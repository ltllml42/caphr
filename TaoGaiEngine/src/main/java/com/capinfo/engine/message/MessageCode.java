package com.capinfo.engine.message;

/**
 * 所有错误信息与编号将
 */
public class MessageCode {

    private boolean flag;
    private Integer code;
    private String msg;

    public MessageCode(){

    }
    public MessageCode(boolean flag, MessageEnum messageEnum, Object... msg) {
        this.code = messageEnum.getCode();
        this.msg = String.format(messageEnum.getMsg(),msg);
    }

    public MessageCode successMessage(MessageEnum messageEnum, Object... msg){
        this.flag = true;
        this.code = messageEnum.getCode();
        this.msg = String.format(messageEnum.getMsg(),msg);
        return this;
    }

    public MessageCode successMessage(){
        this.flag = true;
        return this;
    }


    public MessageCode failMessage(MessageEnum messageEnum, Object... msg){
        this.flag = false;
        this.code = messageEnum.getCode();
        this.msg = String.format(messageEnum.getMsg(),msg);
        return this;
    }

    public MessageCode failMessage(StringBuffer sb){
        this.flag = false;
        this.msg =  sb.toString();
        return this;
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
