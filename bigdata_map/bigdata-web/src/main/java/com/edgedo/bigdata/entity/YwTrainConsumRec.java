package com.edgedo.bigdata.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("yw_train_consum_rec")
public class YwTrainConsumRec implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;

	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	Date createTime;

	/**
	 * 属性描述:学习记录id
	 */
	@TableField(value="LEARN_ID",exist=true)
	String learnId;

	/**
	 * 属性描述:计划id
	 */
	@TableField(value="PLAN_ID",exist=true)
	String planId;

	/**
	 * 属性描述:计划名称
	 */
	@TableField(value="PLAN_NAME",exist=true)
	String planName;

	/**
	 * 属性描述:计划时间
	 */
	@TableField(value="PLAN_CREATE_TIME",exist=true)
	Date planCreateTime;

	/**
	 * 属性描述:所属学员id
	 */
	@TableField(value="STU_ID",exist=true)
	String stuId;

	/**
	 * 属性描述:手机号
	 */
	@TableField(value="STU_PHONE_NUM",exist=true)
	String stuPhoneNum;

	/**
	 * 属性描述:身份证号
	 */
	@TableField(value="STU_ID_CARD",exist=true)
	String stuIdCard;

	/**
	 * 属性描述:资格证号
	 */
	@TableField(value="LICENCE_CODE",exist=true)
	String licenceCode;

	/**
	 * 属性描述:课时时长
	 */
	@TableField(value="STUDY_TIME",exist=true)
	Integer studyTime;

	/**
	 * 属性描述:课时数量
	 */
	@TableField(value="TRAIN_TIME_NUM",exist=true)
	Integer trainTimeNum;

	/**
	 * 属性描述:学习次数
	 */
	@TableField(value="LEARN_NUM",exist=true)
	Integer learnNum;

	/**
	 * 属性描述:开始时间
	 */
	@TableField(value="BEGIN_TIME",exist=true)
	Date beginTime;

	/**
	 * 属性描述:结束时间
	 */
	@TableField(value="END_TIME",exist=true)
	Date endTime;

	/**
	 * 属性描述:所属企业id
	 */
	@TableField(value="COMP_ID",exist=true)
	String compId;

	/**
	 * 属性描述:所属企业id
	 */
	@TableField(value="COMP_NAME",exist=true)
	String compName;

	/**
	 * 属性描述:应用id
	 */
	@TableField(value="APP_ID",exist=true)
	String appId;

	/**
	 * 属性描述:学习类型
	 */
	@TableField(value="LEARN_TYPE",exist=true)
	String learnType;
	//学员姓名
	@TableField(value="STU_NAME",exist=true)
	String stuName;
	//学习记录id
	@TableField(value="REC_ID",exist=true)
	String recId;
	//学习记录是否被取走
	@TableField(value="IS_GET_BY_APP",exist=true)
	String isGetByApp;

	/**
	 * 属性描述:省份 id
	 */
	@TableField(value="PROVINCE_ID",exist=true)
	String provinceId;

	/**
	 * 属性描述:省份名称
	 */
	@TableField(value="PROVINCE_NAME",exist=true)
	String provinceName;

	/**
	 * 属性描述:城市id
	 */
	@TableField(value="CITY_ID",exist=true)
	String cityId;

	/**
	 * 属性描述: 城市名称
	 */
	@TableField(value="CITY_NAME",exist=true)
	String cityName;

	/**
	 * 属性描述: 县区id
	 */
	@TableField(value="XIANQU_ID",exist=true)
	String xianquId;

	/**
	 * 属性描述:县区名
	 */
	@TableField(value="XIANQU_NAME",exist=true)
	String xianquName;

	/**
	 * 属性描述: 本次学习花了多少钱
	 */
	@TableField(value="CONSUME_MONEY",exist = true)
	BigDecimal consumeMoney;

	/**
	 * 属性描述:本次学习记录是属于哪种充值记录的
	 */
	@TableField(value="CHARGE_BILL_ID", exist=true)
	String chargeBillId;
	/**
	 * 属性描述:学习机构类型 (企业/学习点)
	 */
	@TableField(value="PLACE_TYPE", exist=true)
	String placeType;
	/**
	 * 属性描述:学习机构名称
	 */
	@TableField(value="PLACE_NAME", exist=true)
	String placeName;
	/**
	 * 属性描述:学习机构名称
	 */
	@TableField(value="PLACE_ID", exist=true)
	String placeId;
	/**
	 * 属性描述:学习机构名称
	 */
	@TableField(value="car_plate_num", exist=true)
	String carPlateNum;

	@TableField(value="car_frame_num", exist=true)
	String carFrameNum;
	//全局计划id
	@TableField(value="GLOBLE_PLAN_ID", exist=true)
	String globlePlanId;

	//审核状态
	@TableField(value="SHENHE_STATE", exist=true)
	String shenheState;
	//失败原因
	@TableField(value="FAIL_REASON", exist=true)
	String failReason;
	//审核人姓名
	@TableField(value="SH_USER_NAME", exist=true)
	String shUserName;
	//审核人姓名
	@TableField(value="SH_USER_ID", exist=true)
	String shUserId;
	//审核时间
	@TableField(value="SH_TIME", exist=true)
	Date shTime;

	@TableField(value="EMP_TYPE", exist=true)
	private String empType;

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getShUserName() {
		return shUserName;
	}

	public void setShUserName(String shUserName) {
		this.shUserName = shUserName;
	}

	public String getShUserId() {
		return shUserId;
	}

	public void setShUserId(String shUserId) {
		this.shUserId = shUserId;
	}

	public Date getShTime() {
		return shTime;
	}

	public void setShTime(Date shTime) {
		this.shTime = shTime;
	}

	public String getShenheState() {
		return shenheState;
	}

	public void setShenheState(String shenheState) {
		this.shenheState = shenheState;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getGloblePlanId() {
		return globlePlanId;
	}

	public void setGloblePlanId(String globlePlanId) {
		this.globlePlanId = globlePlanId;
	}

	public String getCarFrameNum() {
		return carFrameNum;
	}

	public void setCarFrameNum(String carFrameNum) {
		this.carFrameNum = carFrameNum;
	}

	public String getCarPlateNum() {
		return carPlateNum;
	}

	public void setCarPlateNum(String carPlateNum) {
		this.carPlateNum = carPlateNum;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getChargeBillId() {
		return chargeBillId;
	}

	public void setChargeBillId(String chargeBillId) {
		this.chargeBillId = chargeBillId;
	}

	public BigDecimal getConsumeMoney() {
		return consumeMoney;
	}

	public void setConsumeMoney(BigDecimal consumeMoney) {
		this.consumeMoney = consumeMoney;
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

	public String getIsGetByApp() {
		return isGetByApp;
	}

	public void setIsGetByApp(String isGetByApp) {
		this.isGetByApp = isGetByApp;
	}

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}


	public Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}


	public String getLearnId(){
		return this.learnId;
	}

	public void setLearnId(String learnId){
		this.learnId=learnId;
	}


	public String getPlanId(){
		return this.planId;
	}

	public void setPlanId(String planId){
		this.planId=planId;
	}


	public String getPlanName(){
		return this.planName;
	}

	public void setPlanName(String planName){
		this.planName=planName;
	}


	public Date getPlanCreateTime(){
		return this.planCreateTime;
	}

	public void setPlanCreateTime(Date planCreateTime){
		this.planCreateTime=planCreateTime;
	}


	public String getStuId(){
		return this.stuId;
	}

	public void setStuId(String stuId){
		this.stuId=stuId;
	}


	public String getStuPhoneNum(){
		return this.stuPhoneNum;
	}

	public void setStuPhoneNum(String stuPhoneNum){
		this.stuPhoneNum=stuPhoneNum;
	}


	public String getStuIdCard(){
		return this.stuIdCard;
	}

	public void setStuIdCard(String stuIdCard){
		this.stuIdCard=stuIdCard;
	}


	public String getLicenceCode(){
		return this.licenceCode;
	}

	public void setLicenceCode(String licenceCode){
		this.licenceCode=licenceCode;
	}


	public Integer getStudyTime(){
		return this.studyTime;
	}

	public void setStudyTime(Integer studyTime){
		this.studyTime=studyTime;
	}


	public Integer getTrainTimeNum(){
		return this.trainTimeNum;
	}

	public void setTrainTimeNum(Integer trainTimeNum){
		this.trainTimeNum=trainTimeNum;
	}


	public Integer getLearnNum(){
		return this.learnNum;
	}

	public void setLearnNum(Integer learnNum){
		this.learnNum=learnNum;
	}


	public Date getBeginTime(){
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime){
		this.beginTime=beginTime;
	}


	public Date getEndTime(){
		return this.endTime;
	}

	public void setEndTime(Date endTime){
		this.endTime=endTime;
	}


	public String getCompId(){
		return this.compId;
	}

	public void setCompId(String compId){
		this.compId=compId;
	}


	public String getAppId(){
		return this.appId;
	}

	public void setAppId(String appId){
		this.appId=appId;
	}


	public String getLearnType(){
		return this.learnType;
	}

	public void setLearnType(String learnType){
		this.learnType=learnType;
	}

	public String getStuName(){
		return this.stuName;
	}

	public void setStuName(String stuName){
		this.stuName=stuName;
	}

	public String getRecId(){
		return this.recId;
	}

	public void setRecId(String recId){
		this.recId=recId;
	}
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", learnId=").append(learnId);			
			sb.append(", planId=").append(planId);			
			sb.append(", planName=").append(planName);			
			sb.append(", planCreateTime=").append(planCreateTime);			
			sb.append(", stuId=").append(stuId);			
			sb.append(", stuPhoneNum=").append(stuPhoneNum);			
			sb.append(", stuIdCard=").append(stuIdCard);			
			sb.append(", licenceCode=").append(licenceCode);			
			sb.append(", studyTime=").append(studyTime);			
			sb.append(", trainTimeNum=").append(trainTimeNum);			
			sb.append(", learnNum=").append(learnNum);			
			sb.append(", beginTime=").append(beginTime);			
			sb.append(", endTime=").append(endTime);			
			sb.append(", compId=").append(compId);			
			sb.append(", appId=").append(appId);			
			sb.append(", learnType=").append(learnType);			
			sb.append(", stuName=").append(stuName);
			sb.append(", recId=").append(recId);
			sb.append(", carPlateNum=").append(carPlateNum);
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
        YwTrainConsumRec other = (YwTrainConsumRec) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getLearnId() == null ? other.getId() == null : this.getLearnId().equals(other.getLearnId()))		
				        		&&(this.getPlanId() == null ? other.getId() == null : this.getPlanId().equals(other.getPlanId()))		
				        		&&(this.getPlanName() == null ? other.getId() == null : this.getPlanName().equals(other.getPlanName()))		
				        		&&(this.getPlanCreateTime() == null ? other.getId() == null : this.getPlanCreateTime().equals(other.getPlanCreateTime()))		
				        		&&(this.getStuId() == null ? other.getId() == null : this.getStuId().equals(other.getStuId()))		
				        		&&(this.getStuPhoneNum() == null ? other.getId() == null : this.getStuPhoneNum().equals(other.getStuPhoneNum()))		
				        		&&(this.getStuIdCard() == null ? other.getId() == null : this.getStuIdCard().equals(other.getStuIdCard()))		
				        		&&(this.getLicenceCode() == null ? other.getId() == null : this.getLicenceCode().equals(other.getLicenceCode()))		
				        		&&(this.getStudyTime() == null ? other.getId() == null : this.getStudyTime().equals(other.getStudyTime()))		
				        		&&(this.getTrainTimeNum() == null ? other.getId() == null : this.getTrainTimeNum().equals(other.getTrainTimeNum()))		
				        		&&(this.getLearnNum() == null ? other.getId() == null : this.getLearnNum().equals(other.getLearnNum()))		
				        		&&(this.getBeginTime() == null ? other.getId() == null : this.getBeginTime().equals(other.getBeginTime()))		
				        		&&(this.getEndTime() == null ? other.getId() == null : this.getEndTime().equals(other.getEndTime()))		
				        		&&(this.getCompId() == null ? other.getId() == null : this.getCompId().equals(other.getCompId()))		
				        		&&(this.getAppId() == null ? other.getId() == null : this.getAppId().equals(other.getAppId()))		
				        		&&(this.getLearnType() == null ? other.getId() == null : this.getLearnType().equals(other.getLearnType()))		
				        		&&(this.getStuName() == null ? other.getId() == null : this.getStuName().equals(other.getStuName()))
				        		&&(this.getRecId() == null ? other.getId() == null : this.getRecId().equals(other.getRecId()))
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getLearnId() == null) ? 0 : getLearnId().hashCode());		
		        result = prime * result + ((getPlanId() == null) ? 0 : getPlanId().hashCode());		
		        result = prime * result + ((getPlanName() == null) ? 0 : getPlanName().hashCode());		
		        result = prime * result + ((getPlanCreateTime() == null) ? 0 : getPlanCreateTime().hashCode());		
		        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());		
		        result = prime * result + ((getStuPhoneNum() == null) ? 0 : getStuPhoneNum().hashCode());		
		        result = prime * result + ((getStuIdCard() == null) ? 0 : getStuIdCard().hashCode());		
		        result = prime * result + ((getLicenceCode() == null) ? 0 : getLicenceCode().hashCode());		
		        result = prime * result + ((getStudyTime() == null) ? 0 : getStudyTime().hashCode());		
		        result = prime * result + ((getTrainTimeNum() == null) ? 0 : getTrainTimeNum().hashCode());		
		        result = prime * result + ((getLearnNum() == null) ? 0 : getLearnNum().hashCode());		
		        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());		
		        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());		
		        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());		
		        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());		
		        result = prime * result + ((getLearnType() == null) ? 0 : getLearnType().hashCode());		
		        result = prime * result + ((getStuName() == null) ? 0 : getStuName().hashCode());
		        result = prime * result + ((getRecId() == null) ? 0 : getRecId().hashCode());
		;
        return result;
    }
	


}
