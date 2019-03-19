package com.capinfo.engine.data;

/**
 * version 版本号说明
 */
public enum VersionInfo {

    VERSION_2019("2019","中组部2019年套改方案");
    /**
     * 版本号  和  备注信息
     * @param version
     * @param remarks
     */
    private VersionInfo(String version, String remarks) {
        this.version = version;
        this.remarks = remarks;
    }

    /**
     *  版本号
     */
    private String version;
    /**
     * 描述信息
     */
    private String remarks;

}
