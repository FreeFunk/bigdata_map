package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.entity.BigdataCarStopRecord;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.mapper.BigdataCarStopRecordMapper;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecordView;
import com.edgedo.bigdata.queryvo.CarQuXiangGroupCount;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataCarStopRecordService {
	
	
	@Autowired
	private BigdataCarStopRecordMapper mapper;
	@Autowired
	private CarInfoService carInfoService;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	
	public List<BigdataCarStopRecordView> listPage(BigdataCarStopRecordQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataCarStopRecord voObj) {
		String id = voObj.getId();
		if(id==null){
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
	public String update(BigdataCarStopRecord voObj) {
		mapper.updateById(voObj);
		return "";
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateByFenPian(BigdataCarStopRecord voObj) {
		mapper.updateByFenPian(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataCarStopRecord voObj) {
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
	public BigdataCarStopRecord loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 新增或者修改停车记录
	 * @param carGps
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insertOrUpdateStopRec(BigdataCarRealtimeGps carGps,CarInfo car) {

    	Date currDate = new Date();
    	String dateIntStr = sdf.format(currDate);
    	int dateInt = new Integer(dateIntStr);
    	int countMonth = dateInt/100;
    	int yearNum = countMonth/100;
		//主键规则 日期 + 车牌号 + 车牌颜色 + 坐标点
		String id = sdf.format(currDate) + "-" + carGps.getCarPlateNum() + "-" + carGps.getCarPlateColor()
				+ "-" + carGps.getStopLat() + "-" + carGps.getStopLong();
		BigdataCarStopRecord stopRec = loadByIdAndDate(id,countMonth);
		if(stopRec!=null){
			//计算停留时间
			stopRec.setEndTime(carGps.getStopEndTime());
			stopRec.setBeginTime(carGps.getStopBeginTime());
			stopRec.setStopMiniteNum(carGps.getStopMinuteNum());
			stopRec.setEndTime(currDate);
			stopRec.setMapCountry(carGps.getMapCountry());
			stopRec.setMapProvince(car.getCurrentProvinceName());
			if(car.getCurrentProvinceId()!=null && car.getCurrentProvinceId().length()>0){
				stopRec.setMapProvinceId(car.getCurrentProvinceId());
			}

			stopRec.setMapCity(car.getCurrentCityName());
			stopRec.setMapCityId(car.getCurrentCityId());
			if(car.getCurrentCityId()!=null && car.getCurrentCityId().length()>0){
				stopRec.setMapProvinceId(car.getCurrentCityId());
			}
			stopRec.setMapXianqu(car.getCurrentXianquName());
			stopRec.setMapXianquId(car.getCurrentXianquId());
			if(car.getCurrentXianquId()!=null && car.getCurrentXianquId().length()>0){
				stopRec.setMapProvinceId(car.getCurrentXianquId());
			}
			stopRec.setMapDetail(carGps.getMapDetail());
//			stopRec.setCountDate(null);
//			stopRec.setCountMonth(null);
//			stopRec.setYearNum(null);
			updateByFenPian(stopRec);
		}else{
			BigdataCarStopRecord temStopRec = new BigdataCarStopRecord();
			temStopRec.setId(id);
			temStopRec.setBeginTime(carGps.getStopBeginTime());
			temStopRec.setStopMiniteNum(carGps.getStopMinuteNum());
			temStopRec.setEndTime(carGps.getStopEndTime());
			temStopRec.setCarPlateColor(carGps.getCarPlateColor());
			temStopRec.setCarPlateNum(carGps.getCarPlateNum());
			temStopRec.setCarRealId(carGps.getId());
			temStopRec.setAltitude(carGps.getAltitude());
			temStopRec.setPointLat(carGps.getStopLat());
			temStopRec.setPointLong(carGps.getStopLong());
			temStopRec.setCarType(car.getCarType());
			temStopRec.setMapCountry(carGps.getMapCountry());
			temStopRec.setMapProvince(car.getCurrentProvinceName());
			temStopRec.setMapProvinceId(car.getCurrentProvinceId());
			temStopRec.setMapCity(car.getCurrentCityName());
			temStopRec.setMapCityId(car.getCurrentCityId());
			temStopRec.setMapXianqu(car.getCurrentXianquName());
			temStopRec.setMapXianquId(car.getCurrentXianquId());
			temStopRec.setMapDetail(carGps.getMapDetail());
			temStopRec.setCountDate(dateInt);
			temStopRec.setCountMonth(countMonth);
			temStopRec.setYearNum(yearNum);
			insert(temStopRec);
		}


    }

	/**
	 * 根据主键和分片字段查询分片表中的记录
	 * @param id
	 * @param countMonth
	 * @return
	 */
	private BigdataCarStopRecord loadByIdAndDate(String id, int countMonth) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id",id);
		param.put("countMonth",countMonth);
		return mapper.loadByIdAndDate(param);
	}

	/**
	 *
	 * @param minMinuteNum
	 * @return
	 */
	public List<BigdataCarStopRecord> listUnPoiStopRec(int minMinuteNum) {
		return mapper.listUnPoiStopRec(minMinuteNum);
    }

	/**
	 * 根据类型统计省的去向分布
	 * @param carType
	 * @return
	 */
	public List<CarQuXiangGroupCount> selectProvinceQuXiangGroup(
			String carType,Integer countDate,Integer countMonth,Integer yearNum) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carType",carType);
		param.put("countDate",countDate);
		param.put("countMonth",countMonth);
		param.put("yearNum",yearNum);
		/*return mapper.selectProvinceQuXiangGroup(param);*/
		List<BigdataCarStopRecord> carStopList = mapper.selectProvinceQuXiangGroupOfCar(param);
		List<CarQuXiangGroupCount>  groupList = new ArrayList<CarQuXiangGroupCount>();
		Map<String,CarQuXiangGroupCount> quXiangGroupMap = new HashMap<String,CarQuXiangGroupCount>();
		for(BigdataCarStopRecord stopRec : carStopList){
			String provinceName = stopRec.getMapProvince();
			CarQuXiangGroupCount oraGroupCount = quXiangGroupMap.get(provinceName);
			if(oraGroupCount==null){
				oraGroupCount = new CarQuXiangGroupCount();
				quXiangGroupMap.put(provinceName,oraGroupCount);
				groupList.add(oraGroupCount);
				oraGroupCount.setCount(1);
				oraGroupCount.setMapProvince(provinceName);
			}else{
				int count = oraGroupCount.getCount();
				oraGroupCount.setCount( count + 1 );
			}
		}
		return groupList;
	}

    public List<CarQuXiangGroupCount> selectCityQuXiangGroup(
    		String carType,Integer countDate,Integer countMonth,Integer yearNum) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carType",carType);
		param.put("countDate",countDate);
		param.put("countMonth",countMonth);
		param.put("yearNum",yearNum);
		/*return mapper.selectCityQuXiangGroup(param);*/
		List<BigdataCarStopRecord> carStopList = mapper.selectCityQuXiangGroupOfCar(param);
		List<CarQuXiangGroupCount>  groupList = new ArrayList<CarQuXiangGroupCount>();
		Map<String,CarQuXiangGroupCount> quXiangGroupMap = new HashMap<String,CarQuXiangGroupCount>();
		for(BigdataCarStopRecord stopRec : carStopList){
			String cityName = stopRec.getMapCity();
			CarQuXiangGroupCount oraGroupCount = quXiangGroupMap.get(cityName);
			if(oraGroupCount==null){
				oraGroupCount = new CarQuXiangGroupCount();
				quXiangGroupMap.put(cityName,oraGroupCount);
				groupList.add(oraGroupCount);
				oraGroupCount.setCount(1);
				oraGroupCount.setMapCity(cityName);
				oraGroupCount.setMapProvince(stopRec.getMapProvince());
			}else{
				int count = oraGroupCount.getCount();
				oraGroupCount.setCount( count + 1 );
			}
		}
		return groupList;



    }

	public List<BigdataCarStopRecord> selectCityQuXiangGroupNew(
			String carType,Integer countDate,Integer countMonth,Integer yearNum) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carType",carType);
		param.put("countDate",countDate);
		param.put("countMonth",countMonth);
		param.put("yearNum",yearNum);
		/*return mapper.selectCityQuXiangGroup(param);*/
		List<BigdataCarStopRecord> carStopList = mapper.selectCityQuXiangGroupOfCarNew(param);
		return carStopList;
	}

	/**
	 * 查出某辆车几天内的停车列表，根据时间正序排列一下
	 * @param carRealId
	 * @param dateMin 查询开始日期
	 * @param dateMax 截止日期
	 * @return
	 */
    public List<BigdataCarStopRecord> listCarStopRecOfCar(String carRealId,Date dateMin, Date dateMax) {
		String minStr = sdf.format(dateMin);
		Integer countDateMin = new Integer(minStr);
		Integer countMonthMin = countDateMin/100;
		String maxStr = sdf.format(dateMax);
		Integer countDateMax = new Integer(maxStr);
		Integer countMonthMax = countDateMax/100;

		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carRealId",carRealId);
		param.put("countDateMin",countDateMin);
		param.put("countMonthMin",countMonthMin);
		param.put("countDateMax",countDateMax);
		param.put("countMonthMax",countMonthMax);
		return mapper.listCarStopRecOfCar(param);
    }
}
