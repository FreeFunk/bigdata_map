package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("bigdata_car_realtime_gps")
public class BigdataCarRealtimeGps implements Serializable{


		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;

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
	 * 属性描述:上次定位时间
	 */
	@TableField(value="LAST_POSITION_TIME",exist=true)
	java.util.Date lastPositionTime;

	/**
	 * 属性描述:纬度
	 */
	@TableField(value="POINT_LAT",exist=true)
	java.math.BigDecimal pointLat;

	/**
	 * 属性描述:经度
	 */
	@TableField(value="POINT_LONG",exist=true)
	java.math.BigDecimal pointLong;

	/**
	 * 属性描述:实时速度
	 */
	@TableField(value="REAL_SPEED",exist=true)
	java.math.BigDecimal realSpeed;

	/**
	 * 属性描述:gps速度
	 */
	@TableField(value="GPS_SPEED",exist=true)
	java.math.BigDecimal gpsSpeed;

	/**
	 * 属性描述:里程
	 */
	@TableField(value="MILEAGE",exist=true)
	java.math.BigDecimal mileage;

	/**
	 * 属性描述:方向
	 */
	@TableField(value="DIRECTION",exist=true)
	java.math.BigDecimal direction;

	/**
	 * 属性描述:海拔
	 */
	@TableField(value="ALTITUDE",exist=true)
	java.math.BigDecimal altitude;

	/**
	 * 属性描述:车辆状态
	 */
	@TableField(value="CAR_STATE",exist=true)
	String carState;

	/**
	 * 属性描述:报警状态
	 */
	@TableField(value="ALARM_STATE",exist=true)
	String alarmState;

	/**
	 * 属性描述:车牌颜色
	 * 1:蓝色, 2:黄色,	 3:黑色,	 4:白色, 7:黄绿相间	 9:其他
	 */
	@TableField(value="CAR_PLATE_COLOR",exist=true)
	String carPlateColor;

	/**
	 * 属性描述:数据更新时间
	 */
	@TableField(value="LAST_UP_TIME",exist=true)
	java.util.Date lastUpTime;

	/**
	 * 属性描述:位置国家
	 */
	@TableField(value="MAP_COUNTRY",exist=true)
	String mapCountry;

	/**
	 * 属性描述:位置省份
	 */
	@TableField(value="MAP_PROVINCE",exist=true)
	String mapProvince;
	/**
	 * 属性描述:位置省份id
	 */
	@TableField(value="MAP_PROVINCE_ID",exist=true)
	String mapProvinceId;

	/**
	 * 属性描述:位置城市
	 */
	@TableField(value="MAP_CITY",exist=true)
	String mapCity;
	/**
	 * 属性描述:位置城市id
	 */
	@TableField(value="MAP_CITY_ID",exist=true)
	String mapCityId;

	/**
	 * 属性描述:位置县区
	 */
	@TableField(value="MAP_XIANQU",exist=true)
	String mapXianqu;
	/**
	 * 属性描述:位置县区id
	 */
	@TableField(value="MAP_XIANQU_ID",exist=true)
	String mapXianquId;

	/**
	 * 属性描述:详细位置
	 */
	@TableField(value="MAP_DETAIL",exist=true)
	String mapDetail;

	/**
	 * 属性描述:开始里程
	 */
	@TableField(value="BEGIN_MILEAGE",exist=true)
	java.math.BigDecimal beginMileage;

	/**
	 * 属性描述:开始里程时间
	 */
	@TableField(value="BEGIN_TIME",exist=true)
	java.util.Date beginTime;

	/**
	 * 属性描述:当日是否运营
	 */
	@TableField(value="OPERAT_FLAG",exist=true)
	String operatFlag;

	/**
	 * 属性描述:onlineState
	 */
	@TableField(value="ONLINE_STATE",exist=true)
	java.lang.String onlineState;

	/**
	 * 城市信息更新时间
	 */
	@TableField(value="AREA_UP_TIME",exist=true)
	Date areaUpTime;

	@TableField(value="TODAY_TIME_TOTAL",exist=true)
	BigDecimal todayTimeTotal;

	@TableField(value="TODAY_MILEAGE_TOTAL",exist=true)
	BigDecimal todayMileageTotal;
	/**
	 * 数据ip地址
	 */
	@TableField(value="IP",exist=true)
	String ip;
	/**
	 * 属性描述:停车纬度
	 */
	@TableField(value="STOP_LAT",exist=true)
	java.math.BigDecimal stopLat;

	/**
	 * 属性描述:停车经度
	 */
	@TableField(value="STOP_LONG",exist=true)
	java.math.BigDecimal stopLong;

