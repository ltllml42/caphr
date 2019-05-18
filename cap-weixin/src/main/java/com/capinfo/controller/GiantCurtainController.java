package com.capinfo.controller;

import com.capinfo.config.ActiveMQConfig;
import com.capinfo.service.SimpleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/gcc/{appid}")
public class GiantCurtainController {
    @Autowired
    private SimpleMessageService simpleMessageService;

    //@JmsListener(destination = ActiveMQConfig.MSG_LARGE_SCREEN_DISPLAY_QUEUE)
    //@Scheduled(fixedRate = 10000)
//    @JmsListener(destination = ActiveMQConfig.MSG_LARGE_SCREEN_DISPLAY_QUEUE)
//    public void information(String text) {
//        try {
//            Thread.sleep(5000);
//            simpleMessageService.sendTopicMessage("/topic/gcc",text);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }





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
