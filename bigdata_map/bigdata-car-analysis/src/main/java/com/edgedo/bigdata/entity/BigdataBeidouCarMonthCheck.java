package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("bigdata_beidou_car_month_check")
public class BigdataBeidouCarMonthCheck implements Serializable{
	
		
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
	 * 属性描述:车牌号
	 */
	@TableField(value="CAR_PLATE_NUM",exist=true)
	String carPlateNum;

	/**
	 * 属性描述:车架号
	 */
	@TableField(value="CAR_FRAME_NUM",exist=true)
	String carFrameNum;

	/**
	 * 属性描述:车牌颜色
	 */
	@TableField(value="CAR_PLATE_COLOR",exist=true)
	String carPlateColor;

	/**
	 * 属性描述:当月是否上线
	 */
	@TableField(value="ONLINE_STATE",exist=true)
	String onlineState;

	/**
	 * 属性描述:轨迹不完整次数
	 */
	@TableField(value="TRACE_UNCOMPLETE_NUM",exist=true)
	Integer traceUncompleteNum;

	/**
	 * 属性描述:司机卡上传次数
	 */
	@TableField(value="DRIVER_CARD_UP_NUM",exist=true)
	Integer driverCardUpNum;

	/**
	 * 属性描述:轨迹飘点次数
	 */
	@TableField(value="TRACE_FLY_NUM",exist=true)
	Integer traceFlyNum;

	/**
	 * 属性描述:数据回传间隔是否合格
	 */
	@TableField(value="GPS_UPLOAD_TIME_QUALIFIED_FLAG",exist=true)
	String gpsUploadTimeQualifiedFlag;

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


	public String getCarPlateNum(){
		return this.carPlateNum;
	}

	public void setCarPlateNum(String carPlateNum){
		this.carPlateNum=carPlateNum;
	}


	public String getCarFrameNum(){
		return this.carFrameNum;
	}

	public void setCarFrameNum(String carFrameNum){
		this.carFrameNum=carFrameNum;
	}


	public String getCarPlateColor(){
		return this.carPlateColor;
	}

	public void setCarPlateColor(String carPlateColor){
		this.carPlateColor=carPlateColor;
	}


	public String getOnlineState(){
		return this.onlineState;
	}

	public void setOnlineState(String onlineState){
		this.onlineState=onlineState;
	}


	public Integer getTraceUncompleteNum(){
		return this.traceUncompleteNum;
	}

	public void setTraceUncompleteNum(Integer traceUncompleteNum){
		this.traceUncompleteNum=traceUncompleteNum;
	}


	public Integer getDriverCardUpNum(){
		return this.driverCardUpNum;
	}

	public void setDriverCardUpNum(Integer driverCardUpNum){
		this.driverCardUpNum=driverCardUpNum;
	}


	public Integer getTraceFlyNum(){
		return this.traceFlyNum;
	}

	public void setTraceFlyNum(Integer traceFlyNum){
		this.traceFlyNum=traceFlyNum;
	}


	public String getGpsUploadTimeQualifiedFlag(){
		return this.gpsUploadTimeQualifiedFlag;
	}

	public void setGpsUploadTimeQualifiedFlag(String gpsUploadTimeQualifiedFlag){
		this.gpsUploadTimeQualifiedFlag=gpsUploadTimeQualifiedFlag;
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
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carFrameNum=").append(carFrameNum);			
			sb.append(", carPlateColor=").append(carPlateColor);			
			sb.append(", onlineState=").append(onlineState);			
			sb.append(", traceUncompleteNum=").append(traceUncompleteNum);			
			sb.append(", driverCardUpNum=").append(driverCardUpNum);			
			sb.append(", traceFlyNum=").append(traceFlyNum);			
			sb.append(", gpsUploadTimeQualifiedFlag=").append(gpsUploadTimeQualifiedFlag);			
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
        BigdataBeidouCarMonthCheck other = (BigdataBeidouCarMonthCheck) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getCompId() == null ? other.getId() == null : this.getCompId().equals(other.getCompId()))		
				        		&&(this.getCompName() == null ? other.getId() == null : this.getCompName().equals(other.getCompName()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarFrameNum() == null ? other.getId() == null : this.getCarFrameNum().equals(other.getCarFrameNum()))		
				        		&&(this.getCarPlateColor() == null ? other.getId() == null : this.getCarPlateColor().equals(other.getCarPlateColor()))		
				        		&&(this.getOnlineState() == null ? other.getId() == null : this.getOnlineState().equals(other.getOnlineState()))		
				        		&&(this.getTraceUncompleteNum() == null ? other.getId() == null : this.getTraceUncompleteNum().equals(other.getTraceUncompleteNum()))		
				        		&&(this.getDriverCardUpNum() == null ? other.getId() == null : this.getDriverCardUpNum().equals(other.getDriverCardUpNum()))		
				        		&&(this.getTraceFlyNum() == null ? other.getId() == null : this.getTraceFlyNum().equals(other.getTraceFlyNum()))		
				        		&&(this.getGpsUploadTimeQualifiedFlag() == null ? other.getId() == null : this.getGpsUploadTimeQualifiedFlag().equals(other.getGpsUploadTimeQualifiedFlag()))		
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
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarFrameNum() == null) ? 0 : getCarFrameNum().hashCode());		
		        result = prime * result + ((getCarPlateColor() == null) ? 0 : getCarPlateColor().hashCode());		
		        result = prime * result + ((getOnlineState() == null) ? 0 : getOnlineState().hashCode());		
		        result = prime * result + ((getTraceUncompleteNum() == null) ? 0 : getTraceUncompleteNum().hashCode());		
		        result = prime * result + ((getDriverCardUpNum() == null) ? 0 : getDriverCardUpNum().hashCode());		
		        result = prime * result + ((getTraceFlyNum() == null) ? 0 : getTraceFlyNum().hashCode());		
		        result = prime * result + ((getGpsUploadTimeQualifiedFlag() == null) ? 0 : getGpsUploadTimeQualifiedFlag().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
