package com.edgedo.bigdata.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BigdataCarRealtimeSimple {

    /**
     * 属性描述:主键
     */
    String id;

    /**
     * 属性描述:上次定位时间
     */
    Date lastPositionTime;

    /**
     * 属性描述:纬度
     */
    BigDecimal pointLat;

    /**
     * 属性描述:经度
     */
    BigDecimal pointLong;

    /**
     * 属性描述:实时速度
     */
    BigDecimal realSpeed;

    /**
     * 属性描述:gps速度
     */
    BigDecimal gpsSpeed;

    /**
     * 属性描述:方向
     */
    BigDecimal direction;

    /**
     * 属性描述:海拔
     */
    BigDecimal altitude;
    /**
     * 属性描述:onlineState
     */
    String onlineState="0";

    BigDecimal todayTimeTotal= new BigDecimal(0);

    BigDecimal todayMileageTotal= new BigDecimal(0);

    //数据不合格原因
    String errMsg="";
    //0不符合，1合格
    Integer qualifiedState = 1;

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

    public String getOnlineState() {
        return onlineState;
    }

    public void setOnlineState(String onlineState) {
        this.onlineState = onlineState;
    }

    public BigDecimal getTodayTimeTotal() {
        return todayTimeTotal;
    }

    public void setTodayTimeTotal(BigDecimal todayTimeTotal) {
        this.todayTimeTotal = todayTimeTotal;
    }

    public BigDecimal getTodayMileageTotal() {
        return todayMileageTotal;
    }

    public void setTodayMileageTotal(BigDecimal todayMileageTotal) {
        this.todayMileageTotal = todayMileageTotal;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Integer getQualifiedState() {
        return qualifiedState;
    }

    public void setQualifiedState(Integer qualifiedState) {
        this.qualifiedState = qualifiedState;
    }
}
