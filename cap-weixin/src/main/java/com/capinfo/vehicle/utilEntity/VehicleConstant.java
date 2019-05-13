package com.capinfo.vehicle.utilEntity;

public class VehicleConstant {

    /**
     * 车检工作人员   默认id
     */
    public static final String USER_WORKER_ID = "4409457274594b7e8d2a31bca62de199";


    /**
     * 进入停车场
     */
    public static final String PROCESS_ENTER = "1";
    /**
     * 外观检测
     */
    public static final String PROCESS_APPEAR = "2";
    /**
     *  尾气检测
     */
    public static final String PROCESS_GAS = "3";
    /**
     * 上线检测
     */
    public static final String PROCESS_ONLINE = "4";
    /**
     * 缴费核算
     */
    public static final String PROCESS_PAY = "5";
    /**
     * 车灯复检
     */
    public static final String PORCESS_LIGHT = "6";
    /**
     * 缴费完成 结束  车检完成
     */
    public static final String PROCESS_END = "7";




    /**
     * 检测中     在点进页面的时候改成这个状态。表示这个人签收了开始检测了
     */
    public static final String PROCESS_NOWSTATUS_CHECKING = "1";
    /**
     * 不通过
     */
    public static final String PROCESS_NOWSTATUS_NO = "2";

    /**
     * 检测用时表里status用这几个常量表示     1：检测中
     */
    public static final String PROCESS_SPENDTIME_CHECKING = "1";
    /**
     * 2:检测完成
     */
    public static final String PROCESS_SPENDTIME_END = "2";

    /**
     * 是否是复检的情况     0：否
     */
    public static final String PROCESS_ISREPEAT_NO = "0";
    /**
     * 是否是复检的情况     1：是
     */
    public static final String PROCESS_ISREPEAT_YES = "1";


    /**
     * 车检流程 流程名称
     */
    public static final String FLOW_NAME = "car_process";


    /**
     * 尾气检测人员   角色id
     */
    public static final String ROLEID_GAS = "cc84e70413f64a7bb0c1eee083bf21e3";
    /**
     * 上线检测人员   角色id
     */
    public static final String ROLEID_ONLINE = "f4e2d075e449402e9db65d6e1be2d480";
    /**
     * 车灯复检人员   角色id
     */
    public static final String ROLEID_LIGHT = "dcd47a1a1e6448d78de13964ac9c3ecc";



}
