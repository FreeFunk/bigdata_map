package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_wx_user")
public class SysWxUser implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;
	
	/**
	 * 属性描述:原始id
	 */
	@TableField(value="ORA_ID",exist=true)
	String oraId;
	
	/**
	 * 属性描述:微信OPENID
	 */
	@TableField(value="OPEN_ID",exist=true)
	String openId;
	
	/**
	 * 属性描述:微信昵称
	 */
	@TableField(value="NICK_NAME",exist=true)
	String nickName;
	
	/**
	 * 属性描述:头像地址
	 */
	@TableField(value="HEAD_PHOTO",exist=true)
	String headPhoto;
	
	/**
	 * 属性描述:性别
	 */
	@TableField(value="GENDER",exist=true)
	String gender;
	
	/**
	 * 属性描述:城市
	 */
	@TableField(value="CITY",exist=true)
	String city;
	
	/**
	 * 属性描述:省份
	 */
	@TableField(value="PROVINCE",exist=true)
	String province;
	
	/**
	 * 属性描述:国家
	 */
	@TableField(value="COUNTRY",exist=true)
	String country;
	
	/**
	 * 属性描述:语言
	 */
	@TableField(value="LANGUAGE",exist=true)
	String language;
	
	/**
	 * 属性描述:上次登录时间
	 */
	@TableField(value="LAST_LOGIN_TIME",exist=true)
	java.util.Date lastLoginTime;
	
	/**
	 * 属性描述:上次登录SESSION_KEY
	 */
	@TableField(value="LAST_SESSION_KEY",exist=true)
	String lastSessionKey;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	/**
	 * 属性描述:业务用户id
	 */
	@TableField(value="YW_USER_ID",exist=true)
	String ywUserId;
	
	
	
	
	
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public String getOraId(){
		return this.oraId;
	}
	
	public void setOraId(String oraId){
		this.oraId=oraId;
	}
	
	
	public String getOpenId(){
		return this.openId;
	}
	
	public void setOpenId(String openId){
		this.openId=openId;
	}
	
	
	public String getNickName(){
		return this.nickName;
	}
	
	public void setNickName(String nickName){
		this.nickName=nickName;
	}
	
	
	public String getHeadPhoto(){
		return this.headPhoto;
	}
	
	public void setHeadPhoto(String headPhoto){
		this.headPhoto=headPhoto;
	}
	
	
	public String getGender(){
		return this.gender;
	}
	
	public void setGender(String gender){
		this.gender=gender;
	}
	
	
	public String getCity(){
		return this.city;
	}
	
	public void setCity(String city){
		this.city=city;
	}
	
	
	public String getProvince(){
		return this.province;
	}
	
	public void setProvince(String province){
		this.province=province;
	}
	
	
	public String getCountry(){
		return this.country;
	}
	
	public void setCountry(String country){
		this.country=country;
	}
	
	
	public String getLanguage(){
		return this.language;
	}
	
	public void setLanguage(String language){
		this.language=language;
	}
	
	
	public java.util.Date getLastLoginTime(){
		return this.lastLoginTime;
	}
	
	public void setLastLoginTime(java.util.Date lastLoginTime){
		this.lastLoginTime=lastLoginTime;
	}
	
	
	public String getLastSessionKey(){
		return this.lastSessionKey;
	}
	
	public void setLastSessionKey(String lastSessionKey){
		this.lastSessionKey=lastSessionKey;
	}
	
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	
	public String getYwUserId(){
		return this.ywUserId;
	}
	
	public void setYwUserId(String ywUserId){
		this.ywUserId=ywUserId;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", oraId=").append(oraId);			
			sb.append(", openId=").append(openId);			
			sb.append(", nickName=").append(nickName);			
			sb.append(", headPhoto=").append(headPhoto);			
			sb.append(", gender=").append(gender);			
			sb.append(", city=").append(city);			
			sb.append(", province=").append(province);			
			sb.append(", country=").append(country);			
			sb.append(", language=").append(language);			
			sb.append(", lastLoginTime=").append(lastLoginTime);			
			sb.append(", lastSessionKey=").append(lastSessionKey);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", ywUserId=").append(ywUserId);			
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
        SysWxUser other = (SysWxUser) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getOraId() == null ? other.getId() == null : this.getOraId().equals(other.getOraId()))		
				        		&&(this.getOpenId() == null ? other.getId() == null : this.getOpenId().equals(other.getOpenId()))		
				        		&&(this.getNickName() == null ? other.getId() == null : this.getNickName().equals(other.getNickName()))		
				        		&&(this.getHeadPhoto() == null ? other.getId() == null : this.getHeadPhoto().equals(other.getHeadPhoto()))		
				        		&&(this.getGender() == null ? other.getId() == null : this.getGender().equals(other.getGender()))		
				        		&&(this.getCity() == null ? other.getId() == null : this.getCity().equals(other.getCity()))		
				        		&&(this.getProvince() == null ? other.getId() == null : this.getProvince().equals(other.getProvince()))		
				        		&&(this.getCountry() == null ? other.getId() == null : this.getCountry().equals(other.getCountry()))		
				        		&&(this.getLanguage() == null ? other.getId() == null : this.getLanguage().equals(other.getLanguage()))		
				        		&&(this.getLastLoginTime() == null ? other.getId() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))		
				        		&&(this.getLastSessionKey() == null ? other.getId() == null : this.getLastSessionKey().equals(other.getLastSessionKey()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getYwUserId() == null ? other.getId() == null : this.getYwUserId().equals(other.getYwUserId()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getOraId() == null) ? 0 : getOraId().hashCode());		
		        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());		
		        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());		
		        result = prime * result + ((getHeadPhoto() == null) ? 0 : getHeadPhoto().hashCode());		
		        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());		
		        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());		
		        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());		
		        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());		
		        result = prime * result + ((getLanguage() == null) ? 0 : getLanguage().hashCode());		
		        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());		
		        result = prime * result + ((getLastSessionKey() == null) ? 0 : getLastSessionKey().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getYwUserId() == null) ? 0 : getYwUserId().hashCode());		
		;
        return result;
    }

}
