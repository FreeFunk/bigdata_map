package com.edgedo.reportdata.entity;

import java.util.Date;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author 床前明月光
 * @Date 2019/3/28 18:25
 **/
public class Emp {

    //从业人员姓名
    //主键
    private String id ;
    //创建时间
    private Date createTime;
    //创建人ID
    private String createUserId;
    //创建人名
    private String createUserName;
    //所属车队ID
    private String ownerCarTeamId;
    //所属车队名
    private String ownerCarTeamName;
    //人员姓名/
    private String empName;
    //身份证号
    //人员手机号
    private String empPhone;
    //人员身份证号
    private String empIdCard;
    //从业资格证号
    private String empCode;
    //人员性别
    private String empSex;
    //人员年龄
    private Integer empAge;
    //入职日期；
    private Date empEntryDay;
    //人员描述
    private String empDesc;
    //人员状态；
    private String empState;
    // 登录账号；
    private String empUserCode;
    //登录密码
    private String empPassword;
    //记录培训次数
    private Integer totalTrainTimes;
    //在线培训次数‘
    private Integer onlineTrainTimes;
    //剩余培训次数’
    private Integer trainTimesLeft;
    //绑定时间
    private Date bingTime;
    //openid
    private String openId;
    //微信用户ID；
    private String ywWxUser;
    //审核状态；
    private String shState;
    //数据状态；
    private String dataState;
    //关联车辆(id)
    private String plateNum;
    //车牌号
    private String carPlateNum;

    //已完成次数
    private Integer finishedSafetyTrainingNum;
    //未完成次数
    private Integer unfinishedSafetyTrainingNum;
    //车牌号
    private String carNum;
    //资格证号
    private String licenceCode;
    //人员身份:驾驶员-1，押运员-2，装卸员-3，经理-4，其他-0
    private String empType;
    //是否体验过了:1是已经体验过 其他的比如0是没体验过
    private String isTiyan;
    //同步状态
    private String tongBuState;
    //省ID
    private String provinceId;
    //省名
    private String provinceName;
    //市ID
    private String cityId;
    //市名
    private String cityName;
    //县区ID
    private String xianQuId;
    //县区名
    private String xianQuName;
    //健康信息
    private String healthMessage;

    private String headPhoto;

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }

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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getOwnerCarTeamId() {
        return ownerCarTeamId;
    }

    public void setOwnerCarTeamId(String ownerCarTeamId) {
        this.ownerCarTeamId = ownerCarTeamId;
    }

    public String getOwnerCarTeamName() {
        return ownerCarTeamName;
    }

    public void setOwnerCarTeamName(String ownerCarTeamName) {
        this.ownerCarTeamName = ownerCarTeamName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpIdCard() {
        return empIdCard;
    }

    public void setEmpIdCard(String empIdCard) {
        this.empIdCard = empIdCard;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public Date getEmpEntryDay() {
        return empEntryDay;
    }

    public void setEmpEntryDay(Date empEntryDay) {
        this.empEntryDay = empEntryDay;
    }

    public String getEmpDesc() {
        return empDesc;
    }

    public void setEmpDesc(String empDesc) {
        this.empDesc = empDesc;
    }

    public String getEmpState() {
        return empState;
    }

    public void setEmpState(String empState) {
        this.empState = empState;
    }

    public String getEmpUserCode() {
        return empUserCode;
    }

    public void setEmpUserCode(String empUserCode) {
        this.empUserCode = empUserCode;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public Integer getTotalTrainTimes() {
        return totalTrainTimes;
    }

    public void setTotalTrainTimes(Integer totalTrainTimes) {
        this.totalTrainTimes = totalTrainTimes;
    }

    public Integer getOnlineTrainTimes() {
        return onlineTrainTimes;
    }

    public void setOnlineTrainTimes(Integer onlineTrainTimes) {
        this.onlineTrainTimes = onlineTrainTimes;
    }

    public Integer getTrainTimesLeft() {
        return trainTimesLeft;
    }

    public void setTrainTimesLeft(Integer trainTimesLeft) {
        this.trainTimesLeft = trainTimesLeft;
    }

    public Date getBingTime() {
        return bingTime;
    }

    public void setBingTime(Date bingTime) {
        this.bingTime = bingTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getYwWxUser() {
        return ywWxUser;
    }

    public void setYwWxUser(String ywWxUser) {
        this.ywWxUser = ywWxUser;
    }

    public String getShState() {
        return shState;
    }

    public void setShState(String shState) {
        this.shState = shState;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getCarPlateNum() {
        return carPlateNum;
    }

    public void setCarPlateNum(String carPlateNum) {
        this.carPlateNum = carPlateNum;
    }

    public Integer getFinishedSafetyTrainingNum() {
        return finishedSafetyTrainingNum;
    }

    public void setFinishedSafetyTrainingNum(Integer finishedSafetyTrainingNum) {
        this.finishedSafetyTrainingNum = finishedSafetyTrainingNum;
    }

    public Integer getUnfinishedSafetyTrainingNum() {
        return unfinishedSafetyTrainingNum;
    }

    public void setUnfinishedSafetyTrainingNum(Integer unfinishedSafetyTrainingNum) {
        this.unfinishedSafetyTrainingNum = unfinishedSafetyTrainingNum;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getLicenceCode() {
        return licenceCode;
    }

    public void setLicenceCode(String licenceCode) {
        this.licenceCode = licenceCode;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getIsTiyan() {
        return isTiyan;
    }

    public void setIsTiyan(String isTiyan) {
        this.isTiyan = isTiyan;
    }

    public String getTongBuState() {
        return tongBuState;
    }

    public void setTongBuState(String tongBuState) {
        this.tongBuState = tongBuState;
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

    public String getXianQuId() {
        return xianQuId;
    }

    public void setXianQuId(String xianQuId) {
        this.xianQuId = xianQuId;
    }

    public String getXianQuName() {
        return xianQuName;
    }

    public void setXianQuName(String xianQuName) {
        this.xianQuName = xianQuName;
    }

    public String getHealthMessage() {
        return healthMessage;
    }

    public void setHealthMessage(String healthMessage) {
        this.healthMessage = healthMessage;
    }
}
