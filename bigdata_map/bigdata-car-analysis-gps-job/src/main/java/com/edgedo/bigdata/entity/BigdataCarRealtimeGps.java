package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BigdataCarRealtimeGps extends BigdataCarRealtimeSimple implements Serializable{



	/**
	 * 属性描述:车架号
	 */
	String carFrameNum;

	/**
	 * 属性描述:车辆状态
	 */
	String carState;

	/**
	 * 属性描述:报警状态
	 */
	String alarmState;


	/**
	 * 属性描述:数据更新时间
	 */
	java.util.Date lastUpTime;

	/**
	 * 属性描述:位置国家
	 */
	String mapCountry;

	/**
	 * 属性描述:位置省份
	 */
	String mapProvince;
	/**
	 * 属性描述:位置省份id
	 */
	String mapProvinceId;

	/**
	 * 属性描述:位置城市
	 */
	String mapCity;
	/**
	 * 属性描述:位置城市id
	 */
	String mapCityId;

	/**
	 * 属性描述:位置县区
	 */
	String mapXianqu;
	/**
	 * 属性描述:位置县区id
	 */
	String mapXianquId;

	/**
	 * 属性描述:详细位置
	 */
	String mapDetail;

	/**
	 * 属性描述:开始里程
	 */
	java.math.BigDecimal beginMileage = new BigDecimal(0);

	/**
	 * 属性描述:开始里程时间
	 */
	java.util.Date beginTime;

	/**
	 * 属性描述:当日是否运营
	 */
	String operatFlag="0";

	/**
	 * 属性描述:onlineState
	 */
	java.lang.String onlineState="0";

	/**
	 * 城市信息更新时间
	 */
	Date areaUpTime;

	BigDecimal todayTimeTotal= new BigDecimal(0);

	BigDecimal todayMileageTotal= new BigDecimal(0);
	/**
	 * 数据ip地址
	 */
	String ip;
	/**
	 * 属性描述:停车纬度
	 */
	java.math.BigDecimal stopLat;

	/**
	 * 属性描述:停车经度
	 */
	java.math.BigDecimal stopLong;

	/**
	 * 停车分钟数
	 */
	Integer stopMinuteNum;
	/**
	 * 停车开始时间
	 */
	Date stopBeginTime;
	/**
	 * 停车截止时间
	 */
	Date stopEndTime;


	/**
	 * 属性描述:清晨时长
	 */
	BigDecimal morningMinuteNum= new BigDecimal(0);

	/**
	 * 属性描述:中午时长
	 */
	BigDecimal noonMinuteNum= new BigDecimal(0);

	/**
	 * 属性描述:黄昏时长
	 */
	BigDecimal duskMinuteNum= new BigDecimal(0);

	/**
	 * 属性描述:凌晨时长
	 */
	BigDecimal lingchenMinuteNum= new BigDecimal(0);

	/**
	 * 属性描述:午夜时长
	 */
	BigDecimal midnightMinuteNum= new BigDecimal(0);

	/**
	 * 属性描述:清晨里程
	 */
	java.math.BigDecimal morningMileage= new BigDecimal(0);

	/**
	 * 属性描述:中午里程
	 */
	java.math.BigDecimal noonMileage= new BigDecimal(0);

	/**
	 * 属性描述:黄昏里程
	 */
	java.math.BigDecimal duskMileage= new BigDecimal(0);

	/**
	 * 属性描述:午夜里程
	 */
	java.math.BigDecimal midnightMileage= new BigDecimal(0);

	/**
	 * 属性描述:凌晨里程
	 */
	java.math.BigDecimal lingchenMileage= new BigDecimal(0);
	//数据不合格原因
	String errMsg="";
	//0不符合，1合格
	Integer qualifiedState = 1;
	//gps上传上来的车牌号可能包含特殊符号#123-_这些，将这个存起来通过这个来查轨迹
	private String gpsCarPlateNum;
	//上次定位点的ip用来决定优先级
	private String lastIp;
	//上次定位ip的时间
	private Date lastIpTime;

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Date getLastIpTime() {
		return lastIpTime;
	}

	public void setLastIpTime(Date lastIpTime) {
		this.lastIpTime = lastIpTime;
	}

	public String getGpsCarPlateNum() {
		return gpsCarPlateNum;
	}

	public void setGpsCarPlateNum(String gpsCarPlateNum) {
		this.gpsCarPlateNum = gpsCarPlateNum;
	}

	public Integer getQualifiedState() {
		return qualifiedState;
	}

	public void setQualifiedState(Integer qualifiedState) {
		this.qualifiedState = qualifiedState;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public BigDecimal getLingchenMileage() {
		return lingchenMileage;
	}

	public void setLingchenMileage(BigDecimal lingchenMileage) {
		this.lingchenMileage = lingchenMileage;
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

	public void setMidnightMileage(BigDecimal midnightMileage) {
		this.midnightMileage = midnightMileage;
	}

	public String getMapProvinceId() {
		return mapProvinceId;
	}

	public void setMapProvinceId(String mapProvinceId) {
		this.mapProvinceId = mapProvinceId;
	}

	public String getMapCityId() {
		return mapCityId;
	}

	public void setMapCityId(String mapCityId) {
		this.mapCityId = mapCityId;
	}

	public String getMapXianquId() {
		return mapXianquId;
	}

	public void setMapXianquId(String mapXianquId) {
		this.mapXianquId = mapXianquId;
	}

	public BigDecimal getStopLat() {
		return stopLat;
	}

	public void setStopLat(BigDecimal stopLat) {
		this.stopLat = stopLat;
	}

	public BigDecimal getStopLong() {
		return stopLong;
	}

	public void setStopLong(BigDecimal stopLong) {
		this.stopLong = stopLong;
	}

	public Integer getStopMinuteNum() {
		return stopMinuteNum;
	}

	public void setStopMinuteNum(Integer stopMinuteNum) {
		this.stopMinuteNum = stopMinuteNum;
	}

	public Date getStopBeginTime() {
		return stopBeginTime;
	}

	public void setStopBeginTime(Date stopBeginTime) {
		this.stopBeginTime = stopBeginTime;
	}

	public Date getStopEndTime() {
		return stopEndTime;
	}

	public void setStopEndTime(Date stopEndTime) {
		this.stopEndTime = stopEndTime;
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

	public Date getAreaUpTime() {
		return areaUpTime;
	}

	public void setAreaUpTime(Date areaUpTime) {
		this.areaUpTime = areaUpTime;
	}

	public String getOnlineState() {
		return onlineState;
	}

	public void setOnlineState(String onlineState) {
		this.onlineState = onlineState;
	}

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}



	public String getCarFrameNum(){
		return this.carFrameNum;
	}

	public void setCarFrameNum(String carFrameNum){
		this.carFrameNum=carFrameNum;
	}

	public String getCarState(){
		return this.carState;
	}

	public void setCarState(String carState){
		this.carState=carState;
	}


	public String getAlarmState(){
		return this.alarmState;
	}

	public void setAlarmState(String alarmState){
		this.alarmState=alarmState;
	}


	public java.util.Date getLastUpTime(){
		return this.lastUpTime;
	}

	public void setLastUpTime(java.util.Date lastUpTime){
		this.lastUpTime=lastUpTime;
	}


	public String getMapCountry(){
		return this.mapCountry;
	}

	public void setMapCountry(String mapCountry){
		this.mapCountry=mapCountry;
	}


	public String getMapProvince(){
		return this.mapProvince;
	}

	public void setMapProvince(String mapProvince){
		this.mapProvince=mapProvince;
	}


	public String getMapCity(){
		return this.mapCity;
	}

	public void setMapCity(String mapCity){
		this.mapCity=mapCity;
	}


	public String getMapXianqu(){
		return this.mapXianqu;
	}

	public void setMapXianqu(String mapXianqu){
		this.mapXianqu=mapXianqu;
	}


	public String getMapDetail(){
		return this.mapDetail;
	}

	public void setMapDetail(String mapDetail){
		this.mapDetail=mapDetail;
	}


	public java.math.BigDecimal getBeginMileage(){
		return this.beginMileage;
	}

	public void setBeginMileage(java.math.BigDecimal beginMileage){
		this.beginMileage=beginMileage;
	}


	public java.util.Date getBeginTime(){
		return this.beginTime;
	}

	public void setBeginTime(java.util.Date beginTime){
		this.beginTime=beginTime;
	}


	public String getOperatFlag(){
		return this.operatFlag;
	}

	public void setOperatFlag(String operatFlag){
		this.operatFlag=operatFlag;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


}
