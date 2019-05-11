package com.capinfo.mapper;

import com.capinfo.base.BaseMapper;
import com.capinfo.entity.CapVehicleInfo;

import java.util.List;

public interface CapVehicleInfoMapper extends BaseMapper<CapVehicleInfo,String> {


    List<CapVehicleInfo> selectListByCondition(CapVehicleInfo capVehicleInfo);

    int selectCountJoinByCondition(CapVehicleInfo capVehicleInfo);



}