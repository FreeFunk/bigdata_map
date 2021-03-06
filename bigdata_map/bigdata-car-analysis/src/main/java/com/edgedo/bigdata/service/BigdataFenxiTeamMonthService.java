package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.mapper.BigdataFenxiTeamMonthMapper;
import com.edgedo.bigdata.mapper.BigdataTimeCarDayRecMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamMonthView;
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
public class BigdataFenxiTeamMonthService {
	
	
	@Autowired
	private BigdataFenxiTeamMonthMapper mapper;
	@Autowired
	private BigdataFenxiTeamDayService bigdataFenxiTeamDayService;
	@Autowired
	private BigdataTimeCarDayRecMapper bigdataTimeCarDayRecMapper;
	@Autowired
	private BigdataAlarmRecordService bigdataAlarmRecordService;
	@Autowired
	private BigdataSafetyWarningService bigdataSafetyWarningService;
	@Autowired
	private BigdataFenxiTeamAlarmMonthService bigdataFenxiTeamAlarmMonthService;
	
	public List<BigdataFenxiTeamMonthView> listPage(BigdataFenxiTeamMonthQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFenxiTeamMonth voObj) {
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
	public String update(BigdataFenxiTeamMonth voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFenxiTeamMonth voObj) {
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
	public BigdataFenxiTeamMonth loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataFenxiTeamMonth> selectByMonthAnQuanQianShi(String carType, String xianQuId, Integer timeCount) {
		return mapper.selectByMonthAnQuanQianShi( carType,  xianQuId,  timeCount);
	}

	public List<BigdataFenxiTeamMonth> selectByMonthAnQuanHouShi(String carType, String xianQuId, Integer timeCount) {
		return mapper.selectByMonthAnQuanHouShi( carType,  xianQuId,  timeCount);
	}

	public List<BigdataFenxiTeamMonth> selectByMonthBaiGongLiQianShi(String carType, String xianQuId, Integer timeCount) {
		return mapper.selectByMonthBaiGongLiQianShi( carType,  xianQuId,  timeCount);
	}

	public List<BigdataFenxiTeamMonth> selectByMonthBaiGongLiHouShi(String carType, String xianQuId, Integer timeCount) {
		return mapper.selectByMonthBaiGongLiHouShi( carType,  xianQuId,  timeCount);
	}

	public BigdataFenxiTeamMonth selectById(BigdataFenxiTeamMonthQuery query){
		return mapper.selectById(query);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdateAndMonth(TransitCarTeam team, Integer yearNum, Integer countMonth, Integer countDay) {
		Map<String,Object> map = new HashedMap();
		map.put("teamId",team.getId());
		//统计该车的记录
		BigdataFenxiTeamMonth bigdataFenxiTeamMonth = new BigdataFenxiTeamMonth();
		bigdataFenxiTeamMonth.setId(Guid.guid());
		bigdataFenxiTeamMonth.setProvinceId(team.getProvinceId());
		bigdataFenxiTeamMonth.setProvinceName(team.getProvinceName());
		bigdataFenxiTeamMonth.setCityId(team.getCityId());
		bigdataFenxiTeamMonth.setCityName(team.getCityName());
		bigdataFenxiTeamMonth.setXianquId(team.getXianquId());
		bigdataFenxiTeamMonth.setXianquName(team.getXianquName());
		bigdataFenxiTeamMonth.setTeamId(team.getId());
		bigdataFenxiTeamMonth.setTeamName(team.getTeamName());
		bigdataFenxiTeamMonth.setTeamType(team.getCompanyLevel());
		bigdataFenxiTeamMonth.setTransitType(getTransitTypeText(team.getCompanyLevel()));
		bigdataFenxiTeamMonth.setCountDate(countDay);
		bigdataFenxiTeamMonth.setCountMonth(countMonth);
		bigdataFenxiTeamMonth.setYearNum(yearNum);
		map.put("countMonth",countMonth);
		map.put("yearNum",yearNum);
		//COUNT_CAR_NUM 统计车辆数 RUN_MILEAGE 行驶里程 行驶时长（分）RUN_TIME_LENGTH
		//行驶时长(小时）RUN_TIME_LENGTH_HOUR 报警数量 ALARM_NUM
		BigdataFenxiTeamMonth bigdataFenxiTeamMonth1 = bigdataFenxiTeamDayService.countMileageByMonth(map);
		if(bigdataFenxiTeamMonth1==null){
			bigdataFenxiTeamMonth1 = new BigdataFenxiTeamMonth();
		}
		bigdataFenxiTeamMonth.setCountCarNum(bigdataFenxiTeamMonth1.getCountCarNum());//统计车辆数
		bigdataFenxiTeamMonth.setAlarmRate(getBaoJingAndBaiGongLi(bigdataFenxiTeamMonth1.getAlarmNum(),bigdataFenxiTeamMonth1.getRunMileage()));//报警数量/百公里
		bigdataFenxiTeamMonth.setAverageSpeed(getAverageSpeed(bigdataFenxiTeamMonth1.getRunMileage(),bigdataFenxiTeamMonth1.getRunTimeLengthHour()));//平均速度
		bigdataFenxiTeamMonth.setAverageRunMileage(getAverageRunMileage(bigdataFenxiTeamMonth1.getRunMileage(),bigdataFenxiTeamMonth1.getCountCarNum()));//平均行驶里程
		bigdataFenxiTeamMonth.setAverageRunTimeLength(getAverageRunTimeLength(bigdataFenxiTeamMonth1.getRunTimeLengthHour(),bigdataFenxiTeamMonth1.getCountCarNum()));//平均行驶时长
		bigdataFenxiTeamMonth.setAverageAlarmNum(getAverageAlarmNum(bigdataFenxiTeamMonth1.getAlarmNum(),bigdataFenxiTeamMonth1.getCountCarNum()));//平均报警数
		//23 34 45 56
		BigDecimal runMileage = bigdataFenxiTeamMonth1.getRunMileage();
		if(runMileage==null){
			runMileage = new BigDecimal("0");
		}
		bigdataFenxiTeamMonth.setRunMileage(runMileage);//行驶里程
		BigDecimal runTimeLength = bigdataFenxiTeamMonth1.getRunTimeLength();
		if(runTimeLength==null){
			runTimeLength = new BigDecimal("0");
		}
		String runTimeLengthText = DateUtil.getHourMinuteSecond(runTimeLength);
		bigdataFenxiTeamMonth.setRunTimeLengthText(runTimeLengthText);//行驶时长文本
		//转为小时
		bigdataFenxiTeamMonth.setRunTimeLengthHour(bigdataFenxiTeamMonth1.getRunTimeLengthHour());//行驶时长(小时）
		bigdataFenxiTeamMonth.setRunTimeLength(runTimeLength);//行驶时长（分）
		Integer alarmNum = bigdataFenxiTeamMonth1.getAlarmNum();
		if(alarmNum==null){
			alarmNum = 0;
		}
		bigdataFenxiTeamMonth.setAlarmNum(alarmNum);//报警数量

		//行驶里程前三名
		//map (countMonth yearNum teamId)
		List<BigdataTimeCarDayRec> list = bigdataTimeCarDayRecMapper.selectByMonthCountRunMileageTop(map);
		bigdataFenxiTeamMonth.setRunMileageTopThree(getRunMileageTopThreeText(list));
		//报警数量前三名
		List<BigdataTimeCarDayRec> list1 = bigdataTimeCarDayRecMapper.selectByMonthCountAlarmTop(map);
		bigdataFenxiTeamMonth.setAlarmNumTopThree(getAlarmNumTopThreeText(list1));
		//查询记录是否存在
		BigdataFenxiTeamMonth bigdataFenxiTeamMonth2 = mapper.selectByFenqu(map);
		if(bigdataFenxiTeamMonth2==null){
			bigdataFenxiTeamMonth.setCreateTime(new Date());
			mapper.insert(bigdataFenxiTeamMonth);
		}else {
			bigdataFenxiTeamMonth.setId(bigdataFenxiTeamMonth2.getId());
			bigdataFenxiTeamMonth.setUpdateTime(new Date());
			mapper.updateByfenPian(bigdataFenxiTeamMonth);
		}
		//报警分类统计
		String teamTransitType = bigdataFenxiTeamMonth.getTransitType();
		if(teamTransitType!=null && !teamTransitType.equals("")){
			//分段限速
			List<AlarmVo> alarmVoList = bigdataAlarmRecordService.countByTeamTransitTypeMonth(map);
			for (AlarmVo a:alarmVoList){
				BigdataFenxiTeamAlarmMonth bigdataFenxiTeamAlarmMonth = new BigdataFenxiTeamAlarmMonth();
				bigdataFenxiTeamAlarmMonth.setOwnerTeamMonthId(bigdataFenxiTeamMonth.getId());
				bigdataFenxiTeamAlarmMonth.setAlarmNum(a.getAlarmNum());
				if(runMileage.compareTo(BigDecimal.ZERO)==0){
					bigdataFenxiTeamAlarmMonth.setAlarmRate(new BigDecimal("0"));
				}else {
					bigdataFenxiTeamAlarmMonth.setAlarmRate(new BigDecimal(a.getAlarmNum()).divide(runMileage,2, RoundingMode.HALF_UP));
				}
				bigdataFenxiTeamAlarmMonth.setAlarmType(a.getAlarmType());
				bigdataFenxiTeamAlarmMonth.setAlarmTypeDesc(getAlarmTypeDesc(a.getAlarmType()));
				bigdataFenxiTeamAlarmMonth.setCountDate(countDay);
				bigdataFenxiTeamAlarmMonth.setCountMonth(countMonth);
				bigdataFenxiTeamAlarmMonth.setYearNum(yearNum);
				//统计车队内报警前三的车辆
				Map<String,Object> map1 = new HashMap<>();
				map1.put("teamId",team.getId());
				map1.put("countMonth",countMonth);
				map1.put("alarmType",a.getAlarmType());
				List<AlarmVo> alarmVoList1 = new ArrayList<>();
				if(a.getAlarmType().equals("2")){
					alarmVoList1 = bigdataAlarmRecordService.countByTeamTransitTypeTopThreeMonth(map1);
				}else if (a.getAlarmType().equals("4")){
					alarmVoList1 = bigdataAlarmRecordService.countByTeamTransitTypeTopThreeMonthNew(map1);
				}
				String topThreeCar = "";
				for(AlarmVo alarmVo:alarmVoList1){
					if(topThreeCar.equals("")){
						topThreeCar = alarmVo.getCarPlateNum()+"("+alarmVo.getAlarmNum()+")";
					}else {
						topThreeCar += ","+alarmVo.getCarPlateNum()+"("+alarmVo.getAlarmNum()+")";
					}
				}
				bigdataFenxiTeamAlarmMonth.setAlarmNumTopThree(topThreeCar);
				bigdataFenxiTeamAlarmMonthService.insertOrUpdate(bigdataFenxiTeamAlarmMonth);
			}
			//主动安全
			List<AlarmVo> safetyWarningList = bigdataSafetyWarningService.countByTeamTransitTypeMonth(map);
			for (AlarmVo a:safetyWarningList){
				BigdataFenxiTeamAlarmMonth bigdataFenxiTeamAlarmMonth = new BigdataFenxiTeamAlarmMonth();
				bigdataFenxiTeamAlarmMonth.setOwnerTeamMonthId(bigdataFenxiTeamMonth.getId());
				bigdataFenxiTeamAlarmMonth.setAlarmNum(a.getAlarmNum());
				if(runMileage.compareTo(BigDecimal.ZERO)==0){
					bigdataFenxiTeamAlarmMonth.setAlarmRate(new BigDecimal("0"));
				}else {
					bigdataFenxiTeamAlarmMonth.setAlarmRate(new BigDecimal(a.getAlarmNum()).divide(runMileage,2, RoundingMode.HALF_UP));
				}
				bigdataFenxiTeamAlarmMonth.setAlarmType(getSafeType(a.getAlarmType()));
				bigdataFenxiTeamAlarmMonth.setAlarmTypeDesc(a.getAlarmType());
				bigdataFenxiTeamAlarmMonth.setCountDate(countDay);
				bigdataFenxiTeamAlarmMonth.setCountMonth(countMonth);
				bigdataFenxiTeamAlarmMonth.setYearNum(yearNum);
				Map<String,Object> map1 = new HashMap<>();
				map1.put("teamId",team.getId());
				map1.put("countMonth",countMonth);
				map1.put("alarmType",a.getAlarmType());
				List<AlarmVo> alarmVoList1 = bigdataSafetyWarningService.countByTeamTransitTypeTopThreeMonth(map1);
				String topThreeCar = "";
				for(AlarmVo alarmVo:alarmVoList1){
					if(topThreeCar.equals("")){
						topThreeCar = alarmVo.getCarPlateNum()+"("+alarmVo.getAlarmNum()+")";
					}else {
						topThreeCar += ","+alarmVo.getCarPlateNum()+"("+alarmVo.getAlarmNum()+")";
					}
				}
				bigdataFenxiTeamAlarmMonth.setAlarmNumTopThree(topThreeCar);
				bigdataFenxiTeamAlarmMonthService.insertOrUpdate(bigdataFenxiTeamAlarmMonth);
			}
		}
	}
	//查询一个月之内的报警前三的车辆
	private String getAlarmNumTopThreeText(List<BigdataTimeCarDayRec> list) {
		if (list.size() == 0) {
			return "无";
		} else {
			String str = "";
			//取前三
			for (BigdataTimeCarDayRec bigdataTimeCarDayRec : list) {
				String mapKey = bigdataTimeCarDayRec.getCarPlateNum();//车牌号
				Integer mapValue = bigdataTimeCarDayRec.getAlarmNum();//报警数
				if (mapValue == 0) {
					if (str.equals("")) {
						str = "无";
						break;
					} else {
						return str;
					}
				} else {
					if (str.equals("")) {
						str = mapKey + "(" + mapValue + ")";
					} else {
						str += "，" + mapKey + "(" + mapValue + ")";
					}
				}
			}
			return str;
		}
	}

	//查询一个月之内的里程前三的车辆
	private String getRunMileageTopThreeText(List<BigdataTimeCarDayRec> list) {
		if (list.size() == 0) {
			return "无";
		} else {
			String str = "";
			//取前三
			for (BigdataTimeCarDayRec bigdataTimeCarDayRec : list) {
				String mapKey = bigdataTimeCarDayRec.getCarPlateNum();//车牌号
				BigDecimal mapValue = bigdataTimeCarDayRec.getSumMileage();//报警数
				if (mapValue.compareTo(BigDecimal.ZERO) == 0) {
					if (str.equals("")) {
						str = "无";
						break;
					} else {
						return str;
					}
				} else {
					if (str.equals("")) {
						str = mapKey + "(" + mapValue + ")";
					} else {
						str += "，" + mapKey + "(" + mapValue + ")";
					}
				}
			}
			return str;
		}
	}

	private String getTransitTypeText(String teamType){
		if(teamType !=null && teamType.equals("TEAM_KY")){
			return "客运";
		}else if(teamType !=null && teamType.equals("TEAM_WXHWYS")){
			return "危货";
		}else{
			return "普货";
		}
	}

	//计算报警数量/百公里
	private BigDecimal getBaoJingAndBaiGongLi(Integer baoJingNum, BigDecimal runMileage) {
		//a.divide(b, 2, RoundingMode.HALF_UP)
		if(runMileage.compareTo(BigDecimal.ZERO)==0){
			return new BigDecimal(0);
		}else {
			BigDecimal bigDecimalBaoJingNum = new BigDecimal(baoJingNum);
			BigDecimal bigDecimal = bigDecimalBaoJingNum.divide(runMileage,2, RoundingMode.HALF_UP);
			return bigDecimal;
		}
	}

	//计算平均速度
	private BigDecimal getAverageSpeed(BigDecimal runMileage, BigDecimal runTimeMinuter) {
		if(runTimeMinuter.compareTo(BigDecimal.ZERO)==0){
			return new BigDecimal(0);
		}else {
			BigDecimal bigDecimal = runMileage.divide(runTimeMinuter,2, RoundingMode.HALF_UP);
			return bigDecimal;
		}
	}

	//计算平均报警数量
	private BigDecimal getAverageAlarmNum(Integer baoJingNum, Integer sumNum) {
		if(sumNum==0){
			return new BigDecimal(0);
		}else {
			BigDecimal bigDecimalBaoJingNum = new BigDecimal(baoJingNum);
			BigDecimal bigDecimalCarNum = new BigDecimal(sumNum);
			BigDecimal bigDecimal = bigDecimalBaoJingNum.divide(bigDecimalCarNum,2, RoundingMode.HALF_UP);
			return bigDecimal;
		}
	}

	//计算平均行驶时长（小时）
	private BigDecimal getAverageRunTimeLength(BigDecimal runTimeMinuter, Integer sumNum) {
		if(sumNum==0){
			return new BigDecimal(0);
		}else {
			BigDecimal bigDecimalCarNum = new BigDecimal(sumNum);
			BigDecimal bigDecimal = runTimeMinuter.divide(bigDecimalCarNum,2, RoundingMode.HALF_UP);
			return bigDecimal;
		}
	}

	//计算平均行驶里程
	private BigDecimal getAverageRunMileage(BigDecimal runMileage, Integer sumNum) {
		if(sumNum==0){
			return new BigDecimal(0);
		}else {
			BigDecimal bigDecimalCarNum = new BigDecimal(sumNum);
			BigDecimal bigDecimal = runMileage.divide(bigDecimalCarNum,2, RoundingMode.HALF_UP);
			return bigDecimal;
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
