package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("bigdata_car_day_oftenrun_route")
public class BigdataCarDayOftenrunRoute implements Serializable{
	
		
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
	 * 属性描述:车牌号
	 */
	@TableField(value="CAR_PLATE_NUM",exist=true)
	String carPlateNum;

	/**
	 * 属性描述:车架号
	 */
	@TableField(value="CAR_FRAME_NUM",exist=true)
	String carFrameNum;

	/**
	 * 属性描述:车牌颜色
	 */
	@TableField(value="CAR_PLATE_COLOR",exist=true)
	String carPlateColor;

	/**
	 * 属性描述:关联车辆id
	 */
	@TableField(value="CAR_REAL_ID",exist=true)
	String carRealId;

	/**
	 * 属性描述:所属企业ID
	 */
	@TableField(value="OWNER_TEAM_ID",exist=true)
	String ownerTeamId;

	/**
	 * 属性描述:所属企业名
	 */
	@TableField(value="OWNER_TEAM_NAME",exist=true)
	String ownerTeamName;

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
	 * 属性描述:开始时间
	 */
	@TableField(value="START_TIME",exist=true)
	java.util.Date startTime;

	/**
	 * 属性描述:结束时间
	 */
	@TableField(value="END_TIME",exist=true)
	java.util.Date endTime;

	/**
	 * 属性描述:路线
	 */
	@TableField(value="RUN_ROUTE",exist=true)
	String runRoute;

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
	 * 属性描述:统计时间
	 */
	@TableField(value="COUNT_TIME",exist=true)
	java.util.Date countTime;

	/**
	 * 属性描述:是否跨省
	 */
	@TableField(value="IS_TRANS_PROVINCIAL",exist=true)
	String isTransProvincial;

	/**
	 * 属性描述:当日线路次数
	 */
	@TableField(value="RUN_LINE_NUM",exist=true)
	Integer runLineNum;

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

	public Integer getCountDate() {
		return countDate;
	}

	public void setCountDate(Integer countDate) {
		this.countDate = countDate;
	}

	public Integer getCountMonth() {
		return countMonth;
	}

