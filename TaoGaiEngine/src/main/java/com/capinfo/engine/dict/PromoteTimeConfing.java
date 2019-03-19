package com.capinfo.engine.dict;

/**
 * 晋升时间表
 */
public class PromoteTimeConfing {

    //晋升前职务
    private String frontKey;//保存ID
    private String frontName;//保存汉字

    //晋升后职务
    private String afterKey;//保存ID
    private String afterName;//保存汉字

    //转化年
    private String yearLimit;
    //年转化月
    private String monthLimit;


    public String getFrontKey() {
        return frontKey;
    }

    public void setFrontKey(String frontKey) {
        this.frontKey = frontKey;
    }

    public String getFrontName() {
        return frontName;
    }

    public void setFrontName(String frontName) {
        this.frontName = frontName;
    }

    public String getAfterKey() {
        return afterKey;
    }

    public void setAfterKey(String afterKey) {
        this.afterKey = afterKey;
    }

    public String getAfterName() {
        return afterName;
    }

    public void setAfterName(String afterName) {
        this.afterName = afterName;
    }

    public String getYearLimit() {
        return yearLimit;
    }

    public void setYearLimit(String yearLimit) {
        this.yearLimit = yearLimit;
    }

    public String getMonthLimit() {
        return monthLimit;
    }

    public void setMonthLimit(String monthLimit) {
        this.monthLimit = monthLimit;
    }
}
