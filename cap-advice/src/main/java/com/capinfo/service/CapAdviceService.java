package com.capinfo.service;


import com.capinfo.base.BaseService;
import com.capinfo.entity.CapAdvice;

import java.util.List;

public interface CapAdviceService extends BaseService<CapAdvice,String> {

    int deleteByPrimaryKey(String id);

    @Override
    int insert(CapAdvice record);

    @Override
    int insertSelective(CapAdvice record);


    CapAdvice selectByPrimaryKey(String id);

    @Override
    int updateByPrimaryKeySelective(CapAdvice record);

    @Override
    int updateByPrimaryKey(CapAdvice record);

    @Override
    List<CapAdvice> selectListByPage(CapAdvice sysRole);

    /**
     * 手机端插入。没有当前用户的情况
     * @param record
     * @return
     */
    int insertByMobile(CapAdvice record);

}
