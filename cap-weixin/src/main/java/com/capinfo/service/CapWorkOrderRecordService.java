package com.capinfo.service;

import com.capinfo.base.BaseMapper;
import com.capinfo.base.CurrentUser;
import com.capinfo.base.impl.BaseServiceImpl;
import com.capinfo.entity.CapVehicleInfo;
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
    /*@Autowired
    private CapVehicleInfoService capVehicleInfoService;*/
    @Autowired
    private SysUserService sysUserService;


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
        Map<String, Object> map = flow.getMap();
        String processId = capWorkOrderRecord.getProcInstId();
        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        /*taskService.setVariable(task.getId(), "taskName", task.getName());
        taskService.setVariable(task.getId(), "money", flow.getStepMoney());
        taskService.setVariable(task.getId(), "time", nowTime);*/
        //自动签收一下
        taskService.claim(task.getId(), userId);
        //taskService.addComment(task.getId(), processId, task.getName()+",花费："+flow.getStepMoney()+"元,检测时间："+nowTime+",检测人员账号："+userName+",检测人员id："+userId);
        taskService.addComment(task.getId(), processId, task.getName()+",花费："+flow.getStepMoney()+"元,检测时间："+nowTime+",检测人员账号："+userName);
        taskService.complete(task.getId(), map);

        capWorkOrderRecord.setNowLink(flow.getNowLink());
        capWorkOrderRecord.setNowStatus(flow.getNowStatus());
        addValue(capWorkOrderRecord, false);
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
            //taskService.addComment(task.getId(), processId, task.getName()+",缴费结算时间："+nowTime+",结算人员账号："+userName+",结算人员id："+userId);
            taskService.addComment(task.getId(), processId, task.getName()+",缴费结算时间："+nowTime+",结算人员账号："+userName);
            taskService.complete(task.getId());
            capWorkOrderRecord.setNowLink(VehicleConstant.PROCESS_END);
            capWorkOrderRecord.setEndTime(new Date());
        } else {

        }
        addValue(capWorkOrderRecord, false);
        this.updateByPrimaryKey(capWorkOrderRecord);
    }









}
