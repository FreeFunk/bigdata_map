package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_dictionary_key")
public class SysDictionaryKey implements Serializable{


    /**
     * 属性描述:主键key
     */
    @TableField(value="ID",exist=true)
    String id;

    /**
     * 属性描述:字典名称
     */
    @TableField(value="DICT_NAME",exist=true)
    String dictName;

    /**
     * 属性描述:父节点id
     */
    @TableField(value="PARENT_ID",exist=true)
    String parentId;

    /**
     * 属性描述:字典描述
     */
    @TableField(value="REMARK",exist=true)
    String remark;

    /**
     * 属性描述:排序号
     */
    @TableField(value="ORDER_NUMBER",exist=true)
    java.math.BigDecimal orderNumber;

    /**
     * 属性描述:排序号
     */
    @TableField(value="IS_LEAF",exist=true)
    int isLeaf;

    public int getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(int isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id=id;
    }


    public String getDictName(){
        return this.dictName;
    }

    public void setDictName(String dictName){
        this.dictName=dictName;
    }


    public String getParentId(){
        return this.parentId;
    }

    public void setParentId(String parentId){
        this.parentId=parentId;
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
        sb.append(", dictName=").append(dictName);
        sb.append(", parentId=").append(parentId);
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
        SysDictionaryKey other = (SysDictionaryKey) that;
        boolean flag = true;
        return  flag
                &&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                &&(this.getDictName() == null ? other.getId() == null : this.getDictName().equals(other.getDictName()))
                &&(this.getParentId() == null ? other.getId() == null : this.getParentId().equals(other.getParentId()))
                &&(this.getRemark() == null ? other.getId() == null : this.getRemark().equals(other.getRemark()))
                &&(this.getOrderNumber() == null ? other.getId() == null : this.getOrderNumber().equals(other.getOrderNumber()))
                ;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDictName() == null) ? 0 : getDictName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        ;
        return result;
    }

}
