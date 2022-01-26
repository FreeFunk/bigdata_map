package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataFenxiAlarmQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataFenxiAlarmView queryObj = new BigdataFenxiAlarmView();

	public BigdataFenxiAlarmView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataFenxiAlarmView queryObj) {
		this.queryObj = queryObj;
	}
}
