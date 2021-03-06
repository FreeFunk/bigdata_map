package com.edgedo.bigdata.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_safety_warning")
public class BigdataSafetyWarning implements Serializable{
	
		
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
	 * 属性描述:车牌号
	 */
	@TableField(value="CAR_PLATE_NUM",exist=true)
	java.lang.String carPlateNum;
	
	/**
	 * 属性描述:车架号
	 */
	@TableField(value="CAR_FRAME_NUM",exist=true)
	java.lang.String carFrameNum;
	
	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	java.lang.String carType;
	/**
	 * 属性描述:运营商id
	 */
	@TableField(value="COMP_ID",exist=true)
	String compId;

	/**
	 * 属性描述:运营商名称
	 */
	@TableField(value="COMP_NAME",exist=true)
	String compName;
	
	/**
	 * 属性描述:司机
	 */
	@TableField(value="EMP_NAME",exist=true)
	java.lang.String empName;
	
	/**
	 * 属性描述:身份证号
	 */
	@TableField(value="EMP_ID_CARD",exist=true)
	java.lang.String empIdCard;
	
	/**
	 * 属性描述:资格证号
	 */
	@TableField(value="EMP_CODE",exist=true)
	java.lang.String empCode;
	/**
	 * 属性描述:资格证号
	 */
	@TableField(value="EMP_ID",exist=true)
	java.lang.String empId;

	/**
	 * 属性描述:所属企业ID
	 */
	@TableField(value="OWNER_TEAM_ID",exist=true)
	java.lang.String ownerTeamId;
	
	/**
	 * 属性描述:所属企业名
	 */
	@TableField(value="OWNER_TEAM_NAME",exist=true)
	java.lang.String ownerTeamName;
	
	/**
	 * 属性描述:报警子类型
	 */
	@TableField(value="WARNING_TYPE",exist=true)
	java.lang.String warningType;
	
	/**
	 * 属性描述:报警等级
	 */
	@TableField(value="WARNING_LEVEL",exist=true)
	java.lang.String warningLevel;
	
	/**
	 * 属性描述:报警详情
	 */
	@TableField(value="WARNING_INFO",exist=true)
	java.lang.String warningInfo;
	
	/**
	 * 属性描述:上传时间
	 */
	@TableField(value="UPLOAD_TIME",exist=true)
	java.util.Date uploadTime;
	
	/**
	 * 属性描述:处理结果
	 */
	@TableField(value="DETAIL_INFO",exist=true)
	java.lang.String detailInfo;

	/**
	 * 属性描述:统计日期
	 */
	@TableField(value="COUNT_DATE",exist=true)
	Integer countDate;

	/**
	 * 属性描述:统计月份
	 */
	@TableField(value="COUNT_MONTH",exist=true)
	Integer countMonth;

	/**
	 * 属性描述:开始时间
	 */
	@TableField(value="STARTTIME",exist=true)
	java.util.Date starttime;

	/**
	 * 属性描述:车牌颜色文本
	 */
	@TableField(value="CAR_PLATE_COLOR_TEXT",exist=true)
	String carPlateColorText;

	/**
	 * 属性描述:车牌颜色
	 */
	@TableField(value="CAR_PLATE_COLOR",exist=true)
	String carPlateColor;

	/**
	 * 属性描述:处理状态
	 */
	@TableField(value="HANDLE_STATE",exist=true)
	String handleState;

	/**
	 * 属性描述:处理方式
	 */
	@TableField(value="HANDLE_TYPE",exist=true)
	String handleType;

	/**
	 * 属性描述:处理时间
	 */
	@TableField(value="HANDLE_TIME",exist=true)
	java.util.Date handleTime;

	/**
	 * 属性描述:速度
	 */
	@TableField(value="SPEED",exist=true)
	java.math.BigDecimal speed;

