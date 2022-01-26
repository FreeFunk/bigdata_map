package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import java.util.Date;
import java.util.List;

public class BigdataAlarmRecordQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataAlarmRecordView queryObj = new BigdataAlarmRecordView();

	private Integer weekDateStart;

	private Integer weekDateEnd;

	public Integer getWeekDateStart() {
		return weekDateStart;
	}

	public void setWeekDateStart(Integer weekDateStart) {
		this.weekDateStart = weekDateStart;
	}

	public Integer getWeekDateEnd() {
		return weekDateEnd;
	}

	public void setWeekDateEnd(Integer weekDateEnd) {
		this.weekDateEnd = weekDateEnd;
	}

	private String carPlateNum;

	public String getCarPlateNum() {
		return carPlateNum;
	}

	public void setCarPlateNum(String carPlateNum) {
		this.carPlateNum = carPlateNum;
	}

	public BigdataAlarmRecordView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataAlarmRecordView queryObj) {
		this.queryObj = queryObj;
	}
}
