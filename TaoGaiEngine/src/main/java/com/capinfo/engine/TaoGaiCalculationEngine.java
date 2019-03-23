package com.capinfo.engine;

import com.capinfo.engine.adapter.IntelligenceCalculationEngineAdapter;
import com.capinfo.engine.data.builder.DataParamsBuilder;
import com.capinfo.engine.data.builder.DataParamsDirector;
import com.capinfo.engine.message.MessageCode;
import com.capinfo.engine.message.MessageEnum;
import com.capinfo.engine.taogai.TaoGaiTypeBehavior;
import com.capinfo.engine.taogai.factory.TaoGaiBehaviorFactory;
import com.capinfo.engine.utils.MessageUtils;

import java.util.List;
import java.util.Map;

/**
 * 执行套改
 *
 * @param <OriginalProduct>
 */
public class TaoGaiCalculationEngine<OriginalProduct> extends IntelligenceCalculationEngineAdapter<OriginalProduct> {

    public TaoGaiCalculationEngine(OriginalProduct product){
        super.product = product;
    }

    /**
     *
     * @param builder 选择使用哪种Builder
     * @param baseData 人员基础信息
     * @param postData 获取职务信息
     * @param assessmentData 考核信息
     */
    public TaoGaiCalculationEngine(DataParamsBuilder builder,
                                   Map<String, String> baseData,
                                   Map<String, String> postData,
                                   Map<String, String> assessmentData) {
        DataParamsDirector director = new DataParamsDirector(builder);
        super.product = (OriginalProduct) director.construct(baseData, postData, assessmentData);
    }

    public TaoGaiCalculationEngine(DataParamsBuilder builder,
                                   Map<String, String> baseData) {
        DataParamsDirector director = new DataParamsDirector(builder);
        super.product = (OriginalProduct)director.construct(baseData, null, null);
    }

    public TaoGaiCalculationEngine(DataParamsBuilder builder,
                                   Map<String, String> baseData, Map<String, String> postData) {
        DataParamsDirector director = new DataParamsDirector(builder);
        super.product = (OriginalProduct)director.construct(baseData, postData, null);
    }




    /**
     * 可以抽出一个Config类
     * 写套改的业务逻辑
     * @throws Exception
     */
    @Override
    protected void execTaoGai(TaoGaiTypeBehavior taoGaiTypeBehavior) throws Exception {

            if(super.product==null){
                throw new Exception(MessageUtils.showMessage(MessageEnum.LI_CODE_01));
            }
            super.taoGaiTypeBehavior = taoGaiTypeBehavior;
            super.taoGaiConditionBehavior =
                    TaoGaiBehaviorFactory.newFactory(taoGaiTypeBehavior.judgementType(product));
            taoGaiTypeBehavior.getVersion();//套改方案
            List<MessageCode> codeList = taoGaiConditionBehavior.validate(super.product);
            if (codeList==null||codeList.isEmpty()){
                //就是我想要的参数
                /*taoGaiConditionBehavior.execute(super.product);*/
            }else{
                //需要补充 List<MessageCode>
                throw new Exception();
            }

    }
}
