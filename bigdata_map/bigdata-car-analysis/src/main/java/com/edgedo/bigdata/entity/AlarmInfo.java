package com.edgedo.bigdata.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName AlarmInfo
 * @Description TODO
 * @Author 床前明月光
 * @Date 2019/10/24 15:35
 **/
public class AlarmInfo {
    /*报警级别
    0x00：事件，无报警
    0x01：一级报警
    0x02：二级报警*/
    private String ALARM_GRADE;
    /*报警/事件类型
    0x01：前向碰撞报警
    0x02：车道偏离报警
    0x03：车距过近报警
    0x04：行人碰撞报警
    0x05：频繁变道报警
    0x06：道路标识超限报警
    0x07：障碍物报警
    0x08-0x0F：用户自定义
    0x10：道路标志识别事件
    0x11：主动抓拍事件
    0x12-0x1F：用户自定义
    */
    private String EVENT_TYPE;

    private Date RECV_TIME;
  /*  标志状态
    0x00：不可用
    0x01：开始标志
    0x02：结束标志
        该字段仅适用于有开始和结束标志类型的报警或事件，
        报警类型或事件类型无开始和结束标志，则该位不可用，
        填入 0x00 即可*/
    private String MARK_STATUS;
    //经度
    private BigDecimal LONGITUDE;
    //海拔高度，单位为米（m）
    private String ALTITUDE;
    //车辆状态
    /*按位表示车辆其他状态：
    Bit0 ACC 状态， 0：关闭，1：打开
    Bit1 左转向状态，0：关闭，1：打开
    Bit2 右转向状态， 0：关闭，1：打开
    Bit3 雨刮器状态， 0：关闭，1：打开
    Bit4 制动状态，0：未制动，1：制动
    Bit5 插卡状态，0：未插卡，1：已插卡
    Bit6-Bit9 自定义
    Bit10 定位状态，0：未定位，1：已定位
    Bit11-bit15 自定义*/
    private String VEHICLE_STATUS;
    //报警时间
    private Date WARN_TIME;
    //单位 km/h,范围 0-250
    private String SPEED;
    //报警标识号，定
    private String ALARM_ID;
    //预留
    private String RESERVE;
    //车牌号
    private String CAR_CODE;
    //0x0064
/*    高级驾驶辅助系统报警
0x0065
    驾驶人状态监测系统报警*/
    private Integer WARN_TYPE;
    //纬度
    private BigDecimal LATITUDE;
    /*疲劳程度,范围 1~10。数值越大表示疲劳程度越严
    重，仅在报警类型为 0x01 时有效*/
    private String FATIGUE_DEGREE;
    //车牌颜色
    private String CAR_COLOR;
    //
    private String SERV_IP;

    private String SESSION_KEY;

    private String HANDLER_NAME;

    private Date HANDLER_TIME;

    private String HANDLER_CONTENT;

    private String HANDLER_TYPE;

    public String getHANDLER_NAME() {
        return HANDLER_NAME;
    }

    public void setHANDLER_NAME(String HANDLER_NAME) {
        this.HANDLER_NAME = HANDLER_NAME;
    }

    public Date getHANDLER_TIME() {
        return HANDLER_TIME;
    }

    public void setHANDLER_TIME(Date HANDLER_TIME) {
        this.HANDLER_TIME = HANDLER_TIME;
    }

    public String getHANDLER_CONTENT() {
        return HANDLER_CONTENT;
    }

    public void setHANDLER_CONTENT(String HANDLER_CONTENT) {
        this.HANDLER_CONTENT = HANDLER_CONTENT;
    }

    public String getHANDLER_TYPE() {
        return HANDLER_TYPE;
    }

    public void setHANDLER_TYPE(String HANDLER_TYPE) {
        this.HANDLER_TYPE = HANDLER_TYPE;
    }

    public String getSESSION_KEY() {
        return SESSION_KEY;
    }

    public void setSESSION_KEY(String SESSION_KEY) {
        this.SESSION_KEY = SESSION_KEY;
    }

    public String getALARM_GRADE() {
        return ALARM_GRADE;
    }

    public void setALARM_GRADE(String ALARM_GRADE) {
        this.ALARM_GRADE = ALARM_GRADE;
    }

    public String getEVENT_TYPE() {
        return EVENT_TYPE;
    }

    public void setEVENT_TYPE(String EVENT_TYPE) {
        this.EVENT_TYPE = EVENT_TYPE;
    }

    public Date getRECV_TIME() {
        return RECV_TIME;
    }

    public void setRECV_TIME(Date RECV_TIME) {
        this.RECV_TIME = RECV_TIME;
    }

    public String getMARK_STATUS() {
        return MARK_STATUS;
    }

    public void setMARK_STATUS(String MARK_STATUS) {
        this.MARK_STATUS = MARK_STATUS;
    }

    public BigDecimal getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(BigDecimal LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public String getALTITUDE() {
        return ALTITUDE;
    }

    public void setALTITUDE(String ALTITUDE) {
        this.ALTITUDE = ALTITUDE;
    }

    public String getVEHICLE_STATUS() {
        return VEHICLE_STATUS;
    }

    public void setVEHICLE_STATUS(String VEHICLE_STATUS) {
        this.VEHICLE_STATUS = VEHICLE_STATUS;
    }

    public Date getWARN_TIME() {
        return WARN_TIME;
    }

    public void setWARN_TIME(Date WARN_TIME) {
        this.WARN_TIME = WARN_TIME;
    }

    public String getSPEED() {
        return SPEED;
    }

    public void setSPEED(String SPEED) {
        this.SPEED = SPEED;
    }

    public String getALARM_ID() {
        return ALARM_ID;
    }

    public void setALARM_ID(String ALARM_ID) {
        this.ALARM_ID = ALARM_ID;
    }

    public String getRESERVE() {
        return RESERVE;
    }

    public void setRESERVE(String RESERVE) {
        this.RESERVE = RESERVE;
    }

    public String getCAR_CODE() {
        return CAR_CODE;
    }

    public void setCAR_CODE(String CAR_CODE) {
        this.CAR_CODE = CAR_CODE;
    }

    public Integer getWARN_TYPE() {
        return WARN_TYPE;
    }

    public void setWARN_TYPE(Integer WARN_TYPE) {
        this.WARN_TYPE = WARN_TYPE;
    }

    public BigDecimal getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(BigDecimal LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public String getFATIGUE_DEGREE() {
        return FATIGUE_DEGREE;
    }

    public void setFATIGUE_DEGREE(String FATIGUE_DEGREE) {
        this.FATIGUE_DEGREE = FATIGUE_DEGREE;
    }

    public String getCAR_COLOR() {
        return CAR_COLOR;
    }

    public void setCAR_COLOR(String CAR_COLOR) {
        this.CAR_COLOR = CAR_COLOR;
    }

    public String getSERV_IP() {
        return SERV_IP;
    }

    public void setSERV_IP(String SERV_IP) {
        this.SERV_IP = SERV_IP;
    }
}
