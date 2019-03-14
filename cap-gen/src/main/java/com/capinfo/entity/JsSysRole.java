package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_role")
public class JsSysRole implements Serializable {
    /**
     * 角色编码
     */
    @Id
    private String role_code;

    /**
     * 角色名称
     */
    private String role_name;

    /**
     * 角色分类（高管、中层、基层、其它）
     */
    private String role_type;

    /**
     * 角色排序（升序）
     */
    private Long role_sort;

    /**
     * 系统内置（1是 0否）
     */
    private String is_sys;

    /**
     * 用户类型（employee员工 member会员）
     */
    private String user_type;

    /**
     * 数据范围设置（0未设置  1全部数据 2自定义数据）
     */
    private String data_scope;

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
     * 租户代码
     */
    private String corp_code;

    /**
     * 租户名称
     */
    private String corp_name;

    private static final long serialVersionUID = 1L;

    /**
     * 获取角色编码
     *
     * @return role_code - 角色编码
     */
    public String getRole_code() {
        return role_code;
    }

    /**
     * 设置角色编码
     *
     * @param role_code 角色编码
     */
    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRole_name() {
        return role_name;
    }

    /**
     * 设置角色名称
     *
     * @param role_name 角色名称
     */
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    /**
     * 获取角色分类（高管、中层、基层、其它）
     *
     * @return role_type - 角色分类（高管、中层、基层、其它）
     */
    public String getRole_type() {
        return role_type;
    }

    /**
     * 设置角色分类（高管、中层、基层、其它）
     *
     * @param role_type 角色分类（高管、中层、基层、其它）
     */
    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    /**
     * 获取角色排序（升序）
     *
     * @return role_sort - 角色排序（升序）
     */
    public Long getRole_sort() {
        return role_sort;
    }

    /**
     * 设置角色排序（升序）
     *
     * @param role_sort 角色排序（升序）
     */
    public void setRole_sort(Long role_sort) {
        this.role_sort = role_sort;
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
     * 获取用户类型（employee员工 member会员）
     *
     * @return user_type - 用户类型（employee员工 member会员）
     */
    public String getUser_type() {
        return user_type;
    }

    /**
     * 设置用户类型（employee员工 member会员）
     *
     * @param user_type 用户类型（employee员工 member会员）
     */
    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    /**
     * 获取数据范围设置（0未设置  1全部数据 2自定义数据）
     *
     * @return data_scope - 数据范围设置（0未设置  1全部数据 2自定义数据）
     */
    public String getData_scope() {
        return data_scope;
    }

    /**
     * 设置数据范围设置（0未设置  1全部数据 2自定义数据）
     *
     * @param data_scope 数据范围设置（0未设置  1全部数据 2自定义数据）
     */
    public void setData_scope(String data_scope) {
        this.data_scope = data_scope;
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
     * 获取租户代码
     *
     * @return corp_code - 租户代码
     */
    public String getCorp_code() {
        return corp_code;
    }

    /**
     * 设置租户代码
     *
     * @param corp_code 租户代码
     */
    public void setCorp_code(String corp_code) {
        this.corp_code = corp_code;
    }

    /**
     * 获取租户名称
     *
     * @return corp_name - 租户名称
     */
    public String getCorp_name() {
        return corp_name;
    }

    /**
     * 设置租户名称
     *
     * @param corp_name 租户名称
     */
    public void setCorp_name(String corp_name) {
        this.corp_name = corp_name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", role_code=").append(role_code);
        sb.append(", role_name=").append(role_name);
        sb.append(", role_type=").append(role_type);
        sb.append(", role_sort=").append(role_sort);
        sb.append(", is_sys=").append(is_sys);
        sb.append(", user_type=").append(user_type);
        sb.append(", data_scope=").append(data_scope);
        sb.append(", status=").append(status);
        sb.append(", create_by=").append(create_by);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_by=").append(update_by);
        sb.append(", update_date=").append(update_date);
        sb.append(", remarks=").append(remarks);
        sb.append(", corp_code=").append(corp_code);
        sb.append(", corp_name=").append(corp_name);
        sb.append("]");
        return sb.toString();
    }
}