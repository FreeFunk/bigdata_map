package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysProviceQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysProviceView queryObj = new SysProviceView();

	public SysProviceView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysProviceView queryObj) {
		this.queryObj = queryObj;
	}


	
}
