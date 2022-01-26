package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_user_login_log")
public class SysUserLoginLog implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;
	
	/**
	 * 属性描述:登录时间
	 */
	@TableField(value="LOGIN_TIME",exist=true)
	java.util.Date loginTime;
	
	/**
	 * 属性描述:登录ip
	 */
	@TableField(value="IP",exist=true)
	String ip;
	
	/**
	 * 属性描述:用户姓名
	 */
	@TableField(value="USER_NAME",exist=true)
	String userName;
	
	/**
	 * 属性描述:登录用户id
	 */
	@TableField(value="USER_ID",exist=true)
	String userId;
	
	/**
	 * 属性描述:登录用户手机号
	 */
	@TableField(value="USER_PHONE",exist=true)
	String userPhone;
	
	/**
	 * 属性描述:登出时间
	 */
	@TableField(value="LOGOUT_TIME",exist=true)
	java.util.Date logoutTime;
	
	/**
	 * 属性描述:登出类型
	 */
	@TableField(value="LOGOUT_TYPE",exist=true)
	String logoutType;
	
	/**
	 * 属性描述:登录账号
	 */
	@TableField(value="USER_CODE",exist=true)
	String userCode;
	
	
	
	
	
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public java.util.Date getLoginTime(){
		return this.loginTime;
	}
	
	public void setLoginTime(java.util.Date loginTime){
		this.loginTime=loginTime;
	}
	
	
	public String getIp(){
		return this.ip;
	}
	
	public void setIp(String ip){
		this.ip=ip;
	}
	
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	
	public String getUserId(){
		return this.userId;
	}
	
	public void setUserId(String userId){
		this.userId=userId;
	}
	
	
	public String getUserPhone(){
		return this.userPhone;
	}
	
	public void setUserPhone(String userPhone){
		this.userPhone=userPhone;
	}
	
	
	public java.util.Date getLogoutTime(){
		return this.logoutTime;
	}
	
	public void setLogoutTime(java.util.Date logoutTime){
		this.logoutTime=logoutTime;
	}
	
	
	public String getLogoutType(){
		return this.logoutType;
	}
	
	public void setLogoutType(String logoutType){
		this.logoutType=logoutType;
	}
	
	
	public String getUserCode(){
		return this.userCode;
	}
	
	public void setUserCode(String userCode){
		this.userCode=userCode;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", loginTime=").append(loginTime);			
			sb.append(", ip=").append(ip);			
			sb.append(", userName=").append(userName);			
			sb.append(", userId=").append(userId);			
			sb.append(", userPhone=").append(userPhone);			
			sb.append(", logoutTime=").append(logoutTime);			
			sb.append(", logoutType=").append(logoutType);			
			sb.append(", userCode=").append(userCode);			
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
        SysUserLoginLog other = (SysUserLoginLog) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getLoginTime() == null ? other.getId() == null : this.getLoginTime().equals(other.getLoginTime()))		
				        		&&(this.getIp() == null ? other.getId() == null : this.getIp().equals(other.getIp()))		
				        		&&(this.getUserName() == null ? other.getId() == null : this.getUserName().equals(other.getUserName()))		
				        		&&(this.getUserId() == null ? other.getId() == null : this.getUserId().equals(other.getUserId()))		
				        		&&(this.getUserPhone() == null ? other.getId() == null : this.getUserPhone().equals(other.getUserPhone()))		
				        		&&(this.getLogoutTime() == null ? other.getId() == null : this.getLogoutTime().equals(other.getLogoutTime()))		
				        		&&(this.getLogoutType() == null ? other.getId() == null : this.getLogoutType().equals(other.getLogoutType()))		
				        		&&(this.getUserCode() == null ? other.getId() == null : this.getUserCode().equals(other.getUserCode()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());		
		        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());		
		        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());		
		        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());		
		        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());		
		        result = prime * result + ((getLogoutTime() == null) ? 0 : getLogoutTime().hashCode());		
		        result = prime * result + ((getLogoutType() == null) ? 0 : getLogoutType().hashCode());		
		        result = prime * result + ((getUserCode() == null) ? 0 : getUserCode().hashCode());		
		;
        return result;
    }

}
