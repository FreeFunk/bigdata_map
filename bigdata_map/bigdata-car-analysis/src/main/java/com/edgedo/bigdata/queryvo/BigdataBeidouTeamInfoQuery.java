package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataBeidouTeamInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataBeidouTeamInfoView queryObj = new BigdataBeidouTeamInfoView();

	public BigdataBeidouTeamInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataBeidouTeamInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
