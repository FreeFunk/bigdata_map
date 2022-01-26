package com.edgedo.bigdata.queryvo;

import com.edgedo.bigdata.entity.CarInfo;

import java.util.Date;

public class CarInfoView extends CarInfo {

    private Date countTimeStart;

    private Date countTimeEnd;

    private Date countTime;

    public Date getCountTime() {
        return countTime;
    }

    public void setCountTime(Date countTime) {
        this.countTime = countTime;
    }

    public Date getCountTimeEnd() {
        return countTimeEnd;
    }

    public void setCountTimeEnd(Date countTimeEnd) {
        this.countTimeEnd = countTimeEnd;
    }

    public Date getCountTimeStart() {
        return countTimeStart;
    }

    public void setCountTimeStart(Date countTimeStart) {
        this.countTimeStart = countTimeStart;
    }
}
