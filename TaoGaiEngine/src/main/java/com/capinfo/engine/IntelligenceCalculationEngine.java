package com.capinfo.engine;

import com.capinfo.engine.promotion.PromotionConditionBehavior;
import com.capinfo.engine.promotion.PromotionTypeBehavior;
import com.capinfo.engine.taogai.TaoGaiBehavior;
import com.capinfo.engine.taogai.TaoGaiTypeBehavior;

/**
 *  目前暂定传入的为OriginalData 这个原对象
 *
 */
public abstract class IntelligenceCalculationEngine<T> {

    /**
     * 数据准备
     */
    protected T product;

    /**
     * 套改条件判断
     */
    protected TaoGaiBehavior<T> taoGaiConditionBehavior;

    /**
     * 套改类型判断
     */
    protected TaoGaiTypeBehavior<T> taoGaiTypeBehavior;

    /**
     * 晋升类型判断
     */
    protected PromotionTypeBehavior<T> promotionTypeBehavior;

    /**
     * 晋升
     */
    protected PromotionConditionBehavior<T> promotionConditionBehavior;

    protected abstract void execTaoGai(TaoGaiTypeBehavior taoGaiTypeBehavior) throws Exception;


    protected abstract void execPromotion(PromotionTypeBehavior promotionTypeBehavior);

    public void setTaoGaiConditionBehavior(TaoGaiBehavior<T> taoGaiConditionBehavior) {
        this.taoGaiConditionBehavior = taoGaiConditionBehavior;
    }

    public void setTaoGaiTypeBehavior(TaoGaiTypeBehavior<T> taoGaiTypeBehavior) {
        this.taoGaiTypeBehavior = taoGaiTypeBehavior;
    }

    public void setPromotionTypeBehavior(PromotionTypeBehavior<T> promotionTypeBehavior) {
        this.promotionTypeBehavior = promotionTypeBehavior;
    }

    public void setPromotionConditionBehavior(PromotionConditionBehavior<T> promotionConditionBehavior) {
        this.promotionConditionBehavior = promotionConditionBehavior;
    }
}
