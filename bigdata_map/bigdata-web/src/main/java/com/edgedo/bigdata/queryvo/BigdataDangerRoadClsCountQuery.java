package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataDangerRoadClsCountQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataDangerRoadClsCountView queryObj = new BigdataDangerRoadClsCountView();

	public BigdataDangerRoadClsCountView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataDangerRoadClsCountView queryObj) {
		this.queryObj = queryObj;
	}
}
