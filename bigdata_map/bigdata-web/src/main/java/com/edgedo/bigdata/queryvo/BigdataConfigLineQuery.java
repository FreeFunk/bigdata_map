package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataConfigLineQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataConfigLineView queryObj = new BigdataConfigLineView();

	public BigdataConfigLineView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataConfigLineView queryObj) {
		this.queryObj = queryObj;
	}
}
