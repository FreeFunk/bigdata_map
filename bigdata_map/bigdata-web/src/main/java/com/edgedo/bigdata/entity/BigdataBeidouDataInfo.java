package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_beidou_data_info")
public class BigdataBeidouDataInfo implements Serializable{
	
		
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
	 * 属性描述:上传时间
	 */
	@TableField(value="UPLOAD_TIME",exist=true)
	java.util.Date uploadTime;
	
	/**
	 * 属性描述:运营商名
	 */
	@TableField(value="OPERATOR_NAME",exist=true)
	java.lang.String operatorName;
	
	/**
	 * 属性描述:在网车辆总数
	 */
	@TableField(value="CAR_NUM",exist=true)
	java.lang.Integer carNum;
	
	/**
	 * 属性描述:上传数
	 */
	@TableField(value="UPLOAD_CAR_NUM",exist=true)
	java.lang.Integer uploadCarNum;
	
	/**
	 * 属性描述:上传率
	 */
	@TableField(value="UPLOAD_RATE",exist=true)
	java.math.BigDecimal uploadRate;
	
	/**
	 * 属性描述:丢包数
	 */
	@TableField(value="LOSS_PACKAGE_NUM",exist=true)
	java.lang.Integer lossPackageNum;
	
	/**
	 * 属性描述:丢包率
	 */
	@TableField(value="LOSS_PACKAGE_RATE",exist=true)
	java.math.BigDecimal lossPackageRate;
	
	/**
	 * 属性描述:接收数
	 */
	@TableField(value="RECEIVE_NUM",exist=true)
	java.lang.Integer receiveNum;
	
	/**
	 * 属性描述:接收率
	 */
	@TableField(value="RECEIVE_RATE",exist=true)
	java.math.BigDecimal receiveRate;
	
	/**
	 * 属性描述:合格数
	 */
	@TableField(value="QUALIFIED_NUM",exist=true)
	java.lang.Integer qualifiedNum;
	
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
	
	
	public java.util.Date getUploadTime(){
		return this.uploadTime;
	}
	
	public void setUploadTime(java.util.Date uploadTime){
		this.uploadTime=uploadTime;
	}
	
	
	public java.lang.String getOperatorName(){
		return this.operatorName;
	}
	
	public void setOperatorName(java.lang.String operatorName){
		this.operatorName=operatorName;
	}
	
	
	public java.lang.Integer getCarNum(){
		return this.carNum;
	}
	
	public void setCarNum(java.lang.Integer carNum){
		this.carNum=carNum;
	}
	
	
	public java.lang.Integer getUploadCarNum(){
		return this.uploadCarNum;
	}
	
	public void setUploadCarNum(java.lang.Integer uploadCarNum){
		this.uploadCarNum=uploadCarNum;
	}
	
	
	public java.math.BigDecimal getUploadRate(){
		return this.uploadRate;
	}
	
	public void setUploadRate(java.math.BigDecimal uploadRate){
		this.uploadRate=uploadRate;
	}
	
	
	public java.lang.Integer getLossPackageNum(){
		return this.lossPackageNum;
	}
	
	public void setLossPackageNum(java.lang.Integer lossPackageNum){
		this.lossPackageNum=lossPackageNum;
	}
	
	
	public java.math.BigDecimal getLossPackageRate(){
		return this.lossPackageRate;
	}
	
	public void setLossPackageRate(java.math.BigDecimal lossPackageRate){
		this.lossPackageRate=lossPackageRate;
	}
	
	
	public java.lang.Integer getReceiveNum(){
		return this.receiveNum;
	}
	
	public void setReceiveNum(java.lang.Integer receiveNum){
		this.receiveNum=receiveNum;
	}
	
	
	public java.math.BigDecimal getReceiveRate(){
		return this.receiveRate;
	}
	
	public void setReceiveRate(java.math.BigDecimal receiveRate){
		this.receiveRate=receiveRate;
	}
	
	
	public java.lang.Integer getQualifiedNum(){
		return this.qualifiedNum;
	}
	
	public void setQualifiedNum(java.lang.Integer qualifiedNum){
		this.qualifiedNum=qualifiedNum;
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
			sb.append(", uploadTime=").append(uploadTime);			
			sb.append(", operatorName=").append(operatorName);			
			sb.append(", carNum=").append(carNum);			
			sb.append(", uploadCarNum=").append(uploadCarNum);			
			sb.append(", uploadRate=").append(uploadRate);			
			sb.append(", lossPackageNum=").append(lossPackageNum);			
			sb.append(", lossPackageRate=").append(lossPackageRate);			
			sb.append(", receiveNum=").append(receiveNum);			
			sb.append(", receiveRate=").append(receiveRate);			
			sb.append(", qualifiedNum=").append(qualifiedNum);			
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
        BigdataBeidouDataInfo other = (BigdataBeidouDataInfo) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUploadTime() == null ? other.getId() == null : this.getUploadTime().equals(other.getUploadTime()))		
				        		&&(this.getOperatorName() == null ? other.getId() == null : this.getOperatorName().equals(other.getOperatorName()))		
				        		&&(this.getCarNum() == null ? other.getId() == null : this.getCarNum().equals(other.getCarNum()))		
				        		&&(this.getUploadCarNum() == null ? other.getId() == null : this.getUploadCarNum().equals(other.getUploadCarNum()))		
				        		&&(this.getUploadRate() == null ? other.getId() == null : this.getUploadRate().equals(other.getUploadRate()))		
				        		&&(this.getLossPackageNum() == null ? other.getId() == null : this.getLossPackageNum().equals(other.getLossPackageNum()))		
				        		&&(this.getLossPackageRate() == null ? other.getId() == null : this.getLossPackageRate().equals(other.getLossPackageRate()))		
				        		&&(this.getReceiveNum() == null ? other.getId() == null : this.getReceiveNum().equals(other.getReceiveNum()))		
				        		&&(this.getReceiveRate() == null ? other.getId() == null : this.getReceiveRate().equals(other.getReceiveRate()))		
				        		&&(this.getQualifiedNum() == null ? other.getId() == null : this.getQualifiedNum().equals(other.getQualifiedNum()))		
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
		        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());		
		        result = prime * result + ((getOperatorName() == null) ? 0 : getOperatorName().hashCode());		
		        result = prime * result + ((getCarNum() == null) ? 0 : getCarNum().hashCode());		
		        result = prime * result + ((getUploadCarNum() == null) ? 0 : getUploadCarNum().hashCode());		
		        result = prime * result + ((getUploadRate() == null) ? 0 : getUploadRate().hashCode());		
		        result = prime * result + ((getLossPackageNum() == null) ? 0 : getLossPackageNum().hashCode());		
		        result = prime * result + ((getLossPackageRate() == null) ? 0 : getLossPackageRate().hashCode());		
		        result = prime * result + ((getReceiveNum() == null) ? 0 : getReceiveNum().hashCode());		
		        result = prime * result + ((getReceiveRate() == null) ? 0 : getReceiveRate().hashCode());		
		        result = prime * result + ((getQualifiedNum() == null) ? 0 : getQualifiedNum().hashCode());		
		        result = prime * result + ((getQualifiedRate() == null) ? 0 : getQualifiedRate().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		;
        return result;
    }

}
