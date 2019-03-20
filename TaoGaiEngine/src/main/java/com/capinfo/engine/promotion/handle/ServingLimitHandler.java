package com.capinfo.engine.promotion.handle;

public abstract class ServingLimitHandler<T> {

    public volatile int servingLimit;

    protected ServingLimitHandler next;

    public abstract void handleRequest(T t);













}
