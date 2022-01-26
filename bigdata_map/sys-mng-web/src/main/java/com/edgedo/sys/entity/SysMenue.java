package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_menue")
public class SysMenue implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;
	
	/**
	 * 属性描述:菜单名
	 */
	@TableField(value="TEXT",exist=true)
	String text;
	
	/**
	 * 属性描述:路径
	 */
	@TableField(value="PATH",exist=true)
	String path;
	
	/**
	 * 属性描述:父路径Id
	 */
	@TableField(value="PARENT_ID",exist=true)
	String parentId;
	
	/**
	 * 属性描述:菜单类型
	 */
	@TableField(value="TYPE",exist=true)
	String type;
	
	/**
	 * 属性描述:是否是叶子
	 */
	@TableField(value="IS_LEAF",exist=true)
	Long isLeaf;
	
	/**
	 * 属性描述:排序号
	 */
	@TableField(value="SORT_NUM",exist=true)
	java.math.BigDecimal sortNum;
	
	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	String dataState;
	
	/**
	 * 属性描述:菜单图标css
	 */
	@TableField(value="ICON_CLS",exist=true)
	String iconCls;
	
	/**
	 * 属性描述:打开方式
	 */
	@TableField(value="OPEN_TYPE",exist=true)
	String openType;
	
	
	
	
	
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public String getText(){
		return this.text;
	}
	
	public void setText(String text){
		this.text=text;
	}
	
	
	public String getPath(){
		return this.path;
	}
	
	public void setPath(String path){
		this.path=path;
	}
	
	
	public String getParentId(){
		return this.parentId;
	}
	
	public void setParentId(String parentId){
		this.parentId=parentId;
	}
	
	
	public String getType(){
		return this.type;
	}
	
	public void setType(String type){
		this.type=type;
	}
	
	
	public Long getIsLeaf(){
		return this.isLeaf;
	}
	
	public void setIsLeaf(Long isLeaf){
		this.isLeaf=isLeaf;
	}
	
	
	public java.math.BigDecimal getSortNum(){
		return this.sortNum;
	}
	
	public void setSortNum(java.math.BigDecimal sortNum){
		this.sortNum=sortNum;
	}
	
	
	public String getDataState(){
		return this.dataState;
	}
	
	public void setDataState(String dataState){
		this.dataState=dataState;
	}
	
	
	public String getIconCls(){
		return this.iconCls;
	}
	
	public void setIconCls(String iconCls){
		this.iconCls=iconCls;
	}
	
	
	public String getOpenType(){
		return this.openType;
	}
	
	public void setOpenType(String openType){
		this.openType=openType;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", text=").append(text);			
			sb.append(", path=").append(path);			
			sb.append(", parentId=").append(parentId);			
			sb.append(", type=").append(type);			
			sb.append(", isLeaf=").append(isLeaf);			
			sb.append(", sortNum=").append(sortNum);			
			sb.append(", dataState=").append(dataState);			
			sb.append(", iconCls=").append(iconCls);			
			sb.append(", openType=").append(openType);			
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
        SysMenue other = (SysMenue) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getText() == null ? other.getId() == null : this.getText().equals(other.getText()))		
				        		&&(this.getPath() == null ? other.getId() == null : this.getPath().equals(other.getPath()))		
				        		&&(this.getParentId() == null ? other.getId() == null : this.getParentId().equals(other.getParentId()))		
				        		&&(this.getType() == null ? other.getId() == null : this.getType().equals(other.getType()))		
				        		&&(this.getIsLeaf() == null ? other.getId() == null : this.getIsLeaf().equals(other.getIsLeaf()))		
				        		&&(this.getSortNum() == null ? other.getId() == null : this.getSortNum().equals(other.getSortNum()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				        		&&(this.getIconCls() == null ? other.getId() == null : this.getIconCls().equals(other.getIconCls()))		
				        		&&(this.getOpenType() == null ? other.getId() == null : this.getOpenType().equals(other.getOpenType()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getText() == null) ? 0 : getText().hashCode());		
		        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());		
		        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());		
		        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());		
		        result = prime * result + ((getIsLeaf() == null) ? 0 : getIsLeaf().hashCode());		
		        result = prime * result + ((getSortNum() == null) ? 0 : getSortNum().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		        result = prime * result + ((getIconCls() == null) ? 0 : getIconCls().hashCode());		
		        result = prime * result + ((getOpenType() == null) ? 0 : getOpenType().hashCode());		
		;
        return result;
    }
	

}
