package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataTimeAnalysisQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataTimeAnalysisView queryObj = new BigdataTimeAnalysisView();

	public BigdataTimeAnalysisView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataTimeAnalysisView queryObj) {
		this.queryObj = queryObj;
	}
}
