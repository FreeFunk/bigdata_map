package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysWxPayRecordQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysWxPayRecordView queryObj = new SysWxPayRecordView();

	public SysWxPayRecordView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysWxPayRecordView queryObj) {
		this.queryObj = queryObj;
	}
	

}
