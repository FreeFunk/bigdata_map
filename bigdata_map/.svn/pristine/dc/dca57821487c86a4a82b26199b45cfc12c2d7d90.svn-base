package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_safety_check")
public class BigdataSafetyCheck implements Serializable{
	
		
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
	 * 属性描述:疲劳驾驶考核
	 */
	@TableField(value="FATIGUE_RUN_CHECK",exist=true)
	java.math.BigDecimal fatigueRunCheck;
	
	/**
	 * 属性描述:超速驾驶考核
	 */
	@TableField(value="OVERSPEED_RUN_CHECK",exist=true)
	java.math.BigDecimal overspeedRunCheck;
	
	/**
	 * 属性描述:企业安全隐患考核
	 */
	@TableField(value="TEAM_SAFETY_CHECK",exist=true)
	java.math.BigDecimal teamSafetyCheck;
	
	/**
	 * 属性描述:车辆上线率考核
	 */
	@TableField(value="CAR_ONLINE_RATE_CHECK",exist=true)
	java.math.BigDecimal carOnlineRateCheck;
	
	/**
	 * 属性描述:车辆运营率考核
	 */
	@TableField(value="CAR_OPERATE_RATE_CHECK",exist=true)
	java.math.BigDecimal carOperateRateCheck;
	
	/**
	 * 属性描述:从业人员新增数考核
	 */
	@TableField(value="EMP_ADD_CHECK",exist=true)
	java.math.BigDecimal empAddCheck;
	
	/**
	 * 属性描述:车辆新增数考核
	 */
	@TableField(value="CAR_ADD_CHECK",exist=true)
	java.math.BigDecimal carAddCheck;
	
	/**
	 * 属性描述:企业新增考核
	 */
	@TableField(value="TEAM_ADD_CHECK",exist=true)
	java.math.BigDecimal teamAddCheck;
	
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
	
	
	public java.math.BigDecimal getFatigueRunCheck(){
		return this.fatigueRunCheck;
	}
	
	public void setFatigueRunCheck(java.math.BigDecimal fatigueRunCheck){
		this.fatigueRunCheck=fatigueRunCheck;
	}
	
	
	public java.math.BigDecimal getOverspeedRunCheck(){
		return this.overspeedRunCheck;
	}
	
	public void setOverspeedRunCheck(java.math.BigDecimal overspeedRunCheck){
		this.overspeedRunCheck=overspeedRunCheck;
	}
	
	
	public java.math.BigDecimal getTeamSafetyCheck(){
		return this.teamSafetyCheck;
	}
	
	public void setTeamSafetyCheck(java.math.BigDecimal teamSafetyCheck){
		this.teamSafetyCheck=teamSafetyCheck;
	}
	
	
	public java.math.BigDecimal getCarOnlineRateCheck(){
		return this.carOnlineRateCheck;
	}
	
	public void setCarOnlineRateCheck(java.math.BigDecimal carOnlineRateCheck){
		this.carOnlineRateCheck=carOnlineRateCheck;
	}
	
	
	public java.math.BigDecimal getCarOperateRateCheck(){
		return this.carOperateRateCheck;
	}
	
	public void setCarOperateRateCheck(java.math.BigDecimal carOperateRateCheck){
		this.carOperateRateCheck=carOperateRateCheck;
	}
	
	
	public java.math.BigDecimal getEmpAddCheck(){
		return this.empAddCheck;
	}
	
	public void setEmpAddCheck(java.math.BigDecimal empAddCheck){
		this.empAddCheck=empAddCheck;
	}
	
	
	public java.math.BigDecimal getCarAddCheck(){
		return this.carAddCheck;
	}
	
	public void setCarAddCheck(java.math.BigDecimal carAddCheck){
		this.carAddCheck=carAddCheck;
	}
	
	
	public java.math.BigDecimal getTeamAddCheck(){
		return this.teamAddCheck;
	}
	
	public void setTeamAddCheck(java.math.BigDecimal teamAddCheck){
		this.teamAddCheck=teamAddCheck;
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
			sb.append(", fatigueRunCheck=").append(fatigueRunCheck);			
			sb.append(", overspeedRunCheck=").append(overspeedRunCheck);			
			sb.append(", teamSafetyCheck=").append(teamSafetyCheck);			
			sb.append(", carOnlineRateCheck=").append(carOnlineRateCheck);			
			sb.append(", carOperateRateCheck=").append(carOperateRateCheck);			
			sb.append(", empAddCheck=").append(empAddCheck);			
			sb.append(", carAddCheck=").append(carAddCheck);			
			sb.append(", teamAddCheck=").append(teamAddCheck);			
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
        BigdataSafetyCheck other = (BigdataSafetyCheck) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getFatigueRunCheck() == null ? other.getId() == null : this.getFatigueRunCheck().equals(other.getFatigueRunCheck()))		
				        		&&(this.getOverspeedRunCheck() == null ? other.getId() == null : this.getOverspeedRunCheck().equals(other.getOverspeedRunCheck()))		
				        		&&(this.getTeamSafetyCheck() == null ? other.getId() == null : this.getTeamSafetyCheck().equals(other.getTeamSafetyCheck()))		
				        		&&(this.getCarOnlineRateCheck() == null ? other.getId() == null : this.getCarOnlineRateCheck().equals(other.getCarOnlineRateCheck()))		
				        		&&(this.getCarOperateRateCheck() == null ? other.getId() == null : this.getCarOperateRateCheck().equals(other.getCarOperateRateCheck()))		
				        		&&(this.getEmpAddCheck() == null ? other.getId() == null : this.getEmpAddCheck().equals(other.getEmpAddCheck()))		
				        		&&(this.getCarAddCheck() == null ? other.getId() == null : this.getCarAddCheck().equals(other.getCarAddCheck()))		
				        		&&(this.getTeamAddCheck() == null ? other.getId() == null : this.getTeamAddCheck().equals(other.getTeamAddCheck()))		
				        		&&(this.getCountTime() == null ? other.getId() == null : this.getCountTime().equals(other.getCountTime()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getFatigueRunCheck() == null) ? 0 : getFatigueRunCheck().hashCode());		
		        result = prime * result + ((getOverspeedRunCheck() == null) ? 0 : getOverspeedRunCheck().hashCode());		
		        result = prime * result + ((getTeamSafetyCheck() == null) ? 0 : getTeamSafetyCheck().hashCode());		
		        result = prime * result + ((getCarOnlineRateCheck() == null) ? 0 : getCarOnlineRateCheck().hashCode());		
		        result = prime * result + ((getCarOperateRateCheck() == null) ? 0 : getCarOperateRateCheck().hashCode());		
		        result = prime * result + ((getEmpAddCheck() == null) ? 0 : getEmpAddCheck().hashCode());		
		        result = prime * result + ((getCarAddCheck() == null) ? 0 : getCarAddCheck().hashCode());		
		        result = prime * result + ((getTeamAddCheck() == null) ? 0 : getTeamAddCheck().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		;
        return result;
    }

}
