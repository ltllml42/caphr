package com.capinfo.entity;

import com.capinfo.base.BaseEntity;
import com.capinfo.util.DateUtils;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 *  工单生成  有利于统计
 */
@Getter
@Setter
@Table(name = "cap_work_order_record")
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor//生成无参构造函数
@Builder
public class CapWorkOrderRecord  extends BaseEntity {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;
    @Column(name = "record_id")
    private String recordId; //工单ID
    @Column(name = "plate_no")
    private String plateNo; //车牌号
    @Column(name = "vehicle_id")
    private String vehicleId; //绑定汽车表信息   如果没有则需要添加  一个车允许被多个微信号绑定吗？
    @Column(name = "start_time")
    private Date startTime; //开始时间
    @Column(name = "end_time")
    private Date endTime;//结束时间
    @Column(name = "parking_time")
    private Date parkingTime;//进入停车场时间
    @Column(name = "now_come_back")
    private String nowComeBack;//是否返回当前环节  是  否
    @Column(name = "now_link")
    private String nowLink;//当前所处环节
    @Column(name = "now_status")
    private String nowStatus;//检查状态  通过--未通过
    @Column(name = "total_money")
    private Float totalMoney; //总钱数
    @Column(name = "total_limit")
    private Integer totalLimit;  //分钟   统计的进入停车场环节。

    @Transient
    private String startTimeStr;

    public String getStartTimeStr() {
        if(startTime!=null){
            this.startTimeStr = DateUtils.formatDate(startTime);
        }
        return startTimeStr;
    }

    /*@Column(name = "total_last_limit")
        private int nowLastTime;//最后一个环节花费时间*/
    //不知道为啥名字和mapper里的不一样，先这样改一下
    @Column(name = "total_last_limit")
    private Integer totalLastLimit;


    @Column(name = "proc_inst_id")
    private String procInstId;//工作流ID

    //数据库里没有这个字段不知道为啥。暂时去掉了
    /*@Column(name="remarks")
    private String remarks; //备注*/
    @Column(name = "is_powerfree")
    private String isPowerfree;


    private CapVehicleInfo capVehicleInfo;



}
