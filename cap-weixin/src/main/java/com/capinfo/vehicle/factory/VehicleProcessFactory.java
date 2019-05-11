package com.capinfo.vehicle.factory;

import com.capinfo.vehicle.utilEntity.VehicleConstant;
import com.capinfo.vehicle.utilEntity.VehicleProcess;

/**
 * 判断当前进来的数据需要进行第几步车检
 */
public class VehicleProcessFactory {


    public static VehicleProcessModel processFactory(VehicleProcess process, String type) {
        VehicleProcessModel model = null;
        switch (type) {
            case VehicleConstant.PROCESS_ENTER:
                model = new VehicleProcessFirst();
        }


        return model;
    }


}
