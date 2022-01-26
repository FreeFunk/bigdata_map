package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_wx_config")
public class SysWxConfig implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;
	
	/**
	 * 属性描述:微信账号
	 */
	@TableField(value="WEIXIN_CODE",exist=true)
	String weixinCode;
	
	/**
	 * 属性描述:昵称
	 */
	@TableField(value="NICK_NAME",exist=true)
	String nickName;
	
	/**
	 * 属性描述:订阅号或者服务号
	 */
	@TableField(value="MP_TYPE",exist=true)
	String mpType;
	
	/**
	 * 属性描述:描述
	 */
	@TableField(value="REMARK",exist=true)
	String remark;
	
	/**
	 * 属性描述:邮箱地址
	 */
	@TableField(value="EMAIL",exist=true)
	String email;
	
	/**
	 * 属性描述:应用id
	 */
	@TableField(value="APP_ID",exist=true)
	String appId;
	
	/**
	 * 属性描述:应用秘钥
	 */
	@TableField(value="APP_SECRET",exist=true)
	String appSecret;
	
	/**
	 * 属性描述:令牌
	 */
	@TableField(value="TOKEN",exist=true)
	String token;
	
	/**
	 * 属性描述:消息加密钥匙
	 */
	@TableField(value="ENCODING_AES_KEY",exist=true)
	String encodingAesKey;
	
	/**
	 * 属性描述:服务器地址
	 */
	@TableField(value="URL",exist=true)
	String url;
	
	/**
	 * 属性描述:消息加密方式
	 */
	@TableField(value="SECRET_TYPE",exist=true)
	String secretType;
	
	/**
	 * 属性描述:微信token
	 */
	@TableField(value="ACCESS_TOKEN",exist=true)
	String accessToken;
	
	/**
	 * 属性描述:微信TICKET
	 */
	@TableField(value="TICKET",exist=true)
	String ticket;
	
	/**
	 * 属性描述:操作时间
	 */
	@TableField(value="OPERATE_TIME",exist=true)
	java.util.Date operateTime;
	
	/**
	 * 属性描述:微信ip地址
	 */
	@TableField(value="WX_IP",exist=true)
	String wxIp;
	
	
	
	
	
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public String getWeixinCode(){
		return this.weixinCode;
	}
	
	public void setWeixinCode(String weixinCode){
		this.weixinCode=weixinCode;
	}
	
	
	public String getNickName(){
		return this.nickName;
	}
	
	public void setNickName(String nickName){
		this.nickName=nickName;
	}
	
	
	public String getMpType(){
		return this.mpType;
	}
	
	public void setMpType(String mpType){
		this.mpType=mpType;
	}
	
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark=remark;
	}
	
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	
	public String getAppId(){
		return this.appId;
	}
	
	public void setAppId(String appId){
		this.appId=appId;
	}
	
	
	public String getAppSecret(){
		return this.appSecret;
	}
	
	public void setAppSecret(String appSecret){
		this.appSecret=appSecret;
	}
	
	
	public String getToken(){
		return this.token;
	}
	
	public void setToken(String token){
		this.token=token;
	}
	
	
	public String getEncodingAesKey(){
		return this.encodingAesKey;
	}
	
	public void setEncodingAesKey(String encodingAesKey){
		this.encodingAesKey=encodingAesKey;
	}
	
	
	public String getUrl(){
		return this.url;
	}
	
	public void setUrl(String url){
		this.url=url;
	}
	
	
	public String getSecretType(){
		return this.secretType;
	}
	
	public void setSecretType(String secretType){
		this.secretType=secretType;
	}
	
	
	public String getAccessToken(){
		return this.accessToken;
	}
	
	public void setAccessToken(String accessToken){
		this.accessToken=accessToken;
	}
	
	
	public String getTicket(){
		return this.ticket;
	}
	
	public void setTicket(String ticket){
		this.ticket=ticket;
	}
	
	
	public java.util.Date getOperateTime(){
		return this.operateTime;
	}
	
	public void setOperateTime(java.util.Date operateTime){
		this.operateTime=operateTime;
	}
	
	
	public String getWxIp(){
		return this.wxIp;
	}
	
	public void setWxIp(String wxIp){
		this.wxIp=wxIp;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", weixinCode=").append(weixinCode);			
			sb.append(", nickName=").append(nickName);			
			sb.append(", mpType=").append(mpType);			
			sb.append(", remark=").append(remark);			
			sb.append(", email=").append(email);			
			sb.append(", appId=").append(appId);			
			sb.append(", appSecret=").append(appSecret);			
			sb.append(", token=").append(token);			
			sb.append(", encodingAesKey=").append(encodingAesKey);			
			sb.append(", url=").append(url);			
			sb.append(", secretType=").append(secretType);			
			sb.append(", accessToken=").append(accessToken);			
			sb.append(", ticket=").append(ticket);			
			sb.append(", operateTime=").append(operateTime);			
			sb.append(", wxIp=").append(wxIp);			
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
        SysWxConfig other = (SysWxConfig) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getWeixinCode() == null ? other.getId() == null : this.getWeixinCode().equals(other.getWeixinCode()))		
				        		&&(this.getNickName() == null ? other.getId() == null : this.getNickName().equals(other.getNickName()))		
				        		&&(this.getMpType() == null ? other.getId() == null : this.getMpType().equals(other.getMpType()))		
				        		&&(this.getRemark() == null ? other.getId() == null : this.getRemark().equals(other.getRemark()))		
				        		&&(this.getEmail() == null ? other.getId() == null : this.getEmail().equals(other.getEmail()))		
				        		&&(this.getAppId() == null ? other.getId() == null : this.getAppId().equals(other.getAppId()))		
				        		&&(this.getAppSecret() == null ? other.getId() == null : this.getAppSecret().equals(other.getAppSecret()))		
				        		&&(this.getToken() == null ? other.getId() == null : this.getToken().equals(other.getToken()))		
				        		&&(this.getEncodingAesKey() == null ? other.getId() == null : this.getEncodingAesKey().equals(other.getEncodingAesKey()))		
				        		&&(this.getUrl() == null ? other.getId() == null : this.getUrl().equals(other.getUrl()))		
				        		&&(this.getSecretType() == null ? other.getId() == null : this.getSecretType().equals(other.getSecretType()))		
				        		&&(this.getAccessToken() == null ? other.getId() == null : this.getAccessToken().equals(other.getAccessToken()))		
				        		&&(this.getTicket() == null ? other.getId() == null : this.getTicket().equals(other.getTicket()))		
				        		&&(this.getOperateTime() == null ? other.getId() == null : this.getOperateTime().equals(other.getOperateTime()))		
				        		&&(this.getWxIp() == null ? other.getId() == null : this.getWxIp().equals(other.getWxIp()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getWeixinCode() == null) ? 0 : getWeixinCode().hashCode());		
		        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());		
		        result = prime * result + ((getMpType() == null) ? 0 : getMpType().hashCode());		
		        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());		
		        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());		
		        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());		
		        result = prime * result + ((getAppSecret() == null) ? 0 : getAppSecret().hashCode());		
		        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());		
		        result = prime * result + ((getEncodingAesKey() == null) ? 0 : getEncodingAesKey().hashCode());		
		        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());		
		        result = prime * result + ((getSecretType() == null) ? 0 : getSecretType().hashCode());		
		        result = prime * result + ((getAccessToken() == null) ? 0 : getAccessToken().hashCode());		
		        result = prime * result + ((getTicket() == null) ? 0 : getTicket().hashCode());		
		        result = prime * result + ((getOperateTime() == null) ? 0 : getOperateTime().hashCode());		
		        result = prime * result + ((getWxIp() == null) ? 0 : getWxIp().hashCode());		
		;
        return result;
    }

}
