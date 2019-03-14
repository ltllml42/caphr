package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_config")
public class JsSysConfig implements Serializable {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 名称
     */
    private String config_name;

    /**
     * 参数键
     */
    private String config_key;

    /**
     * 参数值
     */
    private String config_value;

    /**
     * 系统内置（1是 0否）
     */
    private String is_sys;

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
     * 获取名称
     *
     * @return config_name - 名称
     */
    public String getConfig_name() {
        return config_name;
    }

    /**
     * 设置名称
     *
     * @param config_name 名称
     */
    public void setConfig_name(String config_name) {
        this.config_name = config_name;
    }

    /**
     * 获取参数键
     *
     * @return config_key - 参数键
     */
    public String getConfig_key() {
        return config_key;
    }

    /**
     * 设置参数键
     *
     * @param config_key 参数键
     */
    public void setConfig_key(String config_key) {
        this.config_key = config_key;
    }

    /**
     * 获取参数值
     *
     * @return config_value - 参数值
     */
    public String getConfig_value() {
        return config_value;
    }

    /**
     * 设置参数值
     *
     * @param config_value 参数值
     */
    public void setConfig_value(String config_value) {
        this.config_value = config_value;
    }

    /**
     * 获取系统内置（1是 0否）
     *
     * @return is_sys - 系统内置（1是 0否）
     */
    public String getIs_sys() {
        return is_sys;
    }

    /**
     * 设置系统内置（1是 0否）
     *
     * @param is_sys 系统内置（1是 0否）
     */
    public void setIs_sys(String is_sys) {
        this.is_sys = is_sys;
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
        sb.append(", config_name=").append(config_name);
        sb.append(", config_key=").append(config_key);
        sb.append(", config_value=").append(config_value);
        sb.append(", is_sys=").append(is_sys);
        sb.append(", create_by=").append(create_by);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_by=").append(update_by);
        sb.append(", update_date=").append(update_date);
        sb.append(", remarks=").append(remarks);
        sb.append("]");
        return sb.toString();
    }
}