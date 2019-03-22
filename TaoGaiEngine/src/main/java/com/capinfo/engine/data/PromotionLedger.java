package com.capinfo.engine.data;

import java.util.Date;

/**
 * 晋升台账
 */
public class PromotionLedger {

    private String busiId;
    private String foreignKey;
    private String recordData;
    private String servinglimit;//要求格式  1年12月
    private String remainlimit; //格式要求  1年12月
    private Date craeteDate;

    public PromotionLedger(String busiId, String foreignKey, String recordData, String servinglimit, Date craeteDate) {
        this.busiId = busiId;
        this.foreignKey = foreignKey;
        this.recordData = recordData;
        this.servinglimit = servinglimit;
        this.craeteDate = craeteDate;
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }

    public String getRecordData() {
        return recordData;
    }

    public void setRecordData(String recordData) {
        this.recordData = recordData;
    }

    public String getServinglimit() {
        return servinglimit;
    }

    public void setServinglimit(String servinglimit) {
        this.servinglimit = servinglimit;
    }

    public Date getCraeteDate() {
        return craeteDate;
    }

    public void setCraeteDate(Date craeteDate) {
        this.craeteDate = craeteDate;
    }
}
