package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("beidou_data_in_count")
public class BeidouDataInCount implements Serializable{
	
		
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
	 * 属性描述:上传率
	 */
	@TableField(value="UPLOAD_RATE",exist=true)
	java.math.BigDecimal uploadRate;
	
	/**
	 * 属性描述:丢包率
	 */
	@TableField(value="LOSS_PACKAGE_RATE",exist=true)
	java.math.BigDecimal lossPackageRate;
	
	/**
	 * 属性描述:接收率
	 */
	@TableField(value="RECEIVE_RATE",exist=true)
	java.math.BigDecimal receiveRate;
	
	/**
	 * 属性描述:合格率
	 */
	@TableField(value="QUALIFIED_RATE",exist=true)
	java.math.BigDecimal qualifiedRate;
	
	/**
	 * 属性描述:统计时间
	 */
	@TableField(value="COUNT_TIME",exist=true)
	java.util.Date countTime;
	
	
	
	
	
	
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
	
	
	public java.math.BigDecimal getUploadRate(){
		return this.uploadRate;
	}
	
	public void setUploadRate(java.math.BigDecimal uploadRate){
		this.uploadRate=uploadRate;
	}
	
	
	public java.math.BigDecimal getLossPackageRate(){
		return this.lossPackageRate;
	}
	
	public void setLossPackageRate(java.math.BigDecimal lossPackageRate){
		this.lossPackageRate=lossPackageRate;
	}
	
	
	public java.math.BigDecimal getReceiveRate(){
		return this.receiveRate;
	}
	
	public void setReceiveRate(java.math.BigDecimal receiveRate){
		this.receiveRate=receiveRate;
	}
	
	
	public java.math.BigDecimal getQualifiedRate(){
		return this.qualifiedRate;
	}
	
	public void setQualifiedRate(java.math.BigDecimal qualifiedRate){
		this.qualifiedRate=qualifiedRate;
	}
	
	
	public java.util.Date getCountTime(){
		return this.countTime;
	}
	
	public void setCountTime(java.util.Date countTime){
		this.countTime=countTime;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", uploadRate=").append(uploadRate);			
			sb.append(", lossPackageRate=").append(lossPackageRate);			
			sb.append(", receiveRate=").append(receiveRate);			
			sb.append(", qualifiedRate=").append(qualifiedRate);			
			sb.append(", countTime=").append(countTime);			
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
        BeidouDataInCount other = (BeidouDataInCount) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUploadRate() == null ? other.getId() == null : this.getUploadRate().equals(other.getUploadRate()))		
				        		&&(this.getLossPackageRate() == null ? other.getId() == null : this.getLossPackageRate().equals(other.getLossPackageRate()))		
				        		&&(this.getReceiveRate() == null ? other.getId() == null : this.getReceiveRate().equals(other.getReceiveRate()))		
				        		&&(this.getQualifiedRate() == null ? other.getId() == null : this.getQualifiedRate().equals(other.getQualifiedRate()))		
				        		&&(this.getCountTime() == null ? other.getId() == null : this.getCountTime().equals(other.getCountTime()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getUploadRate() == null) ? 0 : getUploadRate().hashCode());		
		        result = prime * result + ((getLossPackageRate() == null) ? 0 : getLossPackageRate().hashCode());		
		        result = prime * result + ((getReceiveRate() == null) ? 0 : getReceiveRate().hashCode());		
		        result = prime * result + ((getQualifiedRate() == null) ? 0 : getQualifiedRate().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		;
        return result;
    }

}
