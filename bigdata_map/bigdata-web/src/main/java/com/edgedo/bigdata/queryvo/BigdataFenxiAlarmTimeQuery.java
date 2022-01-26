package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataFenxiAlarmTimeQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataFenxiAlarmTimeView queryObj = new BigdataFenxiAlarmTimeView();

	public BigdataFenxiAlarmTimeView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataFenxiAlarmTimeView queryObj) {
		this.queryObj = queryObj;
	}
}
