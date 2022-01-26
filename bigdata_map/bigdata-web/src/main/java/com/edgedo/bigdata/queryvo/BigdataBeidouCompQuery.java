package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataBeidouCompQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataBeidouCompView queryObj = new BigdataBeidouCompView();

	public BigdataBeidouCompView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataBeidouCompView queryObj) {
		this.queryObj = queryObj;
	}
}
