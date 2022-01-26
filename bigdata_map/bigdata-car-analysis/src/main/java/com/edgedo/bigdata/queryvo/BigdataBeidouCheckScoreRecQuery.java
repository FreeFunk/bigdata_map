package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataBeidouCheckScoreRecQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataBeidouCheckScoreRecView queryObj = new BigdataBeidouCheckScoreRecView();

	public BigdataBeidouCheckScoreRecView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataBeidouCheckScoreRecView queryObj) {
		this.queryObj = queryObj;
	}
}
