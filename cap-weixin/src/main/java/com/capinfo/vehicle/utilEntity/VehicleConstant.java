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
     * 检测中     在点进页面的时候改成这个状态。表示这个人签收了开始检测了     SPENDTIME表中的字段
     */
    public static final String PROCESS_NOWSTATUS_CHECKING = "1";
    /**
     * 不通过      SPENDTIME表中的字段
     */
    public static final String PROCESS_NOWSTATUS_NO = "2";

    /**
     * 检测用时表里status用这几个常量表示     1：检测中   SPENDTIME表中的status字段
     */
    public static final String PROCESS_SPENDTIME_CHECKING = "1";
    /**
     * 2:检测完成                  PENDTIME表中的status字段
     */
    public static final String PROCESS_SPENDTIME_END = "2";

    /**
     * 是否是复检的情况     0：否     PENDTIME表中的ISREPEAT字段
     */
    public static final String PROCESS_ISREPEAT_NO = "0";
    /**
     * 是否是复检的情况     1：是     PENDTIME表中的ISREPEAT字段
     */
    public static final String PROCESS_ISREPEAT_YES = "1";


    /**
     * 车检流程 流程名称
     */
    public static final String FLOW_NAME = "car_process";


    /**
     * 外观检测人员   角色id
     */
    public static final String ROLEID_APPEAR = "ef2ec0f7546a47e6b4e9fcb4b12350ad";
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
    /**
     * 缴费核算人员   角色id
     */
    public static final String ROLEID_PAY = "b87da330613241278988e345022fb08b";


    /**
     * 是否是新能源车在尾气检测步骤免检     0：不免检   （普通车辆）
     */
    public static final String IS_POWERFREE_NO = "0";
    /**
     * 是否是新能源车在尾气检测步骤免检     1:免检      （新能源车辆）
     */
    public static final String IS_POWERFREE_YES = "1";


    /**
     * 车辆车型 1：小型车
     */
    public static final String VEHICLE_PROP_SMALL = "1";
    /**
     * 车辆车型 2：中型车
     */
    public static final String VEHICLE_PROP_MIDDLE = "2";

    /**
     *  中型车尾气检测人员   用户id    先默认写死这个
     */
    public static final String MID_USERID = "d0dc97f1ab6249819750679c0e51d0c1";


    /**
     * spendtime表排序方式。按创建时间正序排序
     */
    public static final String SPENDTIME_SORTTYPE_CREATEDATEASC = "createDateAsc";




}
