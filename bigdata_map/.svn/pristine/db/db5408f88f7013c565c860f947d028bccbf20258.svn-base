package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataBeidouModelQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataBeidouModelView queryObj = new BigdataBeidouModelView();

	public BigdataBeidouModelView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataBeidouModelView queryObj) {
		this.queryObj = queryObj;
	}
}
