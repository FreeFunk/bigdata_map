<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("${table.sqlName}")
public class ${className} implements Serializable{
	
	<#list table.columns as column>
	<#if column.columnNameFirstLower='id'>
		
	</#if>
	/**
	 * 属性描述:${column.columnAlias}
	 */
	@TableField(value="${column.sqlName}",exist=true)
	${column.javaType} ${column.columnNameFirstLower};
	
	</#list>
	
	
	
	
	<#list table.columns as column>
	
	public ${column.javaType} get${column.columnNameFirstUpper}(){
		return this.${column.columnNameFirstLower};
	}
	
	public void set${column.columnNameFirstUpper}(${column.javaType} ${column.columnNameFirstLower}){
		this.${column.columnNameFirstLower}=${column.columnNameFirstLower};
	}
	
	</#list>
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		<#list table.columns as column>
			sb.append(", ${column.columnNameFirstLower}=").append(${column.columnNameFirstLower});			
		</#list>
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
        ${className} other = (${className}) that;
        boolean flag = true;
        return  flag
        		<#list table.columns as column>
        		&&(this.get${column.columnNameFirstUpper}() == null ? other.getId() == null : this.get${column.columnNameFirstUpper}().equals(other.get${column.columnNameFirstUpper}()))		
				</#list>;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        <#list table.columns as column>
        result = prime * result + ((get${column.columnNameFirstUpper}() == null) ? 0 : get${column.columnNameFirstUpper}().hashCode());		
		</#list>;
        return result;
    }

}
