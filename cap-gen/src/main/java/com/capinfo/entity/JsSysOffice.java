package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "js_sys_office")
public class JsSysOffice implements Serializable {
    /**
     * 机构编码
     */
    @Id
    private String office_code;

    /**
     * 父级编号
     */
    private String parent_code;

    /**
     * 所有父级编号
     */
    private String parent_codes;

    /**
     * 本级排序号（升序）
     */
    private Long tree_sort;

    /**
     * 所有级别排序号
     */
    private String tree_sorts;

    /**
     * 是否最末级
     */
    private String tree_leaf;

    /**
     * 层次级别
     */
    private Short tree_level;

    /**
     * 全节点名
     */
    private String tree_names;

    /**
     * 机构代码
     */
    private String view_code;

    /**
     * 机构名称
     */
    private String office_name;

    /**
     * 机构全称
     */
    private String full_name;

    /**
     * 机构类型
     */
    private String office_type;

    /**
     * 负责人
     */
    private String leader;

    /**
     * 办公电话
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String zip_code;

    /**
     * 电子邮箱
     */
    private String email;

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

    /**
     * 扩展 String 1
     */
    private String extend_s1;

    /**
     * 扩展 String 2
     */
    private String extend_s2;

    /**
     * 扩展 String 3
     */
    private String extend_s3;

    /**
     * 扩展 String 4
     */
    private String extend_s4;

    /**
     * 扩展 String 5
     */
    private String extend_s5;

    /**
     * 扩展 String 6
     */
    private String extend_s6;

    /**
     * 扩展 String 7
     */
    private String extend_s7;

    /**
     * 扩展 String 8
     */
    private String extend_s8;

    /**
     * 扩展 Integer 1
     */
    private BigDecimal extend_i1;

    /**
     * 扩展 Integer 2
     */
    private BigDecimal extend_i2;

    /**
     * 扩展 Integer 3
     */
    private BigDecimal extend_i3;

    /**
     * 扩展 Integer 4
     */
    private BigDecimal extend_i4;

    /**
     * 扩展 Float 1
     */
    private BigDecimal extend_f1;

    /**
     * 扩展 Float 2
     */
    private BigDecimal extend_f2;

    /**
     * 扩展 Float 3
     */
    private BigDecimal extend_f3;

    /**
     * 扩展 Float 4
     */
    private BigDecimal extend_f4;

    /**
     * 扩展 Date 1
     */
    private Date extend_d1;

    /**
     * 扩展 Date 2
     */
    private Date extend_d2;

    /**
     * 扩展 Date 3
     */
    private Date extend_d3;

    /**
     * 扩展 Date 4
     */
    private Date extend_d4;

    private static final long serialVersionUID = 1L;

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
     * 获取父级编号
     *
     * @return parent_code - 父级编号
     */
    public String getParent_code() {
        return parent_code;
    }

