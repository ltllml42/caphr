package com.capinfo.service;

import com.capinfo.base.BaseMapper;
import com.capinfo.base.impl.BaseServiceImpl;
import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.entity.CapWxAccountFans;
import com.capinfo.mapper.CapVehicleInfoMapper;
import com.capinfo.mapper.CapWxAccountFansMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapVehicleInfoService extends BaseServiceImpl<CapVehicleInfo, String> {

    @Autowired
    private CapVehicleInfoMapper capVehicleInfoMapper;

    @Override
    public BaseMapper<CapVehicleInfo, String> getMappser() {
        return capVehicleInfoMapper;
    }
}
