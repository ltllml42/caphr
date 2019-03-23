package com.capinfo.engine.promotion.factory;


import com.capinfo.engine.promotion.*;

public class PromotionModeBehaviorFactory {


    public PromotionConditionBehavior newFactory(PromotionType type){
        switch (type) {
            case TAOGAI_STATUS: new PromotionModeTaoGaiBehavior();
                break;
            case FIRST_PROMOTION_STATUS: new PromotionModeFirstBehavior();
                break;
            case SECOND_PROMOTION_STATUS: new PromotionModeSecondBehavior();
                break;
            case NORMAL_PROMOTION_STATUS: new PromotionModeNormalBehavior();
                break;
            case ERROR_STATUS: new PromotionModeErrorBehavior();
                break;
            /*case UNCERTAIN_STATUS: new PromotionModeUnCentainBehavior();
                break;*/
        }
        return null;
    }

}
