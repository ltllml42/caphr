package com.capinfo.engine.data.builder;

import com.capinfo.engine.data.AssessmentSubset;
import com.capinfo.engine.data.OriginalProduct;
import com.capinfo.engine.data.PostRanks;
import com.capinfo.engine.data.PostSubset;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataParamsAdapter extends DataParamsBuilder{
    @Override
    protected OriginalProduct buildBaseData(Map<String, String> baseData) {
        return new OriginalProduct();
    }

    @Override
    protected List<PostSubset> buildPostSubset(Map<String, String> postData) {
        return new ArrayList<PostSubset>();
    }

    @Override
    protected List<AssessmentSubset> buildAssessmentSubsetList(Map<String, String> assessmentData) {
        return new ArrayList<AssessmentSubset>();
    }

    @Override
    protected List<PostRanks> buildPostSubsetList(Map<String, String> postSubsetData) {
        return null;
    }

    @Override
    protected List<PostRanks> buildRanksSubsetList(Map<String, String> ranksSubsetData) {
        return null;
    }
}
