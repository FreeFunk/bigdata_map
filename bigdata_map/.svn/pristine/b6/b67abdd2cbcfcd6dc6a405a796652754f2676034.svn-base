package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataSafetyWarningQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataSafetyWarningView queryObj = new BigdataSafetyWarningView();

	public BigdataSafetyWarningView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataSafetyWarningView queryObj) {
		this.queryObj = queryObj;
	}
}
