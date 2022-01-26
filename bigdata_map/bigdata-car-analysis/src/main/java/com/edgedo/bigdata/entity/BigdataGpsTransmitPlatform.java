package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("bigdata_gps_transmit_platform")
public class BigdataGpsTransmitPlatform implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;

	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;

	/**
	 * 属性描述:平台名称
	 */
	@TableField(value="PLAT_NAME",exist=true)
	String platName;

	/**
	 * 属性描述:描述
	 */
	@TableField(value="PLAT_DESC",exist=true)
	String platDesc;

	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	String dataState;
	/**
	 * 属性描述:是否有更新
	 */
	@TableField(value="IS_UPDATE",exist=true)
	String isUpdate;


	public String getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}


	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}


	public String getPlatName(){
		return this.platName;
	}

	public void setPlatName(String platName){
		this.platName=platName;
	}


	public String getPlatDesc(){
		return this.platDesc;
	}

	public void setPlatDesc(String platDesc){
		this.platDesc=platDesc;
	}


	public String getDataState(){
		return this.dataState;
	}

	public void setDataState(String dataState){
		this.dataState=dataState;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", platName=").append(platName);			
			sb.append(", platDesc=").append(platDesc);			
			sb.append(", dataState=").append(dataState);			
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
        BigdataGpsTransmitPlatform other = (BigdataGpsTransmitPlatform) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getPlatName() == null ? other.getId() == null : this.getPlatName().equals(other.getPlatName()))		
				        		&&(this.getPlatDesc() == null ? other.getId() == null : this.getPlatDesc().equals(other.getPlatDesc()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getPlatName() == null) ? 0 : getPlatName().hashCode());		
		        result = prime * result + ((getPlatDesc() == null) ? 0 : getPlatDesc().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
