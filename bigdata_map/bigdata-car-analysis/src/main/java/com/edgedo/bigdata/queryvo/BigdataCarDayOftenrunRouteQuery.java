package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataCarDayOftenrunRouteQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataCarDayOftenrunRouteView queryObj = new BigdataCarDayOftenrunRouteView();

	public BigdataCarDayOftenrunRouteView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataCarDayOftenrunRouteView queryObj) {
		this.queryObj = queryObj;
	}
}
