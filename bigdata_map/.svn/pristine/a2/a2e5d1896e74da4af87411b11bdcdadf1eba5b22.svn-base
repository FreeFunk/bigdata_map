package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataSafetyProductionSituationQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataSafetyProductionSituationView queryObj = new BigdataSafetyProductionSituationView();

	public BigdataSafetyProductionSituationView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataSafetyProductionSituationView queryObj) {
		this.queryObj = queryObj;
	}
}
