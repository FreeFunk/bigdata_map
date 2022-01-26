package com.edgedo.drawing.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataDriverCountMonthAndYearQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataDriverCountMonthAndYearView queryObj = new BigdataDriverCountMonthAndYearView();

	public BigdataDriverCountMonthAndYearView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataDriverCountMonthAndYearView queryObj) {
		this.queryObj = queryObj;
	}
}
