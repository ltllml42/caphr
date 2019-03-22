package com.capinfo.engine.taogai;


/**
 *
 */





public enum TaoGaiType {

    GAI1(1,"县以下职级职级"),
    GAI2(2,"非领导职务的"),
    GAI3(3,"领导职务不套改，插入数据");

    private int key;
    private String remarks;

    TaoGaiType(int key, String remarks) {
        this.key = key;
        this.remarks = remarks;
    }



}
