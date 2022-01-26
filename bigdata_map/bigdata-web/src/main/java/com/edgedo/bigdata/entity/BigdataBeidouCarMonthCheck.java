package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_beidou_car_month_check")
public class BigdataBeidouCarMonthCheck implements Serializable{
	
		
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
	 * 属性描述:运营商id
	 */
	@TableField(value="COMP_ID",exist=true)
	java.lang.String compId;
	
	/**
	 * 属性描述:运营商名
	 */
	@TableField(value="COMP_NAME",exist=true)
	java.lang.String compName;
	
	/**
	 * 属性描述:车牌号
	 */
	@TableField(value="CAR_PLATE_NUM",exist=true)
	java.lang.String carPlateNum;
	
	/**
	 * 属性描述:车架号
	 */
	@TableField(value="CAR_FRAME_NUM",exist=true)
	java.lang.String carFrameNum;
	
	/**
	 * 属性描述:车牌颜色
	 */
	@TableField(value="CAR_PLATE_COLOR",exist=true)
	java.lang.String carPlateColor;
	
	/**
	 * 属性描述:当月是否上线
	 */
	@TableField(value="ONLINE_STATE",exist=true)
	java.lang.String onlineState;
	
	/**
	 * 属性描述:轨迹不完整次数
	 */
	@TableField(value="TRACE_UNCOMPLETE_NUM",exist=true)
	java.lang.Integer traceUncompleteNum;
	
	/**
	 * 属性描述:司机卡上传次数
	 */
	@TableField(value="DRIVER_CARD_UP_NUM",exist=true)
	java.lang.Integer driverCardUpNum;
	
	/**
	 * 属性描述:轨迹飘点次数
	 */
	@TableField(value="TRACE_FLY_NUM",exist=true)
	java.lang.Integer traceFlyNum;
	
	/**
	 * 属性描述:数据回传间隔是否合格
	 */
	@TableField(value="GPS_UPLOAD_TIME_QUALIFIED_FLAG",exist=true)
	java.lang.String gpsUploadTimeQualifiedFlag;
	
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
	 * 属性描述:年份
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
	
	
	public java.lang.String getCompId(){
		return this.compId;
	}
	
	public void setCompId(java.lang.String compId){
		this.compId=compId;
	}
	
	
	public java.lang.String getCompName(){
		return this.compName;
	}
	
	public void setCompName(java.lang.String compName){
		this.compName=compName;
	}
	
	
	public java.lang.String getCarPlateNum(){
		return this.carPlateNum;
	}
	
	public void setCarPlateNum(java.lang.String carPlateNum){
		this.carPlateNum=carPlateNum;
	}
	
	
	public java.lang.String getCarFrameNum(){
		return this.carFrameNum;
	}
	
	public void setCarFrameNum(java.lang.String carFrameNum){
		this.carFrameNum=carFrameNum;
	}
	
	
	public java.lang.String getCarPlateColor(){
		return this.carPlateColor;
	}
	
	public void setCarPlateColor(java.lang.String carPlateColor){
		this.carPlateColor=carPlateColor;
	}
	
	
	public java.lang.String getOnlineState(){
		return this.onlineState;
	}
	
	public void setOnlineState(java.lang.String onlineState){
		this.onlineState=onlineState;
	}
	
	
	public java.lang.Integer getTraceUncompleteNum(){
		return this.traceUncompleteNum;
	}
	
	public void setTraceUncompleteNum(java.lang.Integer traceUncompleteNum){
		this.traceUncompleteNum=traceUncompleteNum;
	}
	
	
	public java.lang.Integer getDriverCardUpNum(){
		return this.driverCardUpNum;
	}
	
	public void setDriverCardUpNum(java.lang.Integer driverCardUpNum){
		this.driverCardUpNum=driverCardUpNum;
	}
	
	
	public java.lang.Integer getTraceFlyNum(){
		return this.traceFlyNum;
	}
	
	public void setTraceFlyNum(java.lang.Integer traceFlyNum){
		this.traceFlyNum=traceFlyNum;
	}
	
	
	public java.lang.String getGpsUploadTimeQualifiedFlag(){
		return this.gpsUploadTimeQualifiedFlag;
	}
	
	public void setGpsUploadTimeQualifiedFlag(java.lang.String gpsUploadTimeQualifiedFlag){
		this.gpsUploadTimeQualifiedFlag=gpsUploadTimeQualifiedFlag;
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
