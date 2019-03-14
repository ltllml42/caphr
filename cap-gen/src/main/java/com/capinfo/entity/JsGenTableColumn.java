package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "js_gen_table_column")
public class JsGenTableColumn implements Serializable {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 表名
     */
    private String table_name;

    /**
     * 列名
     */
    private String column_name;

    /**
     * 列排序（升序）
     */
    private Long column_sort;

    /**
     * 类型
     */
    private String column_type;

    /**
     * 列标签名
     */
    private String column_label;

    /**
     * 列备注说明
     */
    private String comments;

    /**
     * 类的属性名
     */
    private String attr_name;

    /**
     * 类的属性类型
     */
    private String attr_type;

    /**
     * 是否主键
     */
    private String is_pk;

    /**
     * 是否可为空
     */
    private String is_null;

    /**
     * 是否插入字段
     */
    private String is_insert;

    /**
     * 是否更新字段
     */
    private String is_update;

    /**
     * 是否列表字段
     */
    private String is_list;

    /**
     * 是否查询字段
     */
    private String is_query;

    /**
     * 查询方式
     */
    private String query_type;

    /**
     * 是否编辑字段
     */
    private String is_edit;

    /**
     * 表单类型
     */
    private String show_type;

    /**
     * 其它生成选项
     */
    private String options;

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取表名
     *
     * @return table_name - 表名
     */
    public String getTable_name() {
        return table_name;
    }

    /**
     * 设置表名
     *
     * @param table_name 表名
     */
    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    /**
     * 获取列名
     *
     * @return column_name - 列名
     */
    public String getColumn_name() {
        return column_name;
    }

    /**
     * 设置列名
     *
     * @param column_name 列名
     */
    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    /**
     * 获取列排序（升序）
     *
     * @return column_sort - 列排序（升序）
     */
    public Long getColumn_sort() {
        return column_sort;
    }

    /**
     * 设置列排序（升序）
     *
     * @param column_sort 列排序（升序）
     */
    public void setColumn_sort(Long column_sort) {
        this.column_sort = column_sort;
    }

    /**
     * 获取类型
     *
     * @return column_type - 类型
     */
    public String getColumn_type() {
        return column_type;
    }

    /**
     * 设置类型
     *
     * @param column_type 类型
     */
    public void setColumn_type(String column_type) {
        this.column_type = column_type;
    }

    /**
     * 获取列标签名
     *
     * @return column_label - 列标签名
     */
    public String getColumn_label() {
        return column_label;
    }

    /**
     * 设置列标签名
     *
     * @param column_label 列标签名
     */
    public void setColumn_label(String column_label) {
        this.column_label = column_label;
    }

    /**
     * 获取列备注说明
     *
     * @return comments - 列备注说明
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置列备注说明
     *
     * @param comments 列备注说明
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 获取类的属性名
     *
     * @return attr_name - 类的属性名
     */
    public String getAttr_name() {
        return attr_name;
    }

    /**
     * 设置类的属性名
     *
     * @param attr_name 类的属性名
     */
    public void setAttr_name(String attr_name) {
        this.attr_name = attr_name;
    }

    /**
     * 获取类的属性类型
     *
     * @return attr_type - 类的属性类型
     */
    public String getAttr_type() {
        return attr_type;
    }

    /**
     * 设置类的属性类型
     *
     * @param attr_type 类的属性类型
     */
    public void setAttr_type(String attr_type) {
        this.attr_type = attr_type;
    }

    /**
     * 获取是否主键
     *
     * @return is_pk - 是否主键
     */
    public String getIs_pk() {
        return is_pk;
    }

    /**
     * 设置是否主键
     *
     * @param is_pk 是否主键
     */
    public void setIs_pk(String is_pk) {
        this.is_pk = is_pk;
    }

    /**
     * 获取是否可为空
     *
     * @return is_null - 是否可为空
     */
    public String getIs_null() {
        return is_null;
    }

    /**
     * 设置是否可为空
     *
     * @param is_null 是否可为空
     */
    public void setIs_null(String is_null) {
        this.is_null = is_null;
    }

    /**
     * 获取是否插入字段
     *
     * @return is_insert - 是否插入字段
     */
    public String getIs_insert() {
        return is_insert;
    }

    /**
     * 设置是否插入字段
     *
     * @param is_insert 是否插入字段
     */
    public void setIs_insert(String is_insert) {
        this.is_insert = is_insert;
    }

    /**
     * 获取是否更新字段
     *
     * @return is_update - 是否更新字段
     */
    public String getIs_update() {
        return is_update;
    }

    /**
     * 设置是否更新字段
     *
     * @param is_update 是否更新字段
     */
    public void setIs_update(String is_update) {
        this.is_update = is_update;
    }

    /**
     * 获取是否列表字段
     *
     * @return is_list - 是否列表字段
     */
    public String getIs_list() {
        return is_list;
    }

    /**
     * 设置是否列表字段
     *
     * @param is_list 是否列表字段
     */
    public void setIs_list(String is_list) {
        this.is_list = is_list;
    }

    /**
     * 获取是否查询字段
     *
     * @return is_query - 是否查询字段
     */
    public String getIs_query() {
        return is_query;
    }

    /**
     * 设置是否查询字段
     *
     * @param is_query 是否查询字段
     */
    public void setIs_query(String is_query) {
        this.is_query = is_query;
    }

    /**
     * 获取查询方式
     *
     * @return query_type - 查询方式
     */
    public String getQuery_type() {
        return query_type;
    }

    /**
     * 设置查询方式
     *
     * @param query_type 查询方式
     */
    public void setQuery_type(String query_type) {
        this.query_type = query_type;
    }

    /**
     * 获取是否编辑字段
     *
     * @return is_edit - 是否编辑字段
     */
    public String getIs_edit() {
        return is_edit;
    }

    /**
     * 设置是否编辑字段
     *
     * @param is_edit 是否编辑字段
     */
    public void setIs_edit(String is_edit) {
        this.is_edit = is_edit;
    }

    /**
     * 获取表单类型
     *
     * @return show_type - 表单类型
     */
    public String getShow_type() {
        return show_type;
    }

    /**
     * 设置表单类型
     *
     * @param show_type 表单类型
     */
    public void setShow_type(String show_type) {
        this.show_type = show_type;
    }

    /**
     * 获取其它生成选项
     *
     * @return options - 其它生成选项
     */
    public String getOptions() {
        return options;
    }

    /**
     * 设置其它生成选项
     *
     * @param options 其它生成选项
     */
    public void setOptions(String options) {
        this.options = options;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", table_name=").append(table_name);
        sb.append(", column_name=").append(column_name);
        sb.append(", column_sort=").append(column_sort);
        sb.append(", column_type=").append(column_type);
        sb.append(", column_label=").append(column_label);
        sb.append(", comments=").append(comments);
        sb.append(", attr_name=").append(attr_name);
        sb.append(", attr_type=").append(attr_type);
        sb.append(", is_pk=").append(is_pk);
        sb.append(", is_null=").append(is_null);
        sb.append(", is_insert=").append(is_insert);
        sb.append(", is_update=").append(is_update);
        sb.append(", is_list=").append(is_list);
        sb.append(", is_query=").append(is_query);
        sb.append(", query_type=").append(query_type);
        sb.append(", is_edit=").append(is_edit);
        sb.append(", show_type=").append(show_type);
        sb.append(", options=").append(options);
        sb.append("]");
        return sb.toString();
    }
}