package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.AlarmVo;
import com.edgedo.bigdata.entity.BigdataFenxiCarAlarmWeek;
import com.edgedo.bigdata.entity.BigdataFenxiCarWeek;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.mapper.BigdataFenxiCarWeekMapper;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarWeekView;
import com.edgedo.common.util.Guid;
import com.edgedo.util.DateUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataFenxiCarWeekService {


	@Autowired
	private BigdataFenxiCarWeekMapper mapper;
	@Autowired
	private BigdataTimeCarDayRecService bigdataTimeCarDayRecService;
	@Autowired
	private BigdataAlarmRecordService bigdataAlarmRecordService;
	@Autowired
	private BigdataSafetyWarningService bigdataSafetyWarningService;
	@Autowired
	private BigdataFenxiCarAlarmWeekService bigdataFenxiCarAlarmWeekService;


	public List<BigdataFenxiCarWeekView> listPage(BigdataFenxiCarWeekQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFenxiCarWeek voObj) {
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
	public String update(BigdataFenxiCarWeek voObj) {
		mapper.updateById(voObj);
		return "";
	}

	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFenxiCarWeek voObj) {
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
	public BigdataFenxiCarWeek loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataFenxiCarWeek> selectByWeekQianShi(String carType, String xianQuId, Integer timeChangeAge, String timeChangeWeek, Integer countMonth) {
		return mapper.selectByWeekQianShi( carType,  xianQuId,  timeChangeAge,  timeChangeWeek,countMonth);
	}
	public List<BigdataFenxiCarWeek> selectByWeekHouShi(String carType, String xianQuId, Integer timeChangeAge, String timeChangeWeek,Integer countMonth) {
		return mapper.selectByWeekHouShi( carType,  xianQuId,  timeChangeAge,  timeChangeWeek,countMonth);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(CarInfo car, int weekYear, int weekOfYear, Date beginDate, Date endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String beginDateStr = sdf.format(beginDate);
		Integer countDate = Integer.parseInt(beginDateStr);
		Integer countMonth = Integer.parseInt(beginDateStr)/100;
		Map<String,Object> map = new HashedMap();
		map.put("carPlateNum",car.getCarPlateNum());
		map.put("carPlateColor",car.getCarPlateColour());
		//统计该车的记录
		BigdataFenxiCarWeek bigdataFenxiCarWeek = new BigdataFenxiCarWeek();
		bigdataFenxiCarWeek.setId(Guid.guid());
		bigdataFenxiCarWeek.setProvinceId(car.getProvinceId());
		bigdataFenxiCarWeek.setProvinceName(car.getProvinceName());
		bigdataFenxiCarWeek.setCityId(car.getCityId());
		bigdataFenxiCarWeek.setCityName(car.getCityName());
		bigdataFenxiCarWeek.setXianquId(car.getXianquId());
		bigdataFenxiCarWeek.setXianquName(car.getXianquName());
		bigdataFenxiCarWeek.setCarPlateNum(car.getCarPlateNum());
		bigdataFenxiCarWeek.setCarPlateColor(car.getCarPlateColour());
		bigdataFenxiCarWeek.setCarFrameNum(car.getCarFrameNum());
		bigdataFenxiCarWeek.setCarType(car.getCarType());
		bigdataFenxiCarWeek.setTransitType(car.getCarTransitType());
		bigdataFenxiCarWeek.setOwnerTeamId(car.getOwnerTeamId());
		bigdataFenxiCarWeek.setOwnerTeamName(car.getOwnerTeamName());
		bigdataFenxiCarWeek.setCountWeek(weekOfYear);
		bigdataFenxiCarWeek.setStartCountDate(beginDate);
		bigdataFenxiCarWeek.setEndCountDate(endDate);
		bigdataFenxiCarWeek.setCountDate(countDate);
		bigdataFenxiCarWeek.setCountMonth(countMonth);
		bigdataFenxiCarWeek.setYearNum(weekYear);
		map.put("beginDate",beginDate);
		map.put("endDate",endDate);
		map.put("countMonth",countMonth);
		map.put("week",weekOfYear);
		BigdataFenxiCarWeek bigdataFenxiCarWeek1 = bigdataTimeCarDayRecService.countMileageByWeek(map);
		if(bigdataFenxiCarWeek1==null){
			bigdataFenxiCarWeek1 = new BigdataFenxiCarWeek();
		}
		BigDecimal runMileage = bigdataFenxiCarWeek1.getRunMileage();
		if(runMileage==null){
			runMileage = new BigDecimal("0");
		}
		bigdataFenxiCarWeek.setRunMileage(runMileage);
		BigDecimal runTimeLength = bigdataFenxiCarWeek1.getRunTimeLength();
		if(runTimeLength==null){
			runTimeLength = new BigDecimal("0");
		}
		//转为小时分
		String runTimeLengthText = DateUtil.getHourMinuteSecond(runTimeLength);

		bigdataFenxiCarWeek.setRunTimeLengthText(runTimeLengthText);
		//转为小时
		bigdataFenxiCarWeek.setRunTimeLengthHour(runTimeLength.divide(new BigDecimal("60"),2, RoundingMode.HALF_UP));
		bigdataFenxiCarWeek.setRunTimeLength(runTimeLength);
		Integer alarmNum = bigdataFenxiCarWeek1.getAlarmNum();
		if(alarmNum==null){
			alarmNum = 0;
		}
		bigdataFenxiCarWeek.setAlarmNum(alarmNum);
		if(runMileage.compareTo(BigDecimal.ZERO)==0){
			bigdataFenxiCarWeek.setAlarmRate(new BigDecimal("0"));
		}else {
			bigdataFenxiCarWeek.setAlarmRate(new BigDecimal(alarmNum).divide(runMileage,2, RoundingMode.HALF_UP));
		}
		//统计报警的数量
		//报警信息周统计
		List<AlarmVo> alarmVoList = new ArrayList<>();
		List<AlarmVo> safetyWarningList = new ArrayList<>();
		List<AlarmVo> alarmVoList1 = new ArrayList<>();
		List<AlarmVo> safetyWarningList1 = new ArrayList<>();
		String carType = car.getCarType();
		if(carType!=null && !carType.equals("")){
			//分段限速
			alarmVoList = bigdataAlarmRecordService.countByCarType(map);
			//主动安全
			safetyWarningList = bigdataSafetyWarningService.countByCarType(map);
		}
		//判断是否跨月
		if(!DateUtil.equalsDate(beginDate,endDate)){
			String endDateStr = sdf.format(endDate);
			Integer countMonth1 = Integer.parseInt(endDateStr)/100;
			Map<String,Object> map1 = new HashedMap();
			map1.put("carPlateNum",car.getCarPlateNum());
			map1.put("carPlateColor",car.getCarPlateColour());
			map1.put("beginDate",beginDate);
			map1.put("endDate",endDate);
			map1.put("countMonth",countMonth1);
			BigdataFenxiCarWeek bigdataFenxiCarWeek2 = bigdataTimeCarDayRecService.countMileageByWeek(map1);
			if(bigdataFenxiCarWeek2==null){
				bigdataFenxiCarWeek2 = new BigdataFenxiCarWeek();
			}
			BigDecimal runMileage2 = bigdataFenxiCarWeek2.getRunMileage();
			if(runMileage2==null){
				runMileage2 = new BigDecimal("0");
			}
			runMileage2 = runMileage2.add(runMileage);
			bigdataFenxiCarWeek.setRunMileage(runMileage2);
			BigDecimal runTimeLength2 = bigdataFenxiCarWeek2.getRunTimeLength();
			if(runTimeLength2==null){
				runTimeLength2 =  new BigDecimal("0");;
			}
			runTimeLength2 = runTimeLength2.add(runTimeLength);

			String runTimeLengthText2 = DateUtil.getHourMinuteSecond(runTimeLength2);
			bigdataFenxiCarWeek.setRunTimeLengthText(runTimeLengthText2);
			//转为小时
			bigdataFenxiCarWeek.setRunTimeLengthHour(runTimeLength2.divide(new BigDecimal("60"),2, RoundingMode.HALF_UP));
			bigdataFenxiCarWeek.setRunTimeLength(runTimeLength2);
			Integer alarmNum2 = bigdataFenxiCarWeek2.getAlarmNum();
			if(alarmNum2==null){
				alarmNum2 = 0;
			}
			alarmNum2 = alarmNum2+alarmNum;
			bigdataFenxiCarWeek.setAlarmNum(alarmNum2);
			if(runMileage2.compareTo(BigDecimal.ZERO)==0){
				bigdataFenxiCarWeek.setAlarmRate(new BigDecimal("0"));
			}else {
				bigdataFenxiCarWeek.setAlarmRate(new BigDecimal(alarmNum2).divide(runMileage2,2, RoundingMode.HALF_UP));
			}
			//报警信息周统计
			alarmVoList1 = bigdataAlarmRecordService.countByCarType(map1);
			for (AlarmVo a:alarmVoList){
				for(AlarmVo a1:alarmVoList1){
					if(a.getAlarmType().equals(a1.getAlarmType())){
						a.setAlarmNum(a.getAlarmNum()+a1.getAlarmNum());
					}
				}
			}
			safetyWarningList1 = bigdataSafetyWarningService.countByCarType(map1);
			for (AlarmVo a:safetyWarningList){
				for(AlarmVo a1:safetyWarningList1){
					if(a.getAlarmType().equals(a1.getAlarmType())){
						a.setAlarmNum(a.getAlarmNum()+a1.getAlarmNum());
					}
				}
			}
			//集合记录汇总
		}
		//查询记录是否存在
		BigdataFenxiCarWeek bigdataFenxiCarWeek3 = mapper.selectByFenqu(map);
		if(bigdataFenxiCarWeek3==null){
			bigdataFenxiCarWeek.setCreateTime(new Date());
			mapper.insert(bigdataFenxiCarWeek);
		}else {
			bigdataFenxiCarWeek.setId(bigdataFenxiCarWeek3.getId());
			bigdataFenxiCarWeek.setUpdateTime(new Date());
			mapper.updateByfenPian(bigdataFenxiCarWeek);
		}
		//分段限速报警统计
		for (AlarmVo a:alarmVoList){
			BigdataFenxiCarAlarmWeek bigdataFenxiCarAlarmWeek = new BigdataFenxiCarAlarmWeek();
			bigdataFenxiCarAlarmWeek.setOwnerCarDayId(bigdataFenxiCarWeek.getId());
			bigdataFenxiCarAlarmWeek.setAlarmNum(a.getAlarmNum());
			if(runMileage.compareTo(BigDecimal.ZERO)==0){
				bigdataFenxiCarAlarmWeek.setAlarmRate(new BigDecimal("0"));
			}else {
				bigdataFenxiCarAlarmWeek.setAlarmRate(new BigDecimal(a.getAlarmNum()).divide(runMileage,2, RoundingMode.HALF_UP));
			}
			bigdataFenxiCarAlarmWeek.setAlarmType(a.getAlarmType());
			bigdataFenxiCarAlarmWeek.setAlarmTypeDesc(getAlarmTypeDesc(a.getAlarmType()));
			bigdataFenxiCarAlarmWeek.setCountDate(countDate);
			bigdataFenxiCarAlarmWeek.setCountWeek(weekOfYear);
			bigdataFenxiCarAlarmWeek.setStartCountDate(beginDate);
			bigdataFenxiCarAlarmWeek.setEndCountDate(endDate);
			bigdataFenxiCarAlarmWeek.setCountMonth(countMonth);
			bigdataFenxiCarAlarmWeek.setYearNum(weekYear);
			bigdataFenxiCarAlarmWeekService.insertOrUpdate(bigdataFenxiCarAlarmWeek);
		}
		//主动安全报警统计
		for (AlarmVo a:safetyWarningList){
			BigdataFenxiCarAlarmWeek bigdataFenxiCarAlarmWeek = new BigdataFenxiCarAlarmWeek();
			bigdataFenxiCarAlarmWeek.setOwnerCarDayId(bigdataFenxiCarWeek.getId());
			bigdataFenxiCarAlarmWeek.setAlarmNum(a.getAlarmNum());
			if(runMileage.compareTo(BigDecimal.ZERO)==0){
				bigdataFenxiCarAlarmWeek.setAlarmRate(new BigDecimal("0"));
			}else {
				bigdataFenxiCarAlarmWeek.setAlarmRate(new BigDecimal(a.getAlarmNum()).divide(runMileage,2, RoundingMode.HALF_UP));
			}
			bigdataFenxiCarAlarmWeek.setAlarmType(getSafeType(a.getAlarmType()));
			bigdataFenxiCarAlarmWeek.setAlarmTypeDesc(a.getAlarmType());
			bigdataFenxiCarAlarmWeek.setCountDate(countDate);
			bigdataFenxiCarAlarmWeek.setCountWeek(weekOfYear);
			bigdataFenxiCarAlarmWeek.setStartCountDate(beginDate);
			bigdataFenxiCarAlarmWeek.setEndCountDate(endDate);
			bigdataFenxiCarAlarmWeek.setCountMonth(countMonth);
			bigdataFenxiCarAlarmWeek.setYearNum(weekYear);
			bigdataFenxiCarAlarmWeekService.insertOrUpdate(bigdataFenxiCarAlarmWeek);
		}
	}

	public String getAlarmTypeDesc(String alarmType){
		if(alarmType.equals("1")){
			return "线路报警";
		}
		if(alarmType.equals("2")){
			return "超速报警";
		}
		if(alarmType.equals("3")){
			return "紧急报警";
		}
		if(alarmType.equals("4")){
			return "疲劳报警";
		}
		return "";
	}


	public String getSafeType(String alarmTypeDesc){
		if(alarmTypeDesc.equals("前向碰撞预警")){
			return "180";
		}
		if(alarmTypeDesc.equals("车辆偏离预警")){
			return "181";
		}
		if(alarmTypeDesc.equals("车距过近预警")){
			return "182";
		}
		if(alarmTypeDesc.equals("限速标志识别")){
			return "183";
		}
		if(alarmTypeDesc.equals("行人碰撞报警")){
			return "184";
		}
		if(alarmTypeDesc.equals("疲劳驾驶报警")){
			return "186";
		}
		if(alarmTypeDesc.equals("接打电话报警")){
			return "187";
		}
		if(alarmTypeDesc.equals("抽烟报警")){
			return "188";
		}
		if(alarmTypeDesc.equals("注意力分散报警")){
			return "189";
		}
		if(alarmTypeDesc.equals("异常报警")){
			return "190";
		}
		return "";
	}

}
