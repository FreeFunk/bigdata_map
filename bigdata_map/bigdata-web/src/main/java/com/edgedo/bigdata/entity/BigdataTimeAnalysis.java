package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_time_analysis")
public class BigdataTimeAnalysis implements Serializable{


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
     * 属性描述:清晨里程
     */
    @TableField(value="EARLY_MORNING_MILEAGE",exist=true)
    java.math.BigDecimal earlyMorningMileage;

    /**
     * 属性描述:清晨时长
     */
    @TableField(value="EARLY_MORNING_TIME",exist=true)
    java.math.BigDecimal earlyMorningTime;

    /**
     * 属性描述:中午里程
     */
    @TableField(value="NOON_MILEAGE",exist=true)
    java.math.BigDecimal noonMileage;

    /**
     * 属性描述:中午时长
     */
    @TableField(value="NOON_TIME",exist=true)
    java.math.BigDecimal noonTime;

    /**
     * 属性描述:黄昏里程
     */
    @TableField(value="DUSK_MILEAGE",exist=true)
    java.math.BigDecimal duskMileage;

    /**
     * 属性描述:黄昏时长
     */
    @TableField(value="DUSK_TIME",exist=true)
    java.math.BigDecimal duskTime;

    /**
     * 属性描述:夜间里程
     */
    @TableField(value="NIGHT_MILEAGE",exist=true)
    java.math.BigDecimal nightMileage;

    /**
     * 属性描述:夜间时长
     */
    @TableField(value="NIGHT_TIME",exist=true)
    java.math.BigDecimal nightTime;

    /**
     * 属性描述:凌晨里程
     */
    @TableField(value="LINGCHEN_MILEAGE",exist=true)
    java.math.BigDecimal lingchenMileage;

    /**
     * 属性描述:凌晨时长
     */
    @TableField(value="LINGCHEN_TIME",exist=true)
    java.math.BigDecimal lingchenTime;

    /**
     * 属性描述:清晨里程占比
     */
    @TableField(value="EARLY_MORNING_MILEAGE_RATE",exist=true)
    java.math.BigDecimal earlyMorningMileageRate;

    /**
     * 属性描述:清晨里程标识
     */
    @TableField(value="EARLY_MORNING_MILEAGE_FLAG",exist=true)
    java.math.BigDecimal earlyMorningMileageFlag;

    /**
     * 属性描述:清晨时长占比
     */
    @TableField(value="EARLY_MORNING_TIME_RATE",exist=true)
    java.math.BigDecimal earlyMorningTimeRate;

    /**
     * 属性描述:清晨时长标识
     */
    @TableField(value="EARLY_MORNING_TIME_FLAG",exist=true)
    java.math.BigDecimal earlyMorningTimeFlag;

    /**
     * 属性描述:中午里程占比
     */
    @TableField(value="NOON_MILEAGE_RATE",exist=true)
    java.math.BigDecimal noonMileageRate;

    /**
     * 属性描述:中午里程标识
     */
    @TableField(value="NOON_MILEAGE_FLAG",exist=true)
    java.math.BigDecimal noonMileageFlag;

    /**
     * 属性描述:中午时长占比
     */
    @TableField(value="NOON_TIME_RATE",exist=true)
    java.math.BigDecimal noonTimeRate;

    /**
     * 属性描述:中午时长标识
     */
    @TableField(value="NOON_TIME_FLAG",exist=true)
    java.math.BigDecimal noonTimeFlag;

    /**
     * 属性描述:黄昏里程占比
     */
    @TableField(value="DUSK_MILEAGE_RETE",exist=true)
    java.math.BigDecimal duskMileageRete;

    /**
     * 属性描述:黄昏里程标识
     */
    @TableField(value="DUSK_MILEAGE_FLAG",exist=true)
    java.math.BigDecimal duskMileageFlag;

    /**
     * 属性描述:黄昏时长占比
     */
    @TableField(value="DUSK_TIME_RATE",exist=true)
    java.math.BigDecimal duskTimeRate;

    /**
     * 属性描述:黄昏时长标识
     */
    @TableField(value="DUSK_TIME_FLAG",exist=true)
    java.math.BigDecimal duskTimeFlag;

