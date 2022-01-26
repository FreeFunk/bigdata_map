package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_user_role")
public class SysUserRole implements Serializable{
	
	/**
	 * 属性描述:用户id
	 */
	@TableField(value="USER_ID",exist=true)
	String userId;
	
	/**
	 * 属性描述:角色id
	 */
	@TableField(value="ROLE_ID",exist=true)
	String roleId;
	
	
	
	
	
	
	public String getUserId(){
		return this.userId;
	}
	
	public void setUserId(String userId){
		this.userId=userId;
	}
	
	
	public String getRoleId(){
		return this.roleId;
	}
	
	public void setRoleId(String roleId){
		this.roleId=roleId;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", userId=").append(userId);			
			sb.append(", roleId=").append(roleId);			
        sb.append("]");
        return sb.toString();
    }

    /**
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
        SysUserRole other = (SysUserRole) that;
        boolean flag = true;
        return  flag
        		&&(this.getUserId() == null ? other.getId() == null : this.getUserId().equals(other.getUserId()))		
				        		&&(this.getRoleId() == null ? other.getId() == null : this.getRoleId().equals(other.getRoleId()))		
				;
    }
*/
  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());		
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        return result;
    }

}
