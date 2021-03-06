package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.MapLocaltionPoint;
import com.edgedo.bigdata.mapper.MapLocaltionPointMapper;
import com.edgedo.bigdata.queryvo.MapLocaltionPointQuery;
import com.edgedo.bigdata.queryvo.MapLocaltionPointView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class MapLocaltionPointService {
	
	
	@Autowired
	private MapLocaltionPointMapper mapper;

	
	public List<MapLocaltionPointView> listPage(MapLocaltionPointQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(MapLocaltionPoint voObj) {
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
	public String update(MapLocaltionPoint voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(MapLocaltionPoint voObj) {
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
	public MapLocaltionPoint loadById(String id) {
		return mapper.selectById(id);
	}


	public MapLocaltionPoint selectByXianQuId(String xianquId,String carType) {
		Map<String,String> map = new HashMap<>();
		map.put("xianquId",xianquId);
		map.put("carType",carType);
		return mapper.selectByXianQuId(map);
	}

	public Integer countCarNumByCityId(String cityId,String carType) {
		Map<String,String> map = new HashMap();
		map.put("cityId",cityId);
		map.put("carType",carType);
		return mapper.countCarNumByCityId(map);
	}

	public MapLocaltionPoint selectByCityId(String cityId,String carType) {
		Map<String,String> map = new HashMap<>();
		map.put("cityId",cityId);
		map.put("carType",carType);
		return mapper.selectByCityId(map);
	}

	public Integer countCarNumByProviceId(String proviceId,String carType) {
		Map<String,String> map = new HashMap<>();
		map.put("proviceId",proviceId);
		map.put("carType",carType);
		return mapper.countCarNumByProviceId(map);
	}

	public MapLocaltionPoint selectByProviceId(String proviceId,String carType) {
		Map<String,String> map = new HashMap<>();
		map.put("proviceId",proviceId);
		map.put("carType",carType);
		return mapper.selectByProviceId(map);
	}
}
