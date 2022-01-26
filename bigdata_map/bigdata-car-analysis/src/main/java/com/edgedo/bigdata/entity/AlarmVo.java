package com.edgedo.bigdata.entity;

/**
 * @ClassName AlarmVo
 * @Description TODO
 * @Author 床前明月光
 * @Date 2019/9/27 9:20
 **/
public class AlarmVo {

    private String carPlateNum;

    private String alarmType;

    private Integer alarmNum;

    public String getCarPlateNum() {
        return carPlateNum;
    }

    public void setCarPlateNum(String carPlateNum) {
        this.carPlateNum = carPlateNum;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public Integer getAlarmNum() {
        return alarmNum;
    }

    public void setAlarmNum(Integer alarmNum) {
        this.alarmNum = alarmNum;
    }
}
