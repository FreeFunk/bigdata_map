package com.edgedo.bigdata.queryvo;

import com.edgedo.bigdata.entity.BigdataTimeCarDayRec;

import java.util.Date;

public class BigdataTimeCarDayRecView extends BigdataTimeCarDayRec {

    private String carFrameNum;

    private String teamName;

    private String contactPerson;

    private String conctactphone;

    private String jyCertNumber;

    private Date countTimeEnd;

    private Integer countDateStart;

    public Integer getCountDateStart() {
        return countDateStart;
    }

    public void setCountDateStart(Integer countDateStart) {
        this.countDateStart = countDateStart;
    }

    public Integer getCountDateEnd() {
        return countDateEnd;
    }

    public void setCountDateEnd(Integer countDateEnd) {
        this.countDateEnd = countDateEnd;
    }

    private Integer countDateEnd;

    @Override
    public String getCarFrameNum() {
        return carFrameNum;
    }

    @Override
    public void setCarFrameNum(String carFrameNum) {
        this.carFrameNum = carFrameNum;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getConctactphone() {
        return conctactphone;
    }

    public void setConctactphone(String conctactphone) {
        this.conctactphone = conctactphone;
    }

    public String getJyCertNumber() {
        return jyCertNumber;
    }

    public void setJyCertNumber(String jyCertNumber) {
        this.jyCertNumber = jyCertNumber;
    }

    public Date getCountTimeEnd() {
        return countTimeEnd;
    }

    public void setCountTimeEnd(Date countTimeEnd) {
        this.countTimeEnd = countTimeEnd;
    }
}
