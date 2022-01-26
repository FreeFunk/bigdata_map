package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import java.util.Date;

public class BigdataOverspeedAnalysisQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataOverspeedAnalysisView queryObj = new BigdataOverspeedAnalysisView();

	private Date startDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public BigdataOverspeedAnalysisView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataOverspeedAnalysisView queryObj) {
		this.queryObj = queryObj;
	}
}
