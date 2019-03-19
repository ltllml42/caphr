package com.capinfo.engine.data;

import java.util.Date;

public class PostSubset {
    /**
     * 职务开始时间
     */
    private Date startDate;

    /**
     * 职务结束时间
     */
    private Date endDate;

    /**
     * 职级（职务等级）
     */
    private String rank;

    /**
     * 职务
     */
    private String post;

    /**
     * 职级任职时间
     */
    private int rankLimit;

    /**
     * 知否为主职务
     */
    private boolean mainPost;

    /**
     * 是否为领导职务
     */
    private boolean isLeader;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getRankLimit() {
        return rankLimit;
    }

    public void setRankLimit(int rankLimit) {
        this.rankLimit = rankLimit;
    }

    public boolean isMainPost() {
        return mainPost;
    }

    public void setMainPost(boolean mainPost) {
        this.mainPost = mainPost;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }
}
