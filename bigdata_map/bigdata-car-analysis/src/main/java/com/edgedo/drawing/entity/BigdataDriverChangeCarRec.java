package com.edgedo.drawing.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_driver_change_car_rec")
public class BigdataDriverChangeCarRec implements Serializable{
	
		
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
	 * 属性描述:所属运营商
	 */
	@TableField(value="COMP_ID",exist=true)
	java.lang.String compId;
	
	/**
	 * 属性描述:运营商名
	 */
	@TableField(value="COMP_NAME",exist=true)
	java.lang.String compName;
	
	/**
	 * 属性描述:所属企业
	 */
	@TableField(value="TEAM_ID",exist=true)
	java.lang.String teamId;
	
	/**
	 * 属性描述:企业名
	 */
	@TableField(value="TEAM_NAME",exist=true)
	java.lang.String teamName;
	
	/**
	 * 属性描述:省ID
	 */
	@TableField(value="PROVINCE_ID",exist=true)
	java.lang.String provinceId;
	
	/**
	 * 属性描述:省名
	 */
	@TableField(value="PROVINCE_NAME",exist=true)
	java.lang.String provinceName;
	
	/**
	 * 属性描述:城市ID
	 */
	@TableField(value="CITY_ID",exist=true)
	java.lang.String cityId;
	
	/**
	 * 属性描述:城市名
	 */
	@TableField(value="CITY_NAME",exist=true)
	java.lang.String cityName;
	
	/**
	 * 属性描述:县区ID
	 */
	@TableField(value="XIANQU_ID",exist=true)
	java.lang.String xianquId;
	
	/**
	 * 属性描述:县区名
	 */
	@TableField(value="XIANQU_NAME",exist=true)
	java.lang.String xianquName;
	
	/**
	 * 属性描述:驾驶员ID
	 */
	@TableField(value="DRIVER_ID",exist=true)
	java.lang.String driverId;
	
	/**
	 * 属性描述:驾驶员姓名
	 */
	@TableField(value="DRIVER_NAME",exist=true)
	java.lang.String driverName;
	
	/**
	 * 属性描述:驾驶员性别
	 */
	@TableField(value="DRIVER_SEX",exist=true)
	java.lang.String driverSex;
	
	/**
	 * 属性描述:驾驶员年龄
	 */
	@TableField(value="DRIVER_AGE",exist=true)
	java.lang.Integer driverAge;
	
	/**
	 * 属性描述:驾驶员电话
	 */
	@TableField(value="DRIVER_PHONE",exist=true)
	java.lang.String driverPhone;
	
	/**
	 * 属性描述:驾驶员身份证号
	 */
	@TableField(value="DRIVER_ID_CARD",exist=true)
	java.lang.String driverIdCard;
	
	/**
	 * 属性描述:驾驶员资格证号
	 */
	@TableField(value="DRIVER_CODE",exist=true)
	java.lang.String driverCode;
	
	/**
	 * 属性描述:车牌号
	 */
	@TableField(value="CAR_PLATE_NUM",exist=true)
	java.lang.String carPlateNum;
	
	/**
	 * 属性描述:车牌颜色
	 */
	@TableField(value="CAR_PLATE_COLOR",exist=true)
	java.lang.String carPlateColor;
	
	/**
	 * 属性描述:车牌颜色文本
	 */
	@TableField(value="CAR_PLATE_COLOR_TEXT",exist=true)
	java.lang.String carPlateColorText;
	
	/**
	 * 属性描述:车架号
	 */
	@TableField(value="CAR_FRAME_NUM",exist=true)
	java.lang.String carFrameNum;
	
	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	java.lang.String carType;
	
	/**
	 * 属性描述:开始时间
	 */
	@TableField(value="START_TIME",exist=true)
	java.util.Date startTime;
	
	/**
	 * 属性描述:结束时间
	 */
	@TableField(value="END_TIME",exist=true)
	java.util.Date endTime;
	
	
	
	
	
	
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
	
	
	public java.lang.String getTeamId(){
		return this.teamId;
	}
	
	public void setTeamId(java.lang.String teamId){
		this.teamId=teamId;
	}
	
	
	public java.lang.String getTeamName(){
		return this.teamName;
	}
	
	public void setTeamName(java.lang.String teamName){
		this.teamName=teamName;
	}
	
	
	public java.lang.String getProvinceId(){
		return this.provinceId;
	}
	
	public void setProvinceId(java.lang.String provinceId){
		this.provinceId=provinceId;
	}
	
	
	public java.lang.String getProvinceName(){
		return this.provinceName;
	}
	
