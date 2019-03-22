package com.capinfo.engine.promotion.handle;

import com.capinfo.engine.data.AssessmentSubset;
import com.capinfo.engine.data.DictBean;
import com.capinfo.engine.data.OriginalProduct;
import com.capinfo.engine.dict.CheckPostConfig;
import com.capinfo.engine.message.MessageEnum;
import com.capinfo.engine.promotion.PromotionType;
import com.capinfo.engine.utils.MessageUtils;
import com.capinfo.engine.TaoGaiLogger;
import com.capinfo.engine.log.Ledger;
import com.capinfo.engine.utils.MockDictUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 年度考核对任职年限的影响
 */
public class ExaminHandler extends ServingLimitHandler implements Ledger {


    private List<DictBean> dictList = new ArrayList<DictBean>();

    private List<AssessmentSubset> assessmentSubsets = new ArrayList<AssessmentSubset>();

    @Override
    public TaoGaiLogger message(String level, Object... msg) {
        return null;
    }

    @Override
    public boolean validate() {
        this.dictList= this.loadDict(dictList);
        boolean flag = super.validate();
        List<AssessmentSubset> subset = product.getAssessmentSubsetList();
        if (subset == null||subset.isEmpty()) {
            flag = false;
        }
        if(dictList==null||dictList.isEmpty()){
            flag = false;
        }
        return flag;
    }

    @Override
    public void handleRequest(PromotionType type) {
        for (Object o : dictList) {
            if(!(o instanceof CheckPostConfig)){
                throw new ClassCastException(MessageUtils.showMessage(MessageEnum.ERROR_CODE_CASE,o.getClass(),CheckPostConfig.class));
            }
        }
        if(validate()){
            this.next().handleRequest(type);
        }

        for (AssessmentSubset assessmentSubset : assessmentSubsets) {
             if("2018".equals(assessmentSubset.getYear())&&"优秀".equals(assessmentSubset.getExamResults())){
                 servingLimit += 6;
             }
             servingLimit -= 0;
             this.next().handleRequest(type);
        }
    }

    @Override
    public List loadDict(List dictList) {
        return MockDictUtils.mockDict("字典表参数");
    }
}
