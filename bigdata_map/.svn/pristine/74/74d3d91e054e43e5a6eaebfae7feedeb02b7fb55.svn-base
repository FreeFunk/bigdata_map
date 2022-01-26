package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysPowerQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysPowerView queryObj = new SysPowerView();

	public SysPowerView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysPowerView queryObj) {
		this.queryObj = queryObj;
	}

	
}
