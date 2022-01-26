package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataFenxiCarAlarmMonthQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataFenxiCarAlarmMonthView queryObj = new BigdataFenxiCarAlarmMonthView();

	public BigdataFenxiCarAlarmMonthView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataFenxiCarAlarmMonthView queryObj) {
		this.queryObj = queryObj;
	}
}
