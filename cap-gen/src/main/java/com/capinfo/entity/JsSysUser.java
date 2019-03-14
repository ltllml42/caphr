package com.capinfo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "js_sys_user")
public class JsSysUser implements Serializable {
    /**
     * 用户编码
     */
    @Id
    private String user_code;

    /**
     * 登录账号
     */
    private String login_code;

    /**
     * 用户昵称
     */
    private String user_name;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 办公电话
     */
    private String phone;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 绑定的微信号
     */
    private String wx_openid;

    /**
     * 绑定的手机串号
     */
    private String mobile_imei;

    /**
     * 用户类型
     */
    private String user_type;

    /**
     * 用户类型引用编号
     */
    private String ref_code;

    /**
     * 用户类型引用姓名
     */
    private String ref_name;

    /**
     * 管理员类型（0非管理员 1系统管理员  2二级管理员）
     */
    private String mgr_type;

    /**
     * 密码安全级别（0初始 1很弱 2弱 3安全 4很安全）
     */
    private Short pwd_security_level;

    /**
     * 密码最后更新时间
     */
    private Date pwd_update_date;

    /**
     * 密码修改记录
     */
    private String pwd_update_record;

    /**
     * 密保问题
     */
    private String pwd_question;

    /**
     * 密保问题答案
     */
    private String pwd_question_answer;

    /**
     * 密保问题2
     */
    private String pwd_question_2;

    /**
     * 密保问题答案2
     */
    private String pwd_question_answer_2;

    /**
     * 密保问题3
     */
    private String pwd_question_3;

    /**
     * 密保问题答案3
     */
    private String pwd_question_answer_3;

    /**
     * 密码问题修改时间
     */
    private Date pwd_quest_update_date;

    /**
     * 最后登陆IP
     */
    private String last_login_ip;

    /**
     * 最后登陆时间
     */
    private Date last_login_date;

    /**
     * 冻结时间
     */
    private Date freeze_date;

    /**
     * 冻结原因
     */
    private String freeze_cause;

    /**
     * 用户权重（降序）
     */
    private Integer user_weight;

    /**
     * 状态（0正常 1删除 2停用 3冻结）
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
     * 租户代码
     */
    private String corp_code;

    /**
     * 租户名称
     */
    private String corp_name;

    /**
     * 扩展 String 1
     */
    private String extend_s1;

    /**
     * 扩展 String 2
     */
    private String extend_s2;

    /**
     * 扩展 String 3
     */
    private String extend_s3;

    /**
     * 扩展 String 4
     */
    private String extend_s4;

    /**
     * 扩展 String 5
     */
    private String extend_s5;

    /**
     * 扩展 String 6
     */
    private String extend_s6;

    /**
     * 扩展 String 7
     */
    private String extend_s7;

    /**
     * 扩展 String 8
     */
    private String extend_s8;

    /**
     * 扩展 Integer 1
     */
    private BigDecimal extend_i1;

    /**
     * 扩展 Integer 2
     */
    private BigDecimal extend_i2;

    /**
     * 扩展 Integer 3
     */
    private BigDecimal extend_i3;

    /**
     * 扩展 Integer 4
     */
    private BigDecimal extend_i4;

    /**
     * 扩展 Float 1
     */
    private BigDecimal extend_f1;

    /**
     * 扩展 Float 2
     */
    private BigDecimal extend_f2;

    /**
     * 扩展 Float 3
     */
    private BigDecimal extend_f3;

    /**
     * 扩展 Float 4
     */
    private BigDecimal extend_f4;

    /**
     * 扩展 Date 1
     */
    private Date extend_d1;

    /**
     * 扩展 Date 2
     */
    private Date extend_d2;

    /**
     * 扩展 Date 3
     */
    private Date extend_d3;

    /**
     * 扩展 Date 4
     */
    private Date extend_d4;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户编码
     *
     * @return user_code - 用户编码
     */
    public String getUser_code() {
        return user_code;
    }

    /**
     * 设置用户编码
     *
     * @param user_code 用户编码
     */
    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    /**
     * 获取登录账号
     *
     * @return login_code - 登录账号
     */
    public String getLogin_code() {
        return login_code;
    }

