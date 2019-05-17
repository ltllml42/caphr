package com.capinfo.controller;

import com.capinfo.base.BaseEntity;
import com.capinfo.entity.*;
import com.capinfo.service.CapVehicleInfoService;
import com.capinfo.service.CapVehicleSpendtimeService;
import com.capinfo.service.CapWorkOrderRecordService;
import com.capinfo.service.CapWxAccountFansService;
import com.capinfo.shiro.token.WeiXinAuth2Token;
import com.capinfo.utils.WeiXinUtils;
import com.capinfo.vo.BindingCarBean;
import com.google.gson.GsonBuilder;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpKefuService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * http://litaolin.nat300.top/oauth2/wx72c8bfbb4f8fc348/saveOrUpdateCar
 * 验证
 */
@Controller
@RequestMapping(value = "/oauth2/{appid}")
public class WeiXinUserController {
    @Autowired
    private CapWxAccountFansService capWxAccountFansService;
    @Autowired
    private CapVehicleInfoService capVehicleInfoService;
    @Autowired
    private CapWorkOrderRecordService capWorkOrderRecordService;
    @Autowired
    private CapVehicleSpendtimeService capVehicleSpendtimeService;

    //绑定
    private WxMpService wxService;

    @Autowired
    public WeiXinUserController(WxMpService wxService) {
        this.wxService = wxService;
    }

