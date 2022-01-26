package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("bigdata_beidou_comp_month_check")
public class BigdataBeidouCompMonthCheck implements Serializable{
	
		
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
	 * 属性描述:运营商类型
	 */
	@TableField(value="COMP_FLAG",exist=true)
	String compFlag;

	/**
	 * 属性描述:得分
	 */
	@TableField(value="SCORE",exist=true)
	java.math.BigDecimal score;

	/**
	 * 属性描述:车辆总数
	 */
	@TableField(value="CAR_NUM",exist=true)
	Integer carNum;

	/**
	 * 属性描述:当月上线数
	 */
	@TableField(value="ONLINE_CAR_NUM",exist=true)
	Integer onlineCarNum;

	/**
	 * 属性描述:上线率
	 */
	@TableField(value="ONLINE_RATE",exist=true)
	java.math.BigDecimal onlineRate;

	/**
	 * 属性描述:当月中断分钟数
	 */
	@TableField(value="LINK_BREAK_MINUTE",exist=true)
	Integer linkBreakMinute;

	/**
	 * 属性描述:联通率
	 */
	@TableField(value="LINK_RATE",exist=true)
	java.math.BigDecimal linkRate;

	/**
	 * 属性描述:当月轨迹不完整车数
	 */
	@TableField(value="TRACE_UNCOMPLETE_CAR_NUM",exist=true)
	Integer traceUncompleteCarNum;

	/**
	 * 属性描述:轨迹完整率
	 */
	@TableField(value="TRACE_COMPLETE_RATE",exist=true)
	java.math.BigDecimal traceCompleteRate;

	/**
	 * 属性描述:数据合格率
	 */
	@TableField(value="DATA_QUALIFIED_RATE",exist=true)
	java.math.BigDecimal dataQualifiedRate;

	/**
	 * 属性描述:司机卡当月上传数
	 */
	@TableField(value="DRIVER_CARD_UP_CAR_NUM",exist=true)
	Integer driverCardUpCarNum;

	/**
	 * 属性描述:司机卡上传率
	 */
	@TableField(value="DRIVER_CARD_UPLOAD_RATE",exist=true)
	java.math.BigDecimal driverCardUploadRate;

	/**
	 * 属性描述:司机卡记录总数
	 */
	@TableField(value="DRIVER_CAR_REC_COUNT",exist=true)
	Integer driverCarRecCount;

	/**
	 * 属性描述:司机卡合格数
	 */
	@TableField(value="DRIVER_CARD_QUALIFIED_NUM",exist=true)
	Integer driverCardQualifiedNum;

	/**
	 * 属性描述:司机身份卡信息准确率
	 */
	@TableField(value="DRIVER_CARD_QUALIFIED_RATE",exist=true)
	java.math.BigDecimal driverCardQualifiedRate;

	/**
	 * 属性描述:分段限速报警准确率
	 */
	@TableField(value="SPEED_ALARM_QUALIFIED_RATE",exist=true)
	java.math.BigDecimal speedAlarmQualifiedRate;

	/**
	 * 属性描述:轨迹漂移车辆数
	 */
	@TableField(value="TRACE_FLAY_CAR_NUM",exist=true)
	Integer traceFlayCarNum;

	/**
	 * 属性描述:车辆漂移率
	 */
	@TableField(value="TRACE_FLY_RATE",exist=true)
	java.math.BigDecimal traceFlyRate;

	/**
	 * 属性描述:回传间隔合格车辆数
	 */
	@TableField(value="GPS_UPLOAD_TIME_QUALIFIED_NUM",exist=true)
	Integer gpsUploadTimeQualifiedNum;

	/**
	 * 属性描述:回传间隔合格率
	 */
	@TableField(value="GPS_UPLOAD_TIME_QUALIFIED_RATE",exist=true)
	java.math.BigDecimal gpsUploadTimeQualifiedRate;

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


	public String getCompFlag() {
		return compFlag;
	}

