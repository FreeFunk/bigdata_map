package com.edgedo.alarm.entity;
//轩慧平台的报警表
public class Alterlogs {
    //主键
    private Integer aid;
    //车牌号码
    private String acarcode;
    //车牌颜色
    private Integer tcarcolour;
    //sim卡号
    private String aphone;
    //报警类型  1线路报警  2超速报警  3紧急报警  4疲劳驾驶
    private Integer atype;
    //报警时间
    private String atime;
    //司机
    private String drivers;
    //经度
    private String longitude;
    //纬度
    private String latitude;
    //报警种类 1平台 2终端
    private Integer type;
    //当前速度
    private String aspeed;
    //时长
    private String remark;
    //处理方式
    private String dtype;
    //处理备注
    private String dremark;
    //处理时间
    private String dtime;

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getDremark() {
        return dremark;
    }

    public void setDremark(String dremark) {
        this.dremark = dremark;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public Integer getTcarcolour() {
        return tcarcolour;
    }

    public void setTcarcolour(Integer tcarcolour) {
        this.tcarcolour = tcarcolour;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAcarcode() {
        return acarcode;
    }

    public void setAcarcode(String acarcode) {
        this.acarcode = acarcode;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public Integer getAtype() {
        return atype;
    }

    public void setAtype(Integer atype) {
        this.atype = atype;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public String getDrivers() {
        return drivers;
    }

    public void setDrivers(String drivers) {
        this.drivers = drivers;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAspeed() {
        return aspeed;
    }

    public void setAspeed(String aspeed) {
        this.aspeed = aspeed;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
