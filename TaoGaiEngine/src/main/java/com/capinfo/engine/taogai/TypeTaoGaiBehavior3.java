package com.capinfo.engine.taogai;

import com.capinfo.engine.data.PostSubset;
import com.capinfo.engine.data.TaoGaiPromotionSubset;

import java.util.List;

public class TypeTaoGaiBehavior3<T> extends AbstractTaoGaiBehavior {

    @Override
    protected TaoGaiPromotionSubset needTypeJudge(PostSubset mainPost, List postList, List list) {
     /*   super.taoGaiPromotionSubset.setBeforeRank();//有关系
        super.taoGaiPromotionSubset.setCountyUnderRank();//有关系
        super.taoGaiPromotionSubset.setNowYearCount();
        super.taoGaiPromotionSubset.setCountyUnderNowRankTime();
        super.taoGaiPromotionSubset.setAfterRank();*/
        return taoGaiPromotionSubset;
    }

}
