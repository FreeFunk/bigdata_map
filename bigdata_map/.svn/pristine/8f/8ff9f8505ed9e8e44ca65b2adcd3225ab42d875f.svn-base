package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysConfigQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysConfigView queryObj = new SysConfigView();

	public SysConfigView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysConfigView queryObj) {
		this.queryObj = queryObj;
	}
	
}
