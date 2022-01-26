package com.edgedo.reportdata.entity;

import java.util.Date;

public class TransitCarTeam {

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String TABLE_ALIAS = "平台车队";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_ID = "默认主键";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_ORDER_NUMBER = "序列号";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_CREATE_USER_NAME = "创建人姓名";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_CREATE_USER_ID = "创建人ID";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_CREATE_TIME = "创建时间";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String FORMAT_CREATE_TIME = "yyyy-MM-dd HH:mm:ss";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_OPERATOR = "操作人";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_OPERATE_TIME = "操作时间";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String FORMAT_OPERATE_TIME = "yyyy-MM-dd HH:mm:ss";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_VERSION = "版本号";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_DATA_STATE = "数据状态";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_TEAM_NAME = "车队名";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_PROVINCE_ID = "省id";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_PROVINCE_NAME = "省名";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_CITY_ID = "市id";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_CITY_NAME = "市名";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_XIANQU_ID = "县区id";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_XIANQU_NAME = "县区名";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_CAR_COUNT = "车队汽车总数";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_TEAM_ADMIN_ID = "车队管理用户主键";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_TEAM_ADMIN_CODE = "车队管理账号";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 */
	public static final String ALIAS_TEAM_ADMIN_PHONE = "车队管理联系电话";
	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 默认主键
	 */
	public static final String UNDO_TASK = "未完成的工作";
	private String id;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 序列号
	 */
	private Integer orderNumber;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 创建人姓名
	 */
	private String createUserName;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 创建人ID
	 */
	private String createUserId;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 创建时间
	 */
	private Date createTime;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 操作人
	 */
	private String operator;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 操作时间
	 */
	private Date operateTime;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 版本号
	 */
	private String version;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 数据状态
	 */
	private String dataState;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 车队名
	 */
	private String teamName;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 省id
	 */
	private String provinceId;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 省名
	 */
	private String provinceName;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 市id
	 */
	private String cityId;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 市名
	 */
	private String cityName;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 县区id
	 */
	private String xianquId;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 县区名
	 */
	private String xianquName;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 车队汽车总数
	 */
	private Integer carCount;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 车队管理用户主键
	 */
	private String teamAdminId;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 车队管理账号
	 */
	private String teamAdminCode;

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 车队管理联系电话
	 */
	private String teamAdminPhone;
	//未完成的工作
	private Integer undoTask;
	//联系人
	private String teamAdminName;
	//备注
	private String remark;
	//车队类型
	private String teamType;
	//检查手机号标识
	private String checkPhoneFlag;

	private String unSearchTeam;

