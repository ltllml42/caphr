package com.capinfo.controller;

import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.entity.CapWorkOrderRecord;
import com.capinfo.entity.CapWxAccountFans;
import com.capinfo.entity.MessageCode;
import com.capinfo.service.CapVehicleInfoService;
import com.capinfo.service.CapWorkOrderRecordService;
import com.capinfo.service.CapWxAccountFansService;
import com.capinfo.shiro.token.WeiXinAuth2Token;
import com.capinfo.utils.WeiXinUtils;
import com.capinfo.vo.BindingCarBean;
import com.google.gson.GsonBuilder;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
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
     * data.fansId = "${fans.id}";
     * data.carId = "${cvInfo.id}";
     * data.name = name.value;
     * data.sex = $(sex).attr("data-values");
     * data.telphone = telphone.value;
     * data.plateNo = lpnChar.value + "@" + lpnNumber.value;
     * data.njType = $(njType).attr("data-values");
     * data.buyTimeStr = buyTime.value;
     * data.lastTestTimeStr = lastTestTime.value;
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
                return "/weixin/fail";
            }
            if (StringUtils.isNotBlank(bean.getFansId())) {
                CapWxAccountFans fansInfo = principal.getFansInfo();
                CapWxAccountFans capWxAccountFans = capWxAccountFansService.selectByPrimaryKey(fansInfo);
                capWxAccountFans.setName(bean.getName());
                capWxAccountFans.setSex(bean.getSex());
                capWxAccountFans.setTelPhone(bean.getTelphone());
                capWxAccountFansService.updateByPrimaryKey(capWxAccountFans);
                Date lastTestTime = DateUtils.parseDate(vehicleInfo.getLastTestTimeStr(), CapVehicleInfo.FORMAT_DATE);
                Date buyTime = DateUtils.parseDate(vehicleInfo.getBuyTimeStr(), CapVehicleInfo.FORMAT_DATE);
                if (StringUtils.isBlank(vehicleInfo.getId())) {
                    vehicleInfo.setLastTestTime(lastTestTime);
                    vehicleInfo.setBuyTime(buyTime);
                    vehicleInfo.setFansId(fansInfo.getId());
                    capVehicleInfoService.insertSelective(vehicleInfo);
                    List<CapVehicleInfo> capVehicleInfos = new ArrayList<CapVehicleInfo>();
                    capVehicleInfos.add(vehicleInfo);
                    principal.setCvInfoList(capVehicleInfos);
                    WeiXinUtils.setPrincipal(principal);
                } else {
                    CapVehicleInfo oldVehicleInfo = capVehicleInfoService.selectByPrimaryKey(vehicleInfo);
                    oldVehicleInfo.setPlateNo(vehicleInfo.getPlateNo());
                    oldVehicleInfo.setNjType(vehicleInfo.getNjType());
                    oldVehicleInfo.setBuyTime(vehicleInfo.getBuyTime());
                    oldVehicleInfo.setLastTestTime(lastTestTime);
                    oldVehicleInfo.setBuyTime(buyTime);
                    capVehicleInfoService.updateByPrimaryKeySelective(oldVehicleInfo);
                }
            }
            return code.setSuccessMessage("", "获取信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return code.setfailMessage("失败", e.getMessage());
        }


    }


    @GetMapping("/{id}/hisTestMsg")
    public String hisTestMsg(@PathVariable String appid, @PathVariable String id, Model model) {
        CapVehicleInfo cvInfo = capVehicleInfoService.selectOne(CapVehicleInfo.builder().id(id).build());
        List<CapWorkOrderRecord> workList = capWorkOrderRecordService.select(CapWorkOrderRecord.builder().vehicleId(id).build());
        model.addAttribute("cvInfo", cvInfo);
        model.addAttribute("workList",workList);
        return "/weixin/hisTestMsg";
    }
    @GetMapping("/{id}/hisTestMsg")
    public String showHis(@PathVariable String appid, @PathVariable String id, Model model) {
        CapWorkOrderRecord cwor = capWorkOrderRecordService.selectOne(CapWorkOrderRecord.builder().id(id).build());
        //历史消息





        model.addAttribute("cwor",cwor);
        return "/weixin/hisTestMsg";
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
    public String success(@PathVariable String appid) {
        return "/weixin/success";
    }


}
