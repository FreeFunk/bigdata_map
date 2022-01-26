package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("city_transport_capacity_analysis")
public class CityTransportCapacityAnalysis implements Serializable{
	
		
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
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	java.lang.String carType;
	
	/**
	 * 属性描述:车辆总数
	 */
	@TableField(value="CAR_TOTAL_NUM",exist=true)
	java.lang.Integer carTotalNum;
	
	/**
	 * 属性描述:车辆上线数
	 */
	@TableField(value="ONLINE_NUM",exist=true)
	java.lang.Integer onlineNum;
	
	/**
	 * 属性描述:车辆上线率
	 */
	@TableField(value="ONLINE_RATE",exist=true)
	java.math.BigDecimal onlineRate;
	
	/**
	 * 属性描述:运营数
	 */
	@TableField(value="OPERATION_NUM",exist=true)
	java.lang.Integer operationNum;
	
	/**
	 * 属性描述:运营率
	 */
	@TableField(value="OPERATION_RATE",exist=true)
	java.math.BigDecimal operationRate;
	
	/**
	 * 属性描述:日总里程
	 */
	@TableField(value="DAY_TOTAL_MILEAGE",exist=true)
	java.math.BigDecimal dayTotalMileage;
	
	/**
	 * 属性描述:日总时长
	 */
	@TableField(value="DAY_TOTAL_TIME",exist=true)
	java.math.BigDecimal dayTotalTime;
	
	/**
	 * 属性描述:当前理论运营峰值
	 */
	@TableField(value="CURRENT_OPERATION_MAX",exist=true)
	java.math.BigDecimal currentOperationMax;
	
	/**
	 * 属性描述:更新时间
	 */
	@TableField(value="UPDATE_TIME",exist=true)
	java.util.Date updateTime;
	
	/**
	 * 属性描述:统计时间
	 */
	@TableField(value="COUNT_TIME",exist=true)
	java.util.Date countTime;
	
	/**
	 * 属性描述:上线率标识
	 */
	@TableField(value="ONLINE_RATE_FLAG",exist=true)
	java.lang.String onlineRateFlag;
	
	/**
	 * 属性描述:运营率标识
	 */
	@TableField(value="OPERATION_RATE_FLAG",exist=true)
	java.lang.String operationRateFlag;
	
	/**
	 * 属性描述:当前理论运营峰值标识
	 */
	@TableField(value="CURRENT_OPERATION_MAX_FLAG",exist=true)
	java.lang.String currentOperationMaxFlag;
	
	/**
	 * 属性描述:日总里程标识
	 */
	@TableField(value="DAY_TOTAL_MILEAGE_FLAG",exist=true)
	java.lang.String dayTotalMileageFlag;
	
	/**
	 * 属性描述:日总时长标识
	 */
	@TableField(value="DAY_TOTAL_TIME_FLAG",exist=true)
	java.lang.String dayTotalTimeFlag;
	
	
	
	
	
	
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
	
	
	public java.lang.String getCarType(){
		return this.carType;
	}
	
	public void setCarType(java.lang.String carType){
		this.carType=carType;
	}
	
	
	public java.lang.Integer getCarTotalNum(){
		return this.carTotalNum;
	}
	
	public void setCarTotalNum(java.lang.Integer carTotalNum){
		this.carTotalNum=carTotalNum;
	}
	
	
	public java.lang.Integer getOnlineNum(){
		return this.onlineNum;
	}
	
	public void setOnlineNum(java.lang.Integer onlineNum){
		this.onlineNum=onlineNum;
	}
	
	
	public java.math.BigDecimal getOnlineRate(){
		return this.onlineRate;
	}
	
	public void setOnlineRate(java.math.BigDecimal onlineRate){
		this.onlineRate=onlineRate;
	}
	
	
	public java.lang.Integer getOperationNum(){
		return this.operationNum;
	}
	
	public void setOperationNum(java.lang.Integer operationNum){
		this.operationNum=operationNum;
	}
	
	
	public java.math.BigDecimal getOperationRate(){
		return this.operationRate;
	}
	
	public void setOperationRate(java.math.BigDecimal operationRate){
		this.operationRate=operationRate;
	}
	
	
	public java.math.BigDecimal getDayTotalMileage(){
		return this.dayTotalMileage;
	}
	
	public void setDayTotalMileage(java.math.BigDecimal dayTotalMileage){
		this.dayTotalMileage=dayTotalMileage;
	}
	
	
	public java.math.BigDecimal getDayTotalTime(){
		return this.dayTotalTime;
	}
	
	public void setDayTotalTime(java.math.BigDecimal dayTotalTime){
		this.dayTotalTime=dayTotalTime;
	}
	
	
	public java.math.BigDecimal getCurrentOperationMax(){
		return this.currentOperationMax;
	}
	
