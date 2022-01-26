package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_site_msg_tongyi")
public class SysSiteMsgTongyi implements Serializable{
	
		
	/**
	 * 属性描述:id
	 */
	@TableField(value="ID",exist=true)
	String id;
	
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
	 * 属性描述:sendUserId
	 */
	@TableField(value="SEND_USER_ID",exist=true)
	String sendUserId;
	
	/**
	 * 属性描述:sendUserName
	 */
	@TableField(value="SEND_USER_NAME",exist=true)
	String sendUserName;
	
	
	
	
	
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
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
	
	
	public String getSendUserId(){
		return this.sendUserId;
	}
	
	public void setSendUserId(String sendUserId){
		this.sendUserId=sendUserId;
	}
	
	
	public String getSendUserName(){
		return this.sendUserName;
	}
	
	public void setSendUserName(String sendUserName){
		this.sendUserName=sendUserName;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", title=").append(title);			
			sb.append(", content=").append(content);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", sendUserId=").append(sendUserId);			
			sb.append(", sendUserName=").append(sendUserName);			
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
        SysSiteMsgTongyi other = (SysSiteMsgTongyi) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getTitle() == null ? other.getId() == null : this.getTitle().equals(other.getTitle()))		
				        		&&(this.getContent() == null ? other.getId() == null : this.getContent().equals(other.getContent()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getSendUserId() == null ? other.getId() == null : this.getSendUserId().equals(other.getSendUserId()))		
				        		&&(this.getSendUserName() == null ? other.getId() == null : this.getSendUserName().equals(other.getSendUserName()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());		
		        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getSendUserId() == null) ? 0 : getSendUserId().hashCode());		
		        result = prime * result + ((getSendUserName() == null) ? 0 : getSendUserName().hashCode());		
		;
        return result;
    }

}
