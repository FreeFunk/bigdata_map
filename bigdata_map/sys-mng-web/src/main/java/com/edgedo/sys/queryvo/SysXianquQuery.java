package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysXianquQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysXianquView queryObj = new SysXianquView();

	public SysXianquView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysXianquView queryObj) {
		this.queryObj = queryObj;
	}

	
}
