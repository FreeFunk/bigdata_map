package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BeidouDataInCountQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BeidouDataInCountView queryObj = new BeidouDataInCountView();

	public BeidouDataInCountView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BeidouDataInCountView queryObj) {
		this.queryObj = queryObj;
	}
}
