package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataLinshiBatchQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataLinshiBatchView queryObj = new BigdataLinshiBatchView();

	public BigdataLinshiBatchView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataLinshiBatchView queryObj) {
		this.queryObj = queryObj;
	}
}
