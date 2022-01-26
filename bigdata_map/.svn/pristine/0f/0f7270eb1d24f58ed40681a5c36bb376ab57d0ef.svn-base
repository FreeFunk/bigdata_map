package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("bigdata_push_learn_rec")
public class BigdataPushLearnRec implements Serializable{
	
		
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
	 * 属性描述:更新时间
	 */
	@TableField(value="UPDATE_TIME",exist=true)
	java.util.Date updateTime;

	/**
	 * 属性描述:从业人员ID
	 */
	@TableField(value="EMP_ID",exist=true)
	String empId;

	/**
	 * 属性描述:资格证号
	 */
	@TableField(value="EMP_CODE",exist=true)
	String empCode;

	/**
	 * 属性描述:违章类型
	 */
	@TableField(value="ALARM_TYPE",exist=true)
	String alarmType;

	/**
	 * 属性描述:课件ID
	 */
	@TableField(value="LESSION_ID",exist=true)
	String lessionId;

	/**
	 * 属性描述:课件名称
	 */
	@TableField(value="LESSON_NAME",exist=true)
	String lessonName;

	/**
	 * 属性描述:学习状态
	 */
	@TableField(value="STUDY_STATE",exist=true)
	String studyState;

	/**
	 * 属性描述:统计日期
	 */
	@TableField(value="COUNT_DATE",exist=true)
	Integer countDate;

	/**
	 * 属性描述:统计月份
	 */
	@TableField(value="COUNT_MONTH",exist=true)
	Integer countMonth;

	/**
	 * 属性描述:统计年份
	 */
	@TableField(value="YEAR_NUM",exist=true)
	Integer yearNum;


	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
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


	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime=updateTime;
	}


	public String getEmpId(){
		return this.empId;
	}

	public void setEmpId(String empId){
		this.empId=empId;
	}


	public String getAlarmType(){
		return this.alarmType;
	}

	public void setAlarmType(String alarmType){
		this.alarmType=alarmType;
	}


	public String getLessionId(){
		return this.lessionId;
	}

	public void setLessionId(String lessionId){
		this.lessionId=lessionId;
	}


	public String getLessonName(){
		return this.lessonName;
	}

	public void setLessonName(String lessonName){
		this.lessonName=lessonName;
	}


	public String getStudyState(){
		return this.studyState;
	}

	public void setStudyState(String studyState){
		this.studyState=studyState;
	}


	public Integer getCountDate(){
		return this.countDate;
	}

	public void setCountDate(Integer countDate){
		this.countDate=countDate;
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
			sb.append(", createTime=").append(createTime);			
			sb.append(", updateTime=").append(updateTime);			
			sb.append(", empId=").append(empId);			
			sb.append(", alarmType=").append(alarmType);			
			sb.append(", lessionId=").append(lessionId);			
			sb.append(", lessonName=").append(lessonName);			
			sb.append(", studyState=").append(studyState);			
			sb.append(", countDate=").append(countDate);			
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
        BigdataPushLearnRec other = (BigdataPushLearnRec) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getEmpId() == null ? other.getId() == null : this.getEmpId().equals(other.getEmpId()))		
				        		&&(this.getAlarmType() == null ? other.getId() == null : this.getAlarmType().equals(other.getAlarmType()))		
				        		&&(this.getLessionId() == null ? other.getId() == null : this.getLessionId().equals(other.getLessionId()))		
				        		&&(this.getLessonName() == null ? other.getId() == null : this.getLessonName().equals(other.getLessonName()))		
				        		&&(this.getStudyState() == null ? other.getId() == null : this.getStudyState().equals(other.getStudyState()))		
				        		&&(this.getCountDate() == null ? other.getId() == null : this.getCountDate().equals(other.getCountDate()))		
				        		&&(this.getCountMonth() == null ? other.getId() == null : this.getCountMonth().equals(other.getCountMonth()))		
				        		&&(this.getYearNum() == null ? other.getId() == null : this.getYearNum().equals(other.getYearNum()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());		
		        result = prime * result + ((getEmpId() == null) ? 0 : getEmpId().hashCode());		
		        result = prime * result + ((getAlarmType() == null) ? 0 : getAlarmType().hashCode());		
		        result = prime * result + ((getLessionId() == null) ? 0 : getLessionId().hashCode());		
		        result = prime * result + ((getLessonName() == null) ? 0 : getLessonName().hashCode());		
		        result = prime * result + ((getStudyState() == null) ? 0 : getStudyState().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
