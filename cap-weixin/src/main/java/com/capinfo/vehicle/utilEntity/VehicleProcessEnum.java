package com.capinfo.vehicle.utilEntity;

public enum VehicleProcessEnum {

    PROCESS_ENTER("1","入场车检","cd-icon-movie.svg","车牌号为%s的车主,欢迎您进入北京兴通爱民检测场"),
    PROCESS_APPEAR("2","外观检测","cd-icon-pad.svg",""),
    PROCESS_GAS("3","尾气检测","cd-icon-movie.svg","车牌号为%s的车主，您的车辆在%s环节%s,请到出口处取车"),
    PROCESS_ONLINE("4","上线检测","cd-icon-pad.svg","车牌号为%s的车主，您的车辆在%s环节%s,请到出口处取车"),
    PROCESS_PAY("5","缴费核算","cd-icon-pad.svg","车牌号为%s的车主，您的车辆在%s环节%s,请到出口处取车"),
    PROCESS_LIGHT("6","车灯复检","cd-icon-pad.svg","车牌号为%s的车主，您的车辆在%s环节%s,请到出口处取车"),
    PROCESS_END("7","完成","cd-icon-wan.svg","车牌号为%s的车主，您的车辆已经检测完毕，欢迎下次光临");

    private String type;
    private String typeName;
    private String remarks;
    private String noticeTemple;

    VehicleProcessEnum(String type, String typeName, String remarks,String noticeTemple) {
        this.type = type;
        this.typeName = typeName;
        this.remarks = remarks;
        this.noticeTemple = noticeTemple;
    }

    public String getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getNoticeTemple() {
        return noticeTemple;
    }
    public String getRemarks() {
        return remarks;
    }
}
