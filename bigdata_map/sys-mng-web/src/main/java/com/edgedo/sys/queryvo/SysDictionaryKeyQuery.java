package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysDictionaryKeyQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private SysDictionaryKeyView queryObj = new SysDictionaryKeyView();

	public SysDictionaryKeyView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysDictionaryKeyView queryObj) {
		this.queryObj = queryObj;
	}



}
