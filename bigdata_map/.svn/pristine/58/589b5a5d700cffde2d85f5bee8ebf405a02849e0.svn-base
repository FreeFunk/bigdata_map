package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_city")
public class SysCity implements Serializable{
	
		
	/**
	 * 属性描述:id
	 */
	@TableField(value="ID",exist=true)
	String id;
	
	/**
	 * 属性描述:name
	 */
	@TableField(value="NAME",exist=true)
	String name;
	
	/**
	 * 属性描述:provinceId
	 */
	@TableField(value="PROVINCE_ID",exist=true)
	String provinceId;
	
	/**
	 * 属性描述:provinceNane
	 */
	@TableField(value="PROVINCE_NANE",exist=true)
	String provinceNane;
	
	/**
	 * 属性描述:orderNumber
	 */
	@TableField(value="ORDER_NUMBER",exist=true)
	java.math.BigDecimal orderNumber;
	
	/**
	 * 属性描述:firstSpell
	 */
	@TableField(value="FIRST_SPELL",exist=true)
	String firstSpell;
	
	/**
	 * 属性描述:status
	 */
	@TableField(value="STATUS",exist=true)
	String status;
	
	/**
	 * 属性描述:remenFlag
	 */
	@TableField(value="REMEN_FLAG",exist=true)
	String remenFlag;
	
	
	
	
	
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	
	public String getProvinceId(){
		return this.provinceId;
	}
	
	public void setProvinceId(String provinceId){
		this.provinceId=provinceId;
	}
	
	
	public String getProvinceNane(){
		return this.provinceNane;
	}
	
	public void setProvinceNane(String provinceNane){
		this.provinceNane=provinceNane;
	}
	
	
	public java.math.BigDecimal getOrderNumber(){
		return this.orderNumber;
	}
	
	public void setOrderNumber(java.math.BigDecimal orderNumber){
		this.orderNumber=orderNumber;
	}
	
	
	public String getFirstSpell(){
		return this.firstSpell;
	}
	
	public void setFirstSpell(String firstSpell){
		this.firstSpell=firstSpell;
	}
	
	
	public String getStatus(){
		return this.status;
	}
	
	public void setStatus(String status){
		this.status=status;
	}
	
	
	public String getRemenFlag(){
		return this.remenFlag;
	}
	
	public void setRemenFlag(String remenFlag){
		this.remenFlag=remenFlag;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", name=").append(name);			
			sb.append(", provinceId=").append(provinceId);			
			sb.append(", provinceNane=").append(provinceNane);			
			sb.append(", orderNumber=").append(orderNumber);			
			sb.append(", firstSpell=").append(firstSpell);			
			sb.append(", status=").append(status);			
			sb.append(", remenFlag=").append(remenFlag);			
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
        SysCity other = (SysCity) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getName() == null ? other.getId() == null : this.getName().equals(other.getName()))		
				        		&&(this.getProvinceId() == null ? other.getId() == null : this.getProvinceId().equals(other.getProvinceId()))		
				        		&&(this.getProvinceNane() == null ? other.getId() == null : this.getProvinceNane().equals(other.getProvinceNane()))		
				        		&&(this.getOrderNumber() == null ? other.getId() == null : this.getOrderNumber().equals(other.getOrderNumber()))		
				        		&&(this.getFirstSpell() == null ? other.getId() == null : this.getFirstSpell().equals(other.getFirstSpell()))		
				        		&&(this.getStatus() == null ? other.getId() == null : this.getStatus().equals(other.getStatus()))		
				        		&&(this.getRemenFlag() == null ? other.getId() == null : this.getRemenFlag().equals(other.getRemenFlag()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());		
		        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());		
		        result = prime * result + ((getProvinceNane() == null) ? 0 : getProvinceNane().hashCode());		
		        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());		
		        result = prime * result + ((getFirstSpell() == null) ? 0 : getFirstSpell().hashCode());		
		        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());		
		        result = prime * result + ((getRemenFlag() == null) ? 0 : getRemenFlag().hashCode());		
		;
        return result;
    }
	

}
