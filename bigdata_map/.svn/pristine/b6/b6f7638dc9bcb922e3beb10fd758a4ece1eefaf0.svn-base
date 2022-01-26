package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataSafetyWarningQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataSafetyWarningView queryObj = new BigdataSafetyWarningView();

	private Integer weekDateStart;

	private Integer weekDateEnd;

	public Integer getWeekDateStart() {
		return weekDateStart;
	}

	public void setWeekDateStart(Integer weekDateStart) {
		this.weekDateStart = weekDateStart;
	}

	public Integer getWeekDateEnd() {
		return weekDateEnd;
	}

	public void setWeekDateEnd(Integer weekDateEnd) {
		this.weekDateEnd = weekDateEnd;
	}

	public BigdataSafetyWarningView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataSafetyWarningView queryObj) {
		this.queryObj = queryObj;
	}
}