    /**
     * 设置登录账号
     *
     * @param login_code 登录账号
     */
    public void setLogin_code(String login_code) {
        this.login_code = login_code;
    }

    /**
     * 获取用户昵称
     *
     * @return user_name - 用户昵称
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * 设置用户昵称
     *
     * @param user_name 用户昵称
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号码
     *
     * @return mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取办公电话
     *
     * @return phone - 办公电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置办公电话
     *
     * @param phone 办公电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取用户性别
     *
     * @return sex - 用户性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置用户性别
     *
     * @param sex 用户性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取头像路径
     *
     * @return avatar - 头像路径
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像路径
     *
     * @param avatar 头像路径
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取个性签名
     *
     * @return sign - 个性签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置个性签名
     *
     * @param sign 个性签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 获取绑定的微信号
     *
     * @return wx_openid - 绑定的微信号
     */
    public String getWx_openid() {
        return wx_openid;
    }

    /**
     * 设置绑定的微信号
     *
     * @param wx_openid 绑定的微信号
     */
    public void setWx_openid(String wx_openid) {
        this.wx_openid = wx_openid;
    }

    /**
     * 获取绑定的手机串号
     *
     * @return mobile_imei - 绑定的手机串号
     */
    public String getMobile_imei() {
        return mobile_imei;
    }

    /**
     * 设置绑定的手机串号
     *
     * @param mobile_imei 绑定的手机串号
     */
    public void setMobile_imei(String mobile_imei) {
        this.mobile_imei = mobile_imei;
    }

    /**
     * 获取用户类型
     *
     * @return user_type - 用户类型
     */
    public String getUser_type() {
        return user_type;
    }

    /**
     * 设置用户类型
     *
     * @param user_type 用户类型
     */
    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    /**
     * 获取用户类型引用编号
     *
     * @return ref_code - 用户类型引用编号
     */
    public String getRef_code() {
        return ref_code;
    }

    /**
     * 设置用户类型引用编号
     *
     * @param ref_code 用户类型引用编号
     */
    public void setRef_code(String ref_code) {
        this.ref_code = ref_code;
    }

    /**
     * 获取用户类型引用姓名
     *
     * @return ref_name - 用户类型引用姓名
     */
    public String getRef_name() {
        return ref_name;
    }

    /**
     * 设置用户类型引用姓名
     *
     * @param ref_name 用户类型引用姓名
     */
    public void setRef_name(String ref_name) {
        this.ref_name = ref_name;
    }

    /**
     * 获取管理员类型（0非管理员 1系统管理员  2二级管理员）
     *
     * @return mgr_type - 管理员类型（0非管理员 1系统管理员  2二级管理员）
     */
    public String getMgr_type() {
        return mgr_type;
    }

    /**
     * 设置管理员类型（0非管理员 1系统管理员  2二级管理员）
     *
     * @param mgr_type 管理员类型（0非管理员 1系统管理员  2二级管理员）
     */
    public void setMgr_type(String mgr_type) {
        this.mgr_type = mgr_type;
    }

    /**
     * 获取密码安全级别（0初始 1很弱 2弱 3安全 4很安全）
     *
     * @return pwd_security_level - 密码安全级别（0初始 1很弱 2弱 3安全 4很安全）
     */
    public Short getPwd_security_level() {
        return pwd_security_level;
    }

    /**
     * 设置密码安全级别（0初始 1很弱 2弱 3安全 4很安全）
     *
     * @param pwd_security_level 密码安全级别（0初始 1很弱 2弱 3安全 4很安全）
     */
    public void setPwd_security_level(Short pwd_security_level) {
        this.pwd_security_level = pwd_security_level;
    }

    /**
     * 获取密码最后更新时间
     *
     * @return pwd_update_date - 密码最后更新时间
     */
    public Date getPwd_update_date() {
        return pwd_update_date;
    }

    /**
     * 设置密码最后更新时间
     *
     * @param pwd_update_date 密码最后更新时间
     */
    public void setPwd_update_date(Date pwd_update_date) {
        this.pwd_update_date = pwd_update_date;
    }

