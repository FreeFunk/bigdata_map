package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_power")
public class SysPower implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;
	
	/**
	 * 属性描述:权限key值
	 */
	@TableField(value="POWER_KEY",exist=true)
	String powerKey;
	
	/**
	 * 属性描述:依赖权限key
	 */
	@TableField(value="DI_KEY",exist=true)
	String diKey;
	
	/**
	 * 属性描述:权限名称
	 */
	@TableField(value="POWER_NAME",exist=true)
	String powerName;
	
	/**
	 * 属性描述:权限描述
	 */
	@TableField(value="POWER_DESC",exist=true)
	String powerDesc;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	/**
	 * 属性描述:排序号
	 */
	@TableField(value="ORDER_NUMBER",exist=true)
	java.math.BigDecimal orderNumber;
	
	/**
	 * 属性描述:所属菜单
	 */
	@TableField(value="MENUE_ID",exist=true)
	String menueId;
	
	
	
	
	
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public String getPowerKey(){
		return this.powerKey;
	}
	
	public void setPowerKey(String powerKey){
		this.powerKey=powerKey;
	}
	
	
	public String getDiKey(){
		return this.diKey;
	}
	
	public void setDiKey(String diKey){
		this.diKey=diKey;
	}
	
	
	public String getPowerName(){
		return this.powerName;
	}
	
	public void setPowerName(String powerName){
		this.powerName=powerName;
	}
	
	
	public String getPowerDesc(){
		return this.powerDesc;
	}
	
	public void setPowerDesc(String powerDesc){
		this.powerDesc=powerDesc;
	}
	
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	
	public java.math.BigDecimal getOrderNumber(){
		return this.orderNumber;
	}
	
	public void setOrderNumber(java.math.BigDecimal orderNumber){
		this.orderNumber=orderNumber;
	}
	
	
	public String getMenueId(){
		return this.menueId;
	}
	
	public void setMenueId(String menueId){
		this.menueId=menueId;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", powerKey=").append(powerKey);			
			sb.append(", diKey=").append(diKey);			
			sb.append(", powerName=").append(powerName);			
			sb.append(", powerDesc=").append(powerDesc);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", orderNumber=").append(orderNumber);			
			sb.append(", menueId=").append(menueId);			
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
        SysPower other = (SysPower) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getPowerKey() == null ? other.getId() == null : this.getPowerKey().equals(other.getPowerKey()))		
				        		&&(this.getDiKey() == null ? other.getId() == null : this.getDiKey().equals(other.getDiKey()))		
				        		&&(this.getPowerName() == null ? other.getId() == null : this.getPowerName().equals(other.getPowerName()))		
				        		&&(this.getPowerDesc() == null ? other.getId() == null : this.getPowerDesc().equals(other.getPowerDesc()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getOrderNumber() == null ? other.getId() == null : this.getOrderNumber().equals(other.getOrderNumber()))		
				        		&&(this.getMenueId() == null ? other.getId() == null : this.getMenueId().equals(other.getMenueId()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getPowerKey() == null) ? 0 : getPowerKey().hashCode());		
		        result = prime * result + ((getDiKey() == null) ? 0 : getDiKey().hashCode());		
		        result = prime * result + ((getPowerName() == null) ? 0 : getPowerName().hashCode());		
		        result = prime * result + ((getPowerDesc() == null) ? 0 : getPowerDesc().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());		
		        result = prime * result + ((getMenueId() == null) ? 0 : getMenueId().hashCode());		
		;
        return result;
    }
	
}
