package com.capinfo.vehicle.factory;

import com.capinfo.vehicle.utilEntity.VehicleConstant;
import com.capinfo.vehicle.utilEntity.VehicleProcess;

/**
 * 进入检测场。这里应该是先不进入工作流，在外观检测完成后进入两步工作流。这里改一些需要修改的数据
 */
public class VehicleProcessFirst implements VehicleProcessModel {


    @Override
    public VehicleProcess processType(VehicleProcess process) {
        process.setProcessType(VehicleConstant.PROCESS_ENTER);
        process.setPass("1");
        return process;
    }
}
