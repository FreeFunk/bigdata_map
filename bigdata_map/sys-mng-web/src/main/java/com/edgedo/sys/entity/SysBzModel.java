package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@TableName("sys_bz_model")
public class SysBzModel implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:模块名
	 */
	@TableField(value="MODEL_NAME",exist=true)
	java.lang.String modelName;
	
	/**
	 * 属性描述:父模块id
	 */
	@TableField(value="PARENT_ID",exist=true)
	java.lang.String parentId;
	
	/**
	 * 属性描述:是否是叶子
	 */
	@TableField(value="IS_LEAF",exist=true)
	java.lang.String isLeaf;
	
	/**
	 * 属性描述:排序号
	 */
	@TableField(value="SORT_NUM",exist=true)
	java.math.BigDecimal sortNum;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	
	
	
	
	
	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.lang.String getModelName(){
		return this.modelName;
	}
	
	public void setModelName(java.lang.String modelName){
		this.modelName=modelName;
	}
	
	
	public java.lang.String getParentId(){
		return this.parentId;
	}
	
	public void setParentId(java.lang.String parentId){
		this.parentId=parentId;
	}
	
	
	public java.lang.String getIsLeaf(){
		return this.isLeaf;
	}
	
	public void setIsLeaf(java.lang.String isLeaf){
		this.isLeaf=isLeaf;
	}
	
	
	public java.math.BigDecimal getSortNum(){
		return this.sortNum;
	}
	
	public void setSortNum(java.math.BigDecimal sortNum){
		this.sortNum=sortNum;
	}
	
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", modelName=").append(modelName);			
			sb.append(", parentId=").append(parentId);			
			sb.append(", isLeaf=").append(isLeaf);			
			sb.append(", sortNum=").append(sortNum);			
			sb.append(", createTime=").append(createTime);			
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
        SysBzModel other = (SysBzModel) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getModelName() == null ? other.getId() == null : this.getModelName().equals(other.getModelName()))		
				        		&&(this.getParentId() == null ? other.getId() == null : this.getParentId().equals(other.getParentId()))		
				        		&&(this.getIsLeaf() == null ? other.getId() == null : this.getIsLeaf().equals(other.getIsLeaf()))		
				        		&&(this.getSortNum() == null ? other.getId() == null : this.getSortNum().equals(other.getSortNum()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());		
		        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());		
		        result = prime * result + ((getIsLeaf() == null) ? 0 : getIsLeaf().hashCode());		
		        result = prime * result + ((getSortNum() == null) ? 0 : getSortNum().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		;
        return result;
    }

}
