package com.capinfo.engine.message;

/**
 *   操作成功  2XX 开头
 *   李陶琳  0XX 开头
 *   韩王栋  1XX 开头
 *   丁晓东  3XX 开头
 *   吴小萌  4XX 开头
 *   邱建辉  5XX 开头
 *   孙本进  6XX 开头
 */
public enum MessageEnum {
    OK_CODE(200,"操作成功"),
    LI_CODE_01(1,"%s 年度考核结果为 %s,增加任职年限 %s"),
    LI_CODE_02(2,"元数据解析错误对象为空"),
    LI_CODE_03(3,"对象解析异常:传入的对象应该为 %s不应该为 %s"),
    LI_CODE_04(4,"解析对象不能为空"),
    LI_CODE_05(5,"当前人员：%s 身份证号码为:%s 还未套改，请先套改后再晋升"),
    LI_CODE_06(6,"当前人员：%s 身份证号码为:%s 字段%s不能为空"),
    LI_CODE_07(7,"当前人员：%s 身份证号码为:%s 没有套改数据"),
    LI_CODE_08(8,"当前人员：%s 身份证号码为:%s 套改数据不正确"),
    LI_CODE_09(12,"当前人员：%s 身份证号码为:%s 套改前职务层次时间"),
    ERROR_CODE_CASE(9,"不能将类 %s 转化为 %s "),
    ERROR_CODE_NULL(10,"空指针异常 对象 %s 为空"),
    ERROR_CODE_NULL_DIC(11,"数据字典 对象 %s 加载失败"),
    ERROR_CODE_UNKNOWN(12,"未知异常")
    ;


    MessageEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
