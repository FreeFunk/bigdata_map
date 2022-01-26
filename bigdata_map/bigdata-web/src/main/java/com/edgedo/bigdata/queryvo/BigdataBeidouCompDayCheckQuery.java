package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataBeidouCompDayCheckQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataBeidouCompDayCheckView queryObj = new BigdataBeidouCompDayCheckView();

	public BigdataBeidouCompDayCheckView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataBeidouCompDayCheckView queryObj) {
		this.queryObj = queryObj;
	}
}
