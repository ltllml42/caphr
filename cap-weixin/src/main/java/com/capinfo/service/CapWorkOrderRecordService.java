package com.capinfo.service;

import com.capinfo.base.BaseMapper;
import com.capinfo.base.CurrentUser;
import com.capinfo.base.impl.BaseServiceImpl;
import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.entity.CapVehicleSpendtime;
import com.capinfo.entity.CapWorkOrderRecord;
import com.capinfo.entity.CarCheckFlowMessage;
import com.capinfo.mapper.CapWorkOrderRecordMapper;
import com.capinfo.vehicle.utilEntity.NowLinkUtils;
import com.capinfo.vehicle.utilEntity.VehicleConstant;
import com.capinfo.vehicle.utilEntity.VehicleFlowEntity;
import com.capinfo.vehicle.utilEntity.VehicleProcessEnum;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用于处理工单的逻辑功能
 */
@Service
public class CapWorkOrderRecordService extends BaseServiceImpl<CapWorkOrderRecord, String> {

    @Autowired
    private CapWorkOrderRecordMapper capWorkOrderRecordMapper;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private CapVehicleInfoService capVehicleInfoService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private CapVehicleSpendtimeService capVehicleSpendtimeService;


    @Override
    public BaseMapper<CapWorkOrderRecord, String> getMappser() {
        return capWorkOrderRecordMapper;
    }


    public CapWorkOrderRecord saveRecordByVehicleInfo(CapVehicleInfo capVehicleInfo) {
        CapWorkOrderRecord capWorkOrderRecord = new CapWorkOrderRecord();
        capWorkOrderRecord.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        capWorkOrderRecord.setPlateNo(capVehicleInfo.getPlateNo());
        //capWorkOrderRecord.setRecordId(capVehicleInfo.getId());
        capWorkOrderRecord.setVehicleId(capVehicleInfo.getId());
        capWorkOrderRecord.setDelFlag("0");
        capWorkOrderRecord.setCreateBy(capVehicleInfo.getCreateBy());
        capWorkOrderRecord.setCreateDate(new Date());
        capWorkOrderRecord.setUpdateBy(capVehicleInfo.getUpdateBy());
        capWorkOrderRecord.setUpdateDate(new Date());
        capWorkOrderRecord.setNowLink(VehicleConstant.PROCESS_ENTER);
        this.getMappser().insert(capWorkOrderRecord);
        return capWorkOrderRecord;
    }


    public List<CapWorkOrderRecord> selectListByCondition(CapWorkOrderRecord capWorkOrderRecord) {
        return capWorkOrderRecordMapper.selectListByCondition(capWorkOrderRecord);
    }


    public List<CapWorkOrderRecord> selectListJoinVehicleByCondition(CapWorkOrderRecord capWorkOrderRecord) {
        return capWorkOrderRecordMapper.selectListJoinVehicleByCondition(capWorkOrderRecord);
    }




