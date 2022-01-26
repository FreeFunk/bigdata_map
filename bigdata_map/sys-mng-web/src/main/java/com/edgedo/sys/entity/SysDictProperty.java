package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_dict_property")
public class SysDictProperty implements Serializable{


	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;

	/**
	 * 属性描述:所属字典
	 */
	@TableField(value="OWNER_DICT_ID",exist=true)
	String ownerDictId;

	/**
	 * 属性描述:属性名称
	 */
	@TableField(value="NAME",exist=true)
	String name;

	/**
	 * 属性描述:属性值
	 */
	@TableField(value="VALUE",exist=true)
	String value;

	/**
	 * 属性描述:描述
	 */
	@TableField(value="REMARK",exist=true)
	String remark;

	/**
	 * 属性描述:排序号
	 */
	@TableField(value="ORDER_NUMBER",exist=true)
	java.math.BigDecimal orderNumber;






	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}


	public String getOwnerDictId(){
		return this.ownerDictId;
	}

	public void setOwnerDictId(String ownerDictId){
		this.ownerDictId=ownerDictId;
	}


	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name=name;
	}


	public String getValue(){
		return this.value;
	}

	public void setValue(String value){
		this.value=value;
	}


	public String getRemark(){
		return this.remark;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}


	public java.math.BigDecimal getOrderNumber(){
		return this.orderNumber;
	}

	public void setOrderNumber(java.math.BigDecimal orderNumber){
		this.orderNumber=orderNumber;
	}




	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", ownerDictId=").append(ownerDictId);
		sb.append(", name=").append(name);
		sb.append(", value=").append(value);
		sb.append(", remark=").append(remark);
		sb.append(", orderNumber=").append(orderNumber);
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
		SysDictProperty other = (SysDictProperty) that;
		boolean flag = true;
		return  flag
				&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&&(this.getOwnerDictId() == null ? other.getId() == null : this.getOwnerDictId().equals(other.getOwnerDictId()))
				&&(this.getName() == null ? other.getId() == null : this.getName().equals(other.getName()))
				&&(this.getValue() == null ? other.getId() == null : this.getValue().equals(other.getValue()))
				&&(this.getRemark() == null ? other.getId() == null : this.getRemark().equals(other.getRemark()))
				&&(this.getOrderNumber() == null ? other.getId() == null : this.getOrderNumber().equals(other.getOrderNumber()))
				;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getOwnerDictId() == null) ? 0 : getOwnerDictId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
		;
		return result;
	}


}
