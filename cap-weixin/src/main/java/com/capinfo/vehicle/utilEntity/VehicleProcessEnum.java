package com.capinfo.vehicle.utilEntity;

public enum VehicleProcessEnum {

    PROCESS_ENTER("1","进入车检厂","enter"),
    PROCESS_APPEAR("2","外观检测","appear"),
    PROCESS_GAS("3","尾气检测","gas"),
    PROCESS_ONLINE("4","上线检测","online"),
    PROCESS_PAY("5","缴费核算","pay"),
    PROCESS_LIGHT("6","车灯复检","light"),
    PROCESS_END("7","完成","end");


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
