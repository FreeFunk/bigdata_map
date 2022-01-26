package com.edgedo.bigdata.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author WangZhen
 * @description
 * @date 2019/11/19
 */
public class BigdataCarTrailGps {

    /**
     * 属性描述:主键
     */
    String id;
    /**
     * 属性描述:车牌号
     */
    String carPlateNum;
    /**
     * 属性描述:车牌颜色
     * 1:蓝色, 2:黄色,	 3:黑色,	 4:白色, 7:黄绿相间	 9:其他
     */
    String carPlateColor;
    /**
     * 属性描述:上次定位时间
     */
    java.util.Date lastPositionTime;

    /**
     * 属性描述:纬度
     */
    java.math.BigDecimal pointLat;

    /**
     * 属性描述:经度
     */
    java.math.BigDecimal pointLong;

    /**
     * 属性描述:实时速度
     */
    java.math.BigDecimal realSpeed;

    /**
     * 属性描述:gps速度
     */
    java.math.BigDecimal gpsSpeed;

    /**
     * 属性描述:方向
     */
    java.math.BigDecimal direction;

    /**
     * 属性描述:海拔
     */
    java.math.BigDecimal altitude;

    /**
     * 属性描述:里程
     */
    java.math.BigDecimal mileage;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLastPositionTime() {
        return lastPositionTime;
    }

    public void setLastPositionTime(Date lastPositionTime) {
        this.lastPositionTime = lastPositionTime;
    }

    public BigDecimal getPointLat() {
        return pointLat;
    }

    public void setPointLat(BigDecimal pointLat) {
        this.pointLat = pointLat;
    }

    public BigDecimal getPointLong() {
        return pointLong;
    }

    public void setPointLong(BigDecimal pointLong) {
        this.pointLong = pointLong;
    }

    public BigDecimal getRealSpeed() {
        return realSpeed;
    }

    public void setRealSpeed(BigDecimal realSpeed) {
        this.realSpeed = realSpeed;
    }

    public BigDecimal getGpsSpeed() {
        return gpsSpeed;
    }

    public void setGpsSpeed(BigDecimal gpsSpeed) {
        this.gpsSpeed = gpsSpeed;
    }

    public BigDecimal getDirection() {
        return direction;
    }

    public void setDirection(BigDecimal direction) {
        this.direction = direction;
    }

    public BigDecimal getAltitude() {
        return altitude;
    }

    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }

    public String getCarPlateNum() {
        return carPlateNum;
    }

    public void setCarPlateNum(String carPlateNum) {
        this.carPlateNum = carPlateNum;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    public String getCarPlateColor() {
        return carPlateColor;
    }

    public void setCarPlateColor(String carPlateColor) {
        this.carPlateColor = carPlateColor;
    }
}
