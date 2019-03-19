package com.capinfo.engine;

import java.util.Date;

/**
 * 人员晋升对象
 */
public class Promotion {
    /**
     * 判断是否晋升
     */
    private boolean isPromotion = false;
    /**
     * 现任职级
     */
    private String nowRanks;
    /**
     * 套改职级
     */
    private String taoGaiRanks;
    /**
     * 套改前职务层次
     */
    private int isLeader;

    /**
     * 任职年限  按照月进行累加
     */
    private int servingLimit;

    /**
     * 上次晋级时间  精确到月
     */
    private Date lastPromotionDate;
    /**
     * 下次晋级时间  精确到月
     */
    private Date nextPromotionDate;


    public boolean isPromotion() {
        return isPromotion;
    }

    public void setPromotion(boolean promotion) {
        isPromotion = promotion;
    }

    public String getNowRanks() {
        return nowRanks;
    }

    public void setNowRanks(String nowRanks) {
        this.nowRanks = nowRanks;
    }

    public String getTaoGaiRanks() {
        return taoGaiRanks;
    }

    public void setTaoGaiRanks(String taoGaiRanks) {
        this.taoGaiRanks = taoGaiRanks;
    }

    public int getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(int isLeader) {
        this.isLeader = isLeader;
    }

    public int getServingLimit() {
        return servingLimit;
    }

    public void setServingLimit(int servingLimit) {
        this.servingLimit = servingLimit;
    }

    public Date getLastPromotionDate() {
        return lastPromotionDate;
    }

    public void setLastPromotionDate(Date lastPromotionDate) {
        this.lastPromotionDate = lastPromotionDate;
    }

    public Date getNextPromotionDate() {
        return nextPromotionDate;
    }

    public void setNextPromotionDate(Date nextPromotionDate) {
        this.nextPromotionDate = nextPromotionDate;
    }
}