    /**
     * 设置父级编号
     *
     * @param parent_code 父级编号
     */
    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }

    /**
     * 获取所有父级编号
     *
     * @return parent_codes - 所有父级编号
     */
    public String getParent_codes() {
        return parent_codes;
    }

    /**
     * 设置所有父级编号
     *
     * @param parent_codes 所有父级编号
     */
    public void setParent_codes(String parent_codes) {
        this.parent_codes = parent_codes;
    }

    /**
     * 获取本级排序号（升序）
     *
     * @return tree_sort - 本级排序号（升序）
     */
    public Long getTree_sort() {
        return tree_sort;
    }

    /**
     * 设置本级排序号（升序）
     *
     * @param tree_sort 本级排序号（升序）
     */
    public void setTree_sort(Long tree_sort) {
        this.tree_sort = tree_sort;
    }

    /**
     * 获取所有级别排序号
     *
     * @return tree_sorts - 所有级别排序号
     */
    public String getTree_sorts() {
        return tree_sorts;
    }

    /**
     * 设置所有级别排序号
     *
     * @param tree_sorts 所有级别排序号
     */
    public void setTree_sorts(String tree_sorts) {
        this.tree_sorts = tree_sorts;
    }

    /**
     * 获取是否最末级
     *
     * @return tree_leaf - 是否最末级
     */
    public String getTree_leaf() {
        return tree_leaf;
    }

    /**
     * 设置是否最末级
     *
     * @param tree_leaf 是否最末级
     */
    public void setTree_leaf(String tree_leaf) {
        this.tree_leaf = tree_leaf;
    }

    /**
     * 获取层次级别
     *
     * @return tree_level - 层次级别
     */
    public Short getTree_level() {
        return tree_level;
    }

    /**
     * 设置层次级别
     *
     * @param tree_level 层次级别
     */
    public void setTree_level(Short tree_level) {
        this.tree_level = tree_level;
    }

    /**
     * 获取全节点名
     *
     * @return tree_names - 全节点名
     */
    public String getTree_names() {
        return tree_names;
    }

    /**
     * 设置全节点名
     *
     * @param tree_names 全节点名
     */
    public void setTree_names(String tree_names) {
        this.tree_names = tree_names;
    }

    /**
     * 获取机构代码
     *
     * @return view_code - 机构代码
     */
    public String getView_code() {
        return view_code;
    }

    /**
     * 设置机构代码
     *
     * @param view_code 机构代码
     */
    public void setView_code(String view_code) {
        this.view_code = view_code;
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
     * 获取机构全称
     *
     * @return full_name - 机构全称
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * 设置机构全称
     *
     * @param full_name 机构全称
     */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /**
     * 获取机构类型
     *
     * @return office_type - 机构类型
     */
    public String getOffice_type() {
        return office_type;
    }

    /**
     * 设置机构类型
     *
     * @param office_type 机构类型
     */
    public void setOffice_type(String office_type) {
        this.office_type = office_type;
    }

    /**
     * 获取负责人
     *
     * @return leader - 负责人
     */
    public String getLeader() {
        return leader;
    }

    /**
     * 设置负责人
     *
     * @param leader 负责人
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }

    /**
     * 获取办公电话
     *
     * @return phone - 办公电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置办公电话
     *
     * @param phone 办公电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取联系地址
     *
     * @return address - 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置联系地址
     *
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取邮政编码
     *
     * @return zip_code - 邮政编码
     */
    public String getZip_code() {
        return zip_code;
    }

    /**
     * 设置邮政编码
     *
     * @param zip_code 邮政编码
     */
    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * 获取扩展 String 1
     *
     * @return extend_s1 - 扩展 String 1
     */
    public String getExtend_s1() {
        return extend_s1;
    }

    /**
     * 设置扩展 String 1
     *
     * @param extend_s1 扩展 String 1
     */
    public void setExtend_s1(String extend_s1) {
        this.extend_s1 = extend_s1;
    }

    /**
     * 获取扩展 String 2
     *
     * @return extend_s2 - 扩展 String 2
     */
    public String getExtend_s2() {
        return extend_s2;
    }

    /**
     * 设置扩展 String 2
     *
     * @param extend_s2 扩展 String 2
     */
    public void setExtend_s2(String extend_s2) {
        this.extend_s2 = extend_s2;
    }

    /**
     * 获取扩展 String 3
     *
     * @return extend_s3 - 扩展 String 3
     */
    public String getExtend_s3() {
        return extend_s3;
    }

    /**
     * 设置扩展 String 3
     *
     * @param extend_s3 扩展 String 3
     */
    public void setExtend_s3(String extend_s3) {
        this.extend_s3 = extend_s3;
    }

    /**
     * 获取扩展 String 4
     *
     * @return extend_s4 - 扩展 String 4
     */
    public String getExtend_s4() {
        return extend_s4;
    }

    /**
     * 设置扩展 String 4
     *
     * @param extend_s4 扩展 String 4
     */
    public void setExtend_s4(String extend_s4) {
        this.extend_s4 = extend_s4;
    }

    /**
     * 获取扩展 String 5
     *
     * @return extend_s5 - 扩展 String 5
     */
    public String getExtend_s5() {
        return extend_s5;
    }

    /**
     * 设置扩展 String 5
     *
     * @param extend_s5 扩展 String 5
     */
    public void setExtend_s5(String extend_s5) {
        this.extend_s5 = extend_s5;
    }

    /**
     * 获取扩展 String 6
     *
     * @return extend_s6 - 扩展 String 6
     */
    public String getExtend_s6() {
        return extend_s6;
    }

    /**
     * 设置扩展 String 6
     *
     * @param extend_s6 扩展 String 6
     */
    public void setExtend_s6(String extend_s6) {
        this.extend_s6 = extend_s6;
    }

    /**
     * 获取扩展 String 7
     *
     * @return extend_s7 - 扩展 String 7
     */
    public String getExtend_s7() {
        return extend_s7;
    }

    /**
     * 设置扩展 String 7
     *
     * @param extend_s7 扩展 String 7
     */
    public void setExtend_s7(String extend_s7) {
        this.extend_s7 = extend_s7;
    }

    /**
     * 获取扩展 String 8
     *
     * @return extend_s8 - 扩展 String 8
     */
    public String getExtend_s8() {
        return extend_s8;
    }

    /**
     * 设置扩展 String 8
     *
     * @param extend_s8 扩展 String 8
     */
    public void setExtend_s8(String extend_s8) {
        this.extend_s8 = extend_s8;
    }

    /**
     * 获取扩展 Integer 1
     *
     * @return extend_i1 - 扩展 Integer 1
     */
    public BigDecimal getExtend_i1() {
        return extend_i1;
    }

    /**
     * 设置扩展 Integer 1
     *
     * @param extend_i1 扩展 Integer 1
     */
    public void setExtend_i1(BigDecimal extend_i1) {
        this.extend_i1 = extend_i1;
    }

    /**
     * 获取扩展 Integer 2
     *
     * @return extend_i2 - 扩展 Integer 2
     */
    public BigDecimal getExtend_i2() {
        return extend_i2;
    }

    /**
     * 设置扩展 Integer 2
     *
     * @param extend_i2 扩展 Integer 2
     */
    public void setExtend_i2(BigDecimal extend_i2) {
        this.extend_i2 = extend_i2;
    }

    /**
     * 获取扩展 Integer 3
     *
     * @return extend_i3 - 扩展 Integer 3
     */
    public BigDecimal getExtend_i3() {
        return extend_i3;
    }

    /**
     * 设置扩展 Integer 3
     *
     * @param extend_i3 扩展 Integer 3
     */
    public void setExtend_i3(BigDecimal extend_i3) {
        this.extend_i3 = extend_i3;
    }

    /**
     * 获取扩展 Integer 4
     *
     * @return extend_i4 - 扩展 Integer 4
     */
    public BigDecimal getExtend_i4() {
        return extend_i4;
    }

    /**
     * 设置扩展 Integer 4
     *
     * @param extend_i4 扩展 Integer 4
     */
    public void setExtend_i4(BigDecimal extend_i4) {
        this.extend_i4 = extend_i4;
    }

    /**
     * 获取扩展 Float 1
     *
     * @return extend_f1 - 扩展 Float 1
     */
    public BigDecimal getExtend_f1() {
        return extend_f1;
    }

    /**
     * 设置扩展 Float 1
     *
     * @param extend_f1 扩展 Float 1
     */
    public void setExtend_f1(BigDecimal extend_f1) {
        this.extend_f1 = extend_f1;
    }

    /**
     * 获取扩展 Float 2
     *
     * @return extend_f2 - 扩展 Float 2
     */
    public BigDecimal getExtend_f2() {
        return extend_f2;
    }

    /**
     * 设置扩展 Float 2
     *
     * @param extend_f2 扩展 Float 2
     */
    public void setExtend_f2(BigDecimal extend_f2) {
        this.extend_f2 = extend_f2;
    }

    /**
     * 获取扩展 Float 3
     *
     * @return extend_f3 - 扩展 Float 3
     */
    public BigDecimal getExtend_f3() {
        return extend_f3;
    }

    /**
     * 设置扩展 Float 3
     *
     * @param extend_f3 扩展 Float 3
     */
    public void setExtend_f3(BigDecimal extend_f3) {
        this.extend_f3 = extend_f3;
    }

    /**
     * 获取扩展 Float 4
     *
     * @return extend_f4 - 扩展 Float 4
     */
    public BigDecimal getExtend_f4() {
        return extend_f4;
    }

    /**
     * 设置扩展 Float 4
     *
     * @param extend_f4 扩展 Float 4
     */
    public void setExtend_f4(BigDecimal extend_f4) {
        this.extend_f4 = extend_f4;
    }

    /**
     * 获取扩展 Date 1
     *
     * @return extend_d1 - 扩展 Date 1
     */
    public Date getExtend_d1() {
        return extend_d1;
    }

    /**
     * 设置扩展 Date 1
     *
     * @param extend_d1 扩展 Date 1
     */
    public void setExtend_d1(Date extend_d1) {
        this.extend_d1 = extend_d1;
    }

    /**
     * 获取扩展 Date 2
     *
     * @return extend_d2 - 扩展 Date 2
     */
    public Date getExtend_d2() {
        return extend_d2;
    }

    /**
     * 设置扩展 Date 2
     *
     * @param extend_d2 扩展 Date 2
     */
    public void setExtend_d2(Date extend_d2) {
        this.extend_d2 = extend_d2;
    }

    /**
     * 获取扩展 Date 3
     *
     * @return extend_d3 - 扩展 Date 3
     */
    public Date getExtend_d3() {
        return extend_d3;
    }

    /**
     * 设置扩展 Date 3
     *
     * @param extend_d3 扩展 Date 3
     */
    public void setExtend_d3(Date extend_d3) {
        this.extend_d3 = extend_d3;
    }

    /**
     * 获取扩展 Date 4
     *
     * @return extend_d4 - 扩展 Date 4
     */
    public Date getExtend_d4() {
        return extend_d4;
    }

    /**
     * 设置扩展 Date 4
     *
     * @param extend_d4 扩展 Date 4
     */
    public void setExtend_d4(Date extend_d4) {
        this.extend_d4 = extend_d4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", office_code=").append(office_code);
        sb.append(", parent_code=").append(parent_code);
        sb.append(", parent_codes=").append(parent_codes);
        sb.append(", tree_sort=").append(tree_sort);
        sb.append(", tree_sorts=").append(tree_sorts);
        sb.append(", tree_leaf=").append(tree_leaf);
        sb.append(", tree_level=").append(tree_level);
        sb.append(", tree_names=").append(tree_names);
        sb.append(", view_code=").append(view_code);
        sb.append(", office_name=").append(office_name);
        sb.append(", full_name=").append(full_name);
        sb.append(", office_type=").append(office_type);
        sb.append(", leader=").append(leader);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", zip_code=").append(zip_code);
        sb.append(", email=").append(email);
        sb.append(", status=").append(status);
        sb.append(", create_by=").append(create_by);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_by=").append(update_by);
        sb.append(", update_date=").append(update_date);
        sb.append(", remarks=").append(remarks);
        sb.append(", corp_code=").append(corp_code);
        sb.append(", corp_name=").append(corp_name);
        sb.append(", extend_s1=").append(extend_s1);
        sb.append(", extend_s2=").append(extend_s2);
        sb.append(", extend_s3=").append(extend_s3);
        sb.append(", extend_s4=").append(extend_s4);
        sb.append(", extend_s5=").append(extend_s5);
        sb.append(", extend_s6=").append(extend_s6);
        sb.append(", extend_s7=").append(extend_s7);
        sb.append(", extend_s8=").append(extend_s8);
        sb.append(", extend_i1=").append(extend_i1);
        sb.append(", extend_i2=").append(extend_i2);
        sb.append(", extend_i3=").append(extend_i3);
        sb.append(", extend_i4=").append(extend_i4);
        sb.append(", extend_f1=").append(extend_f1);
        sb.append(", extend_f2=").append(extend_f2);
        sb.append(", extend_f3=").append(extend_f3);
        sb.append(", extend_f4=").append(extend_f4);
        sb.append(", extend_d1=").append(extend_d1);
        sb.append(", extend_d2=").append(extend_d2);
        sb.append(", extend_d3=").append(extend_d3);
        sb.append(", extend_d4=").append(extend_d4);
        sb.append("]");
        return sb.toString();
    }
}