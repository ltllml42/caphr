package com.capinfo.engine;

/**
 * 套改日志
 */
public class TaoGaiLogger {


    private String level;

    private String msg;

    public TaoGaiLogger(String level, String msg) {
        this.level = level;
        this.msg = msg;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