    /**
     * 属性描述:夜间里程占比
     */
    @TableField(value="NIGHT_MILEAGE_RATE",exist=true)
    java.math.BigDecimal nightMileageRate;

    /**
     * 属性描述:夜间里程标识
     */
    @TableField(value="NIGHT_MILEAGE_FLAG",exist=true)
    java.math.BigDecimal nightMileageFlag;

    /**
     * 属性描述:夜间时长占比
     */
    @TableField(value="NIGHT_TIME_RATE",exist=true)
    java.math.BigDecimal nightTimeRate;

    /**
     * 属性描述:夜间时长标识
     */
    @TableField(value="NIGHT_TIME_FLAG",exist=true)
    java.math.BigDecimal nightTimeFlag;

    /**
     * 属性描述:凌晨时长占比
     */
    @TableField(value="LINGCHEN_TIME_RATE",exist=true)
    java.math.BigDecimal lingchenTimeRate;

    /**
     * 属性描述:凌晨时长标识
     */
    @TableField(value="LINGCHEN_TIME_FLAG",exist=true)
    java.math.BigDecimal lingchenTimeFlag;

    /**
     * 属性描述:凌晨里程占比
     */
    @TableField(value="LINGCHEN_MILEAGE_RATE",exist=true)
    java.math.BigDecimal lingchenMileageRate;

    /**
     * 属性描述:凌晨里程标识
     */
    @TableField(value="LINGCHEN_MILEAGE_FLAG",exist=true)
    java.math.BigDecimal lingchenMileageFlag;

    /**
     * 属性描述:总里程
     */
    @TableField(value="SUM_MILEAGE",exist=true)
    java.math.BigDecimal sumMileage;

    /**
     * 属性描述:总时长
     */
    @TableField(value="SUM_DURATION",exist=true)
    java.math.BigDecimal sumDuration;

    /**
     * 属性描述:车辆类型
     */
    @TableField(value="CAR_TYPE",exist=true)
    java.lang.String carType;

    /**
     * 属性描述:统计时间
     */
    @TableField(value="COUNT_TIME",exist=true)
    java.util.Date countTime;

    /**
     * 属性描述:一类危险时段
     */
    @TableField(value="FIRST_DANGER_TIME_NUM",exist=true)
    java.lang.Integer firstDangerTimeNum;

    /**
     * 属性描述:二类危险时段
     */
    @TableField(value="SECOND_DANGER_TIME_NUM",exist=true)
    java.lang.Integer secondDangerTimeNum;

    /**
     * 属性描述:三类危险时段
     */
    @TableField(value="THIRD_DANGER_TIME_NUM",exist=true)
    java.lang.Integer thirdDangerTimeNum;

    /**
     * 属性描述:月份
     */
    @TableField(value="COUNT_MONTH",exist=true)
    java.lang.Integer countMonth;

    /**
     * 属性描述:统计日期
     */
    @TableField(value="COUNT_DATE",exist=true)
    java.lang.Integer countDate;

    /**
     * 属性描述:firstDangerMileage
     */
    @TableField(value="FIRST_DANGER_MILEAGE",exist=true)
    java.math.BigDecimal firstDangerMileage;

    /**
     * 属性描述:secondDangerMileage
     */
    @TableField(value="SECOND_DANGER_MILEAGE",exist=true)
    java.math.BigDecimal secondDangerMileage;

    /**
     * 属性描述:thirdDangerMileage
     */
    @TableField(value="THIRD_DANGER_MILEAGE",exist=true)
    java.math.BigDecimal thirdDangerMileage;






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


    public java.math.BigDecimal getEarlyMorningMileage(){
        return this.earlyMorningMileage;
    }

    public void setEarlyMorningMileage(java.math.BigDecimal earlyMorningMileage){
        this.earlyMorningMileage=earlyMorningMileage;
    }


    public java.math.BigDecimal getEarlyMorningTime(){
        return this.earlyMorningTime;
    }

    public void setEarlyMorningTime(java.math.BigDecimal earlyMorningTime){
        this.earlyMorningTime=earlyMorningTime;
    }


