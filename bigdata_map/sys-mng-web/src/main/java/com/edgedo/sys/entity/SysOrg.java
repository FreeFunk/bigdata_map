package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_org")
public class SysOrg implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;
	
	/**
	 * 属性描述:组织机构名
	 */
	@TableField(value="ORG_NAME",exist=true)
	String orgName;
	
	/**
	 * 属性描述:所属组织机构
	 */
	@TableField(value="PARENT_ID",exist=true)
	String parentId;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	/**
	 * 属性描述:创建人名
	 */
	@TableField(value="CREATE_USER_NAME",exist=true)
	String createUserName;
	
	/**
	 * 属性描述:创建人id
	 */
	@TableField(value="CREATE_USER_ID",exist=true)
	String createUserId;
	
	/**
	 * 属性描述:排序号
	 */
	@TableField(value="ORDER_NUMBER",exist=true)
	java.math.BigDecimal orderNumber;
	
	/**
	 * 属性描述:组织机构备注
	 */
	@TableField(value="ORG_DESC",exist=true)
	String orgDesc;

	/**
	 * 属性描述:是否是叶子
	 */
	@TableField(value="IS_LEAF",exist=true)
	String isLeaf;
	
	
	
	
	
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public String getOrgName(){
		return this.orgName;
	}
	
	public void setOrgName(String orgName){
		this.orgName=orgName;
	}
	
	
	public String getParentId(){
		return this.parentId;
	}
	
	public void setParentId(String parentId){
		this.parentId=parentId;
	}
	
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	
	public String getCreateUserName(){
		return this.createUserName;
	}
	
	public void setCreateUserName(String createUserName){
		this.createUserName=createUserName;
	}
	
	
	public String getCreateUserId(){
		return this.createUserId;
	}
	
	public void setCreateUserId(String createUserId){
		this.createUserId=createUserId;
	}
	
	
	public java.math.BigDecimal getOrderNumber(){
		return this.orderNumber;
	}
	
	public void setOrderNumber(java.math.BigDecimal orderNumber){
		this.orderNumber=orderNumber;
	}
	
	
	public String getOrgDesc(){
		return this.orgDesc;
	}
	
	public void setOrgDesc(String orgDesc){
		this.orgDesc=orgDesc;
	}

	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", orgName=").append(orgName);			
			sb.append(", parentId=").append(parentId);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", createUserName=").append(createUserName);			
			sb.append(", createUserId=").append(createUserId);			
			sb.append(", orderNumber=").append(orderNumber);			
			sb.append(", orgDesc=").append(orgDesc);			
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
        SysOrg other = (SysOrg) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getOrgName() == null ? other.getId() == null : this.getOrgName().equals(other.getOrgName()))		
				        		&&(this.getParentId() == null ? other.getId() == null : this.getParentId().equals(other.getParentId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCreateUserName() == null ? other.getId() == null : this.getCreateUserName().equals(other.getCreateUserName()))		
				        		&&(this.getCreateUserId() == null ? other.getId() == null : this.getCreateUserId().equals(other.getCreateUserId()))		
				        		&&(this.getOrderNumber() == null ? other.getId() == null : this.getOrderNumber().equals(other.getOrderNumber()))		
				        		&&(this.getOrgDesc() == null ? other.getId() == null : this.getOrgDesc().equals(other.getOrgDesc()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());		
		        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());		
		        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());		
		        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());		
		        result = prime * result + ((getOrgDesc() == null) ? 0 : getOrgDesc().hashCode());		
		;
        return result;
    }
	

}
