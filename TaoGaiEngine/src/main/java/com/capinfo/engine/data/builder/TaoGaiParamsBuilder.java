package com.capinfo.engine.data.builder;

import com.capinfo.engine.data.AssessmentSubset;
import com.capinfo.engine.data.OriginalProduct;
import com.capinfo.engine.data.PostRanks;
import com.capinfo.engine.data.PostSubset;

import java.util.List;
import java.util.Map;

public class TaoGaiParamsBuilder extends DataParamsAdapter{

    @Override
    protected OriginalProduct buildBaseData(Map<String, String> baseData) {
        return null;
    }

    @Override
    protected List<PostSubset> buildPostSubset(Map<String, String> postData) {




        return null;
    }

    @Override
    protected List<AssessmentSubset> buildAssessmentSubsetList(Map<String, String> assessmentData) {
        return null;
    }

    @Override
    protected List<PostRanks> buildPostSubsetList(Map<String, String> postSubsetData) {
        return super.buildPostSubsetList(postSubsetData);
    }

    @Override
    protected List<PostRanks> buildRanksSubsetList(Map<String, String> ranksSubsetData) {
        return super.buildRanksSubsetList(ranksSubsetData);
    }
}