    @GetMapping("bindingUser")
    public String bindingUser(@PathVariable String appid, @RequestParam String code, HttpServletRequest request, HttpServletResponse response) {

        if (!this.wxService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }

        try {
            WxMpOAuth2AccessToken accessToken = wxService.oauth2getAccessToken(code);
            WxMpUser user = wxService.oauth2getUserInfo(accessToken, null);

            //map.put("user", user);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }


        String temps = request.getParameter("");
        String temps2 = request.getParameter("");


        return "";
    }


    @GetMapping("bingingCar")
    public String bindingCar(@PathVariable String appid, Model model) {
        model.addAttribute("appid", appid);
        WeiXinAuth2Token principal = WeiXinUtils.getPrincipal();
        if (principal == null) {
            return "/weixin/fail";
        }
        List<CapVehicleInfo> cvInfoList = principal.getCvInfoList();
        if (CollectionUtils.isEmpty(cvInfoList)) {
            model.addAttribute("fans", principal.getFansInfo());
            model.addAttribute("cvInfo", new CapVehicleInfo());//目前是一个
            return "/weixin/user";
        } else {

            CapVehicleInfo cvInfo = cvInfoList.get(0);
            cvInfo.setYearCheckCount(
                    capWorkOrderRecordService.selectCount(CapWorkOrderRecord.builder().vehicleId(cvInfo.getId()).build()));
            model.addAttribute("cvInfo", cvInfo);//目前是一个
            model.addAttribute("fans", principal.getFansInfo());
            return "/weixin/queryCar";
        }

    }


    /**
     *
     * @param appid
     * @param request
     * @return
     */
    @PostMapping("saveOrUpdateCar")
    @ResponseBody
    public String bindingCar(@PathVariable String appid, @RequestBody BindingCarBean bean, HttpServletRequest request) {
        GsonBuilder builder = new GsonBuilder();
        MessageCode code = new MessageCode();
        String result = null;
        try {
            CapVehicleInfo vehicleInfo = new CapVehicleInfo();
            vehicleInfo.setPlateNo(bean.getPlateNo());
            vehicleInfo.setNjType(bean.getNjType());
            vehicleInfo.setBuyTimeStr(bean.getBuyTimeStr());
            vehicleInfo.setLastTestTimeStr(bean.getLastTestTimeStr());
            WeiXinAuth2Token principal = WeiXinUtils.getPrincipal();
            vehicleInfo.setOpenid(principal.getFansInfo().getOpenId());
            if (principal == null) {
                return code.setfailMessage("权限异常失败","principal为空");
            }
            if (StringUtils.isNotBlank(bean.getFansId())) {
                CapWxAccountFans fansInfo = principal.getFansInfo();
                CapWxAccountFans capWxAccountFans = capWxAccountFansService.selectByPrimaryKey(fansInfo);
                capWxAccountFans.setName(bean.getName());
                capWxAccountFans.setSex(bean.getSex());
                capWxAccountFans.setTelPhone(bean.getTelPhone());
                capWxAccountFansService.updateByPrimaryKey(capWxAccountFans);
                Date lastTestTime = DateUtils.parseDate(vehicleInfo.getLastTestTimeStr(), CapVehicleInfo.FORMAT_DATE);
                Date buyTime = DateUtils.parseDate(vehicleInfo.getBuyTimeStr(), CapVehicleInfo.FORMAT_DATE);
                if (StringUtils.isBlank(vehicleInfo.getId())) {
                    List<CapVehicleInfo> cvcInfoList = capVehicleInfoService.select(CapVehicleInfo.builder().plateNo(vehicleInfo.getPlateNo()).build());

                    switch (validateCar(cvcInfoList,bean)){
                       case "1"://报错提醒 提醒内容为 该车已经被其他人绑定，请先解除绑定后在增加
                           return code.setfailMessage("该车已经被昵称为"+showFansNickName(cvcInfoList)+"人绑定，请先解除绑定后在增加","验证不通过");
                       case "2"://直接update
                           CapVehicleInfo oldVehicleInfo = cvcInfoList.get(0);
                           oldVehicleInfo.setPlateNo(vehicleInfo.getPlateNo());
                           oldVehicleInfo.setNjType(vehicleInfo.getNjType());oldVehicleInfo.setLastTestTime(lastTestTime);
                           oldVehicleInfo.setBuyTime(buyTime);
                           oldVehicleInfo.setFansId(fansInfo.getId());
                           oldVehicleInfo.setOpenid(capWxAccountFans.getOpenId());
                           capVehicleInfoService.updateByPrimaryKeySelective(oldVehicleInfo);
                           refreshPrincipal(principal, oldVehicleInfo);
                           break;
                       case"3"://完全是空需要进行添加操作
                           vehicleInfo.setLastTestTime(lastTestTime);
                           vehicleInfo.setBuyTime(buyTime);
                           vehicleInfo.setFansId(fansInfo.getId());
                           vehicleInfo.setOpenid(capWxAccountFans.getOpenId());
                           capVehicleInfoService.insertSelective(vehicleInfo);
                           refreshPrincipal(principal, vehicleInfo);
                           break;
                   }
                } else {
                    CapVehicleInfo oldVehicleInfo = capVehicleInfoService.selectByPrimaryKey(vehicleInfo);
                    oldVehicleInfo.setPlateNo(vehicleInfo.getPlateNo());
                    oldVehicleInfo.setNjType(vehicleInfo.getNjType());oldVehicleInfo.setLastTestTime(lastTestTime);
                    oldVehicleInfo.setBuyTime(buyTime);
                    capVehicleInfoService.updateByPrimaryKeySelective(oldVehicleInfo);
                    refreshPrincipal(principal, oldVehicleInfo);
                }
            }
            return code.setSuccessMessage("", "获取信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return code.setfailMessage("失败", e.getMessage());
        }


    }

    private void refreshPrincipal(WeiXinAuth2Token principal, CapVehicleInfo oldVehicleInfo) {
        List<CapVehicleInfo> capVehicleInfos = new ArrayList<CapVehicleInfo>();
        capVehicleInfos.add(oldVehicleInfo);
        principal.setCvInfoList(capVehicleInfos);
        WeiXinUtils.setPrincipal(principal);
    }

    private String showFansNickName(List<CapVehicleInfo> cvcInfoList) {
        if(cvcInfoList!=null&&!cvcInfoList.isEmpty()) {
            CapVehicleInfo capVehicleInfo = cvcInfoList.get(0);
            CapWxAccountFans capWxAccountFans = capWxAccountFansService.selectOne(CapWxAccountFans.builder().id(capVehicleInfo.getFansId()).build());
            return capWxAccountFans.getNickName();
        }
        return "";
    }
    private String validateCar(List<CapVehicleInfo> cvcInfoList,BindingCarBean bean) {
        if(cvcInfoList!=null&&!cvcInfoList.isEmpty()){
            CapVehicleInfo capVehicleInfo = cvcInfoList.get(0);
            if(StringUtils.isNotBlank(capVehicleInfo.getFansId())){
                return "1";//报错提醒 提醒内容为 该车已经被其他人绑定，请先解除绑定后在增加
            }else{
                return "2";//直接update
            }
        }
        return "3";//完全是空需要进行添加操作
    }


    @GetMapping("{id}/hisTestMsg")
    public String hisTestMsg(@PathVariable String appid, @PathVariable String id, Model model) {
        CapVehicleInfo cvInfo = capVehicleInfoService.selectOne(CapVehicleInfo.builder().id(id).build());
        List<CapWorkOrderRecord> workList = capWorkOrderRecordService.select(CapWorkOrderRecord.builder().vehicleId(id).build());
        model.addAttribute("cvInfo", cvInfo);
        model.addAttribute("workList", workList);
        return "/weixin/hisTestMsg";
    }

    @GetMapping("/{id}/showHis")
    public String showHis(@PathVariable String appid, @PathVariable String id, Model model) {
        CapWorkOrderRecord cwor = capWorkOrderRecordService.selectOne(CapWorkOrderRecord.builder().id(id).build());
        //历史消息
        List<CapVehicleSpendtime> cvstList =
                capVehicleSpendtimeService.selectBySort(CapVehicleSpendtime.builder().capWorkRecordId(cwor.getId()).build());
        model.addAttribute("cwor", cwor);
        model.addAttribute("cvstList", cvstList);
        return "/weixin/flow";
    }



    @GetMapping("/{id}/del")
    public String del(@PathVariable String appid, @PathVariable String id, Model model) {
        CapVehicleInfo cvInfo = capVehicleInfoService.selectOne(CapVehicleInfo.builder().id(id).build());
        cvInfo.setFansId("");
        capVehicleInfoService.updateByPrimaryKey(cvInfo);
        WeiXinAuth2Token principal = WeiXinUtils.getPrincipal();
        List<CapVehicleInfo> cvInfoList = principal.getCvInfoList();
        Iterator<CapVehicleInfo> iter = cvInfoList.iterator();
        while (iter.hasNext()) {
            CapVehicleInfo next = iter.next();
            if(next.getId().equals(cvInfo.getId())){
                iter.remove();
            }
        }
        principal.setCvInfoList(cvInfoList);
        WeiXinUtils.setPrincipal(principal);
        model.addAttribute("msg","解除绑定成功");
        return "/weixin/success";
    }

    @GetMapping("flow")
    public String flow(@PathVariable String appid) {
        return "/weixin/flow";
    }

    @GetMapping("queryCar")
    public String queryCar(@PathVariable String appid) {
        return "/weixin/queryCar";
    }


    @GetMapping("success")
    public String success(@PathVariable String appid,String msg,Model model) {
        model.addAttribute("msg",msg);
        return "/weixin/success";
    }




}
