package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("limit_speed_warning")
public class LimitSpeedWarning implements Serializable{
	
		
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
	 * 属性描述:报警时间
	 */
	@TableField(value="WARNING_TIME",exist=true)
	java.util.Date warningTime;
	
	/**
	 * 属性描述:报警速度
	 */
	@TableField(value="WARNING_SPEED",exist=true)
	java.math.BigDecimal warningSpeed;
	
	/**
	 * 属性描述:道路等级
	 */
	@TableField(value="ROAD_LEVEL",exist=true)
	java.lang.String roadLevel;
	
	/**
	 * 属性描述:道路限速值
	 */
	@TableField(value="ROAD_LIMIT_SPEED",exist=true)
	java.lang.Integer roadLimitSpeed;
	
	
	
	
	
	
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
	
	
	public java.util.Date getWarningTime(){
		return this.warningTime;
	}
	
	public void setWarningTime(java.util.Date warningTime){
		this.warningTime=warningTime;
	}
	
	
	public java.math.BigDecimal getWarningSpeed(){
		return this.warningSpeed;
	}
	
	public void setWarningSpeed(java.math.BigDecimal warningSpeed){
		this.warningSpeed=warningSpeed;
	}
	
	
	public java.lang.String getRoadLevel(){
		return this.roadLevel;
	}
	
	public void setRoadLevel(java.lang.String roadLevel){
		this.roadLevel=roadLevel;
	}
	
	
	public java.lang.Integer getRoadLimitSpeed(){
		return this.roadLimitSpeed;
	}
	
	public void setRoadLimitSpeed(java.lang.Integer roadLimitSpeed){
		this.roadLimitSpeed=roadLimitSpeed;
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
			sb.append(", ownerTeamId=").append(ownerTeamId);			
			sb.append(", ownerTeamName=").append(ownerTeamName);			
			sb.append(", empName=").append(empName);			
			sb.append(", empIdCard=").append(empIdCard);			
			sb.append(", empCode=").append(empCode);			
			sb.append(", warningTime=").append(warningTime);			
			sb.append(", warningSpeed=").append(warningSpeed);			
			sb.append(", roadLevel=").append(roadLevel);			
			sb.append(", roadLimitSpeed=").append(roadLimitSpeed);			
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
        LimitSpeedWarning other = (LimitSpeedWarning) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarFrameNum() == null ? other.getId() == null : this.getCarFrameNum().equals(other.getCarFrameNum()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
				        		&&(this.getOwnerTeamId() == null ? other.getId() == null : this.getOwnerTeamId().equals(other.getOwnerTeamId()))		
				        		&&(this.getOwnerTeamName() == null ? other.getId() == null : this.getOwnerTeamName().equals(other.getOwnerTeamName()))		
				        		&&(this.getEmpName() == null ? other.getId() == null : this.getEmpName().equals(other.getEmpName()))		
				        		&&(this.getEmpIdCard() == null ? other.getId() == null : this.getEmpIdCard().equals(other.getEmpIdCard()))		
				        		&&(this.getEmpCode() == null ? other.getId() == null : this.getEmpCode().equals(other.getEmpCode()))		
				        		&&(this.getWarningTime() == null ? other.getId() == null : this.getWarningTime().equals(other.getWarningTime()))		
				        		&&(this.getWarningSpeed() == null ? other.getId() == null : this.getWarningSpeed().equals(other.getWarningSpeed()))		
				        		&&(this.getRoadLevel() == null ? other.getId() == null : this.getRoadLevel().equals(other.getRoadLevel()))		
				        		&&(this.getRoadLimitSpeed() == null ? other.getId() == null : this.getRoadLimitSpeed().equals(other.getRoadLimitSpeed()))		
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
		        result = prime * result + ((getOwnerTeamId() == null) ? 0 : getOwnerTeamId().hashCode());		
		        result = prime * result + ((getOwnerTeamName() == null) ? 0 : getOwnerTeamName().hashCode());		
		        result = prime * result + ((getEmpName() == null) ? 0 : getEmpName().hashCode());		
		        result = prime * result + ((getEmpIdCard() == null) ? 0 : getEmpIdCard().hashCode());		
		        result = prime * result + ((getEmpCode() == null) ? 0 : getEmpCode().hashCode());		
		        result = prime * result + ((getWarningTime() == null) ? 0 : getWarningTime().hashCode());		
		        result = prime * result + ((getWarningSpeed() == null) ? 0 : getWarningSpeed().hashCode());		
		        result = prime * result + ((getRoadLevel() == null) ? 0 : getRoadLevel().hashCode());		
		        result = prime * result + ((getRoadLimitSpeed() == null) ? 0 : getRoadLimitSpeed().hashCode());		
		;
        return result;
    }

}
