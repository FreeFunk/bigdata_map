package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataFenxiTeamMonthQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataFenxiTeamMonthView queryObj = new BigdataFenxiTeamMonthView();

	public BigdataFenxiTeamMonthView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataFenxiTeamMonthView queryObj) {
		this.queryObj = queryObj;
	}
}
