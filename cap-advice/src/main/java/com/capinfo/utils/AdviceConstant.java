package com.capinfo.utils;

public class AdviceConstant {

    /**
     * 手机端提交意见时候默认使用这个用户id
     */
    public static final String TSUSER_ID = "174290fde5c742e1b346ce9fe39caf0c";

    /**
     * 举报类型     1：实名举报
     */
    public static final String PROBLEM_TYPE_REAL = "1";
    /**
     * 举报类型     2：匿名举报
     */
    public static final String PROBLEM_TYPE_HIDE = "2";

    /**
     * 意见状态     1：处理中
     */
    public static final String ADVICE_STATUS_DEAL = "1";
    /**
     * 意见状态     2：已结案   举报问题结案时候用到
     */
    public static final String ADVICE_STATUS_FINISH = "2";
    /**
     * 意见状态     3：已回复   意见建议结案时候用到
     */
    public static final String ADVICE_STATUS_REPLY = "3";

}
