package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

@TableName("bigdata_time_car_day_rec")
public class BigdataTimeCarDayRec implements Serializable{
	
		
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
	 * 属性描述:车牌颜色文本
	 */
	@TableField(value="CAR_PLATE_COLOR_TEXT",exist=true)
	String carPlateColorText;

	/**
	 * 属性描述:所属企业ID
	 */
	@TableField(value="OWNER_TEAM_ID",exist=true)
	String ownerTeamId;

	/**
	 * 属性描述:所属企业名
	 */
	@TableField(value="OWNER_TEAM_NAME",exist=true)
	String ownerTeamName;

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
	 * 属性描述:凌晨时长
	 */
	@TableField(value="LINGCHEN_TIME",exist=true)
	java.math.BigDecimal lingchenTime;

	/**
	 * 属性描述:凌晨里程
	 */
	@TableField(value="LINGCHEN_MILEAGE",exist=true)
	java.math.BigDecimal lingchenMileage;

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
	String carType;

	/**
	 * 属性描述:统计时间
	 */
	@TableField(value="COUNT_TIME",exist=true)
	java.util.Date countTime;

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
	 * 属性描述:上线状态
	 */
	@TableField(value="ONLINE_STATE",exist=true)
	String onlineState;

	/**
	 * 属性描述:是否运营
	 */
	@TableField(value="OPERAT_FLAG",exist=true)
	String operatFlag;

	/**
	 * 属性描述:一类危险时段
	 */
	@TableField(value="FIRST_DANGER_TIME_FLAG",exist=true)
	Integer firstDangerTimeFlag;

	/**
	 * 属性描述:二类危险时段
	 */
	@TableField(value="SECOND_DANGER_TIME_FLAG",exist=true)
	Integer secondDangerTimeFlag;

	/**
	 * 属性描述:三类危险时段
	 */
	@TableField(value="THIRD_DANGER_TIME_FLAG",exist=true)
	Integer thirdDangerTimeFlag;

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
	 * 属性描述:统计年份
	 */
	@TableField(value="YEAR_NUM",exist=true)
	Integer yearNum;
	/**
	 * 属性描述:联系人姓名
	 */
	@TableField(value="OWNER_NAME",exist=true)
	String ownerName;
	/**
	 * 属性描述:联系电话
	 */
	@TableField(value="OWNER_PHONE_NUM",exist=true)
	String ownerPhoneNum;

	/**
	 * 属性描述:是否超速
	 */
	@TableField(value="IS_OVER_SPEED",exist=true)
	String isOverSpeed;

	/**
	 * 属性描述:是否超速
	 */
	@TableField(value="OVER_SPEED_NUM",exist=true)
	Integer overSpeedNum;

	/**
	 * 属性描述:是否严重超速
	 */
	@TableField(value="IS_SERIOUS_OVER_SPEED",exist=true)
	String isSeriousOverSpeed;

	/**
	 * 属性描述:是否超速
	 */
	@TableField(value="SERIOUS_OVER_SPEED_NUM",exist=true)
	Integer seriousOverSpeedNum;


	/**
	 * 属性描述:是否疲劳
	 */
	@TableField(value="IS_FATIGUE",exist=true)
	String isFatigue;

	/**
	 * 属性描述:疲劳次数
	 */
	@TableField(value="FATIGUE_NUM",exist=true)
	Integer fatigueNum;

	/**
	 * 属性描述:是否严重疲劳
	 */
	@TableField(value="IS_SERIOUS_FATIGUE",exist=true)
	String isSeriousFatigue;
	/**
	 * 属性描述:是否高速超速
	 */
	@TableField(value="IS_HIGH_WAY_OVER_SPEED",exist=true)
	String isHighWayOverSpeed;
	/**
	 * 属性描述:高速超速次数
	 */
	@TableField(value="HIGH_WAY_OVER_SPEED_NUM",exist=true)
	Integer highWayOverSpeedNum;
	/**
	 * 属性描述:是否国道超速
	 */
	@TableField(value="IS_GUODAO_OVER_SPEED",exist=true)
	String isGuodaoOverSpeed;
	/**
	 * 属性描述:国道超速次数
	 */
	@TableField(value="GUODAO_OVER_SPEED_NUM",exist=true)
	Integer guodaoOverSpeedNum;

