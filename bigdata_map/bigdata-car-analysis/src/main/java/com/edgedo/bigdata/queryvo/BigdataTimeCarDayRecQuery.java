package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataTimeCarDayRecQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataTimeCarDayRecView queryObj = new BigdataTimeCarDayRecView();

	public BigdataTimeCarDayRecView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataTimeCarDayRecView queryObj) {
		this.queryObj = queryObj;
	}
}
