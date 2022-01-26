package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class PeccancyRecQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private PeccancyRecView queryObj = new PeccancyRecView();

	public PeccancyRecView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(PeccancyRecView queryObj) {
		this.queryObj = queryObj;
	}
}
