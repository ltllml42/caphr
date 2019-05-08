package com.capinfo.engine.data;

import com.capinfo.engine.dict.PromoteTimeConfing;
import com.capinfo.engine.promotion.PromotionType;
import com.capinfo.engine.taogai.TaoGaiType;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

/**
 * 查询相应信息并封装到对象中
 *  从RS_A01中获取
 *  名词解释 ：
 *  公务员<b>职级</b>可分为领导职务层次与非领导职务层次
 *  <b>职务<b/>
 *
 *
 */
public class OriginalProduct {



    /**
     * 是否套改
     */
    private boolean coverModel =false;
    /**
     * RS_A01的主键
     */
    private String id;
    /**
     * 姓名	RS_A01  A0101
     */
    private String name;
    /**
     * 身份证	RS_A01  A0184
     */
    private String idCode;
    /**
     * 套改或者晋升时间（手动输入）
     */
    private Date operationTime;

    /**
     * 页面上输入的晋升截止时间
     */
    private Date promotionDateByInput;


    private TaoGaiType taoGaiType;

    private PromotionType promotionType;
    /**
     * 最终运算后生成的数据  (套改和晋升)
     *
     */
    private TaoGaiPromotionSubset nowTaoGaiPromotionSubset;
    /**
     * 任职文号  是从页面传递过来的。
     */
    private String nowReferenceNumber;

    /**
     * 计算中的任职年限
     */
    private int sumLimit;

    /**
     * 工作单位及职务 A01-A0192
     */
    private String workUnitAndPost;


    //目前业务逻辑  在同一个时间里，如果有非领导职务按照非领导职务的任职年限算，任职时间不确定
    /**
     * 职务信息子集
     */
    private List<PostSubset> postSubsetList;

    /**
     * 晋升历史表
     */
    private Stack<TaoGaiPromotionSubset> promotionHisList;

    /**
     * 套改
     */
    private Stack<TaoGaiPromotionSubset> taoGaiHisList;
    /**
     * 职务信息集   A05  通过A0531进行区分
     */
    private List<PostRanks> postList;
    /**
     * 职级信息集  A05  通过A0531进行区分
     */
    private List<PostRanks> ranksList;

    /**
     * 套改后职级职级是否为新职级或旧职级
     */
    private boolean afterNewOrOld;
    /**
     * 套改前职级职级是否为新职级或旧职级
     */
    private boolean beforeNowOrOld;



    /**
     * 考核子集
     */
    private List<AssessmentSubset> assessmentSubsetList;

    public Stack<TaoGaiPromotionSubset> getPromotionHisList() {
        return promotionHisList;
    }

    public void setPromotionHisList(Stack<TaoGaiPromotionSubset> promotionHisList) {
        this.promotionHisList = promotionHisList;
    }

    public Stack<TaoGaiPromotionSubset> getTaoGaiHisList() {
        return taoGaiHisList;
    }

    public void setTaoGaiHisList(Stack<TaoGaiPromotionSubset> taoGaiHisList) {
        this.taoGaiHisList = taoGaiHisList;
    }

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

    public List<PostRanks> getPostList() {
        return postList;
    }

    public void setPostList(List<PostRanks> postList) {
        this.postList = postList;
    }

    public List<PostRanks> getRanksList() {
        return ranksList;
    }

