package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_msg_pushed")
public class JsSysMsgPushed implements Serializable {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 消息类型（PC APP 短信 邮件 微信）
     */
    private String msg_type;

    /**
     * 消息标题
     */
    private String msg_title;

    /**
     * 业务主键
     */
    private String biz_key;

    /**
     * 业务类型
     */
    private String biz_type;

    /**
     * 接受者账号
     */
    private String receive_code;

    /**
     * 接受者用户编码
     */
    private String receive_user_code;

    /**
     * 接受者用户姓名
     */
    private String receive_user_name;

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
     * 是否合并推送
     */
    private String is_merge_push;

    /**
     * 计划推送时间
     */
    private Date plan_push_date;

    /**
     * 推送尝试次数
     */
    private Integer push_number;

    /**
     * 推送返回结果码
     */
    private String push_return_code;

    /**
     * 推送返回消息编号
     */
    private String push_return_msg_id;

    /**
     * 推送状态（0未推送 1成功  2失败）
     */
    private String push_status;

    /**
     * 推送时间
     */
    private Date push_date;

    /**
     * 读取状态（0未送达 1已读 2未读）
     */
    private String read_status;

    /**
     * 读取时间
     */
    private Date read_date;

    /**
     * 消息内容
     */
    private String msg_content;

    /**
     * 推送返回的内容信息
     */
    private String push_return_content;

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
     * 获取消息类型（PC APP 短信 邮件 微信）
     *
     * @return msg_type - 消息类型（PC APP 短信 邮件 微信）
     */
    public String getMsg_type() {
        return msg_type;
    }

    /**
     * 设置消息类型（PC APP 短信 邮件 微信）
     *
     * @param msg_type 消息类型（PC APP 短信 邮件 微信）
     */
    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
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
     * 获取业务主键
     *
     * @return biz_key - 业务主键
     */
    public String getBiz_key() {
        return biz_key;
    }

    /**
     * 设置业务主键
     *
     * @param biz_key 业务主键
     */
    public void setBiz_key(String biz_key) {
        this.biz_key = biz_key;
    }

    /**
     * 获取业务类型
     *
     * @return biz_type - 业务类型
     */
    public String getBiz_type() {
        return biz_type;
    }

    /**
     * 设置业务类型
     *
     * @param biz_type 业务类型
     */
    public void setBiz_type(String biz_type) {
        this.biz_type = biz_type;
    }

    /**
     * 获取接受者账号
     *
     * @return receive_code - 接受者账号
     */
    public String getReceive_code() {
        return receive_code;
    }

    /**
     * 设置接受者账号
     *
     * @param receive_code 接受者账号
     */
    public void setReceive_code(String receive_code) {
        this.receive_code = receive_code;
    }

    /**
     * 获取接受者用户编码
     *
     * @return receive_user_code - 接受者用户编码
     */
    public String getReceive_user_code() {
        return receive_user_code;
    }

    /**
     * 设置接受者用户编码
     *
     * @param receive_user_code 接受者用户编码
     */
    public void setReceive_user_code(String receive_user_code) {
        this.receive_user_code = receive_user_code;
    }

    /**
     * 获取接受者用户姓名
     *
     * @return receive_user_name - 接受者用户姓名
     */
    public String getReceive_user_name() {
        return receive_user_name;
    }

