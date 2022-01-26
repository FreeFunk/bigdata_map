package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataBeidouCarMonthCheckQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataBeidouCarMonthCheckView queryObj = new BigdataBeidouCarMonthCheckView();

	public BigdataBeidouCarMonthCheckView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataBeidouCarMonthCheckView queryObj) {
		this.queryObj = queryObj;
	}
}
