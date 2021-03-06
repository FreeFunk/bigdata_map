package com.edgedo.bigdata.service;

import com.baomidou.mybatisplus.annotations.TableField;
import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.entity.BigdataCarStopRecord;
import com.edgedo.bigdata.entity.BigdataLinshiBatch;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.mapper.BigdataCarRealtimeGpsMapper;
import com.edgedo.bigdata.queryvo.BigdataCarRealtimeGpsQuery;
import com.edgedo.bigdata.queryvo.BigdataCarRealtimeGpsView;
import com.edgedo.common.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataCarRealtimeGpsService {
	//车辆的gps 的map值
	public  static final String CAR_REAL_TIME_GPS_MAP_KEY = "car-real-gps-map";

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


	
	@Autowired
	private BigdataCarRealtimeGpsMapper mapper;

	
	public List<BigdataCarRealtimeGpsView> listPage(BigdataCarRealtimeGpsQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataCarRealtimeGps voObj) {
		String id = voObj.getId();
		if(id == null || id.length()==0){
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
	public String update(BigdataCarRealtimeGps voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataCarRealtimeGps voObj) {
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

	//将车辆的数据加入到缓存中
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void putCarToCache(BigdataCarRealtimeGps target){
		RedisUtil redisUtil = IocUtil.getBean(RedisUtil.class);
		Object obj = redisUtil.hget(CAR_REAL_TIME_GPS_MAP_KEY,target.getId());
		Date lastPositionTime = target.getLastPositionTime() ;
		Date curTime = new Date();

		if(obj!=null){
			BigdataCarRealtimeGps ora = (BigdataCarRealtimeGps)obj;

			java.math.BigDecimal pointLat = target.getPointLat();
			java.math.BigDecimal pointLong = target.getPointLong();
			java.math.BigDecimal realSpeed = target.getRealSpeed();
			java.math.BigDecimal gpsSpeed = target.getGpsSpeed();
			java.math.BigDecimal mileage = target.getMileage();
			java.math.BigDecimal direction = target.getDirection();
			java.math.BigDecimal altitude = target.getAltitude();
			String carState = ora.getCarState();
			String alarmState = ora.getAlarmState();
			String carPlateColor = ora.getCarPlateColor();

			//判断在线状态和
			if(lastPositionTime!=null){
				String dateStr = sdf.format(lastPositionTime);
				String todayStr = sdf.format(new Date());
				if(dateStr.equals(todayStr)){
					ora.setOnlineState("1");
				}else{
					ora.setOnlineState("0");
				}
			}else{
				ora.setOnlineState("0");
			}
			double mileageD = mileage.doubleValue();
			//和累计路程
			double oraMileage = ora.getMileage().doubleValue();
			double beginMileageD = ora.getBeginMileage().doubleValue();


			if(mileageD>beginMileageD){
				ora.setOperatFlag("1");
			}else{
				ora.setOperatFlag("0");
				ora.setTodayTimeTotal(new BigDecimal(0));
			}
			//判断速度
			double speedDouble = target.getRealSpeed().doubleValue();
			double gpsSpeedDouble = target.getGpsSpeed().doubleValue();
			BigDecimal oraLat = ora.getPointLat();
			BigDecimal oraLong = ora.getPointLong();
			BigDecimal targetLat = target.getPointLat();
			BigDecimal targetLong = target.getPointLong();


			double tempdis = BaiDuMapApiUtil.getDistance(oraLat.doubleValue(),oraLong.doubleValue(),
					targetLat.doubleValue(),targetLong.doubleValue());

				//计算时间
			if(tempdis>30 && (speedDouble>0||gpsSpeedDouble>0)){//如果本次大于上一次那么车在行驶中
				BigDecimal todayTimeTotal = ora.getTodayTimeTotal();
				if(todayTimeTotal==null){
					todayTimeTotal = new BigDecimal(0);
				}
				//时间增加2分钟
				todayTimeTotal = todayTimeTotal.add(new BigDecimal(2));
				//修改当日的行驶里程
				ora.setTodayTimeTotal(todayTimeTotal);
				//TODO:计算各个时段的行驶时长和路程 中午11-13, 黄昏 17-19, 午夜23-1 ,清晨 5-7
				if(lastPositionTime!=null ){
					long milSecond = Math.abs(lastPositionTime.getTime()-curTime.getTime());
					long minuteNum = milSecond/(1000*60);
					if(minuteNum<20 ){
						//时钟误差小于20
						Calendar cal = Calendar.getInstance();
						cal.setTime(curTime);
						int hourMin =  cal.get(Calendar.HOUR_OF_DAY);
//				cal.add(Calendar.MINUTE,6);
						int hourMax =  cal.get(Calendar.HOUR_OF_DAY);
						BigDecimal mileAgeRun = new BigDecimal(mileageD-oraMileage);

						if(hourMin>=12&&hourMax<14){
							BigDecimal noonMileage = ora.getNoonMileage();
							if(noonMileage == null){
								noonMileage = mileAgeRun;
							}else{
								noonMileage = noonMileage.add(mileAgeRun);
							}
							BigDecimal noonMinute = ora.getNoonMinuteNum();
							if(noonMinute==null){
								noonMinute = new BigDecimal(2);
							}else{
								noonMinute = noonMinute.add(new BigDecimal(2));
							}
							ora.setNoonMileage(noonMileage);
							ora.setNoonMinuteNum(noonMinute);

						}else if(hourMin>=17&&hourMax<19){
							BigDecimal duskMileage = ora.getDuskMileage();
							if(duskMileage == null){
								duskMileage = mileAgeRun;
							}else{
								duskMileage = duskMileage.add(mileAgeRun);
							}
							BigDecimal duskMinute = ora.getDuskMinuteNum();
							if(duskMinute==null){
								duskMinute = new BigDecimal(2);
							}else{
								duskMinute = duskMinute.add(new BigDecimal(2));
							}
							ora.setDuskMileage(duskMileage);
							ora.setDuskMinuteNum(duskMinute);

						}else if(hourMin>=22){
							BigDecimal midnightMileage = ora.getMidnightMileage();
							if(midnightMileage == null){
								midnightMileage = mileAgeRun;
							}else{
								midnightMileage = midnightMileage.add(mileAgeRun);
							}
							BigDecimal midnightMinute = ora.getMidnightMinuteNum();
							if(midnightMinute==null){
								midnightMinute = new BigDecimal(2);
							}else{
								midnightMinute = midnightMinute.add(new BigDecimal(2));
							}
							ora.setMidnightMileage(midnightMileage);
							ora.setMidnightMinuteNum(midnightMinute);
						}else if(hourMin>=2 && hourMax<5){
							BigDecimal lingchenMileage = ora.getLingchenMileage();
							if(lingchenMileage == null){
								lingchenMileage = mileAgeRun;
							}else{
								lingchenMileage = lingchenMileage.add(mileAgeRun);
							}
							BigDecimal lingchenMinuteNum = ora.getLingchenMinuteNum();
							if(lingchenMinuteNum==null){
								lingchenMinuteNum = new BigDecimal(2);
							}else{
								lingchenMinuteNum = lingchenMinuteNum.add(new BigDecimal(2));
							}
							ora.setLingchenMileage(lingchenMileage);
							ora.setLingchenMinuteNum(lingchenMinuteNum);
						}else if(hourMin>=5&&hourMax<7){
							BigDecimal morningMileage = ora.getMorningMileage();
							if(morningMileage == null){
								morningMileage = mileAgeRun;
							}else{
								morningMileage = morningMileage.add(mileAgeRun);
							}
							BigDecimal morningMinute = ora.getMorningMinuteNum();
							if(morningMinute==null){
								morningMinute = new BigDecimal(2);
							}else{
								morningMinute = morningMinute.add(new BigDecimal(2));
							}
							ora.setMorningMileage(morningMileage);
							ora.setMorningMinuteNum(morningMinute);
						}
					}

				}

			}else{

				String onlineState = ora.getOnlineState();
				if(onlineState!=null && onlineState.equals("1")){//处于停车状态
					//插入停车记录 一天一个停车记录map
					BigDecimal stopLat = ora.getStopLat();
					BigDecimal stopLong = ora.getStopLong();
					Date curDate = new Date();

					if(stopLat!=null&& pointLat!=null&&stopLong!=null&&pointLong!=null){
						double dis = BaiDuMapApiUtil.getDistance(stopLat.doubleValue(),stopLong.doubleValue(),pointLat.doubleValue(),pointLong.doubleValue());
						if(dis<30){
							//1.看看停车地点变没变
							ora.setStopEndTime(curDate);
							//1.1如果地点没换，根据开始时间和结束时间计算停车时长
							Date oraBeginTime = ora.getStopBeginTime();
							long cha = curDate.getTime() - oraBeginTime.getTime();
							long minuteNum = cha/(1000*60);
							//1.2更新时长的结束时间
							ora.setStopMinuteNum((int)minuteNum);
						}else{
							//1.3如果停车地点变化了那么更新地点
							ora.setStopBeginTime(curDate);
							ora.setStopEndTime(curDate);
							ora.setStopLat(pointLat);
							ora.setStopLong(pointLong);
							ora.setStopMinuteNum(0);
							//1.4修改开始时间和结束时间
						}
					}else{
						//1.3如果停车地点变化了那么更新地点
						ora.setStopBeginTime(curDate);
						ora.setStopEndTime(curDate);
						ora.setStopLat(pointLat);
						ora.setStopLong(pointLong);
						ora.setStopMinuteNum(0);
						//1.4修改开始时间和结束时间
					}
				}


				BigDecimal noonMileage = ora.getNoonMileage();
				if(noonMileage == null){
					noonMileage = new BigDecimal(0);
				}
				BigDecimal noonMinute = ora.getNoonMinuteNum();
				if(noonMinute==null){
					noonMinute = new BigDecimal(0);
				}
				ora.setNoonMileage(noonMileage);
				ora.setNoonMinuteNum(noonMinute);

				BigDecimal duskMileage = ora.getDuskMileage();
				if(duskMileage == null){
					duskMileage = new BigDecimal(0);
				}
				BigDecimal duskMinute = ora.getDuskMinuteNum();
				if(duskMinute==null){
					duskMinute = new BigDecimal(0);
				}
				ora.setDuskMileage(duskMileage);
				ora.setDuskMinuteNum(duskMinute);

				BigDecimal midnightMileage = ora.getMidnightMileage();
				if(midnightMileage == null){
					midnightMileage = new BigDecimal(0);
				}
				BigDecimal midnightMinute = ora.getMidnightMinuteNum();
				if(midnightMinute==null){
					midnightMinute = new BigDecimal(0);
				}
				ora.setMidnightMileage(midnightMileage);
				ora.setMidnightMinuteNum(midnightMinute);

				BigDecimal lingchenMileage = ora.getLingchenMileage();
				if(lingchenMileage == null){
					lingchenMileage = new BigDecimal(0);
				}
				BigDecimal lingchenMinuteNum = ora.getLingchenMinuteNum();
				if(lingchenMinuteNum==null){
					lingchenMinuteNum = new BigDecimal(0);
				}
				ora.setLingchenMileage(lingchenMileage);
				ora.setLingchenMinuteNum(lingchenMinuteNum);

				BigDecimal morningMileage = ora.getMorningMileage();
				if(morningMileage == null){
					morningMileage = new BigDecimal(0);
				}
				BigDecimal morningMinute = ora.getMorningMinuteNum();
				if(morningMinute==null){
					morningMinute = new BigDecimal(0);
				}
				ora.setMorningMileage(morningMileage);
				ora.setMorningMinuteNum(morningMinute);

			}
			double todayBegin = ora.getBeginMileage().doubleValue();
			double todayMileageTotal = mileageD - todayBegin;
			if(todayMileageTotal<0){
				todayMileageTotal = 0;
			}
			ora.setTodayMileageTotal(new BigDecimal(todayMileageTotal));
			ora.setLastUpTime(new Date());
			ora.setLastPositionTime(lastPositionTime);
			ora.setPointLat(pointLat);
			ora.setPointLong(pointLong);
			ora.setRealSpeed(realSpeed);
			ora.setGpsSpeed(gpsSpeed);
			ora.setMileage(mileage);
			ora.setDirection(direction);
			ora.setAltitude(altitude);
			ora.setCarState(carState);
			ora.setAlarmState(alarmState);
			BigDecimal beginMileage = ora.getBeginMileage();
			if(beginMileage==null || beginMileage.doubleValue()==0){
				ora.setBeginMileage(mileage);
			}
			ora.setCarPlateColor(carPlateColor);
			//当天行驶超过2公里才算运营
			/*double todayMileDouble = ora.getTodayMileageTotal().doubleValue();
			if(todayMileDouble>2){
				ora.setOperatFlag("1");
			}else{
				ora.setOperatFlag("0");
				ora.setTodayTimeTotal(new BigDecimal(0));
			}*/
			redisUtil.hset(CAR_REAL_TIME_GPS_MAP_KEY,target.getId(),ora);
		}else{
			target.setOperatFlag("0");
			target.setOnlineState("0");
			target.setTodayMileageTotal(new BigDecimal(0));
			target.setTodayTimeTotal(new BigDecimal(0));
			target.setBeginTime(new Date());
			target.setBeginMileage(target.getMileage());
			target.setLastUpTime(new Date());
			redisUtil.hset(CAR_REAL_TIME_GPS_MAP_KEY,target.getId(),target);
		}

	}

	/**
	 * 加载单个
	 * @param id
	 */
	public BigdataCarRealtimeGps loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 设置开始的里程
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateBeginMileageAndOperateStateAndOnlineState() {
		mapper.updateBeginMileageAndOperateStateAndOnlineState();
	}

	//设置是否运营
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateOperatingFlag() {
		mapper.updateOperatingFlag();
	}

	//设置是否在现在
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateOnlineState() {
		mapper.updateOnlineState();
	}
	//根据车牌号和车牌颜色匹配
    public BigdataCarRealtimeGps selectCarByCarPlateAndPlateColor(String carPlateNum, String carPlateColor) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlateNum",carPlateNum);
		param.put("carPlateColor",carPlateColor);
		return mapper.selectCarByCarPlateAndPlateColor(param);
    }

    //新增或者修改gps记录
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insertOrUpdate(BigdataCarRealtimeGps carRealtimeGps) {
		try {
			Integer qu =  carRealtimeGps.getQualifiedState();
			BigdataCarRealtimeGps ora = loadById(carRealtimeGps.getId());
			if (ora != null) {
				update(carRealtimeGps);
			} else {
				insert(carRealtimeGps);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
    }

	//清理gps系统数据
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int updateClearAllGpsState() {
		return mapper.updateClearAllGpsState();
    }

	/**
	 * 根据多个主键查询
	 * @param ids
	 * @return
	 */
    public List<BigdataCarRealtimeGps> selectCarGpsInfoByIds(String[] ids) {
		return mapper.selectCarGpsInfoByIds(ids);
    }
	public void insertBigdataLinshiBatch(String batchId) {
		mapper.insertBigdataLinshiBatch(batchId);
	}

	public List<BigdataLinshiBatch> selecBigdataLinshiBatch(String batchId) {
		return mapper.selecBigdataLinshiBatch(batchId);
	}

	public int selectOrderNumDesc(String batchId) {
		return mapper.selectOrderNumDesc(batchId);
	}

	public List<BigdataLinshiBatch> listByStartAndEndBySortNum(String batchId, int start, int end) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("start",start);
		param.put("end",end);
		param.put("batchId",batchId);
		return mapper.listByStartAndEndBySortNum(param);
	}

	/**
	 * @Author WangZhen
	 * @Description 查询gps表中没在 car_info表中的车
	 * @Date 2019/11/26 17:14
	 **/
    public List<BigdataCarRealtimeGpsView> selectGpsCarNotInCarInfo() {
		return mapper.selectGpsCarNotInCarInfo();
    }


	public List<BigdataCarRealtimeGpsView> selectNotInTodayGps() {
		return mapper.selectNotInTodayGps();
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateClearCarStateById(String carId) {
		mapper.updateClearCarStateById(carId);
	}

    public BigdataCarRealtimeGpsView loadLatestOneCar() {
    	return mapper.loadLatestOneCar();
    }
}
