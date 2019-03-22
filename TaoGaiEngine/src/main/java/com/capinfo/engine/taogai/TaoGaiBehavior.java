package com.capinfo.engine.taogai;

import com.capinfo.engine.data.VersionInfo;
import com.capinfo.engine.message.MessageCode;

import java.util.List;

/**
 * 判断是否允许套改
 *
 *
 * 计算机最难搞定的两个问题是 内存失效和命名。
 * There are only two hard things in Computer Science: cache invalidation
 * and naming things.
 *    ---   Phil Karlton
 *
 *
 */
public interface TaoGaiBehavior<T> {


    public VersionInfo getVersion();

    /**
     * 执行套改
     */
    public void execute();
    /**
     * 当前角色
     * @param data
     * @return ErrorCode
     */
    List<MessageCode> validate(T data);


}
