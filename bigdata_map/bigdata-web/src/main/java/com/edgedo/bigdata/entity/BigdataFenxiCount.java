package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_fenxi_count")
public class BigdataFenxiCount implements Serializable{
	
		
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
	 * 属性描述:更新时间
	 */
	@TableField(value="UPDATE_TIME",exist=true)
	java.util.Date updateTime;
	
	/**
	 * 属性描述:报警车辆数
	 */
	@TableField(value="ALARM_CAR_NUM",exist=true)
	java.lang.Integer alarmCarNum;
	
	/**
	 * 属性描述:报警从业人员数
	 */
	@TableField(value="ALARM_EMP_NUM",exist=true)
	java.lang.Integer alarmEmpNum;
	
	/**
	 * 属性描述:报警企业数
	 */
	@TableField(value="ALARM_COMP_NUM",exist=true)
	java.lang.Integer alarmCompNum;
	
	/**
	 * 属性描述:行驶里程
	 */
	@TableField(value="RUN_MILEAGE",exist=true)
	java.math.BigDecimal runMileage;
	
	/**
	 * 属性描述:行驶时长(小时）
	 */
	@TableField(value="RUN_TIME_LENGTH_HOUR",exist=true)
	java.math.BigDecimal runTimeLengthHour;
	
	/**
	 * 属性描述:常规报警数量
	 */
	@TableField(value="COMMON_ALARM_NUM",exist=true)
	java.lang.Integer commonAlarmNum;
	
	/**
	 * 属性描述:常规处理数量
	 */
	@TableField(value="COMMON_HANDLE_NUM",exist=true)
	java.lang.Integer commonHandleNum;
	
	/**
	 * 属性描述:主动安全报警数量
	 */
	@TableField(value="SAFE_ALARM_NUM",exist=true)
	java.lang.Integer safeAlarmNum;
	
	/**
	 * 属性描述:主动安全处理数量
	 */
	@TableField(value="SAFE_HANDLE_NUM",exist=true)
	java.lang.Integer safeHandleNum;
	
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
	 * 属性描述:区域统计类型
	 */
	@TableField(value="COUNT_TYPE",exist=true)
	java.lang.String countType;
	
	/**
	 * 属性描述:时间统计类型
	 */
	@TableField(value="TIME_TYPE",exist=true)
	java.lang.String timeType;
	
