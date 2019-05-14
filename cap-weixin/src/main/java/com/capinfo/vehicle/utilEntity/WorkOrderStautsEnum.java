package com.capinfo.vehicle.utilEntity;

public enum WorkOrderStautsEnum {

    STAUTS_OK("1","通过",""),
    STATUS_NO("2","不通过",""),
    STATUS_UNDETECTED("3","未检测","");

    private String type;

    private String typeName;

    private String remarks;

    private WorkOrderStautsEnum(String type, String typeName, String remarks) {
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
