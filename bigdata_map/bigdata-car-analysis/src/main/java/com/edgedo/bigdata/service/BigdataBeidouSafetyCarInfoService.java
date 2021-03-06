package com.edgedo.bigdata.service;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.mapper.BigdataBeidouSafetyCarInfoMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouSafetyCarInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouSafetyCarInfoView;
import com.edgedo.bigdata.queryvo.TransitCarInfoQuery;
import com.edgedo.common.util.Guid;
import com.edgedo.common.util.HttpRequestUtil;
import com.edgedo.common.util.ObjectUtil;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataBeidouSafetyCarInfoService {
	
	
	@Autowired
	private BigdataBeidouSafetyCarInfoMapper mapper;
	@Autowired
	private BigdataBeidouCompService bigdataBeidouCompService;
	@Autowired
	private BigdataBeidouModelService bigdataBeidouModelService;
	@Autowired
	private CarInfoService carInfoService;
	@Autowired
	private BigdataBeidouTeamInfoService bigdataBeidouTeamInfoService;
	@Value("${ReportDataUrl}")
	private String ReportDataUrl;

	
	public List<BigdataBeidouSafetyCarInfoView> listPage(BigdataBeidouSafetyCarInfoQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataBeidouSafetyCarInfo voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataBeidouSafetyCarInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataBeidouSafetyCarInfo voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public BigdataBeidouSafetyCarInfo loadById(String id) {
		return mapper.selectById(id);
	}


	/**
	 * 将发送来的主动安全车辆信息存到数据库里
	 * @param safetyCarInfoList
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateSafetyCarInfo(List<BeidouSafetyCarInfo> safetyCarInfoList, String compId) {
		//查询运营商
		BigdataBeidouComp beidouComp = bigdataBeidouCompService.loadById(compId);
		if(beidouComp==null){
			return;
		}
		/*String key = beidouComp.getSingKey();
		if(!key.equals(signKey)){
			return;
		}*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmhhss");
		for(BeidouSafetyCarInfo safetyCarInfo : safetyCarInfoList){

			BigdataBeidouSafetyCarInfo beidouSafetyCarInfo = new BigdataBeidouSafetyCarInfo();
			String carPlateNum = safetyCarInfo.getCarPlateNum();
			if(!carPlateNum.contains("冀C")){
				continue;
			}
			String carPlateColor = safetyCarInfo.getCarPlateColor();

			String reportDataUrl = ReportDataUrl+"/sys/transitCarBaseinfo/selectCarInfoByQuery.jsn";
			TransitCarInfoQuery transitCarInfoQuery = new TransitCarInfoQuery();
			transitCarInfoQuery.setCarPlateNum(carPlateNum);
			transitCarInfoQuery.setCarPlateColor(getColor(carPlateColor));
			transitCarInfoQuery.setCityId("130300");
			Map<String,String> parametersMap = ObjectUtil.objectToMapString(transitCarInfoQuery,"");
			String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parametersMap);

			BigdataBeidouTeamInfo bigdataBeidouTeamInfo = new BigdataBeidouTeamInfo();

			if(responseStr!=null && !responseStr.equals("")){
				Map map = new HashMap();
				map = ObjectUtil.jsonToMap(responseStr);
				boolean f = Boolean.parseBoolean((String) map.get("success"));
				//更新同步状态
				if(f){
					Object data = map.get("data");
					if(data!=null){
						TransitCarBaseinfo transitCarBaseinfo = JSONObject.parseObject((String) data,TransitCarBaseinfo.class);
						beidouSafetyCarInfo.setTeamId(transitCarBaseinfo.getOwnerCarTeamId());
						beidouSafetyCarInfo.setTeamName(transitCarBaseinfo.getOwnerCarTeamName());
						beidouSafetyCarInfo.setProvinceId(transitCarBaseinfo.getProvinceId());
						beidouSafetyCarInfo.setProvinceName(transitCarBaseinfo.getProvinceName());
						beidouSafetyCarInfo.setCityId(transitCarBaseinfo.getCityId());
						beidouSafetyCarInfo.setCityName(transitCarBaseinfo.getCityName());
						beidouSafetyCarInfo.setXianquId(transitCarBaseinfo.getXianquId());
						beidouSafetyCarInfo.setXianquName(transitCarBaseinfo.getXianquName());
						beidouSafetyCarInfo.setCarFrameNum(transitCarBaseinfo.getCarFrameNum());
						//查询企业
						TransitCarTeamQuery query = new TransitCarTeamQuery();
						String reportDataUrl1 = ReportDataUrl+"/sys/carTeam/selectTransitCarTeamInfo.jsn";
						query.setTeamId(transitCarBaseinfo.getOwnerCarTeamId());
						query.setCityId("130300");
						Map<String,String> parameterMap1 = ObjectUtil.objectToMapString(query,"");
						String responseStr1 = HttpRequestUtil.sendPostRequest(reportDataUrl1,parameterMap1);
						org.json.JSONObject jsonObject = new org.json.JSONObject(responseStr1);
						JSONArray jsonArray = jsonObject.optJSONArray("list");
						org.json.JSONObject jsonObject1 = jsonArray.optJSONObject(0);
						if(jsonObject1!=null){
							String companyLevel = jsonObject1.optString("companyLevel");
							String provinceId = jsonObject1.optString("provinceId");
							String provinceName = jsonObject1.optString("provinceName");
							String cityId = jsonObject1.optString("cityId");
							String cityName = jsonObject1.optString("cityName");
							String xianquId = jsonObject1.optString("xianquId");
							String xianquName = jsonObject1.optString("xianquName");
							bigdataBeidouTeamInfo.setProvinceId(provinceId);
							bigdataBeidouTeamInfo.setProvinceName(provinceName);
							bigdataBeidouTeamInfo.setCityId(cityId);
							bigdataBeidouTeamInfo.setCityName(cityName);
							bigdataBeidouTeamInfo.setXianquId(xianquId);
							bigdataBeidouTeamInfo.setXianquName(xianquName);
							bigdataBeidouTeamInfo.setTeamType(companyLevel);
							beidouSafetyCarInfo.setCarType(getCarType(companyLevel));
						}else {
							continue;
						}
					}else {
						System.out.println("车牌号："+carPlateNum+"找不到");
						continue;
					}
				}
			}
			//车辆类型
			String  carType = beidouSafetyCarInfo.getCarType();
			String compCarType = beidouComp.getCompCarType();
			if(!compCarType.equals("*") && !compCarType.contains(carType)){
				continue;
			}
			boolean modelFlag = false;
			//获取设备型号
			/*String modelCode = safetyCarInfo.getModelCode();
			String manufacturerId = safetyCarInfo.getManufacturerId();
			//获取企业关联的设备的型号
			List<BigdataBeidouModel> bigdataBeidouModelList = bigdataBeidouModelService.getByCompId(compId);
			for(BigdataBeidouModel model:bigdataBeidouModelList){
				if (model.getModelCode().equals(modelCode) && manufacturerId.equals(model.getManufacturerId())){
					if(!model.getCarType().equals("*") && !model.getCarType().contains(carType)){
						modelFlag = false;
					}else {
						modelFlag = true;
					}
				}
			}
			if(!modelFlag){
				continue;
			}*/
			String installTimeStr = safetyCarInfo.getInstallTime();
			if(installTimeStr!=null && installTimeStr.length()>0){
				try {
					Date installTime = sdf.parse(installTimeStr);
					beidouSafetyCarInfo.setInstallTime(installTime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				beidouSafetyCarInfo.setInstallTime(new Date());
			}

			beidouSafetyCarInfo.setCreateTime(new Date());
			beidouSafetyCarInfo.setUpdateTime(new Date());
			beidouSafetyCarInfo.setUploadTime(new Date());
			beidouSafetyCarInfo.setCompId(beidouComp.getId());
			beidouSafetyCarInfo.setCompName(beidouComp.getCompName());
			beidouSafetyCarInfo.setCarPlateNum(carPlateNum);
			beidouSafetyCarInfo.setCarPlateColor(carPlateColor);
			beidouSafetyCarInfo.setModelCode(safetyCarInfo.getModelCode());
			beidouSafetyCarInfo.setChannelEnable(safetyCarInfo.getChannelEnable());
			beidouSafetyCarInfo.setChannelNum(safetyCarInfo.getChannelNum());
			beidouSafetyCarInfo.setManufacturerName(safetyCarInfo.getManufacturerName());
			beidouSafetyCarInfo.setManufacturerId(safetyCarInfo.getManufacturerId());
			beidouSafetyCarInfo.setModelId(safetyCarInfo.getModelId());
			beidouSafetyCarInfo.setSim(safetyCarInfo.getSim());
			beidouSafetyCarInfo.setDsmId(safetyCarInfo.getDsmId());
			beidouSafetyCarInfo.setAdasId(safetyCarInfo.getAdasId());
			beidouSafetyCarInfo.setProtocol(safetyCarInfo.getProtocol());
			String deviceType = changeProtocalToRuimingDeviceType(safetyCarInfo.getProtocol());
			beidouSafetyCarInfo.setDeviceType(deviceType);
			beidouSafetyCarInfo.setId(Guid.guid());
			if(installTimeStr==null || installTimeStr.length()>0){
				int count = mapper.countByCarPlateNumAndColor(beidouSafetyCarInfo);
				if(count>0){
					mapper.updateByCarPlateNumAndColor(beidouSafetyCarInfo);
				}else{
					mapper.insert(beidouSafetyCarInfo);
				}
				//更新car_info的数据
				CarInfo carInfo = new CarInfo();
				carInfo.setCarPlateNum(beidouSafetyCarInfo.getCarPlateNum());
				carInfo.setCarPlateColour(beidouSafetyCarInfo.getCarPlateColor());
				carInfo.setCarPlateColorText(CarInfoService.genCarPlateColorTextFromCode(beidouSafetyCarInfo.getCarPlateColor()));
				carInfo.setCarFrameNum(beidouSafetyCarInfo.getCarFrameNum());
				carInfo.setOwnerTeamId(beidouSafetyCarInfo.getTeamId());
				carInfo.setOwnerTeamName(beidouSafetyCarInfo.getTeamName());
				carInfo.setBeidouOperator(beidouSafetyCarInfo.getCompName());
				carInfo.setComId(beidouSafetyCarInfo.getCompId());
				carInfo.setComName(beidouSafetyCarInfo.getCompName());
				carInfoService.insertOrUpdate(carInfo);
				//更新车队信息
				bigdataBeidouTeamInfo.setId(carInfo.getOwnerTeamId());
				bigdataBeidouTeamInfo.setTeamName(carInfo.getOwnerTeamName());
				if(carInfo.getOwnerTeamId()!=null && !carInfo.getOwnerTeamId().equals("")){
					bigdataBeidouTeamInfoService.insertOrUpdate(bigdataBeidouTeamInfo);
				}
			}
		}
	}


	/**
	 * 将协议编码替换成瑞明前端需要的设备类型
	 * @param protocol
	 * @return
	 */
	private String changeProtocalToRuimingDeviceType(String protocol) {
//		23:mdvr设备（暂时不支持）,124:n9m设备,200:808设备,201:905设备,202:1078设备
		switch (protocol){
			case "mdvr":return "23";
			case "n9m":return "124";
			case "808":return "200";
			case "905":return "201";
			case "1078":return "202";
		}
		return protocol;
	}

	//将传入的809 车牌颜色转成智慧运管的颜色代码
	public String getColor(String color){
		if(color.equals("2")){
			return "2";
		}else if(color.equals("1")){
			return "3";
		}else {
			return "7";
		}
	}
	//获取车辆类型
	public String getCarType(String companyLevel){
		if(companyLevel.equals("TEAM_KY")){
			return "客运";
		}
		if(companyLevel.equals("TEAM_WXHWYS")){
			return "危货";
		}
		return "普货";
	}



	public BigdataBeidouSafetyCarInfo selectByCarPlateNumAndColor(BigdataBeidouSafetyCarInfo beidouSafetyCarInfo) {
		return mapper.selectByCarPlateNumAndColor(beidouSafetyCarInfo);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateByCarPlateNum(BigdataBeidouSafetyCarInfo beidouSafetyCarInfo) {
		BigdataBeidouSafetyCarInfo beidouSafetyCarInfo1 = selectByCarPlateNumAndColor(beidouSafetyCarInfo);
		if(beidouSafetyCarInfo1!=null){
			beidouSafetyCarInfo1.setUpdateTime(beidouSafetyCarInfo.getUpdateTime());
			beidouSafetyCarInfo1.setAltitude(beidouSafetyCarInfo.getAltitude());
			beidouSafetyCarInfo1.setLon(beidouSafetyCarInfo.getLon());
			beidouSafetyCarInfo1.setLat(beidouSafetyCarInfo.getLat());
			beidouSafetyCarInfo1.setMileage(beidouSafetyCarInfo.getMileage());
			beidouSafetyCarInfo1.setState(beidouSafetyCarInfo.getState());
			beidouSafetyCarInfo1.setStateDesc(beidouSafetyCarInfo.getStateDesc());
			beidouSafetyCarInfo1.setDirection(beidouSafetyCarInfo.getDirection());
			beidouSafetyCarInfo1.setAlarm(beidouSafetyCarInfo.getAlarm());
			beidouSafetyCarInfo1.setSpeed(beidouSafetyCarInfo.getSpeed());
			update(beidouSafetyCarInfo1);
		}
	}
}
