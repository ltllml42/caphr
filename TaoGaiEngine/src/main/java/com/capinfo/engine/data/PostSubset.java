package com.capinfo.engine.data;

import java.util.Date;

/**
 * A02的参数
 */
public class PostSubset {

    /**
     * 主键
     */
    private String id;
    /**
     * 职务开始时间		A0288
     */
    private Date startDate;

    /**
     * 职务结束时间		免职时间
     */
    private Date endDate;

    /**
     * 职务		厅局级正职   	A0221	DIC_RS_ZB09
     */
    private String post;

    /**
     * 知否为主职务	A0279 	DIC_TRUE_FALSE
     */
    private boolean mainPost;

    /**
     * 是否为领导职务	A0219	DIC_TRUE_FALSE
     */
    private boolean leader;
    /**
     * 任职状态	0以免1在任	A0255		DIC_RS_ZB14
     */
    private Integer workStatus;
    /**
     * 输出标识	Y输出N不输出	A0281	DIC_RS_SCIMP
     */
    private String outputMark;
    /**
     * 操作类型	1：insert，2：update，3：delete
     */
    private String opt;
    /**
     * 是否领导成员		A0201D		DIC_TRUE_FALSE
     */
    private String isLeadMember;
    /**
     * 成员类别		A0201E	DIC_RS_ZB129
     */
    private String memberType;
    /**
     * 职务名称		A0215A
     */
    private String postName;
    /**
     * 是否破格提拔		A0251B	DIC_TRUE_FALSE
     */
    private String isSpecialPromote;
    /**
     * 任职机构名称		A0201A
     */
    private String postUnitName;

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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public boolean isMainPost() {
        return mainPost;
    }

    public void setMainPost(boolean mainPost) {
        this.mainPost = mainPost;
    }

    public boolean isLeader() {
        return leader;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    public String getOutputMark() {
        return outputMark;
    }

    public void setOutputMark(String outputMark) {
        this.outputMark = outputMark;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }



    public String getIsLeadMember() {
        return isLeadMember;
    }

    public void setIsLeadMember(String isLeadMember) {
        this.isLeadMember = isLeadMember;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getIsSpecialPromote() {
        return isSpecialPromote;
    }

    public void setIsSpecialPromote(String isSpecialPromote) {
        this.isSpecialPromote = isSpecialPromote;
    }

    public String getPostUnitName() {
        return postUnitName;
    }

    public void setPostUnitName(String postUnitName) {
        this.postUnitName = postUnitName;
    }
}
