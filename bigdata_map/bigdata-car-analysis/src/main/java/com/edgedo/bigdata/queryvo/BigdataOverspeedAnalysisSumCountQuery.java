package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataOverspeedAnalysisSumCountQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataOverspeedAnalysisSumCountView queryObj = new BigdataOverspeedAnalysisSumCountView();

	public BigdataOverspeedAnalysisSumCountView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataOverspeedAnalysisSumCountView queryObj) {
		this.queryObj = queryObj;
	}
}
