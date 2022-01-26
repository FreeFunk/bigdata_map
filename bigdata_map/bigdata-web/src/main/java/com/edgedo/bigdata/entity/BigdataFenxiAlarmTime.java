package com.edgedo.bigdata.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_fenxi_alarm_time")
public class BigdataFenxiAlarmTime implements Serializable{
	
		
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
	 * 属性描述:0点-1点
	 */
	@TableField(value="ZERO_ONE",exist=true)
	java.lang.Integer zeroOne;
	
	/**
	 * 属性描述:1点-2点
	 */
	@TableField(value="ONE_TWO",exist=true)
	java.lang.Integer oneTwo;
	
	/**
	 * 属性描述:2点-3点
	 */
	@TableField(value="TWO_THREE",exist=true)
	java.lang.Integer twoThree;
	
	/**
	 * 属性描述:3点-4点
	 */
	@TableField(value="THREE_FOUR",exist=true)
	java.lang.Integer threeFour;
	
	/**
	 * 属性描述:4点-5点
	 */
	@TableField(value="FOUR_FIVE",exist=true)
	java.lang.Integer fourFive;
	
	/**
	 * 属性描述:5点-6点
	 */
	@TableField(value="FIVE_SIX",exist=true)
	java.lang.Integer fiveSix;
	
	/**
	 * 属性描述:6点-7点
	 */
	@TableField(value="SIX_SEVEN",exist=true)
	java.lang.Integer sixSeven;
	
	/**
	 * 属性描述:7点-8点
	 */
	@TableField(value="SEVEN_EIGHT",exist=true)
	java.lang.Integer sevenEight;
	
	/**
	 * 属性描述:8点-9点
	 */
	@TableField(value="EIGHT_NINE",exist=true)
	java.lang.Integer eightNine;
	
	/**
	 * 属性描述:9点-10点
	 */
	@TableField(value="NINE_TEN",exist=true)
	java.lang.Integer nineTen;
	
	/**
	 * 属性描述:10点-11点
	 */
	@TableField(value="TEN_ELEVEN",exist=true)
	java.lang.Integer tenEleven;
	
	/**
	 * 属性描述:11点-12点
	 */
	@TableField(value="ELEVEN_TWELVE",exist=true)
	java.lang.Integer elevenTwelve;
	
	/**
	 * 属性描述:12点-13点
	 */
	@TableField(value="TWELVE_THIRTEEN",exist=true)
	java.lang.Integer twelveThirteen;
	
	/**
	 * 属性描述:13点-14点
	 */
	@TableField(value="THIRTEEN_FOURTEEN",exist=true)
	java.lang.Integer thirteenFourteen;
	
	/**
	 * 属性描述:14点-15点
	 */
	@TableField(value="FOURTEEN_FIFTEEN",exist=true)
	java.lang.Integer fourteenFifteen;
	
	/**
	 * 属性描述:15点-16点
	 */
	@TableField(value="FIFTEEN_SIXTEEN",exist=true)
	java.lang.Integer fifteenSixteen;
	
	/**
	 * 属性描述:16点-17点
	 */
	@TableField(value="SIXTEEN_SEVENTEEN",exist=true)
	java.lang.Integer sixteenSeventeen;
	
	/**
	 * 属性描述:17点-18点
	 */
	@TableField(value="SEVENTEEN_EIGHTEEN",exist=true)
	java.lang.Integer seventeenEighteen;
	
	/**
	 * 属性描述:18点-19点
	 */
	@TableField(value="EIGHTEEN_NINETEEN",exist=true)
	java.lang.Integer eighteenNineteen;
	
	/**
	 * 属性描述:19点-20点
	 */
	@TableField(value="NINETEEN_TWENTY",exist=true)
	java.lang.Integer nineteenTwenty;
	
	/**
	 * 属性描述:20点-21点
	 */
	@TableField(value="TWENTY_TWENTYONE",exist=true)
	java.lang.Integer twentyTwentyone;
	
	/**
	 * 属性描述:21点-22点
	 */
	@TableField(value="TWENTYONE_TWENTYTWO",exist=true)
	java.lang.Integer twentyoneTwentytwo;
	
	/**
	 * 属性描述:22点-23点
	 */
	@TableField(value="TWENTYTWO_TWENTYTHREE",exist=true)
	java.lang.Integer twentytwoTwentythree;
	
