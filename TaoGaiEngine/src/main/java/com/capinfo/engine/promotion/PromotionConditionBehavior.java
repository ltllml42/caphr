package com.capinfo.engine.promotion;

import com.capinfo.engine.data.OriginalProduct;
import com.capinfo.engine.data.VersionInfo;
import com.capinfo.engine.message.MessageCode;

/**
 * 晋升条件判断器
 * @param <T>
 */
public interface PromotionConditionBehavior<T> {

    /**
     * 当前版本号
     * @return
     */
    VersionInfo getVersion();
    /**
     * 晋升判断
     * @param
     * @return
     */
    void process();

    /**
     * 验证是否正确 如果不符合晋升条件
     * @param data
     * @return
     */
    public MessageCode validate(T data);


}
