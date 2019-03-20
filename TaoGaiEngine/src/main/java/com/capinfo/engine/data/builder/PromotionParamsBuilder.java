package com.capinfo.engine.data.builder;


import com.capinfo.engine.data.AssessmentSubset;
import com.capinfo.engine.data.OriginalProduct;
import com.capinfo.engine.data.PostSubset;
import com.capinfo.engine.data.builder.DataParamsBuilder;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 晋升中所需要的构建对象
 */
public class PromotionParamsBuilder extends DataParamsAdapter {

    Logger logger  = Logger.getLogger("加载日志");//需要自己写

    @Override
    protected OriginalProduct buildBaseData(Map<String, String> baseData) {
        System.out.println("基本数据已经生成");
        return product;
    }

    @Override
    protected List<PostSubset> buildPostSubset(Map<String, String> postData) {
        System.out.println("加载完成");
        return null;
    }

    @Override
    protected List<AssessmentSubset> buildAssessmentSubsetList(Map<String, String> assessmentData) {
        System.out.println("加载子集");

        return null;
    }
}
