package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "js_sys_company_office")
public class JsSysCompanyOffice implements Serializable {
    /**
     * 公司编码
     */
    @Id
    private String company_code;

    /**
     * 机构编码
     */
    @Id
    private String office_code;

    private static final long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", company_code=").append(company_code);
        sb.append(", office_code=").append(office_code);
        sb.append("]");
        return sb.toString();
    }
}