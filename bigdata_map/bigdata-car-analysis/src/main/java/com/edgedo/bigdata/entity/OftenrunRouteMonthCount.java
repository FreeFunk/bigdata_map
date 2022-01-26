package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("oftenrun_route_month_count")
public class OftenrunRouteMonthCount implements Serializable{
	
		
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
	 * 属性描述:出发省ID
	 */
	@TableField(value="START_PROVINCE_ID",exist=true)
	String startProvinceId;

	/**
	 * 属性描述:出发省名
	 */
	@TableField(value="START_PROVINCE_NAME",exist=true)
	String startProvinceName;

	/**
	 * 属性描述:目的省ID
	 */
	@TableField(value="END_PROVINCE_ID",exist=true)
	String endProvinceId;

	/**
	 * 属性描述:目的省名
	 */
	@TableField(value="END_PROVINCE_NAME",exist=true)
	String endProvinceName;

	/**
	 * 属性描述:出发城市ID
	 */
	@TableField(value="START_CITY_ID",exist=true)
	String startCityId;

	/**
	 * 属性描述:出发城市名
	 */
	@TableField(value="START_CITY_NAME",exist=true)
	String startCityName;

	/**
	 * 属性描述:目的城市ID
	 */
	@TableField(value="END_CITY_ID",exist=true)
	String endCityId;

	/**
	 * 属性描述:目的城市名
	 */
	@TableField(value="END_CITY_NAME",exist=true)
	String endCityName;

	/**
	 * 属性描述:路线
	 */
	@TableField(value="RUN_ROUTE",exist=true)
	String runRoute;

	/**
	 * 属性描述:次数
	 */
	@TableField(value="RUN_NUM",exist=true)
	Integer runNum;

	/**
	 * 属性描述:总里程
	 */
	@TableField(value="SUM_MILEAGE",exist=true)
	java.math.BigDecimal sumMileage;

	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	String carType;

	/**
	 * 属性描述:统计类型
	 */
	@TableField(value="COUNT_TYPE",exist=true)
	String countType;


	/**
	 * 属性描述:统计时间
	 */
	@TableField(value="COUNT_TIME",exist=true)
	java.util.Date countTime;

    /**
     * 月份字符串
	 */
	@TableField(value="MONTH_STR",exist=true)
	String monthStr;
	/**
	 * 月份的数字
	 */
	@TableField(value="COUNT_MONTH",exist=true)
	Integer countMonth;
	/**
	 * 季度类型数字
	 */
	@TableField(value="QUARTER_TYPE",exist=true)
	Integer quarterType;
	/**
	 * 统计年份
	 */
	@TableField(value="YEAR_NUM",exist=true)
	Integer yearNum;

	public Integer getCountMonth() {
		return countMonth;
	}

	public void setCountMonth(Integer countMonth) {
		this.countMonth = countMonth;
	}

	public Integer getYearNum() {
		return yearNum;
	}

	public void setYearNum(Integer yearNum) {
		this.yearNum = yearNum;
	}

	public Integer getQuarterType() {
		return quarterType;
	}

	public void setQuarterType(Integer quarterType) {
		this.quarterType = quarterType;
	}

	public String getMonthStr() {
		return monthStr;
	}

