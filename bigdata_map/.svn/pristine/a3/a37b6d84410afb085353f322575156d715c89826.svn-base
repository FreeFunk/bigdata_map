package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_wx_template_msgconfig")
public class SysWxTemplateMsgconfig implements Serializable{
	
		
	/**
	 * 属性描述:id
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:wxTemplateId
	 */
	@TableField(value="WX_TEMPLATE_ID",exist=true)
	java.lang.String wxTemplateId;
	
	/**
	 * 属性描述:dataKey
	 */
	@TableField(value="DATA_KEY",exist=true)
	java.lang.String dataKey;
	
	/**
	 * 属性描述:dataDesc
	 */
	@TableField(value="DATA_DESC",exist=true)
	java.lang.String dataDesc;
	
	/**
	 * 属性描述:url
	 */
	@TableField(value="URL",exist=true)
	java.lang.String url;
	
	/**
	 * 属性描述:templateRemark
	 */
	@TableField(value="TEMPLATE_REMARK",exist=true)
	java.lang.String templateRemark;
	
	
	
	
	
	
	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.lang.String getWxTemplateId(){
		return this.wxTemplateId;
	}
	
	public void setWxTemplateId(java.lang.String wxTemplateId){
		this.wxTemplateId=wxTemplateId;
	}
	
	
	public java.lang.String getDataKey(){
		return this.dataKey;
	}
	
	public void setDataKey(java.lang.String dataKey){
		this.dataKey=dataKey;
	}
	
	
	public java.lang.String getDataDesc(){
		return this.dataDesc;
	}
	
	public void setDataDesc(java.lang.String dataDesc){
		this.dataDesc=dataDesc;
	}
	
	
	public java.lang.String getUrl(){
		return this.url;
	}
	
	public void setUrl(java.lang.String url){
		this.url=url;
	}
	
	
	public java.lang.String getTemplateRemark(){
		return this.templateRemark;
	}
	
	public void setTemplateRemark(java.lang.String templateRemark){
		this.templateRemark=templateRemark;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", wxTemplateId=").append(wxTemplateId);			
			sb.append(", dataKey=").append(dataKey);			
			sb.append(", dataDesc=").append(dataDesc);			
			sb.append(", url=").append(url);			
			sb.append(", templateRemark=").append(templateRemark);			
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
        SysWxTemplateMsgconfig other = (SysWxTemplateMsgconfig) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getWxTemplateId() == null ? other.getId() == null : this.getWxTemplateId().equals(other.getWxTemplateId()))		
				        		&&(this.getDataKey() == null ? other.getId() == null : this.getDataKey().equals(other.getDataKey()))		
				        		&&(this.getDataDesc() == null ? other.getId() == null : this.getDataDesc().equals(other.getDataDesc()))		
				        		&&(this.getUrl() == null ? other.getId() == null : this.getUrl().equals(other.getUrl()))		
				        		&&(this.getTemplateRemark() == null ? other.getId() == null : this.getTemplateRemark().equals(other.getTemplateRemark()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getWxTemplateId() == null) ? 0 : getWxTemplateId().hashCode());		
		        result = prime * result + ((getDataKey() == null) ? 0 : getDataKey().hashCode());		
		        result = prime * result + ((getDataDesc() == null) ? 0 : getDataDesc().hashCode());		
		        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());		
		        result = prime * result + ((getTemplateRemark() == null) ? 0 : getTemplateRemark().hashCode());		
		;
        return result;
    }

}
