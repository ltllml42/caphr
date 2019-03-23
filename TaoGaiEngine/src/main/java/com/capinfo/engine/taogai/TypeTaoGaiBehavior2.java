package com.capinfo.engine.taogai;

import com.capinfo.engine.data.PostSubset;
import com.capinfo.engine.data.TaoGaiPromotionSubset;
import com.capinfo.engine.message.MessageCode;

import java.util.List;

public class TypeTaoGaiBehavior2 extends AbstractTaoGaiBehavior {

    @Override
    protected TaoGaiPromotionSubset needTypeJudge(PostSubset mainPost, List postList, List list) {
       /* super.taoGaiPromotionSubset.setBeforeRank();//有关系
        super.taoGaiPromotionSubset.setCountyUnderRank();//有关系
        super.taoGaiPromotionSubset.setNowYearCount();
        super.taoGaiPromotionSubset.setCountyUnderNowRankTime();
        super.taoGaiPromotionSubset.setAfterRank();*/
        return taoGaiPromotionSubset;
    }

}
