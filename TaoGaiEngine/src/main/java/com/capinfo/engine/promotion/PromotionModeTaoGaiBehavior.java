package com.capinfo.engine.promotion;

import com.capinfo.engine.data.TaoGaiPromotionSubset;
import com.capinfo.engine.data.VersionInfo;
import com.capinfo.engine.message.MessageCode;

public class PromotionModeTaoGaiBehavior extends AbstractPromotionConditionBehavior {


    @Override
    protected TaoGaiPromotionSubset needPromotionModeTypeJudge() {

        return null;
    }

    @Override
    public int countServingLimit() {
        return 0;
    }
}
