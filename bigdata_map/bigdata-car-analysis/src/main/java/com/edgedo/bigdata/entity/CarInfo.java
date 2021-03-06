package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("car_info")
public class CarInfo implements Serializable{
	
		
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
	 * 属性描述:车牌号
	 */
	@TableField(value="CAR_PLATE_NUM",exist=true)
	String carPlateNum;

	/**
	 * 属性描述:车牌颜色
	 */
	@TableField(value="CAR_PLATE_COLOUR",exist=true)
	String carPlateColour;
	/**
	 * 车牌颜色
	 */
	@TableField(value="CAR_PLATE_COLOR_TEXT",exist=true)
	java.lang.String carPlateColorText;

	/**
	 * 属性描述:车架号
	 */
	@TableField(value="CAR_FRAME_NUM",exist=true)
	String carFrameNum;

	/**
	 * 属性描述:许可证号
	 */
	@TableField(value="LICENSE_CODE",exist=true)
	String licenseCode;

	/**
	 * 属性描述:业户名称
	 */
	@TableField(value="OWNER_NAME",exist=true)
	String ownerName;

	/**
	 * 属性描述:联系电话
	 */
	@TableField(value="OWNER_PHONE_NUM",exist=true)
	String ownerPhoneNum;

	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	String carType;

	/**
	 * 属性描述:车辆品牌
	 */
	@TableField(value="CAR_BRAND",exist=true)
	String carBrand;

	/**
	 * 属性描述:车辆型号
	 */
	@TableField(value="CAR_MODEL",exist=true)
	String carModel;

	/**
	 * 属性描述:外廓尺寸-长
	 */
	@TableField(value="OUTSIZE_LENGTH",exist=true)
	BigDecimal outsizeLength;

	/**
	 * 属性描述:外廓尺寸-宽
	 */
	@TableField(value="OUTSIZE_WIDTH",exist=true)
	BigDecimal outsizeWidth;

	/**
	 * 属性描述:外廓尺寸-高
	 */
	@TableField(value="OUTSIZE_HEIGHT",exist=true)
	BigDecimal outsizeHeight;

	/**
	 * 属性描述:北斗运营商
	 */
	@TableField(value="BEIDOU_OPERATOR",exist=true)
	String beidouOperator;

	/**
	 * 属性描述:所属车队ID
	 */
	@TableField(value="OWNER_TEAM_ID",exist=true)
	String ownerTeamId;

	/**
	 * 属性描述:所属车队名
	 */
	@TableField(value="OWNER_TEAM_NAME",exist=true)
	String ownerTeamName;

	/**
	 * 属性描述:行驶状态
	 */
	@TableField(value="RUN_STATE",exist=true)
	String runState;

	/**
	 * 属性描述:车辆来源
	 */
	@TableField(value="CAR_SOURCE",exist=true)
	String carSource;

	/**
	 * 属性描述:经度
	 */
	@TableField(value="LONGITUDE",exist=true)
	BigDecimal longitude;

	/**
	 * 属性描述:纬度
	 */
	@TableField(value="LATITUDE",exist=true)
	BigDecimal latitude;

	/**
	 * 属性描述:当前省ID
	 */
	@TableField(value="CURRENT_PROVINCE_ID",exist=true)
	String currentProvinceId;

	/**
	 * 属性描述:当前省名
	 */
	@TableField(value="CURRENT_PROVINCE_NAME",exist=true)
	String currentProvinceName;

	/**
	 * 属性描述:当前城市ID
	 */
	@TableField(value="CURRENT_CITY_ID",exist=true)
	String currentCityId;

	/**
	 * 属性描述:当前城市名
	 */
	@TableField(value="CURRENT_CITY_NAME",exist=true)
	String currentCityName;

	/**
	 * 属性描述:当前县区ID
	 */
	@TableField(value="CURRENT_XIANQU_ID",exist=true)
	String currentXianquId;

	/**
	 * 属性描述:当前县区名
	 */
	@TableField(value="CURRENT_XIANQU_NAME",exist=true)
	String currentXianquName;

