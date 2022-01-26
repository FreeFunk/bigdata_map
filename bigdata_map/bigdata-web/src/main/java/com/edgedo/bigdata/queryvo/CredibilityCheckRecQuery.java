package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class CredibilityCheckRecQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private CredibilityCheckRecView queryObj = new CredibilityCheckRecView();

	public CredibilityCheckRecView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(CredibilityCheckRecView queryObj) {
		this.queryObj = queryObj;
	}
}
