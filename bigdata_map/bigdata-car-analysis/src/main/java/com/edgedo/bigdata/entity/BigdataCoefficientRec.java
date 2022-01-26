package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

@TableName("bigdata_coefficient_rec")
public class BigdataCoefficientRec implements Serializable{
	
		
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
	 * 属性描述:超速报警系数
	 */
	@TableField(value="OVERSPEED_WARNING_NUM",exist=true)
	BigDecimal overspeedWarningNum;

	/**
	 * 属性描述:超速报警系数标识
	 */
	@TableField(value="OVERSPEED_WARNING_NUM_FLAG",exist=true)
	String overspeedWarningNumFlag;

	/**
	 * 属性描述:疲劳驾驶系数
	 */
	@TableField(value="FATIGUE_RUN_NUM",exist=true)
	BigDecimal fatigueRunNum;

	/**
	 * 属性描述:疲劳驾驶系数标识
	 */
	@TableField(value="FATIGUE_RUN_NUM_FLAG",exist=true)
	String fatigueRunNumFlag;

	/**
	 * 属性描述:危险路段驾驶里程系数
	 */
	@TableField(value="DANGER_ROAD_RUN_NUM",exist=true)
	BigDecimal dangerRoadRunNum;

	/**
	 * 属性描述:危险路段驾驶里程系数标识
	 */
	@TableField(value="DANGER_ROAD_RUN_NUM_FLAG",exist=true)
	String dangerRoadRunNumFlag;

	/**
	 * 属性描述:危险路段经过次数系数
	 */
	@TableField(value="DANGER_ROAD_PASS_NUM",exist=true)
	BigDecimal dangerRoadPassNum;

	/**
	 * 属性描述:危险路段经过次数系数标识
	 */
	@TableField(value="DANGER_ROAD_PASS_NUM_FLAG",exist=true)
	String dangerRoadPassNumFlag;

	/**
	 * 属性描述:安全生产形势危险系数
	 */
	@TableField(value="SAFETY_NIUM",exist=true)
	BigDecimal safetyNium;

	/**
	 * 属性描述:安全生产形势危险系数标识
	 */
	@TableField(value="SAFETY_NIUM_FLAG",exist=true)
	String safetyNiumFlag;

	//箭头
	@TableField(value="JIANTOU",exist=true)
	BigDecimal jiantou;

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


	public BigDecimal getJiantou() {
		return jiantou;
	}

