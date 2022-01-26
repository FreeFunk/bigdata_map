package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysUserQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysUserView queryObj = new SysUserView();

	public SysUserView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysUserView queryObj) {
		this.queryObj = queryObj;
	}
	

	
}
