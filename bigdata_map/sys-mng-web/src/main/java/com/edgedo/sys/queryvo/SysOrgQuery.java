package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysOrgQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysOrgView queryObj = new SysOrgView();

	public SysOrgView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysOrgView queryObj) {
		this.queryObj = queryObj;
	}
	

	
}
