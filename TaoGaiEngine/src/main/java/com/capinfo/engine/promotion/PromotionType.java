package com.capinfo.engine.promotion;

/**
 *
 *
 *
 *
 *type=1     县处级以下职级，只晋升一次，晋升时间=当前时间-县处级以下职级的任职时间
 * 晋升时间>2年，满足晋升一级的时间，晋升一级。
 * 下次晋升时，晋升时间=当前时间-上次晋升时间
 *
 *type=2    非领导职务 \n
 *       首次晋升===》   任职年限=当前时间-套改前职务层次时间  \n
 *       二次晋升===》   任职年限=当前时间-套改前职务层次时间-首次晋升用时年限（规则中规定的首次晋升时这个职级应该用掉的时间）\n
 *       再次晋升===》   任职年限=当前时间-上次晋升时间 \n
 *
 *type=3   领导职务  \n
 *      首次晋升===》   任职年限=当前时间-任现职务层次时间  \n
 *      二次晋升===》   任职年限=当前时间-任现职务层次时间-首次晋升用时年限（规则中规定的首次晋升时这个职级应该用掉的时间） \n
 *      再次晋升===》   任职年限=当前时间-上次晋升时间 \n
 *
 *
 *
 * 人员晋升对象
 */
public enum PromotionType {

    TAOGAI_STATUS(0,"套改"),
    FIRST_PROMOTION_STATUS(1,"首次晋升"),
    SECOND_PROMOTION_STATUS(2,"二次晋升"),
    NORMAL_PROMOTION_STATUS(3,"正常晋升"),
    ERROR_STATUS(4,"不存在");
    //UNCERTAIN_STATUS(5,"不确定状态");//可能是二次晋升或正常晋升
    ;

    private PromotionType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static PromotionType conversionPromotionType(int type){
        for (PromotionType promotionType : PromotionType.values()) {
            if (promotionType.code == type){
                return promotionType;
            }
        }
        return null;
    }


}
