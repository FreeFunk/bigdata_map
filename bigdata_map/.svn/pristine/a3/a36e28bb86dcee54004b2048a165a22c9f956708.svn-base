package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("bigdata_safety_warning_file")
public class BigdataSafetyWarningFile implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="Id",exist=true)
	String id;

	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;

	/**
	 * 属性描述:所属安全预警Id
	 */
	@TableField(value="OWNER_SAFETY_WARNING_ID",exist=true)
	String ownerSafetyWarningId;

	/**
	 * 属性描述:车牌号
	 */
	@TableField(value="CAR_PLATE_NUM",exist=true)
	String carPlateNum;

	/**
	 * 属性描述:车架号
	 */
	@TableField(value="CAR_FRAME_NUM",exist=true)
	String carFrameNum;

	/**
	 * 属性描述:文件名
	 */
	@TableField(value="FILE_NAME",exist=true)
	String fileName;

	/**
	 * 属性描述:文件类型
	 */
	@TableField(value="FILE_TYPE",exist=true)
	String fileType;

	/**
	 * 属性描述:路径
	 */
	@TableField(value="FILE_URL",exist=true)
	String fileUrl;
	/**
	 * 属性描述:备注
	 */
	@TableField(value="REMARK",exist=true)
	String remark;
	//是否下载
	@TableField(value="IS_DOWNLOAD",exist=true)
	String isDownload;
	//分片日期
	@TableField(value="COUNT_DATE",exist=true)
	Integer countDate;
	//所属月份
	@TableField(value="COUNT_MONTH",exist=true)
	Integer countMonth;

	@TableField(value="SERV_INFO",exist=true)
	String servInfo;

	@TableField(value="SERV_PORT",exist=true)
	Integer servPort;

	@TableField(value="USER_NAME",exist=true)
	String userName;

	@TableField(value="FILE_FTP_URL",exist=true)
	String fileFtpUrl;

	@TableField(value="FILE_FTP_NAME",exist=true)
	String fileFtpName;

	public String getFileFtpUrl() {
		return fileFtpUrl;
	}

	public void setFileFtpUrl(String fileFtpUrl) {
		this.fileFtpUrl = fileFtpUrl;
	}

	public String getFileFtpName() {
		return fileFtpName;
	}

	public void setFileFtpName(String fileFtpName) {
		this.fileFtpName = fileFtpName;
	}

	public String getServInfo() {
		return servInfo;
	}

	public void setServInfo(String servInfo) {
		this.servInfo = servInfo;
	}

	public Integer getServPort() {
		return servPort;
	}

	public void setServPort(Integer servPort) {
		this.servPort = servPort;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIsDownload() {
		return isDownload;
	}

	public void setIsDownload(String isDownload) {
		this.isDownload = isDownload;
	}

	public Integer getCountDate() {
		return countDate;
	}

	public void setCountDate(Integer countDate) {
		this.countDate = countDate;
	}

	public Integer getCountMonth() {
		return countMonth;
	}

	public void setCountMonth(Integer countMonth) {
		this.countMonth = countMonth;
	}

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}


	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}


	public String getOwnerSafetyWarningId(){
		return this.ownerSafetyWarningId;
	}

	public void setOwnerSafetyWarningId(String ownerSafetyWarningId){
		this.ownerSafetyWarningId=ownerSafetyWarningId;
	}


	public String getCarPlateNum(){
		return this.carPlateNum;
	}

	public void setCarPlateNum(String carPlateNum){
		this.carPlateNum=carPlateNum;
	}


	public String getCarFrameNum(){
		return this.carFrameNum;
	}

	public void setCarFrameNum(String carFrameNum){
		this.carFrameNum=carFrameNum;
	}


	public String getFileName(){
		return this.fileName;
	}

	public void setFileName(String fileName){
		this.fileName=fileName;
	}


	public String getFileType(){
		return this.fileType;
	}

	public void setFileType(String fileType){
		this.fileType=fileType;
	}


	public String getFileUrl(){
		return this.fileUrl;
	}

	public void setFileUrl(String fileUrl){
		this.fileUrl=fileUrl;
	}


	public String getRemark(){
		return this.remark;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", ownerSafetyWarningId=").append(ownerSafetyWarningId);			
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carFrameNum=").append(carFrameNum);			
			sb.append(", fileName=").append(fileName);			
			sb.append(", fileType=").append(fileType);			
			sb.append(", fileUrl=").append(fileUrl);			
			sb.append(", remark=").append(remark);			
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
        BigdataSafetyWarningFile other = (BigdataSafetyWarningFile) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getOwnerSafetyWarningId() == null ? other.getId() == null : this.getOwnerSafetyWarningId().equals(other.getOwnerSafetyWarningId()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarFrameNum() == null ? other.getId() == null : this.getCarFrameNum().equals(other.getCarFrameNum()))		
				        		&&(this.getFileName() == null ? other.getId() == null : this.getFileName().equals(other.getFileName()))		
				        		&&(this.getFileType() == null ? other.getId() == null : this.getFileType().equals(other.getFileType()))		
				        		&&(this.getFileUrl() == null ? other.getId() == null : this.getFileUrl().equals(other.getFileUrl()))		
				        		&&(this.getRemark() == null ? other.getId() == null : this.getRemark().equals(other.getRemark()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getOwnerSafetyWarningId() == null) ? 0 : getOwnerSafetyWarningId().hashCode());		
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarFrameNum() == null) ? 0 : getCarFrameNum().hashCode());		
		        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());		
		        result = prime * result + ((getFileType() == null) ? 0 : getFileType().hashCode());		
		        result = prime * result + ((getFileUrl() == null) ? 0 : getFileUrl().hashCode());		
		        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());		
		;
        return result;
    }

}
