package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class CarMonthOftenrunRouteQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private CarMonthOftenrunRouteView queryObj = new CarMonthOftenrunRouteView();

	public CarMonthOftenrunRouteView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(CarMonthOftenrunRouteView queryObj) {
		this.queryObj = queryObj;
	}
}
