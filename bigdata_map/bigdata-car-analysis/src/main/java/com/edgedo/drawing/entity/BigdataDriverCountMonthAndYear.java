package com.edgedo.drawing.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("bigdata_driver_count_month_and_year")
public class BigdataDriverCountMonthAndYear implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;

	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;

	/**
	 * 属性描述:所属运营商
	 */
	@TableField(value="COMP_ID",exist=true)
	String compId;

	/**
	 * 属性描述:运营商名
	 */
	@TableField(value="COMP_NAME",exist=true)
	String compName;

	/**
	 * 属性描述:所属企业
	 */
	@TableField(value="TEAM_ID",exist=true)
	String teamId;

	/**
	 * 属性描述:企业名
	 */
	@TableField(value="TEAM_NAME",exist=true)
	String teamName;

	/**
	 * 属性描述:省ID
	 */
	@TableField(value="PROVINCE_ID",exist=true)
	String provinceId;

	/**
	 * 属性描述:省名
	 */
	@TableField(value="PROVINCE_NAME",exist=true)
	String provinceName;

	/**
	 * 属性描述:城市ID
	 */
	@TableField(value="CITY_ID",exist=true)
	String cityId;

	/**
	 * 属性描述:城市名
	 */
	@TableField(value="CITY_NAME",exist=true)
	String cityName;

	/**
	 * 属性描述:县区ID
	 */
	@TableField(value="XIANQU_ID",exist=true)
	String xianquId;

	/**
	 * 属性描述:县区名
	 */
	@TableField(value="XIANQU_NAME",exist=true)
	String xianquName;

	/**
	 * 属性描述:驾驶员ID
	 */
	@TableField(value="DRIVER_ID",exist=true)
	String driverId;

	/**
	 * 属性描述:驾驶员姓名
	 */
	@TableField(value="DRIVER_NAME",exist=true)
	String driverName;

	/**
	 * 属性描述:驾驶员性别
	 */
	@TableField(value="DRIVER_SEX",exist=true)
	String driverSex;

	/**
	 * 属性描述:驾驶员年龄
	 */
	@TableField(value="DRIVER_AGE",exist=true)
	Integer driverAge;

	/**
	 * 属性描述:驾驶员电话
	 */
	@TableField(value="DRIVER_PHONE",exist=true)
	String driverPhone;

	/**
	 * 属性描述:驾驶员身份证号
	 */
	@TableField(value="DRIVER_ID_CARD",exist=true)
	String driverIdCard;

	/**
	 * 属性描述:驾驶员资格证号
	 */
	@TableField(value="DRIVER_CODE",exist=true)
	String driverCode;

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
	 * 属性描述:白天行驶里程
	 */
	@TableField(value="DAY_RUN_MILEAGE",exist=true)
	java.math.BigDecimal dayRunMileage;

	/**
	 * 属性描述:夜晚行驶里程
	 */
	@TableField(value="NIGHT_RUN_MILEAGE",exist=true)
	java.math.BigDecimal nightRunMileage;

	/**
	 * 属性描述:危险时段行驶里程
	 */
	@TableField(value="DANGER_RUN_MILEAGE",exist=true)
	java.math.BigDecimal dangerRunMileage;

	/**
	 * 属性描述:总里程
	 */
	@TableField(value="SUM_MILEAGE",exist=true)
	java.math.BigDecimal sumMileage;

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
	 * 属性描述:危险时段行驶时长
	 */
	@TableField(value="DANGER_RUN_TIME_LENGTH",exist=true)
	java.math.BigDecimal dangerRunTimeLength;

	/**
	 * 属性描述:总时长
	 */
	@TableField(value="SUM_RUN_TIME_LENGTH",exist=true)
	java.math.BigDecimal sumRunTimeLength;

	/**
	 * 属性描述:白天行驶平均速度
	 */
	@TableField(value="DAY_RUN_AVERAGE_SPEED",exist=true)
	java.math.BigDecimal dayRunAverageSpeed;

	/**
	 * 属性描述:夜晚行驶平均速度
	 */
	@TableField(value="NIGHT_RUN_AVERAGE_SPEED",exist=true)
	java.math.BigDecimal nightRunAverageSpeed;

	/**
	 * 属性描述:危险时段行驶平均速度
	 */
	@TableField(value="DANGER_RUN_AVERAGE_SPEED",exist=true)
	java.math.BigDecimal dangerRunAverageSpeed;

	/**
	 * 属性描述:平均速度
	 */
	@TableField(value="AVERAGE_SPEED",exist=true)
	java.math.BigDecimal averageSpeed;

	/**
	 * 属性描述:最高速度
	 */
	@TableField(value="HIGHEST_SPEED",exist=true)
	java.math.BigDecimal highestSpeed;

	/**
	 * 属性描述:超速次数
	 */
	@TableField(value="OVERSPEED_NUM",exist=true)
	Integer overspeedNum;

	/**
	 * 属性描述:严重超速次数
	 */
	@TableField(value="SERIOUS_OVERSPEED_NUM",exist=true)
	Integer seriousOverspeedNum;

	/**
	 * 属性描述:疲劳次数
	 */
	@TableField(value="TIRED_NUM",exist=true)
	Integer tiredNum;

	/**
	 * 属性描述:严重疲劳次数
	 */
	@TableField(value="SERIOUS_TIRED_NUM",exist=true)
	Integer seriousTiredNum;

	/**
	 * 属性描述:主动安全报警次数
	 */
	@TableField(value="SAFETY_WARNING_NUM",exist=true)
	Integer safetyWarningNum;

	/**
	 * 属性描述:安全培训次数
	 */
	@TableField(value="SAFETRAIN_NUM",exist=true)
	Integer safetrainNum;

	/**
	 * 属性描述:百公里报警系数
	 */
	@TableField(value="WARNING_RATE",exist=true)
	java.math.BigDecimal warningRate;

	/**
	 * 属性描述:统计类型
	 */
	@TableField(value="COUNT_TYPE",exist=true)
	String countType;

	/**
	 * 属性描述:统计日期
	 */
	@TableField(value="COUNT_DATE",exist=true)
	Integer countDate;

	/**
	 * 属性描述:统计月份
	 */
	@TableField(value="COUNT_MONTH",exist=true)
	Integer countMonth;

	/**
	 * 属性描述:统计年份
	 */
	@TableField(value="YEAR_NUM",exist=true)
	Integer yearNum;






	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}


	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}


	public String getCompId(){
		return this.compId;
	}

	public void setCompId(String compId){
		this.compId=compId;
	}


	public String getCompName(){
		return this.compName;
	}

	public void setCompName(String compName){
		this.compName=compName;
	}


	public String getTeamId(){
		return this.teamId;
	}

	public void setTeamId(String teamId){
		this.teamId=teamId;
	}


	public String getTeamName(){
		return this.teamName;
	}

	public void setTeamName(String teamName){
		this.teamName=teamName;
	}


	public String getProvinceId(){
		return this.provinceId;
	}

	public void setProvinceId(String provinceId){
		this.provinceId=provinceId;
	}


	public String getProvinceName(){
		return this.provinceName;
	}

	public void setProvinceName(String provinceName){
		this.provinceName=provinceName;
	}


	public String getCityId(){
		return this.cityId;
	}

	public void setCityId(String cityId){
		this.cityId=cityId;
	}


	public String getCityName(){
		return this.cityName;
	}

	public void setCityName(String cityName){
		this.cityName=cityName;
	}


	public String getXianquId(){
		return this.xianquId;
	}

	public void setXianquId(String xianquId){
		this.xianquId=xianquId;
	}


	public String getXianquName(){
		return this.xianquName;
	}

	public void setXianquName(String xianquName){
		this.xianquName=xianquName;
	}


	public String getDriverId(){
		return this.driverId;
	}

	public void setDriverId(String driverId){
		this.driverId=driverId;
	}


	public String getDriverName(){
		return this.driverName;
	}

	public void setDriverName(String driverName){
		this.driverName=driverName;
	}


	public String getDriverSex(){
		return this.driverSex;
	}

	public void setDriverSex(String driverSex){
		this.driverSex=driverSex;
	}


	public Integer getDriverAge(){
		return this.driverAge;
	}

	public void setDriverAge(Integer driverAge){
		this.driverAge=driverAge;
	}


	public String getDriverPhone(){
		return this.driverPhone;
	}

	public void setDriverPhone(String driverPhone){
		this.driverPhone=driverPhone;
	}


	public String getDriverIdCard(){
		return this.driverIdCard;
	}

	public void setDriverIdCard(String driverIdCard){
		this.driverIdCard=driverIdCard;
	}


	public String getDriverCode(){
		return this.driverCode;
	}

	public void setDriverCode(String driverCode){
		this.driverCode=driverCode;
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


	public java.math.BigDecimal getDayRunMileage(){
		return this.dayRunMileage;
	}

	public void setDayRunMileage(java.math.BigDecimal dayRunMileage){
		this.dayRunMileage=dayRunMileage;
	}


	public java.math.BigDecimal getNightRunMileage(){
		return this.nightRunMileage;
	}

	public void setNightRunMileage(java.math.BigDecimal nightRunMileage){
		this.nightRunMileage=nightRunMileage;
	}


	public java.math.BigDecimal getDangerRunMileage(){
		return this.dangerRunMileage;
	}

	public void setDangerRunMileage(java.math.BigDecimal dangerRunMileage){
		this.dangerRunMileage=dangerRunMileage;
	}


	public java.math.BigDecimal getSumMileage(){
		return this.sumMileage;
	}

	public void setSumMileage(java.math.BigDecimal sumMileage){
		this.sumMileage=sumMileage;
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


	public java.math.BigDecimal getDangerRunTimeLength(){
		return this.dangerRunTimeLength;
	}

	public void setDangerRunTimeLength(java.math.BigDecimal dangerRunTimeLength){
		this.dangerRunTimeLength=dangerRunTimeLength;
	}


	public java.math.BigDecimal getSumRunTimeLength(){
		return this.sumRunTimeLength;
	}

	public void setSumRunTimeLength(java.math.BigDecimal sumRunTimeLength){
		this.sumRunTimeLength=sumRunTimeLength;
	}


	public java.math.BigDecimal getDayRunAverageSpeed(){
		return this.dayRunAverageSpeed;
	}

	public void setDayRunAverageSpeed(java.math.BigDecimal dayRunAverageSpeed){
		this.dayRunAverageSpeed=dayRunAverageSpeed;
	}


	public java.math.BigDecimal getNightRunAverageSpeed(){
		return this.nightRunAverageSpeed;
	}

	public void setNightRunAverageSpeed(java.math.BigDecimal nightRunAverageSpeed){
		this.nightRunAverageSpeed=nightRunAverageSpeed;
	}


	public java.math.BigDecimal getDangerRunAverageSpeed(){
		return this.dangerRunAverageSpeed;
	}

	public void setDangerRunAverageSpeed(java.math.BigDecimal dangerRunAverageSpeed){
		this.dangerRunAverageSpeed=dangerRunAverageSpeed;
	}


	public java.math.BigDecimal getAverageSpeed(){
		return this.averageSpeed;
	}

	public void setAverageSpeed(java.math.BigDecimal averageSpeed){
		this.averageSpeed=averageSpeed;
	}


	public java.math.BigDecimal getHighestSpeed(){
		return this.highestSpeed;
	}

	public void setHighestSpeed(java.math.BigDecimal highestSpeed){
		this.highestSpeed=highestSpeed;
	}


	public Integer getOverspeedNum(){
		return this.overspeedNum;
	}

	public void setOverspeedNum(Integer overspeedNum){
		this.overspeedNum=overspeedNum;
	}


	public Integer getSeriousOverspeedNum(){
		return this.seriousOverspeedNum;
	}

	public void setSeriousOverspeedNum(Integer seriousOverspeedNum){
		this.seriousOverspeedNum=seriousOverspeedNum;
	}


	public Integer getTiredNum(){
		return this.tiredNum;
	}

	public void setTiredNum(Integer tiredNum){
		this.tiredNum=tiredNum;
	}


	public Integer getSeriousTiredNum(){
		return this.seriousTiredNum;
	}

	public void setSeriousTiredNum(Integer seriousTiredNum){
		this.seriousTiredNum=seriousTiredNum;
	}


	public Integer getSafetyWarningNum(){
		return this.safetyWarningNum;
	}

	public void setSafetyWarningNum(Integer safetyWarningNum){
		this.safetyWarningNum=safetyWarningNum;
	}


	public Integer getSafetrainNum(){
		return this.safetrainNum;
	}

	public void setSafetrainNum(Integer safetrainNum){
		this.safetrainNum=safetrainNum;
	}


	public java.math.BigDecimal getWarningRate(){
		return this.warningRate;
	}

	public void setWarningRate(java.math.BigDecimal warningRate){
		this.warningRate=warningRate;
	}


	public String getCountType(){
		return this.countType;
	}

	public void setCountType(String countType){
		this.countType=countType;
	}


	public Integer getCountDate(){
		return this.countDate;
	}

	public void setCountDate(Integer countDate){
		this.countDate=countDate;
	}


	public Integer getCountMonth(){
		return this.countMonth;
	}

	public void setCountMonth(Integer countMonth){
		this.countMonth=countMonth;
	}


	public Integer getYearNum(){
		return this.yearNum;
	}

	public void setYearNum(Integer yearNum){
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
			sb.append(", driverId=").append(driverId);			
			sb.append(", driverName=").append(driverName);			
			sb.append(", driverSex=").append(driverSex);			
			sb.append(", driverAge=").append(driverAge);			
			sb.append(", driverPhone=").append(driverPhone);			
			sb.append(", driverIdCard=").append(driverIdCard);			
			sb.append(", driverCode=").append(driverCode);			
			sb.append(", nationalRoadMileage=").append(nationalRoadMileage);			
			sb.append(", highSpeedMileage=").append(highSpeedMileage);			
			sb.append(", otherRoadMileage=").append(otherRoadMileage);			
			sb.append(", dayRunMileage=").append(dayRunMileage);			
			sb.append(", nightRunMileage=").append(nightRunMileage);			
			sb.append(", dangerRunMileage=").append(dangerRunMileage);			
			sb.append(", sumMileage=").append(sumMileage);			
			sb.append(", dayRunTimeLength=").append(dayRunTimeLength);			
			sb.append(", nightRunTimeLength=").append(nightRunTimeLength);			
			sb.append(", dangerRunTimeLength=").append(dangerRunTimeLength);			
			sb.append(", sumRunTimeLength=").append(sumRunTimeLength);			
			sb.append(", dayRunAverageSpeed=").append(dayRunAverageSpeed);			
			sb.append(", nightRunAverageSpeed=").append(nightRunAverageSpeed);			
			sb.append(", dangerRunAverageSpeed=").append(dangerRunAverageSpeed);			
			sb.append(", averageSpeed=").append(averageSpeed);			
			sb.append(", highestSpeed=").append(highestSpeed);			
			sb.append(", overspeedNum=").append(overspeedNum);			
			sb.append(", seriousOverspeedNum=").append(seriousOverspeedNum);			
			sb.append(", tiredNum=").append(tiredNum);			
			sb.append(", seriousTiredNum=").append(seriousTiredNum);			
			sb.append(", safetyWarningNum=").append(safetyWarningNum);			
			sb.append(", safetrainNum=").append(safetrainNum);			
			sb.append(", warningRate=").append(warningRate);			
			sb.append(", countType=").append(countType);			
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
        BigdataDriverCountMonthAndYear other = (BigdataDriverCountMonthAndYear) that;
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
				        		&&(this.getDriverId() == null ? other.getId() == null : this.getDriverId().equals(other.getDriverId()))		
				        		&&(this.getDriverName() == null ? other.getId() == null : this.getDriverName().equals(other.getDriverName()))		
				        		&&(this.getDriverSex() == null ? other.getId() == null : this.getDriverSex().equals(other.getDriverSex()))		
				        		&&(this.getDriverAge() == null ? other.getId() == null : this.getDriverAge().equals(other.getDriverAge()))		
				        		&&(this.getDriverPhone() == null ? other.getId() == null : this.getDriverPhone().equals(other.getDriverPhone()))		
				        		&&(this.getDriverIdCard() == null ? other.getId() == null : this.getDriverIdCard().equals(other.getDriverIdCard()))		
				        		&&(this.getDriverCode() == null ? other.getId() == null : this.getDriverCode().equals(other.getDriverCode()))		
				        		&&(this.getNationalRoadMileage() == null ? other.getId() == null : this.getNationalRoadMileage().equals(other.getNationalRoadMileage()))		
				        		&&(this.getHighSpeedMileage() == null ? other.getId() == null : this.getHighSpeedMileage().equals(other.getHighSpeedMileage()))		
				        		&&(this.getOtherRoadMileage() == null ? other.getId() == null : this.getOtherRoadMileage().equals(other.getOtherRoadMileage()))		
				        		&&(this.getDayRunMileage() == null ? other.getId() == null : this.getDayRunMileage().equals(other.getDayRunMileage()))		
				        		&&(this.getNightRunMileage() == null ? other.getId() == null : this.getNightRunMileage().equals(other.getNightRunMileage()))		
				        		&&(this.getDangerRunMileage() == null ? other.getId() == null : this.getDangerRunMileage().equals(other.getDangerRunMileage()))		
				        		&&(this.getSumMileage() == null ? other.getId() == null : this.getSumMileage().equals(other.getSumMileage()))		
				        		&&(this.getDayRunTimeLength() == null ? other.getId() == null : this.getDayRunTimeLength().equals(other.getDayRunTimeLength()))		
				        		&&(this.getNightRunTimeLength() == null ? other.getId() == null : this.getNightRunTimeLength().equals(other.getNightRunTimeLength()))		
				        		&&(this.getDangerRunTimeLength() == null ? other.getId() == null : this.getDangerRunTimeLength().equals(other.getDangerRunTimeLength()))		
				        		&&(this.getSumRunTimeLength() == null ? other.getId() == null : this.getSumRunTimeLength().equals(other.getSumRunTimeLength()))		
				        		&&(this.getDayRunAverageSpeed() == null ? other.getId() == null : this.getDayRunAverageSpeed().equals(other.getDayRunAverageSpeed()))		
				        		&&(this.getNightRunAverageSpeed() == null ? other.getId() == null : this.getNightRunAverageSpeed().equals(other.getNightRunAverageSpeed()))		
				        		&&(this.getDangerRunAverageSpeed() == null ? other.getId() == null : this.getDangerRunAverageSpeed().equals(other.getDangerRunAverageSpeed()))		
				        		&&(this.getAverageSpeed() == null ? other.getId() == null : this.getAverageSpeed().equals(other.getAverageSpeed()))		
				        		&&(this.getHighestSpeed() == null ? other.getId() == null : this.getHighestSpeed().equals(other.getHighestSpeed()))		
				        		&&(this.getOverspeedNum() == null ? other.getId() == null : this.getOverspeedNum().equals(other.getOverspeedNum()))		
				        		&&(this.getSeriousOverspeedNum() == null ? other.getId() == null : this.getSeriousOverspeedNum().equals(other.getSeriousOverspeedNum()))		
				        		&&(this.getTiredNum() == null ? other.getId() == null : this.getTiredNum().equals(other.getTiredNum()))		
				        		&&(this.getSeriousTiredNum() == null ? other.getId() == null : this.getSeriousTiredNum().equals(other.getSeriousTiredNum()))		
				        		&&(this.getSafetyWarningNum() == null ? other.getId() == null : this.getSafetyWarningNum().equals(other.getSafetyWarningNum()))		
				        		&&(this.getSafetrainNum() == null ? other.getId() == null : this.getSafetrainNum().equals(other.getSafetrainNum()))		
				        		&&(this.getWarningRate() == null ? other.getId() == null : this.getWarningRate().equals(other.getWarningRate()))		
				        		&&(this.getCountType() == null ? other.getId() == null : this.getCountType().equals(other.getCountType()))		
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
		        result = prime * result + ((getDriverId() == null) ? 0 : getDriverId().hashCode());		
		        result = prime * result + ((getDriverName() == null) ? 0 : getDriverName().hashCode());		
		        result = prime * result + ((getDriverSex() == null) ? 0 : getDriverSex().hashCode());		
		        result = prime * result + ((getDriverAge() == null) ? 0 : getDriverAge().hashCode());		
		        result = prime * result + ((getDriverPhone() == null) ? 0 : getDriverPhone().hashCode());		
		        result = prime * result + ((getDriverIdCard() == null) ? 0 : getDriverIdCard().hashCode());		
		        result = prime * result + ((getDriverCode() == null) ? 0 : getDriverCode().hashCode());		
		        result = prime * result + ((getNationalRoadMileage() == null) ? 0 : getNationalRoadMileage().hashCode());		
		        result = prime * result + ((getHighSpeedMileage() == null) ? 0 : getHighSpeedMileage().hashCode());		
		        result = prime * result + ((getOtherRoadMileage() == null) ? 0 : getOtherRoadMileage().hashCode());		
		        result = prime * result + ((getDayRunMileage() == null) ? 0 : getDayRunMileage().hashCode());		
		        result = prime * result + ((getNightRunMileage() == null) ? 0 : getNightRunMileage().hashCode());		
		        result = prime * result + ((getDangerRunMileage() == null) ? 0 : getDangerRunMileage().hashCode());		
		        result = prime * result + ((getSumMileage() == null) ? 0 : getSumMileage().hashCode());		
		        result = prime * result + ((getDayRunTimeLength() == null) ? 0 : getDayRunTimeLength().hashCode());		
		        result = prime * result + ((getNightRunTimeLength() == null) ? 0 : getNightRunTimeLength().hashCode());		
		        result = prime * result + ((getDangerRunTimeLength() == null) ? 0 : getDangerRunTimeLength().hashCode());		
		        result = prime * result + ((getSumRunTimeLength() == null) ? 0 : getSumRunTimeLength().hashCode());		
		        result = prime * result + ((getDayRunAverageSpeed() == null) ? 0 : getDayRunAverageSpeed().hashCode());		
		        result = prime * result + ((getNightRunAverageSpeed() == null) ? 0 : getNightRunAverageSpeed().hashCode());		
		        result = prime * result + ((getDangerRunAverageSpeed() == null) ? 0 : getDangerRunAverageSpeed().hashCode());		
		        result = prime * result + ((getAverageSpeed() == null) ? 0 : getAverageSpeed().hashCode());		
		        result = prime * result + ((getHighestSpeed() == null) ? 0 : getHighestSpeed().hashCode());		
		        result = prime * result + ((getOverspeedNum() == null) ? 0 : getOverspeedNum().hashCode());		
		        result = prime * result + ((getSeriousOverspeedNum() == null) ? 0 : getSeriousOverspeedNum().hashCode());		
		        result = prime * result + ((getTiredNum() == null) ? 0 : getTiredNum().hashCode());		
		        result = prime * result + ((getSeriousTiredNum() == null) ? 0 : getSeriousTiredNum().hashCode());		
		        result = prime * result + ((getSafetyWarningNum() == null) ? 0 : getSafetyWarningNum().hashCode());		
		        result = prime * result + ((getSafetrainNum() == null) ? 0 : getSafetrainNum().hashCode());		
		        result = prime * result + ((getWarningRate() == null) ? 0 : getWarningRate().hashCode());		
		        result = prime * result + ((getCountType() == null) ? 0 : getCountType().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}