	/**
	 * 属性描述:地理位置信息
	 */
	@TableField(value="LOCALTION_INFO",exist=true)
	String localtionInfo;

	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	String dataState;
	/**
	 * 属性描述:上线状态
	 */
	@TableField(value="ONLINE_STATE",exist=true)
	String onlineState;
	/**
	 * 属性描述:运营状态
	 */
	@TableField(value="OPERAT_FLAG",exist=true)
	String operatFlag;
	/**
     * 核载质量
	 */
	@TableField(value="total_take_mass",exist=true)
	BigDecimal totalTakeMass;
	/**
	 * 准牵引质量
	 */
	@TableField(value="total_pull_mass",exist=true)
	BigDecimal totalPullMass;
	/**
	 * 核载人数
 	 */
	@TableField(value="sit_people_num",exist=true)
	Integer sitPeopleNum;
	/**
	 * 是否同步过
	 */
	@TableField(value="IS_SYN_CAR",exist=true)
	String  isSynCar;
	/**
	 * 日行驶总时长
	 */
	@TableField(value="TODAY_TIME_TOTAL")
	BigDecimal todayTimeTotal;
	/**
	 * 日总里程
	 */
	@TableField(value="TODAY_MILEAGE_TOTAL")
	BigDecimal todayMileageTotal;

	/**
	 * 属性描述:清晨时长
	 */
	@TableField(value="MORNING_MINUTE_NUM",exist=true)
	BigDecimal morningMinuteNum;

	/**
	 * 属性描述:中午时长
	 */
	@TableField(value="NOON_MINUTE_NUM",exist=true)
	BigDecimal noonMinuteNum;

	/**
	 * 属性描述:黄昏时长
	 */
	@TableField(value="DUSK_MINUTE_NUM",exist=true)
	BigDecimal duskMinuteNum;

	/**
	 * 属性描述:凌晨时长
	 */
	@TableField(value="LINGCHEN_MINUTE_NUM",exist=true)
	BigDecimal lingchenMinuteNum;

	/**
	 * 属性描述:午夜时长
	 */
	@TableField(value="MIDNIGHT_MINUTE_NUM",exist=true)
	BigDecimal midnightMinuteNum;

	/**
	 * 属性描述:清晨里程
	 */
	@TableField(value="MORNING_MILEAGE",exist=true)
	java.math.BigDecimal morningMileage;

	/**
	 * 属性描述:中午里程
	 */
	@TableField(value="NOON_MILEAGE",exist=true)
	java.math.BigDecimal noonMileage;

	/**
	 * 属性描述:黄昏里程
	 */
	@TableField(value="DUSK_MILEAGE",exist=true)
	java.math.BigDecimal duskMileage;

	/**
	 * 属性描述:午夜里程
	 */
	@TableField(value="MIDNIGHT_MILEAGE",exist=true)
	java.math.BigDecimal midnightMileage;

	/**
	 * 属性描述:凌晨里程
	 */
	@TableField(value="LINGCHEN_MILEAGE",exist=true)
	java.math.BigDecimal lingchenMileage;

	/**
	 * 属性描述:从业人员id
	 */
	@TableField(value="EMP_ID",exist=true)
	String empId;
	/**
	 * 属性描述:姓名
	 */
	@TableField(value="EMP_NAME",exist=true)
	String empName;
	/**
	 * 属性描述:资格证号
	 */
	@TableField(value="EMP_CODE",exist=true)
	String empCode;
	/**
	 * 属性描述:电话
	 */
	@TableField(value="EMP_PHONE",exist=true)
	String empPhone;

	/**
	 * 城市信息更新时间
	 */
	@TableField(value="AREA_UP_TIME",exist=true)
	Date areaUpTime;

	@TableField(value="LAST_POSITION_TIME",exist=true)
	java.util.Date lastPositionTime;

	@TableField(value="COM_ID",exist=true)
	String comId;

	@TableField(value="COM_NAME",exist=true)
	String comName;

	@TableField(value="CAR_TRANSIT_TYPE",exist=true)
	String carTransitType;
	//数据不合格原因
	@TableField(value="ERR_MSG",exist=true)
	String errMsg = "";
	//0不符合，1合格
	@TableField(value="QUALIFIED_STATE",exist=true)
	Integer qualifiedState = 1;

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Integer getQualifiedState() {
		return qualifiedState;
	}

	public void setQualifiedState(Integer qualifiedState) {
		this.qualifiedState = qualifiedState;
	}

	public String getCarTransitType() {
		return carTransitType;
	}

	public void setCarTransitType(String carTransitType) {
		this.carTransitType = carTransitType;
	}

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public Date getAreaUpTime() {
		return areaUpTime;
	}

