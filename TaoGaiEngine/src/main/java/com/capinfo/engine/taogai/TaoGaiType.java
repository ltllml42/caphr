package com.capinfo.engine.taogai;

public enum TaoGaiType {

    GAI1(1,"套改类型一"),
    GAI2(2,"套改类型二");

    private int key;
    private String remarks;

    TaoGaiType(int key, String remarks) {
        this.key = key;
        this.remarks = remarks;
    }
}
