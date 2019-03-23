package com.capinfo.engine.data;

import com.capinfo.engine.promotion.PromotionType;
import com.capinfo.engine.utils.MockDictUtils;

import java.util.Map;

/**
 * 晋升后，职级肯定是新职级
 * 职级到顶后不再晋升（厅局级正职领导职务不晋升不套改，非领导职务套改不再晋升）
 * 套改后新入人员如何晋级
 *
 *
 *
 *
 *      TAOGAI_STATUS(0,"套改"),
 *     FIRST_PROMOTION_STATUS(1,"首次晋升"),
 *     SECOND_PROMOTION_STATUS(2,"二次晋升"),
 *     NORMAL_PROMOTION_STATUS(3,"正常晋升"),
 *     ERROR_STATUS(4,"不存在"),
 *     UNCERTAIN_STATUS(5,"不确定状态");//可能是二次晋升或正常晋升
 */
public enum TrueTable {
    //true新职级，false老职级
    //最后一条数据的职级====倒数第二条数据的职级====最后一条数据的状态====下一次晋升的晋升情况，应该如何晋升
    /**
     * 每个数据都要存在一个套改信息 （不套改也要插入一条(所有的人都要晋升)）
     * 套改信息后必然有一个首次晋升机会
     *
     *
     */
    //套改前职级是新的规则的，套改后职级是新的规则的，这条数据状态是套改，
    //那么下一次晋升数据的状态必然是首次晋升，判断任职时间的时候需要考虑到套改的时间节点，
    // 如果该人员的任职起始时间在套改节点之前，则需要清除掉套改时间节点之前的任职年限。
    ZL1(true,true, PromotionType.TAOGAI_STATUS,PromotionType.FIRST_PROMOTION_STATUS),//职级任职时间在2019之前
    /**
     *  不可能出现
     */
    ZL2(true,false,PromotionType.TAOGAI_STATUS,PromotionType.ERROR_STATUS),


    /**
     *  所有人员都需要 一次晋升
     */
    ZL3(false,true,PromotionType.TAOGAI_STATUS,PromotionType.FIRST_PROMOTION_STATUS),

    /**
     *  领导职务，套改前套改后职级不变化，可能是一次晋升或者正常晋升
     */
    ZL4(false,false,PromotionType.TAOGAI_STATUS,PromotionType.FIRST_PROMOTION_STATUS),//？


    //要清除掉套改年限之间的任职年限

    /**
     *  二次晋升或正常晋升
     *
     *  是否第二次晋升，还是还是正常晋升 以套改时间作为节点进行计算。
     *     二次晋升， 在套改时间之前还有剩余年限的时候  我们判断为二次晋升，并且达到 晋升要求
     *     正常晋升， 在套改时间之前已经没有年限或者年限到不到套改时间的则正常晋升( 套改年限前的数据要进行累计)
     *
     *
     *
     */
    ZL5(true,true,PromotionType.FIRST_PROMOTION_STATUS,PromotionType.SECOND_PROMOTION_STATUS),//


    /**
     *
     */
    ZL6(true,false,PromotionType.FIRST_PROMOTION_STATUS,PromotionType.ERROR_STATUS),
    /**
     * 领导 ， 套改前的时间+套改后的时间到现在 ，如果符合二次晋升的条件（晋级年限） 就晋升。
     *        如果晋升后的时间在套改之后，则为正常晋升。
     *
     */
    ZL7(false,true,PromotionType.FIRST_PROMOTION_STATUS,PromotionType.SECOND_PROMOTION_STATUS),//领导职务，有过第一次晋升
    /**
     *
     */
    ZL8(false,false,PromotionType.FIRST_PROMOTION_STATUS,PromotionType.ERROR_STATUS),//
    /**
     *
     */
    ZL9(true,true,PromotionType.SECOND_PROMOTION_STATUS,PromotionType.NORMAL_PROMOTION_STATUS),//下次晋升为正常晋升
    /**
     *
     */
    ZL10(true,false,PromotionType.SECOND_PROMOTION_STATUS,PromotionType.ERROR_STATUS),//不存在
    /**
     *
     */
    ZL11(false,true,PromotionType.SECOND_PROMOTION_STATUS,PromotionType.ERROR_STATUS),//
    /**
     * 小栋说: 如果该人员 在套改前的时间段里需要进行二次晋级，
     *        不管第一次晋级后的时间是否在套改前还是套改后统一变为新职级
     */
    ZL12(false,false,PromotionType.SECOND_PROMOTION_STATUS,PromotionType.ERROR_STATUS),//不可能是出现二次晋升
    /**
     *
     */
    ZL13(true,true,PromotionType.NORMAL_PROMOTION_STATUS,PromotionType.NORMAL_PROMOTION_STATUS),//正常晋升
    ZL14(true,false,PromotionType.NORMAL_PROMOTION_STATUS,PromotionType.ERROR_STATUS),
    ZL15(false,true,PromotionType.NORMAL_PROMOTION_STATUS,PromotionType.ERROR_STATUS),
    ZL16(false,false,PromotionType.NORMAL_PROMOTION_STATUS,PromotionType.ERROR_STATUS),
    ;


    /**
     * 晋升前是否为新晋级的职务层级
     */
    private boolean beforeX;

    /**
     * 晋升后是否为新晋级的职务层级
     */
    private boolean afterY;
    /**
     *         TAOGAI_STATUS(0,"套改"),
     *         FIRST_PROMOTION_STATUS(1,"首次晋升"),
     *         SECOND_PROMOTION_STATUS(2,"二次晋升"),
     *         NORMAL_PROMOTION_STATUS(3,"正常晋升"),
     */
    private PromotionType upStatus;

    private PromotionType nextUpStatus;

    private TrueTable(boolean beforeX, boolean afterY, PromotionType upStatus,PromotionType nextUpStatus) {
        this.beforeX = beforeX;
        this.afterY = afterY;
        this.upStatus = upStatus;
        this.nextUpStatus = nextUpStatus;
    }

    //如何判断是新的职级还是旧的职级

    //PromotionType
    public static TrueTable conversionTrueTable(boolean beforeX, boolean afterY, int upStatus){
        PromotionType upStatusType = PromotionType.conversionPromotionType(upStatus);
        for (TrueTable table : TrueTable.values()) {
            if (table.beforeX == beforeX && table.afterY == afterY && upStatusType.getCode()== upStatus){
                return table;
            }
        }
        return null;
    }


    public PromotionType getNextUpStatus() {
        return nextUpStatus;
    }
}




