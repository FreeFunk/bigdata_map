package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

@TableName("bigdata_fenxi_team_day")
public class BigdataFenxiTeamDay implements Serializable{
	
		
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
	 * 属性描述:更新时间
	 */
	@TableField(value="UPDATE_TIME",exist=true)
	java.util.Date updateTime;

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
	 * 属性描述:企业id
	 */
	@TableField(value="TEAM_ID",exist=true)
	String teamId;

	/**
	 * 属性描述:企业名
	 */
	@TableField(value="TEAM_NAME",exist=true)
	String teamName;

	/**
	 * 属性描述:企业类型
	 */
	@TableField(value="TEAM_TYPE",exist=true)
	String teamType;

	/**
	 * 属性描述:运输类型
	 */
	@TableField(value="TRANSIT_TYPE",exist=true)
	String transitType;

	/**
	 * 属性描述:统计车辆数
	 */
	@TableField(value="COUNT_CAR_NUM",exist=true)
	Integer countCarNum;

	/**
	 * 属性描述:行驶里程
	 */
	@TableField(value="RUN_MILEAGE",exist=true)
	java.math.BigDecimal runMileage;

	/**
	 * 属性描述:行驶时长（秒）
	 */
	@TableField(value="RUN_TIME_LENGTH",exist=true)
	java.math.BigDecimal runTimeLength;

	/**
	 * 属性描述:行驶时长文本
	 */
	@TableField(value="RUN_TIME_LENGTH_TEXT",exist=true)
	String runTimeLengthText;

	/**
	 * 属性描述:行驶时长(小时）
	 */
	@TableField(value="RUN_TIME_LENGTH_HOUR",exist=true)
	java.math.BigDecimal runTimeLengthHour;

	/**
	 * 属性描述:报警数量
	 */
	@TableField(value="ALARM_NUM",exist=true)
	Integer alarmNum;

	/**
	 * 属性描述:报警数量/百公里
	 */
	@TableField(value="ALARM_RATE",exist=true)
	java.math.BigDecimal alarmRate;

	/**
	 * 属性描述:安全评分
	 */
	@TableField(value="SAFE_SCORE",exist=true)
	java.math.BigDecimal safeScore;

	/**
	 * 属性描述:平均速度
	 */
	@TableField(value="AVERAGE_SPEED",exist=true)
	java.math.BigDecimal averageSpeed;

	/**
	 * 属性描述:平均行驶里程
	 */
	@TableField(value="AVERAGE_RUN_MILEAGE",exist=true)
	java.math.BigDecimal averageRunMileage;

	/**
	 * 属性描述:平均行驶时长（小时）
	 */
	@TableField(value="AVERAGE_RUN_TIME_LENGTH",exist=true)
	java.math.BigDecimal averageRunTimeLength;

	/**
	 * 属性描述:平均报警数量
	 */
	@TableField(value="AVERAGE_ALARM_NUM",exist=true)
	java.math.BigDecimal averageAlarmNum;

	/**
	 * 属性描述:行驶里程前三
	 */
	@TableField(value="RUN_MILEAGE_TOP_THREE",exist=true)
	String runMileageTopThree;

	/**
	 * 属性描述:报警数量前三
	 */
	@TableField(value="ALARM_NUM_TOP_THREE",exist=true)
	String alarmNumTopThree;

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


	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

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


	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime=updateTime;
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


	public String getTeamName(){
		return this.teamName;
	}

	public void setTeamName(String teamName){
		this.teamName=teamName;
	}


	public String getTeamType(){
		return this.teamType;
	}

	public void setTeamType(String teamType){
		this.teamType=teamType;
	}


	public String getTransitType(){
		return this.transitType;
	}

	public void setTransitType(String transitType){
		this.transitType=transitType;
	}


	public Integer getCountCarNum(){
		return this.countCarNum;
	}

	public void setCountCarNum(Integer countCarNum){
		this.countCarNum=countCarNum;
	}


	public java.math.BigDecimal getRunMileage(){
		return this.runMileage;
	}

	public void setRunMileage(java.math.BigDecimal runMileage){
		this.runMileage=runMileage;
	}


	public BigDecimal getRunTimeLength() {
		return runTimeLength;
	}

	public void setRunTimeLength(BigDecimal runTimeLength) {
		this.runTimeLength = runTimeLength;
	}

	public String getRunTimeLengthText(){
		return this.runTimeLengthText;
	}

	public void setRunTimeLengthText(String runTimeLengthText){
		this.runTimeLengthText=runTimeLengthText;
	}


