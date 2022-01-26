package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("yw_train_lession")
public class YwTrainLession implements Serializable{
	
		
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
	 * 属性描述:创建人id
	 */
	@TableField(value="CREATE_USER_ID",exist=true)
	String createUserId;

	/**
	 * 属性描述:创建人名
	 */
	@TableField(value="CREATE_USER_NAME",exist=true)
	String createUserName;

	/**
	 * 属性描述:课程标题
	 */
	@TableField(value="LESSON_TITLE",exist=true)
	String lessonTitle;

	/**
	 * 属性描述:课程所属分类
	 */
	@TableField(value="OWNER_CLS_ID",exist=true)
	String ownerClsId;

	/**
	 * 属性描述:课程类型
	 */
	@TableField(value="LESSION_TYPE",exist=true)
	String lessionType;

	/**
	 * 属性描述:课程详情数
	 */
	@TableField(value="DETAIL_NUM",exist=true)
	Integer detailNum;

	/**
	 * 属性描述:是否自定义课程
	 */
	@TableField(value="IS_SELF",exist=true)
	String isSelf;

	/**
	 * 属性描述:课程附件
	 */
	@TableField(value="LESSION_FILE",exist=true)
	String lessionFile;

	/**
	 * 属性描述:审核时间
	 */
	@TableField(value="SH_TIME",exist=true)
	String shTime;

	/**
	 * 属性描述:审核人ID
	 */
	@TableField(value="SH_USER_ID",exist=true)
	String shUserId;

	/**
	 * 属性描述:审核人名
	 */
	@TableField(value="SH_USER_NAME",exist=true)
	String shUserName;

	/**
	 * 属性描述:课程状态
	 */
	@TableField(value="LESSION_STATE",exist=true)
	String lessionState;

	/**
	 * 属性描述:课程时长(分)
	 */
	@TableField(value="LESSION_MINITE_NUM",exist=true)
	Integer lessionMiniteNum;

	/**
	 * 属性描述:学习次数
	 */
	@TableField(value="STUDY_TIMES",exist=true)
	Integer studyTimes;

	/**
	 * 属性描述:企业id
	 */
	@TableField(value="COMP_ID",exist=true)
	String compId;

	/**
	 * 属性描述:应用id
	 */
	@TableField(value="APP_ID",exist=true)
	String appId;
	/**
	 * 属性描述:课程展示封面
	 */
	@TableField(value="COVER_IMG",exist=true)
	String coverImg;
	@TableField(value="LESSION_DESC",exist=true)
	String lessionDesc;




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


	public String getCreateUserId(){
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId){
		this.createUserId=createUserId;
	}


	public String getCreateUserName(){
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName){
		this.createUserName=createUserName;
	}


	public String getLessonTitle(){
		return this.lessonTitle;
	}

	public void setLessonTitle(String lessonTitle){
		this.lessonTitle=lessonTitle;
	}


	public String getOwnerClsId(){
		return this.ownerClsId;
	}

	public void setOwnerClsId(String ownerClsId){
		this.ownerClsId=ownerClsId;
	}


	public String getLessionType(){
		return this.lessionType;
	}

	public void setLessionType(String lessionType){
		this.lessionType=lessionType;
	}


	public Integer getDetailNum(){
		return this.detailNum;
	}

	public void setDetailNum(Integer detailNum){
		this.detailNum=detailNum;
	}


	public String getIsSelf(){
		return this.isSelf;
	}

	public void setIsSelf(String isSelf){
		this.isSelf=isSelf;
	}


	public String getLessionFile(){
		return this.lessionFile;
	}

	public void setLessionFile(String lessionFile){
		this.lessionFile=lessionFile;
	}


	public String getShTime(){
		return this.shTime;
	}

	public void setShTime(String shTime){
		this.shTime=shTime;
	}


	public String getShUserId(){
		return this.shUserId;
	}

	public void setShUserId(String shUserId){
		this.shUserId=shUserId;
	}


	public String getShUserName(){
		return this.shUserName;
	}

	public void setShUserName(String shUserName){
		this.shUserName=shUserName;
	}


	public String getLessionState(){
		return this.lessionState;
	}

	public void setLessionState(String lessionState){
		this.lessionState=lessionState;
	}


	public Integer getLessionMiniteNum(){
		return this.lessionMiniteNum;
	}

	public void setLessionMiniteNum(Integer lessionMiniteNum){
		this.lessionMiniteNum=lessionMiniteNum;
	}


	public Integer getStudyTimes(){
		return this.studyTimes;
	}

	public void setStudyTimes(Integer studyTimes){
		this.studyTimes=studyTimes;
	}


	public String getCompId(){
		return this.compId;
	}

	public void setCompId(String compId){
		this.compId=compId;
	}


	public String getAppId(){
		return this.appId;
	}

	public void setAppId(String appId){
		this.appId=appId;
	}

	public String getCoverImg(){
		return this.coverImg;
	}

	public void setCoverImg(String coverImg){
		this.coverImg=coverImg;
	}

