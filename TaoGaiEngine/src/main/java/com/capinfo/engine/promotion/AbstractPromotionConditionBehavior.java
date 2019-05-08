package com.capinfo.engine.promotion;

import com.capinfo.engine.data.*;
import com.capinfo.engine.dict.PromoteTimeConfing;
import com.capinfo.engine.message.MessageCode;
import com.capinfo.engine.taogai.TaoGaiType;
import com.capinfo.engine.utils.DateUtils;
import com.capinfo.engine.utils.entity.DateAddEntity;
import com.capinfo.engine.utils.entity.YearsLimit;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

/**
 * 名言警句
 *
 * 烂程序员关心的是代码。好程序员关心的是数据结构和它们之间的关系。---Torvalds Liunx之父
 */
public abstract class AbstractPromotionConditionBehavior implements PromotionConditionBehavior<OriginalProduct>{



    protected List<PromotionLedger> ledgerList = new ArrayList<PromotionLedger>();
    /**
     * 上一次晋升情况和相关的记录
     */
    protected OriginalProduct lastProduct;
    /**
     * 上次晋级或者套改的数据
     */
    protected TaoGaiPromotionSubset lastPromotionRank;


    /**
     *  下次晋升的数据准备
     */
    protected TaoGaiPromotionSubset nextPromotionRank;

    @Override
    public VersionInfo getVersion() {
        return VersionInfo.VERSION_2019;
    }

    @Override
    public void process() {


        List<PromoteTimeConfing> promoteTimeConfings = loadPromoteList(lastPromotionRank.getRankType());
        //确认要晋升的上级  根据promoteTimeConfings 这个List，得到
        PromoteTimeConfing speculateRank = ladderPromotionRoute(promoteTimeConfings,lastPromotionRank);
        int totalMonths = speculateRank.getNx()*12;
        int rankTotalYearCount = 0;
        //是否符合晋升条件  totalMonths  累计任职年限 rankTotalYearCount 月份
        boolean judgeIsOk = judgeIsOk(totalMonths,rankTotalYearCount);
        











        //TODO:validate(); 开起来
        nextPromotionRank = new TaoGaiPromotionSubset();
		//nextPromotionRank.setId()
		nextPromotionRank.setSid(lastPromotionRank.getSid());
        //nextPromotionRank.setA02Id("");
		nextPromotionRank.setBeforeRank(lastPromotionRank.getAfterRank());
        /**
         * 小栋说：一直存留
         */
		nextPromotionRank.setCountyUnderRank(lastPromotionRank.getCountyUnderRank());
        nextPromotionRank.setCountyUnderNowRankTime(lastPromotionRank.getCountyUnderNowRankTime());

        nextPromotionRank.setNowReferenceNumber(lastProduct.getNowReferenceNumber());
        /**
         * 套改过后， 职务层级永远不变。   政策问题还未定
         */
		nextPromotionRank.setBeforePost(lastPromotionRank.getBeforePost());
        /**
         * 套改过后， 职务层级永远不变。   政策问题还未定
         */
		nextPromotionRank.setBeforePostCate(lastPromotionRank.getBeforePostCate());
        /**
         * 套改过后， 一直都不变。
         */
		nextPromotionRank.setBeforeLevels(lastPromotionRank.getBeforeLevels());
        /**
         * 目前我们假定，套改后不存在这个属性了（或者可能会有新的判定方式）。 未定
         */
		nextPromotionRank.setLeader(lastPromotionRank.isLeader());

        /**
         *  目前为在任状态  是死的。
         */
		nextPromotionRank.setRankNowStatus("1");

        /**
         * 套改就是套改时间，晋升就是晋升时间
         */
		nextPromotionRank.setOperationTime(lastProduct.getOperationTime());
        /**
         * 套改前任现职务层次时间 对应 上一条数据中的套改时间（手动填写）
         */
        nextPromotionRank.setBeforePostNowTime(lastPromotionRank.getOperationTime());


        nextPromotionRank = needPromotionModeTypeJudge();

        /**
         * 累计任职年限
         */
        //nextPromotionRank.setRankTotalYearCount();


        nextPromotionRank.setLedgerList(ledgerList);
    }

    protected boolean judgeIsOk(int totalMonths, int rankTotalYearCount){
        //总任职年限的话
        return (totalMonths-countServingLimit()-countAssessConverLimit(lastProduct.getAssessmentSubsetList()))>0?true:false;
    }


    protected int totalPostLimit(Date rankServingDate){
        Date nowDate = lastProduct.getPromotionDateByInput();
        DateAddEntity completeTaogaiDate = DateUtils.getDateDif(rankServingDate, lastProduct.getPromotionDateByInput());
        return completeTaogaiDate.getMonthNum();
    }


    protected YearsLimit getDateYearCount(Date rankServingDate, Date taogaiDate) {



        YearsLimit limit = new YearsLimit();
        Date nowDate = lastProduct.getPromotionDateByInput();
        if (taogaiDate == null) {
            taogaiDate = DateUtils.parseDate((VersionInfo.VERSION_2019.getYear()+""+VersionInfo.VERSION_2019.getMonth()+""));
        }
        /*if (nowDate == null) {
            nowDate = new Date();

        }*/
        //需要判断晋升截止时间是否输入。如果没有输入则按当前时间并且记入日志
        DateAddEntity completeTaogaiDate = DateUtils.getDateDif(taogaiDate, nowDate);
        int monthNum = completeTaogaiDate.getMonthNum();
        //为正表示填写的套改时间在当前时间之前，为负表示套改时间在当前时间之后（不做处理）
        limit.setAfterTaoGaiDateLimitMonth(monthNum);
        DateAddEntity completeRankServingDate = DateUtils.getDateDif(rankServingDate, taogaiDate);
        //为正表示填写的套改时间在职级任职时间之后。为负表示套改时间在职级时间之前（不做处理）
        int rankServingMonthNum = completeRankServingDate.getMonthNum();
        limit.setBeforeTaoGaiDateLimitMonth(rankServingMonthNum);
        return limit;
    }



