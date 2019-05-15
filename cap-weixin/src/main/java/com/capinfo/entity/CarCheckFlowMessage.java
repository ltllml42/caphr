package com.capinfo.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class CarCheckFlowMessage implements Serializable {

    public final static String FONT_CSS_RED = "colorRed";
    public final static String FONT_CSS_GREEN = "colorGreen";
    public final static String FONT_CSS_YELLOW = "colorYellow";//未检测的时候用这个颜色样式暂时

    private String plateNo;//车牌号
    private String flowStatus;//流程状态
    private String nowStatus;//通过，未通过，
    private String detectionState;//首次检测 ，复检
    private String reCount = "";//复检次数
    private String newIcon;//是否为新的队列
    private String procInstId;//流程id
    private String buisId;//业务表Id  后续判断
    private String action;// del 设置为空闲  add 添加检测队列 up 更新状态
    private String toUser;//用户ID
    private String  statusCss;
    private String flag;//  full 占满  empty 清空
    private String openId;//发消息的用户OpenId 保存
    //colorRed
    //colorGreen
}
