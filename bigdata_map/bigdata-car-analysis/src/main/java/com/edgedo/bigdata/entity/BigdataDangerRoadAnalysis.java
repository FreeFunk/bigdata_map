package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

@TableName("bigdata_danger_road_analysis")
public class BigdataDangerRoadAnalysis implements Serializable{
	
		
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
	 * 属性描述:危险路段分类
	 */
	@TableField(value="DANGER_ROAD_CLS",exist=true)
	String dangerRoadCls;

	/**
	 * 属性描述:所属危险路段ID
	 */
	@TableField(value="OWNER_DANGER_ROAD_ID",exist=true)
	String ownerDangerRoadId;

	/**
	 * 属性描述:危险路段
	 */
	@TableField(value="OWNER_DANGER_ROAD_NAME",exist=true)
	String ownerDangerRoadName;

	/**
	 * 属性描述:次数
	 */
	@TableField(value="DANGER_ROAD_NUM",exist=true)
	Integer dangerRoadNum;

	/**
	 * 属性描述:统计时间
	 */
	@TableField(value="COUNT_TIME",exist=true)
	java.util.Date countTime;

	/**
	 * 属性描述:经度
	 */
	@TableField(value="LONGITUDE",exist=true)
	BigDecimal longitude;

	/**
	 * 属性描述:纬度
	 */
	@TableField(value="LATITUDE",exist=true)
	BigDecimal latitude;


	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
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


	public String getDangerRoadCls(){
		return this.dangerRoadCls;
	}

	public void setDangerRoadCls(String dangerRoadCls){
		this.dangerRoadCls=dangerRoadCls;
	}


	public String getOwnerDangerRoadId(){
		return this.ownerDangerRoadId;
	}

	public void setOwnerDangerRoadId(String ownerDangerRoadId){
		this.ownerDangerRoadId=ownerDangerRoadId;
	}


	public String getOwnerDangerRoadName(){
		return this.ownerDangerRoadName;
	}

	public void setOwnerDangerRoadName(String ownerDangerRoadName){
		this.ownerDangerRoadName=ownerDangerRoadName;
	}


	public Integer getDangerRoadNum(){
		return this.dangerRoadNum;
	}

	public void setDangerRoadNum(Integer dangerRoadNum){
		this.dangerRoadNum=dangerRoadNum;
	}
	
	
	public java.util.Date getCountTime(){
		return this.countTime;
	}
	
	public void setCountTime(java.util.Date countTime){
		this.countTime=countTime;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", dangerRoadCls=").append(dangerRoadCls);			
			sb.append(", ownerDangerRoadId=").append(ownerDangerRoadId);			
			sb.append(", ownerDangerRoadName=").append(ownerDangerRoadName);			
			sb.append(", dangerRoadNum=").append(dangerRoadNum);			
			sb.append(", countTime=").append(countTime);			
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
        BigdataDangerRoadAnalysis other = (BigdataDangerRoadAnalysis) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getDangerRoadCls() == null ? other.getId() == null : this.getDangerRoadCls().equals(other.getDangerRoadCls()))		
				        		&&(this.getOwnerDangerRoadId() == null ? other.getId() == null : this.getOwnerDangerRoadId().equals(other.getOwnerDangerRoadId()))		
				        		&&(this.getOwnerDangerRoadName() == null ? other.getId() == null : this.getOwnerDangerRoadName().equals(other.getOwnerDangerRoadName()))		
				        		&&(this.getDangerRoadNum() == null ? other.getId() == null : this.getDangerRoadNum().equals(other.getDangerRoadNum()))		
				        		&&(this.getCountTime() == null ? other.getId() == null : this.getCountTime().equals(other.getCountTime()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getDangerRoadCls() == null) ? 0 : getDangerRoadCls().hashCode());		
		        result = prime * result + ((getOwnerDangerRoadId() == null) ? 0 : getOwnerDangerRoadId().hashCode());		
		        result = prime * result + ((getOwnerDangerRoadName() == null) ? 0 : getOwnerDangerRoadName().hashCode());		
		        result = prime * result + ((getDangerRoadNum() == null) ? 0 : getDangerRoadNum().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		;
        return result;
    }

}
