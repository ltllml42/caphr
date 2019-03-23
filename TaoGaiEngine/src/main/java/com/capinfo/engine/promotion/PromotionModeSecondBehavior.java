package com.capinfo.engine.promotion;

import com.capinfo.engine.data.OriginalProduct;
import com.capinfo.engine.data.TaoGaiPromotionSubset;
import com.capinfo.engine.data.VersionInfo;
import com.capinfo.engine.dict.PromoteTimeConfing;
import com.capinfo.engine.message.MessageCode;
import com.capinfo.engine.taogai.TaoGaiType;
import com.capinfo.engine.utils.DateUtils;
import com.capinfo.engine.utils.entity.DateAddEntity;
import com.capinfo.engine.utils.entity.DateCount;
import com.capinfo.engine.utils.entity.YearsLimit;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 *
 * /**
 *      *  二次晋升或正常晋升
 *      *
 *      *  是否第二次晋升，还是还是正常晋升 以套改时间作为节点进行计算。
 *      *     二次晋升， 在套改时间之前还有剩余年限的时候  我们判断为二次晋升，并且达到 晋升要求
 *      *     正常晋升， 在套改时间之前已经没有年限或者年限到不到套改时间的则正常晋升( 套改年限前的数据要进行累计)

 *ZL5(true,true,PromotionType.FIRST_PROMOTION_STATUS,PromotionType.UNCERTAIN_STATUS),//
         *ZL6(true,false,PromotionType.FIRST_PROMOTION_STATUS,PromotionType.ERROR_STATUS),
         *
  *      * 领导 ， 套改前的时间+套改后的时间到现在 ，如果符合二次晋升的条件（晋级年限） 就晋升。
  *      *        如果晋升后的时间在套改之后，则为正常晋升。
         *ZL7(false,true,PromotionType.FIRST_PROMOTION_STATUS,PromotionType.UNCERTAIN_STATUS),//领导职务，有过第一次晋升

         *ZL8(false,false,PromotionType.FIRST_PROMOTION_STATUS,PromotionType.ERROR_STATUS),//
 *
 */


public class PromotionModeSecondBehavior extends AbstractPromotionConditionBehavior{

    @Override
    protected TaoGaiPromotionSubset needPromotionModeTypeJudge() {

        PromotionType type = PromotionType.conversionPromotionType(lastPromotionRank.getUpStatus());
        int month = 0;

        if (type!=null&&PromotionType.FIRST_PROMOTION_STATUS==type){
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
                    lastPromotionRank.setRankTotalYearCount(getResultToMonth2(dateYearCount, resultType)+"");

                } else {
                    //县处级以上的人员和领导职务人员
                    lastPromotionRank.setRankTotalYearCount(getTypeToMonth(dateYearCount, resultType)+"");

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
        //县以下人员，一次晋升之后正常晋升
        if (StringUtils.isNotBlank(lastPromotionRank.getCountyUnderRank())) {
            month= totalPostLimit(lastPromotionRank.getNowRankTime());
            nextPromotionRank.setUpStatus(PromotionType.NORMAL_PROMOTION_STATUS.getCode());
        } else {
            //不是县以下人员，一次晋升之后正常晋升
            month= totalPostLimit(lastPromotionRank.getBeforePostNowTime());
            nextPromotionRank.setUpStatus(PromotionType.SECOND_PROMOTION_STATUS.getCode());
        }
        nextPromotionRank.setRankTotalYearCount(month+"");
        List<PromoteTimeConfing> promoteTimeConfings = loadPromoteList(lastPromotionRank.getRankType());
        PromoteTimeConfing speculateRank = ladderPromotionRoute(promoteTimeConfings,lastPromotionRank);
        nextPromotionRank.setAfterRank(speculateRank.getZhgl());

        Date operationTime = lastPromotionRank.getOperationTime();
        DateCount dateYearAndMonth = DateUtils.getDateYearAndMonth(operationTime);
        String str = dateYearAndMonth.getYear()+""+(dateYearAndMonth.getMonth()+speculateRank.getNx()*12);
        nextPromotionRank.setNextPromoteDate(DateUtils.parseDate(str));
        return nextPromotionRank;
    }

    @Override
    public int countServingLimit() {

        PromotionType type = PromotionType.conversionPromotionType(lastPromotionRank.getUpStatus());
        if (type!=null&&PromotionType.FIRST_PROMOTION_STATUS==type){

            /*if ((super.lastProduct.isBeforeNowOrOld() && super.lastProduct.isAfterNewOrOld())
                    ||(!super.lastProduct.isBeforeNowOrOld() && super.lastProduct.isAfterNewOrOld())) {
                //二次晋升。这里计算晋升年月
                TaoGaiType taoGaiType = judgeRank();
                switch (taoGaiType) {
                    case GAI1:
                        *//**
                         * 县处级以下没有二级晋升
                         *//*
                        return null;
                    case GAI2:
                    case GAI3:
                        //套改前职务层次任职时间
                        Date beforePostNowTime = lastPromotionRank.getBeforePostNowTime();

                        //页面上输入的晋升截止时间
                        Date promotionDateByInput = lastProduct.getPromotionDateByInput();
                        //首次晋升用时年限（规则中规定的首次晋升时这）
                        List<PromoteTimeConfing> promoteTimeConfings = loadPromoteList(lastPromotionRank.getRankType());
                        //确认要晋升的上级  根据promoteTimeConfings 这个List，得到
                        PromoteTimeConfing speculateRank = ladderPromotionRoute(promoteTimeConfings,lastPromotionRank,"");
                        //获取一次晋升 所需要的年限
                        int totalMonths = speculateRank.getNx()*12;
                        //获取从套改前任现职务层次时间到截止时间总共的有多少年限
                        DateAddEntity dateDif = DateUtils.getDateDif(beforePostNowTime, promotionDateByInput);
                        //获取二次晋升所需要的年限
                        PromoteTimeConfing promoteTimeConfing = ladderPromotionRoute(promoteTimeConfings, lastPromotionRank);
                        int needNextPromMonths = promoteTimeConfing.getNx()*12;
                        //将一次晋升时间专程年 月
                        DateCount dateYearAndMonth = DateUtils.getDateYearAndMonth(lastPromotionRank.getOperationTime());
                        int year = dateYearAndMonth.getYear();
                        int month = dateYearAndMonth.getMonth() + needNextPromMonths;
                        //预测二次晋升的时间
                        Date nextPromoteTime = DateUtils.parseDate(year + "" + month);
                        //判断二次晋升时间是否在输入的截止时间之前，如果是就可以晋升
                        if(nextPromoteTime.before(promotionDateByInput)){
                            //符合晋升条件
                            nextPromotionRank.setNowRankTime(nextPromoteTime);
                            nextPromotionRank.setUpStatus(PromotionType.SECOND_PROMOTION_STATUS.getCode());
                            //页面上展示  一次晋升后剩余的年限
                            int freeMonths = dateDif.getMonthNum() - needNextPromMonths;
                            int freeYear = freeMonths/12;
                            int freeMonth = freeMonths%12;
                            nextPromotionRank.setNowYearCount((freeYear==0?"":(freeYear+"年"))+(freeMonth==0?"":(freeMonth + "月")));
                            nextPromotionRank.setAfterRank(speculateRank.getZhgl());
                            System.out.println("可以晋升");
                        }else{
                            System.out.println("不可以晋升");
                        }
                        break;
                }

                return nextPromotionRank;
            }*/

        }
        return 0;
    }






}
