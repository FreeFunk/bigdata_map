package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class BigdataBeidouLinkBkRecQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private BigdataBeidouLinkBkRecView queryObj = new BigdataBeidouLinkBkRecView();

	public BigdataBeidouLinkBkRecView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(BigdataBeidouLinkBkRecView queryObj) {
		this.queryObj = queryObj;
	}
}