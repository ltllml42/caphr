package com.capinfo.mapper;

import com.capinfo.base.BaseMapper;
import com.capinfo.entity.CapVehicleSpendtime;
import com.capinfo.entity.CapWorkOrderRecord;

import java.util.List;

/**
 *
 */
public interface CapVehicleSpendtimeMapper extends BaseMapper<CapVehicleSpendtime,String>  {

    List<CapVehicleSpendtime> selectListByCondition(CapVehicleSpendtime capVehicleSpendtime);


}