package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataDriverCardRecQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataDriverCardRecView queryObj = new BigdataDriverCardRecView();

	public BigdataDriverCardRecView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataDriverCardRecView queryObj) {
		this.queryObj = queryObj;
	}
}
