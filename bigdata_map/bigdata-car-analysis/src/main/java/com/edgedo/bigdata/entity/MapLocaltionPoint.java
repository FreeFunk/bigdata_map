package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("map_localtion_point")
public class MapLocaltionPoint implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;

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
	 * 属性描述:车的数量
	 */
	@TableField(value="CAR_NUM",exist=true)
	Integer carNum;

	/**
	 * 属性描述:经度
	 */
	@TableField(value="LONGITUDE",exist=true)
	java.math.BigDecimal longitude;

	/**
	 * 属性描述:纬度
	 */
	@TableField(value="LATITUDE",exist=true)
	java.math.BigDecimal latitude;

	/**
	 * 属性描述:统计类型
	 */
	@TableField(value="COUNT_TYPE",exist=true)
	String countType;


	@TableField(value="CAR_TYPE",exist=true)
	String carType;

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
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


	public Integer getCarNum(){
		return this.carNum;
	}

	public void setCarNum(Integer carNum){
		this.carNum=carNum;
	}


	public java.math.BigDecimal getLongitude(){
		return this.longitude;
	}

	public void setLongitude(java.math.BigDecimal longitude){
		this.longitude=longitude;
	}


	public java.math.BigDecimal getLatitude(){
		return this.latitude;
	}

	public void setLatitude(java.math.BigDecimal latitude){
		this.latitude=latitude;
	}


	public String getCountType(){
		return this.countType;
	}

	public void setCountType(String countType){
		this.countType=countType;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", provinceId=").append(provinceId);			
			sb.append(", provinceName=").append(provinceName);			
			sb.append(", cityId=").append(cityId);			
			sb.append(", cityName=").append(cityName);			
			sb.append(", xianquId=").append(xianquId);			
			sb.append(", xianquName=").append(xianquName);			
			sb.append(", carNum=").append(carNum);			
			sb.append(", longitude=").append(longitude);			
			sb.append(", latitude=").append(latitude);			
			sb.append(", countType=").append(countType);			
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
        MapLocaltionPoint other = (MapLocaltionPoint) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getProvinceId() == null ? other.getId() == null : this.getProvinceId().equals(other.getProvinceId()))		
				        		&&(this.getProvinceName() == null ? other.getId() == null : this.getProvinceName().equals(other.getProvinceName()))		
				        		&&(this.getCityId() == null ? other.getId() == null : this.getCityId().equals(other.getCityId()))		
				        		&&(this.getCityName() == null ? other.getId() == null : this.getCityName().equals(other.getCityName()))		
				        		&&(this.getXianquId() == null ? other.getId() == null : this.getXianquId().equals(other.getXianquId()))		
				        		&&(this.getXianquName() == null ? other.getId() == null : this.getXianquName().equals(other.getXianquName()))		
				        		&&(this.getCarNum() == null ? other.getId() == null : this.getCarNum().equals(other.getCarNum()))		
				        		&&(this.getLongitude() == null ? other.getId() == null : this.getLongitude().equals(other.getLongitude()))		
				        		&&(this.getLatitude() == null ? other.getId() == null : this.getLatitude().equals(other.getLatitude()))		
				        		&&(this.getCountType() == null ? other.getId() == null : this.getCountType().equals(other.getCountType()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());		
		        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());		
		        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());		
		        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());		
		        result = prime * result + ((getXianquId() == null) ? 0 : getXianquId().hashCode());		
		        result = prime * result + ((getXianquName() == null) ? 0 : getXianquName().hashCode());		
		        result = prime * result + ((getCarNum() == null) ? 0 : getCarNum().hashCode());		
		        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());		
		        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());		
		        result = prime * result + ((getCountType() == null) ? 0 : getCountType().hashCode());		
		;
        return result;
    }

}