    /**
     *
     * @param promoteTimeConfings
     * @param lastPromotionRank
     * @return
     */
    protected PromoteTimeConfing ladderPromotionRoute(List<PromoteTimeConfing> promoteTimeConfings, TaoGaiPromotionSubset lastPromotionRank,String name) {
        name = "本次晋升";
        boolean flag = OriginalProduct.isNewOrOldRank(lastPromotionRank.getAfterRank(),lastPromotionRank.getAfterLevels());
        for (PromoteTimeConfing promoteTimeConfing : promoteTimeConfings) {
            if(flag){
                if(lastPromotionRank.getAfterRank().equals(promoteTimeConfing.getZhgl()))
                    return promoteTimeConfing;
            }else{
                if(StringUtils.isNotBlank(lastPromotionRank.getAfterRank())){
                    if(lastPromotionRank.getAfterRank().equals(promoteTimeConfing.getGwy()))
                        return promoteTimeConfing;
                }else{
                    if(lastPromotionRank.getAfterRank().equals(promoteTimeConfing.getZj()))
                        return promoteTimeConfing;

                };
            }
        }
        return null;
    }


    protected PromoteTimeConfing ladderPromotionRoute(List<PromoteTimeConfing> promoteTimeConfings, TaoGaiPromotionSubset lastPromotionRank) {
        PromoteTimeConfing lastRank = ladderPromotionRoute(promoteTimeConfings,lastPromotionRank,"");
        if(lastRank==null) throw new RuntimeException("我日");
        for (PromoteTimeConfing promoteTimeConfing : promoteTimeConfings) {
            if(StringUtils.isNotBlank(lastRank.getPid())){
                if(promoteTimeConfing.getId().equals(lastRank.getPid())){
                    return promoteTimeConfing;
                }
            }else{
                return null;
            }
        }
        throw new RuntimeException("我日");
    }


    /**
     * 判断是县以下职级还是县以上职级非领导还是领导，
     * 然后用这个玩意判断他在一次晋升后该是二次晋升还是正常晋升
     * @return
     */
    protected TaoGaiType judgeRank() {

        if (lastPromotionRank.isLeader()) {
            return TaoGaiType.GAI2;
        }
        if (StringUtils.isNotBlank(lastPromotionRank.getCountyUnderRank())) {
            return TaoGaiType.GAI1;
        }

        return TaoGaiType.GAI3;
    }



    /**
     *  需要进行判断的内容
     * @return
     */
    protected abstract TaoGaiPromotionSubset needPromotionModeTypeJudge();

    /**
     * 任职年限的方法
     * @return
     */
    public abstract int countServingLimit();

    /**
     * 需要读取考核配置表
     *
     * @param
     * @return
     */
    public int countAssessConverLimit(List<AssessmentSubset> assessmentSubsetList) {
        int count = 0;
        for (AssessmentSubset assessmentSubset : assessmentSubsetList) {
            if("1".equals(assessmentSubset.getExamResults())){
                count+=showAssessConfig(assessmentSubset.getExamResults());
            };
        }
        return count;
    }

    /**
     * 韩王栋提供考核配置表信息
     * @param examResults
     * @return
     */
    private int showAssessConfig(String examResults) {
        return 6;
    }


    //获取字典
    public List<PromoteTimeConfing> loadPromoteList(int rankType){
        //originalProduct.getPromotionHisList();
        return new ArrayList<PromoteTimeConfing>();
    };


    @Override
    public MessageCode validate(OriginalProduct data) {

        Stack<TaoGaiPromotionSubset> promotionHisList = data.getPromotionHisList();

        if (promotionHisList==null||promotionHisList.isEmpty()){
            Stack<TaoGaiPromotionSubset> taoGaiHisList = data.getTaoGaiHisList();
            if (taoGaiHisList==null||taoGaiHisList.isEmpty()){
                throw new RuntimeException("我日");
            }
            this.lastPromotionRank = taoGaiHisList.peek();
        }else{
            this.lastPromotionRank =promotionHisList.peek();
        }



        return null;
    }


    /**
     * 输出预测的晋升情况
     * @return
     */
    public TaoGaiPromotionSubset result(){
        return nextPromotionRank;
    }


    public void setLastProduct(OriginalProduct lastProduct) {
        this.lastProduct = lastProduct;
    }




    protected int getResultToMonth2(YearsLimit dateYearCount, int resultType) {
        int result;
        switch (resultType) {
            case 1:
                result = dateYearCount.getAfterTaoGaiDateLimitMonth();
                break;
            case 2:
                result = dateYearCount.getAfterTaoGaiDateLimitMonth();
                break;
            case 3:
                throw new RuntimeException("套改时间与任职时间有误");
            case 4:
                throw new RuntimeException("输入时间有误");
            default:
                throw new RuntimeException("输入时间有误");
        }
        return result;
    }

    protected int getTypeToMonth(YearsLimit dateYearCount, int resultType) {
        int result;
        switch (resultType) {
            case 1:
                result = dateYearCount.getAfterTaoGaiDateLimitMonth() + dateYearCount.getBeforeTaoGaiDateLimitMonth();
                break;
            case 2:
                result = dateYearCount.getAfterTaoGaiDateLimitMonth();
            case 3:
                throw new RuntimeException("套改时间与任职时间有误");
            case 4:
                throw new RuntimeException("输入时间有误");
            default:
                throw new RuntimeException("输入时间有误");
        }
        return result;
    }



}