    /**
     * 获取密码修改记录
     *
     * @return pwd_update_record - 密码修改记录
     */
    public String getPwd_update_record() {
        return pwd_update_record;
    }

    /**
     * 设置密码修改记录
     *
     * @param pwd_update_record 密码修改记录
     */
    public void setPwd_update_record(String pwd_update_record) {
        this.pwd_update_record = pwd_update_record;
    }

    /**
     * 获取密保问题
     *
     * @return pwd_question - 密保问题
     */
    public String getPwd_question() {
        return pwd_question;
    }

    /**
     * 设置密保问题
     *
     * @param pwd_question 密保问题
     */
    public void setPwd_question(String pwd_question) {
        this.pwd_question = pwd_question;
    }

    /**
     * 获取密保问题答案
     *
     * @return pwd_question_answer - 密保问题答案
     */
    public String getPwd_question_answer() {
        return pwd_question_answer;
    }

    /**
     * 设置密保问题答案
     *
     * @param pwd_question_answer 密保问题答案
     */
    public void setPwd_question_answer(String pwd_question_answer) {
        this.pwd_question_answer = pwd_question_answer;
    }

    /**
     * 获取密保问题2
     *
     * @return pwd_question_2 - 密保问题2
     */
    public String getPwd_question_2() {
        return pwd_question_2;
    }

    /**
     * 设置密保问题2
     *
     * @param pwd_question_2 密保问题2
     */
    public void setPwd_question_2(String pwd_question_2) {
        this.pwd_question_2 = pwd_question_2;
    }

    /**
     * 获取密保问题答案2
     *
     * @return pwd_question_answer_2 - 密保问题答案2
     */
    public String getPwd_question_answer_2() {
        return pwd_question_answer_2;
    }

    /**
     * 设置密保问题答案2
     *
     * @param pwd_question_answer_2 密保问题答案2
     */
    public void setPwd_question_answer_2(String pwd_question_answer_2) {
        this.pwd_question_answer_2 = pwd_question_answer_2;
    }

    /**
     * 获取密保问题3
     *
     * @return pwd_question_3 - 密保问题3
     */
    public String getPwd_question_3() {
        return pwd_question_3;
    }

    /**
     * 设置密保问题3
     *
     * @param pwd_question_3 密保问题3
     */
    public void setPwd_question_3(String pwd_question_3) {
        this.pwd_question_3 = pwd_question_3;
    }

    /**
     * 获取密保问题答案3
     *
     * @return pwd_question_answer_3 - 密保问题答案3
     */
    public String getPwd_question_answer_3() {
        return pwd_question_answer_3;
    }

    /**
     * 设置密保问题答案3
     *
     * @param pwd_question_answer_3 密保问题答案3
     */
    public void setPwd_question_answer_3(String pwd_question_answer_3) {
        this.pwd_question_answer_3 = pwd_question_answer_3;
    }

    /**
     * 获取密码问题修改时间
     *
     * @return pwd_quest_update_date - 密码问题修改时间
     */
    public Date getPwd_quest_update_date() {
        return pwd_quest_update_date;
    }

    /**
     * 设置密码问题修改时间
     *
     * @param pwd_quest_update_date 密码问题修改时间
     */
    public void setPwd_quest_update_date(Date pwd_quest_update_date) {
        this.pwd_quest_update_date = pwd_quest_update_date;
    }

    /**
     * 获取最后登陆IP
     *
     * @return last_login_ip - 最后登陆IP
     */
    public String getLast_login_ip() {
        return last_login_ip;
    }

    /**
     * 设置最后登陆IP
     *
     * @param last_login_ip 最后登陆IP
     */
    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    /**
     * 获取最后登陆时间
     *
     * @return last_login_date - 最后登陆时间
     */
    public Date getLast_login_date() {
        return last_login_date;
    }

    /**
     * 设置最后登陆时间
     *
     * @param last_login_date 最后登陆时间
     */
    public void setLast_login_date(Date last_login_date) {
        this.last_login_date = last_login_date;
    }

    /**
     * 获取冻结时间
     *
     * @return freeze_date - 冻结时间
     */
    public Date getFreeze_date() {
        return freeze_date;
    }

