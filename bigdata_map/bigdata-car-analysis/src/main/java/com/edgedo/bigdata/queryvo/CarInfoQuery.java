package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class CarInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private CarInfoView queryObj = new CarInfoView();

	public CarInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(CarInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
