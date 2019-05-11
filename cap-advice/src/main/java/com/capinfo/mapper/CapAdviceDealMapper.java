package com.capinfo.mapper;


import com.capinfo.entity.CapAdviceDeal;

import java.util.List;

public interface CapAdviceDealMapper extends com.capinfo.base.BaseMapper<CapAdviceDeal,String> {

    List<CapAdviceDeal> selectByCondition(CapAdviceDeal capAdviceDeal);

    int selectCountByCondition(CapAdviceDeal capAdviceDeal);


}
