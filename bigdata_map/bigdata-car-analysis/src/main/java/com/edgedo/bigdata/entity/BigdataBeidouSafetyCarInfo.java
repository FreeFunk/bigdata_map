package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

@TableName("bigdata_beidou_safety_car_info")
public class BigdataBeidouSafetyCarInfo implements Serializable{
	
		
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
	 * 属性描述:接入平台ID
	 */
	@TableField(value="COMP_ID",exist=true)
	String compId;

	/**
	 * 属性描述:接入平台
	 */
	@TableField(value="COMP_NAME",exist=true)
	String compName;

	/**
	 * 属性描述:省ID
	 */
	@TableField(value="PROVINCE_ID",exist=true)
	String provinceId;

	/**
	 * 属性描述:省名
	 */
	@TableField(value="PROVINCE_NAME",exist=true)
	String provinceName;

	/**
	 * 属性描述:城市ID
	 */
	@TableField(value="CITY_ID",exist=true)
	String cityId;

	/**
	 * 属性描述:城市名
	 */
	@TableField(value="CITY_NAME",exist=true)
	String cityName;

	/**
	 * 属性描述:县区ID
	 */
	@TableField(value="XIANQU_ID",exist=true)
	String xianquId;

	/**
	 * 属性描述:县区名
	 */
	@TableField(value="XIANQU_NAME",exist=true)
	String xianquName;

	/**
	 * 属性描述:所属企业ID
	 */
	@TableField(value="TEAM_ID",exist=true)
	String teamId;

	/**
	 * 属性描述:企业名
	 */
	@TableField(value="TEAM_NAME",exist=true)
	String teamName;

	/**
	 * 属性描述:车牌号
	 */
	@TableField(value="CAR_PLATE_NUM",exist=true)
	String carPlateNum;

	/**
	 * 属性描述:车牌颜色
	 */
	@TableField(value="CAR_PLATE_COLOR",exist=true)
	String carPlateColor;

	/**
	 * 属性描述:车架号
	 */
	@TableField(value="CAR_FRAME_NUM",exist=true)
	String carFrameNum;

	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	String carType;

	/**
	 * 属性描述:安装时间
	 */
	@TableField(value="INSTALL_TIME",exist=true)
	java.util.Date installTime;

	/**
	 * 属性描述:设备型号
	 */
	@TableField(value="MODEL_CODE",exist=true)
	String modelCode;

	/**
	 * 属性描述:制造商名称
	 */
	@TableField(value="MANUFACTURER_NAME",exist=true)
	String manufacturerName;

	/**
	 * 属性描述:制造商ID
	 */
	@TableField(value="MANUFACTURER_ID",exist=true)
	String manufacturerId;

	/**
	 * 属性描述:设备ID
	 */
	@TableField(value="MODEL_ID",exist=true)
	String modelId;

	/**
	 * 属性描述:SIM卡号
	 */
	@TableField(value="SIM",exist=true)
	String sim;

	/**
	 * 属性描述:DSM设备ID
	 */
	@TableField(value="DSM_ID",exist=true)
	String dsmId;

	/**
	 * 属性描述:ADAS设备ID
	 */
	@TableField(value="ADAS_ID",exist=true)
	String adasId;

	/**
	 * 属性描述:上报时间
	 */
	@TableField(value="UPLOAD_TIME",exist=true)
	java.util.Date uploadTime;
	//通道号
	@TableField(value="CHANNEL_ENABLE",exist=true)
	private String channelEnable;
	//通道总数
	@TableField(value="CHANNEL_NUM",exist=true)
	private Integer channelNum;
	//协议类型
	@TableField(value="PROTOCOL",exist=true)
	private String protocol;
	//前端对接直播视频的设备类型参数 目前瑞明会用根据PROTOCOL转换
	//瑞明:123:mdvr设备（暂时不支持）,124:n9m设备,200:808设备,201:905设备,202:1078设备
	@TableField(value="DEVICE_TYPE",exist=true)
	private String deviceType;

	@TableField(value="altitude",exist=true)
	private BigDecimal altitude;

	@TableField(value="lon",exist=true)
	private BigDecimal lon;

	@TableField(value="lat",exist=true)
	private BigDecimal lat;

	@TableField(value="mileage",exist=true)
	private BigDecimal mileage;

	@TableField(value="state",exist=true)
	private String state;

	@TableField(value="direction",exist=true)
	private String direction;

	@TableField(value="alarm",exist=true)
	private String alarm;

	@TableField(value="speed",exist=true)
	private BigDecimal speed;

