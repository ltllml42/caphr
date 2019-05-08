package com.capinfo.entity;

import com.capinfo.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "cap_wx_account")
public class CapWxAccount extends BaseEntity {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    private String name;

    private String account;

    private String appid;

    private String appsecret;

    private String url;

    private String token;

    @Column(name = "msg_count")
    private Integer msgCount;

}