    public java.math.BigDecimal getNoonMileage(){
        return this.noonMileage;
    }

    public void setNoonMileage(java.math.BigDecimal noonMileage){
        this.noonMileage=noonMileage;
    }


    public java.math.BigDecimal getNoonTime(){
        return this.noonTime;
    }

    public void setNoonTime(java.math.BigDecimal noonTime){
        this.noonTime=noonTime;
    }


    public java.math.BigDecimal getDuskMileage(){
        return this.duskMileage;
    }

    public void setDuskMileage(java.math.BigDecimal duskMileage){
        this.duskMileage=duskMileage;
    }


    public java.math.BigDecimal getDuskTime(){
        return this.duskTime;
    }

    public void setDuskTime(java.math.BigDecimal duskTime){
        this.duskTime=duskTime;
    }


    public java.math.BigDecimal getNightMileage(){
        return this.nightMileage;
    }

    public void setNightMileage(java.math.BigDecimal nightMileage){
        this.nightMileage=nightMileage;
    }


    public java.math.BigDecimal getNightTime(){
        return this.nightTime;
    }

    public void setNightTime(java.math.BigDecimal nightTime){
        this.nightTime=nightTime;
    }


    public java.math.BigDecimal getLingchenMileage(){
        return this.lingchenMileage;
    }

    public void setLingchenMileage(java.math.BigDecimal lingchenMileage){
        this.lingchenMileage=lingchenMileage;
    }


    public java.math.BigDecimal getLingchenTime(){
        return this.lingchenTime;
    }

    public void setLingchenTime(java.math.BigDecimal lingchenTime){
        this.lingchenTime=lingchenTime;
    }


    public java.math.BigDecimal getEarlyMorningMileageRate(){
        return this.earlyMorningMileageRate;
    }

    public void setEarlyMorningMileageRate(java.math.BigDecimal earlyMorningMileageRate){
        this.earlyMorningMileageRate=earlyMorningMileageRate;
    }


    public java.math.BigDecimal getEarlyMorningMileageFlag(){
        return this.earlyMorningMileageFlag;
    }

    public void setEarlyMorningMileageFlag(java.math.BigDecimal earlyMorningMileageFlag){
        this.earlyMorningMileageFlag=earlyMorningMileageFlag;
    }


    public java.math.BigDecimal getEarlyMorningTimeRate(){
        return this.earlyMorningTimeRate;
    }

    public void setEarlyMorningTimeRate(java.math.BigDecimal earlyMorningTimeRate){
        this.earlyMorningTimeRate=earlyMorningTimeRate;
    }


    public java.math.BigDecimal getEarlyMorningTimeFlag(){
        return this.earlyMorningTimeFlag;
    }

    public void setEarlyMorningTimeFlag(java.math.BigDecimal earlyMorningTimeFlag){
        this.earlyMorningTimeFlag=earlyMorningTimeFlag;
    }


    public java.math.BigDecimal getNoonMileageRate(){
        return this.noonMileageRate;
    }

    public void setNoonMileageRate(java.math.BigDecimal noonMileageRate){
        this.noonMileageRate=noonMileageRate;
    }


    public java.math.BigDecimal getNoonMileageFlag(){
        return this.noonMileageFlag;
    }

    public void setNoonMileageFlag(java.math.BigDecimal noonMileageFlag){
        this.noonMileageFlag=noonMileageFlag;
    }


    public java.math.BigDecimal getNoonTimeRate(){
        return this.noonTimeRate;
    }

    public void setNoonTimeRate(java.math.BigDecimal noonTimeRate){
        this.noonTimeRate=noonTimeRate;
    }


    public java.math.BigDecimal getNoonTimeFlag(){
        return this.noonTimeFlag;
    }

    public void setNoonTimeFlag(java.math.BigDecimal noonTimeFlag){
        this.noonTimeFlag=noonTimeFlag;
    }


    public java.math.BigDecimal getDuskMileageRete(){
        return this.duskMileageRete;
    }

    public void setDuskMileageRete(java.math.BigDecimal duskMileageRete){
        this.duskMileageRete=duskMileageRete;
    }


