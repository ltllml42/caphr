package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_lang")
public class JsSysLang implements Serializable {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 归属模块
     */
    private String module_code;

    /**
     * 语言编码
     */
    private String lang_code;

    /**
     * 语言译文
     */
    private String lang_text;

    /**
     * 语言类型
     */
    private String lang_type;

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
     * 获取归属模块
     *
     * @return module_code - 归属模块
     */
    public String getModule_code() {
        return module_code;
    }

    /**
     * 设置归属模块
     *
     * @param module_code 归属模块
     */
    public void setModule_code(String module_code) {
        this.module_code = module_code;
    }

    /**
     * 获取语言编码
     *
     * @return lang_code - 语言编码
     */
    public String getLang_code() {
        return lang_code;
    }

    /**
     * 设置语言编码
     *
     * @param lang_code 语言编码
     */
    public void setLang_code(String lang_code) {
        this.lang_code = lang_code;
    }

    /**
     * 获取语言译文
     *
     * @return lang_text - 语言译文
     */
    public String getLang_text() {
        return lang_text;
    }

    /**
     * 设置语言译文
     *
     * @param lang_text 语言译文
     */
    public void setLang_text(String lang_text) {
        this.lang_text = lang_text;
    }

    /**
     * 获取语言类型
     *
     * @return lang_type - 语言类型
     */
    public String getLang_type() {
        return lang_type;
    }

    /**
     * 设置语言类型
     *
     * @param lang_type 语言类型
     */
    public void setLang_type(String lang_type) {
        this.lang_type = lang_type;
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
        sb.append(", id=").append(id);
        sb.append(", module_code=").append(module_code);
        sb.append(", lang_code=").append(lang_code);
        sb.append(", lang_text=").append(lang_text);
        sb.append(", lang_type=").append(lang_type);
        sb.append(", create_by=").append(create_by);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_by=").append(update_by);
        sb.append(", update_date=").append(update_date);
        sb.append(", remarks=").append(remarks);
        sb.append("]");
        return sb.toString();
    }
}