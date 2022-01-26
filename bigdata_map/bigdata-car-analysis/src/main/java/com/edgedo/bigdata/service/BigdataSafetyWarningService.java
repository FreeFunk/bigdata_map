package com.edgedo.bigdata.service;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.mapper.BigdataAlarmRecordMapper;
import com.edgedo.bigdata.mapper.BigdataSafetyWarningMapper;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningQuery;
import com.edgedo.common.util.Guid;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataSafetyWarningService {

	Map<String,String> warnTypeMap = new HashMap<String,String>();
	{
		//主动安全
		warnTypeMap.put("180","前向碰撞预警");
		warnTypeMap.put("181","车辆偏离预警");
		warnTypeMap.put("182","车距过近预警");
		warnTypeMap.put("184","行人碰撞报警");
		warnTypeMap.put("186","疲劳驾驶报警");
		warnTypeMap.put("187","接打电话报警");
		warnTypeMap.put("188","抽烟报警");
		warnTypeMap.put("189","注意力分散报警");
		warnTypeMap.put("190","异常报警");
		//分段限速（超速，疲劳）
		warnTypeMap.put("14","超速预警");
		warnTypeMap.put("49","平台超速报警");
		warnTypeMap.put("39","平台超速报警");
		warnTypeMap.put("41","平台疲劳驾驶报警");
		warnTypeMap.put("3","疲劳驾驶");
	}
	
	@Autowired
	private BigdataSafetyWarningMapper mapper;
	@Autowired
	private CarInfoService carInfoService;
	@Autowired
	private BigdataBeidouCompService beidouCompService;
	@Autowired
	private BigdataBeidouSafetyCarInfoService bigdataBeidouSafetyCarInfoService;
	@Autowired
	private BigdataAlarmRecordMapper bigdataAlarmRecordMapper;
	@Autowired
	private BigdataAlarmRecordService bigdataAlarmRecordService;

	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataSafetyWarning voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}

	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insertNew(BigdataSafetyWarning voObj) {
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataSafetyWarning voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataSafetyWarning voObj) {
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
	public BigdataSafetyWarning loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 将发送来的主动安全报警存到数据库里
	 * @param alarmList
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateAccepAlarms(List<BeidouProactiveSecurityAlarm1> alarmList,String userId,String userkey) {
		//查询运营商
		BigdataBeidouComp beidouComp = null;
		if(userId!=null && userId.equals("200000")){
			userId= "10001";
			beidouComp = beidouCompService.loadById(userId);
			if(beidouComp==null){
				return;
			}
		}else {
			beidouComp = beidouCompService.loadById(userId);
			if(beidouComp==null){
				return;
			}
			String key = beidouComp.getSingKey();
			if(!key.equals(userkey)){
				return;
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		for(BeidouProactiveSecurityAlarm1 safeAlarm : alarmList){

			BigdataSafetyWarning warning = new BigdataSafetyWarning();
			warning.setAlarmState(safeAlarm.getAlarmstate());
			warning.setBid(safeAlarm.getAlarmid());
			String carPlateNum = safeAlarm.getVehicle_no();
			warning.setCarPlateNum(carPlateNum);
			String plateColor = safeAlarm.getVehicle_color();
			warning.setCarPlateColorText(plateColor);
			//车牌颜色代码
			String colorCode = CarInfoService.genCarPlateColorCodeFromText(plateColor);
			warning.setCarPlateColor(colorCode);
			String carId = carPlateNum + "_" + colorCode;
			//查询车架号
			CarInfo carInfo = carInfoService.loadById(carId);
			if(carInfo!=null){
				warning.setCarFrameNum(carInfo.getCarFrameNum());
				warning.setCarType(carInfo.getCarType());
				warning.setEmpCode(carInfo.getEmpCode());
				warning.setEmpIdCard(carInfo.getEmpCode());
				warning.setEmpName(carInfo.getEmpName());
				warning.setEmpId(carInfo.getEmpId());
				warning.setOwnerTeamId(carInfo.getOwnerTeamId());
				warning.setOwnerTeamName(carInfo.getOwnerTeamName());
				warning.setProvinceId(carInfo.getProvinceId());
				warning.setProvinceName(carInfo.getProvinceName());
				warning.setCityId(carInfo.getCityId());
				warning.setCityName(carInfo.getCityName());
				warning.setXianquId(carInfo.getXianquId());
				warning.setXianquName(carInfo.getXianquName());
			}
			warning.setCompId(beidouComp.getId());
			warning.setCompName(beidouComp.getCompName());

			String starttimeStr = safeAlarm.getStarttime();
			if(starttimeStr!=null && starttimeStr.length()>0){
				try {
					Date starttime = sdf.parse(starttimeStr);
					String startDay = starttimeStr.substring(0,8);
					Integer countDate = new Integer(startDay);
					warning.setCountDate(countDate);
					warning.setCountMonth(countDate/100);
					warning.setStarttime(starttime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			warning.setCreateTime(new Date());
			warning.setDeviceno(safeAlarm.getDeviceno());
			Double direction = safeAlarm.getDirection();
			if(direction!=null){
				warning.setDirection(new BigDecimal(direction));
			}
			String endtimeStr = safeAlarm.getEndtime();
			if(endtimeStr!=null && endtimeStr.length()>0){
				try {
					Date endtime = sdf.parse(endtimeStr);
					warning.setEndtime(endtime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			//处理结果描述
			warning.setDetailInfo(safeAlarm.getHandledesc());
			warning.setHandlePeople(safeAlarm.getHandlepeople());
			warning.setHandleState(safeAlarm.getHandlestate());
			warning.setHandleType(safeAlarm.getHandlemethod());
			String handleTimeStr = safeAlarm.getHandletime();
			if(handleTimeStr!=null && handleTimeStr.length()>0){
				try {
					Date handleTime = sdf.parse(handleTimeStr);
					warning.setHandleTime(handleTime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			Double lat = safeAlarm.getLat();
			if(lat!=null){
				warning.setLat( new BigDecimal(lat));
			}
			Double lon = safeAlarm.getLon();
			if(lon!=null){
				warning.setLon(new BigDecimal(lon));
			}
			warning.setSim(safeAlarm.getSim());
			Double speed = safeAlarm.getSpeed();
			if(speed!=null){
				warning.setSpeed(new BigDecimal(speed));
			}
			warning.setUploadTime(new Date());
			warning.setWarningInfo(safeAlarm.getWarn_content());
			Integer warnType = safeAlarm.getWarn_type();
			String warningType = warnTypeMap.get(warnType+"");
			String handlestate = safeAlarm.getHandlestate();
			if(handlestate!=null && !handlestate.equals("已处理")){
				if(warningType==null || warningType.equals("")){
					continue;
				}
			}
			warning.setWarningType(warningType);
			//报警等级 低于50一级 高于50二级
			if(speed!=null){
				if(speed>50){
					warning.setWarningLevel("2");
				}else{
					warning.setWarningLevel("1");
				}

			}else{
				warning.setWarningLevel("1");
			}
			String id = userId + "_" + warning.getBid();
			warning.setId(id);
			if(starttimeStr!=null && starttimeStr.length()>0){
				int count = mapper.countById(warning);
				if(count==0){
					//如果是疲劳或者超速报警同时插入alarm表
					if(warningType.contains("平台超速报警") || warningType.equals("疲劳驾驶")  || warningType.equals("平台疲劳驾驶报警") || warningType.equals("超速预警") ){
						BigdataAlarmRecord bigdataAlarmRecord = new BigdataAlarmRecord();
						bigdataAlarmRecord.setId(warning.getId());
						bigdataAlarmRecord.setBid(warning.getBid());
						bigdataAlarmRecord.setCompId(warning.getCompId());
						bigdataAlarmRecord.setCompName(warning.getCompName());
						bigdataAlarmRecord.setTeamId(warning.getOwnerTeamId());
						bigdataAlarmRecord.setTeamName(warning.getOwnerTeamName());
						bigdataAlarmRecord.setCreateTime(new Date());
						bigdataAlarmRecord.setCarPlateNum(warning.getCarPlateNum());
						bigdataAlarmRecord.setCarPlateColor(warning.getCarPlateColor());
						bigdataAlarmRecord.setCarType(warning.getCarType());
						bigdataAlarmRecord.setSimCode(warning.getSim());
						if(warningType.contains("超速")){
							bigdataAlarmRecord.setAlarmCls("1");
							bigdataAlarmRecord.setAlarmType("2");
						}
						if(warningType.contains("疲劳")){
							bigdataAlarmRecord.setAlarmCls("2");
							bigdataAlarmRecord.setAlarmType("4");
						}
						bigdataAlarmRecord.setAlarmTime(warning.getStarttime());
						bigdataAlarmRecord.setDriver(warning.getDriverName());
						bigdataAlarmRecord.setLatitude(warning.getLat());
						bigdataAlarmRecord.setLongitude(warning.getLon());
						bigdataAlarmRecord.setAlarmSpeed(warning.getSpeed());
						bigdataAlarmRecord.setCountDate(warning.getCountDate());
						bigdataAlarmRecord.setCountMonth(warning.getCountMonth());
						bigdataAlarmRecord.setEmpId(warning.getEmpId());
						bigdataAlarmRecord.setEmpName(warning.getEmpName());
						bigdataAlarmRecord.setEmpCode(warning.getEmpCode());
						bigdataAlarmRecord.setProvinceId(warning.getProvinceId());
						bigdataAlarmRecord.setProvinceName(warning.getProvinceName());
						bigdataAlarmRecord.setCityId(warning.getCityId());
						bigdataAlarmRecord.setCityName(warning.getCityName());
						bigdataAlarmRecord.setXianquId(warning.getXianquId());
						bigdataAlarmRecord.setXianquName(warning.getXianquName());
						BigdataAlarmRecord bigdataAlarmRecord1 = bigdataAlarmRecordService.loadByIdAndAlarmDate(warning.getId(),warning.getCountMonth());
						if(bigdataAlarmRecord1==null){
							bigdataAlarmRecordMapper.insert(bigdataAlarmRecord);
						}
					}else {
						mapper.insert(warning);
					}
				}
			}else {
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				for(int i=0;i<2;i++){
					Integer countDate = DateUtil.getNowDate(cal.getTime());
					warning.setCountDate(countDate);
					warning.setCountMonth(countDate/100);
					int count = mapper.countById(warning);
					if(count>0){
						warning.setUpdateTime(new Date());
						mapper.updateByPkSelectiveAndFenPianNew(warning);
						break;
					}else {
						cal.add(Calendar.DAY_OF_MONTH,-1);
					}
				}
			}
		}
	}

	/**
	 * 更新车辆的实时状态
	 * @param carRealtimeGpsList
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateCarGps(List<CarRealtimeGps> carRealtimeGpsList,String userId,String userkey) {
		//查询运营商
		BigdataBeidouComp beidouComp = null;
		if(userId!=null && userId.equals("200000")){
			userId= "10001";
			beidouComp = beidouCompService.loadById(userId);
			if(beidouComp==null){
				return;
			}
		}else {
			beidouComp = beidouCompService.loadById(userId);
			if(beidouComp==null){
				return;
			}
			String key = beidouComp.getSingKey();
			if(!key.equals(userkey)){
				return;
			}
		}
		for(CarRealtimeGps car : carRealtimeGpsList){
			BigdataBeidouSafetyCarInfo beidouSafetyCarInfo = new BigdataBeidouSafetyCarInfo();
			beidouSafetyCarInfo.setAltitude(car.getAltitude());
			beidouSafetyCarInfo.setLon(car.getLon());
			beidouSafetyCarInfo.setLat(car.getLat());
			beidouSafetyCarInfo.setMileage(car.getMileage());
			String state = car.getState();
			if(state!=null && !state.equals("")){
				String s =Integer.toBinaryString(Integer.parseInt(state));
				String locationState = s.substring(1,2);
				String yingyunState = s.substring(4,5);
				String youluState = s.substring(10,11);
				String dianluState = s.substring(11,12);
				if(locationState!=null && locationState.equals("0")){
					beidouSafetyCarInfo.setStateDesc("未定位");
				}else {
					if(youluState.equals("1") || dianluState.equals("1")){
						beidouSafetyCarInfo.setStateDesc("故障");
					}else {
						if(yingyunState.equals("0")){
							beidouSafetyCarInfo.setStateDesc("运营");
						}else {
							beidouSafetyCarInfo.setStateDesc("停运");
						}
					}
				}
			}
			beidouSafetyCarInfo.setState(state);
			beidouSafetyCarInfo.setDirection(car.getDirection());
			beidouSafetyCarInfo.setAlarm(car.getAlarm());
			beidouSafetyCarInfo.setSpeed(car.getSpeed());
			beidouSafetyCarInfo.setCarPlateNum(car.getVehicle_no());
			//车牌颜色代码
			String colorCode = CarInfoService.genCarPlateColorCodeFromText(car.getVehicle_color());
			beidouSafetyCarInfo.setCarPlateColor(colorCode);
			beidouSafetyCarInfo.setUpdateTime(new Date());

			bigdataBeidouSafetyCarInfoService.updateByCarPlateNum(beidouSafetyCarInfo);
		}
	}
	/**
	 * 将发送来的主动安全报警存到数据库里
	 * @param safetyWarningList
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateSafetyWarning(List<BeidouSafetyWarning> safetyWarningList, String compId) {
		//查询运营商
		BigdataBeidouComp beidouComp = beidouCompService.loadById(compId);
		if(beidouComp==null){
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		for(BeidouSafetyWarning safetyWarning : safetyWarningList){
		    //车牌号
            String carPlateNum = safetyWarning.getCarPlateNum();
            //车牌颜色
            String carPlateColor = safetyWarning.getCarPlateColor();
            //判断车牌号
            if(!carPlateNum.contains("冀C")){
                continue;
            }
            //判断报警时间
            String starttimeStr = safetyWarning.getStarttime();
            if(starttimeStr==null || starttimeStr.equals("") || starttimeStr.length()==0){
                continue;
            }
            Date starttime = null;
            Integer countDate = null;
            Integer countMonth = null;
            try {
                starttime = sdf.parse(starttimeStr);
                String startDay = starttimeStr.substring(0,8);
                countDate = new Integer(startDay);
                countMonth = countDate/100;
            } catch (ParseException e) {
                e.printStackTrace();
                continue;
            }
            String carId = carPlateNum + "_" + carPlateColor;
            CarInfo carInfo = carInfoService.loadById(carId);
            if(carInfo==null){
            	continue;
			}
            //经纬度
            Double lat = safetyWarning.getLat();
            Double lon = safetyWarning.getLon();
            //速度
            Double speed = safetyWarning.getSpeed();
            //道速限速值
            Double roadSpeedLimit = safetyWarning.getRoadSpeedLimit();
            //报警类型
            int warnType = safetyWarning.getWarningType();
            //判断是否是常规报警
            if(warnType == 49 || warnType == 3){
                BigdataAlarmRecord bigdataAlarmRecord = new BigdataAlarmRecord();
                String id = compId + "_" + safetyWarning.getbId();
                bigdataAlarmRecord.setId(id);
                bigdataAlarmRecord.setBid(safetyWarning.getbId());
                bigdataAlarmRecord.setCompId(beidouComp.getId());
                bigdataAlarmRecord.setCompName(beidouComp.getCompName());
                bigdataAlarmRecord.setCarPlateNum(safetyWarning.getCarPlateNum());
                bigdataAlarmRecord.setCarPlateColor(safetyWarning.getCarPlateColor());
                bigdataAlarmRecord.setCarType(carInfo.getCarType());
                bigdataAlarmRecord.setSimCode(safetyWarning.getSim());
                if(warnType == 3){
                    bigdataAlarmRecord.setAlarmCls("1");
                    bigdataAlarmRecord.setAlarmType("2");
                }
                if(warnType == 49){
                    bigdataAlarmRecord.setAlarmCls("2");
                    bigdataAlarmRecord.setAlarmType("4");
                }
                bigdataAlarmRecord.setAlarmTime(starttime);
                bigdataAlarmRecord.setDriver(safetyWarning.getDriverName());
                if(lat!=null){
                    bigdataAlarmRecord.setLatitude(new BigDecimal(lat));
                }
                if(lon!=null){
                    bigdataAlarmRecord.setLongitude(new BigDecimal(lon));
                }
                if(speed!=null){
                    bigdataAlarmRecord.setAlarmSpeed(new BigDecimal(speed));
                }
                bigdataAlarmRecord.setCountDate(countDate);
                bigdataAlarmRecord.setCountMonth(countMonth);
                bigdataAlarmRecord.setCarType(carInfo.getCarType());
                bigdataAlarmRecord.setTeamId(carInfo.getOwnerTeamId());
                bigdataAlarmRecord.setTeamName(carInfo.getOwnerTeamName());
                bigdataAlarmRecord.setProvinceId(carInfo.getProvinceId());
                bigdataAlarmRecord.setProvinceName(carInfo.getProvinceName());
                bigdataAlarmRecord.setCityId(carInfo.getCityId());
                bigdataAlarmRecord.setCityName(carInfo.getCityName());
                bigdataAlarmRecord.setXianquId(carInfo.getXianquId());
                bigdataAlarmRecord.setXianquName(carInfo.getXianquName());
                bigdataAlarmRecord.setEmpId(carInfo.getEmpId());
                bigdataAlarmRecord.setEmpName(carInfo.getEmpName());
                bigdataAlarmRecord.setEmpCode(carInfo.getEmpCode());
                bigdataAlarmRecord.setRoadLevel(safetyWarning.getRoadLevel());
                if(roadSpeedLimit!=null){
                    bigdataAlarmRecord.setRoadSpeedLimit(new BigDecimal(roadSpeedLimit));
					if(speed.doubleValue()/roadSpeedLimit.doubleValue()>1.5){
						bigdataAlarmRecord.setSeriousFlag("1");
					}else{
						bigdataAlarmRecord.setSeriousFlag("0");
					}
                }else {
					bigdataAlarmRecord.setSeriousFlag("0");
				}
				//报警时长（秒）
				Integer alarmTimeSecond = safetyWarning.getAlarmTimeSecond();
                if(alarmTimeSecond!=null){
					bigdataAlarmRecord.setAlarmTimeSecond(new BigDecimal(safetyWarning.getAlarmTimeSecond()));
					//疲劳报警 大于20分钟算严重疲劳
					if(alarmTimeSecond.doubleValue()/60>20){
						bigdataAlarmRecord.setSeriousFlag("1");
					}else{
						bigdataAlarmRecord.setSeriousFlag("0");
					}
				}else {
					bigdataAlarmRecord.setSeriousFlag("0");
				}
				//危险时段判断 中午11-13, 黄昏 17-19, 午夜23-1 ,清晨 5-7
				Date alarmTime = bigdataAlarmRecord.getAlarmTime();
				Calendar cal = Calendar.getInstance();
				cal.setTime(alarmTime);
				int hour =  cal.get(Calendar.HOUR_OF_DAY);
				if( (hour>=12&&hour<14) || (hour>=17&&hour<19)|| (hour>=2&&hour<5) || (hour>=5&&hour<7)){
					bigdataAlarmRecord.setDangerTimeFlag("1");
				}else{
					bigdataAlarmRecord.setDangerTimeFlag("0");
				}
                String handelType = safetyWarning.getHandleType();
                String detailInfo = safetyWarning.getDetailInfo();
                String handleTimeStr = safetyWarning.getHandleTime();
                if(handleTimeStr!=null && handleTimeStr.length()>0){
                    try {
                        Date handleTime = sdf.parse(handleTimeStr);
                        bigdataAlarmRecord.setDealTime(handleTime);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                bigdataAlarmRecord.setDealType(handelType);
                bigdataAlarmRecord.setDealRemark(detailInfo);
                if(handelType!=null && !handelType.equals("") && handleTimeStr!=null && !handleTimeStr.equals("")){
                    bigdataAlarmRecord.setAlarmState("已处理");
                }else {
                    bigdataAlarmRecord.setAlarmState("未处理");
                }
				System.out.println("bigdataAlarmRecord11======"+ JSONObject.toJSONString(bigdataAlarmRecord));
                //判断是否已经存在
                int count1 = bigdataAlarmRecordMapper.countById(bigdataAlarmRecord);
                if(count1>0){
                    bigdataAlarmRecordMapper.updateByFenPian(bigdataAlarmRecord);
                }else {
                    bigdataAlarmRecord.setCreateTime(new Date());
                    bigdataAlarmRecordMapper.insert(bigdataAlarmRecord);
                }
            }else {
                BigdataSafetyWarning warning = new BigdataSafetyWarning();
                warning.setAlarmState(safetyWarning.getAlarmState());
                warning.setBid(safetyWarning.getbId());
				warning.setCarPlateNum(carInfo.getCarPlateNum());
				warning.setCarPlateColor(carInfo.getCarPlateColour());
                warning.setCarFrameNum(carInfo.getCarFrameNum());
                warning.setCarType(carInfo.getCarType());
				warning.setCarPlateColorText(carInfo.getCarPlateColorText());
                warning.setOwnerTeamId(carInfo.getOwnerTeamId());
                warning.setOwnerTeamName(carInfo.getOwnerTeamName());
                warning.setProvinceId(carInfo.getProvinceId());
                warning.setProvinceName(carInfo.getProvinceName());
                warning.setCityId(carInfo.getCityId());
                warning.setCityName(carInfo.getCityName());
                warning.setXianquId(carInfo.getXianquId());
                warning.setXianquName(carInfo.getXianquName());
                warning.setEmpCode(carInfo.getEmpCode());
                warning.setEmpIdCard(carInfo.getEmpCode());
                warning.setEmpName(carInfo.getEmpPhone());
                warning.setEmpId(carInfo.getEmpId());
                warning.setCompId(beidouComp.getId());
                warning.setCompName(beidouComp.getCompName());
                warning.setCountDate(countDate);
                warning.setCountMonth(countMonth);
                warning.setStarttime(starttime);
                warning.setDeviceno(safetyWarning.getDeviceno());
                warning.setDriverName(safetyWarning.getDriverName());
                warning.setDriverCard(safetyWarning.getDriverCard());
                warning.setSim(safetyWarning.getSim());
                //方向
                Double direction = safetyWarning.getDirection();
                if(direction!=null){
                    warning.setDirection(new BigDecimal(direction));
                }
                if(lat!=null){
                    warning.setLat( new BigDecimal(lat));
                }
                if(lon!=null){
                    warning.setLon(new BigDecimal(lon));
                }
                if(speed!=null){
                    warning.setSpeed(new BigDecimal(speed));
                }
                String endtimeStr = safetyWarning.getEndtime();
                if(endtimeStr!=null && endtimeStr.length()>0){
                    try {
                        Date endtime = sdf.parse(endtimeStr);
                        warning.setEndtime(endtime);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                String handelType = safetyWarning.getHandleType();
                String handleTimeStr = safetyWarning.getHandleTime();
                if(handleTimeStr!=null && handleTimeStr.length()>0){
                    try {
                        Date handleTime = sdf.parse(handleTimeStr);
                        warning.setHandleTime(handleTime);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                //处理结果描述
                warning.setDetailInfo(safetyWarning.getDetailInfo());
                warning.setHandlePeople(safetyWarning.getHandlePeople());
                warning.setHandleType(handelType);
                if(handelType!=null && !handelType.equals("") && handleTimeStr!=null && !handleTimeStr.equals("")){
                    warning.setHandleState("已处理");
                }else {
                    warning.setHandleState("未处理");
                }
                warning.setWarningInfo(safetyWarning.getWarningInfo());
                warning.setWarningType(warnTypeMap.get(warnType+""));
                //报警等级 低于50一级 高于50二级
                if(speed!=null){
                    if(speed>50){
                        warning.setWarningLevel("2");
                    }else{
                        warning.setWarningLevel("1");
                    }

                }else{
                    warning.setWarningLevel("1");
                }
                String id = compId + "_" + warning.getBid();
                warning.setId(id);
                if(countDate!=null && !countDate.equals("")){
                    int count = mapper.countById(warning);
                    if(count>0){
                        warning.setUpdateTime(new Date());
                        mapper.updateByPkSelectiveAndFenPianNew(warning);
                    }else {
                        warning.setCreateTime(new Date());
                        mapper.insert(warning);
                    }
                }
            }
		}
	}
	/**
	 * 根据主键和分片字段统计查询
	 * @param pk
	 * @param countMonth
	 * @return
	 */
	public int countByIdAndFenPian(String pk,int countMonth){
		BigdataSafetyWarning warning = new BigdataSafetyWarning();
		warning.setId(pk);
		warning.setCountMonth(countMonth);
		return mapper.countById(warning);
	}

	/**
	 * 根据主键和分片字段统计查询
	 * @return
	 */
	public int countById(BigdataSafetyWarning warning){
		return mapper.countById(warning);
	}

	public int countByCarPlateNum(Map<String, Object> map) {
		return mapper.countByCarPlateNum(map);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void acceptCarGps(List<CarRealtimeGps> carRealtimeGpsList, String compId) {
		//查询运营商
		BigdataBeidouComp beidouComp = beidouCompService.loadById(compId);
		if(beidouComp==null){
			return;
		}
		for(CarRealtimeGps car : carRealtimeGpsList){
			BigdataBeidouSafetyCarInfo beidouSafetyCarInfo = new BigdataBeidouSafetyCarInfo();
			beidouSafetyCarInfo.setAltitude(car.getAltitude());
			beidouSafetyCarInfo.setLon(car.getLon());
			beidouSafetyCarInfo.setLat(car.getLat());
			beidouSafetyCarInfo.setMileage(car.getMileage());
			String state = car.getState();
			beidouSafetyCarInfo.setStateDesc(getStateStr(state));
			beidouSafetyCarInfo.setState(state);
			beidouSafetyCarInfo.setDirection(car.getDirection());
			beidouSafetyCarInfo.setAlarm(car.getAlarm());
			beidouSafetyCarInfo.setSpeed(car.getSpeed());
			beidouSafetyCarInfo.setCarPlateNum(car.getVehicle_no());
			//车牌颜色代码
			String colorCode = CarInfoService.genCarPlateColorCodeFromText(car.getVehicle_color());
			beidouSafetyCarInfo.setCarPlateColor(colorCode);
			beidouSafetyCarInfo.setUpdateTime(new Date());

			bigdataBeidouSafetyCarInfoService.updateByCarPlateNum(beidouSafetyCarInfo);
		}
	}
	public String getStateStr(String state){
		if(state.equals("0")){
			return "停运";
		}
		if(state.equals("1")){
			return "运营";
		}
		if(state.equals("2")){
			return "故障";
		}
		if(state.equals("3")){
			return "未定位";
		}
		return "未定位";
	}

	public List<AlarmVo> countByCarType(Map<String, Object> map) {
		return mapper.countByCarType(map);
	}

	public List<AlarmVo> countByCarTypeMonth(Map<String, Object> map) {
		return mapper.countByCarTypeMonth(map);
	}

	public List<AlarmVo> countByTeamTransitType(Map<String, Object> map) {
		return mapper.countByTeamTransitType(map);
	}

	public int countHandleNumByCarPlateNum(Map<String, Object> map) {
		return mapper.countHandleNumByCarPlateNum(map);
	}

	public int selectAlarmNumDay(Integer yearNum, Integer countMonth, Integer countDay, String xianQuId, String carType, String startTime, String endTime) {
		return mapper.selectAlarmNumDay(yearNum,  countMonth,  countDay,  xianQuId,  carType,  startTime,  endTime);
	}

	public int selectHandlerDay(Integer yearNum, Integer countMonth, Integer countDay, String xianQuId, String carType, String startTime, String endTime) {
		return mapper.selectHandlerDay(yearNum,  countMonth,  countDay,  xianQuId,  carType,  startTime,  endTime);
	}

	public Map<String, String> selectCountType(Integer countMonth, Integer countDay, String xianQuId, String carType) {
		return mapper.selectCountType( countMonth,  countDay,  xianQuId,  carType);
	}

	public List<AlarmVo> countByTeamTransitTypeMonth(Map<String, Object> map) {
		return  mapper.countByTeamTransitTypeMonth(map);
	}

	public List<AlarmVo> countByTeamTransitTypeTopThree(Map<String, Object> map1) {
		return mapper.countByTeamTransitTypeTopThree(map1);
	}

	public List<AlarmVo> countByTeamTransitTypeTopThreeMonth(Map<String, Object> map1) {
		return mapper.countByTeamTransitTypeTopThreeMonth(map1);
	}

	public int selectWarningTypeCountByQuery(BigdataSafetyWarningQuery query){
		return mapper.selectWarningTypeCountByQuery(query);
	}

	public void updateByPkSelectiveAndFenPian(BigdataSafetyWarning bigdataSafetyWarning) {
		mapper.updateByPkSelectiveAndFenPian(bigdataSafetyWarning);
	}

	public BigdataSafetyWarning selectByBId(Map<String, Object> map) {
		return mapper.selectByBId(map);
	}

	/**
	 * 更新处理方式，处理时间等
	 * @param alarmHandleInfoList
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateAlarmHandleInfo(List<BeidouAlarmHandleInfo> alarmHandleInfoList, String compId) {
		//查询运营商
		BigdataBeidouComp beidouComp = beidouCompService.loadById(compId);
		if(beidouComp==null){
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmhhss");
		for(BeidouAlarmHandleInfo alarmHandleInfo : alarmHandleInfoList){

			String carPlateNum = alarmHandleInfo.getCarPlateNum();
			if(!carPlateNum.contains("冀C")){
				continue;
			}
			String warningType = alarmHandleInfo.getWarningType();
			if(isSafetyWarning(warningType).equals("OTHER")){
				continue;
			}
			if(isSafetyWarning(warningType).equals("SAFETY")){
				BigdataSafetyWarning warning = new BigdataSafetyWarning();
				warning.setCarPlateNum(carPlateNum);
				String carPlateColor = alarmHandleInfo.getCarPlateColor();
				warning.setCarPlateColor(carPlateColor);
				//车牌颜色代码
				String colorText = CarInfoService.genCarPlateColorTextFromCode(carPlateColor);
				warning.setCarPlateColorText(colorText);
				String starttimeStr = alarmHandleInfo.getStarttime();
				if(starttimeStr!=null && starttimeStr.length()>0){
					try {
						Date starttime = sdf.parse(starttimeStr);
						String startDay = starttimeStr.substring(0,8);
						Integer countDate = new Integer(startDay);
						warning.setCountDate(countDate);
						warning.setCountMonth(countDate/100);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				//处理结果描述
				warning.setDetailInfo(alarmHandleInfo.getDetailInfo());
				warning.setHandlePeople(alarmHandleInfo.getHandlePeople());
				warning.setHandleType(alarmHandleInfo.getHandleType());
				String handleTimeStr = alarmHandleInfo.getHandleTime();
				if(handleTimeStr!=null && handleTimeStr.length()>0){
					try {
						Date handleTime = sdf.parse(handleTimeStr);
						warning.setHandleTime(handleTime);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if(alarmHandleInfo.getHandleType()!=null && !alarmHandleInfo.getHandleType().equals("")){
					warning.setHandleState("已处理");
				}
				String id = compId + "_" + warning.getBid();
				warning.setId(id);
				int count = mapper.countById(warning);
				if(count>0){
					warning.setUpdateTime(new Date());
					mapper.updateByPkSelectiveAndFenPian(warning);
				}

			}
			if(isSafetyWarning(warningType).equals("ALARM")){

			}
		}
	}

	//判断是主动安全报警还是常规报警
	/*
	* 主动安全报警
		前向碰撞预警,车辆偏离预警,车距过近预警,行人碰撞报警,
		疲劳驾驶报警,接打电话报警,抽烟报警,注意力分散报警,异常报警
	常规报警
		常规疲劳驾驶报警,超速报警
	* */
	public String isSafetyWarning(String warningType){
		String safetyStr = "前向碰撞预警,车辆偏离预警,车距过近预警,行人碰撞报警,疲劳驾驶报警,接打电话报警,抽烟报警,注意力分散报警,异常报警";
		String alarmStr = "常规疲劳驾驶报警,超速报警";
		if(safetyStr.contains(warningType)){
			return "SAFETY";
		}
		if(alarmStr.equals(warningType)){
			return "ALARM";
		}
		return "OTHER";
	}

	public int countSafetyNum(String driverId, int dayInt) {
		Map<String,Object> map = new HashMap<>();
		map.put("empId",driverId);
		map.put("countDate",dayInt);
		map.put("countMonth",dayInt/100);
 		return mapper.countSafetyNum(map);
	}

	public int countSumNumByCompId(String compId, int dayInt) {
		Map<String,Object> map = new HashMap<>();
		map.put("compId",compId);
		map.put("countDate",dayInt);
		map.put("countMonth",dayInt/100);
		return mapper.countSumNumByCompId(map);
	}
}
