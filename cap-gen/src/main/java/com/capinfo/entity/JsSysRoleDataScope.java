package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "js_sys_role_data_scope")
public class JsSysRoleDataScope implements Serializable {
    /**
     * 控制角色编码
     */
    @Id
    private String role_code;

    /**
     * 控制类型
     */
    @Id
    private String ctrl_type;

    /**
     * 控制数据
     */
    @Id
    private String ctrl_data;

    /**
     * 控制权限
     */
    @Id
    private String ctrl_permi;

    private static final long serialVersionUID = 1L;

    /**
     * 获取控制角色编码
     *
     * @return role_code - 控制角色编码
     */
    public String getRole_code() {
        return role_code;
    }

    /**
     * 设置控制角色编码
     *
     * @param role_code 控制角色编码
     */
    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    /**
     * 获取控制类型
     *
     * @return ctrl_type - 控制类型
     */
    public String getCtrl_type() {
        return ctrl_type;
    }

    /**
     * 设置控制类型
     *
     * @param ctrl_type 控制类型
     */
    public void setCtrl_type(String ctrl_type) {
        this.ctrl_type = ctrl_type;
    }

    /**
     * 获取控制数据
     *
     * @return ctrl_data - 控制数据
     */
    public String getCtrl_data() {
        return ctrl_data;
    }

    /**
     * 设置控制数据
     *
     * @param ctrl_data 控制数据
     */
    public void setCtrl_data(String ctrl_data) {
        this.ctrl_data = ctrl_data;
    }

    /**
     * 获取控制权限
     *
     * @return ctrl_permi - 控制权限
     */
    public String getCtrl_permi() {
        return ctrl_permi;
    }

    /**
     * 设置控制权限
     *
     * @param ctrl_permi 控制权限
     */
    public void setCtrl_permi(String ctrl_permi) {
        this.ctrl_permi = ctrl_permi;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", role_code=").append(role_code);
        sb.append(", ctrl_type=").append(ctrl_type);
        sb.append(", ctrl_data=").append(ctrl_data);
        sb.append(", ctrl_permi=").append(ctrl_permi);
        sb.append("]");
        return sb.toString();
    }
}