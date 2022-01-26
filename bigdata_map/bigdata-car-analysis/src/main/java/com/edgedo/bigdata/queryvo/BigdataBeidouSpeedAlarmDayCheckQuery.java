package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataBeidouSpeedAlarmDayCheckQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataBeidouSpeedAlarmDayCheckView queryObj = new BigdataBeidouSpeedAlarmDayCheckView();

	public BigdataBeidouSpeedAlarmDayCheckView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataBeidouSpeedAlarmDayCheckView queryObj) {
		this.queryObj = queryObj;
	}
}
