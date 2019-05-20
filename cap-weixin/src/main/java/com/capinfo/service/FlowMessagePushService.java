package com.capinfo.service;

import com.capinfo.base.CurrentUser;
import com.capinfo.entity.*;
import com.capinfo.vehicle.utilEntity.NowLinkUtils;
import com.capinfo.vehicle.utilEntity.VehicleConstant;
import com.capinfo.vehicle.utilEntity.VehicleProcessEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.ArrayList;
import java.util.List;

/**
 * JMS流程消息推送
 */
@Service
public class FlowMessagePushService {

    List<String> list = new ArrayList<String>();
    List<CarCheckFlowMessage> cvInfos = new ArrayList<CarCheckFlowMessage>();
    @Autowired
    private Queue displayQueue;
    @Autowired
    private Queue ordinaryQueue;
    @Autowired
    private Queue flowQuere;
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     *
     * @param toUser 发送人
     * @param meesage 发送内容
     */
    public void addflow(List<CurrentUser> toUser,Object meesage){
        if(toUser!=null&&!toUser.isEmpty()){
            for (CurrentUser currentUser : toUser) {
                CarCheckFlowMessage car3 = new CarCheckFlowMessage();
                car3.setBuisId("3");//工单表ID
                car3.setProcInstId("");//流程ID
                car3.setAction("add");//不动
                car3.setNowStatus(VehicleConstant.PROCESS_GAS);
                car3.setPlateNo("京A-NS369");
                car3.setDetectionState("首检");//需要判断
                car3.setReCount("1");//如果为首检则默认为空
                //car3.setToUser(new String[]{""});//将消息发送给那些人
                car3.setNewIcon("新");
                car3.setStatusCss(CarCheckFlowMessage.FONT_CSS_GREEN);
                car3.setFlag("full");
                jmsTemplate.convertAndSend(this.flowQuere,car3);
            }
        }
    }

    /**
     * 添加流程。在外观检测完成后发送队列信息给尾气检测的设备
     * @param userList
     * @param capWorkOrderRecord
     */
    public void addflowByRecord(List<SysUser> userList, CapWorkOrderRecord capWorkOrderRecord, String action) {
        if(userList!=null&&!userList.isEmpty()){
            for (SysUser sysUser : userList) {
                CarCheckFlowMessage carMsg = new CarCheckFlowMessage();
                carMsg.setBuisId(capWorkOrderRecord.getId());
                carMsg.setProcInstId(capWorkOrderRecord.getProcInstId());
                carMsg.setAction(action);//页面上对应的操作标识
                //carMsg.setNowStatus(VehicleConstant.PROCESS_GAS);
                carMsg.setNowStatus("未检测");
                carMsg.setFlowStatus(NowLinkUtils.getNowLinkStr(capWorkOrderRecord.getNowLink()));
                carMsg.setPlateNo(capWorkOrderRecord.getPlateNo());
                if (VehicleConstant.PROCESS_NOWSTATUS_NO.equals(capWorkOrderRecord.getNowStatus())) {
                    carMsg.setDetectionState("复检");//还需要加字段判断一下
                } else {
                    carMsg.setDetectionState("首检");//还需要加字段判断一下
                }
                carMsg.setReCount("1");
                carMsg.setToUser(sysUser.getId());
                carMsg.setNewIcon("新");
                carMsg.setStatusCss(CarCheckFlowMessage.FONT_CSS_YELLOW);
                carMsg.setFlag("full");
                jmsTemplate.convertAndSend(this.flowQuere,carMsg);
            }
        }
    }





    /**
     * 更改流程状态  车牌ID不能变化
     * @param toUser
     * @param car
     */
    public void upflow(List<CurrentUser> toUser,CarCheckFlowMessage car){
        if(toUser!=null&&!toUser.isEmpty()){
            for (CurrentUser currentUser : toUser) {
                car.setProcInstId("");//流程ID
                car.setAction("up");//不动
                car.setNowStatus(VehicleConstant.PROCESS_GAS);
                car.setDetectionState("首检");//需要判断
                car.setReCount("1");//如果为首检则默认为空
                //car.setToUser(new String[]{""});//将消息发送给那些人
                car.setNewIcon("");
                if("不通过".equals(car.getFlowStatus())){
                    car.setFlag("empty");
                    car.setStatusCss(CarCheckFlowMessage.FONT_CSS_RED);
                }else if("通过".equals(car.getFlowStatus())){
                    car.setFlag("empty");
                    car.setStatusCss(CarCheckFlowMessage.FONT_CSS_GREEN);
                }else if("未检".equals(car.getFlowStatus())){
                    car.setFlag("full");
                    car.setStatusCss("");
                }
                jmsTemplate.convertAndSend(this.flowQuere,car);
            }
        }
    }

