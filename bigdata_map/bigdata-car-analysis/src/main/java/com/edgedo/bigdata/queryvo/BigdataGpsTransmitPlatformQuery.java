package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataGpsTransmitPlatformQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataGpsTransmitPlatformView queryObj = new BigdataGpsTransmitPlatformView();

	public BigdataGpsTransmitPlatformView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataGpsTransmitPlatformView queryObj) {
		this.queryObj = queryObj;
	}
}
