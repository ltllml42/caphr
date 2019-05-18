package com.capinfo.vehicle.utilEntity;

public class CarCardInfo {

    //设备ip
    private String ipaddr;
    //停车场id
    private String parkId;
    //车牌号
    private String license;
    //车牌颜色
    private String platecolor;
    //识别时间
    private String recotime;

    private String direction;

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getPlatecolor() {
        return platecolor;
    }

    public void setPlatecolor(String platecolor) {
        this.platecolor = platecolor;
    }

    public String getRecotime() {
        return recotime;
    }

    public void setRecotime(String recotime) {
        this.recotime = recotime;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
