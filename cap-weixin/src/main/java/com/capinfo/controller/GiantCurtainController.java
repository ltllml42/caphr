package com.capinfo.controller;

import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.service.SimpleMessageService;
import com.capinfo.shiro.token.WeiXinAuth2Token;
import com.capinfo.utils.WeiXinUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    List<String> list = new ArrayList<String>();

    public GiantCurtainController(){
        list.add("京G-B1387 入场进行年检");
        list.add("京A-FB123 入场进行年检");
        list.add("京F-GC123 入场进行年检");
        list.add("京G-B1387 入场进行年检");
        list.add("京A-FB123 外观检测通过");
        list.add("京F-GC123 外观检测通过");
        list.add("京G-B1387 外观检测通过");
        list.add("京A-FB123 尾气检测通过");
        list.add("京F-GC123 尾气检测通过");
        list.add("京G-B1387 上线检测通过");
        list.add("京A-FB123上线检测通过");
        list.add("京F-GC123 上线检测通过");
        list.add("京G-B1387 进入停车场");
        list.add("京A-FB123 进入停车场");
        list.add("京F-GC123 进入停车场");
        list.add("京F-GC123 车检完成");
        list.add("京F-GC123 车检完成");

    }

    int i = -1;
    @Scheduled(fixedRate = 10000)
    public void information() {
        //测试数据
        if(i>list.size()){
            i=-1;
        }
        i++;
        simpleMessageService.sendTopicMessage("/topic/callback",list.get(i));
    }



    @Scheduled(fixedRate = 10000)
    public void dataMessage() {//输出一个格式
        simpleMessageService.sendTopicMessage("/topic/message",list.get(i));
    }






    /**
     * 巨型幕布展示窗口
     * @param appid
     * @param model
     * @return
     */
    @GetMapping("index")
    public String show(@PathVariable String appid, Model model) {
        //显示最新的看10条消息

        //

        return "/gcc/index";
    }



}
