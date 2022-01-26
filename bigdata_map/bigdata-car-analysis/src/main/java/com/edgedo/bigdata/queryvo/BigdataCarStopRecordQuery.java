package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataCarStopRecordQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataCarStopRecordView queryObj = new BigdataCarStopRecordView();

	public BigdataCarStopRecordView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataCarStopRecordView queryObj) {
		this.queryObj = queryObj;
	}
}
