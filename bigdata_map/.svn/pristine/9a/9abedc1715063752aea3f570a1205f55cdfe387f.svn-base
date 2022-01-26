package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("bigdata_fenxi_car_alarm_week")
public class BigdataFenxiCarAlarmWeek implements Serializable{
	
		
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
	 * 属性描述:所属车辆周统计ID
	 */
	@TableField(value="OWNER_CAR_DAY_ID",exist=true)
	String ownerCarDayId;

	/**
	 * 属性描述:报警类型
	 */
	@TableField(value="ALARM_TYPE",exist=true)
	String alarmType;

	/**
	 * 属性描述:报警类型描述
	 */
	@TableField(value="ALARM_TYPE_DESC",exist=true)
	String alarmTypeDesc;

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
	 * 属性描述:第几周
	 */
	@TableField(value="COUNT_WEEK",exist=true)
	Integer countWeek;

	/**
	 * 属性描述:开始日期
	 */
	@TableField(value="START_COUNT_DATE",exist=true)
	java.util.Date startCountDate;

	/**
	 * 属性描述:结束日期
	 */
	@TableField(value="END_COUNT_DATE",exist=true)
	java.util.Date endCountDate;

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


	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime=updateTime;
	}


	public String getOwnerCarDayId(){
		return this.ownerCarDayId;
	}

	public void setOwnerCarDayId(String ownerCarDayId){
		this.ownerCarDayId=ownerCarDayId;
	}


	public String getAlarmType(){
		return this.alarmType;
	}

	public void setAlarmType(String alarmType){
		this.alarmType=alarmType;
	}


	public String getAlarmTypeDesc(){
		return this.alarmTypeDesc;
	}

	public void setAlarmTypeDesc(String alarmTypeDesc){
		this.alarmTypeDesc=alarmTypeDesc;
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


	public Integer getCountWeek(){
		return this.countWeek;
	}

	public void setCountWeek(Integer countWeek){
		this.countWeek=countWeek;
	}


	public java.util.Date getStartCountDate(){
		return this.startCountDate;
	}

	public void setStartCountDate(java.util.Date startCountDate){
		this.startCountDate=startCountDate;
	}


	public java.util.Date getEndCountDate(){
		return this.endCountDate;
	}

	public void setEndCountDate(java.util.Date endCountDate){
		this.endCountDate=endCountDate;
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
			sb.append(", ownerCarDayId=").append(ownerCarDayId);			
			sb.append(", alarmType=").append(alarmType);			
			sb.append(", alarmTypeDesc=").append(alarmTypeDesc);			
			sb.append(", alarmNum=").append(alarmNum);			
			sb.append(", alarmRate=").append(alarmRate);			
			sb.append(", countWeek=").append(countWeek);			
			sb.append(", startCountDate=").append(startCountDate);			
			sb.append(", endCountDate=").append(endCountDate);			
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
        BigdataFenxiCarAlarmWeek other = (BigdataFenxiCarAlarmWeek) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getOwnerCarDayId() == null ? other.getId() == null : this.getOwnerCarDayId().equals(other.getOwnerCarDayId()))		
				        		&&(this.getAlarmType() == null ? other.getId() == null : this.getAlarmType().equals(other.getAlarmType()))		
				        		&&(this.getAlarmTypeDesc() == null ? other.getId() == null : this.getAlarmTypeDesc().equals(other.getAlarmTypeDesc()))		
				        		&&(this.getAlarmNum() == null ? other.getId() == null : this.getAlarmNum().equals(other.getAlarmNum()))		
				        		&&(this.getAlarmRate() == null ? other.getId() == null : this.getAlarmRate().equals(other.getAlarmRate()))		
				        		&&(this.getCountWeek() == null ? other.getId() == null : this.getCountWeek().equals(other.getCountWeek()))		
				        		&&(this.getStartCountDate() == null ? other.getId() == null : this.getStartCountDate().equals(other.getStartCountDate()))		
				        		&&(this.getEndCountDate() == null ? other.getId() == null : this.getEndCountDate().equals(other.getEndCountDate()))		
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
		        result = prime * result + ((getOwnerCarDayId() == null) ? 0 : getOwnerCarDayId().hashCode());		
		        result = prime * result + ((getAlarmType() == null) ? 0 : getAlarmType().hashCode());		
		        result = prime * result + ((getAlarmTypeDesc() == null) ? 0 : getAlarmTypeDesc().hashCode());		
		        result = prime * result + ((getAlarmNum() == null) ? 0 : getAlarmNum().hashCode());		
		        result = prime * result + ((getAlarmRate() == null) ? 0 : getAlarmRate().hashCode());		
		        result = prime * result + ((getCountWeek() == null) ? 0 : getCountWeek().hashCode());		
		        result = prime * result + ((getStartCountDate() == null) ? 0 : getStartCountDate().hashCode());		
		        result = prime * result + ((getEndCountDate() == null) ? 0 : getEndCountDate().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
