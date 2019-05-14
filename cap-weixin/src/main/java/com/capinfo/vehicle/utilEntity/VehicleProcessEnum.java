package com.capinfo.vehicle.utilEntity;

public enum VehicleProcessEnum {

    PROCESS_ENTER("1","入场车检","cd-icon-movie.svg"),
    PROCESS_APPEAR("2","外观检测","cd-icon-pad.svg"),
    PROCESS_GAS("3","尾气检测","cd-icon-movie.svg"),
    PROCESS_ONLINE("4","上线检测","cd-icon-pad.svg"),
    PROCESS_PAY("5","缴费核算","cd-icon-pad.svg"),
    PROCESS_LIGHT("6","车灯复检","cd-icon-pad.svg"),
    PROCESS_END("7","车检完成","cd-icon-wan.svg");

    private String type;

    private String typeName;

    private String remarks;

    VehicleProcessEnum(String type, String typeName, String remarks) {
        this.type = type;
        this.typeName = typeName;
        this.remarks = remarks;
    }

    public String getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getRemarks() {
        return remarks;
    }
}
