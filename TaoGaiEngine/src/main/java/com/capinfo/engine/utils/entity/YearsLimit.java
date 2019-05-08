package com.capinfo.engine.utils.entity;

public class YearsLimit {
    //套改时间-套改前任职级时间
    private int beforeTaoGaiDateLimitMonth;
    //输入的时间（或当前时间）-套改时间
    private int afterTaoGaiDateLimitMonth;

    public int getBeforeTaoGaiDateLimitMonth() {
        return beforeTaoGaiDateLimitMonth;
    }
    public void setBeforeTaoGaiDateLimitMonth(int beforeTaoGaiDateLimitMonth) {
        this.beforeTaoGaiDateLimitMonth = beforeTaoGaiDateLimitMonth;
    }

    public int getAfterTaoGaiDateLimitMonth() {
        return afterTaoGaiDateLimitMonth;
    }

    public void setAfterTaoGaiDateLimitMonth(int afterTaoGaiDateLimitMonth) {
        this.afterTaoGaiDateLimitMonth = afterTaoGaiDateLimitMonth;
    }
    public int getType() {
        if (afterTaoGaiDateLimitMonth >=0 && beforeTaoGaiDateLimitMonth >=0) {
            return 1;
        } else if (afterTaoGaiDateLimitMonth >=0 && beforeTaoGaiDateLimitMonth <=0) {
            //新员工的情况
            return 2;
        } else if (afterTaoGaiDateLimitMonth <=0 && beforeTaoGaiDateLimitMonth >=0) {
            //套改政策前离职的情况
            return 3;
        } else if (afterTaoGaiDateLimitMonth <=0 && beforeTaoGaiDateLimitMonth <=0) {
            return 4;
        }
        return 0;
    }



}
