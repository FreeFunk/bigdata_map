package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_org_level_role")
public class SysOrgLevelRole implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;
	
	/**
	 * 属性描述:职级名称
	 */
	@TableField(value="ROLE_NAME",exist=true)
	String roleName;
	
	/**
	 * 属性描述:父职级主键
	 */
	@TableField(value="PARENT_ID",exist=true)
	String parentId;
	
	/**
	 * 属性描述:是否是叶子
	 */
	@TableField(value="IS_LEAF",exist=true)
	String isLeaf;
	
	/**
	 * 属性描述:排序号
	 */
	@TableField(value="ORDER_NUMBER",exist=true)
	java.math.BigDecimal orderNumber;
	
	/**
	 * 属性描述:角色主页
	 */
	@TableField(value="ROLE_HOME_PAGE",exist=true)
	String roleHomePage;
	
	/**
	 * 属性描述:角色主页地址
	 */
	@TableField(value="ROLE_HOME_PAGE_PATH",exist=true)
	String roleHomePagePath;
	
	/**
	 * 属性描述:角色主页id
	 */
	@TableField(value="ROLE_HOME_PAGE_ID",exist=true)
	String roleHomePageId;
	
	
	
	
	
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public String getRoleName(){
		return this.roleName;
	}
	
	public void setRoleName(String roleName){
		this.roleName=roleName;
	}
	
	
	public String getParentId(){
		return this.parentId;
	}
	
	public void setParentId(String parentId){
		this.parentId=parentId;
	}
	
	
	public String getIsLeaf(){
		return this.isLeaf;
	}
	
	public void setIsLeaf(String isLeaf){
		this.isLeaf=isLeaf;
	}
	
	
	public java.math.BigDecimal getOrderNumber(){
		return this.orderNumber;
	}
	
	public void setOrderNumber(java.math.BigDecimal orderNumber){
		this.orderNumber=orderNumber;
	}
	
	
	public String getRoleHomePage(){
		return this.roleHomePage;
	}
	
	public void setRoleHomePage(String roleHomePage){
		this.roleHomePage=roleHomePage;
	}
	
	
	public String getRoleHomePagePath(){
		return this.roleHomePagePath;
	}
	
	public void setRoleHomePagePath(String roleHomePagePath){
		this.roleHomePagePath=roleHomePagePath;
	}
	
	
	public String getRoleHomePageId(){
		return this.roleHomePageId;
	}
	
	public void setRoleHomePageId(String roleHomePageId){
		this.roleHomePageId=roleHomePageId;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", roleName=").append(roleName);			
			sb.append(", parentId=").append(parentId);			
			sb.append(", isLeaf=").append(isLeaf);			
			sb.append(", orderNumber=").append(orderNumber);			
			sb.append(", roleHomePage=").append(roleHomePage);			
			sb.append(", roleHomePagePath=").append(roleHomePagePath);			
			sb.append(", roleHomePageId=").append(roleHomePageId);			
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
        SysOrgLevelRole other = (SysOrgLevelRole) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getRoleName() == null ? other.getId() == null : this.getRoleName().equals(other.getRoleName()))		
				        		&&(this.getParentId() == null ? other.getId() == null : this.getParentId().equals(other.getParentId()))		
				        		&&(this.getIsLeaf() == null ? other.getId() == null : this.getIsLeaf().equals(other.getIsLeaf()))		
				        		&&(this.getOrderNumber() == null ? other.getId() == null : this.getOrderNumber().equals(other.getOrderNumber()))		
				        		&&(this.getRoleHomePage() == null ? other.getId() == null : this.getRoleHomePage().equals(other.getRoleHomePage()))		
				        		&&(this.getRoleHomePagePath() == null ? other.getId() == null : this.getRoleHomePagePath().equals(other.getRoleHomePagePath()))		
				        		&&(this.getRoleHomePageId() == null ? other.getId() == null : this.getRoleHomePageId().equals(other.getRoleHomePageId()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());		
		        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());		
		        result = prime * result + ((getIsLeaf() == null) ? 0 : getIsLeaf().hashCode());		
		        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());		
		        result = prime * result + ((getRoleHomePage() == null) ? 0 : getRoleHomePage().hashCode());		
		        result = prime * result + ((getRoleHomePagePath() == null) ? 0 : getRoleHomePagePath().hashCode());		
		        result = prime * result + ((getRoleHomePageId() == null) ? 0 : getRoleHomePageId().hashCode());		
		;
        return result;
    }

}
