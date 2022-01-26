package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_driver_draw_info")
public class BigdataDriverDrawInfo implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	/**
	 * 属性描述:所属运营商
	 */
	@TableField(value="COMP_ID",exist=true)
	java.lang.String compId;
	
	/**
	 * 属性描述:运营商名
	 */
	@TableField(value="COMP_NAME",exist=true)
	java.lang.String compName;
	
	/**
	 * 属性描述:所属企业
	 */
	@TableField(value="TEAM_ID",exist=true)
	java.lang.String teamId;
	
	/**
	 * 属性描述:企业名
	 */
	@TableField(value="TEAM_NAME",exist=true)
	java.lang.String teamName;
	
	/**
	 * 属性描述:省ID
	 */
	@TableField(value="PROVINCE_ID",exist=true)
	java.lang.String provinceId;
	
	/**
	 * 属性描述:省名
	 */
	@TableField(value="PROVINCE_NAME",exist=true)
	java.lang.String provinceName;
	
	/**
	 * 属性描述:城市ID
	 */
	@TableField(value="CITY_ID",exist=true)
	java.lang.String cityId;
	
	/**
	 * 属性描述:城市名
	 */
	@TableField(value="CITY_NAME",exist=true)
	java.lang.String cityName;
	
	/**
	 * 属性描述:县区ID
	 */
	@TableField(value="XIANQU_ID",exist=true)
	java.lang.String xianquId;
	
	/**
	 * 属性描述:县区名
	 */
	@TableField(value="XIANQU_NAME",exist=true)
	java.lang.String xianquName;
	
	/**
	 * 属性描述:驾驶员姓名
	 */
	@TableField(value="DRIVER_NAME",exist=true)
	java.lang.String driverName;
	
	/**
	 * 属性描述:驾驶员性别
	 */
	@TableField(value="DRIVER_SEX",exist=true)
	java.lang.String driverSex;
	
	/**
	 * 属性描述:驾驶员年龄
	 */
	@TableField(value="DRIVER_AGE",exist=true)
	java.lang.Integer driverAge;
	
	/**
	 * 属性描述:驾驶员电话
	 */
	@TableField(value="DRIVER_PHONE",exist=true)
	java.lang.String driverPhone;
	
	/**
	 * 属性描述:驾驶员入职日期
	 */
	@TableField(value="DRIVER_ENTRY_DAY",exist=true)
	java.util.Date driverEntryDay;
	
	/**
	 * 属性描述:驾驶员身份证号
	 */
	@TableField(value="DRIVER_ID_CARD",exist=true)
	java.lang.String driverIdCard;
	
	/**
	 * 属性描述:驾驶员资格证号
	 */
	@TableField(value="DRIVER_CODE",exist=true)
	java.lang.String driverCode;
	
	/**
	 * 属性描述:驾驶证类型
	 */
	@TableField(value="DRIVER_LICENCE_TYPE",exist=true)
	java.lang.String driverLicenceType;
	
	/**
	 * 属性描述:驾驶证号
	 */
	@TableField(value="DRIVER_LICENCE_NUM",exist=true)
	java.lang.String driverLicenceNum;
	
	/**
	 * 属性描述:准驾车型
	 */
	@TableField(value="DRIVER_CAR_TYPE",exist=true)
	java.lang.String driverCarType;
	
	/**
	 * 属性描述:驾驶员照片
	 */
	@TableField(value="DRIVER_PHOTO_URL",exist=true)
	java.lang.String driverPhotoUrl;
	
	/**
	 * 属性描述:车牌号
	 */
	@TableField(value="CAR_PLATE_NUM",exist=true)
	java.lang.String carPlateNum;
	
	/**
	 * 属性描述:车牌颜色
	 */
	@TableField(value="CAR_PLATE_COLOR",exist=true)
	java.lang.String carPlateColor;
	
	/**
	 * 属性描述:车牌颜色文本
	 */
	@TableField(value="CAR_PLATE_COLOR_TEXT",exist=true)
	java.lang.String carPlateColorText;
	
	/**
	 * 属性描述:车架号
	 */
	@TableField(value="CAR_FRAME_NUM",exist=true)
	java.lang.String carFrameNum;
	
	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	java.lang.String carType;
	
	/**
	 * 属性描述:关联时间
	 */
	@TableField(value="BIND_TIME",exist=true)
	java.util.Date bindTime;
	
	/**
	 * 属性描述:是否实名认证
	 */
	@TableField(value="IS_REAL_STATE",exist=true)
	java.lang.String isRealState;
	
	/**
	 * 属性描述:安全评定等级
	 */
	@TableField(value="SAFE_LEVEL",exist=true)
	java.lang.String safeLevel;
	
	/**
	 * 属性描述:全年行驶时长
	 */
	@TableField(value="YEAR_RUN_TIME_LENGTH",exist=true)
	java.math.BigDecimal yearRunTimeLength;
	
	/**
	 * 属性描述:危险时段行驶时长
	 */
	@TableField(value="DANGER_RUN_TIME_LENGTH",exist=true)
	java.math.BigDecimal dangerRunTimeLength;
	
	/**
	 * 属性描述:白天行驶时长(分钟)
	 */
	@TableField(value="DAY_RUN_TIME_LENGTH",exist=true)
	java.math.BigDecimal dayRunTimeLength;
	
	/**
	 * 属性描述:夜晚行驶时长(分钟)
	 */
	@TableField(value="NIGHT_RUN_TIME_LENGTH",exist=true)
	java.math.BigDecimal nightRunTimeLength;
	
	/**
	 * 属性描述:行驶时长评分
	 */
	@TableField(value="RUN_TIME_LENGTH_LEVEL",exist=true)
	java.lang.String runTimeLengthLevel;
	
	/**
	 * 属性描述:年行驶里程
	 */
	@TableField(value="YEAR_RUN_MILEAGE",exist=true)
	java.math.BigDecimal yearRunMileage;
	
	/**
	 * 属性描述:国道里程
	 */
	@TableField(value="NATIONAL_ROAD_MILEAGE",exist=true)
	java.math.BigDecimal nationalRoadMileage;
	
	/**
	 * 属性描述:高速里程
	 */
	@TableField(value="HIGH_SPEED_MILEAGE",exist=true)
	java.math.BigDecimal highSpeedMileage;
	
	/**
	 * 属性描述:其他道路里程
	 */
	@TableField(value="OTHER_ROAD_MILEAGE",exist=true)
	java.math.BigDecimal otherRoadMileage;
	
	/**
	 * 属性描述:行驶里程评分
	 */
	@TableField(value="RUN_MILEAGE_LEVEL",exist=true)
	java.lang.String runMileageLevel;
	
	/**
	 * 属性描述:超速次数
	 */
	@TableField(value="OVERSPEED_NUM",exist=true)
	java.lang.Integer overspeedNum;
	
	/**
	 * 属性描述:严重超速次数
	 */
	@TableField(value="SERIOUS_OVERSPEED_NUM",exist=true)
	java.lang.Integer seriousOverspeedNum;
	
	/**
	 * 属性描述:疲劳次数
	 */
	@TableField(value="TIRED_NUM",exist=true)
	java.lang.Integer tiredNum;
	
	/**
	 * 属性描述:严重疲劳次数
	 */
	@TableField(value="SERIOUS_TIRED_NUM",exist=true)
	java.lang.Integer seriousTiredNum;
	
	/**
	 * 属性描述:主动安全报警次数
	 */
	@TableField(value="SAFETY_WARNING_NUM",exist=true)
	java.lang.Integer safetyWarningNum;
	
	/**
	 * 属性描述:危险驾驶评分
	 */
	@TableField(value="DANGER_RUN_LEVEL",exist=true)
	java.lang.String dangerRunLevel;
	
	/**
	 * 属性描述:安全培训次数
	 */
	@TableField(value="SAFETRAIN_NUM",exist=true)
	java.lang.Integer safetrainNum;
	
	/**
	 * 属性描述:安全培训评分
	 */
	@TableField(value="SAFETRAIN_LEVEL",exist=true)
	java.lang.String safetrainLevel;
	
	/**
	 * 属性描述:健康档案描述
	 */
	@TableField(value="HEALTH_REC",exist=true)
	java.lang.String healthRec;
	
	/**
	 * 属性描述:健康档案评分
	 */
	@TableField(value="HEALTH_LEVEL",exist=true)
	java.lang.String healthLevel;
	
	/**
	 * 属性描述:常去城市(5个)
	 */
	@TableField(value="STOP_CITY",exist=true)
	java.lang.String stopCity;
	
	/**
	 * 属性描述:常去城市评分
	 */
	@TableField(value="STOP_CITY_LEVEL",exist=true)
	java.lang.String stopCityLevel;
	
	/**
	 * 属性描述:最高速度
	 */
	@TableField(value="HIGHEST_SPEED",exist=true)
	java.math.BigDecimal highestSpeed;
	
	/**
	 * 属性描述:平均速度
	 */
	@TableField(value="AVERAGE_SPEED",exist=true)
	java.math.BigDecimal averageSpeed;
	
	/**
	 * 属性描述:行驶速度评分
	 */
	@TableField(value="RUN_SPEED_LEVEL",exist=true)
	java.lang.String runSpeedLevel;
	
	/**
	 * 属性描述:本地从业描述
	 */
	@TableField(value="EMP_DESC",exist=true)
	java.lang.String empDesc;
	
	/**
	 * 属性描述:百公里报警系数
	 */
	@TableField(value="WARNING_RATE",exist=true)
	java.math.BigDecimal warningRate;
	
	/**
	 * 属性描述:安全生产描述
	 */
	@TableField(value="SAFETY_DESC",exist=true)
	java.lang.String safetyDesc;
	
	/**
	 * 属性描述:经营分析评分
	 */
	@TableField(value="JY_LEVEL",exist=true)
	java.lang.String jyLevel;
	
	/**
	 * 属性描述:统计日期
	 */
	@TableField(value="COUNT_DATE",exist=true)
	java.lang.Integer countDate;
	
	/**
	 * 属性描述:统计月份
	 */
	@TableField(value="COUNT_MONTH",exist=true)
	java.lang.Integer countMonth;
	
	/**
	 * 属性描述:统计年份
	 */
	@TableField(value="YEAR_NUM",exist=true)
	java.lang.Integer yearNum;

	/**
	 * 属性描述:驾驶员id
	 */
	@TableField(value="DRIVER_ID",exist=true)
	java.lang.String driverId;


	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	
	public java.lang.String getCompId(){
		return this.compId;
	}
	
	public void setCompId(java.lang.String compId){
		this.compId=compId;
	}
	
	
	public java.lang.String getCompName(){
		return this.compName;
	}
	
	public void setCompName(java.lang.String compName){
		this.compName=compName;
	}
	
	
	public java.lang.String getTeamId(){
		return this.teamId;
	}
	
	public void setTeamId(java.lang.String teamId){
		this.teamId=teamId;
	}
	
	
	public java.lang.String getTeamName(){
		return this.teamName;
	}
	
	public void setTeamName(java.lang.String teamName){
		this.teamName=teamName;
	}
	
	
	public java.lang.String getProvinceId(){
		return this.provinceId;
	}
	
	public void setProvinceId(java.lang.String provinceId){
		this.provinceId=provinceId;
	}
	
	
	public java.lang.String getProvinceName(){
		return this.provinceName;
	}
	
	public void setProvinceName(java.lang.String provinceName){
		this.provinceName=provinceName;
	}
	
	
	public java.lang.String getCityId(){
		return this.cityId;
	}
	
	public void setCityId(java.lang.String cityId){
		this.cityId=cityId;
	}
	
	
	public java.lang.String getCityName(){
		return this.cityName;
	}
	
	public void setCityName(java.lang.String cityName){
		this.cityName=cityName;
	}
	
	
	public java.lang.String getXianquId(){
		return this.xianquId;
	}
	
	public void setXianquId(java.lang.String xianquId){
		this.xianquId=xianquId;
	}
	
	
	public java.lang.String getXianquName(){
		return this.xianquName;
	}
	
	public void setXianquName(java.lang.String xianquName){
		this.xianquName=xianquName;
	}
	
	
	public java.lang.String getDriverName(){
		return this.driverName;
	}
	
	public void setDriverName(java.lang.String driverName){
		this.driverName=driverName;
	}
	
	
	public java.lang.String getDriverSex(){
		return this.driverSex;
	}
	
	public void setDriverSex(java.lang.String driverSex){
		this.driverSex=driverSex;
	}
	
	
	public java.lang.Integer getDriverAge(){
		return this.driverAge;
	}
	
	public void setDriverAge(java.lang.Integer driverAge){
		this.driverAge=driverAge;
	}
	
	
	public java.lang.String getDriverPhone(){
		return this.driverPhone;
	}
	
	public void setDriverPhone(java.lang.String driverPhone){
		this.driverPhone=driverPhone;
	}
	
	
	public java.util.Date getDriverEntryDay(){
		return this.driverEntryDay;
	}
	
	public void setDriverEntryDay(java.util.Date driverEntryDay){
		this.driverEntryDay=driverEntryDay;
	}
	
	
	public java.lang.String getDriverIdCard(){
		return this.driverIdCard;
	}
	
	public void setDriverIdCard(java.lang.String driverIdCard){
		this.driverIdCard=driverIdCard;
	}
	
	
	public java.lang.String getDriverCode(){
		return this.driverCode;
	}
	
	public void setDriverCode(java.lang.String driverCode){
		this.driverCode=driverCode;
	}
	
	
	public java.lang.String getDriverLicenceType(){
		return this.driverLicenceType;
	}
	
	public void setDriverLicenceType(java.lang.String driverLicenceType){
		this.driverLicenceType=driverLicenceType;
	}
	
	
	public java.lang.String getDriverLicenceNum(){
		return this.driverLicenceNum;
	}
	
	public void setDriverLicenceNum(java.lang.String driverLicenceNum){
		this.driverLicenceNum=driverLicenceNum;
	}
	
	
	public java.lang.String getDriverCarType(){
		return this.driverCarType;
	}
	
	public void setDriverCarType(java.lang.String driverCarType){
		this.driverCarType=driverCarType;
	}
	
	
	public java.lang.String getDriverPhotoUrl(){
		return this.driverPhotoUrl;
	}
	
	public void setDriverPhotoUrl(java.lang.String driverPhotoUrl){
		this.driverPhotoUrl=driverPhotoUrl;
	}
	
	
	public java.lang.String getCarPlateNum(){
		return this.carPlateNum;
	}
	
	public void setCarPlateNum(java.lang.String carPlateNum){
		this.carPlateNum=carPlateNum;
	}
	
	
	public java.lang.String getCarPlateColor(){
		return this.carPlateColor;
	}
	
	public void setCarPlateColor(java.lang.String carPlateColor){
		this.carPlateColor=carPlateColor;
	}
	
	
	public java.lang.String getCarPlateColorText(){
		return this.carPlateColorText;
	}
	
	public void setCarPlateColorText(java.lang.String carPlateColorText){
		this.carPlateColorText=carPlateColorText;
	}
	
	
	public java.lang.String getCarFrameNum(){
		return this.carFrameNum;
	}
	
	public void setCarFrameNum(java.lang.String carFrameNum){
		this.carFrameNum=carFrameNum;
	}
	
	
	public java.lang.String getCarType(){
		return this.carType;
	}
	
	public void setCarType(java.lang.String carType){
		this.carType=carType;
	}
	
	
	public java.util.Date getBindTime(){
		return this.bindTime;
	}
	
	public void setBindTime(java.util.Date bindTime){
		this.bindTime=bindTime;
	}
	
	
	public java.lang.String getIsRealState(){
		return this.isRealState;
	}
	
	public void setIsRealState(java.lang.String isRealState){
		this.isRealState=isRealState;
	}
	
	
	public java.lang.String getSafeLevel(){
		return this.safeLevel;
	}
	
	public void setSafeLevel(java.lang.String safeLevel){
		this.safeLevel=safeLevel;
	}
	
	
	public java.math.BigDecimal getYearRunTimeLength(){
		return this.yearRunTimeLength;
	}
	
	public void setYearRunTimeLength(java.math.BigDecimal yearRunTimeLength){
		this.yearRunTimeLength=yearRunTimeLength;
	}
	
	
	public java.math.BigDecimal getDangerRunTimeLength(){
		return this.dangerRunTimeLength;
	}
	
	public void setDangerRunTimeLength(java.math.BigDecimal dangerRunTimeLength){
		this.dangerRunTimeLength=dangerRunTimeLength;
	}
	
	
	public java.math.BigDecimal getDayRunTimeLength(){
		return this.dayRunTimeLength;
	}
	
	public void setDayRunTimeLength(java.math.BigDecimal dayRunTimeLength){
		this.dayRunTimeLength=dayRunTimeLength;
	}
	
	
	public java.math.BigDecimal getNightRunTimeLength(){
		return this.nightRunTimeLength;
	}
	
	public void setNightRunTimeLength(java.math.BigDecimal nightRunTimeLength){
		this.nightRunTimeLength=nightRunTimeLength;
	}
	
	
	public java.lang.String getRunTimeLengthLevel(){
		return this.runTimeLengthLevel;
	}
	
	public void setRunTimeLengthLevel(java.lang.String runTimeLengthLevel){
		this.runTimeLengthLevel=runTimeLengthLevel;
	}
	
	
	public java.math.BigDecimal getYearRunMileage(){
		return this.yearRunMileage;
	}
	
	public void setYearRunMileage(java.math.BigDecimal yearRunMileage){
		this.yearRunMileage=yearRunMileage;
	}
	
	
	public java.math.BigDecimal getNationalRoadMileage(){
		return this.nationalRoadMileage;
	}
	
	public void setNationalRoadMileage(java.math.BigDecimal nationalRoadMileage){
		this.nationalRoadMileage=nationalRoadMileage;
	}
	
	
	public java.math.BigDecimal getHighSpeedMileage(){
		return this.highSpeedMileage;
	}
	
	public void setHighSpeedMileage(java.math.BigDecimal highSpeedMileage){
		this.highSpeedMileage=highSpeedMileage;
	}
	
	
	public java.math.BigDecimal getOtherRoadMileage(){
		return this.otherRoadMileage;
	}
	
	public void setOtherRoadMileage(java.math.BigDecimal otherRoadMileage){
		this.otherRoadMileage=otherRoadMileage;
	}
	
	
	public java.lang.String getRunMileageLevel(){
		return this.runMileageLevel;
	}
	
	public void setRunMileageLevel(java.lang.String runMileageLevel){
		this.runMileageLevel=runMileageLevel;
	}
	
	
	public java.lang.Integer getOverspeedNum(){
		return this.overspeedNum;
	}
	
	public void setOverspeedNum(java.lang.Integer overspeedNum){
		this.overspeedNum=overspeedNum;
	}
	
	
	public java.lang.Integer getSeriousOverspeedNum(){
		return this.seriousOverspeedNum;
	}
	
	public void setSeriousOverspeedNum(java.lang.Integer seriousOverspeedNum){
		this.seriousOverspeedNum=seriousOverspeedNum;
	}
	
	
	public java.lang.Integer getTiredNum(){
		return this.tiredNum;
	}
	
	public void setTiredNum(java.lang.Integer tiredNum){
		this.tiredNum=tiredNum;
	}
	
	
	public java.lang.Integer getSeriousTiredNum(){
		return this.seriousTiredNum;
	}
	
	public void setSeriousTiredNum(java.lang.Integer seriousTiredNum){
		this.seriousTiredNum=seriousTiredNum;
	}
	
	
	public java.lang.Integer getSafetyWarningNum(){
		return this.safetyWarningNum;
	}
	
	public void setSafetyWarningNum(java.lang.Integer safetyWarningNum){
		this.safetyWarningNum=safetyWarningNum;
	}
	
	
	public java.lang.String getDangerRunLevel(){
		return this.dangerRunLevel;
	}
	
	public void setDangerRunLevel(java.lang.String dangerRunLevel){
		this.dangerRunLevel=dangerRunLevel;
	}
	
	
	public java.lang.Integer getSafetrainNum(){
		return this.safetrainNum;
	}
	
	public void setSafetrainNum(java.lang.Integer safetrainNum){
		this.safetrainNum=safetrainNum;
	}
	
	
	public java.lang.String getSafetrainLevel(){
		return this.safetrainLevel;
	}
	
	public void setSafetrainLevel(java.lang.String safetrainLevel){
		this.safetrainLevel=safetrainLevel;
	}
	
	
	public java.lang.String getHealthRec(){
		return this.healthRec;
	}
	
	public void setHealthRec(java.lang.String healthRec){
		this.healthRec=healthRec;
	}
	
	
	public java.lang.String getHealthLevel(){
		return this.healthLevel;
	}
	
	public void setHealthLevel(java.lang.String healthLevel){
		this.healthLevel=healthLevel;
	}
	
	
	public java.lang.String getStopCity(){
		return this.stopCity;
	}
	
	public void setStopCity(java.lang.String stopCity){
		this.stopCity=stopCity;
	}
	
	
	public java.lang.String getStopCityLevel(){
		return this.stopCityLevel;
	}
	
	public void setStopCityLevel(java.lang.String stopCityLevel){
		this.stopCityLevel=stopCityLevel;
	}
	
	
	public java.math.BigDecimal getHighestSpeed(){
		return this.highestSpeed;
	}
	
	public void setHighestSpeed(java.math.BigDecimal highestSpeed){
		this.highestSpeed=highestSpeed;
	}
	
	
	public java.math.BigDecimal getAverageSpeed(){
		return this.averageSpeed;
	}
	
	public void setAverageSpeed(java.math.BigDecimal averageSpeed){
		this.averageSpeed=averageSpeed;
	}
	
	
	public java.lang.String getRunSpeedLevel(){
		return this.runSpeedLevel;
	}
	
	public void setRunSpeedLevel(java.lang.String runSpeedLevel){
		this.runSpeedLevel=runSpeedLevel;
	}
	
	
	public java.lang.String getEmpDesc(){
		return this.empDesc;
	}
	
	public void setEmpDesc(java.lang.String empDesc){
		this.empDesc=empDesc;
	}
	
	
	public java.math.BigDecimal getWarningRate(){
		return this.warningRate;
	}
	
	public void setWarningRate(java.math.BigDecimal warningRate){
		this.warningRate=warningRate;
	}
	
	
	public java.lang.String getSafetyDesc(){
		return this.safetyDesc;
	}
	
	public void setSafetyDesc(java.lang.String safetyDesc){
		this.safetyDesc=safetyDesc;
	}
	
	
	public java.lang.String getJyLevel(){
		return this.jyLevel;
	}
	
	public void setJyLevel(java.lang.String jyLevel){
		this.jyLevel=jyLevel;
	}
	
	
	public java.lang.Integer getCountDate(){
		return this.countDate;
	}
	
	public void setCountDate(java.lang.Integer countDate){
		this.countDate=countDate;
	}
	
	
	public java.lang.Integer getCountMonth(){
		return this.countMonth;
	}
	
	public void setCountMonth(java.lang.Integer countMonth){
		this.countMonth=countMonth;
	}
	
	
	public java.lang.Integer getYearNum(){
		return this.yearNum;
	}
	
	public void setYearNum(java.lang.Integer yearNum){
		this.yearNum=yearNum;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", compId=").append(compId);			
			sb.append(", compName=").append(compName);			
			sb.append(", teamId=").append(teamId);			
			sb.append(", teamName=").append(teamName);			
			sb.append(", provinceId=").append(provinceId);			
			sb.append(", provinceName=").append(provinceName);			
			sb.append(", cityId=").append(cityId);			
			sb.append(", cityName=").append(cityName);			
			sb.append(", xianquId=").append(xianquId);			
			sb.append(", xianquName=").append(xianquName);			
			sb.append(", driverName=").append(driverName);			
			sb.append(", driverSex=").append(driverSex);			
			sb.append(", driverAge=").append(driverAge);			
			sb.append(", driverPhone=").append(driverPhone);			
			sb.append(", driverEntryDay=").append(driverEntryDay);			
			sb.append(", driverIdCard=").append(driverIdCard);			
			sb.append(", driverCode=").append(driverCode);			
			sb.append(", driverLicenceType=").append(driverLicenceType);			
			sb.append(", driverLicenceNum=").append(driverLicenceNum);			
			sb.append(", driverCarType=").append(driverCarType);			
			sb.append(", driverPhotoUrl=").append(driverPhotoUrl);			
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carPlateColor=").append(carPlateColor);			
			sb.append(", carPlateColorText=").append(carPlateColorText);			
			sb.append(", carFrameNum=").append(carFrameNum);			
			sb.append(", carType=").append(carType);			
			sb.append(", bindTime=").append(bindTime);			
			sb.append(", isRealState=").append(isRealState);			
			sb.append(", safeLevel=").append(safeLevel);			
			sb.append(", yearRunTimeLength=").append(yearRunTimeLength);			
			sb.append(", dangerRunTimeLength=").append(dangerRunTimeLength);			
			sb.append(", dayRunTimeLength=").append(dayRunTimeLength);			
			sb.append(", nightRunTimeLength=").append(nightRunTimeLength);			
			sb.append(", runTimeLengthLevel=").append(runTimeLengthLevel);			
			sb.append(", yearRunMileage=").append(yearRunMileage);			
			sb.append(", nationalRoadMileage=").append(nationalRoadMileage);			
			sb.append(", highSpeedMileage=").append(highSpeedMileage);			
			sb.append(", otherRoadMileage=").append(otherRoadMileage);			
			sb.append(", runMileageLevel=").append(runMileageLevel);			
			sb.append(", overspeedNum=").append(overspeedNum);			
			sb.append(", seriousOverspeedNum=").append(seriousOverspeedNum);			
			sb.append(", tiredNum=").append(tiredNum);			
			sb.append(", seriousTiredNum=").append(seriousTiredNum);			
			sb.append(", safetyWarningNum=").append(safetyWarningNum);			
			sb.append(", dangerRunLevel=").append(dangerRunLevel);			
			sb.append(", safetrainNum=").append(safetrainNum);			
			sb.append(", safetrainLevel=").append(safetrainLevel);			
			sb.append(", healthRec=").append(healthRec);			
			sb.append(", healthLevel=").append(healthLevel);			
			sb.append(", stopCity=").append(stopCity);			
			sb.append(", stopCityLevel=").append(stopCityLevel);			
			sb.append(", highestSpeed=").append(highestSpeed);			
			sb.append(", averageSpeed=").append(averageSpeed);			
			sb.append(", runSpeedLevel=").append(runSpeedLevel);			
			sb.append(", empDesc=").append(empDesc);			
			sb.append(", warningRate=").append(warningRate);			
			sb.append(", safetyDesc=").append(safetyDesc);			
			sb.append(", jyLevel=").append(jyLevel);			
			sb.append(", countDate=").append(countDate);			
			sb.append(", countMonth=").append(countMonth);			
			sb.append(", yearNum=").append(yearNum);			
        sb.append("]");
        return sb.toString();
    }

   
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BigdataDriverDrawInfo other = (BigdataDriverDrawInfo) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCompId() == null ? other.getId() == null : this.getCompId().equals(other.getCompId()))		
				        		&&(this.getCompName() == null ? other.getId() == null : this.getCompName().equals(other.getCompName()))		
				        		&&(this.getTeamId() == null ? other.getId() == null : this.getTeamId().equals(other.getTeamId()))		
				        		&&(this.getTeamName() == null ? other.getId() == null : this.getTeamName().equals(other.getTeamName()))		
				        		&&(this.getProvinceId() == null ? other.getId() == null : this.getProvinceId().equals(other.getProvinceId()))		
				        		&&(this.getProvinceName() == null ? other.getId() == null : this.getProvinceName().equals(other.getProvinceName()))		
				        		&&(this.getCityId() == null ? other.getId() == null : this.getCityId().equals(other.getCityId()))		
				        		&&(this.getCityName() == null ? other.getId() == null : this.getCityName().equals(other.getCityName()))		
				        		&&(this.getXianquId() == null ? other.getId() == null : this.getXianquId().equals(other.getXianquId()))		
				        		&&(this.getXianquName() == null ? other.getId() == null : this.getXianquName().equals(other.getXianquName()))		
				        		&&(this.getDriverName() == null ? other.getId() == null : this.getDriverName().equals(other.getDriverName()))		
				        		&&(this.getDriverSex() == null ? other.getId() == null : this.getDriverSex().equals(other.getDriverSex()))		
				        		&&(this.getDriverAge() == null ? other.getId() == null : this.getDriverAge().equals(other.getDriverAge()))		
				        		&&(this.getDriverPhone() == null ? other.getId() == null : this.getDriverPhone().equals(other.getDriverPhone()))		
				        		&&(this.getDriverEntryDay() == null ? other.getId() == null : this.getDriverEntryDay().equals(other.getDriverEntryDay()))		
				        		&&(this.getDriverIdCard() == null ? other.getId() == null : this.getDriverIdCard().equals(other.getDriverIdCard()))		
				        		&&(this.getDriverCode() == null ? other.getId() == null : this.getDriverCode().equals(other.getDriverCode()))		
				        		&&(this.getDriverLicenceType() == null ? other.getId() == null : this.getDriverLicenceType().equals(other.getDriverLicenceType()))		
				        		&&(this.getDriverLicenceNum() == null ? other.getId() == null : this.getDriverLicenceNum().equals(other.getDriverLicenceNum()))		
				        		&&(this.getDriverCarType() == null ? other.getId() == null : this.getDriverCarType().equals(other.getDriverCarType()))		
				        		&&(this.getDriverPhotoUrl() == null ? other.getId() == null : this.getDriverPhotoUrl().equals(other.getDriverPhotoUrl()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarPlateColor() == null ? other.getId() == null : this.getCarPlateColor().equals(other.getCarPlateColor()))		
				        		&&(this.getCarPlateColorText() == null ? other.getId() == null : this.getCarPlateColorText().equals(other.getCarPlateColorText()))		
				        		&&(this.getCarFrameNum() == null ? other.getId() == null : this.getCarFrameNum().equals(other.getCarFrameNum()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getBindTime() == null ? other.getId() == null : this.getBindTime().equals(other.getBindTime()))		
				        		&&(this.getIsRealState() == null ? other.getId() == null : this.getIsRealState().equals(other.getIsRealState()))		
				        		&&(this.getSafeLevel() == null ? other.getId() == null : this.getSafeLevel().equals(other.getSafeLevel()))		
				        		&&(this.getYearRunTimeLength() == null ? other.getId() == null : this.getYearRunTimeLength().equals(other.getYearRunTimeLength()))		
				        		&&(this.getDangerRunTimeLength() == null ? other.getId() == null : this.getDangerRunTimeLength().equals(other.getDangerRunTimeLength()))		
				        		&&(this.getDayRunTimeLength() == null ? other.getId() == null : this.getDayRunTimeLength().equals(other.getDayRunTimeLength()))		
				        		&&(this.getNightRunTimeLength() == null ? other.getId() == null : this.getNightRunTimeLength().equals(other.getNightRunTimeLength()))		
				        		&&(this.getRunTimeLengthLevel() == null ? other.getId() == null : this.getRunTimeLengthLevel().equals(other.getRunTimeLengthLevel()))		
				        		&&(this.getYearRunMileage() == null ? other.getId() == null : this.getYearRunMileage().equals(other.getYearRunMileage()))		
				        		&&(this.getNationalRoadMileage() == null ? other.getId() == null : this.getNationalRoadMileage().equals(other.getNationalRoadMileage()))		
				        		&&(this.getHighSpeedMileage() == null ? other.getId() == null : this.getHighSpeedMileage().equals(other.getHighSpeedMileage()))		
				        		&&(this.getOtherRoadMileage() == null ? other.getId() == null : this.getOtherRoadMileage().equals(other.getOtherRoadMileage()))		
				        		&&(this.getRunMileageLevel() == null ? other.getId() == null : this.getRunMileageLevel().equals(other.getRunMileageLevel()))		
				        		&&(this.getOverspeedNum() == null ? other.getId() == null : this.getOverspeedNum().equals(other.getOverspeedNum()))		
				        		&&(this.getSeriousOverspeedNum() == null ? other.getId() == null : this.getSeriousOverspeedNum().equals(other.getSeriousOverspeedNum()))		
				        		&&(this.getTiredNum() == null ? other.getId() == null : this.getTiredNum().equals(other.getTiredNum()))		
				        		&&(this.getSeriousTiredNum() == null ? other.getId() == null : this.getSeriousTiredNum().equals(other.getSeriousTiredNum()))		
				        		&&(this.getSafetyWarningNum() == null ? other.getId() == null : this.getSafetyWarningNum().equals(other.getSafetyWarningNum()))		
				        		&&(this.getDangerRunLevel() == null ? other.getId() == null : this.getDangerRunLevel().equals(other.getDangerRunLevel()))		
				        		&&(this.getSafetrainNum() == null ? other.getId() == null : this.getSafetrainNum().equals(other.getSafetrainNum()))		
				        		&&(this.getSafetrainLevel() == null ? other.getId() == null : this.getSafetrainLevel().equals(other.getSafetrainLevel()))		
				        		&&(this.getHealthRec() == null ? other.getId() == null : this.getHealthRec().equals(other.getHealthRec()))		
				        		&&(this.getHealthLevel() == null ? other.getId() == null : this.getHealthLevel().equals(other.getHealthLevel()))		
				        		&&(this.getStopCity() == null ? other.getId() == null : this.getStopCity().equals(other.getStopCity()))		
				        		&&(this.getStopCityLevel() == null ? other.getId() == null : this.getStopCityLevel().equals(other.getStopCityLevel()))		
				        		&&(this.getHighestSpeed() == null ? other.getId() == null : this.getHighestSpeed().equals(other.getHighestSpeed()))		
				        		&&(this.getAverageSpeed() == null ? other.getId() == null : this.getAverageSpeed().equals(other.getAverageSpeed()))		
				        		&&(this.getRunSpeedLevel() == null ? other.getId() == null : this.getRunSpeedLevel().equals(other.getRunSpeedLevel()))		
				        		&&(this.getEmpDesc() == null ? other.getId() == null : this.getEmpDesc().equals(other.getEmpDesc()))		
				        		&&(this.getWarningRate() == null ? other.getId() == null : this.getWarningRate().equals(other.getWarningRate()))		
				        		&&(this.getSafetyDesc() == null ? other.getId() == null : this.getSafetyDesc().equals(other.getSafetyDesc()))		
				        		&&(this.getJyLevel() == null ? other.getId() == null : this.getJyLevel().equals(other.getJyLevel()))		
				        		&&(this.getCountDate() == null ? other.getId() == null : this.getCountDate().equals(other.getCountDate()))		
				        		&&(this.getCountMonth() == null ? other.getId() == null : this.getCountMonth().equals(other.getCountMonth()))		
				        		&&(this.getYearNum() == null ? other.getId() == null : this.getYearNum().equals(other.getYearNum()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());		
		        result = prime * result + ((getCompName() == null) ? 0 : getCompName().hashCode());		
		        result = prime * result + ((getTeamId() == null) ? 0 : getTeamId().hashCode());		
		        result = prime * result + ((getTeamName() == null) ? 0 : getTeamName().hashCode());		
		        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());		
		        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());		
		        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());		
		        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());		
		        result = prime * result + ((getXianquId() == null) ? 0 : getXianquId().hashCode());		
		        result = prime * result + ((getXianquName() == null) ? 0 : getXianquName().hashCode());		
		        result = prime * result + ((getDriverName() == null) ? 0 : getDriverName().hashCode());		
		        result = prime * result + ((getDriverSex() == null) ? 0 : getDriverSex().hashCode());		
		        result = prime * result + ((getDriverAge() == null) ? 0 : getDriverAge().hashCode());		
		        result = prime * result + ((getDriverPhone() == null) ? 0 : getDriverPhone().hashCode());		
		        result = prime * result + ((getDriverEntryDay() == null) ? 0 : getDriverEntryDay().hashCode());		
		        result = prime * result + ((getDriverIdCard() == null) ? 0 : getDriverIdCard().hashCode());		
		        result = prime * result + ((getDriverCode() == null) ? 0 : getDriverCode().hashCode());		
		        result = prime * result + ((getDriverLicenceType() == null) ? 0 : getDriverLicenceType().hashCode());		
		        result = prime * result + ((getDriverLicenceNum() == null) ? 0 : getDriverLicenceNum().hashCode());		
		        result = prime * result + ((getDriverCarType() == null) ? 0 : getDriverCarType().hashCode());		
		        result = prime * result + ((getDriverPhotoUrl() == null) ? 0 : getDriverPhotoUrl().hashCode());		
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarPlateColor() == null) ? 0 : getCarPlateColor().hashCode());		
		        result = prime * result + ((getCarPlateColorText() == null) ? 0 : getCarPlateColorText().hashCode());		
		        result = prime * result + ((getCarFrameNum() == null) ? 0 : getCarFrameNum().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getBindTime() == null) ? 0 : getBindTime().hashCode());		
		        result = prime * result + ((getIsRealState() == null) ? 0 : getIsRealState().hashCode());		
		        result = prime * result + ((getSafeLevel() == null) ? 0 : getSafeLevel().hashCode());		
		        result = prime * result + ((getYearRunTimeLength() == null) ? 0 : getYearRunTimeLength().hashCode());		
		        result = prime * result + ((getDangerRunTimeLength() == null) ? 0 : getDangerRunTimeLength().hashCode());		
		        result = prime * result + ((getDayRunTimeLength() == null) ? 0 : getDayRunTimeLength().hashCode());		
		        result = prime * result + ((getNightRunTimeLength() == null) ? 0 : getNightRunTimeLength().hashCode());		
		        result = prime * result + ((getRunTimeLengthLevel() == null) ? 0 : getRunTimeLengthLevel().hashCode());		
		        result = prime * result + ((getYearRunMileage() == null) ? 0 : getYearRunMileage().hashCode());		
		        result = prime * result + ((getNationalRoadMileage() == null) ? 0 : getNationalRoadMileage().hashCode());		
		        result = prime * result + ((getHighSpeedMileage() == null) ? 0 : getHighSpeedMileage().hashCode());		
		        result = prime * result + ((getOtherRoadMileage() == null) ? 0 : getOtherRoadMileage().hashCode());		
		        result = prime * result + ((getRunMileageLevel() == null) ? 0 : getRunMileageLevel().hashCode());		
		        result = prime * result + ((getOverspeedNum() == null) ? 0 : getOverspeedNum().hashCode());		
		        result = prime * result + ((getSeriousOverspeedNum() == null) ? 0 : getSeriousOverspeedNum().hashCode());		
		        result = prime * result + ((getTiredNum() == null) ? 0 : getTiredNum().hashCode());		
		        result = prime * result + ((getSeriousTiredNum() == null) ? 0 : getSeriousTiredNum().hashCode());		
		        result = prime * result + ((getSafetyWarningNum() == null) ? 0 : getSafetyWarningNum().hashCode());		
		        result = prime * result + ((getDangerRunLevel() == null) ? 0 : getDangerRunLevel().hashCode());		
		        result = prime * result + ((getSafetrainNum() == null) ? 0 : getSafetrainNum().hashCode());		
		        result = prime * result + ((getSafetrainLevel() == null) ? 0 : getSafetrainLevel().hashCode());		
		        result = prime * result + ((getHealthRec() == null) ? 0 : getHealthRec().hashCode());		
		        result = prime * result + ((getHealthLevel() == null) ? 0 : getHealthLevel().hashCode());		
		        result = prime * result + ((getStopCity() == null) ? 0 : getStopCity().hashCode());		
		        result = prime * result + ((getStopCityLevel() == null) ? 0 : getStopCityLevel().hashCode());		
		        result = prime * result + ((getHighestSpeed() == null) ? 0 : getHighestSpeed().hashCode());		
		        result = prime * result + ((getAverageSpeed() == null) ? 0 : getAverageSpeed().hashCode());		
		        result = prime * result + ((getRunSpeedLevel() == null) ? 0 : getRunSpeedLevel().hashCode());		
		        result = prime * result + ((getEmpDesc() == null) ? 0 : getEmpDesc().hashCode());		
		        result = prime * result + ((getWarningRate() == null) ? 0 : getWarningRate().hashCode());		
		        result = prime * result + ((getSafetyDesc() == null) ? 0 : getSafetyDesc().hashCode());		
		        result = prime * result + ((getJyLevel() == null) ? 0 : getJyLevel().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
