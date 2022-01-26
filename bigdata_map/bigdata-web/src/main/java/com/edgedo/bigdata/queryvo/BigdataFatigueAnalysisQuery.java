package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import java.util.Date;

public class BigdataFatigueAnalysisQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataFatigueAnalysisView queryObj = new BigdataFatigueAnalysisView();

	private Date startDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public BigdataFatigueAnalysisView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataFatigueAnalysisView queryObj) {
		this.queryObj = queryObj;
	}
}