	/**
	 * 属性描述:23点-24点
	 */
	@TableField(value="TWENTYTHREE_TWENTYFOUR",exist=true)
	java.lang.Integer twentythreeTwentyfour;
	
	/**
	 * 属性描述:报警分类
	 */
	@TableField(value="ALARM_TYPE",exist=true)
	java.lang.String alarmType;
	
	/**
	 * 属性描述:数据类型（ 报警、处理）
	 */
	@TableField(value="DATA_TYPE",exist=true)
	java.lang.String dataType;
	
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
	 * 属性描述:区域统计类型
	 */
	@TableField(value="COUNT_TYPE",exist=true)
	java.lang.String countType;
	
	/**
	 * 属性描述:车辆类型
	 */
	@TableField(value="CAR_TYPE",exist=true)
	java.lang.String carType;
	
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
	 * 属性描述:统计年份
	 */
	@TableField(value="YEAR_NUM",exist=true)
	java.lang.Integer yearNum;
	
	
	
	
	
	
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
	
	
	public java.lang.Integer getZeroOne(){
		return this.zeroOne;
	}
	
	public void setZeroOne(java.lang.Integer zeroOne){
		this.zeroOne=zeroOne;
	}
	
	
	public java.lang.Integer getOneTwo(){
		return this.oneTwo;
	}
	
	public void setOneTwo(java.lang.Integer oneTwo){
		this.oneTwo=oneTwo;
	}
	
	
	public java.lang.Integer getTwoThree(){
		return this.twoThree;
	}
	
	public void setTwoThree(java.lang.Integer twoThree){
		this.twoThree=twoThree;
	}
	
	
	public java.lang.Integer getThreeFour(){
		return this.threeFour;
	}
	
	public void setThreeFour(java.lang.Integer threeFour){
		this.threeFour=threeFour;
	}
	
	
	public java.lang.Integer getFourFive(){
		return this.fourFive;
	}
	
	public void setFourFive(java.lang.Integer fourFive){
		this.fourFive=fourFive;
	}
	
	
	public java.lang.Integer getFiveSix(){
		return this.fiveSix;
	}
	
	public void setFiveSix(java.lang.Integer fiveSix){
		this.fiveSix=fiveSix;
	}
	
	
	public java.lang.Integer getSixSeven(){
		return this.sixSeven;
	}
	
	public void setSixSeven(java.lang.Integer sixSeven){
		this.sixSeven=sixSeven;
	}
	
	
	public java.lang.Integer getSevenEight(){
		return this.sevenEight;
	}
	
	public void setSevenEight(java.lang.Integer sevenEight){
		this.sevenEight=sevenEight;
	}
	
	
	public java.lang.Integer getEightNine(){
		return this.eightNine;
	}
	
	public void setEightNine(java.lang.Integer eightNine){
		this.eightNine=eightNine;
	}
	
	
	public java.lang.Integer getNineTen(){
		return this.nineTen;
	}
	
	public void setNineTen(java.lang.Integer nineTen){
		this.nineTen=nineTen;
	}
	
	
	public java.lang.Integer getTenEleven(){
		return this.tenEleven;
	}
	
	public void setTenEleven(java.lang.Integer tenEleven){
		this.tenEleven=tenEleven;
	}
	
	
	public java.lang.Integer getElevenTwelve(){
		return this.elevenTwelve;
	}
	
	public void setElevenTwelve(java.lang.Integer elevenTwelve){
		this.elevenTwelve=elevenTwelve;
	}
	
	
	public java.lang.Integer getTwelveThirteen(){
		return this.twelveThirteen;
	}
	
	public void setTwelveThirteen(java.lang.Integer twelveThirteen){
		this.twelveThirteen=twelveThirteen;
	}
	
	
	public java.lang.Integer getThirteenFourteen(){
		return this.thirteenFourteen;
	}
	
	public void setThirteenFourteen(java.lang.Integer thirteenFourteen){
		this.thirteenFourteen=thirteenFourteen;
	}
	
	
	public java.lang.Integer getFourteenFifteen(){
		return this.fourteenFifteen;
	}
	
	public void setFourteenFifteen(java.lang.Integer fourteenFifteen){
		this.fourteenFifteen=fourteenFifteen;
	}
	
	
	public java.lang.Integer getFifteenSixteen(){
		return this.fifteenSixteen;
	}
	
	public void setFifteenSixteen(java.lang.Integer fifteenSixteen){
		this.fifteenSixteen=fifteenSixteen;
	}
	
	
	public java.lang.Integer getSixteenSeventeen(){
		return this.sixteenSeventeen;
	}
	