	public java.math.BigDecimal getRunTimeLengthHour(){
		return this.runTimeLengthHour;
	}

	public void setRunTimeLengthHour(java.math.BigDecimal runTimeLengthHour){
		this.runTimeLengthHour=runTimeLengthHour;
	}


	public Integer getAlarmNum(){
		return this.alarmNum;
	}

	public void setAlarmNum(Integer alarmNum){
		this.alarmNum=alarmNum;
	}


	public java.math.BigDecimal getAlarmRate(){
		return this.alarmRate;
	}

	public void setAlarmRate(java.math.BigDecimal alarmRate){
		this.alarmRate=alarmRate;
	}


	public java.math.BigDecimal getSafeScore(){
		return this.safeScore;
	}

	public void setSafeScore(java.math.BigDecimal safeScore){
		this.safeScore=safeScore;
	}


	public java.math.BigDecimal getAverageSpeed(){
		return this.averageSpeed;
	}

	public void setAverageSpeed(java.math.BigDecimal averageSpeed){
		this.averageSpeed=averageSpeed;
	}


	public java.math.BigDecimal getAverageRunMileage(){
		return this.averageRunMileage;
	}

	public void setAverageRunMileage(java.math.BigDecimal averageRunMileage){
		this.averageRunMileage=averageRunMileage;
	}


	public java.math.BigDecimal getAverageRunTimeLength(){
		return this.averageRunTimeLength;
	}

	public void setAverageRunTimeLength(java.math.BigDecimal averageRunTimeLength){
		this.averageRunTimeLength=averageRunTimeLength;
	}


	public java.math.BigDecimal getAverageAlarmNum(){
		return this.averageAlarmNum;
	}

	public void setAverageAlarmNum(java.math.BigDecimal averageAlarmNum){
		this.averageAlarmNum=averageAlarmNum;
	}


	public String getRunMileageTopThree(){
		return this.runMileageTopThree;
	}

	public void setRunMileageTopThree(String runMileageTopThree){
		this.runMileageTopThree=runMileageTopThree;
	}


	public String getAlarmNumTopThree(){
		return this.alarmNumTopThree;
	}

