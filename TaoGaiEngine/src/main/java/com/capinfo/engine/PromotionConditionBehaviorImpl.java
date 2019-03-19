package com.capinfo.engine;

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
