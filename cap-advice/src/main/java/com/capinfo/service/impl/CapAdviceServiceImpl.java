package com.capinfo.service.impl;

import com.capinfo.base.BaseMapper;
import com.capinfo.base.impl.BaseServiceImpl;
import com.capinfo.entity.CapAdvice;
import com.capinfo.mapper.CapAdviceMapper;
import com.capinfo.service.CapAdviceService;
import com.capinfo.utils.AdviceConstant;
import com.capinfo.utils.QueryCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CapAdviceServiceImpl extends BaseServiceImpl<CapAdvice,String> implements CapAdviceService {

    @Autowired
    private CapAdviceMapper capAdviceMapper;

    @Override
    public CapAdvice selectByPrimaryKey(String id) {
        return capAdviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public BaseMapper<CapAdvice, String> getMappser() {
        return capAdviceMapper;
    }


    @Override
    public int deleteByPrimaryKey(String id) {
        return capAdviceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CapAdvice record) {
        record=super.addValue(record,true);
        return capAdviceMapper.insert(record);
    }


    @Override
    public int updateByPrimaryKeySelective(CapAdvice record) {
        record = super.addValue(record, false);
        return capAdviceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CapAdvice record) {
        return capAdviceMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CapAdvice> selectListByPage(CapAdvice sysRole) {
        return capAdviceMapper.selectListByPage(sysRole);
    }

    @Override
    public int insertByMobile(CapAdvice record) {
        record.setCreateBy(AdviceConstant.TSUSER_ID);
        record.setCreateDate(new Date());
        record.setUpdateBy(AdviceConstant.TSUSER_ID);
        record.setUpdateDate(new Date());
        record.setDelFlag("0");
        //唯一编码
        String code = getCode();
        record.setAdviceCode(code);
        record.setStatus(AdviceConstant.ADVICE_STATUS_DEAL);
        return capAdviceMapper.insert(record);
    }


    private String getCode() {
        String code = QueryCodeUtils.getItemID(5);
        CapAdvice query = new CapAdvice();
        query.setAdviceCode(code);
        List<CapAdvice> list = select(query);
        if (list.size() == 0) {
            return code;
        } else {
            getCode();
        }
        return null;
    }



}
