package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_team_analysis_info")
public class BigdataTeamAnalysisInfo implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	/**
	 * 属性描述:更新时间
	 */
	@TableField(value="UPDATE_TIME",exist=true)
	java.util.Date updateTime;
	
	/**
	 * 属性描述:省ID
	 */
	@TableField(value="PROVINCE_ID",exist=true)
	java.lang.String provinceId;
	
	/**
	 * 属性描述:省名
	 */
	@TableField(value="PROVINCE_NAME",exist=true)
	java.lang.String provinceName;
	
	/**
	 * 属性描述:城市ID
	 */
	@TableField(value="CITY_ID",exist=true)
	java.lang.String cityId;
	
	/**
	 * 属性描述:城市名
	 */
	@TableField(value="CITY_NAME",exist=true)
	java.lang.String cityName;
	
	/**
	 * 属性描述:县区ID
	 */
	@TableField(value="XIANQU_ID",exist=true)
	java.lang.String xianquId;
	
	/**
	 * 属性描述:县区名
	 */
	@TableField(value="XIANQU_NAME",exist=true)
	java.lang.String xianquName;
	
	/**
	 * 属性描述:企业ID
	 */
	@TableField(value="TEAM_ID",exist=true)
	java.lang.String teamId;
	
	/**
	 * 属性描述:企业名
	 */
	@TableField(value="TEAM_NAME",exist=true)
	java.lang.String teamName;
	
	/**
	 * 属性描述:企业类型
	 */
	@TableField(value="TEAM_TYPE",exist=true)
	java.lang.String teamType;

	/**
	 * 属性描述:企业分类
	 */
	@TableField(value="TEAM_CLS",exist=true)
	String teamCls;


	/**
	 * 属性描述:运营商名
	 */
	@TableField(value="COMP_NAME",exist=true)
	String compName;

	/**
	 * 属性描述:车辆总数
	 */
	@TableField(value="ZHYG_CAR_NUM",exist=true)
	Integer zhygCarNum;

	/**
	 * 属性描述:车辆总数
	 */
	@TableField(value="CAR_NUM",exist=true)
	java.lang.Integer carNum;
	
	/**
	 * 属性描述:上线率
	 */
	@TableField(value="ONLINE_RATE",exist=true)
	java.math.BigDecimal onlineRate;
	
	/**
	 * 属性描述:上线数
	 */
	@TableField(value="ONLINE_CAR_NUM",exist=true)
	java.lang.Integer onlineCarNum;
	
	/**
	 * 属性描述:运营率
	 */
	@TableField(value="OPERATION_RATE",exist=true)
	java.math.BigDecimal operationRate;
	
	/**
	 * 属性描述:运营数
	 */
	@TableField(value="OPERATION_NUM",exist=true)
	java.lang.Integer operationNum;
	
	/**
	 * 属性描述:统计日期
	 */
	@TableField(value="COUNT_DATE",exist=true)
	java.lang.Integer countDate;
	
	/**
	 * 属性描述:统计月份
	 */
	@TableField(value="COUNT_MONTH",exist=true)
	java.lang.Integer countMonth;
	
	/**
	 * 属性描述:年份
	 */
	@TableField(value="YEAR_NUM",exist=true)
	java.lang.Integer yearNum;

	public String getTeamCls() {
		return teamCls;
	}

	public void setTeamCls(String teamCls) {
		this.teamCls = teamCls;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public Integer getZhygCarNum() {
		return zhygCarNum;
	}

	public void setZhygCarNum(Integer zhygCarNum) {
		this.zhygCarNum = zhygCarNum;
	}

	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime=updateTime;
	}
	
	
	public java.lang.String getProvinceId(){
		return this.provinceId;
	}
	
	public void setProvinceId(java.lang.String provinceId){
		this.provinceId=provinceId;
	}
	
	
	public java.lang.String getProvinceName(){
		return this.provinceName;
	}
	
	public void setProvinceName(java.lang.String provinceName){
		this.provinceName=provinceName;
	}
	
	
	public java.lang.String getCityId(){
		return this.cityId;
	}
	
	public void setCityId(java.lang.String cityId){
		this.cityId=cityId;
	}
	
	
	public java.lang.String getCityName(){
		return this.cityName;
	}
	
	public void setCityName(java.lang.String cityName){
		this.cityName=cityName;
	}
	
	
	public java.lang.String getXianquId(){
		return this.xianquId;
	}
	
	public void setXianquId(java.lang.String xianquId){
		this.xianquId=xianquId;
	}
	
	
	public java.lang.String getXianquName(){
		return this.xianquName;
	}
	
	public void setXianquName(java.lang.String xianquName){
		this.xianquName=xianquName;
	}
	
	
	public java.lang.String getTeamId(){
		return this.teamId;
	}
	
	public void setTeamId(java.lang.String teamId){
		this.teamId=teamId;
	}
	
	
	public java.lang.String getTeamName(){
		return this.teamName;
	}
	
	public void setTeamName(java.lang.String teamName){
		this.teamName=teamName;
	}
	
	
	public java.lang.String getTeamType(){
		return this.teamType;
	}
	
	public void setTeamType(java.lang.String teamType){
		this.teamType=teamType;
	}
	
	
	public java.lang.Integer getCarNum(){
		return this.carNum;
	}
	
	public void setCarNum(java.lang.Integer carNum){
		this.carNum=carNum;
	}
	
	
	public java.math.BigDecimal getOnlineRate(){
		return this.onlineRate;
	}
	
	public void setOnlineRate(java.math.BigDecimal onlineRate){
		this.onlineRate=onlineRate;
	}
	
	
	public java.lang.Integer getOnlineCarNum(){
		return this.onlineCarNum;
	}
	
	public void setOnlineCarNum(java.lang.Integer onlineCarNum){
		this.onlineCarNum=onlineCarNum;
	}
	
	
	public java.math.BigDecimal getOperationRate(){
		return this.operationRate;
	}
	
	public void setOperationRate(java.math.BigDecimal operationRate){
		this.operationRate=operationRate;
	}
	
	
	public java.lang.Integer getOperationNum(){
		return this.operationNum;
	}
	
	public void setOperationNum(java.lang.Integer operationNum){
		this.operationNum=operationNum;
	}
	
	
	public java.lang.Integer getCountDate(){
		return this.countDate;
	}
	
	public void setCountDate(java.lang.Integer countDate){
		this.countDate=countDate;
	}
	
	
	public java.lang.Integer getCountMonth(){
		return this.countMonth;
	}
	
	public void setCountMonth(java.lang.Integer countMonth){
		this.countMonth=countMonth;
	}
	
	
	public java.lang.Integer getYearNum(){
		return this.yearNum;
	}
	
	public void setYearNum(java.lang.Integer yearNum){
		this.yearNum=yearNum;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", updateTime=").append(updateTime);			
			sb.append(", provinceId=").append(provinceId);			
			sb.append(", provinceName=").append(provinceName);			
			sb.append(", cityId=").append(cityId);			
			sb.append(", cityName=").append(cityName);			
			sb.append(", xianquId=").append(xianquId);			
			sb.append(", xianquName=").append(xianquName);			
			sb.append(", teamId=").append(teamId);			
			sb.append(", teamName=").append(teamName);			
			sb.append(", teamType=").append(teamType);			
			sb.append(", carNum=").append(carNum);			
			sb.append(", onlineRate=").append(onlineRate);			
			sb.append(", onlineCarNum=").append(onlineCarNum);			
			sb.append(", operationRate=").append(operationRate);			
			sb.append(", operationNum=").append(operationNum);			
			sb.append(", countDate=").append(countDate);			
			sb.append(", countMonth=").append(countMonth);			
			sb.append(", yearNum=").append(yearNum);			
        sb.append("]");
        return sb.toString();
    }

   
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BigdataTeamAnalysisInfo other = (BigdataTeamAnalysisInfo) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getProvinceId() == null ? other.getId() == null : this.getProvinceId().equals(other.getProvinceId()))		
				        		&&(this.getProvinceName() == null ? other.getId() == null : this.getProvinceName().equals(other.getProvinceName()))		
				        		&&(this.getCityId() == null ? other.getId() == null : this.getCityId().equals(other.getCityId()))		
				        		&&(this.getCityName() == null ? other.getId() == null : this.getCityName().equals(other.getCityName()))		
				        		&&(this.getXianquId() == null ? other.getId() == null : this.getXianquId().equals(other.getXianquId()))		
				        		&&(this.getXianquName() == null ? other.getId() == null : this.getXianquName().equals(other.getXianquName()))		
				        		&&(this.getTeamId() == null ? other.getId() == null : this.getTeamId().equals(other.getTeamId()))		
				        		&&(this.getTeamName() == null ? other.getId() == null : this.getTeamName().equals(other.getTeamName()))		
				        		&&(this.getTeamType() == null ? other.getId() == null : this.getTeamType().equals(other.getTeamType()))		
				        		&&(this.getCarNum() == null ? other.getId() == null : this.getCarNum().equals(other.getCarNum()))		
				        		&&(this.getOnlineRate() == null ? other.getId() == null : this.getOnlineRate().equals(other.getOnlineRate()))		
				        		&&(this.getOnlineCarNum() == null ? other.getId() == null : this.getOnlineCarNum().equals(other.getOnlineCarNum()))		
				        		&&(this.getOperationRate() == null ? other.getId() == null : this.getOperationRate().equals(other.getOperationRate()))		
				        		&&(this.getOperationNum() == null ? other.getId() == null : this.getOperationNum().equals(other.getOperationNum()))		
				        		&&(this.getCountDate() == null ? other.getId() == null : this.getCountDate().equals(other.getCountDate()))		
				        		&&(this.getCountMonth() == null ? other.getId() == null : this.getCountMonth().equals(other.getCountMonth()))		
				        		&&(this.getYearNum() == null ? other.getId() == null : this.getYearNum().equals(other.getYearNum()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());		
		        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());		
		        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());		
		        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());		
		        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());		
		        result = prime * result + ((getXianquId() == null) ? 0 : getXianquId().hashCode());		
		        result = prime * result + ((getXianquName() == null) ? 0 : getXianquName().hashCode());		
		        result = prime * result + ((getTeamId() == null) ? 0 : getTeamId().hashCode());		
		        result = prime * result + ((getTeamName() == null) ? 0 : getTeamName().hashCode());		
		        result = prime * result + ((getTeamType() == null) ? 0 : getTeamType().hashCode());		
		        result = prime * result + ((getCarNum() == null) ? 0 : getCarNum().hashCode());		
		        result = prime * result + ((getOnlineRate() == null) ? 0 : getOnlineRate().hashCode());		
		        result = prime * result + ((getOnlineCarNum() == null) ? 0 : getOnlineCarNum().hashCode());		
		        result = prime * result + ((getOperationRate() == null) ? 0 : getOperationRate().hashCode());		
		        result = prime * result + ((getOperationNum() == null) ? 0 : getOperationNum().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
