package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class OftenrunRouteMonthCountQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private OftenrunRouteMonthCountView queryObj = new OftenrunRouteMonthCountView();

	public OftenrunRouteMonthCountView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(OftenrunRouteMonthCountView queryObj) {
		this.queryObj = queryObj;
	}
}
