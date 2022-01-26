package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataGpsTransmitCarPermitQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataGpsTransmitCarPermitView queryObj = new BigdataGpsTransmitCarPermitView();

	public BigdataGpsTransmitCarPermitView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataGpsTransmitCarPermitView queryObj) {
		this.queryObj = queryObj;
	}
}
