<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ${className}Query extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ${className}View queryObj = new ${className}View();

	public ${className}View getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(${className}View queryObj) {
		this.queryObj = queryObj;
	}
}
