package com.edgedo.bigdata.entity;

/**
 * @ClassName CarInfoForVideo
 * @Description TODO
 * @Author 床前明月光
 * @Date 2019/9/6 15:09
 **/
public class CarInfoForVideo {

    private String carPlateNum;
    private String carPlateColor;
    private String sim;
    private String deviceType;
    private String channelEnable;
    private String liveIp;
    private Integer livePort;
    private String liveType;

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

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getChannelEnable() {
        return channelEnable;
    }

    public void setChannelEnable(String channelEnable) {
        this.channelEnable = channelEnable;
    }

    public String getLiveIp() {
        return liveIp;
    }

    public void setLiveIp(String liveIp) {
        this.liveIp = liveIp;
    }

    public Integer getLivePort() {
        return livePort;
    }

    public void setLivePort(Integer livePort) {
        this.livePort = livePort;
    }

    public String getLiveType() {
        return liveType;
    }

    public void setLiveType(String liveType) {
        this.liveType = liveType;
    }
}
