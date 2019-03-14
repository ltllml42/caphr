package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "js_sys_user_role")
public class JsSysUserRole implements Serializable {
    /**
     * 用户编码
     */
    @Id
    private String user_code;

    /**
     * 角色编码
     */
    @Id
    private String role_code;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户编码
     *
     * @return user_code - 用户编码
     */
    public String getUser_code() {
        return user_code;
    }

    /**
     * 设置用户编码
     *
     * @param user_code 用户编码
     */
    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user_code=").append(user_code);
        sb.append(", role_code=").append(role_code);
        sb.append("]");
        return sb.toString();
    }
}