    public void setRanksList(List<PostRanks> ranksList) {
        this.ranksList = ranksList;
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

    public TaoGaiType getTaoGaiType() {
        return taoGaiType;
    }

    public void setTaoGaiType(TaoGaiType taoGaiType) {
        this.taoGaiType = taoGaiType;
    }


    public String getWorkUnitAndPost() {
        return workUnitAndPost;
    }

    public void setWorkUnitAndPost(String workUnitAndPost) {
        this.workUnitAndPost = workUnitAndPost;
    }

    /**
     *
     *
     * @return
     */
    public PromotionType getPromotionType() {
        return promotionType;
    }

    /**
     * 是否为新晋级的职务层级
     *
     *
     * | 套改前职级 | 套改前职务层次 |
     * | ---------- | -------------- |
     * | 不存在     | 存在           |
     * | 存在       | 存在           |
     *
     *
     * | GWY        | ZJ     | ZHGL         |
     * | ---------- | ------ | ------------ |
     * |            |        | 一级调研员   |
     * | 厅局级正职 |        | 一级巡视员   |
     * | 厅局级副职 |        | 二级巡视员   |
     * | 县处级正职 | 正处级 | 二级调研员   |
     * |            |        | 三级调研员   |
     * | 县处级副职 | 副处级 | 四级调研员   |
     * |            |        | 一级主任科员 |
     * | 乡科级正职 | 正科级 | 二级主任科员 |
     * |            |        | 三级主任科员 |
     * | 乡科级副职 | 副科级 | 四级主任科员 |
     * | 科员       | 科员级 | 一级科员     |
     * | 办事员     |        | 二级科员     |
     *
     *  GWY 和 ZJ 的数据 如果出现就是旧的数
     */
    public boolean isBeforeNewOrOldRank(TaoGaiPromotionSubset peek) {
        if (StringUtils.isNotBlank(peek.getBeforeRank())){
            return isNewOrOldRank(peek.getBeforeRank());
        }else if(StringUtils.isNotBlank(peek.getBeforeLevels())){
            return isNewOrOldRank(peek.getBeforeLevels());
        }
        throw new RuntimeException("我日");
    }

    /**
     *
     * @param rank
     * @param post
     * @return
     */
    public static boolean isNewOrOldRank(String rank,String post){
        if(StringUtils.isNotBlank(rank)){
            return isNewOrOldRank(rank);
        }
        if(StringUtils.isNotBlank(post)){
            return isNewOrOldRank(rank);
        }
        throw new RuntimeException("我日");
    };



    /**
     *
     * @param peek
     * @return
     */
    public boolean isAfterNewOrOldRank(TaoGaiPromotionSubset peek) {
        if (StringUtils.isNotBlank(peek.getAfterRank())){
            return isNewOrOldRank(peek.getAfterRank());
        }
        throw new RuntimeException("我日");
    }


    /**
     *
     * @param rank
     * @return  true 是新   false 是旧
     */
    private static boolean isNewOrOldRank(String rank){
        List<PromoteTimeConfing> list = new ArrayList<PromoteTimeConfing>();
        for (PromoteTimeConfing ptc: list) {
            if (StringUtils.equals(ptc.getGwy(),rank)||StringUtils.equals(ptc.getZj(),rank)){
                return false;
            }
            if(StringUtils.equals(ptc.getZhgl(),rank)){
                return true;
            }
        }
        throw new RuntimeException("我日");
    }



    public TaoGaiPromotionSubset getNowTaoGaiPromotionSubset() {
        return nowTaoGaiPromotionSubset;
    }

    public void setNowTaoGaiPromotionSubset(TaoGaiPromotionSubset nowTaoGaiPromotionSubset) {
        this.nowTaoGaiPromotionSubset = nowTaoGaiPromotionSubset;
    }

    public int getSumLimit() {
        return sumLimit;
    }

    public void setSumLimit(int sumLimit) {
        this.sumLimit = sumLimit;
    }


    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
    }

    public String getNowReferenceNumber() {
        return nowReferenceNumber;
    }

    public void setNowReferenceNumber(String nowReferenceNumber) {
        this.nowReferenceNumber = nowReferenceNumber;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public boolean isAfterNewOrOld() {
        return afterNewOrOld;
    }

    public void setAfterNewOrOld(boolean afterNewOrOld) {
        this.afterNewOrOld = afterNewOrOld;
    }

    public boolean isBeforeNowOrOld() {
        return beforeNowOrOld;
    }

    public void setBeforeNowOrOld(boolean beforeNowOrOld) {
        this.beforeNowOrOld = beforeNowOrOld;
    }

    public Date getPromotionDateByInput() {
        return promotionDateByInput;
    }

    public void setPromotionDateByInput(Date promotionDateByInput) {
        this.promotionDateByInput = promotionDateByInput;
    }


}
