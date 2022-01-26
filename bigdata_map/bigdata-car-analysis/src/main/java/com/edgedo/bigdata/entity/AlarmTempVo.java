package com.edgedo.bigdata.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @ClassName AlarmTempVo
 * @Description TODO
 * @Author 床前明月光
 * @Date 2019/11/28 16:09
 **/
public class AlarmTempVo implements Serializable{

    @JSONField(name = "SESSION_KEY")
    private String SESSION_KEY;
    @JSONField(name = "ALARM_ID")
    private String ALARM_ID;
    @JSONField(name = "CAR_CODE")
    private String CAR_CODE;
    @JSONField(name = "CAR_COLOR")
    private String CAR_COLOR;


    public String getSESSION_KEY() {
        return SESSION_KEY;
    }

    public void setSESSION_KEY(String SESSION_KEY) {
        this.SESSION_KEY = SESSION_KEY;
    }

    public String getALARM_ID() {
        return ALARM_ID;
    }

    public void setALARM_ID(String ALARM_ID) {
        this.ALARM_ID = ALARM_ID;
    }

    public String getCAR_CODE() {
        return CAR_CODE;
    }

    public void setCAR_CODE(String CAR_CODE) {
        this.CAR_CODE = CAR_CODE;
    }

    public String getCAR_COLOR() {
        return CAR_COLOR;
    }

    public void setCAR_COLOR(String CAR_COLOR) {
        this.CAR_COLOR = CAR_COLOR;
    }
}