	public void setMonthStr(String monthStr) {
		this.monthStr = monthStr;
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


	public String getStartProvinceId(){
		return this.startProvinceId;
	}

	public void setStartProvinceId(String startProvinceId){
		this.startProvinceId=startProvinceId;
	}


	public String getStartProvinceName(){
		return this.startProvinceName;
	}

	public void setStartProvinceName(String startProvinceName){
		this.startProvinceName=startProvinceName;
	}


	public String getEndProvinceId(){
		return this.endProvinceId;
	}

	public void setEndProvinceId(String endProvinceId){
		this.endProvinceId=endProvinceId;
	}


	public String getEndProvinceName(){
		return this.endProvinceName;
	}

	public void setEndProvinceName(String endProvinceName){
		this.endProvinceName=endProvinceName;
	}


	public String getStartCityId(){
		return this.startCityId;
	}

	public void setStartCityId(String startCityId){
		this.startCityId=startCityId;
	}


	public String getStartCityName(){
		return this.startCityName;
	}

	public void setStartCityName(String startCityName){
		this.startCityName=startCityName;
	}


	public String getEndCityId(){
		return this.endCityId;
	}

	public void setEndCityId(String endCityId){
		this.endCityId=endCityId;
	}


	public String getEndCityName(){
		return this.endCityName;
	}

	public void setEndCityName(String endCityName){
		this.endCityName=endCityName;
	}


	public String getRunRoute(){
		return this.runRoute;
	}

	public void setRunRoute(String runRoute){
		this.runRoute=runRoute;
	}


	public Integer getRunNum(){
		return this.runNum;
	}

	public void setRunNum(Integer runNum){
		this.runNum=runNum;
	}


	public java.math.BigDecimal getSumMileage(){
		return this.sumMileage;
	}

	public void setSumMileage(java.math.BigDecimal sumMileage){
		this.sumMileage=sumMileage;
	}


	public String getCarType(){
		return this.carType;
	}

	public void setCarType(String carType){
		this.carType=carType;
	}


	public String getCountType(){
		return this.countType;
	}

	public void setCountType(String countType){
		this.countType=countType;
	}
	
	
	public java.util.Date getCountTime(){
		return this.countTime;
	}
	
	public void setCountTime(java.util.Date countTime){
		this.countTime=countTime;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", startProvinceId=").append(startProvinceId);			
			sb.append(", startProvinceName=").append(startProvinceName);			
			sb.append(", endProvinceId=").append(endProvinceId);			
			sb.append(", endProvinceName=").append(endProvinceName);			
			sb.append(", startCityId=").append(startCityId);			
			sb.append(", startCityName=").append(startCityName);			
			sb.append(", endCityId=").append(endCityId);			
			sb.append(", endCityName=").append(endCityName);			
			sb.append(", runRoute=").append(runRoute);			
			sb.append(", runNum=").append(runNum);			
			sb.append(", sumMileage=").append(sumMileage);			
			sb.append(", carType=").append(carType);			
			sb.append(", countType=").append(countType);			
			sb.append(", countTime=").append(countTime);			
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
        OftenrunRouteMonthCount other = (OftenrunRouteMonthCount) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getStartProvinceId() == null ? other.getId() == null : this.getStartProvinceId().equals(other.getStartProvinceId()))		
				        		&&(this.getStartProvinceName() == null ? other.getId() == null : this.getStartProvinceName().equals(other.getStartProvinceName()))		
				        		&&(this.getEndProvinceId() == null ? other.getId() == null : this.getEndProvinceId().equals(other.getEndProvinceId()))		
				        		&&(this.getEndProvinceName() == null ? other.getId() == null : this.getEndProvinceName().equals(other.getEndProvinceName()))		
				        		&&(this.getStartCityId() == null ? other.getId() == null : this.getStartCityId().equals(other.getStartCityId()))		
				        		&&(this.getStartCityName() == null ? other.getId() == null : this.getStartCityName().equals(other.getStartCityName()))		
				        		&&(this.getEndCityId() == null ? other.getId() == null : this.getEndCityId().equals(other.getEndCityId()))		
				        		&&(this.getEndCityName() == null ? other.getId() == null : this.getEndCityName().equals(other.getEndCityName()))		
				        		&&(this.getRunRoute() == null ? other.getId() == null : this.getRunRoute().equals(other.getRunRoute()))		
				        		&&(this.getRunNum() == null ? other.getId() == null : this.getRunNum().equals(other.getRunNum()))		
				        		&&(this.getSumMileage() == null ? other.getId() == null : this.getSumMileage().equals(other.getSumMileage()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getCountType() == null ? other.getId() == null : this.getCountType().equals(other.getCountType()))		
				        		&&(this.getCountTime() == null ? other.getId() == null : this.getCountTime().equals(other.getCountTime()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getStartProvinceId() == null) ? 0 : getStartProvinceId().hashCode());		
		        result = prime * result + ((getStartProvinceName() == null) ? 0 : getStartProvinceName().hashCode());		
		        result = prime * result + ((getEndProvinceId() == null) ? 0 : getEndProvinceId().hashCode());		
		        result = prime * result + ((getEndProvinceName() == null) ? 0 : getEndProvinceName().hashCode());		
		        result = prime * result + ((getStartCityId() == null) ? 0 : getStartCityId().hashCode());		
		        result = prime * result + ((getStartCityName() == null) ? 0 : getStartCityName().hashCode());		
		        result = prime * result + ((getEndCityId() == null) ? 0 : getEndCityId().hashCode());		
		        result = prime * result + ((getEndCityName() == null) ? 0 : getEndCityName().hashCode());		
		        result = prime * result + ((getRunRoute() == null) ? 0 : getRunRoute().hashCode());		
		        result = prime * result + ((getRunNum() == null) ? 0 : getRunNum().hashCode());		
		        result = prime * result + ((getSumMileage() == null) ? 0 : getSumMileage().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCountType() == null) ? 0 : getCountType().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		;
        return result;
    }

}
