package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataTeamAnalysisInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataTeamAnalysisInfoView queryObj = new BigdataTeamAnalysisInfoView();

	public BigdataTeamAnalysisInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataTeamAnalysisInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
