package com.capinfo.engine.promotion;

import com.capinfo.engine.data.TaoGaiPromotionSubset;

public class PromotionModeUnCentainBehavior extends AbstractPromotionConditionBehavior{



    @Override
    protected TaoGaiPromotionSubset needPromotionModeTypeJudge() {
        return null;
    }

    @Override
    public int countServingLimit() {
        return 0;
    }
}
