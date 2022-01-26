package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class CityTransportCapacityAnalysisInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private CityTransportCapacityAnalysisInfoView queryObj = new CityTransportCapacityAnalysisInfoView();

	public CityTransportCapacityAnalysisInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(CityTransportCapacityAnalysisInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
