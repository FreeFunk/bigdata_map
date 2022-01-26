package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_role_power")
public class SysRolePower implements Serializable{
	
	/**
	 * 属性描述:角色id
	 */
	@TableField(value="ROLE_ID",exist=true)
	String roleId;
	
	/**
	 * 属性描述:权限id
	 */
	@TableField(value="POWER_ID",exist=true)
	String powerId;
	
	/**
	 * 属性描述:菜单id
	 */
	@TableField(value="MENUE_ID",exist=true)
	String menueId;
	
	
	
	
	
	
	public String getRoleId(){
		return this.roleId;
	}
	
	public void setRoleId(String roleId){
		this.roleId=roleId;
	}
	
	
	public String getPowerId(){
		return this.powerId;
	}
	
	public void setPowerId(String powerId){
		this.powerId=powerId;
	}
	
	
	public String getMenueId(){
		return this.menueId;
	}
	
	public void setMenueId(String menueId){
		this.menueId=menueId;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", roleId=").append(roleId);			
			sb.append(", powerId=").append(powerId);			
			sb.append(", menueId=").append(menueId);			
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
        SysRolePower other = (SysRolePower) that;
        boolean flag = true;
        return  flag
        		&&(this.getRoleId() == null ? other.getId() == null : this.getRoleId().equals(other.getRoleId()))		
				        		&&(this.getPowerId() == null ? other.getId() == null : this.getPowerId().equals(other.getPowerId()))		
				        		&&(this.getMenueId() == null ? other.getId() == null : this.getMenueId().equals(other.getMenueId()))		
				;
    }
*/
  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());		
		        result = prime * result + ((getPowerId() == null) ? 0 : getPowerId().hashCode());		
		        result = prime * result + ((getMenueId() == null) ? 0 : getMenueId().hashCode());		
		;
        return result;
    }

}
