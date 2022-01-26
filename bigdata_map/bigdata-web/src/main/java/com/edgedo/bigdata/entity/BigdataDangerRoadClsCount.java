package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_danger_road_cls_count")
public class BigdataDangerRoadClsCount implements Serializable{
	
		
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
	 * 属性描述:一类危险路段经过次数
	 */
	@TableField(value="ONE_CLS_DANGER_ROAD_NUM",exist=true)
	java.lang.Integer oneClsDangerRoadNum;
	
	/**
	 * 属性描述:二类危险路段经过次数
	 */
	@TableField(value="TWO_CLS_DANGER_ROAD_NUM",exist=true)
	java.lang.Integer twoClsDangerRoadNum;
	
	/**
	 * 属性描述:三类危险路段经过次数
	 */
	@TableField(value="THREE_CLS_DANGER_ROAD_NUM",exist=true)
	java.lang.Integer threeClsDangerRoadNum;
	
	/**
	 * 属性描述:四类危险路段经过次数
	 */
	@TableField(value="FOUR_CLS_DANGER_ROAD_NUM",exist=true)
	java.lang.Integer fourClsDangerRoadNum;
	
	/**
	 * 属性描述:统计时间
	 */
	@TableField(value="COUNT_TIME",exist=true)
	java.util.Date countTime;
	
	
	
	
	
	
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
	
	
	public java.lang.Integer getOneClsDangerRoadNum(){
		return this.oneClsDangerRoadNum;
	}
	
	public void setOneClsDangerRoadNum(java.lang.Integer oneClsDangerRoadNum){
		this.oneClsDangerRoadNum=oneClsDangerRoadNum;
	}
	
	
	public java.lang.Integer getTwoClsDangerRoadNum(){
		return this.twoClsDangerRoadNum;
	}
	
	public void setTwoClsDangerRoadNum(java.lang.Integer twoClsDangerRoadNum){
		this.twoClsDangerRoadNum=twoClsDangerRoadNum;
	}
	
	
	public java.lang.Integer getThreeClsDangerRoadNum(){
		return this.threeClsDangerRoadNum;
	}
	
	public void setThreeClsDangerRoadNum(java.lang.Integer threeClsDangerRoadNum){
		this.threeClsDangerRoadNum=threeClsDangerRoadNum;
	}
	
	
	public java.lang.Integer getFourClsDangerRoadNum(){
		return this.fourClsDangerRoadNum;
	}
	
	public void setFourClsDangerRoadNum(java.lang.Integer fourClsDangerRoadNum){
		this.fourClsDangerRoadNum=fourClsDangerRoadNum;
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
			sb.append(", oneClsDangerRoadNum=").append(oneClsDangerRoadNum);			
			sb.append(", twoClsDangerRoadNum=").append(twoClsDangerRoadNum);			
			sb.append(", threeClsDangerRoadNum=").append(threeClsDangerRoadNum);			
			sb.append(", fourClsDangerRoadNum=").append(fourClsDangerRoadNum);			
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
        BigdataDangerRoadClsCount other = (BigdataDangerRoadClsCount) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getOneClsDangerRoadNum() == null ? other.getId() == null : this.getOneClsDangerRoadNum().equals(other.getOneClsDangerRoadNum()))		
				        		&&(this.getTwoClsDangerRoadNum() == null ? other.getId() == null : this.getTwoClsDangerRoadNum().equals(other.getTwoClsDangerRoadNum()))		
				        		&&(this.getThreeClsDangerRoadNum() == null ? other.getId() == null : this.getThreeClsDangerRoadNum().equals(other.getThreeClsDangerRoadNum()))		
				        		&&(this.getFourClsDangerRoadNum() == null ? other.getId() == null : this.getFourClsDangerRoadNum().equals(other.getFourClsDangerRoadNum()))		
				        		&&(this.getCountTime() == null ? other.getId() == null : this.getCountTime().equals(other.getCountTime()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getOneClsDangerRoadNum() == null) ? 0 : getOneClsDangerRoadNum().hashCode());		
		        result = prime * result + ((getTwoClsDangerRoadNum() == null) ? 0 : getTwoClsDangerRoadNum().hashCode());		
		        result = prime * result + ((getThreeClsDangerRoadNum() == null) ? 0 : getThreeClsDangerRoadNum().hashCode());		
		        result = prime * result + ((getFourClsDangerRoadNum() == null) ? 0 : getFourClsDangerRoadNum().hashCode());		
		        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());		
		;
        return result;
    }

}