	//是否认证显示  CHECK_RENZHENG_FLAG
	private String checkRenzhengFlag;
	
	
	//2017.08.14修改
	//发证机关 LICENCE_AUTHORITY
	private String licenceAuthority;
	//检查考核日期 EXA_CHECK_DATE
	private Date exaCheckDate;
	//经营许可证字 BUSINESS_CERT
	private String businessCert;
	//经营许可证号 JY_CERT_NUMBER
	private String jyCertNumber;
	//经营许可证上传图片 JY_CERT_IMAGE_SRC
	private String jyCertImageSrc;
	//经营范围 JY_SCOPE
	private String jyScope;
	//营业执照号 BUSINESS_CERT_CODE
	private String businessCertCode;
	//营业执照上传图片 BUSINESS_CERT_IMAGE_SRC
	private String businessCertImageSrc;
	//经营负责人 JY_MAN_NAME
	private String jyManName;
	//法人代表 LEGAL_REPRESENT_NAME
	private String legalRepresentName;
	//经营许可证证照类别 JY_LICENCE_TYPE
	private String jyLicenceType;
	//经营负责人联系电话 JY_CHARGE_MAN_PHONE
	private String jyChargeManPhone;
	//负责人委托书图片 JY_MAN_NAME_BOOK_IMAGE_SRC
	private String jyManNameBookImageSrc;
	//绑定二维码 QR_CODE_IMAGE_SRC
	private String qrCodeImageSrc;
	//车辆总数 CAR_AMOUNT  
	private String carAmount;
	//证照发放原因 LICENSE_SEND_REASON 
	private String licenseSendReason;
	//管理人员 ADMINISTRATOR
	private String administrator;
	//证照有效时间截止 LICENSE_VALID_DATE
	private Date licenseValidDate;
	//押运人员 ESCORT_MAN_NAME
	private String escortManName;
	//稽查处理状态 CHECKED_STATE
	private String checkedState;
	//国税发证日期 TAXATION_SEND_DATE
	private Date taxationSendDate;
	//国税证变更日期 TAXATION_CHANGE_DATE
	private Date taxationChangeDate;
	//罐车车辆总数 GC_AMOUNT
	private String gcAmount;
	//污水回收设备配备情况 WSHS_FACILITY_CASE
	private String wshsFacilityCase;
	//专洗设备配用清备情况 ZYQX_FACILITY_CASE
	private String zyqxFacilityCase;
	//安全防护设备配备情况 AQFH_FACILITY_CASE
	private String aqfhFacilityCase;
	//危险货物运输驾驶人员 UNSAFE_DRIVER_NAME
	private String unsafeDriverName;
	//车辆总吨位 CAR_SUM_TON
	private String carSumTon;
	//停车场总面积 PARK_SUM_AREA
	private String parkSumArea;
	//经济类型 ECONOMIC_TYPE
	private String economicType;
	//法人代表身份证图片 BUSINESS_CERT_IMAGE
	private String businessCertImage;
	//法人代表证件类型 LEGAL_REPRESENT_LICENCE_TYPE
	private String legalRepresentLicenceType;
	//考核机构 CHECK_INSTITUTION
	private String checkInstitution;
	//业户手机号 TEAM_PHONE_NUMBER
	private String teamPhoneNumber;
	//业户座机号 TEAM_TELEPHONE
	private String teamTelephone;
	//电子邮箱 TEAM_EMAIL
	private String teamEmail;
	//邮政编码 POST_CODE
	private String postCode;
	//业户地址 TEAM_ADDRESS
	private String teamAddress;
	//评定日期 ASSESS_DATE
	private Date assessDate;
	//组织机构代码 INSTITU_FRAME_NUMBER
	private String instituFrameNumber;
	//地税登记号 LAND_TAX_NUMBER
	private String landTaxNumber;
	//工商执照号 BUSINESS_LICENSE_NUMBER
	private String businessLicenseNumber;
	//户籍运营机构名称 RESIDENCE_INSTITUTION
	private String residenceInstitution;
	//企业等级 COMPANY_LAVEL
	private String companyLevel;
	//更改日期 CHANGE_DATE
	private Date changeDate;
	//质量信誉考核结果 ZL_XY_CHECKED_RESULT
	private String zlXyCheckedResult;


	//管理人员安全图片 MNG_ANQUAN_ZEREN_PHOTO----企业组织机构图
	private String mngAnquanZerenPhoto;
	//从业人员安全责任图片 CONGYE_ANQUAN_ZEREN_PHOTO
	private String congyeAnquanZerenPhoto;
	//安全生产检查制度图片 ANQUAN_SC_CHECK_ZD_PHOTO----安全生产检查制度
	private String anquanScCheckZdPhoto;
	//安全生产教育培训制度图片 ANQUAN_SC_EDU_ZD_PHOTO----安全生产责任制度
	private String anquanScEduZdPhoto;
	//安全管理制度图片 ANQUAN_MNG_ZD_PHOTO-----应急小组组织机构图
	private String anquanMngZdPhoto;
	//应急预案制度图片 YINGJI_YUAN_ZD_PHOTO----交通事故应急预案
	private String yingjiYuanZdPhoto;
	//安全生产作业规程图片 ANQUAN_SC_GUICHENG_PHOTO----安全生产操作规程
	private String anquanScGuichengPhoto;
	//安全生产考核制度图片 ANQUAN_SC_KH_ZD_PHOTO
	private String anquanScKhZdPhoto;
	//安全事故处理制度图片 ANQUAN_SGCL_ZD_PHOTO----驾驶员和车辆管理制度
	private String anquanSgclZdPhoto;


	private String sendId;
	private String checkSafeFileSend;
	
	private String ygzPermisionUser;

	//标准化等级 BZH_LAVEL
	private String biaozhunLavel;
	//标准化证书图片  BZH_ZS_PHOTO
	private String  biaozhunPhoto;
	//证书有效期至 ZS_END_DATA
	private Date zhengshuEndDate;
	//场地规划图 CHANGDI_GH_PHOTO
	private String cdghPhoto;
	//消防沙图片 XFSHA_PHOTO
	private String xfsPhoto;
	//消防锹 XFQIU_PHOTO
	private  String xfqiuPhoto;
	//灭火器图片 MHQ_PHOTO
	private String mhqPhoto;
	//场地图片 CHANGDI_PHOTO
	private String changdiPhoto;
	//场地位置 CHANGDIWEIZHI
	private  String changdiweizhi;
	//财务制度 MONEY_ZHIDU-------财政制度
	private String moneyzdPhoto;