	public void setJiantou(BigDecimal jiantou) {
		this.jiantou = jiantou;
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


	public BigDecimal getOverspeedWarningNum(){
		return this.overspeedWarningNum;
	}

	public void setOverspeedWarningNum(BigDecimal overspeedWarningNum){
		this.overspeedWarningNum=overspeedWarningNum;
	}


	public String getOverspeedWarningNumFlag(){
		return this.overspeedWarningNumFlag;
	}

	public void setOverspeedWarningNumFlag(String overspeedWarningNumFlag){
		this.overspeedWarningNumFlag=overspeedWarningNumFlag;
	}


	public BigDecimal getFatigueRunNum(){
		return this.fatigueRunNum;
	}

	public void setFatigueRunNum(BigDecimal fatigueRunNum){
		this.fatigueRunNum=fatigueRunNum;
	}


	public String getFatigueRunNumFlag(){
		return this.fatigueRunNumFlag;
	}

	public void setFatigueRunNumFlag(String fatigueRunNumFlag){
		this.fatigueRunNumFlag=fatigueRunNumFlag;
	}


	public BigDecimal getDangerRoadRunNum(){
		return this.dangerRoadRunNum;
	}

	public void setDangerRoadRunNum(BigDecimal dangerRoadRunNum){
		this.dangerRoadRunNum=dangerRoadRunNum;
	}


	public String getDangerRoadRunNumFlag(){
		return this.dangerRoadRunNumFlag;
	}

	public void setDangerRoadRunNumFlag(String dangerRoadRunNumFlag){
		this.dangerRoadRunNumFlag=dangerRoadRunNumFlag;
	}


	public BigDecimal getDangerRoadPassNum(){
		return this.dangerRoadPassNum;
	}

	public void setDangerRoadPassNum(BigDecimal dangerRoadPassNum){
		this.dangerRoadPassNum=dangerRoadPassNum;
	}


	public String getDangerRoadPassNumFlag(){
		return this.dangerRoadPassNumFlag;
	}

	public void setDangerRoadPassNumFlag(String dangerRoadPassNumFlag){
		this.dangerRoadPassNumFlag=dangerRoadPassNumFlag;
	}


	public BigDecimal getSafetyNium(){
		return this.safetyNium;
	}

	public void setSafetyNium(BigDecimal safetyNium){
		this.safetyNium=safetyNium;
	}


	public String getSafetyNiumFlag(){
		return this.safetyNiumFlag;
	}

	public void setSafetyNiumFlag(String safetyNiumFlag){
		this.safetyNiumFlag=safetyNiumFlag;
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
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", overspeedWarningNum=").append(overspeedWarningNum);			
			sb.append(", overspeedWarningNumFlag=").append(overspeedWarningNumFlag);			
			sb.append(", fatigueRunNum=").append(fatigueRunNum);			
			sb.append(", fatigueRunNumFlag=").append(fatigueRunNumFlag);			
			sb.append(", dangerRoadRunNum=").append(dangerRoadRunNum);			
			sb.append(", dangerRoadRunNumFlag=").append(dangerRoadRunNumFlag);			
			sb.append(", dangerRoadPassNum=").append(dangerRoadPassNum);			
			sb.append(", dangerRoadPassNumFlag=").append(dangerRoadPassNumFlag);			
			sb.append(", safetyNium=").append(safetyNium);			
			sb.append(", safetyNiumFlag=").append(safetyNiumFlag);			
			sb.append(", carType=").append(carType);			
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
        BigdataCoefficientRec other = (BigdataCoefficientRec) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getOverspeedWarningNum() == null ? other.getId() == null : this.getOverspeedWarningNum().equals(other.getOverspeedWarningNum()))		
				        		&&(this.getOverspeedWarningNumFlag() == null ? other.getId() == null : this.getOverspeedWarningNumFlag().equals(other.getOverspeedWarningNumFlag()))		
				        		&&(this.getFatigueRunNum() == null ? other.getId() == null : this.getFatigueRunNum().equals(other.getFatigueRunNum()))		
				        		&&(this.getFatigueRunNumFlag() == null ? other.getId() == null : this.getFatigueRunNumFlag().equals(other.getFatigueRunNumFlag()))		
				        		&&(this.getDangerRoadRunNum() == null ? other.getId() == null : this.getDangerRoadRunNum().equals(other.getDangerRoadRunNum()))		
				        		&&(this.getDangerRoadRunNumFlag() == null ? other.getId() == null : this.getDangerRoadRunNumFlag().equals(other.getDangerRoadRunNumFlag()))		
				        		&&(this.getDangerRoadPassNum() == null ? other.getId() == null : this.getDangerRoadPassNum().equals(other.getDangerRoadPassNum()))		
				        		&&(this.getDangerRoadPassNumFlag() == null ? other.getId() == null : this.getDangerRoadPassNumFlag().equals(other.getDangerRoadPassNumFlag()))		
				        		&&(this.getSafetyNium() == null ? other.getId() == null : this.getSafetyNium().equals(other.getSafetyNium()))		
				        		&&(this.getSafetyNiumFlag() == null ? other.getId() == null : this.getSafetyNiumFlag().equals(other.getSafetyNiumFlag()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getCountTime() == null ? other.getId() == null : this.getCountTime().equals(other.getCountTime()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getOverspeedWarningNum() == null) ? 0 : getOverspeedWarningNum().hashCode());		
		        result = prime * result + ((getOverspeedWarningNumFlag() == null) ? 0 : getOverspeedWarningNumFlag().hashCode());		
		        result = prime * result + ((getFatigueRunNum() == null) ? 0 : getFatigueRunNum().hashCode());		
		        result = prime * result + ((getFatigueRunNumFlag() == null) ? 0 : getFatigueRunNumFlag().hashCode());		
		        result = prime * result + ((getDangerRoadRunNum() == null) ? 0 : getDangerRoadRunNum().hashCode());		
		        result = prime * result + ((getDangerRoadRunNumFlag() == null) ? 0 : getDangerRoadRunNumFlag().hashCode());		
		        result = prime * result + ((getDangerRoadPassNum() == null) ? 0 : getDangerRoadPassNum().hashCode());		
		        result = prime * result + ((getDangerRoadPassNumFlag() == null) ? 0 : getDangerRoadPassNumFlag().hashCode());		
		        result = prime * result + ((getSafetyNium() == null) ? 0 : getSafetyNium().hashCode());		
		        result = prime * result + ((getSafetyNiumFlag() == null) ? 0 : getSafetyNiumFlag().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		;
        return result;
    }

}
