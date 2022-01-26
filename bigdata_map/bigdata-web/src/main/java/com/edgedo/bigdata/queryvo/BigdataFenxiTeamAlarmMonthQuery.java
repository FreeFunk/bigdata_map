package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataFenxiTeamAlarmMonthQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataFenxiTeamAlarmMonthView queryObj = new BigdataFenxiTeamAlarmMonthView();

	public BigdataFenxiTeamAlarmMonthView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataFenxiTeamAlarmMonthView queryObj) {
		this.queryObj = queryObj;
	}
}
