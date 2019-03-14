package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "js_sys_job")
public class JsSysJob implements Serializable {
    /**
     * 任务名称
     */
    @Id
    private String job_name;

    /**
     * 任务组名
     */
    @Id
    private String job_group;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 调用目标字符串
     */
    private String invoke_target;

    /**
     * Cron执行表达式
     */
    private String cron_expression;

    /**
     * 计划执行错误策略
     */
    private Short misfire_instruction;

    /**
     * 是否并发执行
     */
    private String concurrent;

    /**
     * 状态（0正常 1删除 2暂停）
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
     * 获取任务描述
     *
     * @return description - 任务描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置任务描述
     *
     * @param description 任务描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取调用目标字符串
     *
     * @return invoke_target - 调用目标字符串
     */
    public String getInvoke_target() {
        return invoke_target;
    }

    /**
     * 设置调用目标字符串
     *
     * @param invoke_target 调用目标字符串
     */
    public void setInvoke_target(String invoke_target) {
        this.invoke_target = invoke_target;
    }

    /**
     * 获取Cron执行表达式
     *
     * @return cron_expression - Cron执行表达式
     */
    public String getCron_expression() {
        return cron_expression;
    }

    /**
     * 设置Cron执行表达式
     *
     * @param cron_expression Cron执行表达式
     */
    public void setCron_expression(String cron_expression) {
        this.cron_expression = cron_expression;
    }

    /**
     * 获取计划执行错误策略
     *
     * @return misfire_instruction - 计划执行错误策略
     */
    public Short getMisfire_instruction() {
        return misfire_instruction;
    }

    /**
     * 设置计划执行错误策略
     *
     * @param misfire_instruction 计划执行错误策略
     */
    public void setMisfire_instruction(Short misfire_instruction) {
        this.misfire_instruction = misfire_instruction;
    }

    /**
     * 获取是否并发执行
     *
     * @return concurrent - 是否并发执行
     */
    public String getConcurrent() {
        return concurrent;
    }

    /**
     * 设置是否并发执行
     *
     * @param concurrent 是否并发执行
     */
    public void setConcurrent(String concurrent) {
        this.concurrent = concurrent;
    }

    /**
     * 获取状态（0正常 1删除 2暂停）
     *
     * @return status - 状态（0正常 1删除 2暂停）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除 2暂停）
     *
     * @param status 状态（0正常 1删除 2暂停）
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
        sb.append(", job_name=").append(job_name);
        sb.append(", job_group=").append(job_group);
        sb.append(", description=").append(description);
        sb.append(", invoke_target=").append(invoke_target);
        sb.append(", cron_expression=").append(cron_expression);
        sb.append(", misfire_instruction=").append(misfire_instruction);
        sb.append(", concurrent=").append(concurrent);
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