package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataDangerRoadAnalysisQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataDangerRoadAnalysisView queryObj = new BigdataDangerRoadAnalysisView();

	public BigdataDangerRoadAnalysisView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataDangerRoadAnalysisView queryObj) {
		this.queryObj = queryObj;
	}
}
