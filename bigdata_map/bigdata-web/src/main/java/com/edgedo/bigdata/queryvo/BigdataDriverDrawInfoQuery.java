package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataDriverDrawInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataDriverDrawInfoView queryObj = new BigdataDriverDrawInfoView();

	public BigdataDriverDrawInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataDriverDrawInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
