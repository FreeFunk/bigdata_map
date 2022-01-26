package com.edgedo.reportdata.entity;

import java.math.BigDecimal;

public class Agent {

    //总的课时数
    private Integer countLessionNum;
    //手机学习课时数
    private Integer phoneLessionNum;
    //电脑学习课时数
    private Integer pcLessionNum;
    //总的学习人数
    private Integer countPersonNum;
    //应审车辆数
    private Integer trialCarNum;
    //已审车辆数
    private Integer finishedCarNum;
    //应审人员数
    private Integer trailEmpNum;
    //已审人员数
    private Integer finishedEmpNum;
    //充值金额
    private BigDecimal rechargeMoney;
    //消费金额
    private BigDecimal consumeMoney;

    public Integer getCountLessionNum() {
        return countLessionNum;
    }

    public void setCountLessionNum(Integer countLessionNum) {
        this.countLessionNum = countLessionNum;
    }

    public Integer getPhoneLessionNum() {
        return phoneLessionNum;
    }

    public void setPhoneLessionNum(Integer phoneLessionNum) {
        this.phoneLessionNum = phoneLessionNum;
    }

    public Integer getPcLessionNum() {
        return pcLessionNum;
    }

    public void setPcLessionNum(Integer pcLessionNum) {
        this.pcLessionNum = pcLessionNum;
    }

    public Integer getCountPersonNum() {
        return countPersonNum;
    }

    public void setCountPersonNum(Integer countPersonNum) {
        this.countPersonNum = countPersonNum;
    }

    public Integer getTrialCarNum() {
        return trialCarNum;
    }

    public void setTrialCarNum(Integer trialCarNum) {
        this.trialCarNum = trialCarNum;
    }

    public Integer getFinishedCarNum() {
        return finishedCarNum;
    }

    public void setFinishedCarNum(Integer finishedCarNum) {
        this.finishedCarNum = finishedCarNum;
    }

    public Integer getTrailEmpNum() {
        return trailEmpNum;
    }

    public void setTrailEmpNum(Integer trailEmpNum) {
        this.trailEmpNum = trailEmpNum;
    }

    public Integer getFinishedEmpNum() {
        return finishedEmpNum;
    }

    public void setFinishedEmpNum(Integer finishedEmpNum) {
        this.finishedEmpNum = finishedEmpNum;
    }

    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public BigDecimal getConsumeMoney() {
        return consumeMoney;
    }

    public void setConsumeMoney(BigDecimal consumeMoney) {
        this.consumeMoney = consumeMoney;
    }
}