	/**
	 * 属性描述:是否危险时段超速
	 */
	@TableField(value="IS_DANGER_OVER_SPEED",exist=true)
	String isDangerOverSpeed;
	/**
	 * 属性描述:危险时段超速次数
	 */
	@TableField(value="DANGER_OVER_SPEED_NUM",exist=true)
	Integer dangerOverSpeedNum;

	/**
	 * 属性描述:是否危险时段疲劳
	 */
	@TableField(value="IS_DANGER_FATIGUE",exist=true)
	String isDangerFatigue;
	/**
	 * 属性描述:危险时段疲劳次数
	 */
	@TableField(value="DANGER_FATIGUE_NUM",exist=true)
	Integer dangerFatigueNum;


	/**
	 * 属性描述:是否高速严重超速
	 */
	@TableField(value="IS_HIGH_WAY_SER_OVER_SPEED",exist=true)
	String isHighWaySerOverSpeed;
	/**
	 * 属性描述:高速严重超速次数
	 */
	@TableField(value="HIGH_WAY_SER_OVER_SPEED_NUM",exist=true)
	Integer highWaySerOverSpeedNum;
	/**
	 * 属性描述:是否国道严重超速
	 */
	@TableField(value="IS_GUODAO_SER_OVER_SPEED",exist=true)
	String isGuodaoSerOverSpeed;
	/**
	 * 属性描述:危险时段疲劳次数
	 */
	@TableField(value="GUODAO_SER_OVER_SPEED_NUM",exist=true)
	Integer guodaoSerOverSpeedNum;
	/**
	 * 属性描述:是否国道危险时段超速
	 */
	@TableField(value="IS_GUODAO_DANGER_OVER_SPEED",exist=true)
	String isGuodaoDangerOverSpeed;
	/**
	 * 属性描述:国道危险时段超速次数
	 */
	@TableField(value="GUODAO_DANGER_OVER_SPEED_NUM",exist=true)
	Integer guodaoDangerOverSpeedNum;
	/**
	 * 属性描述:是否危险时段疲劳
	 */
	@TableField(value="IS_HIGH_WAY_DANGER_OVER_SPEED",exist=true)
	String isHighWayDangerOverSpeed;
	/**
	 * 属性描述:危险时段疲劳次数
	 */
	@TableField(value="HIGH_WAY_DANGER_OVER_SPEED_NUM",exist=true)
	Integer highWayDangerOverSpeedNum;

	/**
	 * 属性描述:从业人员姓名
	 */
	@TableField(value="EMP_NAME",exist=true)
	String empName;
	/**
	 * 属性描述:从业人员资格证号
	 */
	@TableField(value="EMP_CODE",exist=true)
	String empCode;
	/**
	 * 属性描述:从业人员联系电话
	 */
	@TableField(value="EMP_PHONE",exist=true)
	String empPhone;
	/**
	 * 属性描述:从业人员主键
	 */
	@TableField(value="EMP_ID",exist=true)
	String empId;

	@TableField(value="AVG_SPEED",exist=true)
	java.math.BigDecimal avgSpeed;

	//运输类型
	@TableField(value="TRANSIT_TYPE",exist=true)
	String transitType;

	//安全评分
	@TableField(value="SAFE_SCORE",exist=true)
	java.math.BigDecimal safeScore;

