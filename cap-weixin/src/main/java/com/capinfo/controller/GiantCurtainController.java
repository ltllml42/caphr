package com.capinfo.controller;

import com.capinfo.base.CurrentUser;
import com.capinfo.config.ActiveMQConfig;
import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.entity.CarCheckFlowMessage;
import com.capinfo.service.JsonUtils;
import com.capinfo.service.SimpleMessageService;
import com.capinfo.shiro.token.WeiXinAuth2Token;
import com.capinfo.util.CommonUtil;
import com.capinfo.util.JsonUtil;
import com.capinfo.utils.WeiXinUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.annotation.JmsListeners;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/gcc/{appid}")
public class GiantCurtainController {
    @Autowired
    private SimpleMessageService simpleMessageService;

    //@JmsListener(destination = ActiveMQConfig.MSG_LARGE_SCREEN_DISPLAY_QUEUE)
    //@Scheduled(fixedRate = 10000)
    @JmsListener(destination = ActiveMQConfig.MSG_LARGE_SCREEN_DISPLAY_QUEUE)
    public void information(String text) {
        simpleMessageService.sendTopicMessage("/topic/gcc",text);
    }

    @JmsListener(destination = ActiveMQConfig.MSG_FLOW_QUEUE)
    public void gccIndex(CarCheckFlowMessage message){
        //CurrentUser user = CommonUtil.getUser();
        if(!StringUtils.isEmpty("acfc0e9232f54732a5d9ffe9071bf572")){//将消息发送到各种流程
            simpleMessageService.sendTopicMessage("/topic/flow/"+"acfc0e9232f54732a5d9ffe9071bf572",JsonUtils.toJson(message));
        }
    }



//    @JmsListener(destination = "my_map")
//    public void dataMessage(String text) {//输出一个格式
//        simpleMessageService.sendTopicMessage("/topic/message",text);
//    }






    /**
     * 巨型幕布展示窗口
     * @param appid
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String show(@PathVariable String appid, Model model) {
        //显示最新的看10条消息

        //

        return "/gcc/index";
    }



}
