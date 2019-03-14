package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_module")
public class JsSysModule implements Serializable {
    /**
     * 模块编码
     */
    @Id
    private String module_code;

    /**
     * 模块名称
     */
    private String module_name;

    /**
     * 模块描述
     */
    private String description;

    /**
     * 主类全名
     */
    private String main_class_name;

    /**
     * 当前版本
     */
    private String current_version;

    /**
     * 升级信息
     */
    private String upgrade_info;

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
     * 获取模块编码
     *
     * @return module_code - 模块编码
     */
    public String getModule_code() {
        return module_code;
    }

    /**
     * 设置模块编码
     *
     * @param module_code 模块编码
     */
    public void setModule_code(String module_code) {
        this.module_code = module_code;
    }

    /**
     * 获取模块名称
     *
     * @return module_name - 模块名称
     */
    public String getModule_name() {
        return module_name;
    }

    /**
     * 设置模块名称
     *
     * @param module_name 模块名称
     */
    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    /**
     * 获取模块描述
     *
     * @return description - 模块描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置模块描述
     *
     * @param description 模块描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取主类全名
     *
     * @return main_class_name - 主类全名
     */
    public String getMain_class_name() {
        return main_class_name;
    }

    /**
     * 设置主类全名
     *
     * @param main_class_name 主类全名
     */
    public void setMain_class_name(String main_class_name) {
        this.main_class_name = main_class_name;
    }

    /**
     * 获取当前版本
     *
     * @return current_version - 当前版本
     */
    public String getCurrent_version() {
        return current_version;
    }

    /**
     * 设置当前版本
     *
     * @param current_version 当前版本
     */
    public void setCurrent_version(String current_version) {
        this.current_version = current_version;
    }

    /**
     * 获取升级信息
     *
     * @return upgrade_info - 升级信息
     */
    public String getUpgrade_info() {
        return upgrade_info;
    }

    /**
     * 设置升级信息
     *
     * @param upgrade_info 升级信息
     */
    public void setUpgrade_info(String upgrade_info) {
        this.upgrade_info = upgrade_info;
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
        sb.append(", module_code=").append(module_code);
        sb.append(", module_name=").append(module_name);
        sb.append(", description=").append(description);
        sb.append(", main_class_name=").append(main_class_name);
        sb.append(", current_version=").append(current_version);
        sb.append(", upgrade_info=").append(upgrade_info);
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