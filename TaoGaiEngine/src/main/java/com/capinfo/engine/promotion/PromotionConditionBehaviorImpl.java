package com.capinfo.engine.promotion;

import com.capinfo.engine.data.OriginalProduct;
import com.capinfo.engine.data.VersionInfo;
import com.capinfo.engine.message.MessageCode;

public class PromotionConditionBehaviorImpl<T> implements PromotionConditionBehavior<T> {
    @Override
    public VersionInfo getVersion() {
        return VersionInfo.VERSION_2019;
    }

    @Override
    public Promotion process(T t) {
        //处理过程
        if(t instanceof OriginalProduct){



        }


        return null;
    }

    /**
     * 验证数据是否正确
     * @param data
     * @return
     */
    @Override
    public MessageCode validate(T data) {
        return null;
    }
}
