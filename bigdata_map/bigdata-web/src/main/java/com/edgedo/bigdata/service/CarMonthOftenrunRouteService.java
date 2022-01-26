package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.CarMonthOftenrunRoute;
import com.edgedo.bigdata.mapper.CarMonthOftenrunRouteMapper;
import com.edgedo.bigdata.queryvo.CarMonthOftenrunRouteQuery;
import com.edgedo.bigdata.queryvo.CarMonthOftenrunRouteView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarMonthOftenrunRouteService {
	
	
	@Autowired
	private CarMonthOftenrunRouteMapper mapper;

	
	public List<CarMonthOftenrunRouteView> listPage(CarMonthOftenrunRouteQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	public List<CarMonthOftenrunRouteView> qtlistPage(CarMonthOftenrunRouteQuery query){
		List list = mapper.qtlistPage(query);
		query.setList(list);
		return list;
	}
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(CarMonthOftenrunRoute voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(CarMonthOftenrunRoute voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(CarMonthOftenrunRoute voObj) {
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
	public CarMonthOftenrunRoute loadById(String id) {
		return mapper.selectById(id);
	}
	
	public List<CarMonthOftenrunRouteView> searchOftenRunRoute(CarMonthOftenrunRouteQuery query){
		return mapper.searchOftenRunRoute(query);
	}

	public List<CarMonthOftenrunRouteView> selectOftenRunRoute(CarMonthOftenrunRouteQuery query) {
		return mapper.selectOftenRunRoute(query);
	}
}
