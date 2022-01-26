package com.edgedo.bigdata.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName CarRealtimeGps
 * @Description TODO
 * @Author 床前明月光
 * @Date 2019/9/16 14:44
 **/
public class CarRealtimeGps {

    //海拔高度
    private BigDecimal altitude;
    //车牌颜色
    private String vehicle_color;
    //, 车牌号
    private String vehicle_no;
    //车辆类型
    private String vehicle_type;
    //驾驶员身份证号
    private String driver_card;
    //经度
    private BigDecimal lon;
    //终端设备编号
    private String deviceno;
    //速度
    private BigDecimal speed;
    //驾驶员姓名
    private String driver_name;
    //时间
    private Date datetime;
    //终端sim卡号
    private String sim;
    //报警状态
    private String alarm;
    //车辆状态
    private String state;
    //纬度
    private BigDecimal lat;
    //行车里程
    private BigDecimal mileage;
    //方向
    private String direction;

    public BigDecimal getAltitude() {
        return altitude;
    }

    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }

    public String getVehicle_color() {
        return vehicle_color;
    }

    public void setVehicle_color(String vehicle_color) {
        this.vehicle_color = vehicle_color;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getDriver_card() {
        return driver_card;
    }

    public void setDriver_card(String driver_card) {
        this.driver_card = driver_card;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public String getDeviceno() {
        return deviceno;
    }

    public void setDeviceno(String deviceno) {
        this.deviceno = deviceno;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
