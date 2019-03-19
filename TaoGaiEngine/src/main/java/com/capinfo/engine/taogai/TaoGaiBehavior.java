package com.capinfo.engine.taogai;

import com.capinfo.engine.message.MessageCode;

import java.util.List;

/**
 * 判断是否允许套改
 */
public interface TaoGaiBehavior<T> {


    public String getVersion();

    /**
     * 执行套改
     * @param t 套改对象
     */
    public T execute(T t);
    /**
     * 当前角色
     * @param data
     * @return ErrorCode
     */
    List<MessageCode> validate(T data);


}
