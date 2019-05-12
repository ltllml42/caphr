package com.capinfo.base;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";


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


}
