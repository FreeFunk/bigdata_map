package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataBeidouSafetyCarInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataBeidouSafetyCarInfoView queryObj = new BigdataBeidouSafetyCarInfoView();

	public BigdataBeidouSafetyCarInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataBeidouSafetyCarInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
