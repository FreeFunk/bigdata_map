package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_gps_transmit_car_permit")
public class BigdataGpsTransmitCarPermit implements Serializable{
	
		
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
	 * 属性描述:平台ID
	 */
	@TableField(value="PLAT_ID",exist=true)
	java.lang.String platId;
	
	/**
	 * 属性描述:车辆id
	 */
	@TableField(value="CAR_ID",exist=true)
	java.lang.String carId;
	
	
	
	
	
	
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
	
	
	public java.lang.String getPlatId(){
		return this.platId;
	}
	
	public void setPlatId(java.lang.String platId){
		this.platId=platId;
	}
	
	
	public java.lang.String getCarId(){
		return this.carId;
	}
	
	public void setCarId(java.lang.String carId){
		this.carId=carId;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", platId=").append(platId);			
			sb.append(", carId=").append(carId);			
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
        BigdataGpsTransmitCarPermit other = (BigdataGpsTransmitCarPermit) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getPlatId() == null ? other.getId() == null : this.getPlatId().equals(other.getPlatId()))		
				        		&&(this.getCarId() == null ? other.getId() == null : this.getCarId().equals(other.getCarId()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getPlatId() == null) ? 0 : getPlatId().hashCode());		
		        result = prime * result + ((getCarId() == null) ? 0 : getCarId().hashCode());		
		;
        return result;
    }

}
