package com.capinfo.engine.promotion;

/**
 * 三种情况
 */
public enum PromotionType {
    DYZ1(1,"符合县以下机关职级并完成套改后人员"),
    DYZ2(2,""),
    DYZ3(3,"");

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