	public void setSixteenSeventeen(java.lang.Integer sixteenSeventeen){
		this.sixteenSeventeen=sixteenSeventeen;
	}
	
	
	public java.lang.Integer getSeventeenEighteen(){
		return this.seventeenEighteen;
	}
	
	public void setSeventeenEighteen(java.lang.Integer seventeenEighteen){
		this.seventeenEighteen=seventeenEighteen;
	}
	
	
	public java.lang.Integer getEighteenNineteen(){
		return this.eighteenNineteen;
	}
	
	public void setEighteenNineteen(java.lang.Integer eighteenNineteen){
		this.eighteenNineteen=eighteenNineteen;
	}
	
	
	public java.lang.Integer getNineteenTwenty(){
		return this.nineteenTwenty;
	}
	
	public void setNineteenTwenty(java.lang.Integer nineteenTwenty){
		this.nineteenTwenty=nineteenTwenty;
	}
	
	
	public java.lang.Integer getTwentyTwentyone(){
		return this.twentyTwentyone;
	}
	
	public void setTwentyTwentyone(java.lang.Integer twentyTwentyone){
		this.twentyTwentyone=twentyTwentyone;
	}
	
	
	public java.lang.Integer getTwentyoneTwentytwo(){
		return this.twentyoneTwentytwo;
	}
	
	public void setTwentyoneTwentytwo(java.lang.Integer twentyoneTwentytwo){
		this.twentyoneTwentytwo=twentyoneTwentytwo;
	}
	
	
	public java.lang.Integer getTwentytwoTwentythree(){
		return this.twentytwoTwentythree;
	}
	
	public void setTwentytwoTwentythree(java.lang.Integer twentytwoTwentythree){
		this.twentytwoTwentythree=twentytwoTwentythree;
	}
	
	
	public java.lang.Integer getTwentythreeTwentyfour(){
		return this.twentythreeTwentyfour;
	}
	
	public void setTwentythreeTwentyfour(java.lang.Integer twentythreeTwentyfour){
		this.twentythreeTwentyfour=twentythreeTwentyfour;
	}
	
	
	public java.lang.String getAlarmType(){
		return this.alarmType;
	}
	
	public void setAlarmType(java.lang.String alarmType){
		this.alarmType=alarmType;
	}
	
	
	public java.lang.String getDataType(){
		return this.dataType;
	}
	
