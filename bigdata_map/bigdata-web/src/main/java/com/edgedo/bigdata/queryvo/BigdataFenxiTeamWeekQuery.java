package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataFenxiTeamWeekQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataFenxiTeamWeekView queryObj = new BigdataFenxiTeamWeekView();

	public BigdataFenxiTeamWeekView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataFenxiTeamWeekView queryObj) {
		this.queryObj = queryObj;
	}
}