    /**
     * 开启工作流。这里先把工单表的bow_link改成2--外观检测
     * @param capWorkOrderRecord
     */
    public void startFlow(CapWorkOrderRecord capWorkOrderRecord) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        capWorkOrderRecord.setNowLink(VehicleConstant.PROCESS_APPEAR);
        //开启工作流，id记主表的id，capVehicleInfo的id
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(VehicleConstant.FLOW_NAME);
        capWorkOrderRecord.setProcInstId(processInstance.getId());
        capWorkOrderRecord.setStartTime(new Date());
        this.updateByPrimaryKey(capWorkOrderRecord);
    }


    /**
     * 完成当前节点
     * @param capWorkOrderRecord
     * @param flow
     */
    public void completeFlow(CapWorkOrderRecord capWorkOrderRecord, VehicleFlowEntity flow) {
        this.updateByPrimaryKey(capWorkOrderRecord);
        CurrentUser currentUser = (CurrentUser) SecurityUtils.getSubject().getSession().getAttribute("curentUser");
        //String userId = "";
        String userName = "";
        if (currentUser == null || StringUtils.isBlank(currentUser.getId())) {
            //userId = VehicleConstant.USER_WORKER_ID;
            userName = sysUserService.selectByPrimaryKey(VehicleConstant.USER_WORKER_ID).getRealName();
        } else {
            //userId = currentUser.getId();
            userName = currentUser.getRealName();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(new Date());
        Map<String, Object> map = flow.getMap();
        String processId = capWorkOrderRecord.getProcInstId();
        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        //自动签收一下    暂时这样
        /*if (!VehicleConstant.PROCESS_APPEAR.equals(capWorkOrderRecord.getNowLink())) {
            capVehicleInfoService.claim(capWorkOrderRecord.getRecordId());
        }*/
        capVehicleInfoService.claim(capWorkOrderRecord.getId());
        //新能源车辆在到尾气检测这一步的时候判断一下子
        String nowLink = capWorkOrderRecord.getNowLink();
        if (VehicleConstant.PROCESS_GAS.equals(nowLink)) {
            if (VehicleConstant.IS_POWERFREE_NO.equals(capWorkOrderRecord.getIsPowerfree())) {
                taskService.addComment(task.getId(), processId, task.getName()+",花费："+flow.getStepMoney()+"元,检测时间："+nowTime+",检测人员账号："+userName);
                //这里把那张新表里的值也改一下    complete了就没有task了，taskName不好找，complete之前保存一下这张表好了
                saveSpendtime(capWorkOrderRecord.getId(), task.getName(), flow);
            }
        } else {
            taskService.addComment(task.getId(), processId, task.getName()+",花费："+flow.getStepMoney()+"元,检测时间："+nowTime+",检测人员账号："+userName);
            //这里把那张新表里的值也改一下    complete了就没有task了，taskName不好找，complete之前保存一下这张表好了
            saveSpendtime(capWorkOrderRecord.getId(), task.getName(), flow);
        }
        taskService.complete(task.getId(), map);
        capWorkOrderRecord.setNowLink(flow.getNowLink());
        capWorkOrderRecord.setNowStatus(flow.getNowStatus());
        this.updateByPrimaryKey(capWorkOrderRecord);
    }

    /**
     * 结束流程
     * @param capWorkOrderRecord
     * @param status
     */
    public void endFlow(CapWorkOrderRecord capWorkOrderRecord, String status) {
        CurrentUser currentUser = (CurrentUser) SecurityUtils.getSubject().getSession().getAttribute("curentUser");
        String userId = "";
        String userName = "";
        if (currentUser == null || StringUtils.isBlank(currentUser.getId())) {
            userId = VehicleConstant.USER_WORKER_ID;
            userName = sysUserService.selectByPrimaryKey(VehicleConstant.USER_WORKER_ID).getRealName();
        } else {
            userId = currentUser.getId();
            userName = currentUser.getRealName();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(new Date());
        String processId = capWorkOrderRecord.getProcInstId();
        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        if ("pass".equals(status)) {
            taskService.claim(task.getId(), userId);
            taskService.addComment(task.getId(), processId, task.getName()+",缴费结算时间："+nowTime+",结算人员账号："+userName);
            taskService.complete(task.getId());
            capWorkOrderRecord.setNowLink(VehicleConstant.PROCESS_END);
            capWorkOrderRecord.setEndTime(new Date());
            //这里应该也需要记一条spendtime那张表的数据
            capVehicleSpendtimeService.insertSpendtime(capWorkOrderRecord.getId(), VehicleProcessEnum.PROCESS_END.getTypeName(), VehicleConstant.PROCESS_SPENDTIME_END);
        } else {

        }
        this.updateByPrimaryKey(capWorkOrderRecord);
    }


    /**
     * 保存capVehicleSpendtime这张表，提到这个方法里写吧暂时
     * @param id
     * @param taskName
     */
    private void saveSpendtime(String id, String taskName, VehicleFlowEntity flow) {
        CapVehicleSpendtime spendtime = new CapVehicleSpendtime();
        spendtime.setCapWorkRecordId(id);
        spendtime.setTaskName(taskName);
        spendtime.setStatus(VehicleConstant.PROCESS_SPENDTIME_CHECKING);
        CapVehicleSpendtime spend = capVehicleSpendtimeService.selectListByCondition(spendtime).get(0);
        spend.setStatus(VehicleConstant.PROCESS_SPENDTIME_END);
        spend.setEndTime(new Date());
        spend.setSpendMoney(flow.getStepMoney());
        if (VehicleConstant.PROCESS_NOWSTATUS_NO.equals(flow.getNowStatus())) {
            spend.setNowStatus("2");
        } else {
            spend.setNowStatus("1");
        }
        //还得判断一下是不是复检的情况。还是去查这张表就可以了。如果查出来多于1条那么就是复检的情况
        boolean flag = isRepeat(id, taskName);
        if (flag) {
            spend.setIsrepeat(VehicleConstant.PROCESS_ISREPEAT_YES);
        } else {
            spend.setIsrepeat(VehicleConstant.PROCESS_ISREPEAT_NO);
        }
        //算一下耗时
        countDuration(spend);
        capVehicleSpendtimeService.save(spend);
    }




    /**
     * 判断是否是复检的情况   true表示是复检的情况。false表示不是复检
     * @param id
     * @param taskName
     * @return
     */
    private boolean isRepeat(String id, String taskName) {
        boolean flag = false;
        CapVehicleSpendtime spendtime = new CapVehicleSpendtime();
        spendtime.setCapWorkRecordId(id);
        spendtime.setTaskName(taskName);
        List<CapVehicleSpendtime> list = capVehicleSpendtimeService.selectListByCondition(spendtime);
        if (list.size()>1) {
            flag = true;
        }
        return flag;
    }


    /**
     * 算一下耗时。签收了记下一个开始时间。处理完成记下一个结束时间。
     * 记下来集成秒数
     */
    public void countDuration(CapVehicleSpendtime spend) {
        Date starttime = spend.getStartTime();
        Date endtime = spend.getEndTime();
        int second = (int)(endtime.getTime()-starttime.getTime())/1000;
        spend.setDuration(second);
    }



    /**
     * 根据对应的角色，查出来对应的所在流程的数据。放到参数中的list里
     * @param roleId
     * @param recordList
     */
    public void setSelectListByRoleId(String roleId, List<CapWorkOrderRecord> recordList) {
        String nowLink = NowLinkUtils.getNowLinkByRoleId(roleId);
        CapWorkOrderRecord record = new CapWorkOrderRecord();
        record.setNowLink(nowLink);
        List<CapWorkOrderRecord> list = capWorkOrderRecordMapper.selectListByCondition(record);
        for (CapWorkOrderRecord capWorkOrderRecord : list) {
            String id = capWorkOrderRecord.getId();
            boolean flag = true;
            for (CapWorkOrderRecord workOrderRecord : recordList) {
                if (workOrderRecord.getId().equals(id)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                recordList.add(capWorkOrderRecord);
            }
        }
    }

    /**
     * 把机动车的list根据数据判断一下具体值，放到pad页面上用到的对象里
     * @param recordList
     * @return
     */
    public List<CarCheckFlowMessage> putDataToEntity(List<CapWorkOrderRecord> recordList) {
        List<CarCheckFlowMessage> list = new ArrayList<CarCheckFlowMessage>();
        for (CapWorkOrderRecord capWorkOrderRecord : recordList) {
            CarCheckFlowMessage carMsg = new CarCheckFlowMessage();
            carMsg.setBuisId(capWorkOrderRecord.getId());
            carMsg.setProcInstId(capWorkOrderRecord.getProcInstId());
            carMsg.setAction("add");
            carMsg.setNowStatus("未检测");
            carMsg.setFlowStatus(NowLinkUtils.getNowLinkStr(capWorkOrderRecord.getNowLink()));
            carMsg.setPlateNo(capWorkOrderRecord.getPlateNo());
            if (VehicleConstant.PROCESS_NOWSTATUS_NO.equals(capWorkOrderRecord.getNowStatus())) {
                carMsg.setDetectionState("复检");//还需要加字段判断一下
            } else {
                carMsg.setDetectionState("首检");//还需要加字段判断一下
            }
            carMsg.setReCount("1");
            carMsg.setNewIcon("新");
            carMsg.setStatusCss(CarCheckFlowMessage.FONT_CSS_YELLOW);
            carMsg.setFlag("full");
            list.add(carMsg);
        }
        return list;
    }


    /**
     * 根据车辆的类型  中型车还是小型车    算出总共的检测费用
     * @param id
     */
    public void saveTotalMoney(String id) {
        CapWorkOrderRecord capWorkOrderRecord = this.selectByPrimaryKey(id);
        CapVehicleInfo vehicleInfo = new CapVehicleInfo();
        vehicleInfo.setPlateNo(capWorkOrderRecord.getPlateNo());
        CapVehicleInfo info = capVehicleInfoService.selectListByCondition(vehicleInfo).get(0);
        float totalMoney = 0;
        if (VehicleConstant.VEHICLE_PROP_SMALL.equals(info.getVehicleProp())) {
            //小型车检测计费方式。暂时在这块写死
            totalMoney = 100 + 70 + 80 + 80 + 50;
        } else {
            //中型车检测计费方式。
            totalMoney = 150 + 120 + 80 + 50;
        }
        //在这里算一下复检的次数。复检一次总费用加80
        CapVehicleSpendtime spendtime = new CapVehicleSpendtime();
        spendtime.setCapWorkRecordId(id);
        spendtime.setIsrepeat(VehicleConstant.PROCESS_ISREPEAT_YES);
        List<CapVehicleSpendtime> spendtimeList = capVehicleSpendtimeService.selectListByCondition(spendtime);
        for (CapVehicleSpendtime capVehicleSpendtime : spendtimeList) {
            totalMoney = totalMoney + 80;
        }
        capWorkOrderRecord.setTotalMoney(totalMoney);
        this.updateByPrimaryKey(capWorkOrderRecord);
    }






}