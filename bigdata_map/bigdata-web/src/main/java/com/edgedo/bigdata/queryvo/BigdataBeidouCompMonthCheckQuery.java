package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataBeidouCompMonthCheckQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataBeidouCompMonthCheckView queryObj = new BigdataBeidouCompMonthCheckView();

	public BigdataBeidouCompMonthCheckView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataBeidouCompMonthCheckView queryObj) {
		this.queryObj = queryObj;
	}
}
