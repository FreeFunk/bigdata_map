package com.edgedo.bigdata.entity;

/**
 * @ClassName FileVo
 * @Description TODO
 * @Author 床前明月光
 * @Date 2019/11/19 14:46
 **/
public class AttachFileVo {

    private Integer FILE_SIZE;

    private Integer FILE_FORMAT;

    private String FILE_MD5;

    private Integer FILE_TYPE;

    private String FILE_NAME;

    private String FILE_URL;

    public Integer getFILE_SIZE() {
        return FILE_SIZE;
    }

    public void setFILE_SIZE(Integer FILE_SIZE) {
        this.FILE_SIZE = FILE_SIZE;
    }

    public Integer getFILE_FORMAT() {
        return FILE_FORMAT;
    }

    public void setFILE_FORMAT(Integer FILE_FORMAT) {
        this.FILE_FORMAT = FILE_FORMAT;
    }

    public String getFILE_MD5() {
        return FILE_MD5;
    }

    public void setFILE_MD5(String FILE_MD5) {
        this.FILE_MD5 = FILE_MD5;
    }

    public Integer getFILE_TYPE() {
        return FILE_TYPE;
    }

    public void setFILE_TYPE(Integer FILE_TYPE) {
        this.FILE_TYPE = FILE_TYPE;
    }

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    public void setFILE_NAME(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
    }

    public String getFILE_URL() {
        return FILE_URL;
    }

    public void setFILE_URL(String FILE_URL) {
        this.FILE_URL = FILE_URL;
    }
}