	public void setDataType(java.lang.String dataType){
		this.dataType=dataType;
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
	
	
	public java.lang.String getCountType(){
		return this.countType;
	}
	
	public void setCountType(java.lang.String countType){
		this.countType=countType;
	}
	
	
	public java.lang.String getCarType(){
		return this.carType;
	}
	
	public void setCarType(java.lang.String carType){
		this.carType=carType;
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
			sb.append(", zeroOne=").append(zeroOne);			
			sb.append(", oneTwo=").append(oneTwo);			
			sb.append(", twoThree=").append(twoThree);			
			sb.append(", threeFour=").append(threeFour);			
			sb.append(", fourFive=").append(fourFive);			
			sb.append(", fiveSix=").append(fiveSix);			
			sb.append(", sixSeven=").append(sixSeven);			
			sb.append(", sevenEight=").append(sevenEight);			
			sb.append(", eightNine=").append(eightNine);			
			sb.append(", nineTen=").append(nineTen);			
			sb.append(", tenEleven=").append(tenEleven);			
			sb.append(", elevenTwelve=").append(elevenTwelve);			
			sb.append(", twelveThirteen=").append(twelveThirteen);			
			sb.append(", thirteenFourteen=").append(thirteenFourteen);			
			sb.append(", fourteenFifteen=").append(fourteenFifteen);			
			sb.append(", fifteenSixteen=").append(fifteenSixteen);			
			sb.append(", sixteenSeventeen=").append(sixteenSeventeen);			
			sb.append(", seventeenEighteen=").append(seventeenEighteen);			
			sb.append(", eighteenNineteen=").append(eighteenNineteen);			
			sb.append(", nineteenTwenty=").append(nineteenTwenty);			
			sb.append(", twentyTwentyone=").append(twentyTwentyone);			
			sb.append(", twentyoneTwentytwo=").append(twentyoneTwentytwo);			
			sb.append(", twentytwoTwentythree=").append(twentytwoTwentythree);			
			sb.append(", twentythreeTwentyfour=").append(twentythreeTwentyfour);			
			sb.append(", alarmType=").append(alarmType);			
			sb.append(", dataType=").append(dataType);			
			sb.append(", provinceId=").append(provinceId);			
			sb.append(", provinceName=").append(provinceName);			
			sb.append(", cityId=").append(cityId);			
			sb.append(", cityName=").append(cityName);			
			sb.append(", xianquId=").append(xianquId);			
			sb.append(", xianquName=").append(xianquName);			
			sb.append(", countType=").append(countType);			
			sb.append(", carType=").append(carType);			
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
        BigdataFenxiAlarmTime other = (BigdataFenxiAlarmTime) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUpdateTime() == null ? other.getId() == null : this.getUpdateTime().equals(other.getUpdateTime()))		
				        		&&(this.getZeroOne() == null ? other.getId() == null : this.getZeroOne().equals(other.getZeroOne()))		
				        		&&(this.getOneTwo() == null ? other.getId() == null : this.getOneTwo().equals(other.getOneTwo()))		
				        		&&(this.getTwoThree() == null ? other.getId() == null : this.getTwoThree().equals(other.getTwoThree()))		
				        		&&(this.getThreeFour() == null ? other.getId() == null : this.getThreeFour().equals(other.getThreeFour()))		
				        		&&(this.getFourFive() == null ? other.getId() == null : this.getFourFive().equals(other.getFourFive()))		
				        		&&(this.getFiveSix() == null ? other.getId() == null : this.getFiveSix().equals(other.getFiveSix()))		
				        		&&(this.getSixSeven() == null ? other.getId() == null : this.getSixSeven().equals(other.getSixSeven()))		
				        		&&(this.getSevenEight() == null ? other.getId() == null : this.getSevenEight().equals(other.getSevenEight()))		
				        		&&(this.getEightNine() == null ? other.getId() == null : this.getEightNine().equals(other.getEightNine()))		
				        		&&(this.getNineTen() == null ? other.getId() == null : this.getNineTen().equals(other.getNineTen()))		
				        		&&(this.getTenEleven() == null ? other.getId() == null : this.getTenEleven().equals(other.getTenEleven()))		
				        		&&(this.getElevenTwelve() == null ? other.getId() == null : this.getElevenTwelve().equals(other.getElevenTwelve()))		
				        		&&(this.getTwelveThirteen() == null ? other.getId() == null : this.getTwelveThirteen().equals(other.getTwelveThirteen()))		
				        		&&(this.getThirteenFourteen() == null ? other.getId() == null : this.getThirteenFourteen().equals(other.getThirteenFourteen()))		
				        		&&(this.getFourteenFifteen() == null ? other.getId() == null : this.getFourteenFifteen().equals(other.getFourteenFifteen()))		
				        		&&(this.getFifteenSixteen() == null ? other.getId() == null : this.getFifteenSixteen().equals(other.getFifteenSixteen()))		
				        		&&(this.getSixteenSeventeen() == null ? other.getId() == null : this.getSixteenSeventeen().equals(other.getSixteenSeventeen()))		
				        		&&(this.getSeventeenEighteen() == null ? other.getId() == null : this.getSeventeenEighteen().equals(other.getSeventeenEighteen()))		
				        		&&(this.getEighteenNineteen() == null ? other.getId() == null : this.getEighteenNineteen().equals(other.getEighteenNineteen()))		
				        		&&(this.getNineteenTwenty() == null ? other.getId() == null : this.getNineteenTwenty().equals(other.getNineteenTwenty()))		
				        		&&(this.getTwentyTwentyone() == null ? other.getId() == null : this.getTwentyTwentyone().equals(other.getTwentyTwentyone()))		
				        		&&(this.getTwentyoneTwentytwo() == null ? other.getId() == null : this.getTwentyoneTwentytwo().equals(other.getTwentyoneTwentytwo()))		
				        		&&(this.getTwentytwoTwentythree() == null ? other.getId() == null : this.getTwentytwoTwentythree().equals(other.getTwentytwoTwentythree()))		
				        		&&(this.getTwentythreeTwentyfour() == null ? other.getId() == null : this.getTwentythreeTwentyfour().equals(other.getTwentythreeTwentyfour()))		
				        		&&(this.getAlarmType() == null ? other.getId() == null : this.getAlarmType().equals(other.getAlarmType()))		
				        		&&(this.getDataType() == null ? other.getId() == null : this.getDataType().equals(other.getDataType()))		
				        		&&(this.getProvinceId() == null ? other.getId() == null : this.getProvinceId().equals(other.getProvinceId()))		
				        		&&(this.getProvinceName() == null ? other.getId() == null : this.getProvinceName().equals(other.getProvinceName()))		
				        		&&(this.getCityId() == null ? other.getId() == null : this.getCityId().equals(other.getCityId()))		
				        		&&(this.getCityName() == null ? other.getId() == null : this.getCityName().equals(other.getCityName()))		
				        		&&(this.getXianquId() == null ? other.getId() == null : this.getXianquId().equals(other.getXianquId()))		
				        		&&(this.getXianquName() == null ? other.getId() == null : this.getXianquName().equals(other.getXianquName()))		
				        		&&(this.getCountType() == null ? other.getId() == null : this.getCountType().equals(other.getCountType()))		
				        		&&(this.getCarType() == null ? other.getId() == null : this.getCarType().equals(other.getCarType()))		
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
		        result = prime * result + ((getZeroOne() == null) ? 0 : getZeroOne().hashCode());		
		        result = prime * result + ((getOneTwo() == null) ? 0 : getOneTwo().hashCode());		
		        result = prime * result + ((getTwoThree() == null) ? 0 : getTwoThree().hashCode());		
		        result = prime * result + ((getThreeFour() == null) ? 0 : getThreeFour().hashCode());		
		        result = prime * result + ((getFourFive() == null) ? 0 : getFourFive().hashCode());		
		        result = prime * result + ((getFiveSix() == null) ? 0 : getFiveSix().hashCode());		
		        result = prime * result + ((getSixSeven() == null) ? 0 : getSixSeven().hashCode());		
		        result = prime * result + ((getSevenEight() == null) ? 0 : getSevenEight().hashCode());		
		        result = prime * result + ((getEightNine() == null) ? 0 : getEightNine().hashCode());		
		        result = prime * result + ((getNineTen() == null) ? 0 : getNineTen().hashCode());		
		        result = prime * result + ((getTenEleven() == null) ? 0 : getTenEleven().hashCode());		
		        result = prime * result + ((getElevenTwelve() == null) ? 0 : getElevenTwelve().hashCode());		
		        result = prime * result + ((getTwelveThirteen() == null) ? 0 : getTwelveThirteen().hashCode());		
		        result = prime * result + ((getThirteenFourteen() == null) ? 0 : getThirteenFourteen().hashCode());		
		        result = prime * result + ((getFourteenFifteen() == null) ? 0 : getFourteenFifteen().hashCode());		
		        result = prime * result + ((getFifteenSixteen() == null) ? 0 : getFifteenSixteen().hashCode());		
		        result = prime * result + ((getSixteenSeventeen() == null) ? 0 : getSixteenSeventeen().hashCode());		
		        result = prime * result + ((getSeventeenEighteen() == null) ? 0 : getSeventeenEighteen().hashCode());		
		        result = prime * result + ((getEighteenNineteen() == null) ? 0 : getEighteenNineteen().hashCode());		
		        result = prime * result + ((getNineteenTwenty() == null) ? 0 : getNineteenTwenty().hashCode());		
		        result = prime * result + ((getTwentyTwentyone() == null) ? 0 : getTwentyTwentyone().hashCode());		
		        result = prime * result + ((getTwentyoneTwentytwo() == null) ? 0 : getTwentyoneTwentytwo().hashCode());		
		        result = prime * result + ((getTwentytwoTwentythree() == null) ? 0 : getTwentytwoTwentythree().hashCode());		
		        result = prime * result + ((getTwentythreeTwentyfour() == null) ? 0 : getTwentythreeTwentyfour().hashCode());		
		        result = prime * result + ((getAlarmType() == null) ? 0 : getAlarmType().hashCode());		
		        result = prime * result + ((getDataType() == null) ? 0 : getDataType().hashCode());		
		        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());		
		        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());		
		        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());		
		        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());		
		        result = prime * result + ((getXianquId() == null) ? 0 : getXianquId().hashCode());		
		        result = prime * result + ((getXianquName() == null) ? 0 : getXianquName().hashCode());		
		        result = prime * result + ((getCountType() == null) ? 0 : getCountType().hashCode());		
		        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());		
		        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());		
		        result = prime * result + ((getCountMonth() == null) ? 0 : getCountMonth().hashCode());		
		        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());		
		;
        return result;
    }

}
