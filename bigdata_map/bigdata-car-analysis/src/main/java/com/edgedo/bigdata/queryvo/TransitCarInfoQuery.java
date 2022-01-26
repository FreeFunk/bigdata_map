package com.edgedo.bigdata.queryvo;

import com.edgedo.common.base.QueryObj;

import java.util.Date;

public class TransitCarInfoQuery extends QueryObj{
    private String id;
    //省ID
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
    //车架号
    private String carFrameNum;
    //学习方式
    private String trainType;
    //企业名称
    private String ownerTeamName;
    //企业id
    private String ownerTeamId;
    //车辆类型
    private String carType;
    //车牌颜色
    private String carPlateColor;
    //车主
    private String ownerName;
    //车主联系电话
    private String ownerPhoneNum;
    //技术档案编号
    private String carRecFileCode;

    private String companyLavel;

    public String getCompanyLavel() {
        return companyLavel;
    }

    public void setCompanyLavel(String companyLavel) {
        this.companyLavel = companyLavel;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhoneNum() {
        return ownerPhoneNum;
    }

    public void setOwnerPhoneNum(String ownerPhoneNum) {
        this.ownerPhoneNum = ownerPhoneNum;
    }

    public String getCarRecFileCode() {
        return carRecFileCode;
    }

    public void setCarRecFileCode(String carRecFileCode) {
        this.carRecFileCode = carRecFileCode;
    }

    public String getCarPlateColor() {
        return carPlateColor;
    }

    public void setCarPlateColor(String carPlateColor) {
        this.carPlateColor = carPlateColor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerTeamId() {
        return ownerTeamId;
    }

    public void setOwnerTeamId(String ownerTeamId) {
        this.ownerTeamId = ownerTeamId;
    }

    public String getOwnerTeamName() {
        return ownerTeamName;
    }

    public void setOwnerTeamName(String ownerTeamName) {
        this.ownerTeamName = ownerTeamName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarPlateNum() {
        return carPlateNum;
    }

    public void setCarPlateNum(String carPlateNum) {
        this.carPlateNum = carPlateNum;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    //查询时间
    private Date searchTime;
    //查询类型（年度:YEAR,月度，MONTH）
    private String searchType;

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
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

    public String getCarFrameNum() {
        return carFrameNum;
    }

    public void setCarFrameNum(String carFrameNum) {
        this.carFrameNum = carFrameNum;
    }
}
