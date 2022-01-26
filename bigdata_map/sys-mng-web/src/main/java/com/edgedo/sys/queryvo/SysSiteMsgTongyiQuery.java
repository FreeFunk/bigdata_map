package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class SysSiteMsgTongyiQuery extends QueryObj {
	@JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
	private SysSiteMsgTongyiView queryObj = new SysSiteMsgTongyiView();

	public SysSiteMsgTongyiView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysSiteMsgTongyiView queryObj) {
		this.queryObj = queryObj;
	}

	
}
