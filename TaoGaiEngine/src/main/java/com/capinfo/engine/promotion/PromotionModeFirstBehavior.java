package com.capinfo.engine.promotion;

import com.capinfo.engine.data.TaoGaiPromotionSubset;
import com.capinfo.engine.dict.PromoteTimeConfing;
import com.capinfo.engine.taogai.TaoGaiType;
import com.capinfo.engine.utils.DateUtils;
import com.capinfo.engine.utils.entity.DateCount;
import com.capinfo.engine.utils.entity.YearsLimit;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

//true新职级，false老职级
/**
 * 每个数据都要存在一个套改信息 （不套改也要插入一条(所有的人都要晋升)）
 * 套改信息后必然有一个首次晋升机会
 *
 *
 */
//套改前职级是新的规则的，套改后职级是新的规则的，这条数据状态是套改，
//那么下一次晋升数据的状态必然是首次晋升，判断任职时间的时候需要考虑到套改的时间节点，
// 如果该人员的任职起始时间在套改节点之前，则需要清除掉套改时间节点之前的任职年限。
//    ZL1(true,true, PromotionType.TAOGAI_STATUS,PromotionType.FIRST_PROMOTION_STATUS),//职级任职时间在2019之前
// FIRST_PROMOTION_STATUS(1,"首次晋升"),


/**
 *  所有人员都需要 一次晋升
 */
 //   ZL3(false,true,PromotionType.TAOGAI_STATUS,PromotionType.FIRST_PROMOTION_STATUS),


/**
 *     /**
 *      *  领导职务，套改前套改后职级不变化，可能是一次晋升或者正常晋升
 *      */



public class PromotionModeFirstBehavior extends AbstractPromotionConditionBehavior  {


    /**
     *
     * //套改前职级是新的规则的，套改后职级是新的规则的，这条数据状态是套改，
     *     //那么下一次晋升数据的状态必然是首次晋升，判断任职时间的时候需要考虑到 政策实施的时间节点，
     *     // 如果该人员的任职起始时间在套改节点之前，则需要清除掉套改时间节点之前的任职年限。
     * ZL1(true,true, PromotionType.TAOGAI_STATUS,PromotionType.FIRST_PROMOTION_STATUS),//职级任职时间在2019之前
     *     /**
     *      *  不可能出现
        ZL3(false,true,PromotionType.TAOGAI_STATUS, PromotionType.FIRST_PROMOTION_STATUS),
             *     /**
      *      *  领导职务，套改前套改后职级不变化，可能是一次晋升或者正常晋升
        ZL4(false,false,PromotionType.TAOGAI_STATUS, PromotionType.FIRST_PROMOTION_STATUS),//？
     *
     *
     *
     * @return
     */
    @Override
    protected TaoGaiPromotionSubset needPromotionModeTypeJudge() {
        PromotionType type = PromotionType.conversionPromotionType(lastPromotionRank.getUpStatus());
        int month = 0;

        if (type!=null&&PromotionType.TAOGAI_STATUS==type){
            Date beforePostNowTime = lastPromotionRank.getBeforePostNowTime();
            Date taogaiDate = lastPromotionRank.getOperationTime();
            int result = 0;
            YearsLimit dateYearCount = super.getDateYearCount(beforePostNowTime, taogaiDate);
            int resultType = dateYearCount.getType();
            /**
             * 第一个位置是新职级，第二个位置也是新的职级  ，
             *       那么 计算任职年限 两种情况，第一种情况是   如果该人在套改时间之前的任职年限
             *                               第二种情况是
             */
            if (super.lastProduct.isBeforeNowOrOld() && super.lastProduct.isAfterNewOrOld()) {
                //套改之前的任职年
                lastPromotionRank.setRankTotalYearCount(getTypeToMonth(dateYearCount, resultType)+"");

            } else if (!super.lastProduct.isBeforeNowOrOld() && super.lastProduct.isAfterNewOrOld()) {
                //这条数据，旧职级，新职级  ==》套改
                if (StringUtils.isNotBlank(lastPromotionRank.getCountyUnderRank())) {
                    //县处级以下的人员
                    lastPromotionRank.setValidMonth(getResultToMonth2(dateYearCount, resultType));

                } else {
                    //县处级以上的人员和领导职务人员
                    lastPromotionRank.setValidMonth(getTypeToMonth(dateYearCount, resultType));

                }
            }
            /*else if (!super.lastProduct.isBeforeNowOrOld() && !super.lastProduct.isAfterNewOrOld()) {
                if (setNextPromote()) {
                    return null;
                }
            }*/
            /*if (setNextPromote()) {
                return null;
            }*/

        }
        if (StringUtils.isNotBlank(lastPromotionRank.getCountyUnderRank())) {
            month= totalPostLimit(lastPromotionRank.getNowRankTime());
        } else {
            month= totalPostLimit(lastPromotionRank.getBeforePostNowTime());
        }
        nextPromotionRank.setValidMonth(month);
        nextPromotionRank.setUpStatus(PromotionType.FIRST_PROMOTION_STATUS.getCode());
        List<PromoteTimeConfing> promoteTimeConfings = loadPromoteList(lastPromotionRank.getRankType());
        PromoteTimeConfing speculateRank = ladderPromotionRoute(promoteTimeConfings,lastPromotionRank);
        nextPromotionRank.setAfterRank(speculateRank.getZhgl());
        return nextPromotionRank;
    }











    private boolean setNextPromote() {
        Date beforePostNowTime = lastPromotionRank.getBeforePostNowTime();
        DateCount dateYearAndMonth = DateUtils.getDateYearAndMonth(beforePostNowTime);
        List<PromoteTimeConfing> promoteTimeConfings = loadPromoteList(lastPromotionRank.getRankType());
        PromoteTimeConfing speculateRank = ladderPromotionRoute(promoteTimeConfings,lastPromotionRank);
        int totalMonths = speculateRank.getNx()*12;
        int month = dateYearAndMonth.getMonth() + totalMonths;
        String yearMonth = dateYearAndMonth.getYear()+"" + month;
        //应该晋升的时间
        Date nextPromoteDate = DateUtils.parseDate(yearMonth);
        if (nextPromoteDate.before(lastProduct.getPromotionDateByInput())) {
            //符合晋升条件
            nextPromotionRank.setNowRankTime(nextPromoteDate);
            nextPromotionRank.setUpStatus(PromotionType.FIRST_PROMOTION_STATUS.getCode());
            TaoGaiType taoGaiType = judgeRank();
            switch (taoGaiType) {
                case GAI1:
                    nextPromotionRank.setNowYearCount("");
                    break;
                case GAI2:
                case GAI3:
                    nextPromotionRank.setNowYearCount((dateYearAndMonth.getYear()==0?"":(dateYearAndMonth.getYear()+"年"))+(dateYearAndMonth.getMonth()==0?"":(dateYearAndMonth.getMonth() + "月")));
                    break;
            }
            nextPromotionRank.setAfterRank(speculateRank.getZhgl());
        } else {
            return true;
        } return false;
    }


    @Override
    public int countServingLimit() {





        return 0;
    }


}
