package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_job_log")
public class JsSysJobLog implements Serializable {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 任务名称
     */
    private String job_name;

    /**
     * 任务组名
     */
    private String job_group;

    /**
     * 日志类型
     */
    private String job_type;

    /**
     * 日志事件
     */
    private String job_event;

    /**
     * 日志信息
     */
    private String job_message;

    /**
     * 是否异常
     */
    private String is_exception;

    /**
     * 创建时间
     */
    private Date create_date;

    /**
     * 异常信息
     */
    private String exception_info;

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
     * 获取任务名称
     *
     * @return job_name - 任务名称
     */
    public String getJob_name() {
        return job_name;
    }

    /**
     * 设置任务名称
     *
     * @param job_name 任务名称
     */
    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    /**
     * 获取任务组名
     *
     * @return job_group - 任务组名
     */
    public String getJob_group() {
        return job_group;
    }

    /**
     * 设置任务组名
     *
     * @param job_group 任务组名
     */
    public void setJob_group(String job_group) {
        this.job_group = job_group;
    }

    /**
     * 获取日志类型
     *
     * @return job_type - 日志类型
     */
    public String getJob_type() {
        return job_type;
    }

    /**
     * 设置日志类型
     *
     * @param job_type 日志类型
     */
    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    /**
     * 获取日志事件
     *
     * @return job_event - 日志事件
     */
    public String getJob_event() {
        return job_event;
    }

    /**
     * 设置日志事件
     *
     * @param job_event 日志事件
     */
    public void setJob_event(String job_event) {
        this.job_event = job_event;
    }

    /**
     * 获取日志信息
     *
     * @return job_message - 日志信息
     */
    public String getJob_message() {
        return job_message;
    }

    /**
     * 设置日志信息
     *
     * @param job_message 日志信息
     */
    public void setJob_message(String job_message) {
        this.job_message = job_message;
    }

    /**
     * 获取是否异常
     *
     * @return is_exception - 是否异常
     */
    public String getIs_exception() {
        return is_exception;
    }

    /**
     * 设置是否异常
     *
     * @param is_exception 是否异常
     */
    public void setIs_exception(String is_exception) {
        this.is_exception = is_exception;
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
     * 获取异常信息
     *
     * @return exception_info - 异常信息
     */
    public String getException_info() {
        return exception_info;
    }

    /**
     * 设置异常信息
     *
     * @param exception_info 异常信息
     */
    public void setException_info(String exception_info) {
        this.exception_info = exception_info;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", job_name=").append(job_name);
        sb.append(", job_group=").append(job_group);
        sb.append(", job_type=").append(job_type);
        sb.append(", job_event=").append(job_event);
        sb.append(", job_message=").append(job_message);
        sb.append(", is_exception=").append(is_exception);
        sb.append(", create_date=").append(create_date);
        sb.append(", exception_info=").append(exception_info);
        sb.append("]");
        return sb.toString();
    }
}