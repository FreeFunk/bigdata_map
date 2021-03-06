package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.mapper.BigdataFenxiTeamWeekMapper;
import com.edgedo.bigdata.mapper.BigdataTimeCarDayRecMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamWeekView;
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
public class BigdataFenxiTeamWeekService {
	
	
	@Autowired
	private BigdataFenxiTeamWeekMapper mapper;
	@Autowired
	private BigdataFenxiTeamDayService bigdataFenxiTeamDayService;
	@Autowired
	private BigdataAlarmRecordService bigdataAlarmRecordService;
	@Autowired
	private BigdataSafetyWarningService bigdataSafetyWarningService;
	@Autowired
	private BigdataTimeCarDayRecMapper bigdataTimeCarDayRecMapper;
	@Autowired
	private BigdataFenxiTeamAlarmWeekService bigdataFenxiTeamAlarmWeekService;


	
	public List<BigdataFenxiTeamWeekView> listPage(BigdataFenxiTeamWeekQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFenxiTeamWeek voObj) {
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
	public String update(BigdataFenxiTeamWeek voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFenxiTeamWeek voObj) {
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
	public BigdataFenxiTeamWeek loadById(String id) {
		return mapper.selectById(id);
	}


    public List<BigdataFenxiTeamWeek> selectByWeekAnQuanQianShi(String carType, String xianQuId, Integer timeChangeWeek) {
    	return mapper.selectByWeekAnQuanQianShi( carType,  xianQuId,  timeChangeWeek);
	}

	public List<BigdataFenxiTeamWeek> selectByWeekAnQuanHouShi(String carType, String xianQuId, Integer timeChangeWeek) {
		return mapper.selectByWeekAnQuanHouShi( carType,  xianQuId,  timeChangeWeek);
	}

	public List<BigdataFenxiTeamWeek> selectByWeekBaiGongLiQianShi(String carType, String xianQuId, Integer timeChangeWeek) {
		return mapper.selectByWeekBaiGongLiQianShi( carType,  xianQuId,  timeChangeWeek);
	}

	public List<BigdataFenxiTeamWeek> selectByWeekBaiGongLiHouShi(String carType, String xianQuId, Integer timeChangeWeek) {
		return mapper.selectByWeekBaiGongLiHouShi( carType,  xianQuId,  timeChangeWeek);
	}

	public BigdataFenxiTeamWeek selectById(BigdataFenxiTeamWeekQuery query){
		return mapper.selectById(query);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(TransitCarTeam team, int weekYear, int weekOfYear, Date beginDate, Date endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String beginDateStr = sdf.format(beginDate);
		Integer countDate = Integer.parseInt(beginDateStr);
		Integer countMonth = Integer.parseInt(beginDateStr)/100;
		Map<String,Object> map = new HashedMap();
		map.put("teamId",team.getId());
		//统计该车的记录
		BigdataFenxiTeamWeek bigdataFenxiTeamWeek = new BigdataFenxiTeamWeek();
		bigdataFenxiTeamWeek.setId(Guid.guid());
		bigdataFenxiTeamWeek.setProvinceId(team.getProvinceId());
		bigdataFenxiTeamWeek.setProvinceName(team.getProvinceName());
		bigdataFenxiTeamWeek.setCityId(team.getCityId());
		bigdataFenxiTeamWeek.setCityName(team.getCityName());
		bigdataFenxiTeamWeek.setXianquId(team.getXianquId());
		bigdataFenxiTeamWeek.setXianquName(team.getXianquName());
		bigdataFenxiTeamWeek.setTeamId(team.getId());
		bigdataFenxiTeamWeek.setTeamName(team.getTeamName());
		bigdataFenxiTeamWeek.setTeamType(team.getCompanyLevel());
		bigdataFenxiTeamWeek.setTransitType(getTransitTypeText(team.getCompanyLevel()));
		bigdataFenxiTeamWeek.setCountWeek(weekOfYear);
		bigdataFenxiTeamWeek.setStartCountDate(beginDate);
		bigdataFenxiTeamWeek.setEndCountDate(endDate);
		bigdataFenxiTeamWeek.setCountDate(countDate);
		bigdataFenxiTeamWeek.setCountMonth(countMonth);
		bigdataFenxiTeamWeek.setYearNum(weekYear);
		map.put("beginDate",beginDate);
		map.put("endDate",endDate);
		map.put("countWeek",weekOfYear);
		map.put("countMonth",countMonth);
		map.put("yearNum",weekYear);
		//COUNT_CAR_NUM 统计车辆数 RUN_MILEAGE 行驶里程 行驶时长（分）RUN_TIME_LENGTH
        //行驶时长(小时）RUN_TIME_LENGTH_HOUR 报警数量 ALARM_NUM
        BigdataFenxiTeamWeek bigdataFenxiTeamWeek1 = bigdataFenxiTeamDayService.countMileageByWeek(map);
		if(bigdataFenxiTeamWeek1==null){
			bigdataFenxiTeamWeek1 = new BigdataFenxiTeamWeek();
		}
		bigdataFenxiTeamWeek.setCountCarNum(bigdataFenxiTeamWeek1.getCountCarNum());//统计车辆数
        bigdataFenxiTeamWeek.setAlarmRate(getBaoJingAndBaiGongLi(bigdataFenxiTeamWeek1.getAlarmNum(),bigdataFenxiTeamWeek1.getRunMileage()));//报警数量/百公里
        bigdataFenxiTeamWeek.setAverageSpeed(getAverageSpeed(bigdataFenxiTeamWeek1.getRunMileage(),bigdataFenxiTeamWeek1.getRunTimeLengthHour()));//平均速度
        bigdataFenxiTeamWeek.setAverageRunMileage(getAverageRunMileage(bigdataFenxiTeamWeek1.getRunMileage(),bigdataFenxiTeamWeek1.getCountCarNum()));//平均行驶里程
        bigdataFenxiTeamWeek.setAverageRunTimeLength(getAverageRunTimeLength(bigdataFenxiTeamWeek1.getRunTimeLengthHour(),bigdataFenxiTeamWeek1.getCountCarNum()));//平均行驶时长
        bigdataFenxiTeamWeek.setAverageAlarmNum(getAverageAlarmNum(bigdataFenxiTeamWeek1.getAlarmNum(),bigdataFenxiTeamWeek1.getCountCarNum()));//平均报警数
        //23 34 45 56
		BigDecimal runMileage = bigdataFenxiTeamWeek1.getRunMileage();
		if(runMileage==null){
			runMileage = new BigDecimal("0");
		}
		bigdataFenxiTeamWeek.setRunMileage(runMileage);//行驶里程
		BigDecimal runTimeLength = bigdataFenxiTeamWeek1.getRunTimeLength();
		if(runTimeLength==null){
			runTimeLength = new BigDecimal("0");
		}
		//转为小时分
		String runTimeLengthText = DateUtil.getHourMinuteSecond(runTimeLength);
		bigdataFenxiTeamWeek.setRunTimeLengthText(runTimeLengthText);//行驶时长文本
		//转为小时
		bigdataFenxiTeamWeek.setRunTimeLengthHour(bigdataFenxiTeamWeek1.getRunTimeLengthHour());//行驶时长(小时）
		bigdataFenxiTeamWeek.setRunTimeLength(runTimeLength);//行驶时长（分）
		Integer alarmNum = bigdataFenxiTeamWeek1.getAlarmNum();
		if(alarmNum==null){
			alarmNum = 0;
		}
		bigdataFenxiTeamWeek.setAlarmNum(alarmNum);//报警数量
		//行驶里程前三名
		//map (beginDate endDate countMonth yearNum teamId)
		List<BigdataTimeCarDayRec> list = bigdataTimeCarDayRecMapper.selectByWeekCountRunMileageTop(map);
		bigdataFenxiTeamWeek.setRunMileageTopThree(getRunMileageTopThreeText(list));
		//报警数量前三名
		List<BigdataTimeCarDayRec> list1 = bigdataTimeCarDayRecMapper.selectByWeekCountAlarmTop(map);
		bigdataFenxiTeamWeek.setAlarmNumTopThree(getAlarmNumTopThreeText(list1));

		//统计报警的数量
		//报警信息周统计
		List<AlarmVo> alarmVoList = new ArrayList<>();
		List<AlarmVo> safetyWarningList = new ArrayList<>();
		String teamTransitType = bigdataFenxiTeamWeek.getTransitType();
		if(teamTransitType!=null && !teamTransitType.equals("")){
			//分段限速
			String teamId = team.getId();
			if(teamId!=null && !teamId.equals("neiwang")){
				alarmVoList = bigdataAlarmRecordService.countByTeamTransitType(map);
				//主动安全
				safetyWarningList = bigdataSafetyWarningService.countByTeamTransitType(map);
			}
		}
		//查询记录是否存在
		BigdataFenxiTeamWeek bigdataFenxiTeamWeek3 = mapper.selectByFenqu(map);
		if(bigdataFenxiTeamWeek3==null){
			bigdataFenxiTeamWeek.setCreateTime(new Date());
			mapper.insert(bigdataFenxiTeamWeek);
		}else {
			bigdataFenxiTeamWeek.setId(bigdataFenxiTeamWeek3.getId());
			bigdataFenxiTeamWeek.setUpdateTime(new Date());
			mapper.updateByfenPian(bigdataFenxiTeamWeek);
		}
		//分段限速报警统计
		for (AlarmVo a:alarmVoList){
			BigdataFenxiTeamAlarmWeek bigdataFenxiTeamAlarmWeek = new BigdataFenxiTeamAlarmWeek();
			bigdataFenxiTeamAlarmWeek.setOwnerTeamDayId(bigdataFenxiTeamWeek.getId());
			bigdataFenxiTeamAlarmWeek.setAlarmNum(a.getAlarmNum());
			if(runMileage.compareTo(BigDecimal.ZERO)==0){
				bigdataFenxiTeamAlarmWeek.setAlarmRate(new BigDecimal("0"));
			}else {
				bigdataFenxiTeamAlarmWeek.setAlarmRate(new BigDecimal(a.getAlarmNum()).divide(runMileage,2, RoundingMode.HALF_UP));
			}
			bigdataFenxiTeamAlarmWeek.setAlarmType(a.getAlarmType());
			bigdataFenxiTeamAlarmWeek.setAlarmTypeDesc(getAlarmTypeDesc(a.getAlarmType()));
			bigdataFenxiTeamAlarmWeek.setCountDate(countDate);
			bigdataFenxiTeamAlarmWeek.setCountWeek(weekOfYear);
			bigdataFenxiTeamAlarmWeek.setStartCountDate(beginDate);
			bigdataFenxiTeamAlarmWeek.setEndCountDate(endDate);
			bigdataFenxiTeamAlarmWeek.setCountMonth(countMonth);
			bigdataFenxiTeamAlarmWeek.setYearNum(weekYear);
			//统计车队内报警前三的车辆
			Map<String,Object> map1 = new HashMap<>();
			map1.put("teamId",team.getId());
			map1.put("beginDate",beginDate);
			map1.put("endDate",endDate);
			map1.put("countMonth",countMonth);
			map1.put("alarmType",a.getAlarmType());
			List<AlarmVo> alarmVoList1 = new ArrayList<>();
			if(a.getAlarmType().equals("2")){
				alarmVoList1 = bigdataAlarmRecordService.countByTeamTransitTypeTopThree(map1);
			}else if (a.getAlarmType().equals("4")){
				alarmVoList1 = bigdataAlarmRecordService.countByTeamTransitTypeTopThreeNew(map1);
			}
			String topThreeCar = "";
			for(AlarmVo alarmVo:alarmVoList1){
				if(topThreeCar.equals("")){
					topThreeCar = alarmVo.getCarPlateNum()+"("+alarmVo.getAlarmNum()+")";
				}else {
					topThreeCar += ","+alarmVo.getCarPlateNum()+"("+alarmVo.getAlarmNum()+")";
				}
			}
			bigdataFenxiTeamAlarmWeek.setAlarmNumTopThree(topThreeCar);
			bigdataFenxiTeamAlarmWeekService.insertOrUpdate(bigdataFenxiTeamAlarmWeek);
		}
		//主动安全报警统计
		for (AlarmVo a:safetyWarningList){
			BigdataFenxiTeamAlarmWeek bigdataFenxiTeamAlarmWeek = new BigdataFenxiTeamAlarmWeek();
			bigdataFenxiTeamAlarmWeek.setOwnerTeamDayId(bigdataFenxiTeamWeek.getId());
			bigdataFenxiTeamAlarmWeek.setAlarmNum(a.getAlarmNum());
			if(runMileage.compareTo(BigDecimal.ZERO)==0){
				bigdataFenxiTeamAlarmWeek.setAlarmRate(new BigDecimal("0"));
			}else {
				bigdataFenxiTeamAlarmWeek.setAlarmRate(new BigDecimal(a.getAlarmNum()).divide(runMileage,2, RoundingMode.HALF_UP));
			}
			bigdataFenxiTeamAlarmWeek.setAlarmType(getSafeType(a.getAlarmType()));
			bigdataFenxiTeamAlarmWeek.setAlarmTypeDesc(a.getAlarmType());
			bigdataFenxiTeamAlarmWeek.setCountDate(countDate);
			bigdataFenxiTeamAlarmWeek.setCountWeek(weekOfYear);
			bigdataFenxiTeamAlarmWeek.setStartCountDate(beginDate);
			bigdataFenxiTeamAlarmWeek.setEndCountDate(endDate);
			bigdataFenxiTeamAlarmWeek.setCountMonth(countMonth);
			bigdataFenxiTeamAlarmWeek.setYearNum(weekYear);
			Map<String,Object> map1 = new HashMap<>();
			map1.put("teamId",team.getId());
			map1.put("beginDate",beginDate);
			map1.put("endDate",endDate);
			map1.put("countMonth",countMonth);
			map1.put("alarmType",a.getAlarmType());
			List<AlarmVo> alarmVoList1 = bigdataSafetyWarningService.countByTeamTransitTypeTopThree(map1);
			String topThreeCar = "";
			for(AlarmVo alarmVo:alarmVoList1){
				if(topThreeCar.equals("")){
					topThreeCar = alarmVo.getCarPlateNum()+"("+alarmVo.getAlarmNum()+")";
				}else {
					topThreeCar += ","+alarmVo.getCarPlateNum()+"("+alarmVo.getAlarmNum()+")";
				}
			}
			bigdataFenxiTeamAlarmWeek.setAlarmNumTopThree(topThreeCar);
			bigdataFenxiTeamAlarmWeekService.insertOrUpdate(bigdataFenxiTeamAlarmWeek);
		}
	}

	//查询7天之内的报警前三的车辆
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

	//查询7天之内的里程前三的车辆
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
        if(runMileage==null || runMileage.compareTo(BigDecimal.ZERO)==0){
            return new BigDecimal(0);
        }else {
            BigDecimal bigDecimalBaoJingNum = new BigDecimal(baoJingNum);
            BigDecimal bigDecimal = bigDecimalBaoJingNum.divide(runMileage,2, RoundingMode.HALF_UP);
            return bigDecimal;
        }
    }

    //计算平均速度
    private BigDecimal getAverageSpeed(BigDecimal runMileage, BigDecimal runTimeMinuter) {
        if(runTimeMinuter==null || runTimeMinuter.compareTo(BigDecimal.ZERO)==0){
            return new BigDecimal(0);
        }else {
            BigDecimal bigDecimal = runMileage.divide(runTimeMinuter,2, RoundingMode.HALF_UP);
            return bigDecimal;
        }
    }

    //计算平均报警数量
    private BigDecimal getAverageAlarmNum(Integer baoJingNum, Integer sumNum) {
		if(baoJingNum==null){
			baoJingNum = 0;
		}
        if(sumNum==null || sumNum==0){
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
		if(runTimeMinuter==null){
			runTimeMinuter = new BigDecimal("0");
		}
        if(sumNum==null || sumNum==0){
            return new BigDecimal(0);
        }else {
            BigDecimal bigDecimalCarNum = new BigDecimal(sumNum);
            BigDecimal bigDecimal = runTimeMinuter.divide(bigDecimalCarNum,2, RoundingMode.HALF_UP);
            return bigDecimal;
        }
    }

    //计算平均行驶里程
    private BigDecimal getAverageRunMileage(BigDecimal runMileage, Integer sumNum) {
		if(runMileage==null){
			runMileage = new BigDecimal("0");
		}
        if(sumNum==null || sumNum==0){
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
