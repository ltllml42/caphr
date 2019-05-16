package com.capinfo.entity;

import com.capinfo.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "cap_wx_account_fans")
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor//生成无参构造函数
@Builder
public class CapWxAccountFans extends BaseEntity {

    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "subscribe_status")
    private Integer subscribeStatus;

    @Column(name = "subscribe_time")
    private String subscribeTime;

    private Byte gender;

    private String language;

    private String country;

    private String province;

    private String city;

    @Column(name = "head_img_url")
    private String headImgUrl;

    private Byte status;

    private String remark;
    @Transient
    private String sexDesc;//性别

    @Column(name = "wx_id")
    private String wxId;
    @Column(name = "name")
    private String name;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "del_flag")
    private String delFlag = DEL_FLAG_NORMAL;

    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "telphone")
    private String telPhone; //客户填写的手机号

    private String sex; //客户确认的姓名
    @Transient
    private String fansId;

    @Transient
    private String carId;



}