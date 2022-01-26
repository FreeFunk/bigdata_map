package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataSafetyCheckQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataSafetyCheckView queryObj = new BigdataSafetyCheckView();

	public BigdataSafetyCheckView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataSafetyCheckView queryObj) {
		this.queryObj = queryObj;
	}
}
