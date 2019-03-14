package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "js_sys_role_menu")
public class JsSysRoleMenu implements Serializable {
    /**
     * 角色编码
     */
    @Id
    private String role_code;

    /**
     * 菜单编码
     */
    @Id
    private String menu_code;

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
     * 获取菜单编码
     *
     * @return menu_code - 菜单编码
     */
    public String getMenu_code() {
        return menu_code;
    }

    /**
     * 设置菜单编码
     *
     * @param menu_code 菜单编码
     */
    public void setMenu_code(String menu_code) {
        this.menu_code = menu_code;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", role_code=").append(role_code);
        sb.append(", menu_code=").append(menu_code);
        sb.append("]");
        return sb.toString();
    }
}