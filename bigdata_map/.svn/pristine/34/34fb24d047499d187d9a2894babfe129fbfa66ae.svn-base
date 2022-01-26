package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.mapper.BigdataFenxiCarMonthMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarMonthView;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataFenxiCarMonthService {
	
	
	@Autowired
	private BigdataFenxiCarMonthMapper mapper;
	@Autowired
	private BigdataTimeCarDayRecService bigdataTimeCarDayRecService;
	@Autowired
	private BigdataAlarmRecordService bigdataAlarmRecordService;
	@Autowired
	private BigdataSafetyWarningService bigdataSafetyWarningService;
	@Autowired
	private BigdataFenxiCarAlarmMonthService bigdataFenxiCarAlarmMonthService;

	
	public List<BigdataFenxiCarMonthView> listPage(BigdataFenxiCarMonthQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFenxiCarMonth voObj) {
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
	public String update(BigdataFenxiCarMonth voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFenxiCarMonth voObj) {
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
	public BigdataFenxiCarMonth loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataFenxiCarMonth> selectByMonthQianShi(String carType, String xianQuId, Integer timeCount, String timeType) {
		return mapper.selectByMonthQianShi( carType,  xianQuId,  timeCount,  timeType);
	}

	public List<BigdataFenxiCarMonth> selectByMonthHouShi(String carType, String xianQuId, Integer timeCount, String timeType) {
		return mapper.selectByMonthQianShi( carType,  xianQuId,  timeCount,  timeType);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(CarInfo car, int dateInt) {
		Integer countDate = dateInt;
		Integer countMonth = dateInt/100;
		Integer yearNum = countMonth/100;
		Map<String,Object> map = new HashedMap();
		map.put("carPlateNum",car.getCarPlateNum());
		map.put("carPlateColor",car.getCarPlateColour());
		//统计该车的记录
		BigdataFenxiCarMonth bigdataFenxiCarMonth = new BigdataFenxiCarMonth();
		bigdataFenxiCarMonth.setId(Guid.guid());
		bigdataFenxiCarMonth.setProvinceId(car.getProvinceId());
		bigdataFenxiCarMonth.setProvinceName(car.getProvinceName());
		bigdataFenxiCarMonth.setCityId(car.getCityId());
		bigdataFenxiCarMonth.setCityName(car.getCityName());
		bigdataFenxiCarMonth.setXianquId(car.getXianquId());
		bigdataFenxiCarMonth.setXianquName(car.getXianquName());
		bigdataFenxiCarMonth.setCarPlateNum(car.getCarPlateNum());
		bigdataFenxiCarMonth.setCarPlateColor(car.getCarPlateColour());
		bigdataFenxiCarMonth.setCarFrameNum(car.getCarFrameNum());
		bigdataFenxiCarMonth.setCarType(car.getCarType());
		bigdataFenxiCarMonth.setTransitType(car.getCarTransitType());
		bigdataFenxiCarMonth.setOwnerTeamId(car.getOwnerTeamId());
		bigdataFenxiCarMonth.setOwnerTeamName(car.getOwnerTeamName());
		bigdataFenxiCarMonth.setCountDate(countDate);
		bigdataFenxiCarMonth.setCountMonth(countMonth);
		bigdataFenxiCarMonth.setYearNum(yearNum);
		map.put("countMonth",countMonth);
		BigdataFenxiCarMonth bigdataFenxiCarMonth1 = bigdataTimeCarDayRecService.countMileageByMonth(map);
		if(bigdataFenxiCarMonth1==null){
			bigdataFenxiCarMonth1 = new BigdataFenxiCarMonth();
		}
		BigDecimal runMileage = bigdataFenxiCarMonth1.getRunMileage();
		if(runMileage==null){
			runMileage = new BigDecimal("0");
		}
		bigdataFenxiCarMonth.setRunMileage(runMileage);
		BigDecimal runTimeLength = bigdataFenxiCarMonth1.getRunTimeLength();
		if(runTimeLength==null){
			runTimeLength = new BigDecimal("0");
		}
		String runTimeLengthText = DateUtil.getHourMinuteSecond(runTimeLength);
		bigdataFenxiCarMonth.setRunTimeLengthText(runTimeLengthText);
		//转为小时
		bigdataFenxiCarMonth.setRunTimeLengthHour(runTimeLength.divide(new BigDecimal("60"),2, RoundingMode.HALF_UP));
		bigdataFenxiCarMonth.setRunTimeLength(runTimeLength);
		Integer alarmNum = bigdataFenxiCarMonth1.getAlarmNum();
		if(alarmNum==null){
			alarmNum = 0;
		}
		bigdataFenxiCarMonth.setAlarmNum(alarmNum);
		if(runMileage.compareTo(BigDecimal.ZERO)==0){
			bigdataFenxiCarMonth.setAlarmRate(new BigDecimal("0"));
		}else {
			bigdataFenxiCarMonth.setAlarmRate(new BigDecimal(alarmNum).divide(runMileage,2, RoundingMode.HALF_UP));
		}
		//查询记录是否存在
		map.put("yearNum",yearNum);
		BigdataFenxiCarMonth bigdataFenxiCarMonth2 = mapper.selectByFenqu(map);
		if(bigdataFenxiCarMonth2==null){
			bigdataFenxiCarMonth.setCreateTime(new Date());
			mapper.insert(bigdataFenxiCarMonth);
		}else {
			bigdataFenxiCarMonth.setId(bigdataFenxiCarMonth2.getId());
			bigdataFenxiCarMonth.setUpdateTime(new Date());
			mapper.updateByfenPian(bigdataFenxiCarMonth);
		}
		//报警分类统计
		String carType = car.getCarType();
		if(carType!=null && !carType.equals("")){
			//分段限速
			List<AlarmVo> alarmVoList = bigdataAlarmRecordService.countByCarTypeMonth(map);
			for (AlarmVo a:alarmVoList){
				BigdataFenxiCarAlarmMonth bigdataFenxiCarAlarmMonth = new BigdataFenxiCarAlarmMonth();
				bigdataFenxiCarAlarmMonth.setOwnerCarMonthId(bigdataFenxiCarMonth.getId());
				bigdataFenxiCarAlarmMonth.setAlarmNum(a.getAlarmNum());
				if(runMileage.compareTo(BigDecimal.ZERO)==0){
					bigdataFenxiCarAlarmMonth.setAlarmRate(new BigDecimal("0"));
				}else {
					bigdataFenxiCarAlarmMonth.setAlarmRate(new BigDecimal(a.getAlarmNum()).divide(runMileage,2, RoundingMode.HALF_UP));
				}
				bigdataFenxiCarAlarmMonth.setAlarmType(a.getAlarmType());
				bigdataFenxiCarAlarmMonth.setAlarmTypeDesc(getAlarmTypeDesc(a.getAlarmType()));
				bigdataFenxiCarAlarmMonth.setCountDate(countDate);
				bigdataFenxiCarAlarmMonth.setCountMonth(countMonth);
				bigdataFenxiCarAlarmMonth.setYearNum(yearNum);
				bigdataFenxiCarAlarmMonthService.insertOrUpdate(bigdataFenxiCarAlarmMonth);
			}
			//主动安全
			List<AlarmVo> safetyWarningList = bigdataSafetyWarningService.countByCarTypeMonth(map);
			for (AlarmVo a:safetyWarningList){
				BigdataFenxiCarAlarmMonth bigdataFenxiCarAlarmMonth = new BigdataFenxiCarAlarmMonth();
				bigdataFenxiCarAlarmMonth.setOwnerCarMonthId(bigdataFenxiCarMonth.getId());
				bigdataFenxiCarAlarmMonth.setAlarmNum(a.getAlarmNum());
				if(runMileage.compareTo(BigDecimal.ZERO)==0){
					bigdataFenxiCarAlarmMonth.setAlarmRate(new BigDecimal("0"));
				}else {
					bigdataFenxiCarAlarmMonth.setAlarmRate(new BigDecimal(a.getAlarmNum()).divide(runMileage,2, RoundingMode.HALF_UP));
				}
				bigdataFenxiCarAlarmMonth.setAlarmType(getSafeType(a.getAlarmType()));
				bigdataFenxiCarAlarmMonth.setAlarmTypeDesc(a.getAlarmType());
				bigdataFenxiCarAlarmMonth.setCountDate(countDate);
				bigdataFenxiCarAlarmMonth.setCountMonth(countMonth);
				bigdataFenxiCarAlarmMonth.setYearNum(yearNum);
				bigdataFenxiCarAlarmMonthService.insertOrUpdate(bigdataFenxiCarAlarmMonth);
			}
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
