package com.edgedo.bigdata.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class MapLocaltionPointQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private MapLocaltionPointView queryObj = new MapLocaltionPointView();

	public MapLocaltionPointView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(MapLocaltionPointView queryObj) {
		this.queryObj = queryObj;
	}
}
