package com.capinfo.entity;

import com.capinfo.base.BaseEntity;
import com.capinfo.vehicle.utilEntity.VehicleProcess;
import com.capinfo.vehicle.utilEntity.VehicleProcessEnum;
import com.capinfo.vehicle.utilEntity.WorkOrderStautsEnum;
import lombok.*;
import org.apache.commons.lang.enums.Enum;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name = "cap_vehicle_spendtime")
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor//生成无参构造函数
@Builder
public class CapVehicleSpendtime extends BaseEntity {

    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;
    @Column(name = "cap_work_record_id")
    private String capWorkRecordId;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "status")
    private String status;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "spend_money")
    private Double spendMoney;
    @Column(name = "isrepeat")
    private String isrepeat;
    @Column(name = "now_status")
    private String nowStatus;//加个字段记一下当前这一步最后的状态。1通过2不通过
    @Transient
    private String nowStatuStr;
    @Transient
    private String iconImg;
    @Transient
    private String sortType;//加这个字段变一下select时候的排序方式

    /**
     *     STAUTS_OK("1","通过",""),
     *     STATUS_NO("2","不通过",""),
     *     STATUS_UNDETECTED("3","未检测","");
     * @return
     */
    public String getNowStatuStr() {
        if(StringUtils.isNotBlank(nowStatus)){
            WorkOrderStautsEnum newEnum = getWorkOrderStautsEnum(WorkOrderStautsEnum.class,nowStatus);
            if(newEnum!=null){
                return newEnum.getTypeName();
            }
        }
        return "";
    }

    private WorkOrderStautsEnum getWorkOrderStautsEnum(Class clazz,String typeName){
        List<WorkOrderStautsEnum> enumList = EnumUtils.getEnumList(clazz);
        for (WorkOrderStautsEnum workOrderStautsEnum : enumList) {
            if(typeName.equals(workOrderStautsEnum.getType())){
                return workOrderStautsEnum;
            }
        }
        return null;
    }

    private VehicleProcessEnum getVehicleProcessEnum(Class clazz,String typeName){
        List<VehicleProcessEnum> enumList = EnumUtils.getEnumList(clazz);
        for (VehicleProcessEnum vehicleProcessEnum : enumList) {
            if(typeName.equals(vehicleProcessEnum.getTypeName())){
                return vehicleProcessEnum;
            }
        }
        return null;
    }


    public String getIconImg() {
        //iconImg
        if(StringUtils.isNotBlank(taskName)){
            VehicleProcessEnum vpe = getVehicleProcessEnum(VehicleProcessEnum.class, taskName);
            if(vpe!=null){
                return vpe.getRemarks();
            }else{
                System.out.println(taskName);
            }

        }
        return iconImg;
    }
}
