package com.capinfo.engine.promotion;

import com.capinfo.engine.data.VersionInfo;
import com.capinfo.engine.message.MessageCode;

public class PromotionModeThreeBehavior<T> implements PromotionConditionBehavior<T> {
    @Override
    public VersionInfo getVersion() {
        return VersionInfo.VERSION_2019;
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
