package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_monitor_alarm")
public class SysMonitorAlarm implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:报警时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	/**
	 * 属性描述:报警类型
	 */
	@TableField(value="ALARM_TYPE",exist=true)
	java.lang.String alarmType;
	
	/**
	 * 属性描述:报警状态
	 */
	@TableField(value="ALARM_STATE",exist=true)
	java.lang.String alarmState;
	
	/**
	 * 属性描述:所属系统
	 */
	@TableField(value="SYSTEM_NAME",exist=true)
	java.lang.String systemName;
	
	/**
	 * 属性描述:系统模块
	 */
	@TableField(value="SYSTEM_MODEL",exist=true)
	java.lang.String systemModel;
	
	
	
	
	
	
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
	
	
	public java.lang.String getAlarmType(){
		return this.alarmType;
	}
	
	public void setAlarmType(java.lang.String alarmType){
		this.alarmType=alarmType;
	}
	
	
	public java.lang.String getAlarmState(){
		return this.alarmState;
	}
	
	public void setAlarmState(java.lang.String alarmState){
		this.alarmState=alarmState;
	}
	
	
	public java.lang.String getSystemName(){
		return this.systemName;
	}
	
	public void setSystemName(java.lang.String systemName){
		this.systemName=systemName;
	}
	
	
	public java.lang.String getSystemModel(){
		return this.systemModel;
	}
	
	public void setSystemModel(java.lang.String systemModel){
		this.systemModel=systemModel;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", alarmType=").append(alarmType);			
			sb.append(", alarmState=").append(alarmState);			
			sb.append(", systemName=").append(systemName);			
			sb.append(", systemModel=").append(systemModel);			
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
        SysMonitorAlarm other = (SysMonitorAlarm) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getAlarmType() == null ? other.getId() == null : this.getAlarmType().equals(other.getAlarmType()))		
				        		&&(this.getAlarmState() == null ? other.getId() == null : this.getAlarmState().equals(other.getAlarmState()))		
				        		&&(this.getSystemName() == null ? other.getId() == null : this.getSystemName().equals(other.getSystemName()))		
				        		&&(this.getSystemModel() == null ? other.getId() == null : this.getSystemModel().equals(other.getSystemModel()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getAlarmType() == null) ? 0 : getAlarmType().hashCode());		
		        result = prime * result + ((getAlarmState() == null) ? 0 : getAlarmState().hashCode());		
		        result = prime * result + ((getSystemName() == null) ? 0 : getSystemName().hashCode());		
		        result = prime * result + ((getSystemModel() == null) ? 0 : getSystemModel().hashCode());		
		;
        return result;
    }

}
