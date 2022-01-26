package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("city_transport_capacity_analysis")
public class CityTransportCapacityAnalysis implements Serializable{
	
		
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
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	String carType;

	/**
	 * 属性描述:车辆总数
	 */
	@TableField(value="CAR_TOTAL_NUM",exist=true)
	Integer carTotalNum;

	/**
	 * 属性描述:车辆上线数
	 */
	@TableField(value="ONLINE_NUM",exist=true)
	Integer onlineNum;

	/**
	 * 属性描述:车辆上线率
	 */
	@TableField(value="ONLINE_RATE",exist=true)
	java.math.BigDecimal onlineRate;

	/**
	 * 属性描述:运营数
	 */
	@TableField(value="OPERATION_NUM",exist=true)
	Integer operationNum;

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
	Date countTime;

	public Date getCountTime() {
		return countTime;
	}

	public void setCountTime(Date countTime) {
		this.countTime = countTime;
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


	public String getCarType(){
		return this.carType;
	}

	public void setCarType(String carType){
		this.carType=carType;
	}


	public Integer getCarTotalNum(){
		return this.carTotalNum;
	}

	public void setCarTotalNum(Integer carTotalNum){
		this.carTotalNum=carTotalNum;
	}


	public Integer getOnlineNum(){
		return this.onlineNum;
	}

	public void setOnlineNum(Integer onlineNum){
		this.onlineNum=onlineNum;
	}


	public java.math.BigDecimal getOnlineRate(){
		return this.onlineRate;
	}

	public void setOnlineRate(java.math.BigDecimal onlineRate){
		this.onlineRate=onlineRate;
	}


	public Integer getOperationNum(){
		return this.operationNum;
	}

	public void setOperationNum(Integer operationNum){
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
		;
        return result;
    }

}
