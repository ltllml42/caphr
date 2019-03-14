package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "js_sys_employee_post")
public class JsSysEmployeePost implements Serializable {
    /**
     * 员工编码
     */
    @Id
    private String emp_code;

    /**
     * 岗位编码
     */
    @Id
    private String post_code;

    private static final long serialVersionUID = 1L;

    /**
     * 获取员工编码
     *
     * @return emp_code - 员工编码
     */
    public String getEmp_code() {
        return emp_code;
    }

    /**
     * 设置员工编码
     *
     * @param emp_code 员工编码
     */
    public void setEmp_code(String emp_code) {
        this.emp_code = emp_code;
    }

    /**
     * 获取岗位编码
     *
     * @return post_code - 岗位编码
     */
    public String getPost_code() {
        return post_code;
    }

    /**
     * 设置岗位编码
     *
     * @param post_code 岗位编码
     */
    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", emp_code=").append(emp_code);
        sb.append(", post_code=").append(post_code);
        sb.append("]");
        return sb.toString();
    }
}