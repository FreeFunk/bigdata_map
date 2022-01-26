package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

@TableName("bigdata_fatigue_analysis")
public class BigdataFatigueAnalysis implements Serializable{
	
		
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
	 * 属性描述:高速疲劳里程
	 */
	@TableField(value="HIGH_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal highFatigueMileage;

	/**
	 * 属性描述:高速疲劳时长
	 */
	@TableField(value="HIGH_FATIGUE_TIME",exist=true)
	java.math.BigDecimal highFatigueTime;

	/**
	 * 属性描述:高速疲劳次数
	 */
	@TableField(value="HIGH_FATIGUE_NUM",exist=true)
	Integer highFatigueNum;

	/**
	 * 属性描述:高速严重疲劳里程
	 */
	@TableField(value="HIGH_SERIOUS_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal highSeriousFatigueMileage;

	/**
	 * 属性描述:高速严重疲劳时长
	 */
	@TableField(value="HIGH_SERIOUS_FATIGUE_TIME",exist=true)
	java.math.BigDecimal highSeriousFatigueTime;

	/**
	 * 属性描述:高速严重疲劳次数
	 */
	@TableField(value="HIGH_SERIOUS_FATIGUE_NUM",exist=true)
	Integer highSeriousFatigueNum;

	/**
	 * 属性描述:高速夜间疲劳里程
	 */
	@TableField(value="HIGH_NIGHT_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal highNightFatigueMileage;

	/**
	 * 属性描述:高速夜间疲劳时长
	 */
	@TableField(value="HIGH_NIGHT_FATIGUE_TIME",exist=true)
	java.math.BigDecimal highNightFatigueTime;

	/**
	 * 属性描述:高速夜间疲劳次数
	 */
	@TableField(value="HIGH_NIGHT_FATIGUE_NUM",exist=true)
	Integer highNightFatigueNum;

	/**
	 * 属性描述:国道疲劳里程
	 */
	@TableField(value="NATIONAL_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal nationalFatigueMileage;

	/**
	 * 属性描述:国道疲劳时长
	 */
	@TableField(value="NATIONAL_FATIGUE_TIME",exist=true)
	java.math.BigDecimal nationalFatigueTime;

	/**
	 * 属性描述:国道疲劳次数
	 */
	@TableField(value="NATIONAL_FATIGUE_NUM",exist=true)
	Integer nationalFatigueNum;

	/**
	 * 属性描述:国道严重疲劳里程
	 */
	@TableField(value="NATIONAL_SERIOUS_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal nationalSeriousFatigueMileage;

	/**
	 * 属性描述:国道严重疲劳时长
	 */
	@TableField(value="NATIONAL_SERIOUS_FATIGUE_TIME",exist=true)
	java.math.BigDecimal nationalSeriousFatigueTime;

	/**
	 * 属性描述:国道严重疲劳次数
	 */
	@TableField(value="NATIONAL_SERIOUS_FATIGUE_NUM",exist=true)
	Integer nationalSeriousFatigueNum;

	/**
	 * 属性描述:国道夜间疲劳里程
	 */
	@TableField(value="NATIONAL_NIGHT_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal nationalNightFatigueMileage;

	/**
	 * 属性描述:国道夜间疲劳时长
	 */
	@TableField(value="NATIONAL_NIGHT_FATIGUE_TIME",exist=true)
	java.math.BigDecimal nationalNightFatigueTime;

	/**
	 * 属性描述:国道夜间疲劳次数
	 */
	@TableField(value="NATIONAL_NIGHT_FATIGUE_NUM",exist=true)
	Integer nationalNightFatigueNum;

	/**
	 * 属性描述:其他道路疲劳里程
	 */
	@TableField(value="OTHER_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal otherFatigueMileage;

	/**
	 * 属性描述:其他道路疲劳时长
	 */
	@TableField(value="OTHER_FATIGUE_TIME",exist=true)
	java.math.BigDecimal otherFatigueTime;

	/**
	 * 属性描述:其他道路疲劳次数
	 */
	@TableField(value="OTHER_FATIGUE_NUM",exist=true)
	Integer otherFatigueNum;

	/**
	 * 属性描述:其他道路严重疲劳里程
	 */
	@TableField(value="OTHER_SERIOUS_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal otherSeriousFatigueMileage;

	/**
	 * 属性描述:其他道路严重疲劳时长
	 */
	@TableField(value="OTHER_SERIOUS_FATIGUE_TIME",exist=true)
	java.math.BigDecimal otherSeriousFatigueTime;

	/**
	 * 属性描述:其他道路严重疲劳次数
	 */
	@TableField(value="OTHER_SERIOUS_FATIGUE_NUM",exist=true)
	Integer otherSeriousFatigueNum;

	/**
	 * 属性描述:其他道路夜间疲劳里程
	 */
	@TableField(value="OTHER_NIGHT_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal otherNightFatigueMileage;

	/**
	 * 属性描述:其他道路夜间疲劳时长
	 */
	@TableField(value="OTHER_NIGHT_FATIGUE_TIME",exist=true)
	java.math.BigDecimal otherNightFatigueTime;

	/**
	 * 属性描述:其他道路夜间疲劳次数
	 */
	@TableField(value="OTHER_NIGHT_FATIGUE_NUM",exist=true)
	Integer otherNightFatigueNum;

	/**
	 * 属性描述:疲劳总里程
	 */
	@TableField(value="SUM_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal sumFatigueMileage;

	/**
	 * 属性描述:疲劳总时长
	 */
	@TableField(value="SUM_FATIGUE_TIME",exist=true)
	java.math.BigDecimal sumFatigueTime;

	/**
	 * 属性描述:疲劳总次数
	 */
	@TableField(value="SUM_FATIGUE_NUM",exist=true)
	Integer sumFatigueNum;

	/**
	 * 属性描述:严重疲劳总里程
	 */
	@TableField(value="SUM_SERIOUS_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal sumSeriousFatigueMileage;

	/**
	 * 属性描述:严重疲劳总时长
	 */
	@TableField(value="SUM_SERIOUS_FATIGUE_TIME",exist=true)
	java.math.BigDecimal sumSeriousFatigueTime;

	/**
	 * 属性描述:其他道路严重疲劳次数
	 */
	@TableField(value="SUM_SERIOUS_FATIGUE_NUM",exist=true)
	Integer sumSeriousFatigueNum;

	/**
	 * 属性描述:夜间疲劳总里程
	 */
	@TableField(value="SUM_NIGHT_FATIGUE_MILEAGE",exist=true)
	java.math.BigDecimal sumNightFatigueMileage;

	/**
	 * 属性描述:夜间疲劳总时长
	 */
	@TableField(value="SUM_NIGHT_FATIGUE_TIME",exist=true)
	java.math.BigDecimal sumNightFatigueTime;

	/**
	 * 属性描述:夜间疲劳总次数
	 */
	@TableField(value="SUM_NIGHT_FATIGUE_NUM",exist=true)
	Integer sumNightFatigueNum;

	/**
	 * 属性描述:国道疲劳占比
	 */
	@TableField(value="NATIONAL_FATIGUE_RATE",exist=true)
	java.math.BigDecimal nationalFatigueRate;

	/**
	 * 属性描述:国道疲劳标识
	 */
	@TableField(value="NATIONAL_FATIGUE_FlAG",exist=true)
	String nationalfatigueflAg;

	/**
	 * 属性描述:高速疲劳占比
	 */
	@TableField(value="HIGH_FATIGUE_RATE",exist=true)
	java.math.BigDecimal highFatigueRate;

	/**
	 * 属性描述:高速疲劳标识
	 */
	@TableField(value="HIGH_FATIGUE_FlAG",exist=true)
	String highfatigueflAg;

	/**
	 * 属性描述:其他道路疲劳占比
	 */
	@TableField(value="OTHER_FATIGUE_RATE",exist=true)
	java.math.BigDecimal otherFatigueRate;

	/**
	 * 属性描述:其他道路疲劳标识
	 */
	@TableField(value="OTHER_FATIGUE_FlAG",exist=true)
	String otherfatigueflAg;

	/**
	 * 属性描述:严重疲劳占比
	 */
	@TableField(value="SERIOUS_FATIGUE_RATE",exist=true)
	java.math.BigDecimal seriousFatigueRate;

	/**
	 * 属性描述:严重疲劳标识
	 */
	@TableField(value="SERIOUS_FATIGUE_FlAG",exist=true)
	String seriousfatigueflAg;

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

	//非夜间的疲劳总次数
	@TableField(value="SUM_NIGHT_FATIGUE_NUM_NO",exist=true)
	Integer sumNightFatigueNumNo;
	//危险时段次数占比
	@TableField(value="NIGHT_FATIGUE_RATE",exist=true)
	java.math.BigDecimal nightFatigueRate;
	//危险时段标识
	@TableField(value="NIGHT_FATIGUE_FlAG",exist=true)
	String nightfatigueflAg;

	//非危险时段次数占比
	@TableField(value="NIGHT_FATIGUE_NO_RATE",exist=true)
	java.math.BigDecimal nightFatigueNoRate;
	//非危险时段标识
	@TableField(value="NIGHT_FATIGUE_NO_FlAG",exist=true)
	String nightFatigueNoflAg;

	//统计日期
	@TableField(value="COUNT_DATE",exist=true)
	Integer countDate;
	//统计月份
	@TableField(value="COUNT_MONTH",exist=true)
	Integer countMonth;

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

	public BigDecimal getNightFatigueRate() {
		return nightFatigueRate;
	}

	public void setNightFatigueRate(BigDecimal nightFatigueRate) {
		this.nightFatigueRate = nightFatigueRate;
	}

	public BigDecimal getNightFatigueNoRate() {
		return nightFatigueNoRate;
	}

	public void setNightFatigueNoRate(BigDecimal nightFatigueNoRate) {
		this.nightFatigueNoRate = nightFatigueNoRate;
	}

	public Integer getSumNightFatigueNumNo() {
		return sumNightFatigueNumNo;
	}

	public void setSumNightFatigueNumNo(Integer sumNightFatigueNumNo) {
		this.sumNightFatigueNumNo = sumNightFatigueNumNo;
	}

	public String getNightfatigueflAg() {
		return nightfatigueflAg;
	}

	public void setNightfatigueflAg(String nightfatigueflAg) {
		this.nightfatigueflAg = nightfatigueflAg;
	}

	public String getNightFatigueNoflAg() {
		return nightFatigueNoflAg;
	}

	public void setNightFatigueNoflAg(String nightFatigueNoflAg) {
		this.nightFatigueNoflAg = nightFatigueNoflAg;
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


	public java.math.BigDecimal getHighFatigueMileage(){
		return this.highFatigueMileage;
	}

	public void setHighFatigueMileage(java.math.BigDecimal highFatigueMileage){
		this.highFatigueMileage=highFatigueMileage;
	}


	public java.math.BigDecimal getHighFatigueTime(){
		return this.highFatigueTime;
	}

	public void setHighFatigueTime(java.math.BigDecimal highFatigueTime){
		this.highFatigueTime=highFatigueTime;
	}


	public Integer getHighFatigueNum(){
		return this.highFatigueNum;
	}

	public void setHighFatigueNum(Integer highFatigueNum){
		this.highFatigueNum=highFatigueNum;
	}


	public java.math.BigDecimal getHighSeriousFatigueMileage(){
		return this.highSeriousFatigueMileage;
	}

	public void setHighSeriousFatigueMileage(java.math.BigDecimal highSeriousFatigueMileage){
		this.highSeriousFatigueMileage=highSeriousFatigueMileage;
	}


	public java.math.BigDecimal getHighSeriousFatigueTime(){
		return this.highSeriousFatigueTime;
	}

	public void setHighSeriousFatigueTime(java.math.BigDecimal highSeriousFatigueTime){
		this.highSeriousFatigueTime=highSeriousFatigueTime;
	}


	public Integer getHighSeriousFatigueNum(){
		return this.highSeriousFatigueNum;
	}

	public void setHighSeriousFatigueNum(Integer highSeriousFatigueNum){
		this.highSeriousFatigueNum=highSeriousFatigueNum;
	}


	public java.math.BigDecimal getHighNightFatigueMileage(){
		return this.highNightFatigueMileage;
	}

	public void setHighNightFatigueMileage(java.math.BigDecimal highNightFatigueMileage){
		this.highNightFatigueMileage=highNightFatigueMileage;
	}


	public java.math.BigDecimal getHighNightFatigueTime(){
		return this.highNightFatigueTime;
	}

	public void setHighNightFatigueTime(java.math.BigDecimal highNightFatigueTime){
		this.highNightFatigueTime=highNightFatigueTime;
	}


	public Integer getHighNightFatigueNum(){
		return this.highNightFatigueNum;
	}

	public void setHighNightFatigueNum(Integer highNightFatigueNum){
		this.highNightFatigueNum=highNightFatigueNum;
	}


	public java.math.BigDecimal getNationalFatigueMileage(){
		return this.nationalFatigueMileage;
	}

	public void setNationalFatigueMileage(java.math.BigDecimal nationalFatigueMileage){
		this.nationalFatigueMileage=nationalFatigueMileage;
	}


	public java.math.BigDecimal getNationalFatigueTime(){
		return this.nationalFatigueTime;
	}

	public void setNationalFatigueTime(java.math.BigDecimal nationalFatigueTime){
		this.nationalFatigueTime=nationalFatigueTime;
	}


	public Integer getNationalFatigueNum(){
		return this.nationalFatigueNum;
	}

	public void setNationalFatigueNum(Integer nationalFatigueNum){
		this.nationalFatigueNum=nationalFatigueNum;
	}


	public java.math.BigDecimal getNationalSeriousFatigueMileage(){
		return this.nationalSeriousFatigueMileage;
	}

	public void setNationalSeriousFatigueMileage(java.math.BigDecimal nationalSeriousFatigueMileage){
		this.nationalSeriousFatigueMileage=nationalSeriousFatigueMileage;
	}


	public java.math.BigDecimal getNationalSeriousFatigueTime(){
		return this.nationalSeriousFatigueTime;
	}

	public void setNationalSeriousFatigueTime(java.math.BigDecimal nationalSeriousFatigueTime){
		this.nationalSeriousFatigueTime=nationalSeriousFatigueTime;
	}


	public Integer getNationalSeriousFatigueNum(){
		return this.nationalSeriousFatigueNum;
	}

	public void setNationalSeriousFatigueNum(Integer nationalSeriousFatigueNum){
		this.nationalSeriousFatigueNum=nationalSeriousFatigueNum;
	}


	public java.math.BigDecimal getNationalNightFatigueMileage(){
		return this.nationalNightFatigueMileage;
	}

	public void setNationalNightFatigueMileage(java.math.BigDecimal nationalNightFatigueMileage){
		this.nationalNightFatigueMileage=nationalNightFatigueMileage;
	}


	public java.math.BigDecimal getNationalNightFatigueTime(){
		return this.nationalNightFatigueTime;
	}

	public void setNationalNightFatigueTime(java.math.BigDecimal nationalNightFatigueTime){
		this.nationalNightFatigueTime=nationalNightFatigueTime;
	}


	public Integer getNationalNightFatigueNum(){
		return this.nationalNightFatigueNum;
	}

	public void setNationalNightFatigueNum(Integer nationalNightFatigueNum){
		this.nationalNightFatigueNum=nationalNightFatigueNum;
	}


	public java.math.BigDecimal getOtherFatigueMileage(){
		return this.otherFatigueMileage;
	}

	public void setOtherFatigueMileage(java.math.BigDecimal otherFatigueMileage){
		this.otherFatigueMileage=otherFatigueMileage;
	}


	public java.math.BigDecimal getOtherFatigueTime(){
		return this.otherFatigueTime;
	}

	public void setOtherFatigueTime(java.math.BigDecimal otherFatigueTime){
		this.otherFatigueTime=otherFatigueTime;
	}


	public Integer getOtherFatigueNum(){
		return this.otherFatigueNum;
	}

	public void setOtherFatigueNum(Integer otherFatigueNum){
		this.otherFatigueNum=otherFatigueNum;
	}


	public java.math.BigDecimal getOtherSeriousFatigueMileage(){
		return this.otherSeriousFatigueMileage;
	}

	public void setOtherSeriousFatigueMileage(java.math.BigDecimal otherSeriousFatigueMileage){
		this.otherSeriousFatigueMileage=otherSeriousFatigueMileage;
	}


	public java.math.BigDecimal getOtherSeriousFatigueTime(){
		return this.otherSeriousFatigueTime;
	}

	public void setOtherSeriousFatigueTime(java.math.BigDecimal otherSeriousFatigueTime){
		this.otherSeriousFatigueTime=otherSeriousFatigueTime;
	}


	public Integer getOtherSeriousFatigueNum(){
		return this.otherSeriousFatigueNum;
	}

	public void setOtherSeriousFatigueNum(Integer otherSeriousFatigueNum){
		this.otherSeriousFatigueNum=otherSeriousFatigueNum;
	}


	public java.math.BigDecimal getOtherNightFatigueMileage(){
		return this.otherNightFatigueMileage;
	}

	public void setOtherNightFatigueMileage(java.math.BigDecimal otherNightFatigueMileage){
		this.otherNightFatigueMileage=otherNightFatigueMileage;
	}


	public java.math.BigDecimal getOtherNightFatigueTime(){
		return this.otherNightFatigueTime;
	}

	public void setOtherNightFatigueTime(java.math.BigDecimal otherNightFatigueTime){
		this.otherNightFatigueTime=otherNightFatigueTime;
	}


	public Integer getOtherNightFatigueNum(){
		return this.otherNightFatigueNum;
	}

	public void setOtherNightFatigueNum(Integer otherNightFatigueNum){
		this.otherNightFatigueNum=otherNightFatigueNum;
	}


	public java.math.BigDecimal getSumFatigueMileage(){
		return this.sumFatigueMileage;
	}

	public void setSumFatigueMileage(java.math.BigDecimal sumFatigueMileage){
		this.sumFatigueMileage=sumFatigueMileage;
	}


	public java.math.BigDecimal getSumFatigueTime(){
		return this.sumFatigueTime;
	}

	public void setSumFatigueTime(java.math.BigDecimal sumFatigueTime){
		this.sumFatigueTime=sumFatigueTime;
	}


	public Integer getSumFatigueNum(){
		return this.sumFatigueNum;
	}

	public void setSumFatigueNum(Integer sumFatigueNum){
		this.sumFatigueNum=sumFatigueNum;
	}


	public java.math.BigDecimal getSumSeriousFatigueMileage(){
		return this.sumSeriousFatigueMileage;
	}

	public void setSumSeriousFatigueMileage(java.math.BigDecimal sumSeriousFatigueMileage){
		this.sumSeriousFatigueMileage=sumSeriousFatigueMileage;
	}


	public java.math.BigDecimal getSumSeriousFatigueTime(){
		return this.sumSeriousFatigueTime;
	}

	public void setSumSeriousFatigueTime(java.math.BigDecimal sumSeriousFatigueTime){
		this.sumSeriousFatigueTime=sumSeriousFatigueTime;
	}


	public Integer getSumSeriousFatigueNum(){
		return this.sumSeriousFatigueNum;
	}

	public void setSumSeriousFatigueNum(Integer sumSeriousFatigueNum){
		this.sumSeriousFatigueNum=sumSeriousFatigueNum;
	}


	public java.math.BigDecimal getSumNightFatigueMileage(){
		return this.sumNightFatigueMileage;
	}

	public void setSumNightFatigueMileage(java.math.BigDecimal sumNightFatigueMileage){
		this.sumNightFatigueMileage=sumNightFatigueMileage;
	}


	public java.math.BigDecimal getSumNightFatigueTime(){
		return this.sumNightFatigueTime;
	}

	public void setSumNightFatigueTime(java.math.BigDecimal sumNightFatigueTime){
		this.sumNightFatigueTime=sumNightFatigueTime;
	}


	public Integer getSumNightFatigueNum(){
		return this.sumNightFatigueNum;
	}

	public void setSumNightFatigueNum(Integer sumNightFatigueNum){
		this.sumNightFatigueNum=sumNightFatigueNum;
	}


	public java.math.BigDecimal getNationalFatigueRate(){
		return this.nationalFatigueRate;
	}

	public void setNationalFatigueRate(java.math.BigDecimal nationalFatigueRate){
		this.nationalFatigueRate=nationalFatigueRate;
	}


	public String getNationalfatigueflAg(){
		return this.nationalfatigueflAg;
	}

	public void setNationalfatigueflAg(String nationalfatigueflAg){
		this.nationalfatigueflAg=nationalfatigueflAg;
	}


	public java.math.BigDecimal getHighFatigueRate(){
		return this.highFatigueRate;
	}

	public void setHighFatigueRate(java.math.BigDecimal highFatigueRate){
		this.highFatigueRate=highFatigueRate;
	}


	public String getHighfatigueflAg(){
		return this.highfatigueflAg;
	}

	public void setHighfatigueflAg(String highfatigueflAg){
		this.highfatigueflAg=highfatigueflAg;
	}


	public java.math.BigDecimal getOtherFatigueRate(){
		return this.otherFatigueRate;
	}

	public void setOtherFatigueRate(java.math.BigDecimal otherFatigueRate){
		this.otherFatigueRate=otherFatigueRate;
	}


	public String getOtherfatigueflAg(){
		return this.otherfatigueflAg;
	}

	public void setOtherfatigueflAg(String otherfatigueflAg){
		this.otherfatigueflAg=otherfatigueflAg;
	}


	public java.math.BigDecimal getSeriousFatigueRate(){
		return this.seriousFatigueRate;
	}

	public void setSeriousFatigueRate(java.math.BigDecimal seriousFatigueRate){
		this.seriousFatigueRate=seriousFatigueRate;
	}


	public String getSeriousfatigueflAg(){
		return this.seriousfatigueflAg;
	}

	public void setSeriousfatigueflAg(String seriousfatigueflAg){
		this.seriousfatigueflAg=seriousfatigueflAg;
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
			sb.append(", highFatigueMileage=").append(highFatigueMileage);			
			sb.append(", highFatigueTime=").append(highFatigueTime);			
			sb.append(", highFatigueNum=").append(highFatigueNum);			
			sb.append(", highSeriousFatigueMileage=").append(highSeriousFatigueMileage);			
			sb.append(", highSeriousFatigueTime=").append(highSeriousFatigueTime);			
			sb.append(", highSeriousFatigueNum=").append(highSeriousFatigueNum);			
			sb.append(", highNightFatigueMileage=").append(highNightFatigueMileage);			
			sb.append(", highNightFatigueTime=").append(highNightFatigueTime);			
			sb.append(", highNightFatigueNum=").append(highNightFatigueNum);			
			sb.append(", nationalFatigueMileage=").append(nationalFatigueMileage);			
			sb.append(", nationalFatigueTime=").append(nationalFatigueTime);			
			sb.append(", nationalFatigueNum=").append(nationalFatigueNum);			
			sb.append(", nationalSeriousFatigueMileage=").append(nationalSeriousFatigueMileage);			
			sb.append(", nationalSeriousFatigueTime=").append(nationalSeriousFatigueTime);			
			sb.append(", nationalSeriousFatigueNum=").append(nationalSeriousFatigueNum);			
			sb.append(", nationalNightFatigueMileage=").append(nationalNightFatigueMileage);			
			sb.append(", nationalNightFatigueTime=").append(nationalNightFatigueTime);			
			sb.append(", nationalNightFatigueNum=").append(nationalNightFatigueNum);			
			sb.append(", otherFatigueMileage=").append(otherFatigueMileage);			
			sb.append(", otherFatigueTime=").append(otherFatigueTime);			
			sb.append(", otherFatigueNum=").append(otherFatigueNum);			
			sb.append(", otherSeriousFatigueMileage=").append(otherSeriousFatigueMileage);			
			sb.append(", otherSeriousFatigueTime=").append(otherSeriousFatigueTime);			
			sb.append(", otherSeriousFatigueNum=").append(otherSeriousFatigueNum);			
			sb.append(", otherNightFatigueMileage=").append(otherNightFatigueMileage);			
			sb.append(", otherNightFatigueTime=").append(otherNightFatigueTime);			
			sb.append(", otherNightFatigueNum=").append(otherNightFatigueNum);			
			sb.append(", sumFatigueMileage=").append(sumFatigueMileage);			
			sb.append(", sumFatigueTime=").append(sumFatigueTime);			
			sb.append(", sumFatigueNum=").append(sumFatigueNum);			
			sb.append(", sumSeriousFatigueMileage=").append(sumSeriousFatigueMileage);			
			sb.append(", sumSeriousFatigueTime=").append(sumSeriousFatigueTime);			
			sb.append(", sumSeriousFatigueNum=").append(sumSeriousFatigueNum);			
			sb.append(", sumNightFatigueMileage=").append(sumNightFatigueMileage);			
			sb.append(", sumNightFatigueTime=").append(sumNightFatigueTime);			
			sb.append(", sumNightFatigueNum=").append(sumNightFatigueNum);			
			sb.append(", nationalFatigueRate=").append(nationalFatigueRate);			
			sb.append(", nationalfatigueflAg=").append(nationalfatigueflAg);			
			sb.append(", highFatigueRate=").append(highFatigueRate);			
			sb.append(", highfatigueflAg=").append(highfatigueflAg);			
			sb.append(", otherFatigueRate=").append(otherFatigueRate);			
			sb.append(", otherfatigueflAg=").append(otherfatigueflAg);			
			sb.append(", seriousFatigueRate=").append(seriousFatigueRate);			
			sb.append(", seriousfatigueflAg=").append(seriousfatigueflAg);			
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
        BigdataFatigueAnalysis other = (BigdataFatigueAnalysis) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getHighFatigueMileage() == null ? other.getId() == null : this.getHighFatigueMileage().equals(other.getHighFatigueMileage()))		
				        		&&(this.getHighFatigueTime() == null ? other.getId() == null : this.getHighFatigueTime().equals(other.getHighFatigueTime()))		
				        		&&(this.getHighFatigueNum() == null ? other.getId() == null : this.getHighFatigueNum().equals(other.getHighFatigueNum()))		
				        		&&(this.getHighSeriousFatigueMileage() == null ? other.getId() == null : this.getHighSeriousFatigueMileage().equals(other.getHighSeriousFatigueMileage()))		
				        		&&(this.getHighSeriousFatigueTime() == null ? other.getId() == null : this.getHighSeriousFatigueTime().equals(other.getHighSeriousFatigueTime()))		
				        		&&(this.getHighSeriousFatigueNum() == null ? other.getId() == null : this.getHighSeriousFatigueNum().equals(other.getHighSeriousFatigueNum()))		
				        		&&(this.getHighNightFatigueMileage() == null ? other.getId() == null : this.getHighNightFatigueMileage().equals(other.getHighNightFatigueMileage()))		
				        		&&(this.getHighNightFatigueTime() == null ? other.getId() == null : this.getHighNightFatigueTime().equals(other.getHighNightFatigueTime()))		
				        		&&(this.getHighNightFatigueNum() == null ? other.getId() == null : this.getHighNightFatigueNum().equals(other.getHighNightFatigueNum()))		
				        		&&(this.getNationalFatigueMileage() == null ? other.getId() == null : this.getNationalFatigueMileage().equals(other.getNationalFatigueMileage()))		
				        		&&(this.getNationalFatigueTime() == null ? other.getId() == null : this.getNationalFatigueTime().equals(other.getNationalFatigueTime()))		
				        		&&(this.getNationalFatigueNum() == null ? other.getId() == null : this.getNationalFatigueNum().equals(other.getNationalFatigueNum()))		
				        		&&(this.getNationalSeriousFatigueMileage() == null ? other.getId() == null : this.getNationalSeriousFatigueMileage().equals(other.getNationalSeriousFatigueMileage()))		
				        		&&(this.getNationalSeriousFatigueTime() == null ? other.getId() == null : this.getNationalSeriousFatigueTime().equals(other.getNationalSeriousFatigueTime()))		
				        		&&(this.getNationalSeriousFatigueNum() == null ? other.getId() == null : this.getNationalSeriousFatigueNum().equals(other.getNationalSeriousFatigueNum()))		
				        		&&(this.getNationalNightFatigueMileage() == null ? other.getId() == null : this.getNationalNightFatigueMileage().equals(other.getNationalNightFatigueMileage()))		
				        		&&(this.getNationalNightFatigueTime() == null ? other.getId() == null : this.getNationalNightFatigueTime().equals(other.getNationalNightFatigueTime()))		
				        		&&(this.getNationalNightFatigueNum() == null ? other.getId() == null : this.getNationalNightFatigueNum().equals(other.getNationalNightFatigueNum()))		
				        		&&(this.getOtherFatigueMileage() == null ? other.getId() == null : this.getOtherFatigueMileage().equals(other.getOtherFatigueMileage()))		
				        		&&(this.getOtherFatigueTime() == null ? other.getId() == null : this.getOtherFatigueTime().equals(other.getOtherFatigueTime()))		
				        		&&(this.getOtherFatigueNum() == null ? other.getId() == null : this.getOtherFatigueNum().equals(other.getOtherFatigueNum()))		
				        		&&(this.getOtherSeriousFatigueMileage() == null ? other.getId() == null : this.getOtherSeriousFatigueMileage().equals(other.getOtherSeriousFatigueMileage()))		
				        		&&(this.getOtherSeriousFatigueTime() == null ? other.getId() == null : this.getOtherSeriousFatigueTime().equals(other.getOtherSeriousFatigueTime()))		
				        		&&(this.getOtherSeriousFatigueNum() == null ? other.getId() == null : this.getOtherSeriousFatigueNum().equals(other.getOtherSeriousFatigueNum()))		
				        		&&(this.getOtherNightFatigueMileage() == null ? other.getId() == null : this.getOtherNightFatigueMileage().equals(other.getOtherNightFatigueMileage()))		
				        		&&(this.getOtherNightFatigueTime() == null ? other.getId() == null : this.getOtherNightFatigueTime().equals(other.getOtherNightFatigueTime()))		
				        		&&(this.getOtherNightFatigueNum() == null ? other.getId() == null : this.getOtherNightFatigueNum().equals(other.getOtherNightFatigueNum()))		
				        		&&(this.getSumFatigueMileage() == null ? other.getId() == null : this.getSumFatigueMileage().equals(other.getSumFatigueMileage()))		
				        		&&(this.getSumFatigueTime() == null ? other.getId() == null : this.getSumFatigueTime().equals(other.getSumFatigueTime()))		
				        		&&(this.getSumFatigueNum() == null ? other.getId() == null : this.getSumFatigueNum().equals(other.getSumFatigueNum()))		
				        		&&(this.getSumSeriousFatigueMileage() == null ? other.getId() == null : this.getSumSeriousFatigueMileage().equals(other.getSumSeriousFatigueMileage()))		
				        		&&(this.getSumSeriousFatigueTime() == null ? other.getId() == null : this.getSumSeriousFatigueTime().equals(other.getSumSeriousFatigueTime()))		
				        		&&(this.getSumSeriousFatigueNum() == null ? other.getId() == null : this.getSumSeriousFatigueNum().equals(other.getSumSeriousFatigueNum()))		
				        		&&(this.getSumNightFatigueMileage() == null ? other.getId() == null : this.getSumNightFatigueMileage().equals(other.getSumNightFatigueMileage()))		
				        		&&(this.getSumNightFatigueTime() == null ? other.getId() == null : this.getSumNightFatigueTime().equals(other.getSumNightFatigueTime()))		
				        		&&(this.getSumNightFatigueNum() == null ? other.getId() == null : this.getSumNightFatigueNum().equals(other.getSumNightFatigueNum()))		
				        		&&(this.getNationalFatigueRate() == null ? other.getId() == null : this.getNationalFatigueRate().equals(other.getNationalFatigueRate()))		
				        		&&(this.getNationalfatigueflAg() == null ? other.getId() == null : this.getNationalfatigueflAg().equals(other.getNationalfatigueflAg()))		
				        		&&(this.getHighFatigueRate() == null ? other.getId() == null : this.getHighFatigueRate().equals(other.getHighFatigueRate()))		
				        		&&(this.getHighfatigueflAg() == null ? other.getId() == null : this.getHighfatigueflAg().equals(other.getHighfatigueflAg()))		
				        		&&(this.getOtherFatigueRate() == null ? other.getId() == null : this.getOtherFatigueRate().equals(other.getOtherFatigueRate()))		
				        		&&(this.getOtherfatigueflAg() == null ? other.getId() == null : this.getOtherfatigueflAg().equals(other.getOtherfatigueflAg()))		
				        		&&(this.getSeriousFatigueRate() == null ? other.getId() == null : this.getSeriousFatigueRate().equals(other.getSeriousFatigueRate()))		
				        		&&(this.getSeriousfatigueflAg() == null ? other.getId() == null : this.getSeriousfatigueflAg().equals(other.getSeriousfatigueflAg()))		
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
		        result = prime * result + ((getHighFatigueMileage() == null) ? 0 : getHighFatigueMileage().hashCode());		
		        result = prime * result + ((getHighFatigueTime() == null) ? 0 : getHighFatigueTime().hashCode());		
		        result = prime * result + ((getHighFatigueNum() == null) ? 0 : getHighFatigueNum().hashCode());		
		        result = prime * result + ((getHighSeriousFatigueMileage() == null) ? 0 : getHighSeriousFatigueMileage().hashCode());		
		        result = prime * result + ((getHighSeriousFatigueTime() == null) ? 0 : getHighSeriousFatigueTime().hashCode());		
		        result = prime * result + ((getHighSeriousFatigueNum() == null) ? 0 : getHighSeriousFatigueNum().hashCode());		
		        result = prime * result + ((getHighNightFatigueMileage() == null) ? 0 : getHighNightFatigueMileage().hashCode());		
		        result = prime * result + ((getHighNightFatigueTime() == null) ? 0 : getHighNightFatigueTime().hashCode());		
		        result = prime * result + ((getHighNightFatigueNum() == null) ? 0 : getHighNightFatigueNum().hashCode());		
		        result = prime * result + ((getNationalFatigueMileage() == null) ? 0 : getNationalFatigueMileage().hashCode());		
		        result = prime * result + ((getNationalFatigueTime() == null) ? 0 : getNationalFatigueTime().hashCode());		
		        result = prime * result + ((getNationalFatigueNum() == null) ? 0 : getNationalFatigueNum().hashCode());		
		        result = prime * result + ((getNationalSeriousFatigueMileage() == null) ? 0 : getNationalSeriousFatigueMileage().hashCode());		
		        result = prime * result + ((getNationalSeriousFatigueTime() == null) ? 0 : getNationalSeriousFatigueTime().hashCode());		
		        result = prime * result + ((getNationalSeriousFatigueNum() == null) ? 0 : getNationalSeriousFatigueNum().hashCode());		
		        result = prime * result + ((getNationalNightFatigueMileage() == null) ? 0 : getNationalNightFatigueMileage().hashCode());		
		        result = prime * result + ((getNationalNightFatigueTime() == null) ? 0 : getNationalNightFatigueTime().hashCode());		
		        result = prime * result + ((getNationalNightFatigueNum() == null) ? 0 : getNationalNightFatigueNum().hashCode());		
		        result = prime * result + ((getOtherFatigueMileage() == null) ? 0 : getOtherFatigueMileage().hashCode());		
		        result = prime * result + ((getOtherFatigueTime() == null) ? 0 : getOtherFatigueTime().hashCode());		
		        result = prime * result + ((getOtherFatigueNum() == null) ? 0 : getOtherFatigueNum().hashCode());		
		        result = prime * result + ((getOtherSeriousFatigueMileage() == null) ? 0 : getOtherSeriousFatigueMileage().hashCode());		
		        result = prime * result + ((getOtherSeriousFatigueTime() == null) ? 0 : getOtherSeriousFatigueTime().hashCode());		
		        result = prime * result + ((getOtherSeriousFatigueNum() == null) ? 0 : getOtherSeriousFatigueNum().hashCode());		
		        result = prime * result + ((getOtherNightFatigueMileage() == null) ? 0 : getOtherNightFatigueMileage().hashCode());		
		        result = prime * result + ((getOtherNightFatigueTime() == null) ? 0 : getOtherNightFatigueTime().hashCode());		
		        result = prime * result + ((getOtherNightFatigueNum() == null) ? 0 : getOtherNightFatigueNum().hashCode());		
		        result = prime * result + ((getSumFatigueMileage() == null) ? 0 : getSumFatigueMileage().hashCode());		
		        result = prime * result + ((getSumFatigueTime() == null) ? 0 : getSumFatigueTime().hashCode());		
		        result = prime * result + ((getSumFatigueNum() == null) ? 0 : getSumFatigueNum().hashCode());		
		        result = prime * result + ((getSumSeriousFatigueMileage() == null) ? 0 : getSumSeriousFatigueMileage().hashCode());		
		        result = prime * result + ((getSumSeriousFatigueTime() == null) ? 0 : getSumSeriousFatigueTime().hashCode());		
		        result = prime * result + ((getSumSeriousFatigueNum() == null) ? 0 : getSumSeriousFatigueNum().hashCode());		
		        result = prime * result + ((getSumNightFatigueMileage() == null) ? 0 : getSumNightFatigueMileage().hashCode());		
		        result = prime * result + ((getSumNightFatigueTime() == null) ? 0 : getSumNightFatigueTime().hashCode());		
		        result = prime * result + ((getSumNightFatigueNum() == null) ? 0 : getSumNightFatigueNum().hashCode());		
		        result = prime * result + ((getNationalFatigueRate() == null) ? 0 : getNationalFatigueRate().hashCode());		
		        result = prime * result + ((getNationalfatigueflAg() == null) ? 0 : getNationalfatigueflAg().hashCode());		
		        result = prime * result + ((getHighFatigueRate() == null) ? 0 : getHighFatigueRate().hashCode());		
		        result = prime * result + ((getHighfatigueflAg() == null) ? 0 : getHighfatigueflAg().hashCode());		
		        result = prime * result + ((getOtherFatigueRate() == null) ? 0 : getOtherFatigueRate().hashCode());		
		        result = prime * result + ((getOtherfatigueflAg() == null) ? 0 : getOtherfatigueflAg().hashCode());		
		        result = prime * result + ((getSeriousFatigueRate() == null) ? 0 : getSeriousFatigueRate().hashCode());		
		        result = prime * result + ((getSeriousfatigueflAg() == null) ? 0 : getSeriousfatigueflAg().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		;
        return result;
    }

}
