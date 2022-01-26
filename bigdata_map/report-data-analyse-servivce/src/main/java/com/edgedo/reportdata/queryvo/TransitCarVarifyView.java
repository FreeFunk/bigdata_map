package com.edgedo.reportdata.queryvo;

import com.edgedo.reportdata.entity.TransitCarVarify;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class TransitCarVarifyView extends TransitCarVarify {
    @ApiModelProperty(value = "搜索类型:YEAR,MONTH")
    String searchType;
    @ApiModelProperty(value = "搜索时间")
    Date searchTime;


    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }


}
