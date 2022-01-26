package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataFenxiCarAlarmWeekQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataFenxiCarAlarmWeekView queryObj = new BigdataFenxiCarAlarmWeekView();

	public BigdataFenxiCarAlarmWeekView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataFenxiCarAlarmWeekView queryObj) {
		this.queryObj = queryObj;
	}
}
