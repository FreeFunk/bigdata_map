package com.edgedo.drawing.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataDriverChangeCarRecQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataDriverChangeCarRecView queryObj = new BigdataDriverChangeCarRecView();

	public BigdataDriverChangeCarRecView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataDriverChangeCarRecView queryObj) {
		this.queryObj = queryObj;
	}
}
