package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_beidou_check_standard")
public class BigdataBeidouCheckStandard implements Serializable{
	
		
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
	 * 属性描述:指标名称
	 */
	@TableField(value="STANDARD_NAME",exist=true)
	java.lang.String standardName;
	
	/**
	 * 属性描述:指标方向
	 */
	@TableField(value="STANDARD_DIRECTION",exist=true)
	java.lang.String standardDirection;
	
	/**
	 * 属性描述:扣分数值
	 */
	@TableField(value="SCORE_LINE",exist=true)
	java.math.BigDecimal scoreLine;
	
	/**
	 * 属性描述:不得分数值
	 */
	@TableField(value="UNSCORE_LINE",exist=true)
	java.math.BigDecimal unscoreLine;
	
	/**
	 * 属性描述:分数
	 */
	@TableField(value="SCORE_NUM",exist=true)
	java.math.BigDecimal scoreNum;
	
	/**
	 * 属性描述:得分说明
	 */
	@TableField(value="STANDARD_DESC",exist=true)
	java.lang.String standardDesc;
	
	/**
	 * 属性描述:标准状态
	 */
	@TableField(value="STANDARD_STATE",exist=true)
	java.lang.String standardState;
	
	/**
	 * 属性描述:动态处理类
	 */
	@TableField(value="DEAL_CLASS_NAME",exist=true)
	java.lang.String dealClassName;
	
	
	
	
	
	
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
	
	
	public java.lang.String getStandardName(){
		return this.standardName;
	}
	
	public void setStandardName(java.lang.String standardName){
		this.standardName=standardName;
	}
	
	
	public java.lang.String getStandardDirection(){
		return this.standardDirection;
	}
	
	public void setStandardDirection(java.lang.String standardDirection){
		this.standardDirection=standardDirection;
	}
	
	
	public java.math.BigDecimal getScoreLine(){
		return this.scoreLine;
	}
	
	public void setScoreLine(java.math.BigDecimal scoreLine){
		this.scoreLine=scoreLine;
	}
	
	
	public java.math.BigDecimal getUnscoreLine(){
		return this.unscoreLine;
	}
	
	public void setUnscoreLine(java.math.BigDecimal unscoreLine){
		this.unscoreLine=unscoreLine;
	}
	
	
	public java.math.BigDecimal getScoreNum(){
		return this.scoreNum;
	}
	
	public void setScoreNum(java.math.BigDecimal scoreNum){
		this.scoreNum=scoreNum;
	}
	
	
	public java.lang.String getStandardDesc(){
		return this.standardDesc;
	}
	
	public void setStandardDesc(java.lang.String standardDesc){
		this.standardDesc=standardDesc;
	}
	
	
	public java.lang.String getStandardState(){
		return this.standardState;
	}
	
	public void setStandardState(java.lang.String standardState){
		this.standardState=standardState;
	}
	
	
	public java.lang.String getDealClassName(){
		return this.dealClassName;
	}
	
	public void setDealClassName(java.lang.String dealClassName){
		this.dealClassName=dealClassName;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", standardName=").append(standardName);			
			sb.append(", standardDirection=").append(standardDirection);			
			sb.append(", scoreLine=").append(scoreLine);			
			sb.append(", unscoreLine=").append(unscoreLine);			
			sb.append(", scoreNum=").append(scoreNum);			
			sb.append(", standardDesc=").append(standardDesc);			
			sb.append(", standardState=").append(standardState);			
			sb.append(", dealClassName=").append(dealClassName);			
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
        BigdataBeidouCheckStandard other = (BigdataBeidouCheckStandard) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getStandardName() == null ? other.getId() == null : this.getStandardName().equals(other.getStandardName()))		
				        		&&(this.getStandardDirection() == null ? other.getId() == null : this.getStandardDirection().equals(other.getStandardDirection()))		
				        		&&(this.getScoreLine() == null ? other.getId() == null : this.getScoreLine().equals(other.getScoreLine()))		
				        		&&(this.getUnscoreLine() == null ? other.getId() == null : this.getUnscoreLine().equals(other.getUnscoreLine()))		
				        		&&(this.getScoreNum() == null ? other.getId() == null : this.getScoreNum().equals(other.getScoreNum()))		
				        		&&(this.getStandardDesc() == null ? other.getId() == null : this.getStandardDesc().equals(other.getStandardDesc()))		
				        		&&(this.getStandardState() == null ? other.getId() == null : this.getStandardState().equals(other.getStandardState()))		
				        		&&(this.getDealClassName() == null ? other.getId() == null : this.getDealClassName().equals(other.getDealClassName()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getStandardName() == null) ? 0 : getStandardName().hashCode());		
		        result = prime * result + ((getStandardDirection() == null) ? 0 : getStandardDirection().hashCode());		
		        result = prime * result + ((getScoreLine() == null) ? 0 : getScoreLine().hashCode());		
		        result = prime * result + ((getUnscoreLine() == null) ? 0 : getUnscoreLine().hashCode());		
		        result = prime * result + ((getScoreNum() == null) ? 0 : getScoreNum().hashCode());		
		        result = prime * result + ((getStandardDesc() == null) ? 0 : getStandardDesc().hashCode());		
		        result = prime * result + ((getStandardState() == null) ? 0 : getStandardState().hashCode());		
		        result = prime * result + ((getDealClassName() == null) ? 0 : getDealClassName().hashCode());		
		;
        return result;
    }

}
