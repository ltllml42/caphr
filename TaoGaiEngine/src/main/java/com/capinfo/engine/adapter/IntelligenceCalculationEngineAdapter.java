package com.capinfo.engine.adapter;

import com.capinfo.engine.IntelligenceCalculationEngine;
import com.capinfo.engine.promotion.PromotionTypeBehavior;
import com.capinfo.engine.taogai.TaoGaiTypeBehavior;

public class IntelligenceCalculationEngineAdapter<OriginalProduct>  extends IntelligenceCalculationEngine {

    @Override
    protected void execTaoGai(TaoGaiTypeBehavior taoGaiTypeBehavior) throws Exception {

    }

    @Override
    protected void execPromotion(PromotionTypeBehavior promotionTypeBehavior) {

    }
}
