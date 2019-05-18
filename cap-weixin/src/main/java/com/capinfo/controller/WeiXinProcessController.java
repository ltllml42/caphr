package com.capinfo.controller;

import com.capinfo.config.ActiveMQConfig;
import com.capinfo.entity.CarCheckFlowMessage;
import com.capinfo.service.JsonUtils;
import com.capinfo.service.SimpleMessageService;
import com.capinfo.vehicle.utilEntity.VehicleProcess;
import com.capinfo.vehicle.utilEntity.VehicleProcessEnum;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpKefuService;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Formattable;
import java.util.List;

@RestController
@RequestMapping(value = "/wx/{appid}/process")
@Slf4j
public class WeiXinProcessController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    private WxMpService wxService;


    private WxMpMessageRouter messageRouter;

    @Autowired
    public WeiXinProcessController(WxMpService wxService, WxMpMessageRouter messageRouter) {
        this.wxService = wxService;
        this.messageRouter = messageRouter;
    }


    @Autowired
    private SimpleMessageService simpleMessageService;

    @JmsListener(destination = ActiveMQConfig.MSG_FLOW_QUEUE)
    public void gccIndex(CarCheckFlowMessage message){
        //CurrentUser user = CommonUtil.getUser();

        if(!StringUtils.isEmpty(message.getToUser())){//将消息发送到各种流程
            simpleMessageService.sendTopicMessage("/topic/flow/"+message.getToUser(), JsonUtils.toJson(message));
        }
    }


    @JmsListener(destination = ActiveMQConfig.MSG_WIXIN_MESSAGE_QUEUE)
    public void message(CarCheckFlowMessage message){
        if (!this.wxService.switchover("wx72c8bfbb4f8fc348")) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", "wx72c8bfbb4f8fc348"));
        }
        WxMpKefuService kefuService = wxService.getKefuService();

        String mess = printMessage(message);
        try {
            if(!StringUtils.isEmpty(mess)){
                boolean flag = kefuService.sendKefuMessage(WxMpKefuMessage.TEXT().content(mess).toUser(message.getOpenId()).build());
            }else{
                log.debug("未发送成功："+message);
            }
        } catch (WxErrorException e) {
            log.debug(e.getMessage());
            e.printStackTrace();
        }
    }

    @JmsListener(destination = ActiveMQConfig.MSG_LARGE_SCREEN_DISPLAY_QUEUE)
    public void information(CarCheckFlowMessage message) {
        try {
            Thread.sleep(5000);
            String mess = printMessage(message);
            if(!StringUtils.isEmpty(mess)){
                simpleMessageService.sendTopicMessage("/topic/gcc",mess);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private String printMessage(CarCheckFlowMessage message) {
        List<VehicleProcessEnum> enumList = EnumUtils.getEnumList(VehicleProcessEnum.class);

        //String message = "";
        for (VehicleProcessEnum vpe : enumList) {
            if(vpe.getType().equals(message.getFlowStatus())){
                vpe.getNoticeTemple();
                switch (vpe) {
                    case PROCESS_ENTER:
                        return String.format(vpe.getNoticeTemple(),message.getPlateNo());
                    case PROCESS_APPEAR:
                        return "";
                    case PROCESS_GAS:
                        return String.format(vpe.getNoticeTemple(),message.getPlateNo(),vpe.getTypeName(),message.getNowStatus());
                    case PROCESS_ONLINE:
                        return String.format(vpe.getNoticeTemple(),message.getPlateNo(),vpe.getTypeName(),message.getNowStatus());
                    case PROCESS_PAY:
                        return String.format(vpe.getNoticeTemple(),message.getPlateNo(),vpe.getTypeName(),message.getNowStatus());
                    case PROCESS_LIGHT:
                        return String.format(vpe.getNoticeTemple(),message.getPlateNo(),vpe.getTypeName(),message.getNowStatus());
                    case PROCESS_END:
                        return String.format(vpe.getNoticeTemple(),message.getPlateNo());
                }
            }
        }
        return null;
    }


//    @GetMapping("test")
//    public void information(String text) {
//        if (!this.wxService.switchover("wx72c8bfbb4f8fc348")) {
//            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", "wx72c8bfbb4f8fc348"));
//        }
//        WxMpKefuService kefuService = wxService.getKefuService();
//        try {
//            boolean flag = kefuService.sendKefuMessage(WxMpKefuMessage.TEXT().content("测试通过").toUser("ojeHm1LGVIqyFGkrSd3UMspKn5lg").build());
//            System.out.println(flag);
//        } catch (WxErrorException e) {
//            log.debug(e.getMessage());
//            e.printStackTrace();
//        }
//
//    }




}
