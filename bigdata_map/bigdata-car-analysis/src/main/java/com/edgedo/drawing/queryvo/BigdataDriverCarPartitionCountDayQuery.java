package com.edgedo.drawing.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataDriverCarPartitionCountDayQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataDriverCarPartitionCountDayView queryObj = new BigdataDriverCarPartitionCountDayView();

	public BigdataDriverCarPartitionCountDayView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataDriverCarPartitionCountDayView queryObj) {
		this.queryObj = queryObj;
	}
}
