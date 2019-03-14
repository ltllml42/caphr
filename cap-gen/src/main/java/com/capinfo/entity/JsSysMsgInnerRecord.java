package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_msg_inner_record")
public class JsSysMsgInnerRecord implements Serializable {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 所属消息
     */
    private String msg_inner_id;

    /**
     * 接受者用户编码
     */
    private String receive_user_code;

    /**
     * 接受者用户姓名
     */
    private String receive_user_name;

    /**
     * 读取状态（0未送达 1已读 2未读）
     */
    private String read_status;

    /**
     * 阅读时间
     */
    private Date read_date;

    /**
     * 是否标星
     */
    private String is_star;

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
     * 获取所属消息
     *
     * @return msg_inner_id - 所属消息
     */
    public String getMsg_inner_id() {
        return msg_inner_id;
    }

    /**
     * 设置所属消息
     *
     * @param msg_inner_id 所属消息
     */
    public void setMsg_inner_id(String msg_inner_id) {
        this.msg_inner_id = msg_inner_id;
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
     * 获取阅读时间
     *
     * @return read_date - 阅读时间
     */
    public Date getRead_date() {
        return read_date;
    }

    /**
     * 设置阅读时间
     *
     * @param read_date 阅读时间
     */
    public void setRead_date(Date read_date) {
        this.read_date = read_date;
    }

    /**
     * 获取是否标星
     *
     * @return is_star - 是否标星
     */
    public String getIs_star() {
        return is_star;
    }

    /**
     * 设置是否标星
     *
     * @param is_star 是否标星
     */
    public void setIs_star(String is_star) {
        this.is_star = is_star;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", msg_inner_id=").append(msg_inner_id);
        sb.append(", receive_user_code=").append(receive_user_code);
        sb.append(", receive_user_name=").append(receive_user_name);
        sb.append(", read_status=").append(read_status);
        sb.append(", read_date=").append(read_date);
        sb.append(", is_star=").append(is_star);
        sb.append("]");
        return sb.toString();
    }
}