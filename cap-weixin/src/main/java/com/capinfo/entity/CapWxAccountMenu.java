package com.capinfo.entity;

import com.capinfo.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "cap_wx_account_menu")
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor//生成无参构造函数
@Builder
public class CapWxAccountMenu extends BaseEntity {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    @Column(name = "account_id")
    private String accountId;

    private String mtype;

    @Column(name = "event_type")
    private String eventType;

    private String name;

    @Column(name = "input_code")
    private String inputCode;

    private String url;

    private Integer sort;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "msg_type")
    private String msgType;

    @Column(name = "msg_id")
    private String msgId;

    private Integer gid;

    private String account;

}