    public java.math.BigDecimal getDuskMileageFlag(){
        return this.duskMileageFlag;
    }

    public void setDuskMileageFlag(java.math.BigDecimal duskMileageFlag){
        this.duskMileageFlag=duskMileageFlag;
    }


    public java.math.BigDecimal getDuskTimeRate(){
        return this.duskTimeRate;
    }

    public void setDuskTimeRate(java.math.BigDecimal duskTimeRate){
        this.duskTimeRate=duskTimeRate;
    }


    public java.math.BigDecimal getDuskTimeFlag(){
        return this.duskTimeFlag;
    }

    public void setDuskTimeFlag(java.math.BigDecimal duskTimeFlag){
        this.duskTimeFlag=duskTimeFlag;
    }


    public java.math.BigDecimal getNightMileageRate(){
        return this.nightMileageRate;
    }

    public void setNightMileageRate(java.math.BigDecimal nightMileageRate){
        this.nightMileageRate=nightMileageRate;
    }


    public java.math.BigDecimal getNightMileageFlag(){
        return this.nightMileageFlag;
    }

    public void setNightMileageFlag(java.math.BigDecimal nightMileageFlag){
        this.nightMileageFlag=nightMileageFlag;
    }


    public java.math.BigDecimal getNightTimeRate(){
        return this.nightTimeRate;
    }

    public void setNightTimeRate(java.math.BigDecimal nightTimeRate){
        this.nightTimeRate=nightTimeRate;
    }


    public java.math.BigDecimal getNightTimeFlag(){
        return this.nightTimeFlag;
    }

    public void setNightTimeFlag(java.math.BigDecimal nightTimeFlag){
        this.nightTimeFlag=nightTimeFlag;
    }


    public java.math.BigDecimal getLingchenTimeRate(){
        return this.lingchenTimeRate;
    }

    public void setLingchenTimeRate(java.math.BigDecimal lingchenTimeRate){
        this.lingchenTimeRate=lingchenTimeRate;
    }


    public java.math.BigDecimal getLingchenTimeFlag(){
        return this.lingchenTimeFlag;
    }

    public void setLingchenTimeFlag(java.math.BigDecimal lingchenTimeFlag){
        this.lingchenTimeFlag=lingchenTimeFlag;
    }


    public java.math.BigDecimal getLingchenMileageRate(){
        return this.lingchenMileageRate;
    }

    public void setLingchenMileageRate(java.math.BigDecimal lingchenMileageRate){
        this.lingchenMileageRate=lingchenMileageRate;
    }


    public java.math.BigDecimal getLingchenMileageFlag(){
        return this.lingchenMileageFlag;
    }

    public void setLingchenMileageFlag(java.math.BigDecimal lingchenMileageFlag){
        this.lingchenMileageFlag=lingchenMileageFlag;
    }


    public java.math.BigDecimal getSumMileage(){
        return this.sumMileage;
    }

    public void setSumMileage(java.math.BigDecimal sumMileage){
        this.sumMileage=sumMileage;
    }


    public java.math.BigDecimal getSumDuration(){
        return this.sumDuration;
    }

    public void setSumDuration(java.math.BigDecimal sumDuration){
        this.sumDuration=sumDuration;
    }


    public java.lang.String getCarType(){
        return this.carType;
    }

    public void setCarType(java.lang.String carType){
        this.carType=carType;
    }


    public java.util.Date getCountTime(){
        return this.countTime;
    }

    public void setCountTime(java.util.Date countTime){
        this.countTime=countTime;
    }


    public java.lang.Integer getFirstDangerTimeNum(){
        return this.firstDangerTimeNum;
    }

    public void setFirstDangerTimeNum(java.lang.Integer firstDangerTimeNum){
        this.firstDangerTimeNum=firstDangerTimeNum;
    }


    public java.lang.Integer getSecondDangerTimeNum(){
        return this.secondDangerTimeNum;
    }

    public void setSecondDangerTimeNum(java.lang.Integer secondDangerTimeNum){
        this.secondDangerTimeNum=secondDangerTimeNum;
    }


    public java.lang.Integer getThirdDangerTimeNum(){
        return this.thirdDangerTimeNum;
    }

