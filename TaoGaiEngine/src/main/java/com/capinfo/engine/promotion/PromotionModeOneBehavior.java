package com.capinfo.engine.promotion;

import com.capinfo.engine.data.VersionInfo;
import com.capinfo.engine.message.MessageCode;

public class PromotionModeOneBehavior<T> implements PromotionConditionBehavior<T> {

    @Override
    public VersionInfo getVersion() {
        return null;
    }

    @Override
    public Promotion process(T t) {
        return null;
    }

    @Override
    public MessageCode validate(T data) {
        return null;
    }
}
