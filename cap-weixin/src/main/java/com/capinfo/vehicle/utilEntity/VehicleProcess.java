package com.capinfo.vehicle.utilEntity;

public class VehicleProcess {


    private String id;
    //设备ip  --摄像头对应的ip
    private String ipaddr;
    //停车场id --可能就用这个标识哪个摄像头
    private String parkId;
    //车牌号
    private String license;
    //车牌颜色
    private String platecolor;
    //识别时间
    private String recotime;
    //步骤类型  --当前数据是哪一步车检
    private String processType;
    //当前车检步骤是否通过的工作流流程变量值
    private String pass;
    //流程实例id
    private String proInsId;
    //当前数据的状态   --在第几步
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getProInsId() {
        return proInsId;
    }

    public void setProInsId(String proInsId) {
        this.proInsId = proInsId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
