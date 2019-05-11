package com.capinfo.service;

import com.capinfo.base.BaseService;
import com.capinfo.entity.CapAdviceDeal;

import java.util.List;

/**
 * @author zhuxiaomeng
 * @date 2017/12/21.
 * @email 154040976@qq.com
 */
public interface CapAdviceDealService extends BaseService<CapAdviceDeal,String>{

  int deleteByPrimaryKey(CapAdviceDeal capAdviceDeal);

  int insert(CapAdviceDeal capAdviceDeal);

  int selectCountByCondition(CapAdviceDeal capAdviceDeal);

  List<CapAdviceDeal> selectByCondition(CapAdviceDeal capAdviceDeal);

  int saveDeal(CapAdviceDeal capAdviceDeal);

}
