package com.capinfo.engine.promotion;

import com.capinfo.engine.data.VersionInfo;
import com.capinfo.engine.message.MessageCode;

public interface PromotionTypeBehavior<T> {

    /**
     * 填写版本
     * @return
     */
    public VersionInfo getVersion();

    /**
     * 通过基础数据判断套改类型
     *
     *
     * @param data
     * @return
     */
    public PromotionType judgementType(T data);

    /**
     * 传入的数据必须是符合套改条件的基础数据
     * @param data
     * @return
     */
    public MessageCode validate(T data);


}