	/**
	 * 停车分钟数
	 */
	@TableField(value="STOP_MINUTE_NUM",exist=true)
	Integer stopMinuteNum;
	/**
	 * 停车开始时间
	 */
	@TableField(value="STOP_BEGIN_TIME",exist=true)
	Date stopBeginTime;
	/**
	 * 停车截止时间
	 */
	@TableField(value="STOP_END_TIME",exist=true)
	Date stopEndTime;


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

	//数据不合格原因
	@TableField(value="ERR_MSG",exist=true)
	String errMsg = "";
	//0不符合，1合格
	@TableField(value="QUALIFIED_STATE",exist=true)
	Integer qualifiedState = 1;
	//gps上传上来的车牌号可能包含特殊符号#123-_这些，将这个存起来通过这个来查轨迹
	@TableField(value="GPS_CAR_PLATE_NUM",exist=true)
	private String gpsCarPlateNum;
	//上次定位点的ip用来决定优先级
	@TableField(exist=false)
	private String lastIp;
	//上次定位ip的时间
	@TableField(exist=false)
	private Date lastIpTime;

	/**
	 * 属性描述:车辆表的信息同步状态
	 */
	@TableField(value="CAR_INFO_SYN_STATE",exist=true)
	java.lang.String carInfoSynState;

	public String getCarInfoSynState() {
		return carInfoSynState;
	}

	public void setCarInfoSynState(String carInfoSynState) {
		this.carInfoSynState = carInfoSynState;
	}

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


	public java.util.Date getLastPositionTime(){
		return this.lastPositionTime;
	}

	public void setLastPositionTime(java.util.Date lastPositionTime){
		this.lastPositionTime=lastPositionTime;
	}


	public java.math.BigDecimal getPointLat(){
		return this.pointLat;
	}

	public void setPointLat(java.math.BigDecimal pointLat){
		this.pointLat=pointLat;
	}


	public java.math.BigDecimal getPointLong(){
		return this.pointLong;
	}

	public void setPointLong(java.math.BigDecimal pointLong){
		this.pointLong=pointLong;
	}


	public java.math.BigDecimal getRealSpeed(){
		return this.realSpeed;
	}

	public void setRealSpeed(java.math.BigDecimal realSpeed){
		this.realSpeed=realSpeed;
	}


	public java.math.BigDecimal getGpsSpeed(){
		return this.gpsSpeed;
	}

	public void setGpsSpeed(java.math.BigDecimal gpsSpeed){
		this.gpsSpeed=gpsSpeed;
	}


	public java.math.BigDecimal getMileage(){
		return this.mileage;
	}

	public void setMileage(java.math.BigDecimal mileage){
		this.mileage=mileage;
	}


	public java.math.BigDecimal getDirection(){
		return this.direction;
	}

	public void setDirection(java.math.BigDecimal direction){
		this.direction=direction;
	}


	public java.math.BigDecimal getAltitude(){
		return this.altitude;
	}