    public void upflowByRecord(List<SysUser> userList, CapWorkOrderRecord capWorkOrderRecord, String status, String beforeNowLink, String action) {
        if(userList!=null&&!userList.isEmpty()){
            for (SysUser sysUser : userList) {
                CarCheckFlowMessage carMsg = new CarCheckFlowMessage();
                carMsg.setProcInstId(capWorkOrderRecord.getProcInstId());
                carMsg.setAction(action);
                carMsg.setBuisId(capWorkOrderRecord.getId());
                carMsg.setPlateNo(capWorkOrderRecord.getPlateNo());
                //carMsg.setNowStatus(NowLinkUtils.getNowLinkStr(beforeNowLink));
                carMsg.setFlowStatus(NowLinkUtils.getNowLinkStr(beforeNowLink));
                if (VehicleConstant.PROCESS_NOWSTATUS_NO.equals(capWorkOrderRecord.getNowStatus())) {
                    carMsg.setDetectionState("复检");//还需要加字段判断一下
                } else {
                    carMsg.setDetectionState("首检");//还需要加字段判断一下
                }
                carMsg.setReCount("1");
                carMsg.setNewIcon("");
                carMsg.setToUser(sysUser.getId());
                if ("pass".equals(status)) {
                    carMsg.setFlag("empty");
                    carMsg.setNowStatus("通过");
                    carMsg.setStatusCss(CarCheckFlowMessage.FONT_CSS_GREEN);
                } else if ("nopass".equals(status)) {
                    carMsg.setFlag("empty");
                    carMsg.setNowStatus("不通过");
                    carMsg.setStatusCss(CarCheckFlowMessage.FONT_CSS_RED);
                } else if ("nopasslight".equals(status)) {
                    carMsg.setFlag("empty");
                    carMsg.setNowStatus("车灯复检");
                    carMsg.setStatusCss(CarCheckFlowMessage.FONT_CSS_RED);
                }
                jmsTemplate.convertAndSend(this.flowQuere,carMsg);
            }
        }
    }


    /**
     * 发送给微信公众号消息
     */
    public void sendRecordToWx(CapVehicleInfo capVehicleInfo) {
        CarCheckFlowMessage carMsg = new CarCheckFlowMessage();
        carMsg.setBuisId(capVehicleInfo.getCapWorkOrderRecord().getId());
        carMsg.setFlowStatus(capVehicleInfo.getCapWorkOrderRecord().getNowLink());
        carMsg.setPlateNo(capVehicleInfo.getPlateNo());
        carMsg.setOpenId(capVehicleInfo.getOpenid());
        String nowStatus = capVehicleInfo.getCapWorkOrderRecord().getNowStatus();
        if (VehicleConstant.PROCESS_NOWSTATUS_NO.equals(nowStatus)) {
            carMsg.setNowStatus("不通过");
        } else {
            carMsg.setNowStatus("通过");
        }
        jmsTemplate.convertAndSend(this.ordinaryQueue, carMsg);
    }


    public void sendRecordToLargeScreen(CapVehicleInfo capVehicleInfo) {
        CarCheckFlowMessage carMsg = new CarCheckFlowMessage();
        carMsg.setBuisId(capVehicleInfo.getCapWorkOrderRecord().getId());
        carMsg.setFlowStatus(capVehicleInfo.getCapWorkOrderRecord().getNowLink());
        carMsg.setPlateNo(capVehicleInfo.getPlateNo());
        carMsg.setOpenId(capVehicleInfo.getOpenid());
        String nowStatus = capVehicleInfo.getCapWorkOrderRecord().getNowStatus();
        if (VehicleConstant.PROCESS_NOWSTATUS_NO.equals(nowStatus)) {
            carMsg.setNowStatus("不通过");
        } else {
            carMsg.setNowStatus("通过");
        }
        jmsTemplate.convertAndSend(this.displayQueue, carMsg);
    }



}
