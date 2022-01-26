package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataFenxiCarMonthQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataFenxiCarMonthView queryObj = new BigdataFenxiCarMonthView();

	public BigdataFenxiCarMonthView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataFenxiCarMonthView queryObj) {
		this.queryObj = queryObj;
	}
}
