package com.capinfo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cap_advice")
@Data
@ToString
@EqualsAndHashCode
public class CapAdvice {

    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "reportedperson")
    private String reportedperson;

    @Column(name = "reporteddept")
    private String reporteddept;

    //@NotEmpty(message = "角色名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "file")
    private String file;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "type")
    private String type;

    @Column(name = "report_type")
    private String reportType;

    @Column(name = "status")
    private String status;

    @Column(name = "advice_code")
    private String adviceCode;

    @Column(name = "remark")
    private String remark;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "del_flag")
    private String delFlag;


}
