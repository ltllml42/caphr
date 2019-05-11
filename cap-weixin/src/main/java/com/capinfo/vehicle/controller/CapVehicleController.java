package com.capinfo.vehicle.controller;

import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.entity.CapWorkOrderRecord;
import com.capinfo.exception.MyException;
import com.capinfo.service.CapVehicleInfoService;
import com.capinfo.service.CapWorkOrderRecordService;
import com.capinfo.util.JsonUtil;
import com.capinfo.util.ReType;
import com.capinfo.vehicle.utilEntity.VehicleConstant;
import com.capinfo.vehicle.utilEntity.VehicleFlowEntity;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/vehicle")
public class CapVehicleController {

    /*@Autowired
    private DataExecute dataExecute;*/
    @Autowired
    private CapVehicleInfoService capVehicleInfoService;
    @Autowired
    private CapWorkOrderRecordService capWorkOrderRecordService;



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

    @GetMapping(value = "light")
    public String light(Model model) {
        model.addAttribute("pageType", "light");
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
    @RequiresPermissions("car:show")
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
            capWorkOrderRecordService.saveRecordByVehicleInfo(capVehicleInfo);
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
        CapVehicleInfo capVehicleInfo = capVehicleInfoService.selectByPrimaryKey(id);
        String pageType = request.getParameter("pageType");
        model.addAttribute("pageType", pageType);
        model.addAttribute("capVehicleInfo", capVehicleInfo);
        model.addAttribute("detail", detail);
        if ("pay".equals(pageType)) {
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
        CapVehicleInfo capVehicleInfo = capVehicleInfoService.selectByPrimaryKey(id);
        model.addAttribute("capVehicleInfo", capVehicleInfo);
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
            record.setRecordId(id);
            CapWorkOrderRecord capWorkOrderRecord = capWorkOrderRecordService.selectListByCondition(record).get(0);
            //这里还要加工作流的东西。判断之前开始工作流，判断之后走下一步或者这一步不通过去灯光复检那一步
            //在这里先写开始工作流的
            capWorkOrderRecordService.startFlow(capWorkOrderRecord);
            VehicleFlowEntity flow = new VehicleFlowEntity();
            Map<String, Object> map = new HashMap<>();
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
            CapWorkOrderRecord record = new CapWorkOrderRecord();
            record.setRecordId(id);
            CapWorkOrderRecord capWorkOrderRecord = capWorkOrderRecordService.selectListByCondition(record).get(0);
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
            CapWorkOrderRecord record = new CapWorkOrderRecord();
            record.setRecordId(id);
            CapWorkOrderRecord capWorkOrderRecord = capWorkOrderRecordService.selectListByCondition(record).get(0);
            capWorkOrderRecordService.endFlow(capWorkOrderRecord, status);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
        } catch (Exception e) {
            jsonUtil.setMsg("修改失败");
            e.printStackTrace();
        }
        return jsonUtil;
    }




}