	@TableField(value="state_desc",exist=true)
	private String stateDesc;

	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

	public BigDecimal getAltitude() {
		return altitude;
	}

	public void setAltitude(BigDecimal altitude) {
		this.altitude = altitude;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getMileage() {
		return mileage;
	}

	public void setMileage(BigDecimal mileage) {
		this.mileage = mileage;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getAlarm() {
		return alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}

	public BigDecimal getSpeed() {
		return speed;
	}

	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}


	public String getChannelEnable() {
		return channelEnable;
	}

	public void setChannelEnable(String channelEnable) {
		this.channelEnable = channelEnable;
	}

	public Integer getChannelNum() {
		return channelNum;
	}

	public void setChannelNum(Integer channelNum) {
		this.channelNum = channelNum;
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


	public String getProvinceId(){
		return this.provinceId;
	}

	public void setProvinceId(String provinceId){
		this.provinceId=provinceId;
	}


	public String getProvinceName(){
		return this.provinceName;
	}

	public void setProvinceName(String provinceName){
		this.provinceName=provinceName;
	}


	public String getCityId(){
		return this.cityId;
	}

	public void setCityId(String cityId){
		this.cityId=cityId;
	}


	public String getCityName(){
		return this.cityName;
	}

	public void setCityName(String cityName){
		this.cityName=cityName;
	}


	public String getXianquId(){
		return this.xianquId;
	}

	public void setXianquId(String xianquId){
		this.xianquId=xianquId;
	}


	public String getXianquName(){
		return this.xianquName;
	}

	public void setXianquName(String xianquName){
		this.xianquName=xianquName;
	}


	public String getTeamId(){
		return this.teamId;
	}

	public void setTeamId(String teamId){
		this.teamId=teamId;
	}


	public String getTeamName(){
		return this.teamName;
	}

	public void setTeamName(String teamName){
		this.teamName=teamName;
	}


	public String getCarPlateNum(){
		return this.carPlateNum;
	}

	public void setCarPlateNum(String carPlateNum){
		this.carPlateNum=carPlateNum;
	}


	public String getCarPlateColor(){
		return this.carPlateColor;
	}

	public void setCarPlateColor(String carPlateColor){
		this.carPlateColor=carPlateColor;
	}


	public String getCarFrameNum(){
		return this.carFrameNum;
	}

	public void setCarFrameNum(String carFrameNum){
		this.carFrameNum=carFrameNum;
	}


	public String getCarType(){
		return this.carType;
	}

	public void setCarType(String carType){
		this.carType=carType;
	}


	public java.util.Date getInstallTime(){
		return this.installTime;
	}

	public void setInstallTime(java.util.Date installTime){
		this.installTime=installTime;
	}


	public String getModelCode(){
		return this.modelCode;
	}

	public void setModelCode(String modelCode){
		this.modelCode=modelCode;
	}


	public String getManufacturerName(){
		return this.manufacturerName;
	}

	public void setManufacturerName(String manufacturerName){
		this.manufacturerName=manufacturerName;
	}


	public String getManufacturerId(){
		return this.manufacturerId;
	}

	public void setManufacturerId(String manufacturerId){
		this.manufacturerId=manufacturerId;
	}


	public String getModelId(){
		return this.modelId;
	}

	public void setModelId(String modelId){
		this.modelId=modelId;
	}


	public String getSim(){
		return this.sim;
	}

	public void setSim(String sim){
		this.sim=sim;
	}


	public String getDsmId(){
		return this.dsmId;
	}

	public void setDsmId(String dsmId){
		this.dsmId=dsmId;
	}


	public String getAdasId(){
		return this.adasId;
	}

	public void setAdasId(String adasId){
		this.adasId=adasId;
	}
	
	
	public java.util.Date getUploadTime(){
		return this.uploadTime;
	}
	
	public void setUploadTime(java.util.Date uploadTime){
		this.uploadTime=uploadTime;
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
			sb.append(", provinceId=").append(provinceId);			
			sb.append(", provinceName=").append(provinceName);			
			sb.append(", cityId=").append(cityId);			
			sb.append(", cityName=").append(cityName);			
			sb.append(", xianquId=").append(xianquId);			
			sb.append(", xianquName=").append(xianquName);			
			sb.append(", teamId=").append(teamId);			
			sb.append(", teamName=").append(teamName);			
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carPlateColor=").append(carPlateColor);			
			sb.append(", carFrameNum=").append(carFrameNum);			
			sb.append(", carType=").append(carType);			
			sb.append(", installTime=").append(installTime);			
			sb.append(", modelCode=").append(modelCode);			
			sb.append(", manufacturerName=").append(manufacturerName);			
			sb.append(", manufacturerId=").append(manufacturerId);			
			sb.append(", modelId=").append(modelId);			
			sb.append(", sim=").append(sim);			
			sb.append(", dsmId=").append(dsmId);			
			sb.append(", adasId=").append(adasId);			
			sb.append(", uploadTime=").append(uploadTime);			
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
        BigdataBeidouSafetyCarInfo other = (BigdataBeidouSafetyCarInfo) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getCompId() == null ? other.getId() == null : this.getCompId().equals(other.getCompId()))		
				        		&&(this.getCompName() == null ? other.getId() == null : this.getCompName().equals(other.getCompName()))		
				        		&&(this.getProvinceId() == null ? other.getId() == null : this.getProvinceId().equals(other.getProvinceId()))		
				        		&&(this.getProvinceName() == null ? other.getId() == null : this.getProvinceName().equals(other.getProvinceName()))		
				        		&&(this.getCityId() == null ? other.getId() == null : this.getCityId().equals(other.getCityId()))		
				        		&&(this.getCityName() == null ? other.getId() == null : this.getCityName().equals(other.getCityName()))		
				        		&&(this.getXianquId() == null ? other.getId() == null : this.getXianquId().equals(other.getXianquId()))		
				        		&&(this.getXianquName() == null ? other.getId() == null : this.getXianquName().equals(other.getXianquName()))		
				        		&&(this.getTeamId() == null ? other.getId() == null : this.getTeamId().equals(other.getTeamId()))		
				        		&&(this.getTeamName() == null ? other.getId() == null : this.getTeamName().equals(other.getTeamName()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarPlateColor() == null ? other.getId() == null : this.getCarPlateColor().equals(other.getCarPlateColor()))		
				        		&&(this.getCarFrameNum() == null ? other.getId() == null : this.getCarFrameNum().equals(other.getCarFrameNum()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getInstallTime() == null ? other.getId() == null : this.getInstallTime().equals(other.getInstallTime()))		
				        		&&(this.getModelCode() == null ? other.getId() == null : this.getModelCode().equals(other.getModelCode()))		
				        		&&(this.getManufacturerName() == null ? other.getId() == null : this.getManufacturerName().equals(other.getManufacturerName()))		
				        		&&(this.getManufacturerId() == null ? other.getId() == null : this.getManufacturerId().equals(other.getManufacturerId()))		
				        		&&(this.getModelId() == null ? other.getId() == null : this.getModelId().equals(other.getModelId()))		
				        		&&(this.getSim() == null ? other.getId() == null : this.getSim().equals(other.getSim()))		
				        		&&(this.getDsmId() == null ? other.getId() == null : this.getDsmId().equals(other.getDsmId()))		
				        		&&(this.getAdasId() == null ? other.getId() == null : this.getAdasId().equals(other.getAdasId()))		
				        		&&(this.getUploadTime() == null ? other.getId() == null : this.getUploadTime().equals(other.getUploadTime()))		
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
		        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());		
		        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());		
		        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());		
		        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());		
		        result = prime * result + ((getXianquId() == null) ? 0 : getXianquId().hashCode());		
		        result = prime * result + ((getXianquName() == null) ? 0 : getXianquName().hashCode());		
		        result = prime * result + ((getTeamId() == null) ? 0 : getTeamId().hashCode());		
		        result = prime * result + ((getTeamName() == null) ? 0 : getTeamName().hashCode());		
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarPlateColor() == null) ? 0 : getCarPlateColor().hashCode());		
		        result = prime * result + ((getCarFrameNum() == null) ? 0 : getCarFrameNum().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getInstallTime() == null) ? 0 : getInstallTime().hashCode());		
		        result = prime * result + ((getModelCode() == null) ? 0 : getModelCode().hashCode());		
		        result = prime * result + ((getManufacturerName() == null) ? 0 : getManufacturerName().hashCode());		
		        result = prime * result + ((getManufacturerId() == null) ? 0 : getManufacturerId().hashCode());		
		        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());		
		        result = prime * result + ((getSim() == null) ? 0 : getSim().hashCode());		
		        result = prime * result + ((getDsmId() == null) ? 0 : getDsmId().hashCode());		
		        result = prime * result + ((getAdasId() == null) ? 0 : getAdasId().hashCode());		
		        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());		
		;
        return result;
    }

}
