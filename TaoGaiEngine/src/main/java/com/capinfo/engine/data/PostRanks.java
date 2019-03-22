package com.capinfo.engine.data;

/**
 * 职务层次信息集
 */
public class PostRanks {


    /**
     * 主键
     */
    private String id;
    /**
     * 外键
     */
    private String sid;
    /**
     * 职级/层次		A0501B			职级dic_rs_zb133		层次dic_rs_zb09		职级：县处级以下职级  层次：正处级
     */
    private String zj;
    /**
     * 状态	1在任   0以免  查询出来的就是在任的	A0524		DIC_RS_ZB14
     */
    private String status;
    /**
     * 类别（职务层次、职级标志）	A0531		DIC_RS_ZWZJLB
     */
    private String lb;
    /**
     * 操作类型	1：insert，2：update，3：delete
     */
    private String opt;
    /**
     * 职级时间	A0504
     */
    private String zjDate;

//
//    public PostRanks mapToEntity(PostRanks po,Map<String,Object> map){
//        if(null == po){
//            po = new PostRanks();
//        }
//        String id = (String) map.get("ID");
//        String sid = (String) map.get("SID");
//        String zj = (String) map.get("A0501B");
//        String status = (String) map.get("A0524");
//        String lb = (String) map.get("A0531");
//        po.setId(id);
//        po.setSid(sid);
//        po.setZj(zj);
//        po.setStatus(status);
//        po.setLb(lb);
//        return po;
//    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getZj() {
        return zj;
    }
    public void setZj(String zj) {
        this.zj = zj;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getLb() {
        return lb;
    }
    public void setLb(String lb) {
        this.lb = lb;
    }
    public String getOpt() {
        return opt;
    }
    public void setOpt(String opt) {
        this.opt = opt;
    }
    public String getZjDate() {
        return zjDate;
    }
    public void setZjDate(String zjDate) {
        this.zjDate = zjDate;
    }






}
