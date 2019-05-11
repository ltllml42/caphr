package com.capinfo.utils;


import java.io.Serializable;

public class ResultData implements Serializable {

    private boolean flag;

    private String msg;

    private Object data;

    public ResultData() {
    }

    public ResultData(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultData error(String msg){
        return new ResultData(false,msg);
    }
    public  static ResultData sucess(String msg){
        return new ResultData(true,msg);
    }

}
