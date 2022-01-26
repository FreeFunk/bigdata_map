package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_site_msg")
public class SysSiteMsg implements Serializable{

	/**
	 * 属性描述:id
	 */
	@TableField(value="ID",exist=true)
	String id;
	
	/**
	 * 属性描述:userId
	 */
	@TableField(value="USER_ID",exist=true)
	String userId;
	
	/**
	 * 属性描述:msgType
	 */
	@TableField(value="MSG_TYPE",exist=true)
	String msgType;
	
	/**
	 * 属性描述:title
	 */
	@TableField(value="TITLE",exist=true)
	String title;
	
	/**
	 * 属性描述:content
	 */
	@TableField(value="CONTENT",exist=true)
	String content;
	
	/**
	 * 属性描述:createTime
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	/**
	 * 属性描述:isRead
	 */
	@TableField(value="IS_READ",exist=true)
	String isRead;
	
	/**
	 * 属性描述:readTime
	 */
	@TableField(value="READ_TIME",exist=true)
	java.util.Date readTime;
	
	/**
	 * 属性描述:sendUserId
	 */
	@TableField(value="SEND_USER_ID",exist=true)
	String sendUserId;
	
	/**
	 * 属性描述:senUserName
	 */
	@TableField(value="SEN_USER_NAME",exist=true)
	String senUserName;
	
	/**
	 * 属性描述:dateState
	 */
	@TableField(value="DATE_STATE",exist=true)
	String dateState;
	
	/**
	 * 属性描述:ownerMsg
	 */
	@TableField(value="OWNER_MSG",exist=true)
	String ownerMsg;

	/**
	 * 属性描述:USER_NAME
	 */
	@TableField(value="USER_NAME",exist=true)
	String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * 属性描述:ownerMsg
	 */
	@TableField(value="USER_CODE",exist=true)
	String userCode;
	
	
	
	
	
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public String getUserId(){
		return this.userId;
	}
	
	public void setUserId(String userId){
		this.userId=userId;
	}
	
	
	public String getMsgType(){
		return this.msgType;
	}
	
	public void setMsgType(String msgType){
		this.msgType=msgType;
	}
	
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	
	public String getContent(){
		return this.content;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	
	public String getIsRead(){
		return this.isRead;
	}
	
	public void setIsRead(String isRead){
		this.isRead=isRead;
	}
	
	
	public java.util.Date getReadTime(){
		return this.readTime;
	}
	
	public void setReadTime(java.util.Date readTime){
		this.readTime=readTime;
	}
	
	
	public String getSendUserId(){
		return this.sendUserId;
	}
	
	public void setSendUserId(String sendUserId){
		this.sendUserId=sendUserId;
	}
	
	
	public String getSenUserName(){
		return this.senUserName;
	}
	
	public void setSenUserName(String senUserName){
		this.senUserName=senUserName;
	}
	
	
	public String getDateState(){
		return this.dateState;
	}
	
	public void setDateState(String dateState){
		this.dateState=dateState;
	}
	
	
	public String getOwnerMsg(){
		return this.ownerMsg;
	}
	
	public void setOwnerMsg(String ownerMsg){
		this.ownerMsg=ownerMsg;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", userId=").append(userId);			
			sb.append(", msgType=").append(msgType);			
			sb.append(", title=").append(title);			
			sb.append(", content=").append(content);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", isRead=").append(isRead);			
			sb.append(", readTime=").append(readTime);			
			sb.append(", sendUserId=").append(sendUserId);			
			sb.append(", senUserName=").append(senUserName);			
			sb.append(", dateState=").append(dateState);			
			sb.append(", ownerMsg=").append(ownerMsg);			
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
        SysSiteMsg other = (SysSiteMsg) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getUserId() == null ? other.getId() == null : this.getUserId().equals(other.getUserId()))		
				        		&&(this.getMsgType() == null ? other.getId() == null : this.getMsgType().equals(other.getMsgType()))		
				        		&&(this.getTitle() == null ? other.getId() == null : this.getTitle().equals(other.getTitle()))		
				        		&&(this.getContent() == null ? other.getId() == null : this.getContent().equals(other.getContent()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getIsRead() == null ? other.getId() == null : this.getIsRead().equals(other.getIsRead()))		
				        		&&(this.getReadTime() == null ? other.getId() == null : this.getReadTime().equals(other.getReadTime()))		
				        		&&(this.getSendUserId() == null ? other.getId() == null : this.getSendUserId().equals(other.getSendUserId()))		
				        		&&(this.getSenUserName() == null ? other.getId() == null : this.getSenUserName().equals(other.getSenUserName()))		
				        		&&(this.getDateState() == null ? other.getId() == null : this.getDateState().equals(other.getDateState()))		
				        		&&(this.getOwnerMsg() == null ? other.getId() == null : this.getOwnerMsg().equals(other.getOwnerMsg()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());		
		        result = prime * result + ((getMsgType() == null) ? 0 : getMsgType().hashCode());		
		        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());		
		        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getIsRead() == null) ? 0 : getIsRead().hashCode());		
		        result = prime * result + ((getReadTime() == null) ? 0 : getReadTime().hashCode());		
		        result = prime * result + ((getSendUserId() == null) ? 0 : getSendUserId().hashCode());		
		        result = prime * result + ((getSenUserName() == null) ? 0 : getSenUserName().hashCode());		
		        result = prime * result + ((getDateState() == null) ? 0 : getDateState().hashCode());		
		        result = prime * result + ((getOwnerMsg() == null) ? 0 : getOwnerMsg().hashCode());		
		;
        return result;
    }

}
