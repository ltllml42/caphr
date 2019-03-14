package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_file_upload")
public class JsSysFileUpload implements Serializable {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 文件编号
     */
    private String file_id;

    /**
     * 文件名称
     */
    private String file_name;

    /**
     * 文件分类（image、media、file）
     */
    private String file_type;

    /**
     * 业务主键
     */
    private String biz_key;

    /**
     * 业务类型
     */
    private String biz_type;

    /**
     * 状态（0正常 1删除 2停用）
     */
    private String status;

    /**
     * 创建者
     */
    private String create_by;

    /**
     * 创建时间
     */
    private Date create_date;

    /**
     * 更新者
     */
    private String update_by;

    /**
     * 更新时间
     */
    private Date update_date;

    /**
     * 备注信息
     */
    private String remarks;

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取文件编号
     *
     * @return file_id - 文件编号
     */
    public String getFile_id() {
        return file_id;
    }

    /**
     * 设置文件编号
     *
     * @param file_id 文件编号
     */
    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    /**
     * 获取文件名称
     *
     * @return file_name - 文件名称
     */
    public String getFile_name() {
        return file_name;
    }

    /**
     * 设置文件名称
     *
     * @param file_name 文件名称
     */
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    /**
     * 获取文件分类（image、media、file）
     *
     * @return file_type - 文件分类（image、media、file）
     */
    public String getFile_type() {
        return file_type;
    }

    /**
     * 设置文件分类（image、media、file）
     *
     * @param file_type 文件分类（image、media、file）
     */
    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    /**
     * 获取业务主键
     *
     * @return biz_key - 业务主键
     */
    public String getBiz_key() {
        return biz_key;
    }

    /**
     * 设置业务主键
     *
     * @param biz_key 业务主键
     */
    public void setBiz_key(String biz_key) {
        this.biz_key = biz_key;
    }

    /**
     * 获取业务类型
     *
     * @return biz_type - 业务类型
     */
    public String getBiz_type() {
        return biz_type;
    }

    /**
     * 设置业务类型
     *
     * @param biz_type 业务类型
     */
    public void setBiz_type(String biz_type) {
        this.biz_type = biz_type;
    }

    /**
     * 获取状态（0正常 1删除 2停用）
     *
     * @return status - 状态（0正常 1删除 2停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除 2停用）
     *
     * @param status 状态（0正常 1删除 2停用）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreate_by() {
        return create_by;
    }

    /**
     * 设置创建者
     *
     * @param create_by 创建者
     */
    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreate_date() {
        return create_date;
    }

    /**
     * 设置创建时间
     *
     * @param create_date 创建时间
     */
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdate_by() {
        return update_by;
    }

    /**
     * 设置更新者
     *
     * @param update_by 更新者
     */
    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdate_date() {
        return update_date;
    }

    /**
     * 设置更新时间
     *
     * @param update_date 更新时间
     */
    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    /**
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", file_id=").append(file_id);
        sb.append(", file_name=").append(file_name);
        sb.append(", file_type=").append(file_type);
        sb.append(", biz_key=").append(biz_key);
        sb.append(", biz_type=").append(biz_type);
        sb.append(", status=").append(status);
        sb.append(", create_by=").append(create_by);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_by=").append(update_by);
        sb.append(", update_date=").append(update_date);
        sb.append(", remarks=").append(remarks);
        sb.append("]");
        return sb.toString();
    }
}