	public void setCurrentOperationMax(java.math.BigDecimal currentOperationMax){
		this.currentOperationMax=currentOperationMax;
	}
	
	
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime=updateTime;
	}
	
	
	public java.util.Date getCountTime(){
		return this.countTime;
	}
	
	public void setCountTime(java.util.Date countTime){
		this.countTime=countTime;
	}
	
	
	public java.lang.String getOnlineRateFlag(){
		return this.onlineRateFlag;
	}
	
	public void setOnlineRateFlag(java.lang.String onlineRateFlag){
		this.onlineRateFlag=onlineRateFlag;
	}
	
	
	public java.lang.String getOperationRateFlag(){
		return this.operationRateFlag;
	}
	
	public void setOperationRateFlag(java.lang.String operationRateFlag){
		this.operationRateFlag=operationRateFlag;
	}
	
	
	public java.lang.String getCurrentOperationMaxFlag(){
		return this.currentOperationMaxFlag;
	}
	
	public void setCurrentOperationMaxFlag(java.lang.String currentOperationMaxFlag){
		this.currentOperationMaxFlag=currentOperationMaxFlag;
	}
	
	
	public java.lang.String getDayTotalMileageFlag(){
		return this.dayTotalMileageFlag;
	}
	
	public void setDayTotalMileageFlag(java.lang.String dayTotalMileageFlag){
		this.dayTotalMileageFlag=dayTotalMileageFlag;
	}
	
	
	public java.lang.String getDayTotalTimeFlag(){
		return this.dayTotalTimeFlag;
	}
	
	public void setDayTotalTimeFlag(java.lang.String dayTotalTimeFlag){
		this.dayTotalTimeFlag=dayTotalTimeFlag;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", carType=").append(carType);			
			sb.append(", carTotalNum=").append(carTotalNum);			
			sb.append(", onlineNum=").append(onlineNum);			
			sb.append(", onlineRate=").append(onlineRate);			
			sb.append(", operationNum=").append(operationNum);			
			sb.append(", operationRate=").append(operationRate);			
			sb.append(", dayTotalMileage=").append(dayTotalMileage);			
			sb.append(", dayTotalTime=").append(dayTotalTime);			
			sb.append(", currentOperationMax=").append(currentOperationMax);			
			sb.append(", updateTime=").append(updateTime);			
			sb.append(", countTime=").append(countTime);			
			sb.append(", onlineRateFlag=").append(onlineRateFlag);			
			sb.append(", operationRateFlag=").append(operationRateFlag);			
			sb.append(", currentOperationMaxFlag=").append(currentOperationMaxFlag);			
			sb.append(", dayTotalMileageFlag=").append(dayTotalMileageFlag);			
			sb.append(", dayTotalTimeFlag=").append(dayTotalTimeFlag);			
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
        CityTransportCapacityAnalysis other = (CityTransportCapacityAnalysis) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getCarTotalNum() == null ? other.getId() == null : this.getCarTotalNum().equals(other.getCarTotalNum()))		
				        		&&(this.getOnlineNum() == null ? other.getId() == null : this.getOnlineNum().equals(other.getOnlineNum()))		
				        		&&(this.getOnlineRate() == null ? other.getId() == null : this.getOnlineRate().equals(other.getOnlineRate()))		
				        		&&(this.getOperationNum() == null ? other.getId() == null : this.getOperationNum().equals(other.getOperationNum()))		
				        		&&(this.getOperationRate() == null ? other.getId() == null : this.getOperationRate().equals(other.getOperationRate()))		
				        		&&(this.getDayTotalMileage() == null ? other.getId() == null : this.getDayTotalMileage().equals(other.getDayTotalMileage()))		
				        		&&(this.getDayTotalTime() == null ? other.getId() == null : this.getDayTotalTime().equals(other.getDayTotalTime()))		
				        		&&(this.getCurrentOperationMax() == null ? other.getId() == null : this.getCurrentOperationMax().equals(other.getCurrentOperationMax()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getCountTime() == null ? other.getId() == null : this.getCountTime().equals(other.getCountTime()))		
				        		&&(this.getOnlineRateFlag() == null ? other.getId() == null : this.getOnlineRateFlag().equals(other.getOnlineRateFlag()))		
				        		&&(this.getOperationRateFlag() == null ? other.getId() == null : this.getOperationRateFlag().equals(other.getOperationRateFlag()))		
				        		&&(this.getCurrentOperationMaxFlag() == null ? other.getId() == null : this.getCurrentOperationMaxFlag().equals(other.getCurrentOperationMaxFlag()))		
				        		&&(this.getDayTotalMileageFlag() == null ? other.getId() == null : this.getDayTotalMileageFlag().equals(other.getDayTotalMileageFlag()))		
				        		&&(this.getDayTotalTimeFlag() == null ? other.getId() == null : this.getDayTotalTimeFlag().equals(other.getDayTotalTimeFlag()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCarTotalNum() == null) ? 0 : getCarTotalNum().hashCode());		
		        result = prime * result + ((getOnlineNum() == null) ? 0 : getOnlineNum().hashCode());		
		        result = prime * result + ((getOnlineRate() == null) ? 0 : getOnlineRate().hashCode());		
		        result = prime * result + ((getOperationNum() == null) ? 0 : getOperationNum().hashCode());		
		        result = prime * result + ((getOperationRate() == null) ? 0 : getOperationRate().hashCode());		
		        result = prime * result + ((getDayTotalMileage() == null) ? 0 : getDayTotalMileage().hashCode());		
		        result = prime * result + ((getDayTotalTime() == null) ? 0 : getDayTotalTime().hashCode());		
		        result = prime * result + ((getCurrentOperationMax() == null) ? 0 : getCurrentOperationMax().hashCode());		
		        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		        result = prime * result + ((getOnlineRateFlag() == null) ? 0 : getOnlineRateFlag().hashCode());		
		        result = prime * result + ((getOperationRateFlag() == null) ? 0 : getOperationRateFlag().hashCode());		
		        result = prime * result + ((getCurrentOperationMaxFlag() == null) ? 0 : getCurrentOperationMaxFlag().hashCode());		
		        result = prime * result + ((getDayTotalMileageFlag() == null) ? 0 : getDayTotalMileageFlag().hashCode());		
		        result = prime * result + ((getDayTotalTimeFlag() == null) ? 0 : getDayTotalTimeFlag().hashCode());		
		;
        return result;
    }

}
