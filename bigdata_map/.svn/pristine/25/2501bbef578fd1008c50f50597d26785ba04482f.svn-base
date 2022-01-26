package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("bigdata_beidou_link_bk_rec")
public class BigdataBeidouLinkBkRec implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;

	/**
	 * 属性描述:中断开始时间
	 */
	@TableField(value="BK_START_TIME",exist=true)
	java.util.Date bkStartTime;

	/**
	 * 属性描述:中断结束时间
	 */
	@TableField(value="BK_END_TIME",exist=true)
	java.util.Date bkEndTime;

	/**
	 * 属性描述:中断时长
	 */
	@TableField(value="BK_MINUTE_NUM",exist=true)
	Integer bkMinuteNum;

	/**
	 * 属性描述:运营商id
	 */
	@TableField(value="COMP_ID",exist=true)
	String compId;

	/**
	 * 属性描述:运营商名
	 */
	@TableField(value="COMP_NAME",exist=true)
	String compName;

	/**
	 * 属性描述:统计月份
	 */
	@TableField(value="COUNT_MONTH",exist=true)
	Integer countMonth;

	/**
	 * 属性描述:年份
	 */
	@TableField(value="YEAR_NUM",exist=true)
	Integer yearNum;






	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}


	public java.util.Date getBkStartTime(){
		return this.bkStartTime;
	}

	public void setBkStartTime(java.util.Date bkStartTime){
		this.bkStartTime=bkStartTime;
	}


	public java.util.Date getBkEndTime(){
		return this.bkEndTime;
	}

	public void setBkEndTime(java.util.Date bkEndTime){
		this.bkEndTime=bkEndTime;
	}


	public Integer getBkMinuteNum(){
		return this.bkMinuteNum;
	}

	public void setBkMinuteNum(Integer bkMinuteNum){
		this.bkMinuteNum=bkMinuteNum;
	}


	public String getCompId(){
		return this.compId;
	}

	public void setCompId(String compId){
		this.compId=compId;
	}


	public String getCompName(){
		return this.compName;
	}

	public void setCompName(String compName){
		this.compName=compName;
	}


	public Integer getCountMonth(){
		return this.countMonth;
	}

	public void setCountMonth(Integer countMonth){
		this.countMonth=countMonth;
	}


	public Integer getYearNum(){
		return this.yearNum;
	}

	public void setYearNum(Integer yearNum){
		this.yearNum=yearNum;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", bkStartTime=").append(bkStartTime);			
			sb.append(", bkEndTime=").append(bkEndTime);			
			sb.append(", bkMinuteNum=").append(bkMinuteNum);			
			sb.append(", compId=").append(compId);			
			sb.append(", compName=").append(compName);			
			sb.append(", countMonth=").append(countMonth);			
			sb.append(", yearNum=").append(yearNum);			
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
        BigdataBeidouLinkBkRec other = (BigdataBeidouLinkBkRec) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getBkStartTime() == null ? other.getId() == null : this.getBkStartTime().equals(other.getBkStartTime()))		
				        		&&(this.getBkEndTime() == null ? other.getId() == null : this.getBkEndTime().equals(other.getBkEndTime()))		
				        		&&(this.getBkMinuteNum() == null ? other.getId() == null : this.getBkMinuteNum().equals(other.getBkMinuteNum()))		
				        		&&(this.getCompId() == null ? other.getId() == null : this.getCompId().equals(other.getCompId()))		
				        		&&(this.getCompName() == null ? other.getId() == null : this.getCompName().equals(other.getCompName()))		
				        		&&(this.getCountMonth() == null ? other.getId() == null : this.getCountMonth().equals(other.getCountMonth()))		
				        		&&(this.getYearNum() == null ? other.getId() == null : this.getYearNum().equals(other.getYearNum()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getBkStartTime() == null) ? 0 : getBkStartTime().hashCode());		
		        result = prime * result + ((getBkEndTime() == null) ? 0 : getBkEndTime().hashCode());		
		        result = prime * result + ((getBkMinuteNum() == null) ? 0 : getBkMinuteNum().hashCode());		
		        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());		
		        result = prime * result + ((getCompName() == null) ? 0 : getCompName().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
