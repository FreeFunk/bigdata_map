package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_beidou_model")
public class BigdataBeidouModel implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:设备型号
	 */
	@TableField(value="MODEL_CODE",exist=true)
	java.lang.String modelCode;
	
	/**
	 * 属性描述:制造商名称
	 */
	@TableField(value="MANUFACTURER_NAME",exist=true)
	java.lang.String manufacturerName;
	
	/**
	 * 属性描述:制造商ID
	 */
	@TableField(value="MANUFACTURER_ID",exist=true)
	java.lang.String manufacturerId;
	
	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	java.lang.String carType;
	
	
	
	
	
	
	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.lang.String getModelCode(){
		return this.modelCode;
	}
	
	public void setModelCode(java.lang.String modelCode){
		this.modelCode=modelCode;
	}
	
	
	public java.lang.String getManufacturerName(){
		return this.manufacturerName;
	}
	
	public void setManufacturerName(java.lang.String manufacturerName){
		this.manufacturerName=manufacturerName;
	}
	
	
	public java.lang.String getManufacturerId(){
		return this.manufacturerId;
	}
	
	public void setManufacturerId(java.lang.String manufacturerId){
		this.manufacturerId=manufacturerId;
	}
	
	
	public java.lang.String getCarType(){
		return this.carType;
	}
	
	public void setCarType(java.lang.String carType){
		this.carType=carType;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", modelCode=").append(modelCode);			
			sb.append(", manufacturerName=").append(manufacturerName);			
			sb.append(", manufacturerId=").append(manufacturerId);			
			sb.append(", carType=").append(carType);			
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
        BigdataBeidouModel other = (BigdataBeidouModel) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getModelCode() == null ? other.getId() == null : this.getModelCode().equals(other.getModelCode()))		
				        		&&(this.getManufacturerName() == null ? other.getId() == null : this.getManufacturerName().equals(other.getManufacturerName()))		
				        		&&(this.getManufacturerId() == null ? other.getId() == null : this.getManufacturerId().equals(other.getManufacturerId()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getModelCode() == null) ? 0 : getModelCode().hashCode());		
		        result = prime * result + ((getManufacturerName() == null) ? 0 : getManufacturerName().hashCode());		
		        result = prime * result + ((getManufacturerId() == null) ? 0 : getManufacturerId().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		;
        return result;
    }

}
