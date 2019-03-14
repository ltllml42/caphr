package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "js_sys_file_entity")
public class JsSysFileEntity implements Serializable {
    /**
     * 文件编号
     */
    @Id
    private String file_id;

    /**
     * 文件MD5
     */
    private String file_md5;

    /**
     * 文件相对路径
     */
    private String file_path;

    /**
     * 文件内容类型
     */
    private String file_content_type;

    /**
     * 文件后缀扩展名
     */
    private String file_extension;

    /**
     * 文件大小(单位B)
     */
    private BigDecimal file_size;

    private static final long serialVersionUID = 1L;

    /**
     * 获取文件编号
     *
     * @return file_id - 文件编号
     */
    public String getFile_id() {
        return file_id;
    }

    /**
     * 设置文件编号
     *
     * @param file_id 文件编号
     */
    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    /**
     * 获取文件MD5
     *
     * @return file_md5 - 文件MD5
     */
    public String getFile_md5() {
        return file_md5;
    }

    /**
     * 设置文件MD5
     *
     * @param file_md5 文件MD5
     */
    public void setFile_md5(String file_md5) {
        this.file_md5 = file_md5;
    }

    /**
     * 获取文件相对路径
     *
     * @return file_path - 文件相对路径
     */
    public String getFile_path() {
        return file_path;
    }

    /**
     * 设置文件相对路径
     *
     * @param file_path 文件相对路径
     */
    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    /**
     * 获取文件内容类型
     *
     * @return file_content_type - 文件内容类型
     */
    public String getFile_content_type() {
        return file_content_type;
    }

    /**
     * 设置文件内容类型
     *
     * @param file_content_type 文件内容类型
     */
    public void setFile_content_type(String file_content_type) {
        this.file_content_type = file_content_type;
    }

    /**
     * 获取文件后缀扩展名
     *
     * @return file_extension - 文件后缀扩展名
     */
    public String getFile_extension() {
        return file_extension;
    }

    /**
     * 设置文件后缀扩展名
     *
     * @param file_extension 文件后缀扩展名
     */
    public void setFile_extension(String file_extension) {
        this.file_extension = file_extension;
    }

    /**
     * 获取文件大小(单位B)
     *
     * @return file_size - 文件大小(单位B)
     */
    public BigDecimal getFile_size() {
        return file_size;
    }

    /**
     * 设置文件大小(单位B)
     *
     * @param file_size 文件大小(单位B)
     */
    public void setFile_size(BigDecimal file_size) {
        this.file_size = file_size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", file_id=").append(file_id);
        sb.append(", file_md5=").append(file_md5);
        sb.append(", file_path=").append(file_path);
        sb.append(", file_content_type=").append(file_content_type);
        sb.append(", file_extension=").append(file_extension);
        sb.append(", file_size=").append(file_size);
        sb.append("]");
        return sb.toString();
    }
}