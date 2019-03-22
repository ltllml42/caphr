package com.capinfo.engine.promotion;

import com.capinfo.engine.data.OriginalProduct;
import com.capinfo.engine.data.PromotionLedger;
import com.capinfo.engine.data.TaoGaiPromotionSubset;
import com.capinfo.engine.data.VersionInfo;
import com.capinfo.engine.dict.PromoteTimeConfing;
import com.capinfo.engine.log.Ledger;
import com.capinfo.engine.message.MessageCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 名言警句
 *
 * 烂程序员关心的是代码。好程序员关心的是数据结构和它们之间的关系。---Torvalds Liunx之父
 */
public abstract class AbstractPromotionConditionBehavior implements PromotionConditionBehavior<OriginalProduct>{

    protected List<PromotionLedger> ledgerList = new ArrayList<PromotionLedger>();
    /**
     * 上一次晋升情况和相关的记录
     */
    protected OriginalProduct lastProduct;
    /**
     * 上次晋级或者套改的数据
     */
    protected TaoGaiPromotionSubset lastPromotionRank;
    /**
     *  下次晋升的数据准备
     */
    protected TaoGaiPromotionSubset nextPromotionRank;

    @Override
    public VersionInfo getVersion() {
        return VersionInfo.VERSION_2019;
    }

    @Override
    public void process() {
        //TODO:validate(); 开起来
        nextPromotionRank = new TaoGaiPromotionSubset();
		//nextPromotionRank.setId()
		nextPromotionRank.setSid(lastPromotionRank.getId());
        //nextPromotionRank.setA02Id("");
		nextPromotionRank.setBeforeRank(lastPromotionRank.getBeforeRank());
		//nextPromotionRank.setCountyUnderRank(lastPromotionRank)




        nextPromotionRank.setRankTotalYearCount(
		nextPromotionRank.setNowReferenceNumber(
		nextPromotionRank.setNowYearCount(
		nextPromotionRank.setBeforePost(
		nextPromotionRank.setBeforePostCate(
		nextPromotionRank.setBeforeLevels(
		nextPromotionRank.setLeader(
		nextPromotionRank.setRankNowStatus(
		nextPromotionRank.setNowRankTime(
		nextPromotionRank.setCountyUnderNowRankTime(
		nextPromotionRank.setOperationTime(
		nextPromotionRank.setBeforePostNowTime(
		nextPromotionRank.setPromoteTime(
		nextPromotionRank.setUpStatus(
		nextPromotionRank.setAfterRank(
		nextPromotionRank.setLedgerList(
    }

    public abstract int countServingLimit(OriginalProduct originalProduct);
    public abstract int countAssessConverLimit(OriginalProduct originalProduct);
    public List<PromoteTimeConfing> loadPromoteList(OriginalProduct originalProduct){
        originalProduct.getPromotionHisList();
        return new ArrayList<PromoteTimeConfing>();
    };


    @Override
    public MessageCode validate(OriginalProduct data) {

        Stack<TaoGaiPromotionSubset> promotionHisList = data.getPromotionHisList();

        if (promotionHisList==null||promotionHisList.isEmpty()){
            Stack<TaoGaiPromotionSubset> taoGaiHisList = data.getTaoGaiHisList();
            if (taoGaiHisList==null||taoGaiHisList.isEmpty()){
                throw new RuntimeException("我日");
            }
            this.lastPromotionRank = taoGaiHisList.peek();
        }else{
            this.lastPromotionRank =promotionHisList.peek();
        }



        return null;
    }


    /**
     * 输出预测的晋升情况
     * @return
     */
    public TaoGaiPromotionSubset result(){
        return nextPromotionRank;
    }


    public void setLastProduct(OriginalProduct lastProduct) {
        this.lastProduct = lastProduct;
    }

}
