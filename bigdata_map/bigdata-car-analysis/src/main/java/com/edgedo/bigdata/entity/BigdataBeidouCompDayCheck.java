package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("bigdata_beidou_comp_day_check")
public class BigdataBeidouCompDayCheck implements Serializable{
	
		
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
	 * 属性描述:运营商id
	 */
	@TableField(value="COMP_ID",exist=true)
	String compId;

	/**
	 * 属性描述:运营商名
	 */
	@TableField(value="COMP_NAME",exist=true)
	String compName;

	/**
	 * 属性描述:车辆总数
	 */
	@TableField(value="CAR_NUM",exist=true)
	Integer carNum;

	/**
	 * 属性描述:上线率
	 */
	@TableField(value="ONLINE_RATE",exist=true)
	java.math.BigDecimal onlineRate;

	/**
	 * 属性描述:上线数
	 */
	@TableField(value="ONLINE_CAR_NUM",exist=true)
	Integer onlineCarNum;

	/**
	 * 属性描述:运营率
	 */
	@TableField(value="OPERATION_RATE",exist=true)
	java.math.BigDecimal operationRate;

	/**
	 * 属性描述:运营数
	 */
	@TableField(value="OPERATION_NUM",exist=true)
	Integer operationNum;

	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	String carType;

	/**
	 * 属性描述:县区类型
	 */
	@TableField(value="XIANQU_TYPE",exist=true)
	String xianquType;

	/**
	 * 属性描述:常规报警数
	 */
	@TableField(value="ALARM_NUM",exist=true)
	Integer alarmNum;

	/**
	 * 属性描述:主动安全报警数
	 */
	@TableField(value="SAFETY_NUM",exist=true)
	Integer safetyNum;

	/**
	 * 属性描述:司机插卡记录数
	 */
	@TableField(value="DRIVER_CARD_REC_NUM",exist=true)
	Integer driverCardRecNum;

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
	 * 属性描述:年份
	 */
	@TableField(value="YEAR_NUM",exist=true)
	Integer yearNum;


	public Integer getAlarmNum() {
		return alarmNum;
	}

	public void setAlarmNum(Integer alarmNum) {
		this.alarmNum = alarmNum;
	}

	public Integer getSafetyNum() {
		return safetyNum;
	}

	public void setSafetyNum(Integer safetyNum) {
		this.safetyNum = safetyNum;
	}

	public Integer getDriverCardRecNum() {
		return driverCardRecNum;
	}

	public void setDriverCardRecNum(Integer driverCardRecNum) {
		this.driverCardRecNum = driverCardRecNum;
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


	public Integer getCarNum(){
		return this.carNum;
	}

	public void setCarNum(Integer carNum){
		this.carNum=carNum;
	}


	public java.math.BigDecimal getOnlineRate(){
		return this.onlineRate;
	}

	public void setOnlineRate(java.math.BigDecimal onlineRate){
		this.onlineRate=onlineRate;
	}


	public Integer getOnlineCarNum(){
		return this.onlineCarNum;
	}

	public void setOnlineCarNum(Integer onlineCarNum){
		this.onlineCarNum=onlineCarNum;
	}


	public java.math.BigDecimal getOperationRate(){
		return this.operationRate;
	}

	public void setOperationRate(java.math.BigDecimal operationRate){
		this.operationRate=operationRate;
	}


	public Integer getOperationNum(){
		return this.operationNum;
	}

	public void setOperationNum(Integer operationNum){
		this.operationNum=operationNum;
	}


	public String getCarType(){
		return this.carType;
	}

	public void setCarType(String carType){
		this.carType=carType;
	}


	public String getXianquType(){
		return this.xianquType;
	}

	public void setXianquType(String xianquType){
		this.xianquType=xianquType;
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
			sb.append(", compId=").append(compId);			
			sb.append(", compName=").append(compName);			
			sb.append(", carNum=").append(carNum);			
			sb.append(", onlineRate=").append(onlineRate);			
			sb.append(", onlineCarNum=").append(onlineCarNum);			
			sb.append(", operationRate=").append(operationRate);			
			sb.append(", operationNum=").append(operationNum);			
			sb.append(", carType=").append(carType);			
			sb.append(", xianquType=").append(xianquType);			
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
        BigdataBeidouCompDayCheck other = (BigdataBeidouCompDayCheck) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getCompId() == null ? other.getId() == null : this.getCompId().equals(other.getCompId()))		
				        		&&(this.getCompName() == null ? other.getId() == null : this.getCompName().equals(other.getCompName()))		
				        		&&(this.getCarNum() == null ? other.getId() == null : this.getCarNum().equals(other.getCarNum()))		
				        		&&(this.getOnlineRate() == null ? other.getId() == null : this.getOnlineRate().equals(other.getOnlineRate()))		
				        		&&(this.getOnlineCarNum() == null ? other.getId() == null : this.getOnlineCarNum().equals(other.getOnlineCarNum()))		
				        		&&(this.getOperationRate() == null ? other.getId() == null : this.getOperationRate().equals(other.getOperationRate()))		
				        		&&(this.getOperationNum() == null ? other.getId() == null : this.getOperationNum().equals(other.getOperationNum()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getXianquType() == null ? other.getId() == null : this.getXianquType().equals(other.getXianquType()))		
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
		        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());		
		        result = prime * result + ((getCompName() == null) ? 0 : getCompName().hashCode());		
		        result = prime * result + ((getCarNum() == null) ? 0 : getCarNum().hashCode());		
		        result = prime * result + ((getOnlineRate() == null) ? 0 : getOnlineRate().hashCode());		
		        result = prime * result + ((getOnlineCarNum() == null) ? 0 : getOnlineCarNum().hashCode());		
		        result = prime * result + ((getOperationRate() == null) ? 0 : getOperationRate().hashCode());		
		        result = prime * result + ((getOperationNum() == null) ? 0 : getOperationNum().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getXianquType() == null) ? 0 : getXianquType().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
