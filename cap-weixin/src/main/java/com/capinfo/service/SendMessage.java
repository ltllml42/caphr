package com.capinfo.service;

import java.util.Date;

public class SendMessage {

    private String content;

    private Date time;

    public SendMessage() {

    }

    public SendMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return new Date();
    }

    public void setTime(Date time) {
        this.time = time;
    }
}