	//每月车队台帐类型数
	 private Integer  countLedgerType;
	//从业人员安全管理制度 CYRY_AQGL_ZD
	private String cyryaqglZd;
	//AQ_SGBGL_ZD         安全事故报告处理制度
	private String aqsgbglZd;
	//AQ_YHZG_ZD              安全隐患整改制度
	private String aqyhzgZd;
	//GSXC_AB_ZD            公司巡查制度、安保制度
	private String gsxcabZd;
	//LH_ZD             例会制度
	private String lhZd;
	//AJJ_WLS_WDW   安监局五落实五到位
	private String ajjWlswdw;
	//AJJ_JTGD            安监局九条规定
	private String ajjJtgd;
	//HW_SLHJ_YS_ZD   货物受理环境验视制度
	private String hwslhjysZd;
	//TZGL_ZD            台账管理制度
	private String tzglZd;
	//GS_ZD         公司制度
	private String gsZd;
	//FZR_AQSC_ZR_ZD        负责人安全生产责任制度
	private String FzraqsczrZd;
	//CYRY_AQSC_ZR_ZD         从业人员安全生产责任制度
	private String CyryaqsczrZd;
	//AQSC_JYPX_ZD               安全生产教育培训制度
	private String AqscjypxZd;
	//AQSC_KHYJC_ZD              安全生产考核与奖惩制度
	private String AqsckhyjcZd;
	//AQSGBG_TJYCL_ZD               安全事故报告、统计与处理制度
	private String AqsgbgTjyclZd;
	//从业人员数量
	private Integer teamEmployeeNum;

	///已完成人数
	private Integer finishedEmpNum;
	//未完成人数
	private Integer unFinishedEmpNum;
	//当月培训总次数
	private Integer countTrainingByMonth;
	//同步状态
	private String tongBuState;
	//从业人员数量
	private Integer empNum;
	//培训总次数
	private Integer trainingNum;
	//已完成车辆数
	private Integer finishedCarNum;
	//本月的培训次数
	private Integer trainingMonthNum;
	//经营许可证下发时间
	private Date licenceSendTime;
	//车辆完成度
	private String carFinished;

	public String getCarFinished() {
		return carFinished;
	}

	public void setCarFinished(String carFinished) {
		this.carFinished = carFinished;
	}

	public Date getLicenceSendTime() {
		return licenceSendTime;
	}

	public void setLicenceSendTime(Date licenceSendTime) {
		this.licenceSendTime = licenceSendTime;
	}

	public Integer getTrainingMonthNum() {
		return trainingMonthNum;
	}

	public void setTrainingMonthNum(Integer trainingMonthNum) {
		this.trainingMonthNum = trainingMonthNum;
	}

	public Integer getFinishedCarNum() {
		return finishedCarNum;
	}

	public void setFinishedCarNum(Integer finishedCarNum) {
		this.finishedCarNum = finishedCarNum;
	}

	public Integer getEmpNum() {
		return empNum;
	}

	public void setEmpNum(Integer empNum) {
		this.empNum = empNum;
	}

	public Integer getTrainingNum() {
		return trainingNum;
	}

	public void setTrainingNum(Integer trainingNum) {
		this.trainingNum = trainingNum;
	}

	public String getTongBuState() {
		return tongBuState;
	}

	public void setTongBuState(String tongBuState) {
		this.tongBuState = tongBuState;
	}

	public Integer getCountTrainingByMonth() {
		return countTrainingByMonth;
	}

	public void setCountTrainingByMonth(Integer countTrainingByMonth) {
		this.countTrainingByMonth = countTrainingByMonth;
	}

	public Integer getFinishedEmpNum() {
		return finishedEmpNum;
	}

	public void setFinishedEmpNum(Integer finishedEmpNum) {
		this.finishedEmpNum = finishedEmpNum;
	}

	public Integer getUnFinishedEmpNum() {
		return unFinishedEmpNum;
	}

	public void setUnFinishedEmpNum(Integer unFinishedEmpNum) {
		this.unFinishedEmpNum = unFinishedEmpNum;
	}

	public Integer getTeamEmployeeNum() {
		return teamEmployeeNum;
	}

	public void setTeamEmployeeNum(Integer teamEmployeeNum) {
		this.teamEmployeeNum = teamEmployeeNum;
	}

	public String getYgzPermisionUser() {
		return ygzPermisionUser;
	}

	public void setYgzPermisionUser(String ygzPermisionUser) {
		this.ygzPermisionUser = ygzPermisionUser;
	}

	public String getCheckSafeFileSend() {
		return checkSafeFileSend;
	}

	public void setCheckSafeFileSend(String checkSafeFileSend) {
		this.checkSafeFileSend = checkSafeFileSend;
	}

