package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataFenxiCountQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataFenxiCountView queryObj = new BigdataFenxiCountView();

	public BigdataFenxiCountView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataFenxiCountView queryObj) {
		this.queryObj = queryObj;
	}
}
