package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysRolePowerQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysRolePowerView queryObj = new SysRolePowerView();

	public SysRolePowerView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysRolePowerView queryObj) {
		this.queryObj = queryObj;
	}

	
}