    /**
     * 设置冻结时间
     *
     * @param freeze_date 冻结时间
     */
    public void setFreeze_date(Date freeze_date) {
        this.freeze_date = freeze_date;
    }

    /**
     * 获取冻结原因
     *
     * @return freeze_cause - 冻结原因
     */
    public String getFreeze_cause() {
        return freeze_cause;
    }

    /**
     * 设置冻结原因
     *
     * @param freeze_cause 冻结原因
     */
    public void setFreeze_cause(String freeze_cause) {
        this.freeze_cause = freeze_cause;
    }

    /**
     * 获取用户权重（降序）
     *
     * @return user_weight - 用户权重（降序）
     */
    public Integer getUser_weight() {
        return user_weight;
    }

    /**
     * 设置用户权重（降序）
     *
     * @param user_weight 用户权重（降序）
     */
    public void setUser_weight(Integer user_weight) {
        this.user_weight = user_weight;
    }

    /**
     * 获取状态（0正常 1删除 2停用 3冻结）
     *
     * @return status - 状态（0正常 1删除 2停用 3冻结）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除 2停用 3冻结）
     *
     * @param status 状态（0正常 1删除 2停用 3冻结）
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
     * 获取扩展 String 1
     *
     * @return extend_s1 - 扩展 String 1
     */
    public String getExtend_s1() {
        return extend_s1;
    }

    /**
     * 设置扩展 String 1
     *
     * @param extend_s1 扩展 String 1
     */
    public void setExtend_s1(String extend_s1) {
        this.extend_s1 = extend_s1;
    }

    /**
     * 获取扩展 String 2
     *
     * @return extend_s2 - 扩展 String 2
     */
    public String getExtend_s2() {
        return extend_s2;
    }

    /**
     * 设置扩展 String 2
     *
     * @param extend_s2 扩展 String 2
     */
    public void setExtend_s2(String extend_s2) {
        this.extend_s2 = extend_s2;
    }

    /**
     * 获取扩展 String 3
     *
     * @return extend_s3 - 扩展 String 3
     */
    public String getExtend_s3() {
        return extend_s3;
    }

    /**
     * 设置扩展 String 3
     *
     * @param extend_s3 扩展 String 3
     */
    public void setExtend_s3(String extend_s3) {
        this.extend_s3 = extend_s3;
    }

    /**
     * 获取扩展 String 4
     *
     * @return extend_s4 - 扩展 String 4
     */
    public String getExtend_s4() {
        return extend_s4;
    }

    /**
     * 设置扩展 String 4
     *
     * @param extend_s4 扩展 String 4
     */
    public void setExtend_s4(String extend_s4) {
        this.extend_s4 = extend_s4;
    }

    /**
     * 获取扩展 String 5
     *
     * @return extend_s5 - 扩展 String 5
     */
    public String getExtend_s5() {
        return extend_s5;
    }

    /**
     * 设置扩展 String 5
     *
     * @param extend_s5 扩展 String 5
     */
    public void setExtend_s5(String extend_s5) {
        this.extend_s5 = extend_s5;
    }

    /**
     * 获取扩展 String 6
     *
     * @return extend_s6 - 扩展 String 6
     */
    public String getExtend_s6() {
        return extend_s6;
    }

    /**
     * 设置扩展 String 6
     *
     * @param extend_s6 扩展 String 6
     */
    public void setExtend_s6(String extend_s6) {
        this.extend_s6 = extend_s6;
    }

    /**
     * 获取扩展 String 7
     *
     * @return extend_s7 - 扩展 String 7
     */
    public String getExtend_s7() {
        return extend_s7;
    }

    /**
     * 设置扩展 String 7
     *
     * @param extend_s7 扩展 String 7
     */
    public void setExtend_s7(String extend_s7) {
        this.extend_s7 = extend_s7;
    }

    /**
     * 获取扩展 String 8
     *
     * @return extend_s8 - 扩展 String 8
     */
    public String getExtend_s8() {
        return extend_s8;
    }

