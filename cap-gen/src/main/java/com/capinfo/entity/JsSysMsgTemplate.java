package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_msg_template")
public class JsSysMsgTemplate implements Serializable {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 归属模块
     */
    private String module_code;

    /**
     * 模板键值
     */
    private String tpl_key;

    /**
     * 模板名称
     */
    private String tpl_name;

    /**
     * 模板类型
     */
    private String tpl_type;

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

    /**
     * 模板内容
     */
    private String tpl_content;

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
     * 获取归属模块
     *
     * @return module_code - 归属模块
     */
    public String getModule_code() {
        return module_code;
    }

    /**
     * 设置归属模块
     *
     * @param module_code 归属模块
     */
    public void setModule_code(String module_code) {
        this.module_code = module_code;
    }

    /**
     * 获取模板键值
     *
     * @return tpl_key - 模板键值
     */
    public String getTpl_key() {
        return tpl_key;
    }

    /**
     * 设置模板键值
     *
     * @param tpl_key 模板键值
     */
    public void setTpl_key(String tpl_key) {
        this.tpl_key = tpl_key;
    }

    /**
     * 获取模板名称
     *
     * @return tpl_name - 模板名称
     */
    public String getTpl_name() {
        return tpl_name;
    }

    /**
     * 设置模板名称
     *
     * @param tpl_name 模板名称
     */
    public void setTpl_name(String tpl_name) {
        this.tpl_name = tpl_name;
    }

    /**
     * 获取模板类型
     *
     * @return tpl_type - 模板类型
     */
    public String getTpl_type() {
        return tpl_type;
    }

    /**
     * 设置模板类型
     *
     * @param tpl_type 模板类型
     */
    public void setTpl_type(String tpl_type) {
        this.tpl_type = tpl_type;
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

    /**
     * 获取模板内容
     *
     * @return tpl_content - 模板内容
     */
    public String getTpl_content() {
        return tpl_content;
    }

    /**
     * 设置模板内容
     *
     * @param tpl_content 模板内容
     */
    public void setTpl_content(String tpl_content) {
        this.tpl_content = tpl_content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", module_code=").append(module_code);
        sb.append(", tpl_key=").append(tpl_key);
        sb.append(", tpl_name=").append(tpl_name);
        sb.append(", tpl_type=").append(tpl_type);
        sb.append(", status=").append(status);
        sb.append(", create_by=").append(create_by);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_by=").append(update_by);
        sb.append(", update_date=").append(update_date);
        sb.append(", remarks=").append(remarks);
        sb.append(", tpl_content=").append(tpl_content);
        sb.append("]");
        return sb.toString();
    }
}