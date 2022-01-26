package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_fenxi_car_alarm_month")
public class BigdataFenxiCarAlarmMonth implements Serializable{
	
		
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
	 * 属性描述:所属车辆月统计ID
	 */
	@TableField(value="OWNER_CAR_MONTH_ID",exist=true)
	java.lang.String ownerCarMonthId;
	
	/**
	 * 属性描述:报警类型
	 */
	@TableField(value="ALARM_TYPE",exist=true)
	java.lang.String alarmType;
	
	/**
	 * 属性描述:报警类型描述
	 */
	@TableField(value="ALARM_TYPE_DESC",exist=true)
	java.lang.String alarmTypeDesc;
	
	/**
	 * 属性描述:报警数量
	 */
	@TableField(value="ALARM_NUM",exist=true)
	java.lang.Integer alarmNum;
	
	/**
	 * 属性描述:报警数量/百公里
	 */
	@TableField(value="ALARM_RATE",exist=true)
	java.math.BigDecimal alarmRate;
	
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
	
	
	public java.lang.String getOwnerCarMonthId(){
		return this.ownerCarMonthId;
	}
	
	public void setOwnerCarMonthId(java.lang.String ownerCarMonthId){
		this.ownerCarMonthId=ownerCarMonthId;
	}
	
	
	public java.lang.String getAlarmType(){
		return this.alarmType;
	}
	
	public void setAlarmType(java.lang.String alarmType){
		this.alarmType=alarmType;
	}
	
	
	public java.lang.String getAlarmTypeDesc(){
		return this.alarmTypeDesc;
	}
	
	public void setAlarmTypeDesc(java.lang.String alarmTypeDesc){
		this.alarmTypeDesc=alarmTypeDesc;
	}
	
	
	public java.lang.Integer getAlarmNum(){
		return this.alarmNum;
	}
	
	public void setAlarmNum(java.lang.Integer alarmNum){
		this.alarmNum=alarmNum;
	}
	
	
	public java.math.BigDecimal getAlarmRate(){
		return this.alarmRate;
	}
	
	public void setAlarmRate(java.math.BigDecimal alarmRate){
		this.alarmRate=alarmRate;
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
			sb.append(", ownerCarMonthId=").append(ownerCarMonthId);			
			sb.append(", alarmType=").append(alarmType);			
			sb.append(", alarmTypeDesc=").append(alarmTypeDesc);			
			sb.append(", alarmNum=").append(alarmNum);			
			sb.append(", alarmRate=").append(alarmRate);			
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
        BigdataFenxiCarAlarmMonth other = (BigdataFenxiCarAlarmMonth) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getOwnerCarMonthId() == null ? other.getId() == null : this.getOwnerCarMonthId().equals(other.getOwnerCarMonthId()))		
				        		&&(this.getAlarmType() == null ? other.getId() == null : this.getAlarmType().equals(other.getAlarmType()))		
				        		&&(this.getAlarmTypeDesc() == null ? other.getId() == null : this.getAlarmTypeDesc().equals(other.getAlarmTypeDesc()))		
				        		&&(this.getAlarmNum() == null ? other.getId() == null : this.getAlarmNum().equals(other.getAlarmNum()))		
				        		&&(this.getAlarmRate() == null ? other.getId() == null : this.getAlarmRate().equals(other.getAlarmRate()))		
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
		        result = prime * result + ((getOwnerCarMonthId() == null) ? 0 : getOwnerCarMonthId().hashCode());		
		        result = prime * result + ((getAlarmType() == null) ? 0 : getAlarmType().hashCode());		
		        result = prime * result + ((getAlarmTypeDesc() == null) ? 0 : getAlarmTypeDesc().hashCode());		
		        result = prime * result + ((getAlarmNum() == null) ? 0 : getAlarmNum().hashCode());		
		        result = prime * result + ((getAlarmRate() == null) ? 0 : getAlarmRate().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
