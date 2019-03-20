package com.capinfo.engine.utils.entity;

import java.util.Date;

/**
 * 需要这样的一个对象，保存年份，月份，年月的date类型，输入的年或月后累加后的相同对象
 */
public class DateCount {

    private Integer year;

    private Integer month;

    private Date yearMonthDate;
    //1累加年，2累加月
    private String addYearOrMonth;
    //需要累加的年数或月数
    private String addNum;

    private DateCount afterAddDateCount;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Date getYearMonthDate() {
        return yearMonthDate;
    }

    public void setYearMonthDate(Date yearMonthDate) {
        this.yearMonthDate = yearMonthDate;
    }

    public String getAddYearOrMonth() {
        return addYearOrMonth;
    }

    public void setAddYearOrMonth(String addYearOrMonth) {
        this.addYearOrMonth = addYearOrMonth;
    }

    public DateCount getAfterAddDateCount() {
        return afterAddDateCount;
    }

    public void setAfterAddDateCount(DateCount afterAddDateCount) {
        this.afterAddDateCount = afterAddDateCount;
    }

    public String getAddNum() {
        return addNum;
    }

    public void setAddNum(String addNum) {
        this.addNum = addNum;
    }
}
