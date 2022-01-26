package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataPushLearnRecQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataPushLearnRecView queryObj = new BigdataPushLearnRecView();

	public BigdataPushLearnRecView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataPushLearnRecView queryObj) {
		this.queryObj = queryObj;
	}
}
