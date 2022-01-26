package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_danger_road_cls_month")
public class BigdataDangerRoadClsMonth implements Serializable{
	
		
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
	 * 属性描述:危险路段分类
	 */
	@TableField(value="DANGER_ROAD_CLS_NAME",exist=true)
	java.lang.String dangerRoadClsName;
	
	/**
	 * 属性描述:危险路段超过次数
	 */
	@TableField(value="DANGER_ROAD_PASS_NUM",exist=true)
	java.lang.Integer dangerRoadPassNum;
	
	/**
	 * 属性描述:月份
	 */
	@TableField(value="COUNT_MONTH",exist=true)
	java.lang.Integer countMonth;
	
	/**
	 * 属性描述:年份
	 */
	@TableField(value="YEAR_NUM",exist=true)
	java.lang.Integer yearNum;
	
	/**
	 * 属性描述:经度
	 */
	@TableField(value="LONGITUDE",exist=true)
	java.math.BigDecimal longitude;
	
	/**
	 * 属性描述:纬度
	 */
	@TableField(value="LATITUDE",exist=true)
	java.math.BigDecimal latitude;
	
	
	
	
	
	
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
	
	
	public java.lang.String getDangerRoadClsName(){
		return this.dangerRoadClsName;
	}
	
	public void setDangerRoadClsName(java.lang.String dangerRoadClsName){
		this.dangerRoadClsName=dangerRoadClsName;
	}
	
	
	public java.lang.Integer getDangerRoadPassNum(){
		return this.dangerRoadPassNum;
	}
	
	public void setDangerRoadPassNum(java.lang.Integer dangerRoadPassNum){
		this.dangerRoadPassNum=dangerRoadPassNum;
	}
	
	
	public java.lang.Integer getCountMonth(){
		return this.countMonth;
	}
	
	public void setCountMonth(java.lang.Integer countMonth){
		this.countMonth=countMonth;
	}
	
	
	public java.lang.Integer getYearNum(){
		return this.yearNum;
	}
	
	public void setYearNum(java.lang.Integer yearNum){
		this.yearNum=yearNum;
	}
	
	
	public java.math.BigDecimal getLongitude(){
		return this.longitude;
	}
	
	public void setLongitude(java.math.BigDecimal longitude){
		this.longitude=longitude;
	}
	
	
	public java.math.BigDecimal getLatitude(){
		return this.latitude;
	}
	
	public void setLatitude(java.math.BigDecimal latitude){
		this.latitude=latitude;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", dangerRoadClsName=").append(dangerRoadClsName);			
			sb.append(", dangerRoadPassNum=").append(dangerRoadPassNum);			
			sb.append(", countMonth=").append(countMonth);			
			sb.append(", yearNum=").append(yearNum);			
			sb.append(", longitude=").append(longitude);			
			sb.append(", latitude=").append(latitude);			
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
        BigdataDangerRoadClsMonth other = (BigdataDangerRoadClsMonth) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getDangerRoadClsName() == null ? other.getId() == null : this.getDangerRoadClsName().equals(other.getDangerRoadClsName()))		
				        		&&(this.getDangerRoadPassNum() == null ? other.getId() == null : this.getDangerRoadPassNum().equals(other.getDangerRoadPassNum()))		
				        		&&(this.getCountMonth() == null ? other.getId() == null : this.getCountMonth().equals(other.getCountMonth()))		
				        		&&(this.getYearNum() == null ? other.getId() == null : this.getYearNum().equals(other.getYearNum()))		
				        		&&(this.getLongitude() == null ? other.getId() == null : this.getLongitude().equals(other.getLongitude()))		
				        		&&(this.getLatitude() == null ? other.getId() == null : this.getLatitude().equals(other.getLatitude()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getDangerRoadClsName() == null) ? 0 : getDangerRoadClsName().hashCode());		
		        result = prime * result + ((getDangerRoadPassNum() == null) ? 0 : getDangerRoadPassNum().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());		
		        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());		
		;
        return result;
    }

}