	public BigDecimal getSpeed() {
		return speed;
	}

	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}

	public String getCarPlateColor() {
		return carPlateColor;
	}

	public void setCarPlateColor(String carPlateColor) {
		this.carPlateColor = carPlateColor;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getHandleState() {
		return handleState;
	}

	public void setHandleState(String handleState) {
		this.handleState = handleState;
	}

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

	public Date getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}

	public String getCarPlateColorText() {
		return carPlateColorText;
	}

	public void setCarPlateColorText(String carPlateColorText) {
		this.carPlateColorText = carPlateColorText;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
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

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

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
	
	
	public java.lang.String getCarPlateNum(){
		return this.carPlateNum;
	}
	
	public void setCarPlateNum(java.lang.String carPlateNum){
		this.carPlateNum=carPlateNum;
	}
	
	
	public java.lang.String getCarFrameNum(){
		return this.carFrameNum;
	}
	
	public void setCarFrameNum(java.lang.String carFrameNum){
		this.carFrameNum=carFrameNum;
	}
	
	
	public java.lang.String getCarType(){
		return this.carType;
	}
	
	public void setCarType(java.lang.String carType){
		this.carType=carType;
	}
	
	
	public java.lang.String getEmpName(){
		return this.empName;
	}
	
	public void setEmpName(java.lang.String empName){
		this.empName=empName;
	}
	
	
	public java.lang.String getEmpIdCard(){
		return this.empIdCard;
	}
	
	public void setEmpIdCard(java.lang.String empIdCard){
		this.empIdCard=empIdCard;
	}
	
	
	public java.lang.String getEmpCode(){
		return this.empCode;
	}
	
	public void setEmpCode(java.lang.String empCode){
		this.empCode=empCode;
	}
	
	
	public java.lang.String getOwnerTeamId(){
		return this.ownerTeamId;
	}
	
	public void setOwnerTeamId(java.lang.String ownerTeamId){
		this.ownerTeamId=ownerTeamId;
	}
	
	
	public java.lang.String getOwnerTeamName(){
		return this.ownerTeamName;
	}
	
	public void setOwnerTeamName(java.lang.String ownerTeamName){
		this.ownerTeamName=ownerTeamName;
	}
	
	
	public java.lang.String getWarningType(){
		return this.warningType;
	}
	
	public void setWarningType(java.lang.String warningType){
		this.warningType=warningType;
	}
	
	
	public java.lang.String getWarningLevel(){
		return this.warningLevel;
	}
	
	public void setWarningLevel(java.lang.String warningLevel){
		this.warningLevel=warningLevel;
	}
	
	
	public java.lang.String getWarningInfo(){
		return this.warningInfo;
	}
	
	public void setWarningInfo(java.lang.String warningInfo){
		this.warningInfo=warningInfo;
	}
	
	
	public java.util.Date getUploadTime(){
		return this.uploadTime;
	}
	
	public void setUploadTime(java.util.Date uploadTime){
		this.uploadTime=uploadTime;
	}
	
	
	public java.lang.String getDetailInfo(){
		return this.detailInfo;
	}
	
	public void setDetailInfo(java.lang.String detailInfo){
		this.detailInfo=detailInfo;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carFrameNum=").append(carFrameNum);			
			sb.append(", carType=").append(carType);			
			sb.append(", empName=").append(empName);			
			sb.append(", empIdCard=").append(empIdCard);			
			sb.append(", empCode=").append(empCode);			
			sb.append(", ownerTeamId=").append(ownerTeamId);			
			sb.append(", ownerTeamName=").append(ownerTeamName);			
			sb.append(", warningType=").append(warningType);			
			sb.append(", warningLevel=").append(warningLevel);			
			sb.append(", warningInfo=").append(warningInfo);			
			sb.append(", uploadTime=").append(uploadTime);			
			sb.append(", detailInfo=").append(detailInfo);			
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
        BigdataSafetyWarning other = (BigdataSafetyWarning) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarFrameNum() == null ? other.getId() == null : this.getCarFrameNum().equals(other.getCarFrameNum()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getEmpName() == null ? other.getId() == null : this.getEmpName().equals(other.getEmpName()))		
				        		&&(this.getEmpIdCard() == null ? other.getId() == null : this.getEmpIdCard().equals(other.getEmpIdCard()))		
				        		&&(this.getEmpCode() == null ? other.getId() == null : this.getEmpCode().equals(other.getEmpCode()))		
				        		&&(this.getOwnerTeamId() == null ? other.getId() == null : this.getOwnerTeamId().equals(other.getOwnerTeamId()))		
				        		&&(this.getOwnerTeamName() == null ? other.getId() == null : this.getOwnerTeamName().equals(other.getOwnerTeamName()))		
				        		&&(this.getWarningType() == null ? other.getId() == null : this.getWarningType().equals(other.getWarningType()))		
				        		&&(this.getWarningLevel() == null ? other.getId() == null : this.getWarningLevel().equals(other.getWarningLevel()))		
				        		&&(this.getWarningInfo() == null ? other.getId() == null : this.getWarningInfo().equals(other.getWarningInfo()))		
				        		&&(this.getUploadTime() == null ? other.getId() == null : this.getUploadTime().equals(other.getUploadTime()))		
				        		&&(this.getDetailInfo() == null ? other.getId() == null : this.getDetailInfo().equals(other.getDetailInfo()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarFrameNum() == null) ? 0 : getCarFrameNum().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getEmpName() == null) ? 0 : getEmpName().hashCode());		
		        result = prime * result + ((getEmpIdCard() == null) ? 0 : getEmpIdCard().hashCode());		
		        result = prime * result + ((getEmpCode() == null) ? 0 : getEmpCode().hashCode());		
		        result = prime * result + ((getOwnerTeamId() == null) ? 0 : getOwnerTeamId().hashCode());		
		        result = prime * result + ((getOwnerTeamName() == null) ? 0 : getOwnerTeamName().hashCode());		
		        result = prime * result + ((getWarningType() == null) ? 0 : getWarningType().hashCode());		
		        result = prime * result + ((getWarningLevel() == null) ? 0 : getWarningLevel().hashCode());		
		        result = prime * result + ((getWarningInfo() == null) ? 0 : getWarningInfo().hashCode());		
		        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());		
		        result = prime * result + ((getDetailInfo() == null) ? 0 : getDetailInfo().hashCode());		
		;
        return result;
    }

}
