package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysSiteMsgQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysSiteMsgView queryObj = new SysSiteMsgView();

	public SysSiteMsgView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysSiteMsgView queryObj) {
		this.queryObj = queryObj;
	}

	
}
