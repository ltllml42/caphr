package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "js_sys_log")
public class JsSysLog implements Serializable {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 日志类型
     */
    private String log_type;

    /**
     * 日志标题
     */
    private String log_title;

    /**
     * 创建者
     */
    private String create_by;

    /**
     * 用户名称
     */
    private String create_by_name;

    /**
     * 创建时间
     */
    private Date create_date;

    /**
     * 请求URI
     */
    private String request_uri;

    /**
     * 操作方式
     */
    private String request_method;

    /**
     * 业务主键
     */
    private String biz_key;

    /**
     * 业务类型
     */
    private String biz_type;

    /**
     * 操作IP地址
     */
    private String remote_addr;

    /**
     * 请求服务器地址
     */
    private String server_addr;

    /**
     * 是否异常
     */
    private String is_exception;

    /**
     * 用户代理
     */
    private String user_agent;

    /**
     * 设备名称/操作系统
     */
    private String device_name;

    /**
     * 浏览器名称
     */
    private String browser_name;

    /**
     * 执行时间
     */
    private BigDecimal execute_time;

    /**
     * 租户代码
     */
    private String corp_code;

    /**
     * 租户名称
     */
    private String corp_name;

    /**
     * 操作提交的数据
     */
    private String request_params;

    /**
     * 新旧数据比较结果
     */
    private String diff_modify_data;

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
     * 获取日志类型
     *
     * @return log_type - 日志类型
     */
    public String getLog_type() {
        return log_type;
    }

    /**
     * 设置日志类型
     *
     * @param log_type 日志类型
     */
    public void setLog_type(String log_type) {
        this.log_type = log_type;
    }

    /**
     * 获取日志标题
     *
     * @return log_title - 日志标题
     */
    public String getLog_title() {
        return log_title;
    }

    /**
     * 设置日志标题
     *
     * @param log_title 日志标题
     */
    public void setLog_title(String log_title) {
        this.log_title = log_title;
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
     * 获取用户名称
     *
     * @return create_by_name - 用户名称
     */
    public String getCreate_by_name() {
        return create_by_name;
    }

    /**
     * 设置用户名称
     *
     * @param create_by_name 用户名称
     */
    public void setCreate_by_name(String create_by_name) {
        this.create_by_name = create_by_name;
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
     * 获取请求URI
     *
     * @return request_uri - 请求URI
     */
    public String getRequest_uri() {
        return request_uri;
    }

    /**
     * 设置请求URI
     *
     * @param request_uri 请求URI
     */
    public void setRequest_uri(String request_uri) {
        this.request_uri = request_uri;
    }

    /**
     * 获取操作方式
     *
     * @return request_method - 操作方式
     */
    public String getRequest_method() {
        return request_method;
    }

    /**
     * 设置操作方式
     *
     * @param request_method 操作方式
     */
    public void setRequest_method(String request_method) {
        this.request_method = request_method;
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
     * 获取操作IP地址
     *
     * @return remote_addr - 操作IP地址
     */
    public String getRemote_addr() {
        return remote_addr;
    }

    /**
     * 设置操作IP地址
     *
     * @param remote_addr 操作IP地址
     */
    public void setRemote_addr(String remote_addr) {
        this.remote_addr = remote_addr;
    }

    /**
     * 获取请求服务器地址
     *
     * @return server_addr - 请求服务器地址
     */
    public String getServer_addr() {
        return server_addr;
    }

    /**
     * 设置请求服务器地址
     *
     * @param server_addr 请求服务器地址
     */
    public void setServer_addr(String server_addr) {
        this.server_addr = server_addr;
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
     * 获取用户代理
     *
     * @return user_agent - 用户代理
     */
    public String getUser_agent() {
        return user_agent;
    }

    /**
     * 设置用户代理
     *
     * @param user_agent 用户代理
     */
    public void setUser_agent(String user_agent) {
        this.user_agent = user_agent;
    }

    /**
     * 获取设备名称/操作系统
     *
     * @return device_name - 设备名称/操作系统
     */
    public String getDevice_name() {
        return device_name;
    }

    /**
     * 设置设备名称/操作系统
     *
     * @param device_name 设备名称/操作系统
     */
    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    /**
     * 获取浏览器名称
     *
     * @return browser_name - 浏览器名称
     */
    public String getBrowser_name() {
        return browser_name;
    }

    /**
     * 设置浏览器名称
     *
     * @param browser_name 浏览器名称
     */
    public void setBrowser_name(String browser_name) {
        this.browser_name = browser_name;
    }

    /**
     * 获取执行时间
     *
     * @return execute_time - 执行时间
     */
    public BigDecimal getExecute_time() {
        return execute_time;
    }

    /**
     * 设置执行时间
     *
     * @param execute_time 执行时间
     */
    public void setExecute_time(BigDecimal execute_time) {
        this.execute_time = execute_time;
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

    /**
     * 获取操作提交的数据
     *
     * @return request_params - 操作提交的数据
     */
    public String getRequest_params() {
        return request_params;
    }

    /**
     * 设置操作提交的数据
     *
     * @param request_params 操作提交的数据
     */
    public void setRequest_params(String request_params) {
        this.request_params = request_params;
    }

    /**
     * 获取新旧数据比较结果
     *
     * @return diff_modify_data - 新旧数据比较结果
     */
    public String getDiff_modify_data() {
        return diff_modify_data;
    }

    /**
     * 设置新旧数据比较结果
     *
     * @param diff_modify_data 新旧数据比较结果
     */
    public void setDiff_modify_data(String diff_modify_data) {
        this.diff_modify_data = diff_modify_data;
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
        sb.append(", log_type=").append(log_type);
        sb.append(", log_title=").append(log_title);
        sb.append(", create_by=").append(create_by);
        sb.append(", create_by_name=").append(create_by_name);
        sb.append(", create_date=").append(create_date);
        sb.append(", request_uri=").append(request_uri);
        sb.append(", request_method=").append(request_method);
        sb.append(", biz_key=").append(biz_key);
        sb.append(", biz_type=").append(biz_type);
        sb.append(", remote_addr=").append(remote_addr);
        sb.append(", server_addr=").append(server_addr);
        sb.append(", is_exception=").append(is_exception);
        sb.append(", user_agent=").append(user_agent);
        sb.append(", device_name=").append(device_name);
        sb.append(", browser_name=").append(browser_name);
        sb.append(", execute_time=").append(execute_time);
        sb.append(", corp_code=").append(corp_code);
        sb.append(", corp_name=").append(corp_name);
        sb.append(", request_params=").append(request_params);
        sb.append(", diff_modify_data=").append(diff_modify_data);
        sb.append(", exception_info=").append(exception_info);
        sb.append("]");
        return sb.toString();
    }
}