    /**
     * 设置扩展 String 8
     *
     * @param extend_s8 扩展 String 8
     */
    public void setExtend_s8(String extend_s8) {
        this.extend_s8 = extend_s8;
    }

    /**
     * 获取扩展 Integer 1
     *
     * @return extend_i1 - 扩展 Integer 1
     */
    public BigDecimal getExtend_i1() {
        return extend_i1;
    }

    /**
     * 设置扩展 Integer 1
     *
     * @param extend_i1 扩展 Integer 1
     */
    public void setExtend_i1(BigDecimal extend_i1) {
        this.extend_i1 = extend_i1;
    }

    /**
     * 获取扩展 Integer 2
     *
     * @return extend_i2 - 扩展 Integer 2
     */
    public BigDecimal getExtend_i2() {
        return extend_i2;
    }

    /**
     * 设置扩展 Integer 2
     *
     * @param extend_i2 扩展 Integer 2
     */
    public void setExtend_i2(BigDecimal extend_i2) {
        this.extend_i2 = extend_i2;
    }

    /**
     * 获取扩展 Integer 3
     *
     * @return extend_i3 - 扩展 Integer 3
     */
    public BigDecimal getExtend_i3() {
        return extend_i3;
    }

    /**
     * 设置扩展 Integer 3
     *
     * @param extend_i3 扩展 Integer 3
     */
    public void setExtend_i3(BigDecimal extend_i3) {
        this.extend_i3 = extend_i3;
    }

    /**
     * 获取扩展 Integer 4
     *
     * @return extend_i4 - 扩展 Integer 4
     */
    public BigDecimal getExtend_i4() {
        return extend_i4;
    }

    /**
     * 设置扩展 Integer 4
     *
     * @param extend_i4 扩展 Integer 4
     */
    public void setExtend_i4(BigDecimal extend_i4) {
        this.extend_i4 = extend_i4;
    }

    /**
     * 获取扩展 Float 1
     *
     * @return extend_f1 - 扩展 Float 1
     */
    public BigDecimal getExtend_f1() {
        return extend_f1;
    }

    /**
     * 设置扩展 Float 1
     *
     * @param extend_f1 扩展 Float 1
     */
    public void setExtend_f1(BigDecimal extend_f1) {
        this.extend_f1 = extend_f1;
    }

    /**
     * 获取扩展 Float 2
     *
     * @return extend_f2 - 扩展 Float 2
     */
    public BigDecimal getExtend_f2() {
        return extend_f2;
    }

    /**
     * 设置扩展 Float 2
     *
     * @param extend_f2 扩展 Float 2
     */
    public void setExtend_f2(BigDecimal extend_f2) {
        this.extend_f2 = extend_f2;
    }

    /**
     * 获取扩展 Float 3
     *
     * @return extend_f3 - 扩展 Float 3
     */
    public BigDecimal getExtend_f3() {
        return extend_f3;
    }

    /**
     * 设置扩展 Float 3
     *
     * @param extend_f3 扩展 Float 3
     */
    public void setExtend_f3(BigDecimal extend_f3) {
        this.extend_f3 = extend_f3;
    }

    /**
     * 获取扩展 Float 4
     *
     * @return extend_f4 - 扩展 Float 4
     */
    public BigDecimal getExtend_f4() {
        return extend_f4;
    }

    /**
     * 设置扩展 Float 4
     *
     * @param extend_f4 扩展 Float 4
     */
    public void setExtend_f4(BigDecimal extend_f4) {
        this.extend_f4 = extend_f4;
    }

    /**
     * 获取扩展 Date 1
     *
     * @return extend_d1 - 扩展 Date 1
     */
    public Date getExtend_d1() {
        return extend_d1;
    }

    /**
     * 设置扩展 Date 1
     *
     * @param extend_d1 扩展 Date 1
     */
    public void setExtend_d1(Date extend_d1) {
        this.extend_d1 = extend_d1;
    }

    /**
     * 获取扩展 Date 2
     *
     * @return extend_d2 - 扩展 Date 2
     */
    public Date getExtend_d2() {
        return extend_d2;
    }

