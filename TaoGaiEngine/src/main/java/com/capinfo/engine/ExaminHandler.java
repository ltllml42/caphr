package com.capinfo.engine;

/**
 * 年度考核对任职年限的影响
 */
public class ExaminHandler<T> implements ServingLimitHandler<T>, Ledger {


    /**
     * 如果没有考核记录则不会进行判断
     * @param t
     * @return
     */
    @Override
    public boolean validate(T t) {
        return false;
    }

    /**
     * 考核子集判断
     *
     * @param
     * @return
     */
    @Override
    public int limitResults(T t) {
//        if (assessmentIndex.equals("优秀")) {
//            return 6;
//        } else if ("基本称职".equals(assessmentIndex)) {
//            return -12;
//        }
//        return 0;
        return 0;
    }

    /**
     * 用于记录台账信息
     *
     * @param msg
     * @return
     */
    @Override
    public TaoGaiLogger message(String level, Object... msg) {
        TaoGaiLogger logger =
                new TaoGaiLogger(level,
                        MessageUtils.showMessage(MessageEnum.LI_CODE_01.getMsg(), msg));
        return logger;
    }


}
