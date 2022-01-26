package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import java.util.Date;

public class SysUserOpLogQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysUserOpLogView queryObj = new SysUserOpLogView();

	public SysUserOpLogView getQueryObj() {
		return queryObj;
	}

	public Date startTime;
	public Date endTime;

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

	public void setQueryObj(SysUserOpLogView queryObj) {
		this.queryObj = queryObj;
	}
}
