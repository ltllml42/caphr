package com.capinfo.engine.data;

/**
 * version 版本号说明
 */
public enum VersionInfo {

    VERSION_2019(2019,6,"中组部2019年套改方案");

    /**
     * 记录套改版本号，套改年，套改月等重要数据
     * @param year
     * @param month
     * @param remarks
     */
    private VersionInfo(int year,int month, String remarks) {
        this.year = year;
        this.month = month;
        this.remarks = remarks;
    }

    /**
     *  年份
     */
    private int year;

    /**
     *  月份 格式 1
     */
    private int month;

    /**
     * 描述信息
     */
    private String remarks;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
