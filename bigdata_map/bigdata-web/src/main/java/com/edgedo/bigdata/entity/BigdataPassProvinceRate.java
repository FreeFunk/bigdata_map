package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_pass_province_rate")
public class BigdataPassProvinceRate implements Serializable{
	
		
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
	 * 属性描述:跨省率
	 */
	@TableField(value="PASS_PROVINCE_RATE",exist=true)
	java.math.BigDecimal passProvinceRate;
	
	/**
	 * 属性描述:跨省率标识
	 */
	@TableField(value="PASS_PROVINCE_RATE_FLAG",exist=true)
	java.lang.String passProvinceRateFlag;
	
	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	java.lang.String carType;
	
	/**
	 * 属性描述:统计类型
	 */
	@TableField(value="COUNT_TYPE",exist=true)
	java.lang.String countType;
	
	/**
	 * 属性描述:统计时间
	 */
	@TableField(value="COUNT_TIME",exist=true)
	java.util.Date countTime;
	
	/**
	 * 属性描述:季度类型
	 */
	@TableField(value="QUARTER_TYPE",exist=true)
	java.lang.String quarterType;
	
	
	
	
	
	
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
	
	
	public java.math.BigDecimal getPassProvinceRate(){
		return this.passProvinceRate;
	}
	
	public void setPassProvinceRate(java.math.BigDecimal passProvinceRate){
		this.passProvinceRate=passProvinceRate;
	}
	
	
	public java.lang.String getPassProvinceRateFlag(){
		return this.passProvinceRateFlag;
	}
	
	public void setPassProvinceRateFlag(java.lang.String passProvinceRateFlag){
		this.passProvinceRateFlag=passProvinceRateFlag;
	}
	
	
	public java.lang.String getCarType(){
		return this.carType;
	}
	
	public void setCarType(java.lang.String carType){
		this.carType=carType;
	}
	
	
	public java.lang.String getCountType(){
		return this.countType;
	}
	
	public void setCountType(java.lang.String countType){
		this.countType=countType;
	}
	
	
	public java.util.Date getCountTime(){
		return this.countTime;
	}
	
	public void setCountTime(java.util.Date countTime){
		this.countTime=countTime;
	}
	
	
	public java.lang.String getQuarterType(){
		return this.quarterType;
	}
	
	public void setQuarterType(java.lang.String quarterType){
		this.quarterType=quarterType;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", passProvinceRate=").append(passProvinceRate);			
			sb.append(", passProvinceRateFlag=").append(passProvinceRateFlag);			
			sb.append(", carType=").append(carType);			
			sb.append(", countType=").append(countType);			
			sb.append(", countTime=").append(countTime);			
			sb.append(", quarterType=").append(quarterType);			
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
        BigdataPassProvinceRate other = (BigdataPassProvinceRate) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getPassProvinceRate() == null ? other.getId() == null : this.getPassProvinceRate().equals(other.getPassProvinceRate()))		
				        		&&(this.getPassProvinceRateFlag() == null ? other.getId() == null : this.getPassProvinceRateFlag().equals(other.getPassProvinceRateFlag()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getCountType() == null ? other.getId() == null : this.getCountType().equals(other.getCountType()))		
				        		&&(this.getCountTime() == null ? other.getId() == null : this.getCountTime().equals(other.getCountTime()))		
				        		&&(this.getQuarterType() == null ? other.getId() == null : this.getQuarterType().equals(other.getQuarterType()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getPassProvinceRate() == null) ? 0 : getPassProvinceRate().hashCode());		
		        result = prime * result + ((getPassProvinceRateFlag() == null) ? 0 : getPassProvinceRateFlag().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCountType() == null) ? 0 : getCountType().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		        result = prime * result + ((getQuarterType() == null) ? 0 : getQuarterType().hashCode());		
		;
        return result;
    }

}
