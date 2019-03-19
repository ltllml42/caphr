package com.capinfo.engine.data;

import com.capinfo.engine.taogai.TaoGaiType;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询相应信息并封装到对象中
 *
 *  名词解释 ：
 *  公务员<b>职级</b>可分为领导职务层次与非领导职务层次
 *  <b>职务<b/>
 *
 *
 */
public class OriginalProduct {

    /**
     *  县处级一下需要处理
     */
    List<DictBean> needRanksDicts = new ArrayList<DictBean>();

    public List<DictBean> getNeedRanksDicts() {
        return needRanksDicts;
    }

    public void setNeedRanksDicts(List<DictBean> needRanksDicts) {
        this.needRanksDicts = needRanksDicts;
    }

    /**
     * 是否套改
     */
    private boolean coverModel =false;

    private TaoGaiType type;

    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证
     */
    private String idCode;
    /**
     * 职务
     */
    private String post;

    /**
     * 套改前的职务层级
     */
    private String beforeRank;

    /**
     * 现任职务层级
     */
    private String afterRanks;

    /**
     * 是否领导职务(职务类别)
     */
    private boolean isLeader;

    /**
     * 任职年限  按月份进行统计。
     */
    private int servingLimit;
    //目前业务逻辑  在同一个时间里，如果有非领导职务按照非领导职务的任职年限算，任职时间不确定
    /**
     * 职务信息子集
     */
    private List<PostSubset> postSubsetList;

    /**
     * 套改还是晋升
     */
    private List<TaoGaiPromotionSubset> taoGaiSubsetList;
    /**
     * 职务层次信息集
     */
    private List<PostRanks> postRanksList;
    /**
     * 考核子集
     */
    private List<AssessmentSubset> assessmentSubsetList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getBeforeRank() {
        return beforeRank;
    }

    public void setBeforeRank(String beforeRank) {
        this.beforeRank = beforeRank;
    }

    public String getAfterRanks() {
        return afterRanks;
    }

    public void setAfterRanks(String afterRanks) {
        this.afterRanks = afterRanks;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }


    public int getServingLimit() {
        return servingLimit;
    }

    public void setServingLimit(int servingLimit) {
        this.servingLimit = servingLimit;
    }

    public List<PostRanks> getPostRanksList() {
        return postRanksList;
    }

    public void setPostRanksList(List<PostRanks> postRanksList) {
        this.postRanksList = postRanksList;
    }

    public List<PostSubset> getPostSubsetList() {
        return postSubsetList;
    }

    public void setPostSubsetList(List<PostSubset> postSubsetList) {
        this.postSubsetList = postSubsetList;
    }

    public List<AssessmentSubset> getAssessmentSubsetList() {
        return assessmentSubsetList;
    }

    public void setAssessmentSubsetList(List<AssessmentSubset> assessmentSubsetList) {
        this.assessmentSubsetList = assessmentSubsetList;
    }

    public boolean isCoverModel() {
        return coverModel;
    }

    public void setCoverModel(boolean coverModel) {
        this.coverModel = coverModel;
    }
}
