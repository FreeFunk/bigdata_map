package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("bigdata_beidou_comp")
public class BigdataBeidouComp implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;

	/**
	 * 属性描述:运营商名
	 */
	@TableField(value="COMP_NAME",exist=true)
	String compName;

	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;

	/**
	 * 属性描述:签名key
	 */
	@TableField(value="SING_KEY",exist=true)
	String singKey;

	/**
	 * 属性描述:ip白名单
	 */
	@TableField(value="IP_ADDRESS",exist=true)
	String ipAddress;

	/**
	 * 属性描述:状态0启用,1停用
	 */
	@TableField(value="COMP_STATE",exist=true)
	String compState;
	//ip地址
	@TableField(value="IP_809_ADDRESS",exist=true)
	String ip809Address;

	//上次联通时间
	@TableField(value="LAST_UP_TIME",exist=true)
	java.util.Date lastUpTime;
	//ip地址
	@TableField(value="COMP_FLAG",exist=true)
	String compFlag;
	//ip地址
	@TableField(value="COMP_CAR_TYPE",exist=true)
	String compCarType;

	public String getCompFlag() {
		return compFlag;
	}

	public void setCompFlag(String compFlag) {
		this.compFlag = compFlag;
	}

	public String getCompCarType() {
		return compCarType;
	}

	public void setCompCarType(String compCarType) {
		this.compCarType = compCarType;
	}

	public Date getLastUpTime() {
		return lastUpTime;
	}

	public void setLastUpTime(Date lastUpTime) {
		this.lastUpTime = lastUpTime;
	}

	public String getIp809Address() {
		return ip809Address;
	}

	public void setIp809Address(String ip809Address) {
		this.ip809Address = ip809Address;
	}

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}


	public String getCompName(){
		return this.compName;
	}

	public void setCompName(String compName){
		this.compName=compName;
	}


	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}


	public String getSingKey(){
		return this.singKey;
	}

	public void setSingKey(String singKey){
		this.singKey=singKey;
	}


	public String getIpAddress(){
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress){
		this.ipAddress=ipAddress;
	}


	public String getCompState(){
		return this.compState;
	}

	public void setCompState(String compState){
		this.compState=compState;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", compName=").append(compName);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", singKey=").append(singKey);			
			sb.append(", ipAddress=").append(ipAddress);			
			sb.append(", compState=").append(compState);			
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
        BigdataBeidouComp other = (BigdataBeidouComp) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCompName() == null ? other.getId() == null : this.getCompName().equals(other.getCompName()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getSingKey() == null ? other.getId() == null : this.getSingKey().equals(other.getSingKey()))		
				        		&&(this.getIpAddress() == null ? other.getId() == null : this.getIpAddress().equals(other.getIpAddress()))		
				        		&&(this.getCompState() == null ? other.getId() == null : this.getCompState().equals(other.getCompState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCompName() == null) ? 0 : getCompName().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getSingKey() == null) ? 0 : getSingKey().hashCode());		
		        result = prime * result + ((getIpAddress() == null) ? 0 : getIpAddress().hashCode());		
		        result = prime * result + ((getCompState() == null) ? 0 : getCompState().hashCode());		
		;
        return result;
    }

}
