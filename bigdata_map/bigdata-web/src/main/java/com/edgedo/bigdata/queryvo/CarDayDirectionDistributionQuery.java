package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class CarDayDirectionDistributionQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private CarDayDirectionDistributionView queryObj = new CarDayDirectionDistributionView();

	public CarDayDirectionDistributionView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(CarDayDirectionDistributionView queryObj) {
		this.queryObj = queryObj;
	}
}
