package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_msg_inner")
public class JsSysMsgInner implements Serializable {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 消息标题
     */
    private String msg_title;

    /**
     * 内容级别（1普通 2一般 3紧急）
     */
    private String content_level;

    /**
     * 内容类型（1公告 2新闻 3会议 4其它）
     */
    private String content_type;

    /**
     * 接受者类型（1用户 2部门 3角色 4岗位）
     */
    private String receive_type;

    /**
     * 发送者用户编码
     */
    private String send_user_code;

    /**
     * 发送者用户姓名
     */
    private String send_user_name;

    /**
     * 发送时间
     */
    private Date send_date;

    /**
     * 是否有附件
     */
    private String is_attac;

    /**
     * 通知类型（PC APP 短信 邮件 微信）多选
     */
    private String notify_types;

    /**
     * 状态（0正常 1删除 4审核 5驳回 9草稿）
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
     * 消息内容
     */
    private String msg_content;

    /**
     * 接受者字符串
     */
    private String receive_codes;

    /**
     * 接受者名称字符串
     */
    private String receive_names;

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
     * 获取消息标题
     *
     * @return msg_title - 消息标题
     */
    public String getMsg_title() {
        return msg_title;
    }

    /**
     * 设置消息标题
     *
     * @param msg_title 消息标题
     */
    public void setMsg_title(String msg_title) {
        this.msg_title = msg_title;
    }

    /**
     * 获取内容级别（1普通 2一般 3紧急）
     *
     * @return content_level - 内容级别（1普通 2一般 3紧急）
     */
    public String getContent_level() {
        return content_level;
    }

    /**
     * 设置内容级别（1普通 2一般 3紧急）
     *
     * @param content_level 内容级别（1普通 2一般 3紧急）
     */
    public void setContent_level(String content_level) {
        this.content_level = content_level;
    }

    /**
     * 获取内容类型（1公告 2新闻 3会议 4其它）
     *
     * @return content_type - 内容类型（1公告 2新闻 3会议 4其它）
     */
    public String getContent_type() {
        return content_type;
    }

    /**
     * 设置内容类型（1公告 2新闻 3会议 4其它）
     *
     * @param content_type 内容类型（1公告 2新闻 3会议 4其它）
     */
    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    /**
     * 获取接受者类型（1用户 2部门 3角色 4岗位）
     *
     * @return receive_type - 接受者类型（1用户 2部门 3角色 4岗位）
     */
    public String getReceive_type() {
        return receive_type;
    }

    /**
     * 设置接受者类型（1用户 2部门 3角色 4岗位）
     *
     * @param receive_type 接受者类型（1用户 2部门 3角色 4岗位）
     */
    public void setReceive_type(String receive_type) {
        this.receive_type = receive_type;
    }

    /**
     * 获取发送者用户编码
     *
     * @return send_user_code - 发送者用户编码
     */
    public String getSend_user_code() {
        return send_user_code;
    }

    /**
     * 设置发送者用户编码
     *
     * @param send_user_code 发送者用户编码
     */
    public void setSend_user_code(String send_user_code) {
        this.send_user_code = send_user_code;
    }

    /**
     * 获取发送者用户姓名
     *
     * @return send_user_name - 发送者用户姓名
     */
    public String getSend_user_name() {
        return send_user_name;
    }

    /**
     * 设置发送者用户姓名
     *
     * @param send_user_name 发送者用户姓名
     */
    public void setSend_user_name(String send_user_name) {
        this.send_user_name = send_user_name;
    }

    /**
     * 获取发送时间
     *
     * @return send_date - 发送时间
     */
    public Date getSend_date() {
        return send_date;
    }

    /**
     * 设置发送时间
     *
     * @param send_date 发送时间
     */
    public void setSend_date(Date send_date) {
        this.send_date = send_date;
    }

    /**
     * 获取是否有附件
     *
     * @return is_attac - 是否有附件
     */
    public String getIs_attac() {
        return is_attac;
    }

    /**
     * 设置是否有附件
     *
     * @param is_attac 是否有附件
     */
    public void setIs_attac(String is_attac) {
        this.is_attac = is_attac;
    }

    /**
     * 获取通知类型（PC APP 短信 邮件 微信）多选
     *
     * @return notify_types - 通知类型（PC APP 短信 邮件 微信）多选
     */
    public String getNotify_types() {
        return notify_types;
    }

    /**
     * 设置通知类型（PC APP 短信 邮件 微信）多选
     *
     * @param notify_types 通知类型（PC APP 短信 邮件 微信）多选
     */
    public void setNotify_types(String notify_types) {
        this.notify_types = notify_types;
    }

    /**
     * 获取状态（0正常 1删除 4审核 5驳回 9草稿）
     *
     * @return status - 状态（0正常 1删除 4审核 5驳回 9草稿）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除 4审核 5驳回 9草稿）
     *
     * @param status 状态（0正常 1删除 4审核 5驳回 9草稿）
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
     * 获取消息内容
     *
     * @return msg_content - 消息内容
     */
    public String getMsg_content() {
        return msg_content;
    }

    /**
     * 设置消息内容
     *
     * @param msg_content 消息内容
     */
    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content;
    }

    /**
     * 获取接受者字符串
     *
     * @return receive_codes - 接受者字符串
     */
    public String getReceive_codes() {
        return receive_codes;
    }

    /**
     * 设置接受者字符串
     *
     * @param receive_codes 接受者字符串
     */
    public void setReceive_codes(String receive_codes) {
        this.receive_codes = receive_codes;
    }

    /**
     * 获取接受者名称字符串
     *
     * @return receive_names - 接受者名称字符串
     */
    public String getReceive_names() {
        return receive_names;
    }

    /**
     * 设置接受者名称字符串
     *
     * @param receive_names 接受者名称字符串
     */
    public void setReceive_names(String receive_names) {
        this.receive_names = receive_names;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", msg_title=").append(msg_title);
        sb.append(", content_level=").append(content_level);
        sb.append(", content_type=").append(content_type);
        sb.append(", receive_type=").append(receive_type);
        sb.append(", send_user_code=").append(send_user_code);
        sb.append(", send_user_name=").append(send_user_name);
        sb.append(", send_date=").append(send_date);
        sb.append(", is_attac=").append(is_attac);
        sb.append(", notify_types=").append(notify_types);
        sb.append(", status=").append(status);
        sb.append(", create_by=").append(create_by);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_by=").append(update_by);
        sb.append(", update_date=").append(update_date);
        sb.append(", remarks=").append(remarks);
        sb.append(", msg_content=").append(msg_content);
        sb.append(", receive_codes=").append(receive_codes);
        sb.append(", receive_names=").append(receive_names);
        sb.append("]");
        return sb.toString();
    }
}