package com.capinfo.controller;

import com.capinfo.base.CurrentUser;
import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.entity.CapWorkOrderRecord;
import com.capinfo.entity.CarCheckFlowMessage;
import com.capinfo.entity.SysUser;
import com.capinfo.service.SysUserService;
import com.capinfo.util.CommonUtil;
import com.capinfo.utils.WeiXinUtils;
import com.capinfo.vehicle.utilEntity.VehicleConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.FixedRateTask;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /mq/test/data
 */
@Controller
@RequestMapping(value = "/mq/test")
@Slf4j
public class MqTestController {



    List<String> list = new ArrayList<String>();
    List<CarCheckFlowMessage> cvInfos = new ArrayList<CarCheckFlowMessage>();
    @Autowired
    private Queue displayQueue;
    @Autowired
    private Queue ordinaryQueue;
    @Autowired
    private Queue flowQuere;
    @Autowired
    private SysUserService sysUserService;



    public MqTestController(){

        CapWorkOrderRecord cvi1 = new CapWorkOrderRecord();
        cvi1.setPlateNo("京G-FA123");
        cvi1.setNowLink("3");
        //未通过
        //不通过
        //
        cvi1.setNowStatus("");

        CapWorkOrderRecord cvi2 = new CapWorkOrderRecord();
        cvi2.setPlateNo("京A-FF123");
        cvi1.setNowLink("3");


        CapWorkOrderRecord cvi3 = new CapWorkOrderRecord();
        cvi3.setPlateNo("京F-FC123");
        cvi1.setNowLink("3");

        CapWorkOrderRecord cvi4 = new CapWorkOrderRecord();
        cvi4.setPlateNo("京D-AB123");
        cvi1.setNowLink("4");

        CapWorkOrderRecord cvi5 = new CapWorkOrderRecord();
        cvi5.setPlateNo("京C-IA123");
        cvi1.setNowLink("4");

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

        CarCheckFlowMessage car1 = new CarCheckFlowMessage();
        car1.setBuisId("1");
        car1.setAction("add");
        car1.setFlowStatus(VehicleConstant.PROCESS_GAS);
        car1.setPlateNo("京A-FD123");
        car1.setDetectionState("首检");
        //car1.setToUser(new String[]{""});//将消息发送给那些人
        car1.setNewIcon("新");
        car1.setStatusCss(CarCheckFlowMessage.FONT_CSS_GREEN);
        car1.setFlag("full");
        car1.setOpenId("ojeHm1LGVIqyFGkrSd3UMspKn5lg");

        CarCheckFlowMessage car2 = new CarCheckFlowMessage();
        car2.setBuisId("2");
        car2.setAction("add");
        car2.setFlowStatus(VehicleConstant.PROCESS_GAS);
        car2.setPlateNo("京A-SF369");
        car2.setDetectionState("首检");
        //car2.setToUser(new String[]{""});//将消息发送给那些人
        car2.setNewIcon("新");
        car2.setStatusCss(CarCheckFlowMessage.FONT_CSS_GREEN);
        car2.setFlag("full");
        car2.setOpenId("ojeHm1LGVIqyFGkrSd3UMspKn5lg");

        CarCheckFlowMessage car3 = new CarCheckFlowMessage();
        car3.setBuisId("3");
        car3.setAction("add");
        car3.setFlowStatus(VehicleConstant.PROCESS_GAS);
        car3.setPlateNo("京A-NS369");
        car3.setDetectionState("首检");
        //car3.setToUser(new String[]{""});//将消息发送给那些人
        car3.setNewIcon("新");
        car3.setStatusCss(CarCheckFlowMessage.FONT_CSS_GREEN);
        car3.setFlag("full");
        car3.setOpenId("ojeHm1LGVIqyFGkrSd3UMspKn5lg");

        CarCheckFlowMessage car4 = new CarCheckFlowMessage();
        car4.setBuisId("3");
        car4.setAction("add");
        car4.setFlowStatus(VehicleConstant.PROCESS_GAS);
        car4.setPlateNo("京A-NS369");
        car4.setDetectionState("复检");
        //car4.setToUser(new String[]{""});//将消息发送给那些人
        car4.setNewIcon("新");
        car4.setStatusCss(CarCheckFlowMessage.FONT_CSS_GREEN);
        car4.setFlag("full");
        car4.setOpenId("ojeHm1LGVIqyFGkrSd3UMspKn5lg");

        cvInfos.add(car1);
        cvInfos.add(car2);
        cvInfos.add(car3);
        cvInfos.add(car4);
    }


    /**
     *
     *
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    int i=0;
    /*@Scheduled(fixedRate = 10000)
    public void sendOrdinaryQueue() {
        //测试数据
        if(i==list.size()){
            i=0;
        }
        jmsTemplate.convertAndSend(this.ordinaryQueue, cvInfos.get(i));
        i++;
        System.out.println("msg发送成功");
    }*/




//    @Scheduled(fixedRate = 10000)
//    public void sendMsg() {
//        //测试数据
//        if(i==list.size()-1){
//            i=0;
//        }
//        jmsTemplate.convertAndSend(this.displayQueue, list.get(i++));
//
//        log.debug("大屏显示消息为"+list.get(i));
//    }


    /**
     *     @Autowired
     *     private Queue displayQueue;
     *     @Autowired
     *     private Queue ordinaryQueue;
     *     @Autowired
     *     private Queue flowQuere;
     */
    /*@Scheduled(fixedRate = 2000)
    public void sendOrdinaryQueue() {
        //测试数据
        if(i>=list.size()-1){
            i=0;
        }
        jmsTemplate.convertAndSend(this.ordinaryQueue, list.get(i));
        i++;
        System.out.println("msg发送成功");
    }

    static int count = 0 ;
    @Scheduled(fixedRate = 10000)
    public void sendFlowQuere() {
       // CurrentUser user = CommonUtil.getUser();
    //  if(user!=null){


            if(cvInfos.size()-1<count){
                count=0;
            }
            jmsTemplate.convertAndSend(this.flowQuere,cvInfos.get(count));

            log.debug("工作流输出显示:"+cvInfos.get(count));
            count++;
      //  }else{
      //      log.debug("还未重新登录！");
      //  }

    }*/





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


    @Scheduled(fixedRate = 60000)
    public void sendOrdinaryQueue() {
        //测试
        List<String> roleList = new ArrayList<String>();
        roleList.add(VehicleConstant.ROLEID_GAS);
        roleList.add(VehicleConstant.ROLEID_ONLINE);
        roleList.add(VehicleConstant.ROLEID_LIGHT);
        List<SysUser> userList = new ArrayList<SysUser>();
        for (String str : roleList) {
            List<SysUser> userListByRoleId = sysUserService.getUserListByRoleId(str);
            for (SysUser sysUser : userListByRoleId) {
                userList.add(sysUser);
            }
        }
        for (SysUser user : userList) {
            CarCheckFlowMessage carMsg = new CarCheckFlowMessage();
            carMsg.setAction("msg");
            carMsg.setToUser(user.getId());
            jmsTemplate.convertAndSend(this.flowQuere,carMsg);
        }


    }



}