    /**
     * 设置扩展 Date 2
     *
     * @param extend_d2 扩展 Date 2
     */
    public void setExtend_d2(Date extend_d2) {
        this.extend_d2 = extend_d2;
    }

    /**
     * 获取扩展 Date 3
     *
     * @return extend_d3 - 扩展 Date 3
     */
    public Date getExtend_d3() {
        return extend_d3;
    }

    /**
     * 设置扩展 Date 3
     *
     * @param extend_d3 扩展 Date 3
     */
    public void setExtend_d3(Date extend_d3) {
        this.extend_d3 = extend_d3;
    }

    /**
     * 获取扩展 Date 4
     *
     * @return extend_d4 - 扩展 Date 4
     */
    public Date getExtend_d4() {
        return extend_d4;
    }

    /**
     * 设置扩展 Date 4
     *
     * @param extend_d4 扩展 Date 4
     */
    public void setExtend_d4(Date extend_d4) {
        this.extend_d4 = extend_d4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user_code=").append(user_code);
        sb.append(", login_code=").append(login_code);
        sb.append(", user_name=").append(user_name);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", mobile=").append(mobile);
        sb.append(", phone=").append(phone);
        sb.append(", sex=").append(sex);
        sb.append(", avatar=").append(avatar);
        sb.append(", sign=").append(sign);
        sb.append(", wx_openid=").append(wx_openid);
        sb.append(", mobile_imei=").append(mobile_imei);
        sb.append(", user_type=").append(user_type);
        sb.append(", ref_code=").append(ref_code);
        sb.append(", ref_name=").append(ref_name);
        sb.append(", mgr_type=").append(mgr_type);
        sb.append(", pwd_security_level=").append(pwd_security_level);
        sb.append(", pwd_update_date=").append(pwd_update_date);
        sb.append(", pwd_update_record=").append(pwd_update_record);
        sb.append(", pwd_question=").append(pwd_question);
        sb.append(", pwd_question_answer=").append(pwd_question_answer);
        sb.append(", pwd_question_2=").append(pwd_question_2);
        sb.append(", pwd_question_answer_2=").append(pwd_question_answer_2);
        sb.append(", pwd_question_3=").append(pwd_question_3);
        sb.append(", pwd_question_answer_3=").append(pwd_question_answer_3);
        sb.append(", pwd_quest_update_date=").append(pwd_quest_update_date);
        sb.append(", last_login_ip=").append(last_login_ip);
        sb.append(", last_login_date=").append(last_login_date);
        sb.append(", freeze_date=").append(freeze_date);
        sb.append(", freeze_cause=").append(freeze_cause);
        sb.append(", user_weight=").append(user_weight);
        sb.append(", status=").append(status);
        sb.append(", create_by=").append(create_by);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_by=").append(update_by);
        sb.append(", update_date=").append(update_date);
        sb.append(", remarks=").append(remarks);
        sb.append(", corp_code=").append(corp_code);
        sb.append(", corp_name=").append(corp_name);
        sb.append(", extend_s1=").append(extend_s1);
        sb.append(", extend_s2=").append(extend_s2);
        sb.append(", extend_s3=").append(extend_s3);
        sb.append(", extend_s4=").append(extend_s4);
        sb.append(", extend_s5=").append(extend_s5);
        sb.append(", extend_s6=").append(extend_s6);
        sb.append(", extend_s7=").append(extend_s7);
        sb.append(", extend_s8=").append(extend_s8);
        sb.append(", extend_i1=").append(extend_i1);
        sb.append(", extend_i2=").append(extend_i2);
        sb.append(", extend_i3=").append(extend_i3);
        sb.append(", extend_i4=").append(extend_i4);
        sb.append(", extend_f1=").append(extend_f1);
        sb.append(", extend_f2=").append(extend_f2);
        sb.append(", extend_f3=").append(extend_f3);
        sb.append(", extend_f4=").append(extend_f4);
        sb.append(", extend_d1=").append(extend_d1);
        sb.append(", extend_d2=").append(extend_d2);
        sb.append(", extend_d3=").append(extend_d3);
        sb.append(", extend_d4=").append(extend_d4);
        sb.append("]");
        return sb.toString();
    }
}