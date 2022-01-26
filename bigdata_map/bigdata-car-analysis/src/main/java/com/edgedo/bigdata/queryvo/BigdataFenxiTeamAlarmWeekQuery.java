package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataFenxiTeamAlarmWeekQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataFenxiTeamAlarmWeekView queryObj = new BigdataFenxiTeamAlarmWeekView();

	public BigdataFenxiTeamAlarmWeekView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataFenxiTeamAlarmWeekView queryObj) {
		this.queryObj = queryObj;
	}
}
