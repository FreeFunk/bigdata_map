package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_role_menue")
public class SysRoleMenue implements Serializable{
	
	/**
	 * 属性描述:菜单ID
	 */
	@TableField(value="MENUE_ID",exist=true)
	String menueId;
	
	/**
	 * 属性描述:角色ID
	 */
	@TableField(value="ROLE_ID",exist=true)
	String roleId;
	
	
	
	
	
	
	public String getMenueId(){
		return this.menueId;
	}
	
	public void setMenueId(String menueId){
		this.menueId=menueId;
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
			sb.append(", menueId=").append(menueId);			
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
        SysRoleMenue other = (SysRoleMenue) that;
        boolean flag = true;
        return  flag
        		&&(this.getMenueId() == null ? other.getId() == null : this.getMenueId().equals(other.getMenueId()))		
				        		&&(this.getRoleId() == null ? other.getId() == null : this.getRoleId().equals(other.getRoleId()))		
				;
    }
	*/
  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMenueId() == null) ? 0 : getMenueId().hashCode());		
		        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());		
		;
        return result;
    }
	

}
