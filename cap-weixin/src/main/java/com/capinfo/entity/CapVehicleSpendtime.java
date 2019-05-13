package com.capinfo.entity;

import com.capinfo.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
    private double spendMoney;
    @Column(name = "isrepeat")
    private String isrepeat;
    @Column(name = "now_status")
    private String nowStatus;//加个字段记一下当前这一步最后的状态。1通过2不通过

}
