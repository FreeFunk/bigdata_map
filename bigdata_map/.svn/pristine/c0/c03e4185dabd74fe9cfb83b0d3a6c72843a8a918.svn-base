package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_config_line")
public class BigdataConfigLine implements Serializable{
	
		
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
	 * 属性描述:名字
	 */
	@TableField(value="LINE_NAME",exist=true)
	java.lang.String lineName;
	
	/**
	 * 属性描述:KEY
	 */
	@TableField(value="LINE_KEY",exist=true)
	java.lang.String lineKey;
	
	/**
	 * 属性描述:VALUE
	 */
	@TableField(value="LINE_VALUE",exist=true)
	java.lang.String lineValue;
	
	/**
	 * 属性描述:备注
	 */
	@TableField(value="REMARK",exist=true)
	java.lang.String remark;
	
	
	
	
	
	
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
	
	
	public java.lang.String getLineName(){
		return this.lineName;
	}
	
	public void setLineName(java.lang.String lineName){
		this.lineName=lineName;
	}
	
	
	public java.lang.String getLineKey(){
		return this.lineKey;
	}
	
	public void setLineKey(java.lang.String lineKey){
		this.lineKey=lineKey;
	}
	
	
	public java.lang.String getLineValue(){
		return this.lineValue;
	}
	
	public void setLineValue(java.lang.String lineValue){
		this.lineValue=lineValue;
	}
	
	
	public java.lang.String getRemark(){
		return this.remark;
	}
	
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", lineName=").append(lineName);			
			sb.append(", lineKey=").append(lineKey);			
			sb.append(", lineValue=").append(lineValue);			
			sb.append(", remark=").append(remark);			
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
        BigdataConfigLine other = (BigdataConfigLine) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getLineName() == null ? other.getId() == null : this.getLineName().equals(other.getLineName()))		
				        		&&(this.getLineKey() == null ? other.getId() == null : this.getLineKey().equals(other.getLineKey()))		
				        		&&(this.getLineValue() == null ? other.getId() == null : this.getLineValue().equals(other.getLineValue()))		
				        		&&(this.getRemark() == null ? other.getId() == null : this.getRemark().equals(other.getRemark()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getLineName() == null) ? 0 : getLineName().hashCode());		
		        result = prime * result + ((getLineKey() == null) ? 0 : getLineKey().hashCode());		
		        result = prime * result + ((getLineValue() == null) ? 0 : getLineValue().hashCode());		
		        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());		
		;
        return result;
    }

}