	public void setProvinceName(java.lang.String provinceName){
		this.provinceName=provinceName;
	}
	
	
	public java.lang.String getCityId(){
		return this.cityId;
	}
	
	public void setCityId(java.lang.String cityId){
		this.cityId=cityId;
	}
	
	
	public java.lang.String getCityName(){
		return this.cityName;
	}
	
	public void setCityName(java.lang.String cityName){
		this.cityName=cityName;
	}
	
	
	public java.lang.String getXianquId(){
		return this.xianquId;
	}
	
	public void setXianquId(java.lang.String xianquId){
		this.xianquId=xianquId;
	}
	
	
	public java.lang.String getXianquName(){
		return this.xianquName;
	}
	
	public void setXianquName(java.lang.String xianquName){
		this.xianquName=xianquName;
	}
	
	
	public java.lang.String getDriverId(){
		return this.driverId;
	}
	
	public void setDriverId(java.lang.String driverId){
		this.driverId=driverId;
	}
	
	
	public java.lang.String getDriverName(){
		return this.driverName;
	}
	
	public void setDriverName(java.lang.String driverName){
		this.driverName=driverName;
	}
	
	
	public java.lang.String getDriverSex(){
		return this.driverSex;
	}
	
	public void setDriverSex(java.lang.String driverSex){
		this.driverSex=driverSex;
	}
	
	
	public java.lang.Integer getDriverAge(){
		return this.driverAge;
	}
	
	public void setDriverAge(java.lang.Integer driverAge){
		this.driverAge=driverAge;
	}
	
	
	public java.lang.String getDriverPhone(){
		return this.driverPhone;
	}
	
	public void setDriverPhone(java.lang.String driverPhone){
		this.driverPhone=driverPhone;
	}
	
	
	public java.lang.String getDriverIdCard(){
		return this.driverIdCard;
	}
	
	public void setDriverIdCard(java.lang.String driverIdCard){
		this.driverIdCard=driverIdCard;
	}
	
	
	public java.lang.String getDriverCode(){
		return this.driverCode;
	}
	
	public void setDriverCode(java.lang.String driverCode){
		this.driverCode=driverCode;
	}
	
	
	public java.lang.String getCarPlateNum(){
		return this.carPlateNum;
	}
	
	public void setCarPlateNum(java.lang.String carPlateNum){
		this.carPlateNum=carPlateNum;
	}
	
	
	public java.lang.String getCarPlateColor(){
		return this.carPlateColor;
	}
	
	public void setCarPlateColor(java.lang.String carPlateColor){
		this.carPlateColor=carPlateColor;
	}
	
	
	public java.lang.String getCarPlateColorText(){
		return this.carPlateColorText;
	}
	
	public void setCarPlateColorText(java.lang.String carPlateColorText){
		this.carPlateColorText=carPlateColorText;
	}
	
	
	public java.lang.String getCarFrameNum(){
		return this.carFrameNum;
	}
	
	public void setCarFrameNum(java.lang.String carFrameNum){
		this.carFrameNum=carFrameNum;
	}
	
	
	public java.lang.String getCarType(){
		return this.carType;
	}
	
	public void setCarType(java.lang.String carType){
		this.carType=carType;
	}
	
	
	public java.util.Date getStartTime(){
		return this.startTime;
	}
	
	public void setStartTime(java.util.Date startTime){
		this.startTime=startTime;
	}
	
	
	public java.util.Date getEndTime(){
		return this.endTime;
	}
	
