package com.capinfo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;


@Configuration
@EnableJms
public class ActiveMQConfig {
    //大屏展示消息队列
    public final static String MSG_LARGE_SCREEN_DISPLAY_QUEUE = "MSG_LARGE_SCREEN_DISPLAY_QUEUE";
    public final static String MSG_WIXIN_MESSAGE_QUEUE = "MSG_WIXIN_MESSAGE_QUEUE";
    public final static String MSG_FLOW_QUEUE = "MSG_FLOW_QUEUE";

    /**
     * 大屏展示
     * @return
     */
    @Bean(name = "displayQueue")
    public Queue queueMq1() {
        return new ActiveMQQueue(MSG_LARGE_SCREEN_DISPLAY_QUEUE) ;
    }

    /**
     * 普通消息通知
     * @return
     */
    @Bean(name = "ordinaryQueue")
    public Queue queueMq2() {
        return new ActiveMQQueue(MSG_WIXIN_MESSAGE_QUEUE) ;
    }

    /**
     * 流程消息通知
     * @return
     */
    @Bean(name = "flowQuere")
    public Queue queueMq3() {
        return new ActiveMQQueue(MSG_FLOW_QUEUE) ;
    }



}
