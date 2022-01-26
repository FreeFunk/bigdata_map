package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataCarDayOftenrunRoute;
import com.edgedo.bigdata.mapper.BigdataCarDayOftenrunRouteMapper;
import com.edgedo.bigdata.queryvo.BigdataCarDayOftenrunRouteQuery;
import com.edgedo.bigdata.queryvo.BigdataCarDayOftenrunRouteView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataCarDayOftenrunRouteService {
	
	
	@Autowired
	private BigdataCarDayOftenrunRouteMapper mapper;

	
	public List<BigdataCarDayOftenrunRouteView> listPage(BigdataCarDayOftenrunRouteQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	public List<BigdataCarDayOftenrunRouteView> qtlistPage(BigdataCarDayOftenrunRouteQuery query){
		List list = mapper.qtlistPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataCarDayOftenrunRoute voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataCarDayOftenrunRoute voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataCarDayOftenrunRoute voObj) {
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
	public BigdataCarDayOftenrunRoute loadById(String id) {
		return mapper.selectById(id);
	}
	

}
