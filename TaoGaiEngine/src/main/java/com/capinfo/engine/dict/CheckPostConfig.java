package com.capinfo.engine.dict;

/**
 * 考核结果
 * 这个表加载到Tomcat容器中  需要缓存支持。
 */
public class CheckPostConfig {
    private String key;//考核结果的Key
    private String checkResult;//考核结果的值  中文
    private String postMonth; //任职年限 月

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getPostMonth() {
        return postMonth;
    }

    public void setPostMonth(String postMonth) {
        this.postMonth = postMonth;
    }
}