    public void setThirdDangerTimeNum(java.lang.Integer thirdDangerTimeNum){
        this.thirdDangerTimeNum=thirdDangerTimeNum;
    }


    public java.lang.Integer getCountMonth(){
        return this.countMonth;
    }

    public void setCountMonth(java.lang.Integer countMonth){
        this.countMonth=countMonth;
    }


    public java.lang.Integer getCountDate(){
        return this.countDate;
    }

    public void setCountDate(java.lang.Integer countDate){
        this.countDate=countDate;
    }


    public java.math.BigDecimal getFirstDangerMileage(){
        return this.firstDangerMileage;
    }

    public void setFirstDangerMileage(java.math.BigDecimal firstDangerMileage){
        this.firstDangerMileage=firstDangerMileage;
    }


    public java.math.BigDecimal getSecondDangerMileage(){
        return this.secondDangerMileage;
    }

    public void setSecondDangerMileage(java.math.BigDecimal secondDangerMileage){
        this.secondDangerMileage=secondDangerMileage;
    }


    public java.math.BigDecimal getThirdDangerMileage(){
        return this.thirdDangerMileage;
    }

    public void setThirdDangerMileage(java.math.BigDecimal thirdDangerMileage){
        this.thirdDangerMileage=thirdDangerMileage;
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", earlyMorningMileage=").append(earlyMorningMileage);			
			sb.append(", earlyMorningTime=").append(earlyMorningTime);			
			sb.append(", noonMileage=").append(noonMileage);			
			sb.append(", noonTime=").append(noonTime);			
			sb.append(", duskMileage=").append(duskMileage);			
			sb.append(", duskTime=").append(duskTime);			
			sb.append(", nightMileage=").append(nightMileage);			
			sb.append(", nightTime=").append(nightTime);			
			sb.append(", lingchenMileage=").append(lingchenMileage);			
			sb.append(", lingchenTime=").append(lingchenTime);			
			sb.append(", earlyMorningMileageRate=").append(earlyMorningMileageRate);			
			sb.append(", earlyMorningMileageFlag=").append(earlyMorningMileageFlag);			
			sb.append(", earlyMorningTimeRate=").append(earlyMorningTimeRate);			
			sb.append(", earlyMorningTimeFlag=").append(earlyMorningTimeFlag);			
			sb.append(", noonMileageRate=").append(noonMileageRate);			
			sb.append(", noonMileageFlag=").append(noonMileageFlag);			
			sb.append(", noonTimeRate=").append(noonTimeRate);			
			sb.append(", noonTimeFlag=").append(noonTimeFlag);			
			sb.append(", duskMileageRete=").append(duskMileageRete);			
			sb.append(", duskMileageFlag=").append(duskMileageFlag);			
			sb.append(", duskTimeRate=").append(duskTimeRate);			
			sb.append(", duskTimeFlag=").append(duskTimeFlag);			
			sb.append(", nightMileageRate=").append(nightMileageRate);			
			sb.append(", nightMileageFlag=").append(nightMileageFlag);			
			sb.append(", nightTimeRate=").append(nightTimeRate);			
			sb.append(", nightTimeFlag=").append(nightTimeFlag);			
			sb.append(", lingchenTimeRate=").append(lingchenTimeRate);			
			sb.append(", lingchenTimeFlag=").append(lingchenTimeFlag);			
			sb.append(", lingchenMileageRate=").append(lingchenMileageRate);			
			sb.append(", lingchenMileageFlag=").append(lingchenMileageFlag);			
			sb.append(", sumMileage=").append(sumMileage);			
			sb.append(", sumDuration=").append(sumDuration);			
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
        BigdataTimeAnalysis other = (BigdataTimeAnalysis) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getEarlyMorningMileage() == null ? other.getId() == null : this.getEarlyMorningMileage().equals(other.getEarlyMorningMileage()))		
				        		&&(this.getEarlyMorningTime() == null ? other.getId() == null : this.getEarlyMorningTime().equals(other.getEarlyMorningTime()))		
				        		&&(this.getNoonMileage() == null ? other.getId() == null : this.getNoonMileage().equals(other.getNoonMileage()))		
				        		&&(this.getNoonTime() == null ? other.getId() == null : this.getNoonTime().equals(other.getNoonTime()))		
				        		&&(this.getDuskMileage() == null ? other.getId() == null : this.getDuskMileage().equals(other.getDuskMileage()))		
				        		&&(this.getDuskTime() == null ? other.getId() == null : this.getDuskTime().equals(other.getDuskTime()))		
				        		&&(this.getNightMileage() == null ? other.getId() == null : this.getNightMileage().equals(other.getNightMileage()))		
				        		&&(this.getNightTime() == null ? other.getId() == null : this.getNightTime().equals(other.getNightTime()))		
				        		&&(this.getLingchenMileage() == null ? other.getId() == null : this.getLingchenMileage().equals(other.getLingchenMileage()))		
				        		&&(this.getLingchenTime() == null ? other.getId() == null : this.getLingchenTime().equals(other.getLingchenTime()))		
				        		&&(this.getEarlyMorningMileageRate() == null ? other.getId() == null : this.getEarlyMorningMileageRate().equals(other.getEarlyMorningMileageRate()))		
				        		&&(this.getEarlyMorningMileageFlag() == null ? other.getId() == null : this.getEarlyMorningMileageFlag().equals(other.getEarlyMorningMileageFlag()))		
				        		&&(this.getEarlyMorningTimeRate() == null ? other.getId() == null : this.getEarlyMorningTimeRate().equals(other.getEarlyMorningTimeRate()))		
				        		&&(this.getEarlyMorningTimeFlag() == null ? other.getId() == null : this.getEarlyMorningTimeFlag().equals(other.getEarlyMorningTimeFlag()))		
				        		&&(this.getNoonMileageRate() == null ? other.getId() == null : this.getNoonMileageRate().equals(other.getNoonMileageRate()))		
				        		&&(this.getNoonMileageFlag() == null ? other.getId() == null : this.getNoonMileageFlag().equals(other.getNoonMileageFlag()))		
				        		&&(this.getNoonTimeRate() == null ? other.getId() == null : this.getNoonTimeRate().equals(other.getNoonTimeRate()))		
				        		&&(this.getNoonTimeFlag() == null ? other.getId() == null : this.getNoonTimeFlag().equals(other.getNoonTimeFlag()))		
				        		&&(this.getDuskMileageRete() == null ? other.getId() == null : this.getDuskMileageRete().equals(other.getDuskMileageRete()))		
				        		&&(this.getDuskMileageFlag() == null ? other.getId() == null : this.getDuskMileageFlag().equals(other.getDuskMileageFlag()))		
				        		&&(this.getDuskTimeRate() == null ? other.getId() == null : this.getDuskTimeRate().equals(other.getDuskTimeRate()))		
				        		&&(this.getDuskTimeFlag() == null ? other.getId() == null : this.getDuskTimeFlag().equals(other.getDuskTimeFlag()))		
				        		&&(this.getNightMileageRate() == null ? other.getId() == null : this.getNightMileageRate().equals(other.getNightMileageRate()))		
				        		&&(this.getNightMileageFlag() == null ? other.getId() == null : this.getNightMileageFlag().equals(other.getNightMileageFlag()))		
				        		&&(this.getNightTimeRate() == null ? other.getId() == null : this.getNightTimeRate().equals(other.getNightTimeRate()))		
				        		&&(this.getNightTimeFlag() == null ? other.getId() == null : this.getNightTimeFlag().equals(other.getNightTimeFlag()))		
				        		&&(this.getLingchenTimeRate() == null ? other.getId() == null : this.getLingchenTimeRate().equals(other.getLingchenTimeRate()))		
				        		&&(this.getLingchenTimeFlag() == null ? other.getId() == null : this.getLingchenTimeFlag().equals(other.getLingchenTimeFlag()))		
				        		&&(this.getLingchenMileageRate() == null ? other.getId() == null : this.getLingchenMileageRate().equals(other.getLingchenMileageRate()))		
				        		&&(this.getLingchenMileageFlag() == null ? other.getId() == null : this.getLingchenMileageFlag().equals(other.getLingchenMileageFlag()))		
				        		&&(this.getSumMileage() == null ? other.getId() == null : this.getSumMileage().equals(other.getSumMileage()))		
				        		&&(this.getSumDuration() == null ? other.getId() == null : this.getSumDuration().equals(other.getSumDuration()))		
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
		        result = prime * result + ((getEarlyMorningMileage() == null) ? 0 : getEarlyMorningMileage().hashCode());		
		        result = prime * result + ((getEarlyMorningTime() == null) ? 0 : getEarlyMorningTime().hashCode());		
		        result = prime * result + ((getNoonMileage() == null) ? 0 : getNoonMileage().hashCode());		
		        result = prime * result + ((getNoonTime() == null) ? 0 : getNoonTime().hashCode());		
		        result = prime * result + ((getDuskMileage() == null) ? 0 : getDuskMileage().hashCode());		
		        result = prime * result + ((getDuskTime() == null) ? 0 : getDuskTime().hashCode());		
		        result = prime * result + ((getNightMileage() == null) ? 0 : getNightMileage().hashCode());		
		        result = prime * result + ((getNightTime() == null) ? 0 : getNightTime().hashCode());		
		        result = prime * result + ((getLingchenMileage() == null) ? 0 : getLingchenMileage().hashCode());		
		        result = prime * result + ((getLingchenTime() == null) ? 0 : getLingchenTime().hashCode());		
		        result = prime * result + ((getEarlyMorningMileageRate() == null) ? 0 : getEarlyMorningMileageRate().hashCode());		
		        result = prime * result + ((getEarlyMorningMileageFlag() == null) ? 0 : getEarlyMorningMileageFlag().hashCode());		
		        result = prime * result + ((getEarlyMorningTimeRate() == null) ? 0 : getEarlyMorningTimeRate().hashCode());		
		        result = prime * result + ((getEarlyMorningTimeFlag() == null) ? 0 : getEarlyMorningTimeFlag().hashCode());		
		        result = prime * result + ((getNoonMileageRate() == null) ? 0 : getNoonMileageRate().hashCode());		
		        result = prime * result + ((getNoonMileageFlag() == null) ? 0 : getNoonMileageFlag().hashCode());		
		        result = prime * result + ((getNoonTimeRate() == null) ? 0 : getNoonTimeRate().hashCode());		
		        result = prime * result + ((getNoonTimeFlag() == null) ? 0 : getNoonTimeFlag().hashCode());		
		        result = prime * result + ((getDuskMileageRete() == null) ? 0 : getDuskMileageRete().hashCode());		
		        result = prime * result + ((getDuskMileageFlag() == null) ? 0 : getDuskMileageFlag().hashCode());		
		        result = prime * result + ((getDuskTimeRate() == null) ? 0 : getDuskTimeRate().hashCode());		
		        result = prime * result + ((getDuskTimeFlag() == null) ? 0 : getDuskTimeFlag().hashCode());		
		        result = prime * result + ((getNightMileageRate() == null) ? 0 : getNightMileageRate().hashCode());		
		        result = prime * result + ((getNightMileageFlag() == null) ? 0 : getNightMileageFlag().hashCode());		
		        result = prime * result + ((getNightTimeRate() == null) ? 0 : getNightTimeRate().hashCode());		
		        result = prime * result + ((getNightTimeFlag() == null) ? 0 : getNightTimeFlag().hashCode());		
		        result = prime * result + ((getLingchenTimeRate() == null) ? 0 : getLingchenTimeRate().hashCode());		
		        result = prime * result + ((getLingchenTimeFlag() == null) ? 0 : getLingchenTimeFlag().hashCode());		
		        result = prime * result + ((getLingchenMileageRate() == null) ? 0 : getLingchenMileageRate().hashCode());		
		        result = prime * result + ((getLingchenMileageFlag() == null) ? 0 : getLingchenMileageFlag().hashCode());		
		        result = prime * result + ((getSumMileage() == null) ? 0 : getSumMileage().hashCode());		
		        result = prime * result + ((getSumDuration() == null) ? 0 : getSumDuration().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		;
        return result;
    }

}
