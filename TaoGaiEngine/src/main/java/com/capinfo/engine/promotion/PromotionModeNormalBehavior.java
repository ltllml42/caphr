package com.capinfo.engine.promotion;

import com.capinfo.engine.data.TaoGaiPromotionSubset;
import com.capinfo.engine.dict.PromoteTimeConfing;
import com.capinfo.engine.utils.DateUtils;
import com.capinfo.engine.utils.entity.DateCount;
import com.capinfo.engine.utils.entity.YearsLimit;

import java.util.Date;
import java.util.List;

public class PromotionModeNormalBehavior<OriginalProduct> extends AbstractPromotionConditionBehavior {

    @Override
    protected TaoGaiPromotionSubset needPromotionModeTypeJudge() {
        PromotionType type = PromotionType.conversionPromotionType(lastPromotionRank.getUpStatus());
        int month = 0;
        //ZL9(true,true,PromotionType.SECOND_PROMOTION_STATUS,PromotionType.NORMAL_PROMOTION_STATUS),//下次晋升为正常晋升
        //ZL13(true,true,PromotionType.NORMAL_PROMOTION_STATUS,PromotionType.NORMAL_PROMOTION_STATUS),//正常晋升
//        if (type!=null&&(PromotionType.NORMAL_PROMOTION_STATUS==type||PromotionType.SECOND_PROMOTION_STATUS==type)){
        Date beforePostNowTime = lastPromotionRank.getBeforePostNowTime();
        Date taogaiDate = lastPromotionRank.getOperationTime();
        int result = 0;
        YearsLimit dateYearCount = super.getDateYearCount(beforePostNowTime, taogaiDate);
        int resultType = dateYearCount.getType();

        nextPromotionRank.setUpStatus(PromotionType.NORMAL_PROMOTION_STATUS.getCode());
        nextPromotionRank.setRankTotalYearCount("0");
        nextPromotionRank.setNowYearCount("0");
        List<PromoteTimeConfing> promoteTimeConfings = loadPromoteList(lastPromotionRank.getRankType());
        PromoteTimeConfing speculateRank = ladderPromotionRoute(promoteTimeConfings, lastPromotionRank);
        int nx = speculateRank.getNx() * 12;
        nextPromotionRank.setAfterRank(speculateRank.getZhgl());
        DateCount dateYearAndMonth = DateUtils.getDateYearAndMonth(lastPromotionRank.getOperationTime());
        nextPromotionRank.setNextPromoteDate(DateUtils.parseDate(dateYearAndMonth.getYear() + "" + (dateYearAndMonth.getMonth() + nx)));


//        }

        return nextPromotionRank;
    }

    @Override
    public int countServingLimit() {
        return 0;
    }
}