	public void setCountMonth(Integer countMonth) {
		this.countMonth = countMonth;
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


	public String getCarPlateNum(){
		return this.carPlateNum;
	}

	public void setCarPlateNum(String carPlateNum){
		this.carPlateNum=carPlateNum;
	}


	public String getCarFrameNum(){
		return this.carFrameNum;
	}

	public void setCarFrameNum(String carFrameNum){
		this.carFrameNum=carFrameNum;
	}


	public String getCarPlateColor(){
		return this.carPlateColor;
	}

	public void setCarPlateColor(String carPlateColor){
		this.carPlateColor=carPlateColor;
	}


	public String getCarRealId(){
		return this.carRealId;
	}

	public void setCarRealId(String carRealId){
		this.carRealId=carRealId;
	}


	public String getOwnerTeamId(){
		return this.ownerTeamId;
	}

	public void setOwnerTeamId(String ownerTeamId){
		this.ownerTeamId=ownerTeamId;
	}


	public String getOwnerTeamName(){
		return this.ownerTeamName;
	}

	public void setOwnerTeamName(String ownerTeamName){
		this.ownerTeamName=ownerTeamName;
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


	public java.util.Date getStartTime(){
		return this.startTime;
	}

	public void setStartTime(java.util.Date startTime){
		this.startTime=startTime;
	}


	public java.util.Date getEndTime(){
		return this.endTime;
	}

	public void setEndTime(java.util.Date endTime){
		this.endTime=endTime;
	}


	public String getRunRoute(){
		return this.runRoute;
	}

	public void setRunRoute(String runRoute){
		this.runRoute=runRoute;
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


	public java.util.Date getCountTime(){
		return this.countTime;
	}

	public void setCountTime(java.util.Date countTime){
		this.countTime=countTime;
	}


	public String getIsTransProvincial(){
		return this.isTransProvincial;
	}

	public void setIsTransProvincial(String isTransProvincial){
		this.isTransProvincial=isTransProvincial;
	}


	public Integer getRunLineNum(){
		return this.runLineNum;
	}

	public void setRunLineNum(Integer runLineNum){
		this.runLineNum=runLineNum;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carFrameNum=").append(carFrameNum);			
			sb.append(", carPlateColor=").append(carPlateColor);			
			sb.append(", carRealId=").append(carRealId);			
			sb.append(", ownerTeamId=").append(ownerTeamId);			
			sb.append(", ownerTeamName=").append(ownerTeamName);			
			sb.append(", startProvinceId=").append(startProvinceId);			
			sb.append(", startProvinceName=").append(startProvinceName);			
			sb.append(", endProvinceId=").append(endProvinceId);			
			sb.append(", endProvinceName=").append(endProvinceName);			
			sb.append(", startCityId=").append(startCityId);			
			sb.append(", startCityName=").append(startCityName);			
			sb.append(", endCityId=").append(endCityId);			
			sb.append(", endCityName=").append(endCityName);			
			sb.append(", startTime=").append(startTime);			
			sb.append(", endTime=").append(endTime);			
			sb.append(", runRoute=").append(runRoute);			
			sb.append(", sumMileage=").append(sumMileage);			
			sb.append(", carType=").append(carType);			
			sb.append(", countTime=").append(countTime);			
			sb.append(", isTransProvincial=").append(isTransProvincial);			
			sb.append(", runLineNum=").append(runLineNum);			
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
        BigdataCarDayOftenrunRoute other = (BigdataCarDayOftenrunRoute) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarFrameNum() == null ? other.getId() == null : this.getCarFrameNum().equals(other.getCarFrameNum()))		
				        		&&(this.getCarPlateColor() == null ? other.getId() == null : this.getCarPlateColor().equals(other.getCarPlateColor()))		
				        		&&(this.getCarRealId() == null ? other.getId() == null : this.getCarRealId().equals(other.getCarRealId()))		
				        		&&(this.getOwnerTeamId() == null ? other.getId() == null : this.getOwnerTeamId().equals(other.getOwnerTeamId()))		
				        		&&(this.getOwnerTeamName() == null ? other.getId() == null : this.getOwnerTeamName().equals(other.getOwnerTeamName()))		
				        		&&(this.getStartProvinceId() == null ? other.getId() == null : this.getStartProvinceId().equals(other.getStartProvinceId()))		
				        		&&(this.getStartProvinceName() == null ? other.getId() == null : this.getStartProvinceName().equals(other.getStartProvinceName()))		
				        		&&(this.getEndProvinceId() == null ? other.getId() == null : this.getEndProvinceId().equals(other.getEndProvinceId()))		
				        		&&(this.getEndProvinceName() == null ? other.getId() == null : this.getEndProvinceName().equals(other.getEndProvinceName()))		
				        		&&(this.getStartCityId() == null ? other.getId() == null : this.getStartCityId().equals(other.getStartCityId()))		
				        		&&(this.getStartCityName() == null ? other.getId() == null : this.getStartCityName().equals(other.getStartCityName()))		
				        		&&(this.getEndCityId() == null ? other.getId() == null : this.getEndCityId().equals(other.getEndCityId()))		
				        		&&(this.getEndCityName() == null ? other.getId() == null : this.getEndCityName().equals(other.getEndCityName()))		
				        		&&(this.getStartTime() == null ? other.getId() == null : this.getStartTime().equals(other.getStartTime()))		
				        		&&(this.getEndTime() == null ? other.getId() == null : this.getEndTime().equals(other.getEndTime()))		
				        		&&(this.getRunRoute() == null ? other.getId() == null : this.getRunRoute().equals(other.getRunRoute()))		
				        		&&(this.getSumMileage() == null ? other.getId() == null : this.getSumMileage().equals(other.getSumMileage()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getCountTime() == null ? other.getId() == null : this.getCountTime().equals(other.getCountTime()))		
				        		&&(this.getIsTransProvincial() == null ? other.getId() == null : this.getIsTransProvincial().equals(other.getIsTransProvincial()))		
				        		&&(this.getRunLineNum() == null ? other.getId() == null : this.getRunLineNum().equals(other.getRunLineNum()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarFrameNum() == null) ? 0 : getCarFrameNum().hashCode());		
		        result = prime * result + ((getCarPlateColor() == null) ? 0 : getCarPlateColor().hashCode());		
		        result = prime * result + ((getCarRealId() == null) ? 0 : getCarRealId().hashCode());		
		        result = prime * result + ((getOwnerTeamId() == null) ? 0 : getOwnerTeamId().hashCode());		
		        result = prime * result + ((getOwnerTeamName() == null) ? 0 : getOwnerTeamName().hashCode());		
		        result = prime * result + ((getStartProvinceId() == null) ? 0 : getStartProvinceId().hashCode());		
		        result = prime * result + ((getStartProvinceName() == null) ? 0 : getStartProvinceName().hashCode());		
		        result = prime * result + ((getEndProvinceId() == null) ? 0 : getEndProvinceId().hashCode());		
		        result = prime * result + ((getEndProvinceName() == null) ? 0 : getEndProvinceName().hashCode());		
		        result = prime * result + ((getStartCityId() == null) ? 0 : getStartCityId().hashCode());		
		        result = prime * result + ((getStartCityName() == null) ? 0 : getStartCityName().hashCode());		
		        result = prime * result + ((getEndCityId() == null) ? 0 : getEndCityId().hashCode());		
		        result = prime * result + ((getEndCityName() == null) ? 0 : getEndCityName().hashCode());		
		        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());		
		        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());		
		        result = prime * result + ((getRunRoute() == null) ? 0 : getRunRoute().hashCode());		
		        result = prime * result + ((getSumMileage() == null) ? 0 : getSumMileage().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		        result = prime * result + ((getIsTransProvincial() == null) ? 0 : getIsTransProvincial().hashCode());		
		        result = prime * result + ((getRunLineNum() == null) ? 0 : getRunLineNum().hashCode());		
		;
        return result;
    }

}
