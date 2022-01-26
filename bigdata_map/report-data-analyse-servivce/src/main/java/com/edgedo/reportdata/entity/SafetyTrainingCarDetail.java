package com.edgedo.reportdata.entity;

import java.util.Date;

public class SafetyTrainingCarDetail {

    //主键
    private String id;
    //创建时间
    private Date createTime;
    //省id
    private String provinceId;
    //省名
    private String provinceName;
    //城市ID
    private String cityId;
    //城市名
    private String cityName;
    //县区ID
    private String xianquId;
    //县区名
    private String xianquName;
    //车牌号
    private String carPlateNum;
    //车牌颜色
    private String carPlateColor;
    //车架号
    private String carFrameNum;
    //联系人
    private String contactPerson;
    //联系电话
    private String contactPhone;
    //许可证号
    private String jyCertNumber;
    //年审截止时间
    private Date operatingStopDate;
    //更新时间
    private Date updateTime;
    //统计时间
    private Date tongjiTime;
    //统计类型
    private String tongjiType;
    //是否完成
    private String isFinished;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getXianquId() {
        return xianquId;
    }

    public void setXianquId(String xianquId) {
        this.xianquId = xianquId;
    }

    public String getXianquName() {
        return xianquName;
    }

    public void setXianquName(String xianquName) {
        this.xianquName = xianquName;
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

    public String getCarFrameNum() {
        return carFrameNum;
    }

    public void setCarFrameNum(String carFrameNum) {
        this.carFrameNum = carFrameNum;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getJyCertNumber() {
        return jyCertNumber;
    }

    public void setJyCertNumber(String jyCertNumber) {
        this.jyCertNumber = jyCertNumber;
    }

    public Date getOperatingStopDate() {
        return operatingStopDate;
    }

    public void setOperatingStopDate(Date operatingStopDate) {
        this.operatingStopDate = operatingStopDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getTongjiTime() {
        return tongjiTime;
    }

    public void setTongjiTime(Date tongjiTime) {
        this.tongjiTime = tongjiTime;
    }

    public String getTongjiType() {
        return tongjiType;
    }

    public void setTongjiType(String tongjiType) {
        this.tongjiType = tongjiType;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }
}
