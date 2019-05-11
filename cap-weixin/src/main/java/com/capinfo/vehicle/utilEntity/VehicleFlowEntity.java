package com.capinfo.vehicle.utilEntity;

import java.util.Map;

public class VehicleFlowEntity {

    //流程变量
    private Map<String, Object> map;
    //接下来走到的节点
    private String nowLink;
    //节点状态  通过/不通过
    private String nowStatus;
    //当前步骤花费钱数
    private double stepMoney;
    //是否为复检的情况  null或者1为不是复检的情况，2为复检的情况     暂时先这样想这个属性先不加
    private String isRepeat;


    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getNowLink() {
        return nowLink;
    }

    public void setNowLink(String nowLink) {
        this.nowLink = nowLink;
    }

    public String getNowStatus() {
        return nowStatus;
    }

    public void setNowStatus(String nowStatus) {
        this.nowStatus = nowStatus;
    }

    public double getStepMoney() {
        return stepMoney;
    }

    public void setStepMoney(double stepMoney) {
        this.stepMoney = stepMoney;
    }

    public String getIsRepeat() {
        return isRepeat;
    }

    public void setIsRepeat(String isRepeat) {
        this.isRepeat = isRepeat;
    }
}
