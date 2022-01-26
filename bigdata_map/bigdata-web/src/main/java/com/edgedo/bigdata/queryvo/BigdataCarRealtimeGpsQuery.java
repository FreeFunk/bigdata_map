package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import java.util.Date;

public class BigdataCarRealtimeGpsQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataCarRealtimeGpsView queryObj = new BigdataCarRealtimeGpsView();

	private Date startTime;

	private Date endTime;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public BigdataCarRealtimeGpsView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataCarRealtimeGpsView queryObj) {
		this.queryObj = queryObj;
	}
}
