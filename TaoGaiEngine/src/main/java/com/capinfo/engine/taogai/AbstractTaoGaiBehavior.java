package com.capinfo.engine.taogai;

import com.capinfo.engine.TaoGaiLogger;
import com.capinfo.engine.data.*;
import com.capinfo.engine.log.Ledger;
import com.capinfo.engine.message.MessageCode;
import com.capinfo.engine.promotion.PromotionType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractTaoGaiBehavior<OriginalProduct> implements TaoGaiBehavior<OriginalProduct>, Ledger {


    protected List<PromotionLedger> ledgerList = new ArrayList<PromotionLedger>();
    /**
     * 上一次晋升情况和相关的记录
     */
    protected com.capinfo.engine.data.OriginalProduct taogaiProduct;
    /**
     *  套改
     */
    protected TaoGaiPromotionSubset taoGaiPromotionSubset;

    @Override
    public VersionInfo getVersion() {
        return VersionInfo.VERSION_2019;
    }

    @Override
    public void execute() {
        //validate(taogaiProduct);
        taoGaiPromotionSubset = new TaoGaiPromotionSubset();
        /**
         * 在任的主职务信息
         */
        PostSubset mainPost = findByMainPost(taogaiProduct.getPostSubsetList());

        /**
         * 在任的职务层次
         */
        List<PostRanks> postList = taogaiProduct.getPostList();
        /**
         * 在任的职级
         */
        List<PostRanks> ranksList = taogaiProduct.getRanksList();

        //taoGaiPromotionSubset.setId(
		taoGaiPromotionSubset.setSid(taogaiProduct.getId());
		//A02Id 是主职务的ID
		taoGaiPromotionSubset.setA02Id(mainPost.getId());

		//taoGaiPromotionSubset.setRankTotalYearCount()// 不用填写
		taoGaiPromotionSubset.setNowReferenceNumber(taogaiProduct.getNowReferenceNumber());
        /**
         * 页面上传入的套改时间 到 主职务职级的任职时间
         *
         *
         */
		taoGaiPromotionSubset.setBeforePost(mainPost.getPost());
		taoGaiPromotionSubset.setBeforePostCate(taogaiProduct.getWorkUnitAndPost());
		taoGaiPromotionSubset.setBeforeLevels(findByBeforeLevels(postList));
		taoGaiPromotionSubset.setLeader(mainPost.isLeader());
        //在任 目前套改必须是在任的将来有可能会调整
		taoGaiPromotionSubset.setRankNowStatus("1");
		//任现职级时间就是套改时间(手动输入)
		taoGaiPromotionSubset.setNowRankTime(findByNowRankTime(ranksList));

        /*
         taoGaiPromotionSubset.setOperationTime(taogaiProduct.getTaoGaiTime());
*/
		taoGaiPromotionSubset.setBeforePostNowTime(findByBeforePostNowTime(postList));
		//套改不需要填写套改时间
		//taoGaiPromotionSubset.setPromoteTime();
		taoGaiPromotionSubset.setUpStatus(PromotionType.TAOGAI_STATUS.getCode());
        taoGaiPromotionSubset = needTypeJudge(mainPost,postList,ranksList);
        taoGaiPromotionSubset.setLedgerList(ledgerList);
    }

    protected abstract TaoGaiPromotionSubset needTypeJudge(PostSubset mainPost, List<PostRanks> postList, List<PostRanks> ranksList);


    /**
     *
     * @param postList
     * @return
     */
    protected Date findByBeforePostNowTime(List<PostRanks> postList){
        return new Date();
    };

    /**
     * 获取职级的任职时间
     * @param ranksList
     * @return
     */
    private Date findByNowRankTime(List<PostRanks> ranksList) {

        return new Date();
    }

    /**
     *
     * @param postList
     * @return
     */
    private String findByBeforeLevels(List<PostRanks> postList) {

        return "";
    }


    /**
     *  TODO:未完成代码
     * @param postSubsetList
     * @return
     */
    protected PostSubset findByMainPost(List<PostSubset> postSubsetList){
        return new PostSubset();
    };

    @Override
    public List<MessageCode> validate(OriginalProduct data) {
        return null;
    }

    @Override
    public TaoGaiLogger message(String level, Object... msg) {
        return null;
    }

    public TaoGaiPromotionSubset result(){
        return taoGaiPromotionSubset;
    }

}
