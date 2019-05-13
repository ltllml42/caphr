package com.capinfo.service;

import com.capinfo.base.BaseMapper;
import com.capinfo.base.CurrentUser;
import com.capinfo.base.impl.BaseServiceImpl;
import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.entity.CapVehicleSpendtime;
import com.capinfo.entity.CapWorkOrderRecord;
import com.capinfo.mapper.CapWorkOrderRecordMapper;
import com.capinfo.vehicle.utilEntity.VehicleConstant;
import com.capinfo.vehicle.utilEntity.VehicleFlowEntity;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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


    public void saveRecordByVehicleInfo(CapVehicleInfo capVehicleInfo) {
        CapWorkOrderRecord capWorkOrderRecord = new CapWorkOrderRecord();
        capWorkOrderRecord.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        capWorkOrderRecord.setPlateNo(capVehicleInfo.getPlateNo());
        capWorkOrderRecord.setRecordId(capVehicleInfo.getId());
        capWorkOrderRecord.setDelFlag("0");
        capWorkOrderRecord.setCreateBy(capVehicleInfo.getCreateBy());
        capWorkOrderRecord.setCreateDate(new Date());
        capWorkOrderRecord.setUpdateBy(capVehicleInfo.getUpdateBy());
        capWorkOrderRecord.setUpdateDate(new Date());
        capWorkOrderRecord.setNowLink(VehicleConstant.PROCESS_ENTER);
        this.insertSelective(capWorkOrderRecord);
    }


    public List<CapWorkOrderRecord> selectListByCondition(CapWorkOrderRecord capWorkOrderRecord) {
        return capWorkOrderRecordMapper.selectListByCondition(capWorkOrderRecord);
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
        addValue(capWorkOrderRecord, false);
        this.updateByPrimaryKey(capWorkOrderRecord);
    }


    /**
     * 完成当前节点
     * @param capWorkOrderRecord
     * @param flow
     */
    public void completeFlow(CapWorkOrderRecord capWorkOrderRecord, VehicleFlowEntity flow) {
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
        if (VehicleConstant.PROCESS_APPEAR.equals(capWorkOrderRecord.getNowLink())) {
            capVehicleInfoService.claim(capWorkOrderRecord.getRecordId());
        }
        taskService.addComment(task.getId(), processId, task.getName()+",花费："+flow.getStepMoney()+"元,检测时间："+nowTime+",检测人员账号："+userName);
        //这里把那张新表里的值也改一下    complete了就没有task了，taskName不好找，complete之前保存一下这张表好了
        saveSpendtime(capWorkOrderRecord.getRecordId(), task.getName(), flow);
        taskService.complete(task.getId(), map);
        capWorkOrderRecord.setNowLink(flow.getNowLink());
        capWorkOrderRecord.setNowStatus(flow.getNowStatus());
        addValue(capWorkOrderRecord, false);
        this.updateByPrimaryKey(capWorkOrderRecord);

        //在这加推送消息队列的东西应该
        //尾气检测结束，上线检测结束不通过的时候


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
        } else {

        }
        addValue(capWorkOrderRecord, false);
        this.updateByPrimaryKey(capWorkOrderRecord);
    }


    /**
     * 保存capVehicleSpendtime这张表，提到这个方法里写吧暂时
     * @param id
     * @param taskName
     */
    private void saveSpendtime(String id, String taskName, VehicleFlowEntity flow) {
        CapVehicleSpendtime spendtime = new CapVehicleSpendtime();
        spendtime.setCapVehicleId(id);
        spendtime.setTaskName(taskName);
        spendtime.setStatus(VehicleConstant.PROCESS_SPENDTIME_CHECKING);
        CapVehicleSpendtime spend = capVehicleSpendtimeService.selectListByCondition(spendtime).get(0);
        spend.setStatus(VehicleConstant.PROCESS_SPENDTIME_END);
        spend.setEndTime(new Date());
        spend.setSpendMoney(flow.getStepMoney());
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
        spendtime.setCapVehicleId(id);
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


}