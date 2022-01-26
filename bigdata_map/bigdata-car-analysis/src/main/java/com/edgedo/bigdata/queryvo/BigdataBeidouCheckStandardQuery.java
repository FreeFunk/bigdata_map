package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataBeidouCheckStandardQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataBeidouCheckStandardView queryObj = new BigdataBeidouCheckStandardView();

	public BigdataBeidouCheckStandardView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataBeidouCheckStandardView queryObj) {
		this.queryObj = queryObj;
	}
}
