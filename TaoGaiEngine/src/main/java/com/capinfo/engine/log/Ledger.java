package com.capinfo.engine.log;

import com.capinfo.engine.TaoGaiLogger;

/**
 * 如果需要记录台账则需要实现这个接口
 *
 * | 转  换  符 | 说    明                                    | 示    例     |
 * | ---------- | ------------------------------------------- | ------------ |
 * | %s         | 字符串类型                                  | "mingrisoft" |
 * | %c         | 字符类型                                    | 'm'          |
 * | %b         | 布尔类型                                    | true         |
 * | %d         | 整数类型（十进制）                          | 99           |
 * | %x         | 整数类型（十六进制）                        | FF           |
 * | %o         | 整数类型（八进制）                          | 77           |
 * | %f         | 浮点类型                                    | 99.99        |
 * | %a         | 十六进制浮点类型                            | FF.35AE      |
 * | %e         | 指数类型                                    | 9.38e+5      |
 * | %g         | 通用浮点类型（f和e类型中较短的）            |              |
 * | %h         | 散列码                                      |              |
 * | %%         | 百分比类型                                  | ％           |
 * | %n         | 换行符                                      |              |
 * | %tx        | 日期与时间类型（x代表不同的日期与时间转换符 |              |
 *
 *
 */
public interface Ledger {

    /**
     * DEBUG级别
     */
    public static final String DEBUG ="DEBUG";
    /**
     * 错误级别
     */
    public static final String ERROR = "ERROR";
    /**
     * INFO
     */
    public static final String INFO = "INFO";
    /**
     * 台账主记录，记录晋升的时候必须要加入这个信息
     */
    public static final String MAIN = "MAIN";



    /**
     * 记录台账  recordLedger
     * @return
     */
    TaoGaiLogger message(String level, Object... msg);

}
