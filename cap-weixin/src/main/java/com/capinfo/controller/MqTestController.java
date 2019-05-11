package com.capinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /mq/test/data
 */
@Controller
@RequestMapping(value = "/mq/test")
public class MqTestController {

    List<String> list = new ArrayList<String>();

    public MqTestController(){
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


    /**
     *
     *
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    int i=0;

    @Scheduled(fixedRate = 10000)
    public void sendMsg() {
        //测试数据
        if(i==list.size()){
            i=0;
        }
        jmsTemplate.convertAndSend("my_msg", list.get(i++));
        System.out.println("msg发送成功");
    }

//    @Scheduled(fixedRate = 10000)
//    public void sendMap() {
//        Map map = new HashMap();
//        map.put("mobile", "13888888888");
//        map.put("content", "王总喜提兰博基尼");
//        jmsTemplate.convertAndSend("my_map", map);
//        System.out.println("map发送成功");
//    }





    @GetMapping("/showCar")
    public String showCar(){
        return "order/showCar";
    }

    @GetMapping("data")
    @ResponseBody
    public String data(){
        String temp = "{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":[{\"id\":10000,\"username\":\"user-0\",\"sex\":\"女\",\"city\":\"城市-0\",\"sign\":\"签名-0\",\"experience\":255,\"logins\":24,\"wealth\":82830700,\"classify\":\"作家\",\"score\":57},{\"id\":10001,\"username\":\"user-1\",\"sex\":\"男\",\"city\":\"城市-1\",\"sign\":\"签名-1\",\"experience\":884,\"logins\":58,\"wealth\":64928690,\"classify\":\"词人\",\"score\":27}]}";
        return temp;
    }



}
