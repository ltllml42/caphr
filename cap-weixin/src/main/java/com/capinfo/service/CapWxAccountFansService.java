package com.capinfo.service;

import com.capinfo.base.BaseMapper;
import com.capinfo.base.impl.BaseServiceImpl;
import com.capinfo.entity.CapWxAccountFans;
import com.capinfo.mapper.CapWxAccountFansMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapWxAccountFansService extends BaseServiceImpl<CapWxAccountFans, String> {

    @Autowired
    private CapWxAccountFansMapper capWxAccountFansMapper;

    @Override
    public BaseMapper<CapWxAccountFans, String> getMappser() {
        return capWxAccountFansMapper;
    }
}
