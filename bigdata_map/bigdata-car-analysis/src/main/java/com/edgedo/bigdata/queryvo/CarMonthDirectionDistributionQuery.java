package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class CarMonthDirectionDistributionQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private CarMonthDirectionDistributionView queryObj = new CarMonthDirectionDistributionView();

	public CarMonthDirectionDistributionView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(CarMonthDirectionDistributionView queryObj) {
		this.queryObj = queryObj;
	}
}
