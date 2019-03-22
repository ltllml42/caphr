package com.capinfo.engine.promotion.handle;

import com.capinfo.engine.data.OriginalProduct;
import com.capinfo.engine.dict.CheckPostConfig;
import com.capinfo.engine.message.MessageEnum;
import com.capinfo.engine.promotion.PromotionType;
import com.capinfo.engine.utils.MessageUtils;

import java.util.List;

public abstract class ServingLimitHandler {

    protected volatile int servingLimit = 0;

    protected OriginalProduct product;

    protected ServingLimitHandler next;

    /**
     * 业务处理计算任职年限
     */
    public abstract void handleRequest(PromotionType type);

    /**
     * 加载业务字典
      * @param dictList
     */
    public abstract List loadDict(List dictList);

    public boolean validate(){
        if(product!=null){
            throw new NullPointerException(MessageUtils.showMessage(MessageEnum.ERROR_CODE_NULL,OriginalProduct.class));
        }
        return true;
    };

    public int getServingLimit() {
        return servingLimit;
    }

    public void setServingLimit(int servingLimit) {
        this.servingLimit = servingLimit;
    }

    public ServingLimitHandler next() {
        return this.next;
    }

    public void setNext(ServingLimitHandler next) {
        this.next = next;
    }

    public void setProduct(OriginalProduct product) {
        this.product = product;
    }
}
