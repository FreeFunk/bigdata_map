package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.mapper.BigdataTimeCarDayRecMapper;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecView;
import com.edgedo.common.util.Guid;
import io.swagger.models.auth.In;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataTimeCarDayRecService {

	@Autowired
	private BigdataAlarmRecordService alarmRecordService;

	@Autowired
	private BigdataSafetyWarningService bigdataSafetyWarningService;

	@Autowired
	private BigdataTimeCarDayRecMapper mapper;

	@Autowired
	private CarInfoService carInfoService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdfInt = new SimpleDateFormat("yyyyMMdd");

	
	public List<BigdataTimeCarDayRecView> listPage(BigdataTimeCarDayRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataTimeCarDayRec voObj) {
		String id = voObj.getId();
		if(id==null || id.length()==0){
			voObj.setId(Guid.guid());
		}
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataTimeCarDayRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataTimeCarDayRec voObj) {
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
	public BigdataTimeCarDayRec loadById(String id) {
		return mapper.selectById(id);
	}

	//将车辆的行驶信息生成每日的日志
   /* public void updateSynCarDayRec(CarInfo car) {
		String carPlateNum = car.getCarPlateNum();
		String carPlateColor = car.getCarPlateColour();
		Date curDate = new Date();
		//设置主键 日期+车牌号+车牌颜色
		String dateStr = sdf.format(curDate);
		String dayRecId = dateStr + "-" + carPlateNum + "-" + carPlateColor;
		BigdataTimeCarDayRec bigdataTimeCarDayRec = loadById(dayRecId);
		if(bigdataTimeCarDayRec == null){
			//数据库中没有
			bigdataTimeCarDayRec = new BigdataTimeCarDayRec();
			bigdataTimeCarDayRec.setId(dayRecId);
			bigdataTimeCarDayRec.setCarFrameNum(car.getCarFrameNum());
			bigdataTimeCarDayRec.setCarPlateNum(carPlateNum);
			bigdataTimeCarDayRec.setCarPlateColor(carPlateColor);
			bigdataTimeCarDayRec.setCarType(car.getCarType());
			bigdataTimeCarDayRec.setCountTime(curDate);
			bigdataTimeCarDayRec.setCreateTime(new Date());
			bigdataTimeCarDayRec.setDuskMileage(car.getDuskMileage());
			Integer duskMinuteNum = car.getDuskMinuteNum();
			if(duskMinuteNum==null)duskMinuteNum=0;
			bigdataTimeCarDayRec.setDuskTime(new BigDecimal(duskMinuteNum));
			bigdataTimeCarDayRec.setEarlyMorningMileage(car.getMorningMileage());
			Integer morningMinuteNum = car.getMorningMinuteNum();
			if(morningMinuteNum==null)morningMinuteNum=0;
			bigdataTimeCarDayRec.setEarlyMorningTime(new BigDecimal(morningMinuteNum));
			bigdataTimeCarDayRec.setLingchenMileage(car.getLingchenMileage());
			Integer LingchenMinuteNum = car.getLingchenMinuteNum();
			if(LingchenMinuteNum==null)LingchenMinuteNum=0;
			bigdataTimeCarDayRec.setLingchenTime(new BigDecimal(LingchenMinuteNum));
			bigdataTimeCarDayRec.setNightMileage(car.getMidnightMileage());
			Integer MidnightMinuteNum = car.getMidnightMinuteNum();
			if(MidnightMinuteNum==null)MidnightMinuteNum=0;
			bigdataTimeCarDayRec.setNightTime(new BigDecimal(MidnightMinuteNum));
			bigdataTimeCarDayRec.setNoonMileage(car.getNoonMileage());
			Integer NoonMinuteNum = car.getNoonMinuteNum();
			if(NoonMinuteNum==null)NoonMinuteNum=0;
			bigdataTimeCarDayRec.setNoonTime(new BigDecimal(NoonMinuteNum));
			bigdataTimeCarDayRec.setSumDuration(car.getTodayTimeTotal());
			bigdataTimeCarDayRec.setSumMileage(car.getTodayMileageTotal());
			insert(bigdataTimeCarDayRec);
		}else{
			//数据库中有需要更新
			bigdataTimeCarDayRec.setCarFrameNum(car.getCarFrameNum());
			bigdataTimeCarDayRec.setDuskMileage(car.getDuskMileage());
			Integer duskMinuteNum = car.getDuskMinuteNum();
			if(duskMinuteNum==null)duskMinuteNum=0;
			bigdataTimeCarDayRec.setDuskTime(new BigDecimal(duskMinuteNum));
			bigdataTimeCarDayRec.setEarlyMorningMileage(car.getMorningMileage());
			Integer morningMinuteNum = car.getMorningMinuteNum();
			if(morningMinuteNum==null)morningMinuteNum=0;
			bigdataTimeCarDayRec.setEarlyMorningTime(new BigDecimal(morningMinuteNum));
			bigdataTimeCarDayRec.setLingchenMileage(car.getLingchenMileage());
			Integer LingchenMinuteNum = car.getLingchenMinuteNum();
			if(LingchenMinuteNum==null)LingchenMinuteNum=0;
			bigdataTimeCarDayRec.setLingchenTime(new BigDecimal(LingchenMinuteNum));
			bigdataTimeCarDayRec.setNightMileage(car.getMidnightMileage());
			Integer MidnightMinuteNum = car.getMidnightMinuteNum();
			if(MidnightMinuteNum==null)MidnightMinuteNum=0;
			bigdataTimeCarDayRec.setNightTime(new BigDecimal(MidnightMinuteNum));
			bigdataTimeCarDayRec.setNoonMileage(car.getNoonMileage());
			Integer NoonMinuteNum = car.getNoonMinuteNum();
			if(NoonMinuteNum==null)NoonMinuteNum=0;
			bigdataTimeCarDayRec.setNoonTime(new BigDecimal(NoonMinuteNum));
			bigdataTimeCarDayRec.setSumDuration(car.getTodayTimeTotal());
			bigdataTimeCarDayRec.setSumMileage(car.getTodayMileageTotal());
			update(bigdataTimeCarDayRec);

		}


    }*/
	//分组统计各个类型的车辆的汇总信息
    public List<BigdataTimeCarDayRec> sumGroupByCarTypeOfDay(Integer countDate) {
    	Integer countMonth = countDate/100;
    	Map<String,Object> param = new HashMap<String,Object>();
		param.put("countDate",countDate);
		param.put("countMonth",countMonth);
		return mapper.sumGroupByCarTypeOfDay(param);

    }

	/**
	 * 根据车辆的实时信息更新车辆的历史信息
	 * @param car
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdateCarDayHis(CarInfo car,Date curr) {
		//添加时间字符串
		String dateStr = sdfInt.format(curr);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Integer yearNum = countMonth/100;
		//历史的id = 日期  + 车牌号 + 车牌颜色
		String id = dateStr + "-" + car.getCarPlateNum() + "-" + car.getCarPlateColour();
		BigdataTimeCarDayRec oraDayHistory = loadByIdAndDate(id,countMonth);
		//判断是否有记录
		BigdataTimeCarDayRec dayHistory = new BigdataTimeCarDayRec();
		//将车辆的数据挪到历史对象中
		dayHistory = new BigdataTimeCarDayRec();
		dayHistory.setId(id);
		//运输类型
		dayHistory.setTransitType(car.getCarTransitType());
		//统计车辆的报警数量
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlateNum",car.getCarPlateNum());
		param.put("carPlateColor",car.getCarPlateColour());
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		//常规报警数量
		int commonAlarmNum = alarmRecordService.countByCarPlateNum(param);
		dayHistory.setCommonAlarmNum(commonAlarmNum);
		//常规处理数量
		int commonHandleNum = alarmRecordService.countHandleNumByCarPlateNum(param);
		dayHistory.setCommonHandleNum(commonHandleNum);
		//主动安全报警数量
		int safeWarningNum = bigdataSafetyWarningService.countByCarPlateNum(param);
		dayHistory.setSafeAlarmNum(safeWarningNum);
		//主动安全处理数量
		int safeHandleNum = bigdataSafetyWarningService.countHandleNumByCarPlateNum(param);
		dayHistory.setSafeHandleNum(safeHandleNum);
		//报警数量
		dayHistory.setAlarmNum(commonAlarmNum+safeWarningNum);
		//是否报警
		if(commonAlarmNum>0 || safeWarningNum>0){
			dayHistory.setIsAlarm("1");
		}else {
			dayHistory.setIsAlarm("0");
		}
		dayHistory.setQualifiedState(car.getQualifiedState());
		dayHistory.setEmpName(car.getEmpName());
		dayHistory.setEmpCode(car.getEmpCode());
		dayHistory.setEmpPhone(car.getEmpPhone());
		dayHistory.setEmpId(car.getEmpId());
		dayHistory.setCarFrameNum(car.getCarFrameNum());
		dayHistory.setCarPlateColorText(car.getCarPlateColorText());
		dayHistory.setCarPlateColor(car.getCarPlateColour());
		dayHistory.setCarPlateNum(car.getCarPlateNum());
		dayHistory.setCityId(car.getCityId());
		dayHistory.setCityName(car.getCityName());
		dayHistory.setCountDate(countDate);
		dayHistory.setCountMonth(countMonth);
		dayHistory.setYearNum(yearNum);
		dayHistory.setCreateTime(new Date());

		dayHistory.setDuskMileage(car.getDuskMileage());
		BigDecimal duskMinuteNum = car.getDuskMinuteNum();
		if(duskMinuteNum==null)duskMinuteNum=new BigDecimal(0);
		dayHistory.setDuskTime(duskMinuteNum);

		dayHistory.setEarlyMorningMileage(car.getMorningMileage());
		BigDecimal morningMinuteNum = car.getMorningMinuteNum();
		if(morningMinuteNum==null)morningMinuteNum = new BigDecimal(0);
		dayHistory.setEarlyMorningTime(morningMinuteNum);

		dayHistory.setLingchenMileage(car.getLingchenMileage());
		BigDecimal LingchenMinuteNum = car.getLingchenMinuteNum();
		if(LingchenMinuteNum==null)LingchenMinuteNum=new BigDecimal(0);
		dayHistory.setLingchenTime(LingchenMinuteNum);

		dayHistory.setNightMileage(car.getMidnightMileage());
		BigDecimal MidnightMinuteNum = car.getMidnightMinuteNum();
		if(MidnightMinuteNum==null)MidnightMinuteNum=new BigDecimal(0);
		dayHistory.setNightTime(MidnightMinuteNum);

		dayHistory.setNoonMileage(car.getNoonMileage());
		BigDecimal NoonMinuteNum = car.getNoonMinuteNum();
		if(NoonMinuteNum==null)NoonMinuteNum=new BigDecimal(0);
		dayHistory.setNoonTime(NoonMinuteNum);

		dayHistory.setSumDuration(car.getTodayTimeTotal());
		dayHistory.setSumMileage(car.getTodayMileageTotal());
		dayHistory.setOnlineState(car.getOnlineState());
		dayHistory.setOperatFlag(car.getOperatFlag());
		dayHistory.setProvinceId(car.getProvinceId());
		dayHistory.setProvinceName(car.getProvinceName());
		dayHistory.setSumMileage(car.getTodayMileageTotal());
		dayHistory.setSumDuration(car.getTodayTimeTotal());
		dayHistory.setXianquId(car.getXianquId());
		dayHistory.setXianquName(car.getXianquName());
		dayHistory.setCarType(car.getCarType());
		dayHistory.setOwnerName(car.getOwnerName());
		dayHistory.setOwnerPhoneNum(car.getOwnerPhoneNum());
		dayHistory.setOwnerTeamId(car.getOwnerTeamId());
		dayHistory.setOwnerTeamName(car.getOwnerTeamName());
		BigDecimal s = new BigDecimal("1600");
		if(car.getTodayMileageTotal()==null || car.getTodayMileageTotal().compareTo(s)>0){
			dayHistory.setSumMileage(new BigDecimal("0"));
		}
		//计算平均速度
		if(car.getTodayMileageTotal()!=null && car.getTodayTimeTotal().doubleValue()!=0){
			BigDecimal miniNum = car.getTodayTimeTotal().divide(new BigDecimal("60"),2,BigDecimal.ROUND_HALF_UP);
			BigDecimal avgSpeed = new BigDecimal(0);
			if(miniNum.doubleValue()>0){
				avgSpeed = car.getTodayMileageTotal().divide(
						miniNum
						,2,BigDecimal.ROUND_HALF_UP);
			}
			if(avgSpeed.doubleValue()>95){
				int randNumber =new Random().nextInt(90-80)+80;
				dayHistory.setAvgSpeed(new BigDecimal(""+randNumber));
			}else {
				dayHistory.setAvgSpeed(avgSpeed);
			}
		}else {
			dayHistory.setAvgSpeed(new BigDecimal("0"));
		}
		//一类时段是凌晨
		BigDecimal lingChenMileAge = dayHistory.getLingchenMileage();
		BigDecimal lingchenTime = dayHistory.getLingchenTime();
		double  lingChenMileAgeDou = lingChenMileAge.doubleValue();
		double lingchenTimeDou = lingchenTime.doubleValue();
		if(lingChenMileAgeDou>10 && lingchenTimeDou>20){
			dayHistory.setFirstDangerTimeFlag(1);
		}else{
			dayHistory.setFirstDangerTimeFlag(0);
		}

		//二类时段是 清晨和黄昏
		BigDecimal morningMileage = dayHistory.getEarlyMorningMileage();
		BigDecimal morningTime =dayHistory.getEarlyMorningTime();
		BigDecimal duskMileage = dayHistory.getDuskMileage();
		BigDecimal duskTime = dayHistory.getDuskTime();
		double morningMileageDou = morningMileage.doubleValue();
		double morningTimeDou = morningTime.doubleValue();
		double duskMileageDou = duskMileage.doubleValue();
		double duskTimeDou = duskTime.doubleValue();
		if((morningMileageDou>10&&morningTimeDou>10) || (duskMileageDou>10&&duskTimeDou>10)){
			dayHistory.setSecondDangerTimeFlag(1);
		}else{
			dayHistory.setSecondDangerTimeFlag(0);
		}

		//三类时段是 中午
		BigDecimal noonMileage = dayHistory.getNoonMileage();
		BigDecimal noonTime = dayHistory.getNoonTime();

		double noonMileageDou = noonMileage.doubleValue();
		double noonTimeDou = noonTime.doubleValue();
		if(noonMileageDou>10&&noonTimeDou>10){
			dayHistory.setThirdDangerTimeFlag(1);
		}else{
			dayHistory.setThirdDangerTimeFlag(0);
		}

		if(oraDayHistory==null){
			//无记录增加
			//设置各个危险统计初始化
			dayHistory.setOverSpeedNum(0);
			dayHistory.setIsOverSpeed("0");
			dayHistory.setIsFatigue("0");
			dayHistory.setIsSeriousFatigue("0");
			dayHistory.setFatigueNum(0);
			dayHistory.setIsDangerFatigue("0");
			dayHistory.setDangerFatigueNum(0);
			dayHistory.setIsHighWayOverSpeed("0");
			dayHistory.setHighWayOverSpeedNum(0);
			dayHistory.setIsGuodaoOverSpeed("0");
			dayHistory.setGuodaoOverSpeedNum(0);
			dayHistory.setIsSeriousOverSpeed("0");
			dayHistory.setSeriousOverSpeedNum(0);
			dayHistory.setIsDangerOverSpeed("0");
			dayHistory.setDangerOverSpeedNum(0);
			dayHistory.setIsHighWaySerOverSpeed("0");
			dayHistory.setHighWaySerOverSpeedNum(0);
			dayHistory.setIsGuodaoSerOverSpeed("0");
			dayHistory.setGuodaoSerOverSpeedNum(0);
			dayHistory.setIsHighWayDangerOverSpeed("0");
			dayHistory.setHighWayDangerOverSpeedNum(0);
			dayHistory.setIsGuodaoDangerOverSpeed("0");
			dayHistory.setGuodaoDangerOverSpeedNum(0);
			insert(dayHistory);
		}else{
			//有记录更新
			updateByFenPian(dayHistory);
		}
		//统计严重疲劳次数//todo
		/*int count = alarmRecordService.countDayFatigueOfCar(car.getCarPlateNum(),car.getCarPlateColour(),curr);
		if(count>20){
			carInfoService.updateIsImportant(car.getId());
		}*/

	}

	/**
	 * 根据主键和分片字段查询
	 * @param id
	 * @param countMonth
	 * @return
	 */
	private BigdataTimeCarDayRec loadByIdAndDate(String id, Integer countMonth) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id",id);
		param.put("countMonth",countMonth);
		return mapper.loadByIdAndDate(param);

	}

	/**
	 * 统计月份的情况
	 * @param countMonth
	 * @param carType
	 * @return
	 */
	public BigdataTimeCarSumCount selectSumGroupCarInfoMonth(int countMonth, String carType) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("carType",carType);
		List<BigdataTimeCarDayRec> firstCount = mapper.selectSumGroupCarInfoMonthFirstCount(param);
		List<BigdataTimeCarDayRec> secondCount = mapper.selectSumGroupCarInfoMonthSecondCount(param);
		List<BigdataTimeCarDayRec> thirdCount = mapper.selectSumGroupCarInfoMonthThirdCount(param);
		BigdataTimeCarSumCount carDayRec = new BigdataTimeCarSumCount();
		carDayRec.setCarType(carType);
		carDayRec.setCountMonth(countMonth);
		carDayRec.setFirstDangerTimeNum(firstCount.size());
		carDayRec.setSecondDangerTimeNum(secondCount.size());
		carDayRec.setThirdDangerTimeNum(thirdCount.size());
		return carDayRec;
	}

	/**
	 * 统计车辆的疲劳和超速情况
	 * @param car
	 * @param cur
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdateOverSpeedAndFitigue(CarInfo car, Date cur) {
		String carPlateNum = car.getCarPlateNum();
		String carPlateColor = car.getCarPlateColour();

		//统计超速次数
		int overSpeedNum = alarmRecordService.countDayOverSpeedOfCar(carPlateNum,carPlateColor,cur);
		//统计疲劳次数
		int fatigueNum = alarmRecordService.countDayFatigueOfCar(carPlateNum,carPlateColor,cur);
		//统计高速超速次数
		int highWayOverSpeedNum = alarmRecordService.countDayHighWayOverSpeedOfCar(
				carPlateNum,carPlateColor,cur,null,null);

		//统计国道超速次数
		int guodaoOverSpeedNum = alarmRecordService.countDayGuodaoWayOverSpeedOfCar(
				carPlateNum,carPlateColor,cur,null,null);
		//统计严重超速次数
		int seriousOverSpeedNum = alarmRecordService.countDaySeriousWayOverSpeedOfCar(carPlateNum,carPlateColor,cur);
		//统计危险时段超速次数
		int dangerOverSpeedNum = alarmRecordService.countDayDangerWayOverSpeedOfCar(carPlateNum,carPlateColor,cur);
		//统计危险时段疲劳次数
		int dangerFatigueNum = alarmRecordService.countDayDangerFatigueOfCar(carPlateNum,carPlateColor,cur);
		//高速严重超速次数
		int highWaySerOverSpeedNum = alarmRecordService.countDayHighWayOverSpeedOfCar(
				carPlateNum,carPlateColor,cur,"1",null);
		//国道严重超速次数
		int guodaoSerOverSpeedNum = alarmRecordService.countDayGuodaoWayOverSpeedOfCar(
				carPlateNum,carPlateColor,cur,"1",null);
		//高速危险时段超速次数
		int highWayDangerOverSpeedNum = alarmRecordService.countDayHighWayOverSpeedOfCar(
				carPlateNum,carPlateColor,cur,null,"1");
		//国道危险时段超速次数
		int guodaoDangerOverSpeedNum = alarmRecordService.countDayHighWayOverSpeedOfCar(
				carPlateNum,carPlateColor,cur,null,"1");

		String dateStr = sdfInt.format(cur);
		int countMonth = new Integer(dateStr)/100;
		//历史的id = 日期  + 车牌号 + 车牌颜色
		String id = dateStr + "-" + car.getCarPlateNum() + "-" + car.getCarPlateColour();
		BigdataTimeCarDayRec oraDayHistory = loadByIdAndDate(id,countMonth);
		if(oraDayHistory!=null){
			//判断是否有记录
			BigdataTimeCarDayRec dayHistory = new BigdataTimeCarDayRec();
			dayHistory.setId(id);
			if(overSpeedNum>0){
				dayHistory.setIsOverSpeed("1");
			}else{
				dayHistory.setIsOverSpeed("0");
			}
			dayHistory.setOverSpeedNum(overSpeedNum);
			if(fatigueNum>0){
				dayHistory.setIsFatigue("1");
			}else{
				dayHistory.setIsFatigue("0");
			}
			if(fatigueNum>=20){
				dayHistory.setIsSeriousFatigue("1");
			}else{
				dayHistory.setIsSeriousFatigue("0");
			}
			dayHistory.setFatigueNum(fatigueNum);
			if(highWayOverSpeedNum>0){
				dayHistory.setIsHighWayOverSpeed("1");
			}else{
				dayHistory.setIsHighWayOverSpeed("0");
			}
			dayHistory.setHighWayOverSpeedNum(highWayOverSpeedNum);
			if(guodaoOverSpeedNum>0){
				dayHistory.setIsGuodaoOverSpeed("1");
			}else{
				dayHistory.setIsGuodaoOverSpeed("0");
			}
			dayHistory.setGuodaoOverSpeedNum(guodaoOverSpeedNum);
			if(seriousOverSpeedNum>0){
				dayHistory.setIsSeriousOverSpeed("1");
			}else{
				dayHistory.setIsSeriousOverSpeed("0");
			}
			dayHistory.setSeriousOverSpeedNum(seriousOverSpeedNum);
			if(dangerOverSpeedNum>0){
				dayHistory.setIsDangerOverSpeed("1");
			}else{
				dayHistory.setIsDangerOverSpeed("0");
			}
			dayHistory.setDangerOverSpeedNum(dangerOverSpeedNum);
			if(dangerFatigueNum>0){
				dayHistory.setIsDangerFatigue("1");
			}else{
				dayHistory.setIsDangerFatigue("0");
			}

			dayHistory.setDangerFatigueNum(dangerFatigueNum);
			if(highWaySerOverSpeedNum>0){
				dayHistory.setIsHighWaySerOverSpeed("1");
			}else{
				dayHistory.setIsHighWaySerOverSpeed("0");
			}
			dayHistory.setHighWaySerOverSpeedNum(highWaySerOverSpeedNum);
			if(guodaoSerOverSpeedNum>0){
				dayHistory.setIsGuodaoSerOverSpeed("1");
			}else{
				dayHistory.setIsGuodaoSerOverSpeed("0");
			}
			dayHistory.setGuodaoSerOverSpeedNum(guodaoSerOverSpeedNum);

			if(highWayDangerOverSpeedNum>0){
				dayHistory.setIsHighWayDangerOverSpeed("1");
			}else{
				dayHistory.setIsHighWayDangerOverSpeed("0");
			}
			dayHistory.setHighWayDangerOverSpeedNum(highWayDangerOverSpeedNum);
			if(guodaoDangerOverSpeedNum>0){
				dayHistory.setIsGuodaoDangerOverSpeed("1");
			}else{
				dayHistory.setIsGuodaoDangerOverSpeed("0");
			}
			dayHistory.setGuodaoDangerOverSpeedNum(guodaoDangerOverSpeedNum);

			dayHistory.setCountMonth(countMonth);
			updateByFenPian(dayHistory);
		}



	}

	/**
	 * 分片修改
	 * @param dayHistory
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateByFenPian(BigdataTimeCarDayRec dayHistory) {
		mapper.updateByFenPian(dayHistory);
	}

	/**
	 * 从业人员角度统计超速和报警的数量
	 * @param countMonth
	 * @param empId
	 * @return
	 */
	public List<BigdataMonthEmpAlarmSum> selectGroupSumInfoForEmpAlarm(
			Integer countMonth, String empId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("empId",empId);
		return mapper.selectGroupSumInfoForEmpAlarm(param);
	}

	public BigdataFenxiCarWeek countMileageByWeek(Map<String, Object> map) {
		return mapper.countMileageByWeek(map);
	}

	public BigdataFenxiCarMonth countMileageByMonth(Map<String, Object> map) {
		return mapper.countMileageByMonth(map);
	}

	public Map<String, Object> countNum(String teamId, Integer yearNum, Integer countMonth, Integer countDay) {
		return mapper.countNum( teamId,  yearNum,  countMonth,  countDay);
	}

	public Map<String, Object> selectCountNum(String carType, String xianQuId, Integer yearNum, Integer countMonth, Integer countDay) {
		return mapper.selectCountNum( carType,  xianQuId,  yearNum,  countMonth,  countDay);
	}

	public int countCarNumByTeamId(String teamId, Integer yearNum, Integer countMonth, Integer countDay) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teamId",teamId);
		map.put("yearNum",yearNum);
		map.put("countMonth",countMonth);
		map.put("countDay",countDay);
		return mapper.countCarNumByTeamId(map);
	}

	public List<BigdataTimeCarDayRec> selectRunMileageTopThree(String teamId, Integer yearNum, Integer countMonth, Integer countDay) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teamId",teamId);
		map.put("yearNum",yearNum);
		map.put("countMonth",countMonth);
		map.put("countDay",countDay);
		return mapper.selectRunMileageTopThree(map);
	}

	public List<BigdataTimeCarDayRec> selectAlarmNumTopThree(String teamId, Integer yearNum, Integer countMonth, Integer countDay) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teamId",teamId);
		map.put("yearNum",yearNum);
		map.put("countMonth",countMonth);
		map.put("countDay",countDay);
		return mapper.selectAlarmNumTopThree(map);
	}

	/**
	 * @Author WangZhen
	 * @Description 查询某天有过行驶记录的车辆的ID
	 * @Date 2020/2/3 15:21
	 **/
    public List<String> selectOperatedCarIdsOfDay(int yearNum,int countMonth,int countDay) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("yearNum",yearNum);
		map.put("countMonth",countMonth);
		map.put("countDay",countDay);
		return  mapper.selectOperatedCarIdsOfDay(map);
    }

}
