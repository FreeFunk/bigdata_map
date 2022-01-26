package com.edgedo.drawing.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataDriverStopRecQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataDriverStopRecView queryObj = new BigdataDriverStopRecView();

	public BigdataDriverStopRecView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataDriverStopRecView queryObj) {
		this.queryObj = queryObj;
	}
}