	public void setEndTime(java.util.Date endTime){
		this.endTime=endTime;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", compId=").append(compId);			
			sb.append(", compName=").append(compName);			
			sb.append(", teamId=").append(teamId);			
			sb.append(", teamName=").append(teamName);			
			sb.append(", provinceId=").append(provinceId);			
			sb.append(", provinceName=").append(provinceName);			
			sb.append(", cityId=").append(cityId);			
			sb.append(", cityName=").append(cityName);			
			sb.append(", xianquId=").append(xianquId);			
			sb.append(", xianquName=").append(xianquName);			
			sb.append(", driverId=").append(driverId);			
			sb.append(", driverName=").append(driverName);			
			sb.append(", driverSex=").append(driverSex);			
			sb.append(", driverAge=").append(driverAge);			
			sb.append(", driverPhone=").append(driverPhone);			
			sb.append(", driverIdCard=").append(driverIdCard);			
			sb.append(", driverCode=").append(driverCode);			
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carPlateColor=").append(carPlateColor);			
			sb.append(", carPlateColorText=").append(carPlateColorText);			
			sb.append(", carFrameNum=").append(carFrameNum);			
			sb.append(", carType=").append(carType);			
			sb.append(", startTime=").append(startTime);			
			sb.append(", endTime=").append(endTime);			
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
        BigdataDriverChangeCarRec other = (BigdataDriverChangeCarRec) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCompId() == null ? other.getId() == null : this.getCompId().equals(other.getCompId()))		
				        		&&(this.getCompName() == null ? other.getId() == null : this.getCompName().equals(other.getCompName()))		
				        		&&(this.getTeamId() == null ? other.getId() == null : this.getTeamId().equals(other.getTeamId()))		
				        		&&(this.getTeamName() == null ? other.getId() == null : this.getTeamName().equals(other.getTeamName()))		
				        		&&(this.getProvinceId() == null ? other.getId() == null : this.getProvinceId().equals(other.getProvinceId()))		
				        		&&(this.getProvinceName() == null ? other.getId() == null : this.getProvinceName().equals(other.getProvinceName()))		
				        		&&(this.getCityId() == null ? other.getId() == null : this.getCityId().equals(other.getCityId()))		
				        		&&(this.getCityName() == null ? other.getId() == null : this.getCityName().equals(other.getCityName()))		
				        		&&(this.getXianquId() == null ? other.getId() == null : this.getXianquId().equals(other.getXianquId()))		
				        		&&(this.getXianquName() == null ? other.getId() == null : this.getXianquName().equals(other.getXianquName()))		
				        		&&(this.getDriverId() == null ? other.getId() == null : this.getDriverId().equals(other.getDriverId()))		
				        		&&(this.getDriverName() == null ? other.getId() == null : this.getDriverName().equals(other.getDriverName()))		
				        		&&(this.getDriverSex() == null ? other.getId() == null : this.getDriverSex().equals(other.getDriverSex()))		
				        		&&(this.getDriverAge() == null ? other.getId() == null : this.getDriverAge().equals(other.getDriverAge()))		
				        		&&(this.getDriverPhone() == null ? other.getId() == null : this.getDriverPhone().equals(other.getDriverPhone()))		
				        		&&(this.getDriverIdCard() == null ? other.getId() == null : this.getDriverIdCard().equals(other.getDriverIdCard()))		
				        		&&(this.getDriverCode() == null ? other.getId() == null : this.getDriverCode().equals(other.getDriverCode()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarPlateColor() == null ? other.getId() == null : this.getCarPlateColor().equals(other.getCarPlateColor()))		
				        		&&(this.getCarPlateColorText() == null ? other.getId() == null : this.getCarPlateColorText().equals(other.getCarPlateColorText()))		
				        		&&(this.getCarFrameNum() == null ? other.getId() == null : this.getCarFrameNum().equals(other.getCarFrameNum()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getStartTime() == null ? other.getId() == null : this.getStartTime().equals(other.getStartTime()))		
				        		&&(this.getEndTime() == null ? other.getId() == null : this.getEndTime().equals(other.getEndTime()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());		
		        result = prime * result + ((getCompName() == null) ? 0 : getCompName().hashCode());		
		        result = prime * result + ((getTeamId() == null) ? 0 : getTeamId().hashCode());		
		        result = prime * result + ((getTeamName() == null) ? 0 : getTeamName().hashCode());		
		        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());		
		        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());		
		        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());		
		        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());		
		        result = prime * result + ((getXianquId() == null) ? 0 : getXianquId().hashCode());		
		        result = prime * result + ((getXianquName() == null) ? 0 : getXianquName().hashCode());		
		        result = prime * result + ((getDriverId() == null) ? 0 : getDriverId().hashCode());		
		        result = prime * result + ((getDriverName() == null) ? 0 : getDriverName().hashCode());		
		        result = prime * result + ((getDriverSex() == null) ? 0 : getDriverSex().hashCode());		
		        result = prime * result + ((getDriverAge() == null) ? 0 : getDriverAge().hashCode());		
		        result = prime * result + ((getDriverPhone() == null) ? 0 : getDriverPhone().hashCode());		
		        result = prime * result + ((getDriverIdCard() == null) ? 0 : getDriverIdCard().hashCode());		
		        result = prime * result + ((getDriverCode() == null) ? 0 : getDriverCode().hashCode());		
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarPlateColor() == null) ? 0 : getCarPlateColor().hashCode());		
		        result = prime * result + ((getCarPlateColorText() == null) ? 0 : getCarPlateColorText().hashCode());		
		        result = prime * result + ((getCarFrameNum() == null) ? 0 : getCarFrameNum().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());		
		        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());		
		;
        return result;
    }

}
