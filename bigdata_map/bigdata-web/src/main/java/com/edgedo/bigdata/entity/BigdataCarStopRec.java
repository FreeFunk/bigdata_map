package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_car_stop_rec")
public class BigdataCarStopRec implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:所属车辆
	 */
	@TableField(value="CAR_REAL_ID",exist=true)
	java.lang.String carRealId;
	
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
	 * 属性描述:位置国家
	 */
	@TableField(value="MAP_COUNTRY",exist=true)
	java.lang.String mapCountry;
	
	/**
	 * 属性描述:mapProvinceId
	 */
	@TableField(value="MAP_PROVINCE_ID",exist=true)
	java.lang.String mapProvinceId;
	
	/**
	 * 属性描述:位置省份
	 */
	@TableField(value="MAP_PROVINCE",exist=true)
	java.lang.String mapProvince;
	
	/**
	 * 属性描述:mapCityId
	 */
	@TableField(value="MAP_CITY_ID",exist=true)
	java.lang.String mapCityId;
	
	/**
	 * 属性描述:位置城市
	 */
	@TableField(value="MAP_CITY",exist=true)
	java.lang.String mapCity;
	
	/**
	 * 属性描述:mapXianquId
	 */
	@TableField(value="MAP_XIANQU_ID",exist=true)
	java.lang.String mapXianquId;
	
	/**
	 * 属性描述:位置县区
	 */
	@TableField(value="MAP_XIANQU",exist=true)
	java.lang.String mapXianqu;
	
	/**
	 * 属性描述:详细位置
	 */
	@TableField(value="MAP_DETAIL",exist=true)
	java.lang.String mapDetail;
	
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
	 * 属性描述:海拔
	 */
	@TableField(value="ALTITUDE",exist=true)
	java.math.BigDecimal altitude;
	
	/**
	 * 属性描述:carType
	 */
	@TableField(value="CAR_TYPE",exist=true)
	java.lang.String carType;
	
	/**
	 * 属性描述:countDate
	 */
	@TableField(value="COUNT_DATE",exist=true)
	java.lang.Integer countDate;
	
	/**
	 * 属性描述:countMonth
	 */
	@TableField(value="COUNT_MONTH",exist=true)
	java.lang.Integer countMonth;
	
	/**
	 * 属性描述:yearNum
	 */
	@TableField(value="YEAR_NUM",exist=true)
	java.lang.Integer yearNum;
	
	
	
	
	
	
	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.lang.String getCarRealId(){
		return this.carRealId;
	}
	
	public void setCarRealId(java.lang.String carRealId){
		this.carRealId=carRealId;
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
	
	
	public java.lang.String getMapCountry(){
		return this.mapCountry;
	}
	
	public void setMapCountry(java.lang.String mapCountry){
		this.mapCountry=mapCountry;
	}
	
	
	public java.lang.String getMapProvinceId(){
		return this.mapProvinceId;
	}
	
	public void setMapProvinceId(java.lang.String mapProvinceId){
		this.mapProvinceId=mapProvinceId;
	}
	
	
	public java.lang.String getMapProvince(){
		return this.mapProvince;
	}
	
	public void setMapProvince(java.lang.String mapProvince){
		this.mapProvince=mapProvince;
	}
	
	
	public java.lang.String getMapCityId(){
		return this.mapCityId;
	}
	
	public void setMapCityId(java.lang.String mapCityId){
		this.mapCityId=mapCityId;
	}
	
	
	public java.lang.String getMapCity(){
		return this.mapCity;
	}
	
	public void setMapCity(java.lang.String mapCity){
		this.mapCity=mapCity;
	}
	
	
	public java.lang.String getMapXianquId(){
		return this.mapXianquId;
	}
	
	public void setMapXianquId(java.lang.String mapXianquId){
		this.mapXianquId=mapXianquId;
	}
	
	
	public java.lang.String getMapXianqu(){
		return this.mapXianqu;
	}
	
	public void setMapXianqu(java.lang.String mapXianqu){
		this.mapXianqu=mapXianqu;
	}
	
	
	public java.lang.String getMapDetail(){
		return this.mapDetail;
	}
	
	public void setMapDetail(java.lang.String mapDetail){
		this.mapDetail=mapDetail;
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
	
	
	public java.math.BigDecimal getAltitude(){
		return this.altitude;
	}
	
	public void setAltitude(java.math.BigDecimal altitude){
		this.altitude=altitude;
	}
	
	
	public java.lang.String getCarType(){
		return this.carType;
	}
	
	public void setCarType(java.lang.String carType){
		this.carType=carType;
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
			sb.append(", carRealId=").append(carRealId);			
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carPlateColor=").append(carPlateColor);			
			sb.append(", mapCountry=").append(mapCountry);			
			sb.append(", mapProvinceId=").append(mapProvinceId);			
			sb.append(", mapProvince=").append(mapProvince);			
			sb.append(", mapCityId=").append(mapCityId);			
			sb.append(", mapCity=").append(mapCity);			
			sb.append(", mapXianquId=").append(mapXianquId);			
			sb.append(", mapXianqu=").append(mapXianqu);			
			sb.append(", mapDetail=").append(mapDetail);			
			sb.append(", pointLat=").append(pointLat);			
			sb.append(", pointLong=").append(pointLong);			
			sb.append(", altitude=").append(altitude);			
			sb.append(", carType=").append(carType);			
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
        BigdataCarStopRec other = (BigdataCarStopRec) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCarRealId() == null ? other.getId() == null : this.getCarRealId().equals(other.getCarRealId()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarPlateColor() == null ? other.getId() == null : this.getCarPlateColor().equals(other.getCarPlateColor()))		
				        		&&(this.getMapCountry() == null ? other.getId() == null : this.getMapCountry().equals(other.getMapCountry()))		
				        		&&(this.getMapProvinceId() == null ? other.getId() == null : this.getMapProvinceId().equals(other.getMapProvinceId()))		
				        		&&(this.getMapProvince() == null ? other.getId() == null : this.getMapProvince().equals(other.getMapProvince()))		
				        		&&(this.getMapCityId() == null ? other.getId() == null : this.getMapCityId().equals(other.getMapCityId()))		
				        		&&(this.getMapCity() == null ? other.getId() == null : this.getMapCity().equals(other.getMapCity()))		
				        		&&(this.getMapXianquId() == null ? other.getId() == null : this.getMapXianquId().equals(other.getMapXianquId()))		
				        		&&(this.getMapXianqu() == null ? other.getId() == null : this.getMapXianqu().equals(other.getMapXianqu()))		
				        		&&(this.getMapDetail() == null ? other.getId() == null : this.getMapDetail().equals(other.getMapDetail()))		
				        		&&(this.getPointLat() == null ? other.getId() == null : this.getPointLat().equals(other.getPointLat()))		
				        		&&(this.getPointLong() == null ? other.getId() == null : this.getPointLong().equals(other.getPointLong()))		
				        		&&(this.getAltitude() == null ? other.getId() == null : this.getAltitude().equals(other.getAltitude()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
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
		        result = prime * result + ((getCarRealId() == null) ? 0 : getCarRealId().hashCode());		
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarPlateColor() == null) ? 0 : getCarPlateColor().hashCode());		
		        result = prime * result + ((getMapCountry() == null) ? 0 : getMapCountry().hashCode());		
		        result = prime * result + ((getMapProvinceId() == null) ? 0 : getMapProvinceId().hashCode());		
		        result = prime * result + ((getMapProvince() == null) ? 0 : getMapProvince().hashCode());		
		        result = prime * result + ((getMapCityId() == null) ? 0 : getMapCityId().hashCode());		
		        result = prime * result + ((getMapCity() == null) ? 0 : getMapCity().hashCode());		
		        result = prime * result + ((getMapXianquId() == null) ? 0 : getMapXianquId().hashCode());		
		        result = prime * result + ((getMapXianqu() == null) ? 0 : getMapXianqu().hashCode());		
		        result = prime * result + ((getMapDetail() == null) ? 0 : getMapDetail().hashCode());		
		        result = prime * result + ((getPointLat() == null) ? 0 : getPointLat().hashCode());		
		        result = prime * result + ((getPointLong() == null) ? 0 : getPointLong().hashCode());		
		        result = prime * result + ((getAltitude() == null) ? 0 : getAltitude().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
