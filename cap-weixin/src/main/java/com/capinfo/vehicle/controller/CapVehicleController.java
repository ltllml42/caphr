package com.capinfo.vehicle.controller;

import com.capinfo.base.CurrentUser;
import com.capinfo.entity.*;
import com.capinfo.exception.MyException;
import com.capinfo.service.*;
import com.capinfo.util.JsonUtil;
import com.capinfo.util.ReType;
import com.capinfo.vehicle.utilEntity.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping(value = "/vehicle")
public class CapVehicleController {

    /*@Autowired
    private DataExecute dataExecute;*/
    @Autowired
    private CapVehicleInfoService capVehicleInfoService;
    @Autowired
    private CapWorkOrderRecordService capWorkOrderRecordService;
    @Autowired
    private FlowMessagePushService flowMessagePushService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private CapVehicleSpendtimeService capVehicleSpendtimeService;
    @Autowired
    private RoleService roleService;



    /**
     * 进入车检厂    应该是摄像头传接口数据开始。先用页面模拟
     * @param model
     * @return
     */
    @GetMapping(value = "enter")
    public String enter(Model model) {
        model.addAttribute("pageType", "enter");
        return "vehicle/vehicleList";
    }

    /**
     * 外观检测     --开始流程  把工作流从这里往下进行两步
     * @param model
     * @return
     */
    @GetMapping(value = "appear")
    public String appear(Model model) {
        model.addAttribute("pageType", "appear");
        return "vehicle/vehicleList";
    }

    /**
     * 尾气检测
     * @param model
     * @return
     */
    @GetMapping(value = "gas")
    public String gas(Model model) {
        model.addAttribute("pageType", "gas");
        return "vehicle/vehicleList";
    }

    /**
     * 上线检测
     * @param model
     * @return
     */
    @GetMapping(value = "online")
    public String online(Model model) {
        model.addAttribute("pageType", "online");
        return "vehicle/vehicleList";
    }

    /**
     * 缴费核算
     * @param model
     * @return
     */
    @GetMapping(value = "pay")
    public String pay(Model model) {
        model.addAttribute("pageType", "pay");
        return "vehicle/vehicleList";
    }

    /**
     * 灯光复检
     * @param model
     * @return
     */
    @GetMapping(value = "light")
    public String light(Model model) {
        model.addAttribute("pageType", "light");
        return "vehicle/vehicleList";
    }

    /**
     * 所有结束流程的
     * @param model
     * @return
     */
    @GetMapping(value = "end")
    public String endList(Model model) {
        model.addAttribute("pageType", "end");
        return "vehicle/vehicleList";
    }



    /**
     * 车检车辆list的接口
     * @param capVehicleInfo
     * @param model
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation(value = "/showVehicleList", httpMethod = "GET", notes = "意见列表")
    @GetMapping(value = "showVehicleList")
    @ResponseBody
    public ReType showAdviceList(CapVehicleInfo capVehicleInfo, HttpServletRequest request, Model model, String page, String limit) {
        String pageType = request.getParameter("pageType");
        CapWorkOrderRecord record = new CapWorkOrderRecord();
        switch (pageType) {
            case "enter":
                record.setNowLink(VehicleConstant.PROCESS_ENTER);
                capVehicleInfo.setCapWorkOrderRecord(record);
                break;
            case "appear":
                record.setNowLink(VehicleConstant.PROCESS_APPEAR);
                capVehicleInfo.setCapWorkOrderRecord(record);
                break;
            case "gas":
                record.setNowLink(VehicleConstant.PROCESS_GAS);
                capVehicleInfo.setCapWorkOrderRecord(record);
                break;
            case "online":
                record.setNowLink(VehicleConstant.PROCESS_ONLINE);
                capVehicleInfo.setCapWorkOrderRecord(record);
                break;
            case "pay":
                record.setNowLink(VehicleConstant.PROCESS_PAY);
                capVehicleInfo.setCapWorkOrderRecord(record);
                break;
            case "end":
                record.setNowLink(VehicleConstant.PROCESS_END);
                capVehicleInfo.setCapWorkOrderRecord(record);
                break;
            case "light":
                record.setNowLink(VehicleConstant.PORCESS_LIGHT);
                capVehicleInfo.setCapWorkOrderRecord(record);
                break;
        }
        return capVehicleInfoService.showJoinOrderRecord(capVehicleInfo, Integer.valueOf(page), Integer.valueOf(limit));
    }


    /**
     * 添加车牌信息
     * @param model
     * @return
     */
    @GetMapping(value = "showAddVehicle")
    public String showAddVehicle(Model model) {
        return "vehicle/add-vehicle";
    }


