package com.capinfo.engine.promotion;

/**
 *
 *type=1     县处级以下职级，只晋升一次，晋升时间=当前时间-县处级以下职级的任职时间
 * 晋升时间>2年，满足晋升一级的时间，晋升一级。
 * 下次晋升时，晋升时间=当前时间-上次晋升时间
 *
 *type=2    非领导职务 \n
 *       首次晋升===》   任职年限=当前时间-套改前职务层次时间  \n
 *       二次晋升===》   任职年限=当前时间-套改前职务层次时间-首次晋升用时年限（规则中规定的首次晋升时这个职级应该用掉的时间）\n
 *       再次晋升===》   任职年限=当前时间-上次晋升时间 \n
 *
 *type=3   领导职务  \n
 *      首次晋升===》   任职年限=当前时间-任现职务层次时间  \n
 *      二次晋升===》   任职年限=当前时间-任现职务层次时间-首次晋升用时年限（规则中规定的首次晋升时这个职级应该用掉的时间） \n
 *      再次晋升===》   任职年限=当前时间-上次晋升时间 \n
 *
 *
 *
 * 人员晋升对象
 */
public enum PromotionType {
    DYZ1(1,"县处级以下职级"),
    DYZ2(2,"非领导职务"),
    DYZ3(3,"领导职务");

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
