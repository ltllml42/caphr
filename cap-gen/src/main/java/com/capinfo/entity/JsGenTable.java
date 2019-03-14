package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_gen_table")
public class JsGenTable implements Serializable {
    /**
     * 表名
     */
    @Id
    private String table_name;

    /**
     * 实体类名称
     */
    private String class_name;

    /**
     * 表说明
     */
    private String comments;

    /**
     * 关联父表的表名
     */
    private String parent_table_name;

    /**
     * 本表关联父表的外键名
     */
    private String parent_table_fk_name;

    /**
     * 数据源名称
     */
    private String data_source_name;

    /**
     * 使用的模板
     */
    private String tpl_category;

    /**
     * 生成包路径
     */
    private String package_name;

    /**
     * 生成模块名
     */
    private String module_name;

    /**
     * 生成子模块名
     */
    private String sub_module_name;

    /**
     * 生成功能名
     */
    private String function_name;

    /**
     * 生成功能名（简写）
     */
    private String function_name_simple;

    /**
     * 生成功能作者
     */
    private String function_author;

    /**
     * 生成基础路径
     */
    private String gen_base_dir;

    /**
     * 其它生成选项
     */
    private String options;

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
     * 获取实体类名称
     *
     * @return class_name - 实体类名称
     */
    public String getClass_name() {
        return class_name;
    }

    /**
     * 设置实体类名称
     *
     * @param class_name 实体类名称
     */
    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    /**
     * 获取表说明
     *
     * @return comments - 表说明
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置表说明
     *
     * @param comments 表说明
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 获取关联父表的表名
     *
     * @return parent_table_name - 关联父表的表名
     */
    public String getParent_table_name() {
        return parent_table_name;
    }

    /**
     * 设置关联父表的表名
     *
     * @param parent_table_name 关联父表的表名
     */
    public void setParent_table_name(String parent_table_name) {
        this.parent_table_name = parent_table_name;
    }

    /**
     * 获取本表关联父表的外键名
     *
     * @return parent_table_fk_name - 本表关联父表的外键名
     */
    public String getParent_table_fk_name() {
        return parent_table_fk_name;
    }

    /**
     * 设置本表关联父表的外键名
     *
     * @param parent_table_fk_name 本表关联父表的外键名
     */
    public void setParent_table_fk_name(String parent_table_fk_name) {
        this.parent_table_fk_name = parent_table_fk_name;
    }

    /**
     * 获取数据源名称
     *
     * @return data_source_name - 数据源名称
     */
    public String getData_source_name() {
        return data_source_name;
    }

    /**
     * 设置数据源名称
     *
     * @param data_source_name 数据源名称
     */
    public void setData_source_name(String data_source_name) {
        this.data_source_name = data_source_name;
    }

    /**
     * 获取使用的模板
     *
     * @return tpl_category - 使用的模板
     */
    public String getTpl_category() {
        return tpl_category;
    }

    /**
     * 设置使用的模板
     *
     * @param tpl_category 使用的模板
     */
    public void setTpl_category(String tpl_category) {
        this.tpl_category = tpl_category;
    }

    /**
     * 获取生成包路径
     *
     * @return package_name - 生成包路径
     */
    public String getPackage_name() {
        return package_name;
    }

    /**
     * 设置生成包路径
     *
     * @param package_name 生成包路径
     */
    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    /**
     * 获取生成模块名
     *
     * @return module_name - 生成模块名
     */
    public String getModule_name() {
        return module_name;
    }

    /**
     * 设置生成模块名
     *
     * @param module_name 生成模块名
     */
    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    /**
     * 获取生成子模块名
     *
     * @return sub_module_name - 生成子模块名
     */
    public String getSub_module_name() {
        return sub_module_name;
    }

    /**
     * 设置生成子模块名
     *
     * @param sub_module_name 生成子模块名
     */
    public void setSub_module_name(String sub_module_name) {
        this.sub_module_name = sub_module_name;
    }

    /**
     * 获取生成功能名
     *
     * @return function_name - 生成功能名
     */
    public String getFunction_name() {
        return function_name;
    }

    /**
     * 设置生成功能名
     *
     * @param function_name 生成功能名
     */
    public void setFunction_name(String function_name) {
        this.function_name = function_name;
    }

    /**
     * 获取生成功能名（简写）
     *
     * @return function_name_simple - 生成功能名（简写）
     */
    public String getFunction_name_simple() {
        return function_name_simple;
    }

    /**
     * 设置生成功能名（简写）
     *
     * @param function_name_simple 生成功能名（简写）
     */
    public void setFunction_name_simple(String function_name_simple) {
        this.function_name_simple = function_name_simple;
    }

    /**
     * 获取生成功能作者
     *
     * @return function_author - 生成功能作者
     */
    public String getFunction_author() {
        return function_author;
    }

    /**
     * 设置生成功能作者
     *
     * @param function_author 生成功能作者
     */
    public void setFunction_author(String function_author) {
        this.function_author = function_author;
    }

    /**
     * 获取生成基础路径
     *
     * @return gen_base_dir - 生成基础路径
     */
    public String getGen_base_dir() {
        return gen_base_dir;
    }

    /**
     * 设置生成基础路径
     *
     * @param gen_base_dir 生成基础路径
     */
    public void setGen_base_dir(String gen_base_dir) {
        this.gen_base_dir = gen_base_dir;
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
        sb.append(", table_name=").append(table_name);
        sb.append(", class_name=").append(class_name);
        sb.append(", comments=").append(comments);
        sb.append(", parent_table_name=").append(parent_table_name);
        sb.append(", parent_table_fk_name=").append(parent_table_fk_name);
        sb.append(", data_source_name=").append(data_source_name);
        sb.append(", tpl_category=").append(tpl_category);
        sb.append(", package_name=").append(package_name);
        sb.append(", module_name=").append(module_name);
        sb.append(", sub_module_name=").append(sub_module_name);
        sb.append(", function_name=").append(function_name);
        sb.append(", function_name_simple=").append(function_name_simple);
        sb.append(", function_author=").append(function_author);
        sb.append(", gen_base_dir=").append(gen_base_dir);
        sb.append(", options=").append(options);
        sb.append(", create_by=").append(create_by);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_by=").append(update_by);
        sb.append(", update_date=").append(update_date);
        sb.append(", remarks=").append(remarks);
        sb.append("]");
        return sb.toString();
    }
}