package com.capinfo.vehicle.dataJudge;

import com.capinfo.vehicle.factory.VehicleProcessFactory;
import com.capinfo.vehicle.utilEntity.VehicleConstant;
import com.capinfo.vehicle.utilEntity.VehicleProcess;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DataExecute {


    public VehicleProcess execute(VehicleProcess process) {

        //在这判断这条数据的type应该是几。查数据库里这个车牌对应的流程id
        String type = judgeType(process);

        process = VehicleProcessFactory.processFactory(process, type).processType(process);

        if (VehicleConstant.PROCESS_ENTER.equals(process.getProcessType())) {
            //插入数据库一条
        } else if (VehicleConstant.PROCESS_APPEAR.equals(process.getProcessType())) {
            //工作流开启
        } else {
            //工作流执行complete
        }


        return process;
    }




    private String judgeType(VehicleProcess process) {

        String proInsId = process.getProInsId();
        if (StringUtils.isBlank(proInsId)) {
            return VehicleConstant.PROCESS_ENTER;
        }


        return "";
    }


}
