package com.capinfo.engine.promotion;

import java.util.Date;

/**
 *
 *type=1     县处级以下职级，只晋升一次，晋升时间=当前时间-县处级以下职级的任职时间
 *            晋升时间>2年，满足晋升一级的时间，晋升一级。
 *            次晋升时，晋升时间=当前时间-上次晋升时间
 *
 *type=2    非领导职务 \n
 *       首次晋升===》   任职年限=当前时间-套改前职务层次时间  \n
 *       二次晋升===》   任职年限=当前时间-套改前职务层次时间-首次晋升用时年限（规则中规定的首次晋升时这个职级应该用掉的时间）\n
 *       再次晋升===》   任职年限=当前时间-上次晋升时间 \n
 *
 *type=3   领导职务  \n
 *      首次晋升===》   任职年限=当前时间-任现职务层次时间  \n
 *      二次晋升===》   任职年限=当前时间-任现职务层次时间-首次晋升用时年限（规则中规定的首次晋升时这个职级应该用掉的时间） \n
 *      再次晋升===》   任职年限=当前时间-上次晋升时间 \n
 *
 *
 *
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
