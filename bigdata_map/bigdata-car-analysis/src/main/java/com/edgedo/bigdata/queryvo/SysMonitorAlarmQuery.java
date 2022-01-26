package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysMonitorAlarmQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysMonitorAlarmView queryObj = new SysMonitorAlarmView();

	public SysMonitorAlarmView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysMonitorAlarmView queryObj) {
		this.queryObj = queryObj;
	}
}