	/**
	 * 属性描述:第几周
	 */
	@TableField(value="COUNT_WEEK",exist=true)
	java.lang.Integer countWeek;
	
	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	java.lang.String carType;
	
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
	
	
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime=updateTime;
	}
	
	
	public java.lang.Integer getAlarmCarNum(){
		return this.alarmCarNum;
	}
	
	public void setAlarmCarNum(java.lang.Integer alarmCarNum){
		this.alarmCarNum=alarmCarNum;
	}
	
	
	public java.lang.Integer getAlarmEmpNum(){
		return this.alarmEmpNum;
	}
	
	public void setAlarmEmpNum(java.lang.Integer alarmEmpNum){
		this.alarmEmpNum=alarmEmpNum;
	}
	
	
	public java.lang.Integer getAlarmCompNum(){
		return this.alarmCompNum;
	}
	
	public void setAlarmCompNum(java.lang.Integer alarmCompNum){
		this.alarmCompNum=alarmCompNum;
	}
	
	
	public java.math.BigDecimal getRunMileage(){
		return this.runMileage;
	}
	
	public void setRunMileage(java.math.BigDecimal runMileage){
		this.runMileage=runMileage;
	}
	
	
	public java.math.BigDecimal getRunTimeLengthHour(){
		return this.runTimeLengthHour;
	}
	
	public void setRunTimeLengthHour(java.math.BigDecimal runTimeLengthHour){
		this.runTimeLengthHour=runTimeLengthHour;
	}
	
	
	public java.lang.Integer getCommonAlarmNum(){
		return this.commonAlarmNum;
	}
	
	public void setCommonAlarmNum(java.lang.Integer commonAlarmNum){
		this.commonAlarmNum=commonAlarmNum;
	}
	
	
	public java.lang.Integer getCommonHandleNum(){
		return this.commonHandleNum;
	}
	
	public void setCommonHandleNum(java.lang.Integer commonHandleNum){
		this.commonHandleNum=commonHandleNum;
	}
	
	
	public java.lang.Integer getSafeAlarmNum(){
		return this.safeAlarmNum;
	}
	
	public void setSafeAlarmNum(java.lang.Integer safeAlarmNum){
		this.safeAlarmNum=safeAlarmNum;
	}
	
	
	public java.lang.Integer getSafeHandleNum(){
		return this.safeHandleNum;
	}
	
	public void setSafeHandleNum(java.lang.Integer safeHandleNum){
		this.safeHandleNum=safeHandleNum;
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
	
	
	public java.lang.String getCountType(){
		return this.countType;
	}
	
	public void setCountType(java.lang.String countType){
		this.countType=countType;
	}
	
	
	public java.lang.String getTimeType(){
		return this.timeType;
	}
	
	public void setTimeType(java.lang.String timeType){
		this.timeType=timeType;
	}
	
	
	public java.lang.Integer getCountWeek(){
		return this.countWeek;
	}
	
	public void setCountWeek(java.lang.Integer countWeek){
		this.countWeek=countWeek;
	}
	
	
	public java.lang.String getCarType(){
		return this.carType;
	}
	
	public void setCarType(java.lang.String carType){
		this.carType=carType;
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
			sb.append(", updateTime=").append(updateTime);			
			sb.append(", alarmCarNum=").append(alarmCarNum);			
			sb.append(", alarmEmpNum=").append(alarmEmpNum);			
			sb.append(", alarmCompNum=").append(alarmCompNum);			
			sb.append(", runMileage=").append(runMileage);			
			sb.append(", runTimeLengthHour=").append(runTimeLengthHour);			
			sb.append(", commonAlarmNum=").append(commonAlarmNum);			
			sb.append(", commonHandleNum=").append(commonHandleNum);			
			sb.append(", safeAlarmNum=").append(safeAlarmNum);			
			sb.append(", safeHandleNum=").append(safeHandleNum);			
			sb.append(", provinceId=").append(provinceId);			
			sb.append(", provinceName=").append(provinceName);			
			sb.append(", cityId=").append(cityId);			
			sb.append(", cityName=").append(cityName);			
			sb.append(", xianquId=").append(xianquId);			
			sb.append(", xianquName=").append(xianquName);			
			sb.append(", countType=").append(countType);			
			sb.append(", timeType=").append(timeType);			
			sb.append(", countWeek=").append(countWeek);			
			sb.append(", carType=").append(carType);			
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
        BigdataFenxiCount other = (BigdataFenxiCount) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getAlarmCarNum() == null ? other.getId() == null : this.getAlarmCarNum().equals(other.getAlarmCarNum()))		
				        		&&(this.getAlarmEmpNum() == null ? other.getId() == null : this.getAlarmEmpNum().equals(other.getAlarmEmpNum()))		
				        		&&(this.getAlarmCompNum() == null ? other.getId() == null : this.getAlarmCompNum().equals(other.getAlarmCompNum()))		
				        		&&(this.getRunMileage() == null ? other.getId() == null : this.getRunMileage().equals(other.getRunMileage()))		
				        		&&(this.getRunTimeLengthHour() == null ? other.getId() == null : this.getRunTimeLengthHour().equals(other.getRunTimeLengthHour()))		
				        		&&(this.getCommonAlarmNum() == null ? other.getId() == null : this.getCommonAlarmNum().equals(other.getCommonAlarmNum()))		
				        		&&(this.getCommonHandleNum() == null ? other.getId() == null : this.getCommonHandleNum().equals(other.getCommonHandleNum()))		
				        		&&(this.getSafeAlarmNum() == null ? other.getId() == null : this.getSafeAlarmNum().equals(other.getSafeAlarmNum()))		
				        		&&(this.getSafeHandleNum() == null ? other.getId() == null : this.getSafeHandleNum().equals(other.getSafeHandleNum()))		
				        		&&(this.getProvinceId() == null ? other.getId() == null : this.getProvinceId().equals(other.getProvinceId()))		
				        		&&(this.getProvinceName() == null ? other.getId() == null : this.getProvinceName().equals(other.getProvinceName()))		
				        		&&(this.getCityId() == null ? other.getId() == null : this.getCityId().equals(other.getCityId()))		
				        		&&(this.getCityName() == null ? other.getId() == null : this.getCityName().equals(other.getCityName()))		
				        		&&(this.getXianquId() == null ? other.getId() == null : this.getXianquId().equals(other.getXianquId()))		
				        		&&(this.getXianquName() == null ? other.getId() == null : this.getXianquName().equals(other.getXianquName()))		
				        		&&(this.getCountType() == null ? other.getId() == null : this.getCountType().equals(other.getCountType()))		
				        		&&(this.getTimeType() == null ? other.getId() == null : this.getTimeType().equals(other.getTimeType()))		
				        		&&(this.getCountWeek() == null ? other.getId() == null : this.getCountWeek().equals(other.getCountWeek()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
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
		        result = prime * result + ((getAlarmCarNum() == null) ? 0 : getAlarmCarNum().hashCode());		
		        result = prime * result + ((getAlarmEmpNum() == null) ? 0 : getAlarmEmpNum().hashCode());		
		        result = prime * result + ((getAlarmCompNum() == null) ? 0 : getAlarmCompNum().hashCode());		
		        result = prime * result + ((getRunMileage() == null) ? 0 : getRunMileage().hashCode());		
		        result = prime * result + ((getRunTimeLengthHour() == null) ? 0 : getRunTimeLengthHour().hashCode());		
		        result = prime * result + ((getCommonAlarmNum() == null) ? 0 : getCommonAlarmNum().hashCode());		
		        result = prime * result + ((getCommonHandleNum() == null) ? 0 : getCommonHandleNum().hashCode());		
		        result = prime * result + ((getSafeAlarmNum() == null) ? 0 : getSafeAlarmNum().hashCode());		
		        result = prime * result + ((getSafeHandleNum() == null) ? 0 : getSafeHandleNum().hashCode());		
		        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());		
		        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());		
		        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());		
		        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());		
		        result = prime * result + ((getXianquId() == null) ? 0 : getXianquId().hashCode());		
		        result = prime * result + ((getXianquName() == null) ? 0 : getXianquName().hashCode());		
		        result = prime * result + ((getCountType() == null) ? 0 : getCountType().hashCode());		
		        result = prime * result + ((getTimeType() == null) ? 0 : getTimeType().hashCode());		
		        result = prime * result + ((getCountWeek() == null) ? 0 : getCountWeek().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
