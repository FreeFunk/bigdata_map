package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysBzModelQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysBzModelView queryObj = new SysBzModelView();

	public SysBzModelView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysBzModelView queryObj) {
		this.queryObj = queryObj;
	}
}