	public String getLessionDesc(){
		return this.lessionDesc;
	}

	public void setLessionDesc(String lessionDesc){
		this.lessionDesc=lessionDesc;
	}
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", createUserId=").append(createUserId);			
			sb.append(", createUserName=").append(createUserName);			
			sb.append(", lessonTitle=").append(lessonTitle);			
			sb.append(", ownerClsId=").append(ownerClsId);			
			sb.append(", lessionType=").append(lessionType);			
			sb.append(", detailNum=").append(detailNum);			
			sb.append(", isSelf=").append(isSelf);			
			sb.append(", lessionFile=").append(lessionFile);			
			sb.append(", shTime=").append(shTime);			
			sb.append(", shUserId=").append(shUserId);			
			sb.append(", shUserName=").append(shUserName);			
			sb.append(", lessionState=").append(lessionState);			
			sb.append(", lessionMiniteNum=").append(lessionMiniteNum);			
			sb.append(", studyTimes=").append(studyTimes);			
			sb.append(", compId=").append(compId);			
			sb.append(", appId=").append(appId);
			sb.append(", coverImg=").append(coverImg);
			sb.append(", lessionDesc=").append(lessionDesc);
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
        YwTrainLession other = (YwTrainLession) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCreateUserId() == null ? other.getId() == null : this.getCreateUserId().equals(other.getCreateUserId()))		
				        		&&(this.getCreateUserName() == null ? other.getId() == null : this.getCreateUserName().equals(other.getCreateUserName()))		
				        		&&(this.getLessonTitle() == null ? other.getId() == null : this.getLessonTitle().equals(other.getLessonTitle()))		
				        		&&(this.getOwnerClsId() == null ? other.getId() == null : this.getOwnerClsId().equals(other.getOwnerClsId()))		
				        		&&(this.getLessionType() == null ? other.getId() == null : this.getLessionType().equals(other.getLessionType()))		
				        		&&(this.getDetailNum() == null ? other.getId() == null : this.getDetailNum().equals(other.getDetailNum()))		
				        		&&(this.getIsSelf() == null ? other.getId() == null : this.getIsSelf().equals(other.getIsSelf()))		
				        		&&(this.getLessionFile() == null ? other.getId() == null : this.getLessionFile().equals(other.getLessionFile()))		
				        		&&(this.getShTime() == null ? other.getId() == null : this.getShTime().equals(other.getShTime()))		
				        		&&(this.getShUserId() == null ? other.getId() == null : this.getShUserId().equals(other.getShUserId()))		
				        		&&(this.getShUserName() == null ? other.getId() == null : this.getShUserName().equals(other.getShUserName()))		
				        		&&(this.getLessionState() == null ? other.getId() == null : this.getLessionState().equals(other.getLessionState()))		
				        		&&(this.getLessionMiniteNum() == null ? other.getId() == null : this.getLessionMiniteNum().equals(other.getLessionMiniteNum()))		
				        		&&(this.getStudyTimes() == null ? other.getId() == null : this.getStudyTimes().equals(other.getStudyTimes()))		
				        		&&(this.getCompId() == null ? other.getId() == null : this.getCompId().equals(other.getCompId()))		
				        		&&(this.getAppId() == null ? other.getId() == null : this.getAppId().equals(other.getAppId()))
								&&(this.getCoverImg() == null ? other.getId() == null : this.getCoverImg().equals(other.getCoverImg()))
								&&(this.getLessionDesc() == null ? other.getId() == null : this.getLessionDesc().equals(other.getLessionDesc()))
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());		
		        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());		
		        result = prime * result + ((getLessonTitle() == null) ? 0 : getLessonTitle().hashCode());		
		        result = prime * result + ((getOwnerClsId() == null) ? 0 : getOwnerClsId().hashCode());		
		        result = prime * result + ((getLessionType() == null) ? 0 : getLessionType().hashCode());		
		        result = prime * result + ((getDetailNum() == null) ? 0 : getDetailNum().hashCode());		
		        result = prime * result + ((getIsSelf() == null) ? 0 : getIsSelf().hashCode());		
		        result = prime * result + ((getLessionFile() == null) ? 0 : getLessionFile().hashCode());		
		        result = prime * result + ((getShTime() == null) ? 0 : getShTime().hashCode());		
		        result = prime * result + ((getShUserId() == null) ? 0 : getShUserId().hashCode());		
		        result = prime * result + ((getShUserName() == null) ? 0 : getShUserName().hashCode());		
		        result = prime * result + ((getLessionState() == null) ? 0 : getLessionState().hashCode());		
		        result = prime * result + ((getLessionMiniteNum() == null) ? 0 : getLessionMiniteNum().hashCode());		
		        result = prime * result + ((getStudyTimes() == null) ? 0 : getStudyTimes().hashCode());		
		        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());		
		        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());		
		        result = prime * result + ((getCoverImg() == null) ? 0 : getCoverImg().hashCode());
		        result = prime * result + ((getLessionDesc() == null) ? 0 : getLessionDesc().hashCode());
		;
        return result;
    }
	

}
