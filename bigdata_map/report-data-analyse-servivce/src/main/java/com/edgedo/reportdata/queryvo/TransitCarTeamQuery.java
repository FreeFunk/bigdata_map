package com.edgedo.reportdata.queryvo;

import com.edgedo.common.base.QueryObj;

import java.util.Date;

public class TransitCarTeamQuery extends QueryObj{

    //省ID
    private String provinceId;
    //省名
    private String provinceName;
    //城市ID
    private String cityId;
    //城市名
    private String cityName;
    //县区ID
    private String xianquId;
    //县区名
    private String xianquName;
    //经营许可证号
    private String jyCretNum;
    //车队id
    private String teamId;
    //车队名
    private String teamName;
    //企业类型
    private String companyLavel;
    //查询时间
    private Date searchTime;
    //查询类型（年度:YEAR,月度，MONTH）
    private String searchType;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getCompanyLavel() {
        return companyLavel;
    }

    public void setCompanyLavel(String companyLavel) {
        this.companyLavel = companyLavel;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getXianquId() {
        return xianquId;
    }

    public void setXianquId(String xianquId) {
        this.xianquId = xianquId;
    }

    public String getXianquName() {
        return xianquName;
    }

    public void setXianquName(String xianquName) {
        this.xianquName = xianquName;
    }

    public String getJyCretNum() {
        return jyCretNum;
    }

    public void setJyCretNum(String jyCretNum) {
        this.jyCretNum = jyCretNum;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
