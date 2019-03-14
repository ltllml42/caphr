package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_area")
public class JsSysArea implements Serializable {
    /**
     * 区域编码
     */
    @Id
    private String area_code;

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
     * 区域名称
     */
    private String area_name;

    /**
     * 区域类型
     */
    private String area_type;

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
     * 获取区域编码
     *
     * @return area_code - 区域编码
     */
    public String getArea_code() {
        return area_code;
    }

    /**
     * 设置区域编码
     *
     * @param area_code 区域编码
     */
    public void setArea_code(String area_code) {
        this.area_code = area_code;
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
     * 获取区域名称
     *
     * @return area_name - 区域名称
     */
    public String getArea_name() {
        return area_name;
    }

    /**
     * 设置区域名称
     *
     * @param area_name 区域名称
     */
    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    /**
     * 获取区域类型
     *
     * @return area_type - 区域类型
     */
    public String getArea_type() {
        return area_type;
    }

    /**
     * 设置区域类型
     *
     * @param area_type 区域类型
     */
    public void setArea_type(String area_type) {
        this.area_type = area_type;
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
        sb.append(", area_code=").append(area_code);
        sb.append(", parent_code=").append(parent_code);
        sb.append(", parent_codes=").append(parent_codes);
        sb.append(", tree_sort=").append(tree_sort);
        sb.append(", tree_sorts=").append(tree_sorts);
        sb.append(", tree_leaf=").append(tree_leaf);
        sb.append(", tree_level=").append(tree_level);
        sb.append(", tree_names=").append(tree_names);
        sb.append(", area_name=").append(area_name);
        sb.append(", area_type=").append(area_type);
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