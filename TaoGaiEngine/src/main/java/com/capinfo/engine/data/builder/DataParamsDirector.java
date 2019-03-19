package com.capinfo.engine.data.builder;

import com.capinfo.engine.data.OriginalProduct;

import java.util.Map;

public class DataParamsDirector {

    private DataParamsBuilder builder;

    public DataParamsDirector(DataParamsBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(DataParamsBuilder builder)
    {
        this.builder=builder;
    }

    /**
     * 需要提供基础信息集的数据
     * @param baseData
     * @param postData
     * @param assessmentData
     * @return
     */
    public OriginalProduct construct(Map<String,String> baseData, Map<String,String> postData, Map<String,String> assessmentData)
    {
        OriginalProduct product = builder.getReturns();
        if(builder.isDataNull(baseData))
            builder.buildBaseData(baseData);
        if(builder.isDataNull(postData))
            product.setPostSubsetList(builder.buildPostSubset(postData));
        if(builder.isDataNull(assessmentData))
            product.setAssessmentSubsetList(builder.buildAssessmentSubsetList(assessmentData));
        //可以自己添加需要的构造方法
        return product;
    }


}
