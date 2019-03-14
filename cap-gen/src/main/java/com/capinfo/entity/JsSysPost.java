package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_post")
public class JsSysPost implements Serializable {
    /**
     * 岗位编码
     */
    @Id
    private String post_code;

    /**
     * 岗位名称
     */
    private String post_name;

    /**
     * 岗位分类（高管、中层、基层）
     */
    private String post_type;

    /**
     * 岗位排序（升序）
     */
    private Long post_sort;

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

    /**
     * 获取岗位名称
     *
     * @return post_name - 岗位名称
     */
    public String getPost_name() {
        return post_name;
    }

    /**
     * 设置岗位名称
     *
     * @param post_name 岗位名称
     */
    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    /**
     * 获取岗位分类（高管、中层、基层）
     *
     * @return post_type - 岗位分类（高管、中层、基层）
     */
    public String getPost_type() {
        return post_type;
    }

    /**
     * 设置岗位分类（高管、中层、基层）
     *
     * @param post_type 岗位分类（高管、中层、基层）
     */
    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    /**
     * 获取岗位排序（升序）
     *
     * @return post_sort - 岗位排序（升序）
     */
    public Long getPost_sort() {
        return post_sort;
    }

    /**
     * 设置岗位排序（升序）
     *
     * @param post_sort 岗位排序（升序）
     */
    public void setPost_sort(Long post_sort) {
        this.post_sort = post_sort;
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
        sb.append(", post_code=").append(post_code);
        sb.append(", post_name=").append(post_name);
        sb.append(", post_type=").append(post_type);
        sb.append(", post_sort=").append(post_sort);
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