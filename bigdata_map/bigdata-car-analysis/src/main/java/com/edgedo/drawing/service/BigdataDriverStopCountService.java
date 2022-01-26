package com.edgedo.drawing.service;

import com.edgedo.drawing.entity.BigdataDriverStopCount;
import com.edgedo.drawing.mapper.BigdataDriverStopCountMapper;
import com.edgedo.drawing.queryvo.BigdataDriverStopCountQuery;
import com.edgedo.drawing.queryvo.BigdataDriverStopCountView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BigdataDriverStopCountService {
	
	
	@Autowired
	private BigdataDriverStopCountMapper mapper;

	
	public List<BigdataDriverStopCountView> listPage(BigdataDriverStopCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverStopCount voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverStopCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverStopCount voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public int deleteByIds(List<String> ids) {
		
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public BigdataDriverStopCount loadById(String id) {
		return mapper.selectById(id);
	}


	public void insertOrUpdateByCityId(BigdataDriverStopCount s) {
		BigdataDriverStopCount bigdataDriverStopCount = mapper.selectByCityId(s);
		if(bigdataDriverStopCount==null){
			s.setId(Guid.guid());
			mapper.insert(s);
		}else {
			bigdataDriverStopCount.setStopNum(s.getStopNum());
			bigdataDriverStopCount.setCountDate(s.getCountDate());
			mapper.updateByfenPian(bigdataDriverStopCount);
		}
	}

	public List<BigdataDriverStopCount> selectGroupCityIdById(String driverId, int yearNum) {
		Map<String,Object> map = new HashMap<>();
		map.put("driverId",driverId);
		map.put("yearNum",yearNum);
		return mapper.selectGroupCityIdById(map);
	}

	public String listTopThree(String driverId, int yearNum) {
		Map<String,Object> map = new HashMap<>();
		map.put("driverId",driverId);
		map.put("yearNum",yearNum);
		map.put("countType","YEAR");
		List<BigdataDriverStopCount>  driverStopCountList = mapper.listTopThree(map);
		String stopCitys = "";
		for(BigdataDriverStopCount s:driverStopCountList){
			if(stopCitys.equals("")){
				stopCitys = s.getMapCity();
			}else {
				stopCitys = stopCitys+","+s.getMapCity();
			}
		}
		return stopCitys;
	}
}
