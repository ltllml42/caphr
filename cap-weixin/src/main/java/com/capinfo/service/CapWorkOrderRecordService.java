package com.capinfo.service;

import com.capinfo.base.BaseMapper;
import com.capinfo.base.impl.BaseServiceImpl;
import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.entity.CapWorkOrderRecord;
import com.capinfo.mapper.CapWorkOrderRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用于处理工单的逻辑功能
 */
@Service
public class CapWorkOrderRecordService extends BaseServiceImpl<CapWorkOrderRecord, String> {

    @Autowired
    private CapWorkOrderRecordMapper capWorkOrderRecordMapper;

    @Override
    public BaseMapper<CapWorkOrderRecord, String> getMappser() {
        return capWorkOrderRecordMapper;
    }
}
