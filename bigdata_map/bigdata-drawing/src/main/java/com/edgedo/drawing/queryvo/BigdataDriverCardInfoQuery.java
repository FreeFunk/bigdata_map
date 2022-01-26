package com.edgedo.drawing.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataDriverCardInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataDriverCardInfoView queryObj = new BigdataDriverCardInfoView();

	public BigdataDriverCardInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataDriverCardInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
