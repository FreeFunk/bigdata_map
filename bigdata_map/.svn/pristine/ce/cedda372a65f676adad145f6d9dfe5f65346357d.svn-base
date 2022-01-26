package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import java.util.Date;

public class BigdataOverspeedAnalysisSumCountQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataOverspeedAnalysisSumCountView queryObj = new BigdataOverspeedAnalysisSumCountView();

	private Date startMonthDate;

	private Date endMonthDate;

	public Date getStartMonthDate() {
		return startMonthDate;
	}

	public void setStartMonthDate(Date startMonthDate) {
		this.startMonthDate = startMonthDate;
	}

	public Date getEndMonthDate() {
		return endMonthDate;
	}

	public void setEndMonthDate(Date endMonthDate) {
		this.endMonthDate = endMonthDate;
	}

	public BigdataOverspeedAnalysisSumCountView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataOverspeedAnalysisSumCountView queryObj) {
		this.queryObj = queryObj;
	}
}
