package com.capinfo.engine.dict;

/**
 * 晋升时间表
 *
 *  韩王栋起的名字，和改程序作者没有关系
 *
 *
 */
public class PromoteTimeConfing {
    /**
     * id
     */
   private String id;
    /**
     * 父ID
     */
   private String pid;
    /**
     *公务员套改前职务层次
     */
   private String gwy;
    /**
     * 公务员套改前职务层级
     */
   private String zj;
    /**
     * 套改后级别
     */
   private String zhgl;
    /**
     * 套改类型   三种套改类型
     */
   private String type;
    /**
     * 晋升年限
     */
   private int nx;
    /**
     * 排序
     */
   private int sort;
    /**
     * 是否有效
     */
   private String delFlag;
    /**
     * 中文备注
     */
   private String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getGwy() {
        return gwy;
    }

    public void setGwy(String gwy) {
        this.gwy = gwy;
    }

    public String getZj() {
        return zj;
    }

    public void setZj(String zj) {
        this.zj = zj;
    }

    public String getZhgl() {
        return zhgl;
    }

    public void setZhgl(String zhgl) {
        this.zhgl = zhgl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNx() {
        return nx;
    }

    public void setNx(int nx) {
        this.nx = nx;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
