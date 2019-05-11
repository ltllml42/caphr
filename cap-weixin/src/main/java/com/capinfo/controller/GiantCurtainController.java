package com.capinfo.controller;

import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.service.SimpleMessageService;
import com.capinfo.shiro.token.WeiXinAuth2Token;
import com.capinfo.utils.WeiXinUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
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

    @JmsListener(destination = "my_msg")
    public void information(String text) {
        simpleMessageService.sendTopicMessage("/topic/callback",text);
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