	public void setAlarmNumTopThree(String alarmNumTopThree){
		this.alarmNumTopThree=alarmNumTopThree;
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
			sb.append(", updateTime=").append(updateTime);			
			sb.append(", provinceId=").append(provinceId);			
			sb.append(", provinceName=").append(provinceName);			
			sb.append(", cityId=").append(cityId);			
			sb.append(", cityName=").append(cityName);			
			sb.append(", xianquId=").append(xianquId);			
			sb.append(", xianquName=").append(xianquName);			
			sb.append(", teamName=").append(teamName);			
			sb.append(", teamType=").append(teamType);			
			sb.append(", transitType=").append(transitType);			
			sb.append(", countCarNum=").append(countCarNum);			
			sb.append(", runMileage=").append(runMileage);			
			sb.append(", runTimeLength=").append(runTimeLength);			
			sb.append(", runTimeLengthText=").append(runTimeLengthText);			
			sb.append(", runTimeLengthHour=").append(runTimeLengthHour);			
			sb.append(", alarmNum=").append(alarmNum);			
			sb.append(", alarmRate=").append(alarmRate);			
			sb.append(", safeScore=").append(safeScore);			
			sb.append(", averageSpeed=").append(averageSpeed);			
			sb.append(", averageRunMileage=").append(averageRunMileage);			
			sb.append(", averageRunTimeLength=").append(averageRunTimeLength);			
			sb.append(", averageAlarmNum=").append(averageAlarmNum);			
			sb.append(", runMileageTopThree=").append(runMileageTopThree);			
			sb.append(", alarmNumTopThree=").append(alarmNumTopThree);			
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
        BigdataFenxiTeamDay other = (BigdataFenxiTeamDay) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getProvinceId() == null ? other.getId() == null : this.getProvinceId().equals(other.getProvinceId()))		
				        		&&(this.getProvinceName() == null ? other.getId() == null : this.getProvinceName().equals(other.getProvinceName()))		
				        		&&(this.getCityId() == null ? other.getId() == null : this.getCityId().equals(other.getCityId()))		
				        		&&(this.getCityName() == null ? other.getId() == null : this.getCityName().equals(other.getCityName()))		
				        		&&(this.getXianquId() == null ? other.getId() == null : this.getXianquId().equals(other.getXianquId()))		
				        		&&(this.getXianquName() == null ? other.getId() == null : this.getXianquName().equals(other.getXianquName()))		
				        		&&(this.getTeamName() == null ? other.getId() == null : this.getTeamName().equals(other.getTeamName()))		
				        		&&(this.getTeamType() == null ? other.getId() == null : this.getTeamType().equals(other.getTeamType()))		
				        		&&(this.getTransitType() == null ? other.getId() == null : this.getTransitType().equals(other.getTransitType()))		
				        		&&(this.getCountCarNum() == null ? other.getId() == null : this.getCountCarNum().equals(other.getCountCarNum()))		
				        		&&(this.getRunMileage() == null ? other.getId() == null : this.getRunMileage().equals(other.getRunMileage()))		
				        		&&(this.getRunTimeLength() == null ? other.getId() == null : this.getRunTimeLength().equals(other.getRunTimeLength()))		
				        		&&(this.getRunTimeLengthText() == null ? other.getId() == null : this.getRunTimeLengthText().equals(other.getRunTimeLengthText()))		
				        		&&(this.getRunTimeLengthHour() == null ? other.getId() == null : this.getRunTimeLengthHour().equals(other.getRunTimeLengthHour()))		
				        		&&(this.getAlarmNum() == null ? other.getId() == null : this.getAlarmNum().equals(other.getAlarmNum()))		
				        		&&(this.getAlarmRate() == null ? other.getId() == null : this.getAlarmRate().equals(other.getAlarmRate()))		
				        		&&(this.getSafeScore() == null ? other.getId() == null : this.getSafeScore().equals(other.getSafeScore()))		
				        		&&(this.getAverageSpeed() == null ? other.getId() == null : this.getAverageSpeed().equals(other.getAverageSpeed()))		
				        		&&(this.getAverageRunMileage() == null ? other.getId() == null : this.getAverageRunMileage().equals(other.getAverageRunMileage()))		
				        		&&(this.getAverageRunTimeLength() == null ? other.getId() == null : this.getAverageRunTimeLength().equals(other.getAverageRunTimeLength()))		
				        		&&(this.getAverageAlarmNum() == null ? other.getId() == null : this.getAverageAlarmNum().equals(other.getAverageAlarmNum()))		
				        		&&(this.getRunMileageTopThree() == null ? other.getId() == null : this.getRunMileageTopThree().equals(other.getRunMileageTopThree()))		
				        		&&(this.getAlarmNumTopThree() == null ? other.getId() == null : this.getAlarmNumTopThree().equals(other.getAlarmNumTopThree()))		
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
		        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());		
		        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());		
		        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());		
		        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());		
		        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());		
		        result = prime * result + ((getXianquId() == null) ? 0 : getXianquId().hashCode());		
		        result = prime * result + ((getXianquName() == null) ? 0 : getXianquName().hashCode());		
		        result = prime * result + ((getTeamName() == null) ? 0 : getTeamName().hashCode());		
		        result = prime * result + ((getTeamType() == null) ? 0 : getTeamType().hashCode());		
		        result = prime * result + ((getTransitType() == null) ? 0 : getTransitType().hashCode());		
		        result = prime * result + ((getCountCarNum() == null) ? 0 : getCountCarNum().hashCode());		
		        result = prime * result + ((getRunMileage() == null) ? 0 : getRunMileage().hashCode());		
		        result = prime * result + ((getRunTimeLength() == null) ? 0 : getRunTimeLength().hashCode());		
		        result = prime * result + ((getRunTimeLengthText() == null) ? 0 : getRunTimeLengthText().hashCode());		
		        result = prime * result + ((getRunTimeLengthHour() == null) ? 0 : getRunTimeLengthHour().hashCode());		
		        result = prime * result + ((getAlarmNum() == null) ? 0 : getAlarmNum().hashCode());		
		        result = prime * result + ((getAlarmRate() == null) ? 0 : getAlarmRate().hashCode());		
		        result = prime * result + ((getSafeScore() == null) ? 0 : getSafeScore().hashCode());		
		        result = prime * result + ((getAverageSpeed() == null) ? 0 : getAverageSpeed().hashCode());		
		        result = prime * result + ((getAverageRunMileage() == null) ? 0 : getAverageRunMileage().hashCode());		
		        result = prime * result + ((getAverageRunTimeLength() == null) ? 0 : getAverageRunTimeLength().hashCode());		
		        result = prime * result + ((getAverageAlarmNum() == null) ? 0 : getAverageAlarmNum().hashCode());		
		        result = prime * result + ((getRunMileageTopThree() == null) ? 0 : getRunMileageTopThree().hashCode());		
		        result = prime * result + ((getAlarmNumTopThree() == null) ? 0 : getAlarmNumTopThree().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
