package com.capinfo.service;

import com.capinfo.base.CurrentUser;
import com.capinfo.entity.CapWorkOrderRecord;
import com.capinfo.entity.CarCheckFlowMessage;
import com.capinfo.vehicle.utilEntity.VehicleConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
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
        if(toUser!=null&&toUser.isEmpty()){
            for (CurrentUser currentUser : toUser) {
                CarCheckFlowMessage car3 = new CarCheckFlowMessage();
                car3.setBuisId("3");//工单表ID
                car3.setProcInstId("");//流程ID
                car3.setAction("add");//不动
                car3.setNowStatus(VehicleConstant.PROCESS_GAS);
                car3.setPlateNo("京A-NS369");
                car3.setDetectionState("首检");//需要判断
                car3.setReCount("1");//如果为首检则默认为空
                car3.setToUser(new String[]{""});//将消息发送给那些人
                car3.setNewIcon("新");
                car3.setStatusCss(CarCheckFlowMessage.FONT_CSS_GREEN);
                car3.setFlag("full");
                jmsTemplate.convertAndSend(this.flowQuere,car3);
            }
        }
    };

    /**
     * 更改流程状态  车牌ID不能变化
     * @param toUser
     * @param car
     */
    public void upflow(List<CurrentUser> toUser,CarCheckFlowMessage car){
        if(toUser!=null&&toUser.isEmpty()){
            for (CurrentUser currentUser : toUser) {
                car.setProcInstId("");//流程ID
                car.setAction("up");//不动
                car.setNowStatus(VehicleConstant.PROCESS_GAS);
                car.setDetectionState("首检");//需要判断
                car.setReCount("1");//如果为首检则默认为空
                car.setToUser(new String[]{""});//将消息发送给那些人
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
    };
}
