package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import java.util.Date;

public class BigdataAlarmRecordQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataAlarmRecordView queryObj = new BigdataAlarmRecordView();

	private Integer countMonth;

	private Integer countDate;

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

	public Integer getCountDate() {
		return countDate;
	}

	public void setCountDate(Integer countDate) {
		this.countDate = countDate;
	}

	public Integer getCountMonth() {
		return countMonth;
	}

	public void setCountMonth(Integer countMonth) {
		this.countMonth = countMonth;
	}

	public BigdataAlarmRecordView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataAlarmRecordView queryObj) {
		this.queryObj = queryObj;
	}
}
