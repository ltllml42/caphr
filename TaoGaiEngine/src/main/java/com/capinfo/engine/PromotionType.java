package com.capinfo.engine;

/**
 * 三种情况
 */
public enum PromotionType {
    DYZ1(1,"第一种情况"),
    DYZ2(2,"第二种情况"),
    DYZ3(3,"第三种情况");

    private int type;
    private String remarks;

    PromotionType(int type, String remarks) {
        this.type = type;
        this.remarks = remarks;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