	//报警数量
	@TableField(value="ALARM_NUM",exist=true)
	java.lang.Integer alarmNum;
	//常规报警数量
	@TableField(value="COMMON_ALARM_NUM",exist=true)
	java.lang.Integer commonAlarmNum;
	//常规处理数量
	@TableField(value="COMMON_HANDLE_NUM",exist=true)
	java.lang.Integer commonHandleNum;
	//主动安全报警数量
	@TableField(value="SAFE_ALARM_NUM",exist=true)
	java.lang.Integer safeAlarmNum;
	//主动安全处理数量
	@TableField(value="SAFE_HANDLE_NUM",exist=true)
	java.lang.Integer safeHandleNum;
	//是否报警
	@TableField(value="IS_ALARM",exist=true)
	java.lang.String isAlarm;
	//是否合格
	@TableField(value="QUALIFIED_STATE",exist=true)
	java.lang.Integer qualifiedState;

	public Integer getQualifiedState() {
		return qualifiedState;
	}

	public void setQualifiedState(Integer qualifiedState) {
		this.qualifiedState = qualifiedState;
	}

	public Integer getCommonAlarmNum() {
		return commonAlarmNum;
	}

	public void setCommonAlarmNum(Integer commonAlarmNum) {
		this.commonAlarmNum = commonAlarmNum;
	}

	public Integer getCommonHandleNum() {
		return commonHandleNum;
	}

	public void setCommonHandleNum(Integer commonHandleNum) {
		this.commonHandleNum = commonHandleNum;
	}

	public Integer getSafeAlarmNum() {
		return safeAlarmNum;
	}

	public void setSafeAlarmNum(Integer safeAlarmNum) {
		this.safeAlarmNum = safeAlarmNum;
	}

	public Integer getSafeHandleNum() {
		return safeHandleNum;
	}

	public void setSafeHandleNum(Integer safeHandleNum) {
		this.safeHandleNum = safeHandleNum;
	}

	public String getIsAlarm() {
		return isAlarm;
	}

	public void setIsAlarm(String isAlarm) {
		this.isAlarm = isAlarm;
	}

	public String getTransitType() {
		return transitType;
	}

	public void setTransitType(String transitType) {
		this.transitType = transitType;
	}

	public BigDecimal getSafeScore() {
		return safeScore;
	}

	public void setSafeScore(BigDecimal safeScore) {
		this.safeScore = safeScore;
	}

	public Integer getAlarmNum() {
		return alarmNum;
	}

	public void setAlarmNum(Integer alarmNum) {
		this.alarmNum = alarmNum;
	}

