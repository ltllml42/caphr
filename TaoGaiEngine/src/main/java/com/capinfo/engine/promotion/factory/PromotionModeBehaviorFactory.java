package com.capinfo.engine.promotion.factory;


import com.capinfo.engine.promotion.PromotionConditionBehavior;
import com.capinfo.engine.promotion.PromotionModeOneBehavior;
import com.capinfo.engine.promotion.PromotionType;

public class PromotionModeBehaviorFactory {


    public PromotionConditionBehavior newFactory(PromotionType type){

        switch (type) {
            case DYZ1: return new PromotionModeOneBehavior();
            case DYZ2: return new PromotionModeOneBehavior();
            case DYZ3: return new PromotionModeOneBehavior();
            default:return null;
        }
    }

}
