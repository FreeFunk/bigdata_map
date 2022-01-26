package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataCarStopRec;
import com.edgedo.bigdata.entity.BigdataCarStopRecord;
import com.edgedo.bigdata.entity.BigdataDriverCardInfo;
import com.edgedo.drawing.entity.BigdataDriverStopRec;
import com.edgedo.bigdata.mapper.BigdataCarStopRecMapper;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecQuery;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecView;
import com.edgedo.common.util.Guid;
import com.edgedo.drawing.service.BigdataDriverStopRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataCarStopRecService {
	
	
	@Autowired
	private BigdataCarStopRecMapper mapper;
	@Autowired
	private BigdataCarStopRecordService carStopRecordService;
	@Autowired
	private BigdataDriverCardInfoService bigdataDriverCardInfoService;
	@Autowired
	private BigdataDriverStopRecService bigdataDriverStopRecService;
	
	public List<BigdataCarStopRecView> listPage(BigdataCarStopRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataCarStopRec voObj) {
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
	public String update(BigdataCarStopRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataCarStopRec voObj) {
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
	public BigdataCarStopRec loadById(String id) {
		return mapper.selectById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertCarStopRec(String carType, int countDate, int countMonth, int yearNum) {

		List<BigdataCarStopRecord> carStopRecordList = carStopRecordService.selectCityQuXiangGroupNew(null,countDate,countMonth,yearNum);
		for(BigdataCarStopRecord b:carStopRecordList){
			//查询车的记录是否已经存在
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("carType",carType);
			param.put("countDate",countDate);
			param.put("countMonth",countMonth);
			param.put("yearNum",yearNum);
			param.put("carRealId",b.getCarRealId());
			param.put("mapCityId",b.getMapCityId());
		/*	BigdataCarStopRecView bigdataCarStopRecView = mapper.selectByCarRealId(param);
			if(bigdataCarStopRecView!=null){
				continue;
			}*/
			String cityStr = b.getMapCityId();
			if(cityStr==null ||cityStr.trim().equals("")){
				cityStr = b.getMapCity();
			}

			String id = countDate + "_" + b.getCarRealId() + "_" + cityStr;
			param.put("id",id);
			int count = mapper.countByIdAndCountMonth(param);
			if(count>0){
				continue;
			}
			BigdataCarStopRec bigdataCarStopRec = new BigdataCarStopRec();

			bigdataCarStopRec.setId(id);
			bigdataCarStopRec.setAltitude(b.getAltitude());
			bigdataCarStopRec.setCarPlateColor(b.getCarPlateColor());
			bigdataCarStopRec.setCarPlateNum(b.getCarPlateNum());
			bigdataCarStopRec.setCarRealId(b.getCarRealId());
			bigdataCarStopRec.setCarType(b.getCarType());
			bigdataCarStopRec.setCountDate(b.getCountDate());
			bigdataCarStopRec.setCountMonth(b.getCountMonth());
			bigdataCarStopRec.setMapCity(b.getMapCity());
			bigdataCarStopRec.setMapCityId(b.getMapCityId());
			bigdataCarStopRec.setMapCountry(b.getMapCountry());
			bigdataCarStopRec.setMapDetail(b.getMapDetail());
			bigdataCarStopRec.setMapProvince(b.getMapProvince());
			bigdataCarStopRec.setMapProvinceId(b.getMapProvinceId());
			bigdataCarStopRec.setMapXianqu(b.getMapXianqu());
			bigdataCarStopRec.setMapXianquId(b.getMapXianquId());
			bigdataCarStopRec.setPointLat(b.getPointLat());
			bigdataCarStopRec.setPointLong(b.getPointLong());
			bigdataCarStopRec.setYearNum(b.getYearNum());
			mapper.insert(bigdataCarStopRec);
			//获取车辆关联的驾驶员的信息插入停车记录
			Map<String,String> map = new HashMap<>();
			map.put("carPlateNum",b.getCarPlateNum());
			map.put("carPlateColor",b.getCarPlateColor());
			List<BigdataDriverCardInfo> driverCardInfoList = bigdataDriverCardInfoService.selectByCarPlateNumAndColor(map);
			for(BigdataDriverCardInfo d:driverCardInfoList){
				BigdataDriverStopRec bigdataDriverStopRec = new BigdataDriverStopRec();
				bigdataDriverStopRec.setCarRealId(b.getCarPlateNum()+"_"+b.getCarPlateColor());
				bigdataDriverStopRec.setDriverId(d.getId());
				bigdataDriverStopRec.setDriverName(d.getDriverName());
				bigdataDriverStopRec.setDriverSex(d.getDriverSex());
				bigdataDriverStopRec.setDriverAge(d.getDriverAge());
				bigdataDriverStopRec.setDriverPhone(d.getDriverPhone());
				bigdataDriverStopRec.setDriverIdCard(d.getDriverIdCard());
				bigdataDriverStopRec.setDriverCode(d.getDriverCode());
				bigdataDriverStopRec.setMapCountry(b.getMapCountry());
				bigdataDriverStopRec.setMapProvinceId(b.getMapProvinceId());
				bigdataDriverStopRec.setMapProvince(b.getMapProvince());
				bigdataDriverStopRec.setMapCity(b.getMapCity());
				bigdataDriverStopRec.setMapCityId(b.getMapCityId());
				bigdataDriverStopRec.setCountDate(b.getCountDate());
				bigdataDriverStopRec.setCountMonth(b.getCountMonth());
				bigdataDriverStopRec.setYearNum(b.getYearNum());
				bigdataDriverStopRecService.insert(bigdataDriverStopRec);
			}
		}
	}
}
