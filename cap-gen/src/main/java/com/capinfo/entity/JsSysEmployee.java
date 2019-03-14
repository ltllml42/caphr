package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_employee")
public class JsSysEmployee implements Serializable {
    /**
     * 员工编码
     */
    @Id
    private String emp_code;

    /**
     * 员工姓名
     */
    private String emp_name;

    /**
     * 英文名
     */
    private String emp_name_en;

    /**
     * 机构编码
     */
    private String office_code;

    /**
     * 机构名称
     */
    private String office_name;

    /**
     * 公司编码
     */
    private String company_code;

    /**
     * 公司名称
     */
    private String company_name;

    /**
     * 状态（0在职 1删除 2离职）
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
     * 获取员工姓名
     *
     * @return emp_name - 员工姓名
     */
    public String getEmp_name() {
        return emp_name;
    }

    /**
     * 设置员工姓名
     *
     * @param emp_name 员工姓名
     */
    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    /**
     * 获取英文名
     *
     * @return emp_name_en - 英文名
     */
    public String getEmp_name_en() {
        return emp_name_en;
    }

    /**
     * 设置英文名
     *
     * @param emp_name_en 英文名
     */
    public void setEmp_name_en(String emp_name_en) {
        this.emp_name_en = emp_name_en;
    }

    /**
     * 获取机构编码
     *
     * @return office_code - 机构编码
     */
    public String getOffice_code() {
        return office_code;
    }

    /**
     * 设置机构编码
     *
     * @param office_code 机构编码
     */
    public void setOffice_code(String office_code) {
        this.office_code = office_code;
    }

    /**
     * 获取机构名称
     *
     * @return office_name - 机构名称
     */
    public String getOffice_name() {
        return office_name;
    }

    /**
     * 设置机构名称
     *
     * @param office_name 机构名称
     */
    public void setOffice_name(String office_name) {
        this.office_name = office_name;
    }

    /**
     * 获取公司编码
     *
     * @return company_code - 公司编码
     */
    public String getCompany_code() {
        return company_code;
    }

    /**
     * 设置公司编码
     *
     * @param company_code 公司编码
     */
    public void setCompany_code(String company_code) {
        this.company_code = company_code;
    }

    /**
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompany_name() {
        return company_name;
    }

    /**
     * 设置公司名称
     *
     * @param company_name 公司名称
     */
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    /**
     * 获取状态（0在职 1删除 2离职）
     *
     * @return status - 状态（0在职 1删除 2离职）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0在职 1删除 2离职）
     *
     * @param status 状态（0在职 1删除 2离职）
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
        sb.append(", emp_code=").append(emp_code);
        sb.append(", emp_name=").append(emp_name);
        sb.append(", emp_name_en=").append(emp_name_en);
        sb.append(", office_code=").append(office_code);
        sb.append(", office_name=").append(office_name);
        sb.append(", company_code=").append(company_code);
        sb.append(", company_name=").append(company_name);
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