package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("bigdata_time_car_sum_count")
public class BigdataTimeCarSumCount implements Serializable{
	
		
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
	 * 属性描述:一类危险时段
	 */
	@TableField(value="FIRST_DANGER_TIME_NUM",exist=true)
	Integer firstDangerTimeNum;

	/**
	 * 属性描述:二类危险时段
	 */
	@TableField(value="SECOND_DANGER_TIME_NUM",exist=true)
	Integer secondDangerTimeNum;

	/**
	 * 属性描述:三类危险时段
	 */
	@TableField(value="THIRD_DANGER_TIME_NUM",exist=true)
	Integer thirdDangerTimeNum;

	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	String carType;

	/**
	 * 属性描述:月份字符串
	 */
	@TableField(value="COUNT_MONTH",exist=true)
	Integer countMonth;

	/**
	 * 属性描述:年度
	 */
	@TableField(value="COUNT_YEAR",exist=true)
	Integer countYear;

	/**
	 * 属性描述:上次更新时间
	 */
	@TableField(value="LAST_UP_TIME",exist=true)
	java.util.Date lastUpTime;






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


	public Integer getFirstDangerTimeNum(){
		return this.firstDangerTimeNum;
	}

	public void setFirstDangerTimeNum(Integer firstDangerTimeNum){
		this.firstDangerTimeNum=firstDangerTimeNum;
	}


	public Integer getSecondDangerTimeNum(){
		return this.secondDangerTimeNum;
	}

	public void setSecondDangerTimeNum(Integer secondDangerTimeNum){
		this.secondDangerTimeNum=secondDangerTimeNum;
	}


	public Integer getThirdDangerTimeNum(){
		return this.thirdDangerTimeNum;
	}

	public void setThirdDangerTimeNum(Integer thirdDangerTimeNum){
		this.thirdDangerTimeNum=thirdDangerTimeNum;
	}


	public String getCarType(){
		return this.carType;
	}

	public void setCarType(String carType){
		this.carType=carType;
	}


	public Integer getCountMonth(){
		return this.countMonth;
	}

	public void setCountMonth(Integer countMonth){
		this.countMonth=countMonth;
	}


	public Integer getCountYear(){
		return this.countYear;
	}

	public void setCountYear(Integer countYear){
		this.countYear=countYear;
	}
	
	
	public java.util.Date getLastUpTime(){
		return this.lastUpTime;
	}
	
	public void setLastUpTime(java.util.Date lastUpTime){
		this.lastUpTime=lastUpTime;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", countType=").append(countType);			
			sb.append(", countTime=").append(countTime);			
			sb.append(", firstDangerTimeNum=").append(firstDangerTimeNum);			
			sb.append(", secondDangerTimeNum=").append(secondDangerTimeNum);			
			sb.append(", thirdDangerTimeNum=").append(thirdDangerTimeNum);			
			sb.append(", carType=").append(carType);			
			sb.append(", countMonth=").append(countMonth);			
			sb.append(", countYear=").append(countYear);			
			sb.append(", lastUpTime=").append(lastUpTime);			
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
        BigdataTimeCarSumCount other = (BigdataTimeCarSumCount) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCountType() == null ? other.getId() == null : this.getCountType().equals(other.getCountType()))		
				        		&&(this.getCountTime() == null ? other.getId() == null : this.getCountTime().equals(other.getCountTime()))		
				        		&&(this.getFirstDangerTimeNum() == null ? other.getId() == null : this.getFirstDangerTimeNum().equals(other.getFirstDangerTimeNum()))		
				        		&&(this.getSecondDangerTimeNum() == null ? other.getId() == null : this.getSecondDangerTimeNum().equals(other.getSecondDangerTimeNum()))		
				        		&&(this.getThirdDangerTimeNum() == null ? other.getId() == null : this.getThirdDangerTimeNum().equals(other.getThirdDangerTimeNum()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getCountMonth() == null ? other.getId() == null : this.getCountMonth().equals(other.getCountMonth()))		
				        		&&(this.getCountYear() == null ? other.getId() == null : this.getCountYear().equals(other.getCountYear()))		
				        		&&(this.getLastUpTime() == null ? other.getId() == null : this.getLastUpTime().equals(other.getLastUpTime()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCountType() == null) ? 0 : getCountType().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		        result = prime * result + ((getFirstDangerTimeNum() == null) ? 0 : getFirstDangerTimeNum().hashCode());		
		        result = prime * result + ((getSecondDangerTimeNum() == null) ? 0 : getSecondDangerTimeNum().hashCode());		
		        result = prime * result + ((getThirdDangerTimeNum() == null) ? 0 : getThirdDangerTimeNum().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getCountYear() == null) ? 0 : getCountYear().hashCode());		
		        result = prime * result + ((getLastUpTime() == null) ? 0 : getLastUpTime().hashCode());		
		;
        return result;
    }

}