    @ApiOperation(value = "/addVehicle", httpMethod = "POST", notes = "添加车辆")
    @PostMapping(value = "addVehicle")
    @ResponseBody
    public JsonUtil addAdvice(CapVehicleInfo capVehicleInfo) {
        if (StringUtils.isEmpty(capVehicleInfo.getPlateNo())) {
            JsonUtil.error("车牌号不能为空");
        }
        JsonUtil j = new JsonUtil();
        try {
            capVehicleInfo = capVehicleInfoService.save(capVehicleInfo);
            //在这要再加一条record表的数据
            CapWorkOrderRecord capWorkOrderRecord = capWorkOrderRecordService.saveRecordByVehicleInfo(capVehicleInfo);
            //加一条spendtime这张表的数据
            capVehicleSpendtimeService.insertSpendtime(capWorkOrderRecord.getId(), VehicleProcessEnum.PROCESS_ENTER.getTypeName(), VehicleConstant.PROCESS_SPENDTIME_END);
            j.setMsg("保存成功");
        } catch (MyException e) {
            j.setMsg("保存失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }


    /**
     * 选择检测是否通过的页面
     * @param id
     * @param model
     * @param detail
     * @return
     */
    @GetMapping(value = "showComplete")
    public String showComplete(String id, HttpServletRequest request, Model model, boolean detail) {
        //CapVehicleInfo capVehicleInfo = capVehicleInfoService.selectByPrimaryKey(id);
        CapWorkOrderRecord capWorkOrderRecord = capWorkOrderRecordService.selectByPrimaryKey(id);
        //用工单表查。这个车的数据只有一条
        String pageType = request.getParameter("pageType");
        model.addAttribute("pageType", pageType);
        model.addAttribute("capWorkOrderRecord", capWorkOrderRecord);
        model.addAttribute("detail", detail);
        //在这里要做签收动作。工作流里签收一下，也把这个开始时间记到一张表里
        //不是进入并且不是外观检测的时候签收一下
        //暂时变成点通过不通过的时候自动签收
        /*if (!"appear".equals(pageType) && !"enter".equals(pageType) && !"pay".equals(pageType)) {
            capVehicleInfoService.claim(id);
        }*/
        if ("pay".equals(pageType) || "end".equals(pageType)) {
            return "vehicle/pay-vehicle";
        } else {
            return "vehicle/complete-vehicle";
        }
    }

    /**
     * 上线检测不通过的确认页面     这个页面要加入 是否只复检灯光 的选项
     * @param id
     * @param request
     * @param model
     * @return
     */
    @GetMapping(value = "nopassOnline")
    public String nopassOnline(String id, HttpServletRequest request, Model model) {
        //CapVehicleInfo capVehicleInfo = capVehicleInfoService.selectByPrimaryKey(id);
        CapWorkOrderRecord capWorkOrderRecord = capWorkOrderRecordService.selectByPrimaryKey(id);
        model.addAttribute("capWorkOrderRecord", capWorkOrderRecord);
        return "vehicle/nopass-online";
    }




    /**
     * 外观检测的时候调这个
     * @param
     * @return
     */
    @ApiOperation(value = "/completeVehicleAppear", httpMethod = "POST", notes = "完成检测")
    @PostMapping(value = "completeVehicleAppear")
    @ResponseBody
    public JsonUtil completeVehicleAppear(String id, HttpServletRequest request) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        String status = request.getParameter("status");
        if (StringUtils.isBlank(id)) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            //selectByPrimaryKey
            //找到这条数据的子表数据，把nowlink改掉
            CapWorkOrderRecord record = new CapWorkOrderRecord();
            //record.setRecordId(id);
            record.setVehicleId(id);
            CapWorkOrderRecord capWorkOrderRecord = capWorkOrderRecordService.selectListByCondition(record).get(0);
            //这里还要加工作流的东西。判断之前开始工作流，判断之后走下一步或者这一步不通过去灯光复检那一步
            //在这里先写开始工作流的
            capWorkOrderRecordService.startFlow(capWorkOrderRecord);
            VehicleFlowEntity flow = new VehicleFlowEntity();
            Map<String, Object> map = new HashMap<String, Object>();
            if ("pass".equals(status)) {
                //可能需要判断车牌种类。暂时先这么写，下一步到尾气检测
                flow.setNowLink(VehicleConstant.PROCESS_GAS);
                map.put("pass", "1");
            } else if ("nopass".equals(status)) {
                flow.setNowLink(VehicleConstant.PROCESS_APPEAR);
                flow.setNowStatus(VehicleConstant.PROCESS_NOWSTATUS_NO);
                map.put("pass", "2");
            }
            flow.setMap(map);
            flow.setStepMoney(20);
            capWorkOrderRecordService.completeFlow(capWorkOrderRecord, flow);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
        } catch (Exception e) {
            jsonUtil.setMsg("修改失败");
            e.printStackTrace();
        }
        return jsonUtil;
    }



    /**
     * 其他时候暂时调这个。有情况再说
     * @param
     * @return
     */
    @ApiOperation(value = "/completeVehicle", httpMethod = "POST", notes = "完成检测")
    @PostMapping(value = "completeVehicle")
    @ResponseBody
    public JsonUtil completeVehicle(String id, HttpServletRequest request) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        String status = request.getParameter("status");
        if (StringUtils.isBlank(id)) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            CapWorkOrderRecord capWorkOrderRecord = capWorkOrderRecordService.selectByPrimaryKey(id);
            if (VehicleConstant.PROCESS_ONLINE.equals(capWorkOrderRecord.getNowLink())) {
                String onlylight = request.getParameter("onlylight");
                if ("yes".equals(onlylight)) {
                    status = "nopasslight";
                }
            }
            VehicleFlowEntity flow = capVehicleInfoService.getMatchMap(status, capWorkOrderRecord);
            capWorkOrderRecordService.completeFlow(capWorkOrderRecord, flow);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
        } catch (Exception e) {
            jsonUtil.setMsg("修改失败");
            e.printStackTrace();
        }
        return jsonUtil;
    }

    /**
     * 其他时候暂时调这个。有情况再说
     * @param
     * @return
     */
    @ApiOperation(value = "/completeVehicleMobile", httpMethod = "POST", notes = "完成检测")
    @PostMapping(value = "completeVehicleMobile")
    @ResponseBody
    public JsonUtil completeVehicleMobile(@RequestBody ResultBean bean, HttpServletRequest request) {
        CurrentUser currentUser = (CurrentUser) SecurityUtils.getSubject().getSession().getAttribute("curentUser");
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        String status = bean.getStatus();
        if (StringUtils.isBlank(bean.getId())) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            CapWorkOrderRecord capWorkOrderRecord = capWorkOrderRecordService.selectByPrimaryKey(bean.getId());
            String beforeNowLink = capWorkOrderRecord.getNowLink();
            //可能需要判断一下当前用户有没有处理这一步对应的角色权限。如果没有直接返回
            //因为处理结束之后会推送消息到页面上把对应数据改为  通过/不通过  这种时候当前用户可能不是数据对应步骤的操作人
            // 前台做了限制了后台也做一下判断
            String roleId = NowLinkUtils.getRoleIdByNowLink(beforeNowLink);
            List<SysUser> userList = sysUserService.getUserListByRoleId(roleId);
            boolean flag = getFlagByCurrentRole(userList, currentUser.getId());
            if (!flag) {
                jsonUtil.setMsg("修改失败");
                return jsonUtil;
            }
            if (VehicleConstant.PROCESS_GAS.equals(beforeNowLink)) {
                capWorkOrderRecord.setIsPowerfree(bean.getFree());
                //在这里判断一下用户。如果是检测中型车的用户，那么把字段加上值。如果不是中型车的用户，填成小型车
                capVehicleInfoService.saveVehiclePropValue(capWorkOrderRecord.getPlateNo());
            }
            VehicleFlowEntity flow = capVehicleInfoService.getMatchMap(status, capWorkOrderRecord);
            capWorkOrderRecordService.completeFlow(capWorkOrderRecord, flow);
            //在这加推送消息队列的东西应该
            //尾气检测结束，上线检测结束不通过的时候
            if (VehicleConstant.PROCESS_GAS.equals(beforeNowLink) || VehicleConstant.PROCESS_ONLINE.equals(beforeNowLink) || VehicleConstant.PORCESS_LIGHT.equals(beforeNowLink)) {
                //自己也要把页面上数据的状态改一下。暂时不去remove当前用户了
                flowMessagePushService.upflowByRecord(userList, capWorkOrderRecord, status, beforeNowLink, "up");
                //给下一步的发消息  如果下一步是在尾气检测、上线检测、灯光复检的时候
                if (VehicleConstant.PROCESS_GAS.equals(capWorkOrderRecord.getNowLink()) || VehicleConstant.PROCESS_ONLINE.equals(capWorkOrderRecord.getNowLink()) || VehicleConstant.PORCESS_LIGHT.equals(capWorkOrderRecord.getNowLink())) {
                    //给下一步的用户发消息的时候要排除当前用户。这一步不通过的时候下一步可能还是这一步，会冲掉
                    String nextRoleId = NowLinkUtils.getRoleIdByNowLink(capWorkOrderRecord.getNowLink());
                    List<SysUser> nextUserList = sysUserService.getUserListByRoleId(nextRoleId);
                    SysUser current = sysUserService.selectByPrimaryKey(currentUser.getId());
                    Iterator<SysUser> iterator = nextUserList.iterator();
                    while (iterator.hasNext()) {
                        SysUser user = iterator.next();
                        if (user.getId().equals(current.getId())) {
                            iterator.remove();
                        }
                    }
                    flowMessagePushService.addflowByRecord(nextUserList, capWorkOrderRecord, "add");
                }
                //不通过的时候，给微信公众号推送一条消息
                if (VehicleConstant.PROCESS_NOWSTATUS_NO.equals(capWorkOrderRecord.getNowStatus())) {
                    String recordId = capWorkOrderRecord.getVehicleId();
                    CapVehicleInfo vehicleInfo = capVehicleInfoService.selectByPrimaryKey(recordId);
                    vehicleInfo.setCapWorkOrderRecord(capWorkOrderRecord);
                    capVehicleInfoService.sendMsg(vehicleInfo);
                }
            }
            //在最后写不合前面的混了就  如果下一步到缴费核算的情况下，把整体的费用算一下
            if (VehicleConstant.PROCESS_PAY.equals(capWorkOrderRecord.getNowLink())) {
                capWorkOrderRecordService.saveTotalMoney(capWorkOrderRecord.getId());
                //这个时候是通过的情况下。这个时候也往公众号和大屏推送一条消息
                String recordId = capWorkOrderRecord.getVehicleId();
                CapVehicleInfo vehicleInfo = capVehicleInfoService.selectByPrimaryKey(recordId);
                capWorkOrderRecord.setNowLink(beforeNowLink);
                vehicleInfo.setCapWorkOrderRecord(capWorkOrderRecord);
                capVehicleInfoService.sendMsg(vehicleInfo);
            }
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
        } catch (Exception e) {
            jsonUtil.setMsg("修改失败");
            e.printStackTrace();
        }
        return jsonUtil;
    }


    /**
     * pad端刷新加载数据时候用这个玩意。消息推送后刷新或者退出再回来页面需要用这个刷新
     * @param request
     * @return
     */
    @ApiOperation(value = "/loadData", httpMethod = "POST", notes = "加载数据")
    @PostMapping(value = "loadData")
    @ResponseBody
    public ResultData loadData(HttpServletRequest request) {
        CurrentUser currentUser = (CurrentUser) SecurityUtils.getSubject().getSession().getAttribute("curentUser");
        ResultData result = new ResultData();
        result.setFlag(false);
        try {
            List<SysRole> roleList = roleService.getRoleListByUser(currentUser.getId());
            List<CapWorkOrderRecord> list = new ArrayList<CapWorkOrderRecord>();
            for (SysRole sysRole : roleList) {
                capWorkOrderRecordService.setSelectListByRoleId(sysRole.getId(), list);
            }
            List<CarCheckFlowMessage> carMsgList = capWorkOrderRecordService.putDataToEntity(list);
            result.setFlag(true);
            result.setMsg("加载成功");
            result.setData(carMsgList);
        } catch (Exception e) {
            result.setMsg("加载失败");
            e.printStackTrace();
        }
        return result;
    }





    /**
     * 缴费核算的时候
     * @param
     * @return
     */
    @ApiOperation(value = "/endVehicle", httpMethod = "POST", notes = "完成检测")
    @PostMapping(value = "endVehicle")
    @ResponseBody
    public JsonUtil endVehicle(String id, HttpServletRequest request) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        String status = request.getParameter("status");
        if (StringUtils.isBlank(id)) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            CapWorkOrderRecord capWorkOrderRecord = capWorkOrderRecordService.selectByPrimaryKey(id);
            capWorkOrderRecordService.endFlow(capWorkOrderRecord, status);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
        } catch (Exception e) {
            jsonUtil.setMsg("修改失败");
            e.printStackTrace();
        }
        return jsonUtil;
    }


    /**
     * 根据当前用户的角色是否是当前车检步骤判断一下时候允许执行操作
     * @return
     */
    private boolean getFlagByCurrentRole(List<SysUser> userList, String currentUserId) {
        boolean flag = false;
        for (SysUser sysUser : userList) {
            if (sysUser.getId().equals(currentUserId)) {
                flag = true;
                break;
            }
        }
        return flag;
    }



    @ApiOperation(value = "/showSpendtimeList", httpMethod = "GET", notes = "车检情况列表")
    @GetMapping(value = "showSpendtimeList")
    @ResponseBody
    public ReType showSpendtimeListByRecord(HttpServletRequest request, Model model, String page, String limit) {
        String recordId = request.getParameter("recordId");
        CapVehicleSpendtime spendtime = new CapVehicleSpendtime();
        spendtime.setCapWorkRecordId(recordId);
        spendtime.setSortType(VehicleConstant.SPENDTIME_SORTTYPE_CREATEDATEASC);
        List<CapVehicleSpendtime> list = capVehicleSpendtimeService.selectListByCondition(spendtime);
        Page<CapVehicleSpendtime> tPage = PageHelper.startPage(1, 100);
        return new ReType(tPage.getTotal(), list);
    }



}
