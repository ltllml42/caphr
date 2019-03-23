package com.capinfo.engine.data;

import java.util.Date;
import java.util.List;

/**
 * 套改晋升表   RS_A65
 *
 *  需要注意的是
 *         如果套改前职级(rank)和套改前套改前职务层次都有的话以套改前职级()为准
 * @author 86150
 *
 */
public class TaoGaiPromotionSubset {

    private String id;

    private String sid;
    /**
     * a02表id
     */
    private String a02Id;
    /**
     * 套改前职级  县处级以下职级
     */
    private String beforeRank;
    /**
     * 套改前职务层次 正处级
     */
    private String beforeLevels;
    /**
     * 县以下职级
     */
    private String countyUnderRank;

    public int getValidMonth() {
        return validMonth;
    }

    public void setValidMonth(int validMonth) {
        this.validMonth = validMonth;
    }

    /**
     * 有效年限
     */
    private int validMonth;

    /**
     * 套改后 职务层次
     */
    private String afterLevels;

    /**
     * 任现职级时间
     */
    private Date nowRankTime;

    /**
     * 县以下机关职级任职时间
     */
    private Date countyUnderNowRankTime;
    /**
     * 职级累计年限
     */
    private String rankTotalYearCount;


    /**
     * 套改后职级
     */
    private String afterRank;
    /**
     * 套改时间  (手动录入的时间)
     */
    private Date operationTime;
    /**
     * 任职文号
     */
    private String nowReferenceNumber;
    /**
     * 任职年限
     */
    private String nowYearCount;
    /**
     * 套改前工作单位及职务
     */
    private String beforePost;
    /**
     * 套改前职务类别
     */
    private String beforePostCate;

    /**
     * 套改前职务层次任职时间
     */
    private Date beforePostNowTime;
    /**
     * 领导职务晋升标记
     */
    private boolean isLeader;
    /**
     * 职级任职状态
     */
    private String rankNowStatus;
    /**
     * 晋升时间
     */
    private Date promoteTime;
    /**
     * 是套改还是首次晋升还是二次晋升还是正常晋升
     */
    private int upStatus;
    /**
     * 晋升台账
     */
    private List<PromotionLedger> ledgerList;
    /**
     * 1 综合管理类
     *
     * 2 专业技术类
     *
     * 3 行政执法类
     *
     */
    private int rankType;

    private Date nextPromoteDate;



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
    public String getA02Id() {
        return a02Id;
    }
    public void setA02Id(String a02Id) {
        this.a02Id = a02Id;
    }

    public String getBeforeRank() {
        return beforeRank;
    }

    public void setBeforeRank(String beforeRank) {
        this.beforeRank = beforeRank;
    }

    public String getCountyUnderRank() {
        return countyUnderRank;
    }
    public void setCountyUnderRank(String countyUnderRank) {
        this.countyUnderRank = countyUnderRank;
    }

    public String getRankTotalYearCount() {
        return rankTotalYearCount;
    }
    public void setRankTotalYearCount(String rankTotalYearCount) {
        this.rankTotalYearCount = rankTotalYearCount;
    }

    public String getNowReferenceNumber() {
        return nowReferenceNumber;
    }
    public void setNowReferenceNumber(String nowReferenceNumber) {
        this.nowReferenceNumber = nowReferenceNumber;
    }
    public String getNowYearCount() {
        return nowYearCount;
    }
    public void setNowYearCount(String nowYearCount) {
        this.nowYearCount = nowYearCount;
    }
    public String getBeforePost() {
        return beforePost;
    }
    public void setBeforePost(String beforePost) {
        this.beforePost = beforePost;
    }
    public String getBeforePostCate() {
        return beforePostCate;
    }
    public void setBeforePostCate(String beforePostCate) {
        this.beforePostCate = beforePostCate;
    }
    public String getBeforeLevels() {
        return beforeLevels;
    }
    public void setBeforeLevels(String beforeLevels) {
        this.beforeLevels = beforeLevels;
    }

    public boolean isLeader() {
        return isLeader;
    }
    public void setLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }
    public String getRankNowStatus() {
        return rankNowStatus;
    }
    public void setRankNowStatus(String rankNowStatus) {
        this.rankNowStatus = rankNowStatus;
    }


    public Date getNowRankTime() {
        return nowRankTime;
    }

    public void setNowRankTime(Date nowRankTime) {
        this.nowRankTime = nowRankTime;
    }

    public Date getCountyUnderNowRankTime() {
        return countyUnderNowRankTime;
    }

    public void setCountyUnderNowRankTime(Date countyUnderNowRankTime) {
        this.countyUnderNowRankTime = countyUnderNowRankTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public Date getBeforePostNowTime() {
        return beforePostNowTime;
    }

    public void setBeforePostNowTime(Date beforePostNowTime) {
        this.beforePostNowTime = beforePostNowTime;
    }

    public Date getPromoteTime() {
        return promoteTime;
    }

    public void setPromoteTime(Date promoteTime) {
        this.promoteTime = promoteTime;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public int getUpStatus() {
        return upStatus;
    }

    public void setUpStatus(int upStatus) {
        this.upStatus = upStatus;
    }

    public String getAfterRank() {
        return afterRank;
    }

    public void setAfterRank(String afterRank) {
        this.afterRank = afterRank;
    }

    public List<PromotionLedger> getLedgerList() {
        return ledgerList;
    }

    public void setLedgerList(List<PromotionLedger> ledgerList) {
        this.ledgerList = ledgerList;
    }

    public int getRankType() {
        return rankType;
    }

    public void setRankType(int rankType) {
        this.rankType = rankType;
    }

    public String getAfterLevels() {
        return afterLevels;
    }

    public void setAfterLevels(String afterLevels) {
        this.afterLevels = afterLevels;
    }

    public Date getNextPromoteDate() {
        return nextPromoteDate;
    }

    public void setNextPromoteDate(Date nextPromoteDate) {
        this.nextPromoteDate = nextPromoteDate;
    }
}
