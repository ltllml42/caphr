package com.capinfo.engine;
/**
 *  任职年限判断
 */
public interface ServingLimitHandler<T> {


    boolean validate(T t);

    /**
     *
     * @param
     * @return
     */
    int limitResults(T t);
}