	public void setAltitude(java.math.BigDecimal altitude){
		this.altitude=altitude;
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


	public String getCarPlateColor(){
		return this.carPlateColor;
	}

	public void setCarPlateColor(String carPlateColor){
		this.carPlateColor=carPlateColor;
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

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carFrameNum=").append(carFrameNum);			
			sb.append(", lastPositionTime=").append(lastPositionTime);			
			sb.append(", pointLat=").append(pointLat);			
			sb.append(", pointLong=").append(pointLong);			
			sb.append(", realSpeed=").append(realSpeed);			
			sb.append(", gpsSpeed=").append(gpsSpeed);			
			sb.append(", mileage=").append(mileage);			
			sb.append(", direction=").append(direction);			
			sb.append(", altitude=").append(altitude);			
			sb.append(", carState=").append(carState);			
			sb.append(", alarmState=").append(alarmState);			
			sb.append(", carPlateColor=").append(carPlateColor);			
			sb.append(", lastUpTime=").append(lastUpTime);			
			sb.append(", mapCountry=").append(mapCountry);			
			sb.append(", mapProvince=").append(mapProvince);			
			sb.append(", mapCity=").append(mapCity);			
			sb.append(", mapXianqu=").append(mapXianqu);			
			sb.append(", mapDetail=").append(mapDetail);			
			sb.append(", beginMileage=").append(beginMileage);			
			sb.append(", beginTime=").append(beginTime);			
			sb.append(", operatFlag=").append(operatFlag);			
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
        BigdataCarRealtimeGps other = (BigdataCarRealtimeGps) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarFrameNum() == null ? other.getId() == null : this.getCarFrameNum().equals(other.getCarFrameNum()))		
				        		&&(this.getLastPositionTime() == null ? other.getId() == null : this.getLastPositionTime().equals(other.getLastPositionTime()))		
				        		&&(this.getPointLat() == null ? other.getId() == null : this.getPointLat().equals(other.getPointLat()))		
				        		&&(this.getPointLong() == null ? other.getId() == null : this.getPointLong().equals(other.getPointLong()))		
				        		&&(this.getRealSpeed() == null ? other.getId() == null : this.getRealSpeed().equals(other.getRealSpeed()))		
				        		&&(this.getGpsSpeed() == null ? other.getId() == null : this.getGpsSpeed().equals(other.getGpsSpeed()))		
				        		&&(this.getMileage() == null ? other.getId() == null : this.getMileage().equals(other.getMileage()))		
				        		&&(this.getDirection() == null ? other.getId() == null : this.getDirection().equals(other.getDirection()))		
				        		&&(this.getAltitude() == null ? other.getId() == null : this.getAltitude().equals(other.getAltitude()))		
				        		&&(this.getCarState() == null ? other.getId() == null : this.getCarState().equals(other.getCarState()))		
				        		&&(this.getAlarmState() == null ? other.getId() == null : this.getAlarmState().equals(other.getAlarmState()))		
				        		&&(this.getCarPlateColor() == null ? other.getId() == null : this.getCarPlateColor().equals(other.getCarPlateColor()))		
				        		&&(this.getLastUpTime() == null ? other.getId() == null : this.getLastUpTime().equals(other.getLastUpTime()))		
				        		&&(this.getMapCountry() == null ? other.getId() == null : this.getMapCountry().equals(other.getMapCountry()))		
				        		&&(this.getMapProvince() == null ? other.getId() == null : this.getMapProvince().equals(other.getMapProvince()))		
				        		&&(this.getMapCity() == null ? other.getId() == null : this.getMapCity().equals(other.getMapCity()))		
				        		&&(this.getMapXianqu() == null ? other.getId() == null : this.getMapXianqu().equals(other.getMapXianqu()))		
				        		&&(this.getMapDetail() == null ? other.getId() == null : this.getMapDetail().equals(other.getMapDetail()))		
				        		&&(this.getBeginMileage() == null ? other.getId() == null : this.getBeginMileage().equals(other.getBeginMileage()))		
				        		&&(this.getBeginTime() == null ? other.getId() == null : this.getBeginTime().equals(other.getBeginTime()))		
				        		&&(this.getOperatFlag() == null ? other.getId() == null : this.getOperatFlag().equals(other.getOperatFlag()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarFrameNum() == null) ? 0 : getCarFrameNum().hashCode());		
		        result = prime * result + ((getLastPositionTime() == null) ? 0 : getLastPositionTime().hashCode());		
		        result = prime * result + ((getPointLat() == null) ? 0 : getPointLat().hashCode());		
		        result = prime * result + ((getPointLong() == null) ? 0 : getPointLong().hashCode());		
		        result = prime * result + ((getRealSpeed() == null) ? 0 : getRealSpeed().hashCode());		
		        result = prime * result + ((getGpsSpeed() == null) ? 0 : getGpsSpeed().hashCode());		
		        result = prime * result + ((getMileage() == null) ? 0 : getMileage().hashCode());		
		        result = prime * result + ((getDirection() == null) ? 0 : getDirection().hashCode());		
		        result = prime * result + ((getAltitude() == null) ? 0 : getAltitude().hashCode());		
		        result = prime * result + ((getCarState() == null) ? 0 : getCarState().hashCode());		
		        result = prime * result + ((getAlarmState() == null) ? 0 : getAlarmState().hashCode());		
		        result = prime * result + ((getCarPlateColor() == null) ? 0 : getCarPlateColor().hashCode());		
		        result = prime * result + ((getLastUpTime() == null) ? 0 : getLastUpTime().hashCode());		
		        result = prime * result + ((getMapCountry() == null) ? 0 : getMapCountry().hashCode());		
		        result = prime * result + ((getMapProvince() == null) ? 0 : getMapProvince().hashCode());		
		        result = prime * result + ((getMapCity() == null) ? 0 : getMapCity().hashCode());		
		        result = prime * result + ((getMapXianqu() == null) ? 0 : getMapXianqu().hashCode());		
		        result = prime * result + ((getMapDetail() == null) ? 0 : getMapDetail().hashCode());		
		        result = prime * result + ((getBeginMileage() == null) ? 0 : getBeginMileage().hashCode());		
		        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());		
		        result = prime * result + ((getOperatFlag() == null) ? 0 : getOperatFlag().hashCode());		
		;
        return result;
    }

}
