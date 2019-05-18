package com.capinfo.mapper;

import com.capinfo.base.BaseMapper;
import com.capinfo.entity.CapWorkOrderRecord;

import java.util.List;

/**
 *
 */
public interface CapWorkOrderRecordMapper extends BaseMapper<CapWorkOrderRecord,String> {

    List<CapWorkOrderRecord> selectListByCondition(CapWorkOrderRecord capWorkOrderRecord);

    List<CapWorkOrderRecord> selectListJoinVehicleByCondition(CapWorkOrderRecord capWorkOrderRecord);


}