	public void setCompFlag(String compFlag) {
		this.compFlag = compFlag;
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


	public java.math.BigDecimal getScore(){
		return this.score;
	}

	public void setScore(java.math.BigDecimal score){
		this.score=score;
	}


	public Integer getCarNum(){
		return this.carNum;
	}

	public void setCarNum(Integer carNum){
		this.carNum=carNum;
	}


	public Integer getOnlineCarNum(){
		return this.onlineCarNum;
	}

	public void setOnlineCarNum(Integer onlineCarNum){
		this.onlineCarNum=onlineCarNum;
	}


	public java.math.BigDecimal getOnlineRate(){
		return this.onlineRate;
	}

	public void setOnlineRate(java.math.BigDecimal onlineRate){
		this.onlineRate=onlineRate;
	}


	public Integer getLinkBreakMinute(){
		return this.linkBreakMinute;
	}

	public void setLinkBreakMinute(Integer linkBreakMinute){
		this.linkBreakMinute=linkBreakMinute;
	}


	public java.math.BigDecimal getLinkRate(){
		return this.linkRate;
	}

	public void setLinkRate(java.math.BigDecimal linkRate){
		this.linkRate=linkRate;
	}


	public Integer getTraceUncompleteCarNum(){
		return this.traceUncompleteCarNum;
	}

	public void setTraceUncompleteCarNum(Integer traceUncompleteCarNum){
		this.traceUncompleteCarNum=traceUncompleteCarNum;
	}


	public java.math.BigDecimal getTraceCompleteRate(){
		return this.traceCompleteRate;
	}

	public void setTraceCompleteRate(java.math.BigDecimal traceCompleteRate){
		this.traceCompleteRate=traceCompleteRate;
	}


	public java.math.BigDecimal getDataQualifiedRate(){
		return this.dataQualifiedRate;
	}

	public void setDataQualifiedRate(java.math.BigDecimal dataQualifiedRate){
		this.dataQualifiedRate=dataQualifiedRate;
	}


	public Integer getDriverCardUpCarNum(){
		return this.driverCardUpCarNum;
	}

	public void setDriverCardUpCarNum(Integer driverCardUpCarNum){
		this.driverCardUpCarNum=driverCardUpCarNum;
	}


	public java.math.BigDecimal getDriverCardUploadRate(){
		return this.driverCardUploadRate;
	}

	public void setDriverCardUploadRate(java.math.BigDecimal driverCardUploadRate){
		this.driverCardUploadRate=driverCardUploadRate;
	}


	public Integer getDriverCarRecCount(){
		return this.driverCarRecCount;
	}

	public void setDriverCarRecCount(Integer driverCarRecCount){
		this.driverCarRecCount=driverCarRecCount;
	}


	public Integer getDriverCardQualifiedNum(){
		return this.driverCardQualifiedNum;
	}

	public void setDriverCardQualifiedNum(Integer driverCardQualifiedNum){
		this.driverCardQualifiedNum=driverCardQualifiedNum;
	}


	public java.math.BigDecimal getDriverCardQualifiedRate(){
		return this.driverCardQualifiedRate;
	}

	public void setDriverCardQualifiedRate(java.math.BigDecimal driverCardQualifiedRate){
		this.driverCardQualifiedRate=driverCardQualifiedRate;
	}


	public java.math.BigDecimal getSpeedAlarmQualifiedRate(){
		return this.speedAlarmQualifiedRate;
	}

	public void setSpeedAlarmQualifiedRate(java.math.BigDecimal speedAlarmQualifiedRate){
		this.speedAlarmQualifiedRate=speedAlarmQualifiedRate;
	}


	public Integer getTraceFlayCarNum(){
		return this.traceFlayCarNum;
	}

	public void setTraceFlayCarNum(Integer traceFlayCarNum){
		this.traceFlayCarNum=traceFlayCarNum;
	}


	public java.math.BigDecimal getTraceFlyRate(){
		return this.traceFlyRate;
	}

	public void setTraceFlyRate(java.math.BigDecimal traceFlyRate){
		this.traceFlyRate=traceFlyRate;
	}


	public Integer getGpsUploadTimeQualifiedNum(){
		return this.gpsUploadTimeQualifiedNum;
	}

	public void setGpsUploadTimeQualifiedNum(Integer gpsUploadTimeQualifiedNum){
		this.gpsUploadTimeQualifiedNum=gpsUploadTimeQualifiedNum;
	}


	public java.math.BigDecimal getGpsUploadTimeQualifiedRate(){
		return this.gpsUploadTimeQualifiedRate;
	}

	public void setGpsUploadTimeQualifiedRate(java.math.BigDecimal gpsUploadTimeQualifiedRate){
		this.gpsUploadTimeQualifiedRate=gpsUploadTimeQualifiedRate;
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
			sb.append(", score=").append(score);			
			sb.append(", carNum=").append(carNum);			
			sb.append(", onlineCarNum=").append(onlineCarNum);			
			sb.append(", onlineRate=").append(onlineRate);			
			sb.append(", linkBreakMinute=").append(linkBreakMinute);			
			sb.append(", linkRate=").append(linkRate);			
			sb.append(", traceUncompleteCarNum=").append(traceUncompleteCarNum);			
			sb.append(", traceCompleteRate=").append(traceCompleteRate);			
			sb.append(", dataQualifiedRate=").append(dataQualifiedRate);			
			sb.append(", driverCardUpCarNum=").append(driverCardUpCarNum);			
			sb.append(", driverCardUploadRate=").append(driverCardUploadRate);			
			sb.append(", driverCarRecCount=").append(driverCarRecCount);			
			sb.append(", driverCardQualifiedNum=").append(driverCardQualifiedNum);			
			sb.append(", driverCardQualifiedRate=").append(driverCardQualifiedRate);			
			sb.append(", speedAlarmQualifiedRate=").append(speedAlarmQualifiedRate);			
			sb.append(", traceFlayCarNum=").append(traceFlayCarNum);			
			sb.append(", traceFlyRate=").append(traceFlyRate);			
			sb.append(", gpsUploadTimeQualifiedNum=").append(gpsUploadTimeQualifiedNum);			
			sb.append(", gpsUploadTimeQualifiedRate=").append(gpsUploadTimeQualifiedRate);			
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
        BigdataBeidouCompMonthCheck other = (BigdataBeidouCompMonthCheck) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getCompId() == null ? other.getId() == null : this.getCompId().equals(other.getCompId()))		
				        		&&(this.getCompName() == null ? other.getId() == null : this.getCompName().equals(other.getCompName()))		
				        		&&(this.getScore() == null ? other.getId() == null : this.getScore().equals(other.getScore()))		
				        		&&(this.getCarNum() == null ? other.getId() == null : this.getCarNum().equals(other.getCarNum()))		
				        		&&(this.getOnlineCarNum() == null ? other.getId() == null : this.getOnlineCarNum().equals(other.getOnlineCarNum()))		
				        		&&(this.getOnlineRate() == null ? other.getId() == null : this.getOnlineRate().equals(other.getOnlineRate()))		
				        		&&(this.getLinkBreakMinute() == null ? other.getId() == null : this.getLinkBreakMinute().equals(other.getLinkBreakMinute()))		
				        		&&(this.getLinkRate() == null ? other.getId() == null : this.getLinkRate().equals(other.getLinkRate()))		
				        		&&(this.getTraceUncompleteCarNum() == null ? other.getId() == null : this.getTraceUncompleteCarNum().equals(other.getTraceUncompleteCarNum()))		
				        		&&(this.getTraceCompleteRate() == null ? other.getId() == null : this.getTraceCompleteRate().equals(other.getTraceCompleteRate()))		
				        		&&(this.getDataQualifiedRate() == null ? other.getId() == null : this.getDataQualifiedRate().equals(other.getDataQualifiedRate()))		
				        		&&(this.getDriverCardUpCarNum() == null ? other.getId() == null : this.getDriverCardUpCarNum().equals(other.getDriverCardUpCarNum()))		
				        		&&(this.getDriverCardUploadRate() == null ? other.getId() == null : this.getDriverCardUploadRate().equals(other.getDriverCardUploadRate()))		
				        		&&(this.getDriverCarRecCount() == null ? other.getId() == null : this.getDriverCarRecCount().equals(other.getDriverCarRecCount()))		
				        		&&(this.getDriverCardQualifiedNum() == null ? other.getId() == null : this.getDriverCardQualifiedNum().equals(other.getDriverCardQualifiedNum()))		
				        		&&(this.getDriverCardQualifiedRate() == null ? other.getId() == null : this.getDriverCardQualifiedRate().equals(other.getDriverCardQualifiedRate()))		
				        		&&(this.getSpeedAlarmQualifiedRate() == null ? other.getId() == null : this.getSpeedAlarmQualifiedRate().equals(other.getSpeedAlarmQualifiedRate()))		
				        		&&(this.getTraceFlayCarNum() == null ? other.getId() == null : this.getTraceFlayCarNum().equals(other.getTraceFlayCarNum()))		
				        		&&(this.getTraceFlyRate() == null ? other.getId() == null : this.getTraceFlyRate().equals(other.getTraceFlyRate()))		
				        		&&(this.getGpsUploadTimeQualifiedNum() == null ? other.getId() == null : this.getGpsUploadTimeQualifiedNum().equals(other.getGpsUploadTimeQualifiedNum()))		
				        		&&(this.getGpsUploadTimeQualifiedRate() == null ? other.getId() == null : this.getGpsUploadTimeQualifiedRate().equals(other.getGpsUploadTimeQualifiedRate()))		
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
		        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());		
		        result = prime * result + ((getCarNum() == null) ? 0 : getCarNum().hashCode());		
		        result = prime * result + ((getOnlineCarNum() == null) ? 0 : getOnlineCarNum().hashCode());		
		        result = prime * result + ((getOnlineRate() == null) ? 0 : getOnlineRate().hashCode());		
		        result = prime * result + ((getLinkBreakMinute() == null) ? 0 : getLinkBreakMinute().hashCode());		
		        result = prime * result + ((getLinkRate() == null) ? 0 : getLinkRate().hashCode());		
		        result = prime * result + ((getTraceUncompleteCarNum() == null) ? 0 : getTraceUncompleteCarNum().hashCode());		
		        result = prime * result + ((getTraceCompleteRate() == null) ? 0 : getTraceCompleteRate().hashCode());		
		        result = prime * result + ((getDataQualifiedRate() == null) ? 0 : getDataQualifiedRate().hashCode());		
		        result = prime * result + ((getDriverCardUpCarNum() == null) ? 0 : getDriverCardUpCarNum().hashCode());		
		        result = prime * result + ((getDriverCardUploadRate() == null) ? 0 : getDriverCardUploadRate().hashCode());		
		        result = prime * result + ((getDriverCarRecCount() == null) ? 0 : getDriverCarRecCount().hashCode());		
		        result = prime * result + ((getDriverCardQualifiedNum() == null) ? 0 : getDriverCardQualifiedNum().hashCode());		
		        result = prime * result + ((getDriverCardQualifiedRate() == null) ? 0 : getDriverCardQualifiedRate().hashCode());		
		        result = prime * result + ((getSpeedAlarmQualifiedRate() == null) ? 0 : getSpeedAlarmQualifiedRate().hashCode());		
		        result = prime * result + ((getTraceFlayCarNum() == null) ? 0 : getTraceFlayCarNum().hashCode());		
		        result = prime * result + ((getTraceFlyRate() == null) ? 0 : getTraceFlyRate().hashCode());		
		        result = prime * result + ((getGpsUploadTimeQualifiedNum() == null) ? 0 : getGpsUploadTimeQualifiedNum().hashCode());		
		        result = prime * result + ((getGpsUploadTimeQualifiedRate() == null) ? 0 : getGpsUploadTimeQualifiedRate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
