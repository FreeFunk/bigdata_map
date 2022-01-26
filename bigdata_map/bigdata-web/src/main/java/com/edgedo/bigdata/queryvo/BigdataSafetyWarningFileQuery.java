package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataSafetyWarningFileQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataSafetyWarningFileView queryObj = new BigdataSafetyWarningFileView();

	public BigdataSafetyWarningFileView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataSafetyWarningFileView queryObj) {
		this.queryObj = queryObj;
	}
}
