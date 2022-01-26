package com.edgedo.drawing.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_driver_stop_count")
public class BigdataDriverStopCount implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:所属车辆
	 */
	@TableField(value="CAR_REAL_ID",exist=true)
	java.lang.String carRealId;
	
	/**
	 * 属性描述:驾驶员ID
	 */
	@TableField(value="DRIVER_ID",exist=true)
	java.lang.String driverId;
	
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
	 * 属性描述:位置国家
	 */
	@TableField(value="MAP_COUNTRY",exist=true)
	java.lang.String mapCountry;
	
	/**
	 * 属性描述:位置省份
	 */
	@TableField(value="MAP_PROVINCE",exist=true)
	java.lang.String mapProvince;
	
	/**
	 * 属性描述:省份id
	 */
	@TableField(value="MAP_PROVINCE_ID",exist=true)
	java.lang.String mapProvinceId;
	
	/**
	 * 属性描述:位置城市
	 */
	@TableField(value="MAP_CITY",exist=true)
	java.lang.String mapCity;
	
	/**
	 * 属性描述:城市id
	 */
	@TableField(value="MAP_CITY_ID",exist=true)
	java.lang.String mapCityId;
	
	/**
	 * 属性描述:停靠次数
	 */
	@TableField(value="STOP_NUM",exist=true)
	java.lang.Integer stopNum;
	
	/**
	 * 属性描述:统计类型
	 */
	@TableField(value="COUNT_TYPE",exist=true)
	java.lang.String countType;
	
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
	
	
	public java.lang.String getCarRealId(){
		return this.carRealId;
	}
	
	public void setCarRealId(java.lang.String carRealId){
		this.carRealId=carRealId;
	}
	
	
	public java.lang.String getDriverId(){
		return this.driverId;
	}
	
	public void setDriverId(java.lang.String driverId){
		this.driverId=driverId;
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
	
	
	public java.lang.String getMapCountry(){
		return this.mapCountry;
	}
	
	public void setMapCountry(java.lang.String mapCountry){
		this.mapCountry=mapCountry;
	}
	
	
	public java.lang.String getMapProvince(){
		return this.mapProvince;
	}
	
	public void setMapProvince(java.lang.String mapProvince){
		this.mapProvince=mapProvince;
	}
	
	
	public java.lang.String getMapProvinceId(){
		return this.mapProvinceId;
	}
	
	public void setMapProvinceId(java.lang.String mapProvinceId){
		this.mapProvinceId=mapProvinceId;
	}
	
	
	public java.lang.String getMapCity(){
		return this.mapCity;
	}
	
	public void setMapCity(java.lang.String mapCity){
		this.mapCity=mapCity;
	}
	
	
	public java.lang.String getMapCityId(){
		return this.mapCityId;
	}
	
	public void setMapCityId(java.lang.String mapCityId){
		this.mapCityId=mapCityId;
	}
	
	
	public java.lang.Integer getStopNum(){
		return this.stopNum;
	}
	
	public void setStopNum(java.lang.Integer stopNum){
		this.stopNum=stopNum;
	}
	
	
	public java.lang.String getCountType(){
		return this.countType;
	}
	
	public void setCountType(java.lang.String countType){
		this.countType=countType;
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
			sb.append(", carRealId=").append(carRealId);			
			sb.append(", driverId=").append(driverId);			
			sb.append(", driverName=").append(driverName);			
			sb.append(", driverSex=").append(driverSex);			
			sb.append(", driverAge=").append(driverAge);			
			sb.append(", driverPhone=").append(driverPhone);			
			sb.append(", driverIdCard=").append(driverIdCard);			
			sb.append(", driverCode=").append(driverCode);			
			sb.append(", mapCountry=").append(mapCountry);			
			sb.append(", mapProvince=").append(mapProvince);			
			sb.append(", mapProvinceId=").append(mapProvinceId);			
			sb.append(", mapCity=").append(mapCity);			
			sb.append(", mapCityId=").append(mapCityId);			
			sb.append(", stopNum=").append(stopNum);			
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
        BigdataDriverStopCount other = (BigdataDriverStopCount) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCarRealId() == null ? other.getId() == null : this.getCarRealId().equals(other.getCarRealId()))		
				        		&&(this.getDriverId() == null ? other.getId() == null : this.getDriverId().equals(other.getDriverId()))		
				        		&&(this.getDriverName() == null ? other.getId() == null : this.getDriverName().equals(other.getDriverName()))		
				        		&&(this.getDriverSex() == null ? other.getId() == null : this.getDriverSex().equals(other.getDriverSex()))		
				        		&&(this.getDriverAge() == null ? other.getId() == null : this.getDriverAge().equals(other.getDriverAge()))		
				        		&&(this.getDriverPhone() == null ? other.getId() == null : this.getDriverPhone().equals(other.getDriverPhone()))		
				        		&&(this.getDriverIdCard() == null ? other.getId() == null : this.getDriverIdCard().equals(other.getDriverIdCard()))		
				        		&&(this.getDriverCode() == null ? other.getId() == null : this.getDriverCode().equals(other.getDriverCode()))		
				        		&&(this.getMapCountry() == null ? other.getId() == null : this.getMapCountry().equals(other.getMapCountry()))		
				        		&&(this.getMapProvince() == null ? other.getId() == null : this.getMapProvince().equals(other.getMapProvince()))		
				        		&&(this.getMapProvinceId() == null ? other.getId() == null : this.getMapProvinceId().equals(other.getMapProvinceId()))		
				        		&&(this.getMapCity() == null ? other.getId() == null : this.getMapCity().equals(other.getMapCity()))		
				        		&&(this.getMapCityId() == null ? other.getId() == null : this.getMapCityId().equals(other.getMapCityId()))		
				        		&&(this.getStopNum() == null ? other.getId() == null : this.getStopNum().equals(other.getStopNum()))		
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
		        result = prime * result + ((getCarRealId() == null) ? 0 : getCarRealId().hashCode());		
		        result = prime * result + ((getDriverId() == null) ? 0 : getDriverId().hashCode());		
		        result = prime * result + ((getDriverName() == null) ? 0 : getDriverName().hashCode());		
		        result = prime * result + ((getDriverSex() == null) ? 0 : getDriverSex().hashCode());		
		        result = prime * result + ((getDriverAge() == null) ? 0 : getDriverAge().hashCode());		
		        result = prime * result + ((getDriverPhone() == null) ? 0 : getDriverPhone().hashCode());		
		        result = prime * result + ((getDriverIdCard() == null) ? 0 : getDriverIdCard().hashCode());		
		        result = prime * result + ((getDriverCode() == null) ? 0 : getDriverCode().hashCode());		
		        result = prime * result + ((getMapCountry() == null) ? 0 : getMapCountry().hashCode());		
		        result = prime * result + ((getMapProvince() == null) ? 0 : getMapProvince().hashCode());		
		        result = prime * result + ((getMapProvinceId() == null) ? 0 : getMapProvinceId().hashCode());		
		        result = prime * result + ((getMapCity() == null) ? 0 : getMapCity().hashCode());		
		        result = prime * result + ((getMapCityId() == null) ? 0 : getMapCityId().hashCode());		
		        result = prime * result + ((getStopNum() == null) ? 0 : getStopNum().hashCode());		
		        result = prime * result + ((getCountType() == null) ? 0 : getCountType().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
