package com.capinfo.engine.data.builder;

import com.capinfo.engine.data.OriginalProduct;
import com.capinfo.engine.data.AssessmentSubset;
import com.capinfo.engine.data.PostRanks;
import com.capinfo.engine.data.PostSubset;

import java.util.List;
import java.util.Map;

/**
 * 组装晋升所需要用到的数据对象
 */
public abstract class DataParamsBuilder {
    /**
     * 产品送上
     */
    protected OriginalProduct product = new OriginalProduct();

    protected  Map<String,String> baseData;

    protected Map<String,String> postData;

    protected Map<String,String> assessmentData;

    /**
     * 获取RS_A01表中的数据
     * @param baseData
     * @return OriginalProduct
     */
    protected abstract OriginalProduct buildBaseData(Map<String,String> baseData);

    /**
     * 获取 职务子集信息
     * @param postData
     * @return List<PostSubset>
     */
    protected abstract List<PostSubset> buildPostSubset(Map<String,String> postData);


    /**
     * 获取考核信息子集
     * @param assessmentData
     * @return List<AssessmentSubset>
     */
    protected abstract  List<AssessmentSubset> buildAssessmentSubsetList(Map<String,String> assessmentData);



    protected abstract  List<PostRanks> buildPostSubsetList(Map<String,String> postSubsetData);


    protected abstract  List<PostRanks> buildRanksSubsetList(Map<String,String> ranksSubsetData);



    /**
     * 返回装配结果
     *  自己根据需求可以增加，调用方式
     *  OriginalProduct product = super.getReturns()
     *  增加自己子类的Returns
     *
     * @return
     */
    public OriginalProduct getReturns(){
        return product;
    }

    protected boolean isDataNull(Map<String,String> map){
        if(map!=null&&!map.isEmpty()){
            return true;
        }
        return false;
    }

}
