package com.edgedo.bigdata.entity;

public class BeidouAlarmHandleInfo {

    //必填,唯一,用于关联数据 报警主键
    private String bId;
    //开始时间
    private String starttime;
    //车牌号
    private String carPlateNum;
    //车牌颜色
    private String carPlateColor;
    //报警类型
    private String warningType;
    //处理结果
    private String detailInfo;
    //处理状态
    private String handleState;
    //处理方式（电话提醒、短信下发、终端提醒、误报处理、其他）
    private String handleType;
    //处理时间，格式yyyymmddhhmmss
    private String handleTime;
    //处理人
    private String handlePeople;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getCarPlateNum() {
        return carPlateNum;
    }

    public void setCarPlateNum(String carPlateNum) {
        this.carPlateNum = carPlateNum;
    }

    public String getCarPlateColor() {
        return carPlateColor;
    }

    public void setCarPlateColor(String carPlateColor) {
        this.carPlateColor = carPlateColor;
    }

    public String getWarningType() {
        return warningType;
    }

    public void setWarningType(String warningType) {
        this.warningType = warningType;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getHandleState() {
        return handleState;
    }

    public void setHandleState(String handleState) {
        this.handleState = handleState;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public String getHandlePeople() {
        return handlePeople;
    }

    public void setHandlePeople(String handlePeople) {
        this.handlePeople = handlePeople;
    }
}