    /**
     * 设置接受者用户姓名
     *
     * @param receive_user_name 接受者用户姓名
     */
    public void setReceive_user_name(String receive_user_name) {
        this.receive_user_name = receive_user_name;
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
     * 获取是否合并推送
     *
     * @return is_merge_push - 是否合并推送
     */
    public String getIs_merge_push() {
        return is_merge_push;
    }

    /**
     * 设置是否合并推送
     *
     * @param is_merge_push 是否合并推送
     */
    public void setIs_merge_push(String is_merge_push) {
        this.is_merge_push = is_merge_push;
    }

    /**
     * 获取计划推送时间
     *
     * @return plan_push_date - 计划推送时间
     */
    public Date getPlan_push_date() {
        return plan_push_date;
    }

    /**
     * 设置计划推送时间
     *
     * @param plan_push_date 计划推送时间
     */
    public void setPlan_push_date(Date plan_push_date) {
        this.plan_push_date = plan_push_date;
    }

    /**
     * 获取推送尝试次数
     *
     * @return push_number - 推送尝试次数
     */
    public Integer getPush_number() {
        return push_number;
    }

    /**
     * 设置推送尝试次数
     *
     * @param push_number 推送尝试次数
     */
    public void setPush_number(Integer push_number) {
        this.push_number = push_number;
    }

    /**
     * 获取推送返回结果码
     *
     * @return push_return_code - 推送返回结果码
     */
    public String getPush_return_code() {
        return push_return_code;
    }

    /**
     * 设置推送返回结果码
     *
     * @param push_return_code 推送返回结果码
     */
    public void setPush_return_code(String push_return_code) {
        this.push_return_code = push_return_code;
    }

    /**
     * 获取推送返回消息编号
     *
     * @return push_return_msg_id - 推送返回消息编号
     */
    public String getPush_return_msg_id() {
        return push_return_msg_id;
    }

    /**
     * 设置推送返回消息编号
     *
     * @param push_return_msg_id 推送返回消息编号
     */
    public void setPush_return_msg_id(String push_return_msg_id) {
        this.push_return_msg_id = push_return_msg_id;
    }

    /**
     * 获取推送状态（0未推送 1成功  2失败）
     *
     * @return push_status - 推送状态（0未推送 1成功  2失败）
     */
    public String getPush_status() {
        return push_status;
    }

    /**
     * 设置推送状态（0未推送 1成功  2失败）
     *
     * @param push_status 推送状态（0未推送 1成功  2失败）
     */
    public void setPush_status(String push_status) {
        this.push_status = push_status;
    }

    /**
     * 获取推送时间
     *
     * @return push_date - 推送时间
     */
    public Date getPush_date() {
        return push_date;
    }

    /**
     * 设置推送时间
     *
     * @param push_date 推送时间
     */
    public void setPush_date(Date push_date) {
        this.push_date = push_date;
    }

    /**
     * 获取读取状态（0未送达 1已读 2未读）
     *
     * @return read_status - 读取状态（0未送达 1已读 2未读）
     */
    public String getRead_status() {
        return read_status;
    }

    /**
     * 设置读取状态（0未送达 1已读 2未读）
     *
     * @param read_status 读取状态（0未送达 1已读 2未读）
     */
    public void setRead_status(String read_status) {
        this.read_status = read_status;
    }

    /**
     * 获取读取时间
     *
     * @return read_date - 读取时间
     */
    public Date getRead_date() {
        return read_date;
    }

    /**
     * 设置读取时间
     *
     * @param read_date 读取时间
     */
    public void setRead_date(Date read_date) {
        this.read_date = read_date;
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
     * 获取推送返回的内容信息
     *
     * @return push_return_content - 推送返回的内容信息
     */
    public String getPush_return_content() {
        return push_return_content;
    }

    /**
     * 设置推送返回的内容信息
     *
     * @param push_return_content 推送返回的内容信息
     */
    public void setPush_return_content(String push_return_content) {
        this.push_return_content = push_return_content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", msg_type=").append(msg_type);
        sb.append(", msg_title=").append(msg_title);
        sb.append(", biz_key=").append(biz_key);
        sb.append(", biz_type=").append(biz_type);
        sb.append(", receive_code=").append(receive_code);
        sb.append(", receive_user_code=").append(receive_user_code);
        sb.append(", receive_user_name=").append(receive_user_name);
        sb.append(", send_user_code=").append(send_user_code);
        sb.append(", send_user_name=").append(send_user_name);
        sb.append(", send_date=").append(send_date);
        sb.append(", is_merge_push=").append(is_merge_push);
        sb.append(", plan_push_date=").append(plan_push_date);
        sb.append(", push_number=").append(push_number);
        sb.append(", push_return_code=").append(push_return_code);
        sb.append(", push_return_msg_id=").append(push_return_msg_id);
        sb.append(", push_status=").append(push_status);
        sb.append(", push_date=").append(push_date);
        sb.append(", read_status=").append(read_status);
        sb.append(", read_date=").append(read_date);
        sb.append(", msg_content=").append(msg_content);
        sb.append(", push_return_content=").append(push_return_content);
        sb.append("]");
        return sb.toString();
    }
}