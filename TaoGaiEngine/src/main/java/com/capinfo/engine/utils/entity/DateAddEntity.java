package com.capinfo.engine.utils.entity;

import java.util.List;

public class DateAddEntity {

    //得到的每年对应月的集合
    private List<DateCount> dateCountList;
    //得到一个总共有几个月的这么一个数量
    private int dateCountNum;
    //得到输入时间到当前日期总共有几个月的一个数量
    private int monthNum;

    public List<DateCount> getDateCountList() {
        return dateCountList;
    }

    public void setDateCountList(List<DateCount> dateCountList) {
        this.dateCountList = dateCountList;
    }

    public int getDateCountNum() {
        return dateCountNum;
    }

    public void setDateCountNum(int dateCountNum) {
        this.dateCountNum = dateCountNum;
    }

    public int getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(int monthNum) {
        this.monthNum = monthNum;
    }
}
