package com.edgedo.bigdata.service;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.mapper.BigdataAlarmRecordMapper;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordView;
import com.edgedo.common.util.Guid;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataAlarmRecordService {
	
	
	@Autowired
	private BigdataAlarmRecordMapper mapper;

	@Autowired
	private CarInfoService carInfoService;

	SimpleDateFormat sdfDay = new SimpleDateFormat("yyyyMMdd");

	
	public List<BigdataAlarmRecordView> listPage(BigdataAlarmRecordQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	/**
	 * 不分页查询
	 * @param query
	 * @return
	 */
	public List<BigdataAlarmRecordView> listByObj(BigdataAlarmRecordQuery query){
		List list = mapper.listByObj(query);
		query.setList(list);
		return list;
	}

	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataAlarmRecord voObj) {
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
	public String update(BigdataAlarmRecord voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataAlarmRecord voObj) {
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
	public BigdataAlarmRecord loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 将接收到的报警信息加入到数据库中
	 * @param alarmRecord
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insertAcceptAlarm(BigdataAlarmRecord alarmRecord) {
		String id = alarmRecord.getCompId() + "-" + alarmRecord.getBid();
		//查询是否存在
		Date cur = alarmRecord.getAlarmTime();
		String dateStr = sdfDay.format(cur);
		alarmRecord.setId(id);
    	Map<String,Object> param = new HashMap<String,Object>();
		param.put("compId",alarmRecord.getCompId());
		param.put("bId", alarmRecord.getBid());
		String carId = alarmRecord.getCarPlateNum() + "_" + alarmRecord.getCarPlateColor();
		CarInfo car = carInfoService.loadById(carId);
		if(car!=null){
			BigdataAlarmRecord oraAlarm = loadByIdAndAlarmDate(id,new Integer(dateStr)/100);
			//判断重复
			if(oraAlarm==null){
				//将时间信息解析成秒
				BigDecimal secondNum = new BigDecimal(0);
				try {
					String timeInfo = alarmRecord.getAlarmTimeInfo();
					String timeType = timeInfo.substring(timeInfo.length() - 1);
					String timeNumStr = timeInfo.substring(0, timeInfo.length() - 1);


					if (timeType.equals("秒")) {
						secondNum = new BigDecimal(timeNumStr);
					} else if (timeType.equals("分")) {
						secondNum = new BigDecimal(timeNumStr).multiply(new BigDecimal(60));
					} else {
						if(!timeNumStr.equals("")){
							secondNum = new BigDecimal(timeNumStr);
						}
					}
				}catch (Exception e){e.printStackTrace();}finally{}
				alarmRecord.setAlarmTimeSecond(secondNum);
				//超速大百分之50算严重超速
				if(alarmRecord.getAlarmType().equals("2") && alarmRecord.getAlarmCls().equals("1")){

					//超速的时间加上60秒
					BigDecimal alarmTimeSecond = alarmRecord.getAlarmTimeSecond().add(new BigDecimal(60));
					alarmRecord.setAlarmTimeSecond(alarmTimeSecond);

					BigDecimal alarmSpeed = alarmRecord.getAlarmSpeed();
					BigDecimal roadSpeedLimit = alarmRecord.getRoadSpeedLimit();
					if(alarmSpeed==null ||roadSpeedLimit==null ){
						return;
					}
					if(alarmSpeed.doubleValue()/roadSpeedLimit.doubleValue()>1.5){
						alarmRecord.setSeriousFlag("1");
					}else{
						alarmRecord.setSeriousFlag("0");
					}
				}else if(alarmRecord.getAlarmType().equals("4") ){
					//疲劳报警 大于20分钟算严重疲劳
					if(secondNum.doubleValue()/60>20){
						alarmRecord.setSeriousFlag("1");
					}else{
						alarmRecord.setSeriousFlag("0");
//						alarmRecord.get
					}
					//判断道路类型是否是高速

					/*41000 高速公路,42000 国道,43000 主要大街、城市快速路,51000 省道,
							44000 主要道路,45000  次要道路,52000 乡公路,53000 县乡村内部道路
					54000 县乡村内部道路,47000 普通道路,49 非导航道路*/
				}
				//危险时段判断 中午11-13, 黄昏 17-19, 午夜23-1 ,清晨 5-7
				Date alarmTime = alarmRecord.getAlarmTime();
				Calendar cal = Calendar.getInstance();
				cal.setTime(alarmTime);
				int hour =  cal.get(Calendar.HOUR_OF_DAY);
				if( (hour>=12&&hour<14) || (hour>=17&&hour<19)|| (hour>=2&&hour<5) || (hour>=5&&hour<7)){
					alarmRecord.setDangerTimeFlag("1");
				}else{
					alarmRecord.setDangerTimeFlag("0");
				}
				//将记录插入数据库
				alarmRecord.setCreateTime(new Date());
				alarmRecord.setCarType(car.getCarType());
				int countDate = new Integer(dateStr);
				alarmRecord.setCountDate(countDate);
				alarmRecord.setCountMonth(countDate/100);
				//关联的从业人员
				alarmRecord.setEmpId(car.getEmpId());
				alarmRecord.setEmpName(car.getEmpName());
				alarmRecord.setEmpCode(car.getEmpCode());
				alarmRecord.setEmpPhone(car.getEmpPhone());

				alarmRecord.setTeamId(car.getOwnerTeamId());
				alarmRecord.setTeamName(car.getOwnerTeamName());
				alarmRecord.setProvinceId(car.getProvinceId());
				alarmRecord.setProvinceName(car.getProvinceName());
				alarmRecord.setCityId(car.getCityId());
				alarmRecord.setCityName(car.getCityName());
				alarmRecord.setXianquId(car.getXianquId());
				alarmRecord.setXianquName(car.getXianquName());
				//处理时间
				Date dealTime = alarmRecord.getDealTime();
				//处理备注
				String dealRemark = alarmRecord.getDealRemark();
				//处理方式
				String dealType = alarmRecord.getDealType();
				if(dealTime!=null && dealRemark!=null && !dealRemark.equals("") && dealType!=null && !dealType.equals("")){
					//判断处理时间是否合理
					if(dealTime.compareTo(alarmRecord.getAlarmTime())<0){
						dealTime = new Date();
						alarmRecord.setDealTime(dealTime);
					}
					alarmRecord.setAlarmState("已处理");
				}
				insert(alarmRecord);
			}else {
				//处理时间
				Date dealTime = alarmRecord.getDealTime();
				//处理备注
				String dealRemark = alarmRecord.getDealRemark();
				//处理方式
				String dealType = alarmRecord.getDealType();
				if(dealTime!=null){
					//判断处理时间是否合理
					if(dealTime.compareTo(alarmRecord.getAlarmTime())<0){
						dealTime = new Date();
					}
					oraAlarm.setDealTime(dealTime);
					oraAlarm.setDealRemark(dealRemark);
					oraAlarm.setDealType(dealType);
					oraAlarm.setAlarmState("已处理");
					updateByFenPian(oraAlarm);
				}
			}
		}


    }

	/**
	 * 将接收到的报警信息加入到数据库中
	 * @param alarmRecord
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BigdataAlarmRecordService.class);
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertAcceptAlarmNew(BigdataAlarmRecord alarmRecord) {
		String id = alarmRecord.getCompId() + "-" + alarmRecord.getBid();
		//查询是否存在
		Date cur = alarmRecord.getAlarmTime();
		String dateStr = sdfDay.format(cur);
		alarmRecord.setId(id);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("compId",alarmRecord.getCompId());
		param.put("bId", alarmRecord.getBid());
		String carId = alarmRecord.getCarPlateNum() + "_" + alarmRecord.getCarPlateColor();
		CarInfo car = carInfoService.loadById(carId);
		if(car!=null){
			BigdataAlarmRecord oraAlarm = loadByIdAndAlarmDate(id,new Integer(dateStr)/100);
			//判断重复
			if(oraAlarm==null){
				LOGGER.error(JSONObject.toJSONString(alarmRecord));
				//将时间信息解析成秒
				BigDecimal secondNum = new BigDecimal(0);
				try {
					String timeInfo = alarmRecord.getAlarmTimeInfo();
					String timeType = timeInfo.substring(timeInfo.length() - 1);
					String timeNumStr = timeInfo.substring(0, timeInfo.length() - 1);


					if (timeType.equals("秒")) {
						secondNum = new BigDecimal(timeNumStr);
					} else if (timeType.equals("分")) {
						secondNum = new BigDecimal(timeNumStr).multiply(new BigDecimal(60));
					} else {
						if(!timeNumStr.equals("")){
							secondNum = new BigDecimal(timeNumStr);
						}
					}
				}catch (Exception e){e.printStackTrace();}finally{}
				alarmRecord.setAlarmTimeSecond(secondNum);
				//超速大百分之50算严重超速
				if(alarmRecord.getAlarmType().equals("2") && alarmRecord.getAlarmCls().equals("1")){

					//超速的时间加上60秒
					BigDecimal alarmTimeSecond = alarmRecord.getAlarmTimeSecond().add(new BigDecimal(60));
					alarmRecord.setAlarmTimeSecond(alarmTimeSecond);

					BigDecimal alarmSpeed = alarmRecord.getAlarmSpeed();
					BigDecimal roadSpeedLimit = alarmRecord.getRoadSpeedLimit();
					if(alarmSpeed==null ||roadSpeedLimit==null ){
						return;
					}
					if(alarmSpeed.doubleValue()/roadSpeedLimit.doubleValue()>1.5){
						alarmRecord.setSeriousFlag("1");
					}else{
						alarmRecord.setSeriousFlag("0");
					}
				}else if(alarmRecord.getAlarmType().equals("4") ){
					//疲劳报警 大于20分钟算严重疲劳
					if(secondNum.doubleValue()/60>20){
						alarmRecord.setSeriousFlag("1");
					}else{
						alarmRecord.setSeriousFlag("0");
//						alarmRecord.get
					}
					//判断道路类型是否是高速

					/*41000 高速公路,42000 国道,43000 主要大街、城市快速路,51000 省道,
							44000 主要道路,45000  次要道路,52000 乡公路,53000 县乡村内部道路
					54000 县乡村内部道路,47000 普通道路,49 非导航道路*/
				}
				//危险时段判断 中午11-13, 黄昏 17-19, 午夜23-1 ,清晨 5-7
				Date alarmTime = alarmRecord.getAlarmTime();
				Calendar cal = Calendar.getInstance();
				cal.setTime(alarmTime);
				int hour =  cal.get(Calendar.HOUR_OF_DAY);
				if( (hour>=12&&hour<14) || (hour>=17&&hour<19)|| (hour>=2&&hour<5) || (hour>=5&&hour<7)){
					alarmRecord.setDangerTimeFlag("1");
				}else{
					alarmRecord.setDangerTimeFlag("0");
				}
				//将记录插入数据库
				alarmRecord.setCreateTime(new Date());
				alarmRecord.setCarType(car.getCarType());
				int countDate = new Integer(dateStr);
				alarmRecord.setCountDate(countDate);
				alarmRecord.setCountMonth(countDate/100);
				//关联的从业人员
				alarmRecord.setEmpId(car.getEmpId());
				alarmRecord.setEmpName(car.getEmpName());
				alarmRecord.setEmpCode(car.getEmpCode());
				alarmRecord.setEmpPhone(car.getEmpPhone());

				alarmRecord.setTeamId(car.getOwnerTeamId());
				alarmRecord.setTeamName(car.getOwnerTeamName());
				alarmRecord.setProvinceId(car.getProvinceId());
				alarmRecord.setProvinceName(car.getProvinceName());
				alarmRecord.setCityId(car.getCityId());
				alarmRecord.setCityName(car.getCityName());
				alarmRecord.setXianquId(car.getXianquId());
				alarmRecord.setXianquName(car.getXianquName());
				//处理时间
				Date dealTime = alarmRecord.getDealTime();
				//处理备注
				String dealRemark = alarmRecord.getDealRemark();
				//处理方式
				String dealType = alarmRecord.getDealType();
				if(dealTime!=null && dealRemark!=null && !dealRemark.equals("") && dealType!=null && !dealType.equals("")){
					//判断处理时间是否合理
					if(dealTime.compareTo(alarmRecord.getAlarmTime())<0){
						dealTime = new Date();
						alarmRecord.setDealTime(dealTime);
					}
					alarmRecord.setAlarmState("已处理");
				}
				//insert(alarmRecord);
			}
		}


	}
	/**
	 * 因为增加了报警表的水平切片查询根据主键查询为提高效率增加统计日期
	 * @param id
	 * @param countMonth
	 * @return
	 */
	public BigdataAlarmRecord loadByIdAndAlarmDate(String id, Integer countMonth) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id",id);
		param.put("countMonth",countMonth);
		return mapper.loadByIdAndAlarmDate(param);
	}

	public int countByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		return mapper.countByQuery(bigdataAlarmRecordQuery);
	}

	public int countOtherRoadOverSpeedNum(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		return mapper.countOtherRoadOverSpeedNum(bigdataAlarmRecordQuery);
	}

	public int sumByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		return mapper.sumByQuery(bigdataAlarmRecordQuery);
	}

	public int sumOtherRoadOverSpeedNum(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		return mapper.sumOtherRoadOverSpeedNum(bigdataAlarmRecordQuery);
	}

	public int countByQueryNew(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		List<Integer> list = mapper.countByQueryNew(bigdataAlarmRecordQuery);
		if(list==null){
			return 0;
		}
		return list.size();
	}

	public int countSeriousByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		return mapper.countSeriousByQuery(bigdataAlarmRecordQuery);
	}

	public Integer sumSeriousByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		List<CarListVo> carList = mapper.selectSeriousCarListByQuery(bigdataAlarmRecordQuery);
		List<String> carPlateNumList = new ArrayList<>();
		for(CarListVo c: carList){
			carPlateNumList.add(c.getCarPlateNum());
		}
		String carPlateNum = "'"+ StringUtils.join(carPlateNumList,"','")+"'";
		bigdataAlarmRecordQuery.setCarPlateNum(carPlateNum);
		Integer i = mapper.sumSeriousByQuery(bigdataAlarmRecordQuery);
		if(i==null){
			i=0;
		}
		return i;
	}

	/**
	 * 查询几个没有完成位置 查询的
	 * @param limit
	 * @return
	 */
    public List<BigdataAlarmRecord> listUnLocationAlarm(
    		int limit, Integer countMonth , Integer countDate) {
    	Map<String,Object> param = new HashMap<String,Object>();
		param.put("limit",limit);
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
    	return mapper.listUnLocationAlarm(param);
    }

	public int updateByFenPian(BigdataAlarmRecord param) {
		return mapper.updateByFenPian(param);
	}

	/**
	 * 根据日期和月份分片   分组统计
	 * @param countMonth
	 * @param countDate
	 * @return
	 */
    public List<BigdataDangerRoadClsMonth> selectGroupCountOfDangerRoad(int countMonth, int countDate) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		return mapper.selectGroupCountOfDangerRoad(param);
    }


	public int countSeriousByQueryNew(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		List<Integer>  list = mapper.countSeriousByQueryNew(bigdataAlarmRecordQuery);
		if(list==null){
			return 0;
		}
		return list.size();
	}

	public int countCarNumByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		List<String> list = mapper.countCarNumByQuery(bigdataAlarmRecordQuery);
		if(list==null){
			return 0;
		}
		return list.size();
	}

	//统计某个车辆的超速车辆数据
    public int countDayOverSpeedOfCar(String carPlateNum, String carPlateColor, Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
    	Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlateNum",carPlateNum);
		param.put("carPlateColor",carPlateColor);
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		return mapper.countDayOverSpeedOfCar(param);

    }

    //统计车辆当天的疲劳次数
	public int countDayFatigueOfCar(String carPlateNum, String carPlateColor, Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlateNum",carPlateNum);
		param.put("carPlateColor",carPlateColor);
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		return mapper.countDayFatigueOfCar(param);
	}

	//统计高速路段的超速次数
	public int countDayHighWayOverSpeedOfCar(
			String carPlateNum, String carPlateColor, Date cur,
			String isSerious,String isDanger) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlateNum",carPlateNum);
		param.put("carPlateColor",carPlateColor);
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("isSerious",isSerious);
		param.put("isDanger",isDanger);
		return mapper.countDayHighWayOverSpeedOfCar(param);
	}

	//国道超速次数
	public int countDayGuodaoWayOverSpeedOfCar(
			String carPlateNum, String carPlateColor, Date cur,
			String isSerious,String isDanger
		) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlateNum",carPlateNum);
		param.put("carPlateColor",carPlateColor);
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);

		return mapper.countDayGuodaoWayOverSpeedOfCar(param);
	}

	//严重超速次数
	public int countDaySeriousWayOverSpeedOfCar(String carPlateNum, String carPlateColor, Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlateNum",carPlateNum);
		param.put("carPlateColor",carPlateColor);
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		return mapper.countDaySeriousWayOverSpeedOfCar(param);
	}

	//危险时段超速次数
	public int countDayDangerWayOverSpeedOfCar(String carPlateNum, String carPlateColor, Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlateNum",carPlateNum);
		param.put("carPlateColor",carPlateColor);
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		return mapper.countDayDangerWayOverSpeedOfCar(param);
	}

	//危险时段疲劳次数
	public int countDayDangerFatigueOfCar(String carPlateNum, String carPlateColor, Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlateNum",carPlateNum);
		param.put("carPlateColor",carPlateColor);
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		return mapper.countDayDangerFatigueOfCar(param);
	}

	/**
	 * 超速次数
	 * @param cur
	 * @return
	 */
    public List<BigdataAlarmRecordView> selectGroupCountDayOverSpeedOfCar(Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("alarmType","2");
		param.put("alarmCls","1");
		return mapper.selectGroupCountByCondition(param);
    }

	/**
	 * 疲劳次数
	 * @param cur
	 * @return
	 */
	public List<BigdataAlarmRecordView> selectGroupCountDayFatigueOfCar(Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("alarmType","4");
		return mapper.selectGroupCountByCondition(param);
	}

	/**
	 * 高速超速次数
	 * @param cur
	 * @return
	 */
	public List<BigdataAlarmRecordView> selectGroupCountDayHighWayOverSpeedOfCar(Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("alarmType","2");
		param.put("alarmCls","1");
		param.put("roadLevel","41000");
		return mapper.selectGroupCountByCondition(param);
	}

	/**
	 * 国道超速次数
	 * @param cur
	 * @return
	 */
	public List<BigdataAlarmRecordView> selectGroupCountDayGuodaoWayOverSpeedOfCar(Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("alarmType","2");
		param.put("alarmCls","1");
		param.put("roadLevel","42000");
		return mapper.selectGroupCountByCondition(param);
	}

	/**
	 * 严重超速次数
	 * @param cur
	 * @return
	 */
	public List<BigdataAlarmRecordView> selectGroupCountDaySeriousWayOverSpeedOfCar(Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("alarmType","2");
		param.put("alarmCls","1");
		param.put("seriousFlag","1");
		return mapper.selectGroupCountByCondition(param);
	}

	/**
	 * 危险时段超速
	 * @param cur
	 * @return
	 */
	public List<BigdataAlarmRecordView> selectGroupCountDayDangerWayOverSpeedOfCar(Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("alarmType","2");
		param.put("alarmCls","1");
		param.put("dangerTimeFlag","1");
		return mapper.selectGroupCountByCondition(param);
	}

	/**
	 * 危险时段疲劳次数
	 * @param cur
	 * @return
	 */
	public List<BigdataAlarmRecordView> selectGroupCountDayDangerFatigueOfCar(Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("alarmType","4");
		param.put("dangerTimeFlag","1");
		return mapper.selectGroupCountByCondition(param);
	}



	/**
	 * 高速严重超速次数
	 * @param cur
	 * @return
	 */
	public List<BigdataAlarmRecordView> selectGroupDayHighWaySerOverSpeedOfCar(Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("alarmType","2");
		param.put("alarmCls","1");
		param.put("seriousFlag","1");
		param.put("roadLevel","41000");
		return mapper.selectGroupCountByCondition(param);
	}

	/**
	 * 国道严重超速次数
	 * @param cur
	 * @return
	 */
	public List<BigdataAlarmRecordView> selectGroupCountDayGuodaoWaySerOverSpeedOfCar(Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("alarmType","2");
		param.put("alarmCls","1");
		param.put("seriousFlag","1");
		param.put("roadLevel","42000");
		return mapper.selectGroupCountByCondition(param);
	}

	/**
	 * 高速危险时段超速次数
	 * @param cur
	 * @return
	 */
	public List<BigdataAlarmRecordView> selectGroupDayHighWayDangerOverSpeedOfCar(Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("alarmType","2");
		param.put("alarmCls","1");
		param.put("dangerTimeFlag","1");
		param.put("roadLevel","41000");
		return mapper.selectGroupCountByCondition(param);
	}

	/**
	 * 国道危险时段超速次数
	 * @param cur
	 * @return
	 */
	public List<BigdataAlarmRecordView> selectGroupDayGuodaoWayDangerOverSpeedOfCar(Date cur) {
		String dateStr = sdfDay.format(cur);
		Integer countDate = new Integer(dateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("countDate",countDate);
		param.put("alarmType","2");
		param.put("alarmCls","1");
		param.put("dangerTimeFlag","1");
		param.put("roadLevel","42000");
		return mapper.selectGroupCountByCondition(param);
	}

	public int countByCompId(Map<String, Object> map) {
		return mapper.countByCompId(map);
	}


	public int countByCarPlateNum(Map<String, Object> map) {
		return mapper.countByCarPlateNum(map);
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

    public int selectAlarm(Integer yearNum, Integer countMonth, Integer countDay,
						   String xianQuId, String carType, String startTime, String endTime) {
		return mapper.selectAlarm(yearNum,  countMonth,  countDay,  xianQuId,  carType,  startTime,  endTime);
	}

	public int selectHandler(Integer yearNum, Integer countMonth, Integer countDay,
							 String xianQuId, String carType, String startTime, String endTime) {
		return mapper.selectHandler(yearNum,  countMonth,  countDay,  xianQuId,  carType,  startTime,  endTime);
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

	public List<AlarmVo> countByTeamTransitTypeTopThreeNew(Map<String, Object> map1) {
		return mapper.countByTeamTransitTypeTopThreeNew(map1);
	}

	public List<AlarmVo> countByTeamTransitTypeTopThreeMonth(Map<String, Object> map1) {
		return mapper.countByTeamTransitTypeTopThreeMonth(map1);
	}

	public List<AlarmVo> countByTeamTransitTypeTopThreeMonthNew(Map<String, Object> map1) {
		return mapper.countByTeamTransitTypeTopThreeMonthNew(map1);
	}

	public int selectAlarmTypeCountByQuery(BigdataAlarmRecordQuery query){
		return mapper.selectAlarmTypeCountByQuery(query);
	}

	public List<BigdataAlarmRecord> selectDataForFake(Map<String, Object> map) {
		return mapper.selectDataForFake(map);
	}

	public int countById(BigdataAlarmRecord a) {
		return mapper.countById(a);
	}

	public List<BigdataAlarmRecord> selectDataForFakeNew() {
		return mapper.selectDataForFakeNew();
	}

	public int countOverSpeedNum(String driverId, int dayInt) {
		Map<String,Object> map = new HashMap<>();
		map.put("alarmCls","1");
		map.put("alarmType","2");
		map.put("countDate",dayInt);
		map.put("countMonth",dayInt/100);
		map.put("empId",driverId);
		return mapper.countOverSpeedNum(map);
	}

	public int countSeriousOverSpeedNum(String driverId, int dayInt) {
		Map<String,Object> map = new HashMap<>();
		map.put("alarmCls","1");
		map.put("alarmType","2");
		map.put("countDate",dayInt);
		map.put("countMonth",dayInt/100);
		map.put("empId",driverId);
		map.put("seriousFlag","1");
		return mapper.countSeriousOverSpeedNum(map);
	}

	public int countFatigueNum(String driverId, int dayInt) {
		Map<String,Object> map = new HashMap<>();
		map.put("alarmCls","2");
		map.put("alarmType","4");
		map.put("countDate",dayInt);
		map.put("countMonth",dayInt/100);
		map.put("empId",driverId);
		return mapper.countFatigueNum(map);
	}

    public int countSumNumByCompId(String compId,int dayInt) {
		Map<String,Object> map = new HashMap<>();
		map.put("countDate",dayInt);
		map.put("countMonth",dayInt/100);
		map.put("compId",compId);
		return mapper.countSumNumByCompId(map);
    }

	public List<BigdataAlarmRecord> selectGroupEmpId(int countMonth,String alarmType) {
		Map<String,Object> map = new HashMap<>();
		map.put("alarmType",alarmType);
		map.put("countMonth",countMonth);
		return mapper.selectGroupEmpId(map);
	}

	public int countNotOverSpeedCarNumByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		List<String> list = mapper.countNotOverSpeedCarNumByQuery(bigdataAlarmRecordQuery);
		if(list==null){
			return 0;
		}
		return list.size();
	}

	public int sumNotOverSpeedByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		return mapper.sumNotOverSpeedByQuery(bigdataAlarmRecordQuery);
	}

	public int countNotCarNumByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery) {
		List<String> list = mapper.countNotCarNumByQuery(bigdataAlarmRecordQuery);
		if(list==null){
			return 0;
		}
		return list.size();
	}
}