	public void setAreaUpTime(Date areaUpTime) {
		this.areaUpTime = areaUpTime;
	}

	public Date getLastPositionTime() {
		return lastPositionTime;
	}

	public void setLastPositionTime(Date lastPositionTime) {
		this.lastPositionTime = lastPositionTime;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public BigDecimal getMorningMinuteNum() {
		return morningMinuteNum;
	}

	public void setMorningMinuteNum(BigDecimal morningMinuteNum) {
		this.morningMinuteNum = morningMinuteNum;
	}

	public BigDecimal getNoonMinuteNum() {
		return noonMinuteNum;
	}

	public void setNoonMinuteNum(BigDecimal noonMinuteNum) {
		this.noonMinuteNum = noonMinuteNum;
	}

	public BigDecimal getDuskMinuteNum() {
		return duskMinuteNum;
	}

	public void setDuskMinuteNum(BigDecimal duskMinuteNum) {
		this.duskMinuteNum = duskMinuteNum;
	}

	public BigDecimal getLingchenMinuteNum() {
		return lingchenMinuteNum;
	}

	public void setLingchenMinuteNum(BigDecimal lingchenMinuteNum) {
		this.lingchenMinuteNum = lingchenMinuteNum;
	}

	public BigDecimal getMidnightMinuteNum() {
		return midnightMinuteNum;
	}

	public void setMidnightMinuteNum(BigDecimal midnightMinuteNum) {
		this.midnightMinuteNum = midnightMinuteNum;
	}

	public BigDecimal getMorningMileage() {
		return morningMileage;
	}

	public void setMorningMileage(BigDecimal morningMileage) {
		this.morningMileage = morningMileage;
	}

	public BigDecimal getNoonMileage() {
		return noonMileage;
	}

	public void setNoonMileage(BigDecimal noonMileage) {
		this.noonMileage = noonMileage;
	}

	public BigDecimal getDuskMileage() {
		return duskMileage;
	}

	public void setDuskMileage(BigDecimal duskMileage) {
		this.duskMileage = duskMileage;
	}

	public BigDecimal getMidnightMileage() {
		return midnightMileage;
	}

	public void setMidnightMileage(BigDecimal midnightMileage) {
		this.midnightMileage = midnightMileage;
	}

	public BigDecimal getLingchenMileage() {
		return lingchenMileage;
	}

	public void setLingchenMileage(BigDecimal lingchenMileage) {
		this.lingchenMileage = lingchenMileage;
	}

	public BigDecimal getTodayTimeTotal() {
		return todayTimeTotal;
	}

	public void setTodayTimeTotal(BigDecimal todayTimeTotal) {
		this.todayTimeTotal = todayTimeTotal;
	}

	public BigDecimal getTodayMileageTotal() {
		return todayMileageTotal;
	}

	public void setTodayMileageTotal(BigDecimal todayMileageTotal) {
		this.todayMileageTotal = todayMileageTotal;
	}

	public String getIsSynCar() {
		return isSynCar;
	}

	public void setIsSynCar(String isSynCar) {
		this.isSynCar = isSynCar;
	}

	public String getCarPlateColorText() {
		return carPlateColorText;
	}

	public void setCarPlateColorText(String carPlateColorText) {
		this.carPlateColorText = carPlateColorText;
	}

	public Integer getSitPeopleNum() {
		return sitPeopleNum;
	}

	public void setSitPeopleNum(Integer sitPeopleNum) {
		this.sitPeopleNum = sitPeopleNum;
	}

	public BigDecimal getTotalTakeMass() {
		return totalTakeMass;
	}

	public void setTotalTakeMass(BigDecimal totalTakeMass) {
		this.totalTakeMass = totalTakeMass;
	}

	public BigDecimal getTotalPullMass() {
		return totalPullMass;
	}

	public void setTotalPullMass(BigDecimal totalPullMass) {
		this.totalPullMass = totalPullMass;
	}

	public String getOnlineState() {
		return onlineState;
	}

	public void setOnlineState(String onlineState) {
		this.onlineState = onlineState;
	}

	public String getOperatFlag() {
		return operatFlag;
	}

	public void setOperatFlag(String operatFlag) {
		this.operatFlag = operatFlag;
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


	public String getCarPlateNum(){
		return this.carPlateNum;
	}

	public void setCarPlateNum(String carPlateNum){
		this.carPlateNum=carPlateNum;
	}


	public String getCarPlateColour(){
		return this.carPlateColour;
	}

	public void setCarPlateColour(String carPlateColour){
		this.carPlateColour=carPlateColour;
	}


	public String getCarFrameNum(){
		return this.carFrameNum;
	}

	public void setCarFrameNum(String carFrameNum){
		this.carFrameNum=carFrameNum;
	}


	public String getLicenseCode(){
		return this.licenseCode;
	}

	public void setLicenseCode(String licenseCode){
		this.licenseCode=licenseCode;
	}


	public String getOwnerName(){
		return this.ownerName;
	}

	public void setOwnerName(String ownerName){
		this.ownerName=ownerName;
	}


	public String getOwnerPhoneNum(){
		return this.ownerPhoneNum;
	}

	public void setOwnerPhoneNum(String ownerPhoneNum){
		this.ownerPhoneNum=ownerPhoneNum;
	}


	public String getCarType(){
		return this.carType;
	}

	public void setCarType(String carType){
		this.carType=carType;
	}


	public String getCarBrand(){
		return this.carBrand;
	}

	public void setCarBrand(String carBrand){
		this.carBrand=carBrand;
	}


	public String getCarModel(){
		return this.carModel;
	}

	public void setCarModel(String carModel){
		this.carModel=carModel;
	}


	public BigDecimal getOutsizeLength(){
		return this.outsizeLength;
	}

	public void setOutsizeLength(BigDecimal outsizeLength){
		this.outsizeLength=outsizeLength;
	}


	public BigDecimal getOutsizeWidth(){
		return this.outsizeWidth;
	}

	public void setOutsizeWidth(BigDecimal outsizeWidth){
		this.outsizeWidth=outsizeWidth;
	}


	public BigDecimal getOutsizeHeight(){
		return this.outsizeHeight;
	}

	public void setOutsizeHeight(BigDecimal outsizeHeight){
		this.outsizeHeight=outsizeHeight;
	}


	public String getBeidouOperator(){
		return this.beidouOperator;
	}

	public void setBeidouOperator(String beidouOperator){
		this.beidouOperator=beidouOperator;
	}


	public String getOwnerTeamId(){
		return this.ownerTeamId;
	}

	public void setOwnerTeamId(String ownerTeamId){
		this.ownerTeamId=ownerTeamId;
	}


	public String getOwnerTeamName(){
		return this.ownerTeamName;
	}

	public void setOwnerTeamName(String ownerTeamName){
		this.ownerTeamName=ownerTeamName;
	}


	public String getRunState(){
		return this.runState;
	}

	public void setRunState(String runState){
		this.runState=runState;
	}


	public String getCarSource(){
		return this.carSource;
	}

	public void setCarSource(String carSource){
		this.carSource=carSource;
	}


	public BigDecimal getLongitude(){
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude){
		this.longitude=longitude;
	}


	public BigDecimal getLatitude(){
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude){
		this.latitude=latitude;
	}


	public String getCurrentProvinceId(){
		return this.currentProvinceId;
	}

	public void setCurrentProvinceId(String currentProvinceId){
		this.currentProvinceId=currentProvinceId;
	}


	public String getCurrentProvinceName(){
		return this.currentProvinceName;
	}

	public void setCurrentProvinceName(String currentProvinceName){
		this.currentProvinceName=currentProvinceName;
	}


	public String getCurrentCityId(){
		return this.currentCityId;
	}

	public void setCurrentCityId(String currentCityId){
		this.currentCityId=currentCityId;
	}


	public String getCurrentCityName(){
		return this.currentCityName;
	}

	public void setCurrentCityName(String currentCityName){
		this.currentCityName=currentCityName;
	}


	public String getCurrentXianquId(){
		return this.currentXianquId;
	}

	public void setCurrentXianquId(String currentXianquId){
		this.currentXianquId=currentXianquId;
	}


	public String getCurrentXianquName(){
		return this.currentXianquName;
	}

	public void setCurrentXianquName(String currentXianquName){
		this.currentXianquName=currentXianquName;
	}


	public String getLocaltionInfo(){
		return this.localtionInfo;
	}

	public void setLocaltionInfo(String localtionInfo){
		this.localtionInfo=localtionInfo;
	}


	public String getDataState(){
		return this.dataState;
	}

	public void setDataState(String dataState){
		this.dataState=dataState;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", provinceId=").append(provinceId);			
			sb.append(", provinceName=").append(provinceName);			
			sb.append(", cityId=").append(cityId);			
			sb.append(", cityName=").append(cityName);			
			sb.append(", xianquId=").append(xianquId);			
			sb.append(", xianquName=").append(xianquName);			
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carPlateColour=").append(carPlateColour);			
			sb.append(", carFrameNum=").append(carFrameNum);			
			sb.append(", licenseCode=").append(licenseCode);			
			sb.append(", ownerName=").append(ownerName);			
			sb.append(", ownerPhoneNum=").append(ownerPhoneNum);			
			sb.append(", carType=").append(carType);			
			sb.append(", carBrand=").append(carBrand);			
			sb.append(", carModel=").append(carModel);			
			sb.append(", outsizeLength=").append(outsizeLength);			
			sb.append(", outsizeWidth=").append(outsizeWidth);			
			sb.append(", outsizeHeight=").append(outsizeHeight);			
			sb.append(", beidouOperator=").append(beidouOperator);			
			sb.append(", ownerTeamId=").append(ownerTeamId);			
			sb.append(", ownerTeamName=").append(ownerTeamName);			
			sb.append(", runState=").append(runState);			
			sb.append(", carSource=").append(carSource);			
			sb.append(", longitude=").append(longitude);			
			sb.append(", latitude=").append(latitude);			
			sb.append(", currentProvinceId=").append(currentProvinceId);			
			sb.append(", currentProvinceName=").append(currentProvinceName);			
			sb.append(", currentCityId=").append(currentCityId);			
			sb.append(", currentCityName=").append(currentCityName);			
			sb.append(", currentXianquId=").append(currentXianquId);			
			sb.append(", currentXianquName=").append(currentXianquName);			
			sb.append(", localtionInfo=").append(localtionInfo);			
			sb.append(", dataState=").append(dataState);			
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
        CarInfo other = (CarInfo) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getProvinceId() == null ? other.getId() == null : this.getProvinceId().equals(other.getProvinceId()))		
				        		&&(this.getProvinceName() == null ? other.getId() == null : this.getProvinceName().equals(other.getProvinceName()))		
				        		&&(this.getCityId() == null ? other.getId() == null : this.getCityId().equals(other.getCityId()))		
				        		&&(this.getCityName() == null ? other.getId() == null : this.getCityName().equals(other.getCityName()))		
				        		&&(this.getXianquId() == null ? other.getId() == null : this.getXianquId().equals(other.getXianquId()))		
				        		&&(this.getXianquName() == null ? other.getId() == null : this.getXianquName().equals(other.getXianquName()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarPlateColour() == null ? other.getId() == null : this.getCarPlateColour().equals(other.getCarPlateColour()))		
				        		&&(this.getCarFrameNum() == null ? other.getId() == null : this.getCarFrameNum().equals(other.getCarFrameNum()))		
				        		&&(this.getLicenseCode() == null ? other.getId() == null : this.getLicenseCode().equals(other.getLicenseCode()))		
				        		&&(this.getOwnerName() == null ? other.getId() == null : this.getOwnerName().equals(other.getOwnerName()))		
				        		&&(this.getOwnerPhoneNum() == null ? other.getId() == null : this.getOwnerPhoneNum().equals(other.getOwnerPhoneNum()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getCarBrand() == null ? other.getId() == null : this.getCarBrand().equals(other.getCarBrand()))		
				        		&&(this.getCarModel() == null ? other.getId() == null : this.getCarModel().equals(other.getCarModel()))		
				        		&&(this.getOutsizeLength() == null ? other.getId() == null : this.getOutsizeLength().equals(other.getOutsizeLength()))		
				        		&&(this.getOutsizeWidth() == null ? other.getId() == null : this.getOutsizeWidth().equals(other.getOutsizeWidth()))		
				        		&&(this.getOutsizeHeight() == null ? other.getId() == null : this.getOutsizeHeight().equals(other.getOutsizeHeight()))		
				        		&&(this.getBeidouOperator() == null ? other.getId() == null : this.getBeidouOperator().equals(other.getBeidouOperator()))		
				        		&&(this.getOwnerTeamId() == null ? other.getId() == null : this.getOwnerTeamId().equals(other.getOwnerTeamId()))		
				        		&&(this.getOwnerTeamName() == null ? other.getId() == null : this.getOwnerTeamName().equals(other.getOwnerTeamName()))		
				        		&&(this.getRunState() == null ? other.getId() == null : this.getRunState().equals(other.getRunState()))		
				        		&&(this.getCarSource() == null ? other.getId() == null : this.getCarSource().equals(other.getCarSource()))		
				        		&&(this.getLongitude() == null ? other.getId() == null : this.getLongitude().equals(other.getLongitude()))		
				        		&&(this.getLatitude() == null ? other.getId() == null : this.getLatitude().equals(other.getLatitude()))		
				        		&&(this.getCurrentProvinceId() == null ? other.getId() == null : this.getCurrentProvinceId().equals(other.getCurrentProvinceId()))		
				        		&&(this.getCurrentProvinceName() == null ? other.getId() == null : this.getCurrentProvinceName().equals(other.getCurrentProvinceName()))		
				        		&&(this.getCurrentCityId() == null ? other.getId() == null : this.getCurrentCityId().equals(other.getCurrentCityId()))		
				        		&&(this.getCurrentCityName() == null ? other.getId() == null : this.getCurrentCityName().equals(other.getCurrentCityName()))		
				        		&&(this.getCurrentXianquId() == null ? other.getId() == null : this.getCurrentXianquId().equals(other.getCurrentXianquId()))		
				        		&&(this.getCurrentXianquName() == null ? other.getId() == null : this.getCurrentXianquName().equals(other.getCurrentXianquName()))		
				        		&&(this.getLocaltionInfo() == null ? other.getId() == null : this.getLocaltionInfo().equals(other.getLocaltionInfo()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());		
		        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());		
		        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());		
		        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());		
		        result = prime * result + ((getXianquId() == null) ? 0 : getXianquId().hashCode());		
		        result = prime * result + ((getXianquName() == null) ? 0 : getXianquName().hashCode());		
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarPlateColour() == null) ? 0 : getCarPlateColour().hashCode());		
		        result = prime * result + ((getCarFrameNum() == null) ? 0 : getCarFrameNum().hashCode());		
		        result = prime * result + ((getLicenseCode() == null) ? 0 : getLicenseCode().hashCode());		
		        result = prime * result + ((getOwnerName() == null) ? 0 : getOwnerName().hashCode());		
		        result = prime * result + ((getOwnerPhoneNum() == null) ? 0 : getOwnerPhoneNum().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCarBrand() == null) ? 0 : getCarBrand().hashCode());		
		        result = prime * result + ((getCarModel() == null) ? 0 : getCarModel().hashCode());		
		        result = prime * result + ((getOutsizeLength() == null) ? 0 : getOutsizeLength().hashCode());		
		        result = prime * result + ((getOutsizeWidth() == null) ? 0 : getOutsizeWidth().hashCode());		
		        result = prime * result + ((getOutsizeHeight() == null) ? 0 : getOutsizeHeight().hashCode());		
		        result = prime * result + ((getBeidouOperator() == null) ? 0 : getBeidouOperator().hashCode());		
		        result = prime * result + ((getOwnerTeamId() == null) ? 0 : getOwnerTeamId().hashCode());		
		        result = prime * result + ((getOwnerTeamName() == null) ? 0 : getOwnerTeamName().hashCode());		
		        result = prime * result + ((getRunState() == null) ? 0 : getRunState().hashCode());		
		        result = prime * result + ((getCarSource() == null) ? 0 : getCarSource().hashCode());		
		        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());		
		        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());		
		        result = prime * result + ((getCurrentProvinceId() == null) ? 0 : getCurrentProvinceId().hashCode());		
		        result = prime * result + ((getCurrentProvinceName() == null) ? 0 : getCurrentProvinceName().hashCode());		
		        result = prime * result + ((getCurrentCityId() == null) ? 0 : getCurrentCityId().hashCode());		
		        result = prime * result + ((getCurrentCityName() == null) ? 0 : getCurrentCityName().hashCode());		
		        result = prime * result + ((getCurrentXianquId() == null) ? 0 : getCurrentXianquId().hashCode());		
		        result = prime * result + ((getCurrentXianquName() == null) ? 0 : getCurrentXianquName().hashCode());		
		        result = prime * result + ((getLocaltionInfo() == null) ? 0 : getLocaltionInfo().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
