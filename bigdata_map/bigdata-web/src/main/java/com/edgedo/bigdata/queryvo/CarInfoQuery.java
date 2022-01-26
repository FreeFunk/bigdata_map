package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class CarInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private CarInfoView queryObj = new CarInfoView();

	private int searchCount;

	private String searchType;

	private String companyLavel;

	public String getCompanyLavel() {
		return companyLavel;
	}

	public void setCompanyLavel(String companyLavel) {
		this.companyLavel = companyLavel;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public int getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}

	public CarInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(CarInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