	public Integer getUndoTask() { return undoTask;	}

	public void setUndoTask(Integer undoTask) { this.undoTask = undoTask;	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getCheckRenzhengFlag() {
		return checkRenzhengFlag;
	}

	public void setCheckRenzhengFlag(String checkRenzhengFlag) {
		this.checkRenzhengFlag = checkRenzhengFlag;
	}

	public String getUnSearchTeam() {
		return unSearchTeam;
	}

	public void setUnSearchTeam(String unSearchTeam) {
		this.unSearchTeam = unSearchTeam;
	}

	/**
	 * This variable is automatically generated by AutoGenerate for CDP.
	 * @chineseName 新的版本号
	 */
	private String newVersion;

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回默认主键
	 * @return 默认主键
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回序列号
	 * @return 序列号
	 */
	public Integer getOrderNumber() {
		return orderNumber;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回创建人姓名
	 * @return 创建人姓名
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回创建人ID
	 * @return 创建人ID
	 */
	public String getCreateUserId() {
		return createUserId;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回创建时间
	 * @return 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回创建时间
	 * @return 创建时间
	 */

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回操作人
	 * @return 操作人
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回操作时间
	 * @return 操作时间
	 */
	public Date getOperateTime() {
		return operateTime;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回操作时间
	 * @return 操作时间
	 */

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回版本号
	 * @return 版本号
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回数据状态
	 * @return 数据状态
	 */
	public String getDataState() {
		return dataState;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回车队名
	 * @return 车队名
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回省id
	 * @return 省id
	 */
	public String getProvinceId() {
		return provinceId;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回省名
	 * @return 省名
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回市id
	 * @return 市id
	 */
	public String getCityId() {
		return cityId;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回市名
	 * @return 市名
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回县区id
	 * @return 县区id
	 */
	public String getXianquId() {
		return xianquId;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回县区名
	 * @return 县区名
	 */
	public String getXianquName() {
		return xianquName;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回车队汽车总数
	 * @return 车队汽车总数
	 */
	public Integer getCarCount() {
		return carCount;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回车队管理用户主键
	 * @return 车队管理用户主键
	 */
	public String getTeamAdminId() {
		return teamAdminId;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回车队管理账号
	 * @return 车队管理账号
	 */
	public String getTeamAdminCode() {
		return teamAdminCode;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回车队管理联系电话
	 * @return 车队管理联系电话
	 */
	public String getTeamAdminPhone() {
		return teamAdminPhone;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>返回新的版本号
	 * @return 新的版本号
	 */
	public String getNewVersion() {
		return newVersion;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置默认主键
	 * @param id 默认主键
	 */
	public void setId(String id) {
		if (id != null) {
			this.id = id.trim();
		} else {
			this.id = id;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置序列号
	 * @param orderNumber 序列号
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置创建人姓名
	 * @param createUserName 创建人姓名
	 */
	public void setCreateUserName(String createUserName) {
		if (createUserName != null) {
			this.createUserName = createUserName.trim();
		} else {
			this.createUserName = createUserName;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置创建人ID
	 * @param createUserId 创建人ID
	 */
	public void setCreateUserId(String createUserId) {
		if (createUserId != null) {
			this.createUserId = createUserId.trim();
		} else {
			this.createUserId = createUserId;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置创建时间
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置操作人
	 * @param operator 操作人
	 */
	public void setOperator(String operator) {
		if (operator != null) {
			this.operator = operator.trim();
		} else {
			this.operator = operator;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置操作时间
	 * @param operateTime 操作时间
	 */
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置版本号
	 * @param version 版本号
	 */
	public void setVersion(String version) {
		if (version != null) {
			this.version = version.trim();
		} else {
			this.version = version;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置数据状态
	 * @param dataState 数据状态
	 */
	public void setDataState(String dataState) {
		if (dataState != null) {
			this.dataState = dataState.trim();
		} else {
			this.dataState = dataState;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置车队名
	 * @param teamName 车队名
	 */
	public void setTeamName(String teamName) {
		if (teamName != null) {
			this.teamName = teamName.trim();
		} else {
			this.teamName = teamName;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置省id
	 * @param provinceId 省id
	 */
	public void setProvinceId(String provinceId) {
		if (provinceId != null) {
			this.provinceId = provinceId.trim();
		} else {
			this.provinceId = provinceId;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置省名
	 * @param provinceName 省名
	 */
	public void setProvinceName(String provinceName) {
		if (provinceName != null) {
			this.provinceName = provinceName.trim();
		} else {
			this.provinceName = provinceName;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置市id
	 * @param cityId 市id
	 */
	public void setCityId(String cityId) {
		if (cityId != null) {
			this.cityId = cityId.trim();
		} else {
			this.cityId = cityId;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置市名
	 * @param cityName 市名
	 */
	public void setCityName(String cityName) {
		if (cityName != null) {
			this.cityName = cityName.trim();
		} else {
			this.cityName = cityName;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置县区id
	 * @param xianquId 县区id
	 */
	public void setXianquId(String xianquId) {
		if (xianquId != null) {
			this.xianquId = xianquId.trim();
		} else {
			this.xianquId = xianquId;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置县区名
	 * @param xianquName 县区名
	 */
	public void setXianquName(String xianquName) {
		if (xianquName != null) {
			this.xianquName = xianquName.trim();
		} else {
			this.xianquName = xianquName;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置车队汽车总数
	 * @param carCount 车队汽车总数
	 */
	public void setCarCount(Integer carCount) {
		this.carCount = carCount;
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置车队管理用户主键
	 * @param teamAdminId 车队管理用户主键
	 */
	public void setTeamAdminId(String teamAdminId) {
		if (teamAdminId != null) {
			this.teamAdminId = teamAdminId.trim();
		} else {
			this.teamAdminId = teamAdminId;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置车队管理账号
	 * @param teamAdminCode 车队管理账号
	 */
	public void setTeamAdminCode(String teamAdminCode) {
		if (teamAdminCode != null) {
			this.teamAdminCode = teamAdminCode.trim();
		} else {
			this.teamAdminCode = teamAdminCode;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置车队管理联系电话
	 * @param teamAdminPhone 车队管理联系电话
	 */
	public void setTeamAdminPhone(String teamAdminPhone) {
		if (teamAdminPhone != null) {
			this.teamAdminPhone = teamAdminPhone.trim();
		} else {
			this.teamAdminPhone = teamAdminPhone;
		}
	}

	/**
	 * This method is automatically generated by AutoGenerate for CDP.
	 * <p>设置新的版本号
	 * @param newVersion 新的版本号
	 */
	public void setNewVersion(String newVersion) {
		if (newVersion != null) {
			this.newVersion = newVersion.trim();
		} else {
			this.newVersion = newVersion;
		}
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTeamAdminName() {
		return teamAdminName;
	}

	public void setTeamAdminName(String teamAdminName) {
		this.teamAdminName = teamAdminName;
	}

	public String getTeamType() {
		return teamType;
	}

	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}

	public String getCheckPhoneFlag() {
		return checkPhoneFlag;
	}

	public void setCheckPhoneFlag(String checkPhoneFlag) {
		this.checkPhoneFlag = checkPhoneFlag;
	}

	public String getLicenceAuthority() {
		return licenceAuthority;
	}

	public void setLicenceAuthority(String licenceAuthority) {
		this.licenceAuthority = licenceAuthority;
	}

	public Date getExaCheckDate() {
		return exaCheckDate;
	}

	public void setExaCheckDate(Date exaCheckDate) {
		this.exaCheckDate = exaCheckDate;
	}

	public String getBusinessCert() {
		return businessCert;
	}

	public void setBusinessCert(String businessCert) {
		this.businessCert = businessCert;
	}

	public String getJyCertNumber() {
		return jyCertNumber;
	}

	public void setJyCertNumber(String jyCertNumber) {
		this.jyCertNumber = jyCertNumber;
	}

	public String getJyCertImageSrc() {
		return jyCertImageSrc;
	}

	public void setJyCertImageSrc(String jyCertImageSrc) {
		this.jyCertImageSrc = jyCertImageSrc;
	}

	public String getJyScope() {
		return jyScope;
	}

	public void setJyScope(String jyScope) {
		this.jyScope = jyScope;
	}

	public String getBusinessCertCode() {
		return businessCertCode;
	}

	public void setBusinessCertCode(String businessCertCode) {
		this.businessCertCode = businessCertCode;
	}

	public String getBusinessCertImageSrc() {
		return businessCertImageSrc;
	}

	public void setBusinessCertImageSrc(String businessCertImageSrc) {
		this.businessCertImageSrc = businessCertImageSrc;
	}

	public String getJyManName() {
		return jyManName;
	}

	public void setJyManName(String jyManName) {
		this.jyManName = jyManName;
	}

	public String getLegalRepresentName() {
		return legalRepresentName;
	}

	public void setLegalRepresentName(String legalRepresentName) {
		this.legalRepresentName = legalRepresentName;
	}

	public String getJyLicenceType() {
		return jyLicenceType;
	}

	public void setJyLicenceType(String jyLicenceType) {
		this.jyLicenceType = jyLicenceType;
	}

	public String getJyChargeManPhone() {
		return jyChargeManPhone;
	}

	public void setJyChargeManPhone(String jyChargeManPhone) {
		this.jyChargeManPhone = jyChargeManPhone;
	}

	public String getJyManNameBookImageSrc() {
		return jyManNameBookImageSrc;
	}

	public void setJyManNameBookImageSrc(String jyManNameBookImageSrc) {
		this.jyManNameBookImageSrc = jyManNameBookImageSrc;
	}

	public String getQrCodeImageSrc() {
		return qrCodeImageSrc;
	}

	public void setQrCodeImageSrc(String qrCodeImageSrc) {
		this.qrCodeImageSrc = qrCodeImageSrc;
	}

	public String getCarAmount() {
		return carAmount;
	}

	public void setCarAmount(String carAmount) {
		this.carAmount = carAmount;
	}

	public String getLicenseSendReason() {
		return licenseSendReason;
	}

	public void setLicenseSendReason(String licenseSendReason) {
		this.licenseSendReason = licenseSendReason;
	}

	public String getAdministrator() {
		return administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}

	public Date getLicenseValidDate() {
		return licenseValidDate;
	}

	public void setLicenseValidDate(Date licenseValidDate) {
		this.licenseValidDate = licenseValidDate;
	}

	public String getEscortManName() {
		return escortManName;
	}

	public void setEscortManName(String escortManName) {
		this.escortManName = escortManName;
	}

	public String getCheckedState() {
		return checkedState;
	}

	public void setCheckedState(String checkedState) {
		this.checkedState = checkedState;
	}

	public Date getTaxationSendDate() {
		return taxationSendDate;
	}

	public void setTaxationSendDate(Date taxationSendDate) {
		this.taxationSendDate = taxationSendDate;
	}

	public Date getTaxationChangeDate() {
		return taxationChangeDate;
	}

	public void setTaxationChangeDate(Date taxationChangeDate) {
		this.taxationChangeDate = taxationChangeDate;
	}

	public String getGcAmount() {
		return gcAmount;
	}

	public void setGcAmount(String gcAmount) {
		this.gcAmount = gcAmount;
	}

	public String getWshsFacilityCase() {
		return wshsFacilityCase;
	}

	public void setWshsFacilityCase(String wshsFacilityCase) {
		this.wshsFacilityCase = wshsFacilityCase;
	}

	public String getZyqxFacilityCase() {
		return zyqxFacilityCase;
	}

	public void setZyqxFacilityCase(String zyqxFacilityCase) {
		this.zyqxFacilityCase = zyqxFacilityCase;
	}

	public String getAqfhFacilityCase() {
		return aqfhFacilityCase;
	}

	public void setAqfhFacilityCase(String aqfhFacilityCase) {
		this.aqfhFacilityCase = aqfhFacilityCase;
	}

	public String getUnsafeDriverName() {
		return unsafeDriverName;
	}

	public void setUnsafeDriverName(String unsafeDriverName) {
		this.unsafeDriverName = unsafeDriverName;
	}

	public String getCarSumTon() {
		return carSumTon;
	}

	public void setCarSumTon(String carSumTon) {
		this.carSumTon = carSumTon;
	}

	public String getParkSumArea() {
		return parkSumArea;
	}

	public void setParkSumArea(String parkSumArea) {
		this.parkSumArea = parkSumArea;
	}

	public String getEconomicType() {
		return economicType;
	}

	public void setEconomicType(String economicType) {
		this.economicType = economicType;
	}

	public String getBusinessCertImage() {
		return businessCertImage;
	}

	public void setBusinessCertImage(String businessCertImage) {
		this.businessCertImage = businessCertImage;
	}

	public String getLegalRepresentLicenceType() {
		return legalRepresentLicenceType;
	}

	public void setLegalRepresentLicenceType(String legalRepresentLicenceType) {
		this.legalRepresentLicenceType = legalRepresentLicenceType;
	}

	public String getCheckInstitution() {
		return checkInstitution;
	}

	public void setCheckInstitution(String checkInstitution) {
		this.checkInstitution = checkInstitution;
	}

	public String getTeamPhoneNumber() {
		return teamPhoneNumber;
	}

	public void setTeamPhoneNumber(String teamPhoneNumber) {
		this.teamPhoneNumber = teamPhoneNumber;
	}

	public String getTeamTelephone() {
		return teamTelephone;
	}

	public void setTeamTelephone(String teamTelephone) {
		this.teamTelephone = teamTelephone;
	}

	public String getTeamEmail() {
		return teamEmail;
	}

	public void setTeamEmail(String teamEmail) {
		this.teamEmail = teamEmail;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getTeamAddress() {
		return teamAddress;
	}

	public void setTeamAddress(String teamAddress) {
		this.teamAddress = teamAddress;
	}

	public Date getAssessDate() {
		return assessDate;
	}

	public void setAssessDate(Date assessDate) {
		this.assessDate = assessDate;
	}

	public String getInstituFrameNumber() {
		return instituFrameNumber;
	}

	public void setInstituFrameNumber(String instituFrameNumber) {
		this.instituFrameNumber = instituFrameNumber;
	}

	public String getLandTaxNumber() {
		return landTaxNumber;
	}

	public void setLandTaxNumber(String landTaxNumber) {
		this.landTaxNumber = landTaxNumber;
	}

	public String getBusinessLicenseNumber() {
		return businessLicenseNumber;
	}

	public void setBusinessLicenseNumber(String businessLicenseNumber) {
		this.businessLicenseNumber = businessLicenseNumber;
	}

	public String getResidenceInstitution() {
		return residenceInstitution;
	}

	public void setResidenceInstitution(String residenceInstitution) {
		this.residenceInstitution = residenceInstitution;
	}

	public String getCompanyLevel() {
		return companyLevel;
	}

	public void setCompanyLevel(String companyLevel) {
		this.companyLevel = companyLevel;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getZlXyCheckedResult() {
		return zlXyCheckedResult;
	}

	public void setZlXyCheckedResult(String zlXyCheckedResult) {
		this.zlXyCheckedResult = zlXyCheckedResult;
	}

	public String getMngAnquanZerenPhoto() {
		return mngAnquanZerenPhoto;
	}

	public void setMngAnquanZerenPhoto(String mngAnquanZerenPhoto) {
		this.mngAnquanZerenPhoto = mngAnquanZerenPhoto;
	}

	public String getCongyeAnquanZerenPhoto() {
		return congyeAnquanZerenPhoto;
	}

	public void setCongyeAnquanZerenPhoto(String congyeAnquanZerenPhoto) {
		this.congyeAnquanZerenPhoto = congyeAnquanZerenPhoto;
	}

	public String getAnquanScCheckZdPhoto() {
		return anquanScCheckZdPhoto;
	}

	public void setAnquanScCheckZdPhoto(String anquanScCheckZdPhoto) {
		this.anquanScCheckZdPhoto = anquanScCheckZdPhoto;
	}

	public String getAnquanScEduZdPhoto() {
		return anquanScEduZdPhoto;
	}

	public void setAnquanScEduZdPhoto(String anquanScEduZdPhoto) {
		this.anquanScEduZdPhoto = anquanScEduZdPhoto;
	}

	public String getAnquanMngZdPhoto() {
		return anquanMngZdPhoto;
	}

	public void setAnquanMngZdPhoto(String anquanMngZdPhoto) {
		this.anquanMngZdPhoto = anquanMngZdPhoto;
	}

	public String getYingjiYuanZdPhoto() {
		return yingjiYuanZdPhoto;
	}

	public void setYingjiYuanZdPhoto(String yingjiYuanZdPhoto) {
		this.yingjiYuanZdPhoto = yingjiYuanZdPhoto;
	}

	public String getAnquanScGuichengPhoto() {
		return anquanScGuichengPhoto;
	}

	public void setAnquanScGuichengPhoto(String anquanScGuichengPhoto) {
		this.anquanScGuichengPhoto = anquanScGuichengPhoto;
	}

	public String getAnquanScKhZdPhoto() {
		return anquanScKhZdPhoto;
	}

	public void setAnquanScKhZdPhoto(String anquanScKhZdPhoto) {
		this.anquanScKhZdPhoto = anquanScKhZdPhoto;
	}

	public String getAnquanSgclZdPhoto() {
		return anquanSgclZdPhoto;
	}

	public void setAnquanSgclZdPhoto(String anquanSgclZdPhoto) {
		this.anquanSgclZdPhoto = anquanSgclZdPhoto;
	}

	public String getBiaozhunLavel() {
		return biaozhunLavel;
	}

	public void setBiaozhunLavel(String biaozhunLavel) {
		this.biaozhunLavel = biaozhunLavel;
	}

	public String getBiaozhunPhoto() {
		return biaozhunPhoto;
	}

	public void setBiaozhunPhoto(String biaozhunPhoto) {
		this.biaozhunPhoto = biaozhunPhoto;
	}

	public Date getZhengshuEndDate() {
		return zhengshuEndDate;
	}

	public void setZhengshuEndDate(Date zhengshuEndDate) {
		this.zhengshuEndDate = zhengshuEndDate;
	}

	public String getCdghPhoto() {
		return cdghPhoto;
	}

	public void setCdghPhoto(String cdghPhoto) {
		this.cdghPhoto = cdghPhoto;
	}

	public String getXfsPhoto() {
		return xfsPhoto;
	}

	public void setXfsPhoto(String xfsPhoto) {
		this.xfsPhoto = xfsPhoto;
	}

	public String getXfqiuPhoto() {
		return xfqiuPhoto;
	}

	public void setXfqiuPhoto(String xfqiuPhoto) {
		this.xfqiuPhoto = xfqiuPhoto;
	}

	public String getMhqPhoto() {
		return mhqPhoto;
	}

	public void setMhqPhoto(String mhqPhoto) {
		this.mhqPhoto = mhqPhoto;
	}

	public String getChangdiPhoto() {
		return changdiPhoto;
	}

	public void setChangdiPhoto(String changdiPhoto) {
		this.changdiPhoto = changdiPhoto;
	}

	public String getChangdiweizhi() {
		return changdiweizhi;
	}

	public void setChangdiweizhi(String changdiweizhi) {
		this.changdiweizhi = changdiweizhi;
	}

	public String getMoneyzdPhoto() {
		return moneyzdPhoto;
	}

	public void setMoneyzdPhoto(String moneyzdPhoto) {
		this.moneyzdPhoto = moneyzdPhoto;
	}
	public Integer getCountLedgerType() {
		return countLedgerType;
	}

			public void setCountLedgerType(Integer countLedgerType) {
			this.countLedgerType = countLedgerType;
		}

	public String getCyryaqglZd() {
		return cyryaqglZd;
	}

	public void setCyryaqglZd(String cyryaqglZd) {
		this.cyryaqglZd = cyryaqglZd;
	}

	public String getAqsgbglZd() {
		return aqsgbglZd;
	}

	public void setAqsgbglZd(String aqsgbglZd) {
		this.aqsgbglZd = aqsgbglZd;
	}

	public String getAqyhzgZd() {
		return aqyhzgZd;
	}

	public void setAqyhzgZd(String aqyhzgZd) {
		this.aqyhzgZd = aqyhzgZd;
	}

	public String getGsxcabZd() {
		return gsxcabZd;
	}

	public void setGsxcabZd(String gsxcabZd) {
		this.gsxcabZd = gsxcabZd;
	}

	public String getLhZd() {
		return lhZd;
	}

	public void setLhZd(String lhZd) {
		this.lhZd = lhZd;
	}

	public String getAjjWlswdw() {
		return ajjWlswdw;
	}

	public void setAjjWlswdw(String ajjWlswdw) {
		this.ajjWlswdw = ajjWlswdw;
	}

	public String getAjjJtgd() {
		return ajjJtgd;
	}

	public void setAjjJtgd(String ajjJtgd) {
		this.ajjJtgd = ajjJtgd;
	}

	public String getHwslhjysZd() {
		return hwslhjysZd;
	}

	public void setHwslhjysZd(String hwslhjysZd) {
		this.hwslhjysZd = hwslhjysZd;
	}

	public String getTzglZd() {
		return tzglZd;
	}

	public void setTzglZd(String tzglZd) {
		this.tzglZd = tzglZd;
	}

	public String getGsZd() {
		return gsZd;
	}

	public void setGsZd(String gsZd) {
		this.gsZd = gsZd;
	}

	public static String getTableAlias() {
		return TABLE_ALIAS;
	}

	public String getFzraqsczrZd() {
		return FzraqsczrZd;
	}

	public void setFzraqsczrZd(String fzraqsczrZd) {
		FzraqsczrZd = fzraqsczrZd;
	}

	public String getCyryaqsczrZd() {
		return CyryaqsczrZd;
	}

	public void setCyryaqsczrZd(String cyryaqsczrZd) {
		CyryaqsczrZd = cyryaqsczrZd;
	}

	public String getAqscjypxZd() {
		return AqscjypxZd;
	}

	public void setAqscjypxZd(String aqscjypxZd) {
		AqscjypxZd = aqscjypxZd;
	}

	public String getAqsckhyjcZd() {
		return AqsckhyjcZd;
	}

	public void setAqsckhyjcZd(String aqsckhyjcZd) {
		AqsckhyjcZd = aqsckhyjcZd;
	}

	public String getAqsgbgTjyclZd() {
		return AqsgbgTjyclZd;
	}

	public void setAqsgbgTjyclZd(String aqsgbgTjyclZd) {
		AqsgbgTjyclZd = aqsgbgTjyclZd;
	}
}