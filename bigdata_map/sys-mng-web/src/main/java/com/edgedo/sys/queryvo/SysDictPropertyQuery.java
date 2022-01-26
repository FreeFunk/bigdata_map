package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysDictPropertyQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private SysDictPropertyView queryObj = new SysDictPropertyView();

	public SysDictPropertyView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysDictPropertyView queryObj) {
		this.queryObj = queryObj;
	}



}
