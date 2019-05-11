package com.capinfo.service.impl;

import com.capinfo.base.BaseMapper;
import com.capinfo.base.CurrentUser;
import com.capinfo.base.impl.BaseServiceImpl;
import com.capinfo.entity.CapAdviceDeal;
import com.capinfo.mapper.CapAdviceDealMapper;
import com.capinfo.service.CapAdviceDealService;
import com.capinfo.util.BeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author zhuxiaomeng
 * @date 2017/12/21.
 * @email 154040976@qq.com
 */
@Service
public class CapAdviceDealServiceImpl extends BaseServiceImpl<CapAdviceDeal,String> implements
        CapAdviceDealService {

  @Autowired
  private CapAdviceDealMapper capAdviceDealMapper;

  @Override
  public BaseMapper<CapAdviceDeal, String> getMappser() {
    return capAdviceDealMapper;
  }

  @Override
  public int deleteByPrimaryKey(CapAdviceDeal capAdviceDeal) {
    return capAdviceDealMapper.deleteByPrimaryKey(capAdviceDeal);
  }

  @Override
  public int selectCountByCondition(CapAdviceDeal capAdviceDeal) {
    return capAdviceDealMapper.selectCountByCondition(capAdviceDeal);
  }

  @Override
  public List<CapAdviceDeal> selectByCondition(CapAdviceDeal capAdviceDeal) {
    return capAdviceDealMapper.selectByCondition(capAdviceDeal);
  }

  @Override
  public int saveDeal(CapAdviceDeal capAdviceDeal) {
    CurrentUser currentUser = (CurrentUser) SecurityUtils.getSubject().getSession().getAttribute("curentUser");
    int result = 0;
    String id = capAdviceDeal.getId();
    capAdviceDeal.setDelFlag("0");
    if (StringUtils.isNotBlank(id)) {
      CapAdviceDeal oldCapAdviceDeal = this.selectByPrimaryKey(id);
      BeanUtil.copyNotNullBean(capAdviceDeal, oldCapAdviceDeal);
      result = this.updateByPrimaryKeySelective(oldCapAdviceDeal);
    } else {
      capAdviceDeal.setId(UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());
      capAdviceDeal.setUpdateBy(currentUser.getId());
      capAdviceDeal.setUpdateDate(new Date());
      capAdviceDeal.setStatus("1");
      result = this.insertSelective(capAdviceDeal);
    }
    return result;
  }
}