	public BigDecimal getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(BigDecimal avgSpeed) {
		this.avgSpeed = avgSpeed;
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

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getIsHighWaySerOverSpeed() {
		return isHighWaySerOverSpeed;
	}

	public void setIsHighWaySerOverSpeed(String isHighWaySerOverSpeed) {
		this.isHighWaySerOverSpeed = isHighWaySerOverSpeed;
	}

	public Integer getHighWaySerOverSpeedNum() {
		return highWaySerOverSpeedNum;
	}

	public void setHighWaySerOverSpeedNum(Integer highWaySerOverSpeedNum) {
		this.highWaySerOverSpeedNum = highWaySerOverSpeedNum;
	}

	public String getIsGuodaoSerOverSpeed() {
		return isGuodaoSerOverSpeed;
	}

	public void setIsGuodaoSerOverSpeed(String isGuodaoSerOverSpeed) {
		this.isGuodaoSerOverSpeed = isGuodaoSerOverSpeed;
	}

	public Integer getGuodaoSerOverSpeedNum() {
		return guodaoSerOverSpeedNum;
	}

	public void setGuodaoSerOverSpeedNum(Integer guodaoSerOverSpeedNum) {
		this.guodaoSerOverSpeedNum = guodaoSerOverSpeedNum;
	}

	public String getIsGuodaoDangerOverSpeed() {
		return isGuodaoDangerOverSpeed;
	}

	public void setIsGuodaoDangerOverSpeed(String isGuodaoDangerOverSpeed) {
		this.isGuodaoDangerOverSpeed = isGuodaoDangerOverSpeed;
	}

	public Integer getGuodaoDangerOverSpeedNum() {
		return guodaoDangerOverSpeedNum;
	}

	public void setGuodaoDangerOverSpeedNum(Integer guodaoDangerOverSpeedNum) {
		this.guodaoDangerOverSpeedNum = guodaoDangerOverSpeedNum;
	}

	public String getIsHighWayDangerOverSpeed() {
		return isHighWayDangerOverSpeed;
	}

	public void setIsHighWayDangerOverSpeed(String isHighWayDangerOverSpeed) {
		this.isHighWayDangerOverSpeed = isHighWayDangerOverSpeed;
	}

	public Integer getHighWayDangerOverSpeedNum() {
		return highWayDangerOverSpeedNum;
	}

	public void setHighWayDangerOverSpeedNum(Integer highWayDangerOverSpeedNum) {
		this.highWayDangerOverSpeedNum = highWayDangerOverSpeedNum;
	}

	public String getIsDangerOverSpeed() {
		return isDangerOverSpeed;
	}

	public void setIsDangerOverSpeed(String isDangerOverSpeed) {
		this.isDangerOverSpeed = isDangerOverSpeed;
	}

	public Integer getDangerOverSpeedNum() {
		return dangerOverSpeedNum;
	}

	public void setDangerOverSpeedNum(Integer dangerOverSpeedNum) {
		this.dangerOverSpeedNum = dangerOverSpeedNum;
	}

	public String getIsDangerFatigue() {
		return isDangerFatigue;
	}

	public void setIsDangerFatigue(String isDangerFatigue) {
		this.isDangerFatigue = isDangerFatigue;
	}

	public Integer getDangerFatigueNum() {
		return dangerFatigueNum;
	}

	public void setDangerFatigueNum(Integer dangerFatigueNum) {
		this.dangerFatigueNum = dangerFatigueNum;
	}

	public String getIsHighWayOverSpeed() {
		return isHighWayOverSpeed;
	}

	public void setIsHighWayOverSpeed(String isHighWayOverSpeed) {
		this.isHighWayOverSpeed = isHighWayOverSpeed;
	}

	public Integer getHighWayOverSpeedNum() {
		return highWayOverSpeedNum;
	}

	public void setHighWayOverSpeedNum(Integer highWayOverSpeedNum) {
		this.highWayOverSpeedNum = highWayOverSpeedNum;
	}

	public String getIsGuodaoOverSpeed() {
		return isGuodaoOverSpeed;
	}

	public void setIsGuodaoOverSpeed(String isGuodaoOverSpeed) {
		this.isGuodaoOverSpeed = isGuodaoOverSpeed;
	}

	public Integer getGuodaoOverSpeedNum() {
		return guodaoOverSpeedNum;
	}

	public void setGuodaoOverSpeedNum(Integer guodaoOverSpeedNum) {
		this.guodaoOverSpeedNum = guodaoOverSpeedNum;
	}

	public String getIsSeriousOverSpeed() {
		return isSeriousOverSpeed;
	}

	public void setIsSeriousOverSpeed(String isSeriousOverSpeed) {
		this.isSeriousOverSpeed = isSeriousOverSpeed;
	}

	public Integer getSeriousOverSpeedNum() {
		return seriousOverSpeedNum;
	}

	public void setSeriousOverSpeedNum(Integer seriousOverSpeedNum) {
		this.seriousOverSpeedNum = seriousOverSpeedNum;
	}

	public String getIsSeriousFatigue() {
		return isSeriousFatigue;
	}

	public void setIsSeriousFatigue(String isSeriousFatigue) {
		this.isSeriousFatigue = isSeriousFatigue;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPhoneNum() {
		return ownerPhoneNum;
	}

	public void setOwnerPhoneNum(String ownerPhoneNum) {
		this.ownerPhoneNum = ownerPhoneNum;
	}

	public String getIsOverSpeed() {
		return isOverSpeed;
	}

	public void setIsOverSpeed(String isOverSpeed) {
		this.isOverSpeed = isOverSpeed;
	}

	public Integer getOverSpeedNum() {
		return overSpeedNum;
	}

	public void setOverSpeedNum(Integer overSpeedNum) {
		this.overSpeedNum = overSpeedNum;
	}

	public String getIsFatigue() {
		return isFatigue;
	}

	public void setIsFatigue(String isFatigue) {
		this.isFatigue = isFatigue;
	}

	public Integer getFatigueNum() {
		return fatigueNum;
	}

	public void setFatigueNum(Integer fatigueNum) {
		this.fatigueNum = fatigueNum;
	}

	public Integer getYearNum() {
		return yearNum;
	}

	public void setYearNum(Integer yearNum) {
		this.yearNum = yearNum;
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


	public String getCarPlateColorText(){
		return this.carPlateColorText;
	}

	public void setCarPlateColorText(String carPlateColorText){
		this.carPlateColorText=carPlateColorText;
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


	public java.math.BigDecimal getLingchenTime(){
		return this.lingchenTime;
	}

	public void setLingchenTime(java.math.BigDecimal lingchenTime){
		this.lingchenTime=lingchenTime;
	}


	public java.math.BigDecimal getLingchenMileage(){
		return this.lingchenMileage;
	}

	public void setLingchenMileage(java.math.BigDecimal lingchenMileage){
		this.lingchenMileage=lingchenMileage;
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


	public String getOnlineState(){
		return this.onlineState;
	}

	public void setOnlineState(String onlineState){
		this.onlineState=onlineState;
	}


	public String getOperatFlag(){
		return this.operatFlag;
	}

	public void setOperatFlag(String operatFlag){
		this.operatFlag=operatFlag;
	}


	public Integer getFirstDangerTimeFlag(){
		return this.firstDangerTimeFlag;
	}

	public void setFirstDangerTimeFlag(Integer firstDangerTimeFlag){
		this.firstDangerTimeFlag=firstDangerTimeFlag;
	}


	public Integer getSecondDangerTimeFlag(){
		return this.secondDangerTimeFlag;
	}

	public void setSecondDangerTimeFlag(Integer secondDangerTimeFlag){
		this.secondDangerTimeFlag=secondDangerTimeFlag;
	}


	public Integer getThirdDangerTimeFlag(){
		return this.thirdDangerTimeFlag;
	}

	public void setThirdDangerTimeFlag(Integer thirdDangerTimeFlag){
		this.thirdDangerTimeFlag=thirdDangerTimeFlag;
	}


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

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carFrameNum=").append(carFrameNum);			
			sb.append(", carPlateColor=").append(carPlateColor);			
			sb.append(", carPlateColorText=").append(carPlateColorText);			
			sb.append(", ownerTeamId=").append(ownerTeamId);			
			sb.append(", ownerTeamName=").append(ownerTeamName);			
			sb.append(", earlyMorningMileage=").append(earlyMorningMileage);			
			sb.append(", earlyMorningTime=").append(earlyMorningTime);			
			sb.append(", noonMileage=").append(noonMileage);			
			sb.append(", noonTime=").append(noonTime);			
			sb.append(", duskMileage=").append(duskMileage);			
			sb.append(", duskTime=").append(duskTime);			
			sb.append(", nightMileage=").append(nightMileage);			
			sb.append(", nightTime=").append(nightTime);			
			sb.append(", lingchenTime=").append(lingchenTime);			
			sb.append(", lingchenMileage=").append(lingchenMileage);			
			sb.append(", sumMileage=").append(sumMileage);			
			sb.append(", sumDuration=").append(sumDuration);			
			sb.append(", carType=").append(carType);			
			sb.append(", countTime=").append(countTime);			
			sb.append(", provinceId=").append(provinceId);			
			sb.append(", provinceName=").append(provinceName);			
			sb.append(", cityId=").append(cityId);			
			sb.append(", cityName=").append(cityName);			
			sb.append(", xianquId=").append(xianquId);			
			sb.append(", xianquName=").append(xianquName);			
			sb.append(", onlineState=").append(onlineState);			
			sb.append(", operatFlag=").append(operatFlag);			
			sb.append(", firstDangerTimeFlag=").append(firstDangerTimeFlag);			
			sb.append(", secondDangerTimeFlag=").append(secondDangerTimeFlag);			
			sb.append(", thirdDangerTimeFlag=").append(thirdDangerTimeFlag);			
			sb.append(", countDate=").append(countDate);			
			sb.append(", countMonth=").append(countMonth);			
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
        BigdataTimeCarDayRec other = (BigdataTimeCarDayRec) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarFrameNum() == null ? other.getId() == null : this.getCarFrameNum().equals(other.getCarFrameNum()))		
				        		&&(this.getCarPlateColor() == null ? other.getId() == null : this.getCarPlateColor().equals(other.getCarPlateColor()))		
				        		&&(this.getCarPlateColorText() == null ? other.getId() == null : this.getCarPlateColorText().equals(other.getCarPlateColorText()))		
				        		&&(this.getOwnerTeamId() == null ? other.getId() == null : this.getOwnerTeamId().equals(other.getOwnerTeamId()))		
				        		&&(this.getOwnerTeamName() == null ? other.getId() == null : this.getOwnerTeamName().equals(other.getOwnerTeamName()))		
				        		&&(this.getEarlyMorningMileage() == null ? other.getId() == null : this.getEarlyMorningMileage().equals(other.getEarlyMorningMileage()))		
				        		&&(this.getEarlyMorningTime() == null ? other.getId() == null : this.getEarlyMorningTime().equals(other.getEarlyMorningTime()))		
				        		&&(this.getNoonMileage() == null ? other.getId() == null : this.getNoonMileage().equals(other.getNoonMileage()))		
				        		&&(this.getNoonTime() == null ? other.getId() == null : this.getNoonTime().equals(other.getNoonTime()))		
				        		&&(this.getDuskMileage() == null ? other.getId() == null : this.getDuskMileage().equals(other.getDuskMileage()))		
				        		&&(this.getDuskTime() == null ? other.getId() == null : this.getDuskTime().equals(other.getDuskTime()))		
				        		&&(this.getNightMileage() == null ? other.getId() == null : this.getNightMileage().equals(other.getNightMileage()))		
				        		&&(this.getNightTime() == null ? other.getId() == null : this.getNightTime().equals(other.getNightTime()))		
				        		&&(this.getLingchenTime() == null ? other.getId() == null : this.getLingchenTime().equals(other.getLingchenTime()))		
				        		&&(this.getLingchenMileage() == null ? other.getId() == null : this.getLingchenMileage().equals(other.getLingchenMileage()))		
				        		&&(this.getSumMileage() == null ? other.getId() == null : this.getSumMileage().equals(other.getSumMileage()))		
				        		&&(this.getSumDuration() == null ? other.getId() == null : this.getSumDuration().equals(other.getSumDuration()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getCountTime() == null ? other.getId() == null : this.getCountTime().equals(other.getCountTime()))		
				        		&&(this.getProvinceId() == null ? other.getId() == null : this.getProvinceId().equals(other.getProvinceId()))		
				        		&&(this.getProvinceName() == null ? other.getId() == null : this.getProvinceName().equals(other.getProvinceName()))		
				        		&&(this.getCityId() == null ? other.getId() == null : this.getCityId().equals(other.getCityId()))		
				        		&&(this.getCityName() == null ? other.getId() == null : this.getCityName().equals(other.getCityName()))		
				        		&&(this.getXianquId() == null ? other.getId() == null : this.getXianquId().equals(other.getXianquId()))		
				        		&&(this.getXianquName() == null ? other.getId() == null : this.getXianquName().equals(other.getXianquName()))		
				        		&&(this.getOnlineState() == null ? other.getId() == null : this.getOnlineState().equals(other.getOnlineState()))		
				        		&&(this.getOperatFlag() == null ? other.getId() == null : this.getOperatFlag().equals(other.getOperatFlag()))		
				        		&&(this.getFirstDangerTimeFlag() == null ? other.getId() == null : this.getFirstDangerTimeFlag().equals(other.getFirstDangerTimeFlag()))		
				        		&&(this.getSecondDangerTimeFlag() == null ? other.getId() == null : this.getSecondDangerTimeFlag().equals(other.getSecondDangerTimeFlag()))		
				        		&&(this.getThirdDangerTimeFlag() == null ? other.getId() == null : this.getThirdDangerTimeFlag().equals(other.getThirdDangerTimeFlag()))		
				        		&&(this.getCountDate() == null ? other.getId() == null : this.getCountDate().equals(other.getCountDate()))		
				        		&&(this.getCountMonth() == null ? other.getId() == null : this.getCountMonth().equals(other.getCountMonth()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarFrameNum() == null) ? 0 : getCarFrameNum().hashCode());		
		        result = prime * result + ((getCarPlateColor() == null) ? 0 : getCarPlateColor().hashCode());		
		        result = prime * result + ((getCarPlateColorText() == null) ? 0 : getCarPlateColorText().hashCode());		
		        result = prime * result + ((getOwnerTeamId() == null) ? 0 : getOwnerTeamId().hashCode());		
		        result = prime * result + ((getOwnerTeamName() == null) ? 0 : getOwnerTeamName().hashCode());		
		        result = prime * result + ((getEarlyMorningMileage() == null) ? 0 : getEarlyMorningMileage().hashCode());		
		        result = prime * result + ((getEarlyMorningTime() == null) ? 0 : getEarlyMorningTime().hashCode());		
		        result = prime * result + ((getNoonMileage() == null) ? 0 : getNoonMileage().hashCode());		
		        result = prime * result + ((getNoonTime() == null) ? 0 : getNoonTime().hashCode());		
		        result = prime * result + ((getDuskMileage() == null) ? 0 : getDuskMileage().hashCode());		
		        result = prime * result + ((getDuskTime() == null) ? 0 : getDuskTime().hashCode());		
		        result = prime * result + ((getNightMileage() == null) ? 0 : getNightMileage().hashCode());		
		        result = prime * result + ((getNightTime() == null) ? 0 : getNightTime().hashCode());		
		        result = prime * result + ((getLingchenTime() == null) ? 0 : getLingchenTime().hashCode());		
		        result = prime * result + ((getLingchenMileage() == null) ? 0 : getLingchenMileage().hashCode());		
		        result = prime * result + ((getSumMileage() == null) ? 0 : getSumMileage().hashCode());		
		        result = prime * result + ((getSumDuration() == null) ? 0 : getSumDuration().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());		
		        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());		
		        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());		
		        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());		
		        result = prime * result + ((getXianquId() == null) ? 0 : getXianquId().hashCode());		
		        result = prime * result + ((getXianquName() == null) ? 0 : getXianquName().hashCode());		
		        result = prime * result + ((getOnlineState() == null) ? 0 : getOnlineState().hashCode());		
		        result = prime * result + ((getOperatFlag() == null) ? 0 : getOperatFlag().hashCode());		
		        result = prime * result + ((getFirstDangerTimeFlag() == null) ? 0 : getFirstDangerTimeFlag().hashCode());		
		        result = prime * result + ((getSecondDangerTimeFlag() == null) ? 0 : getSecondDangerTimeFlag().hashCode());		
		        result = prime * result + ((getThirdDangerTimeFlag() == null) ? 0 : getThirdDangerTimeFlag().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		;
        return result;
    }

}
