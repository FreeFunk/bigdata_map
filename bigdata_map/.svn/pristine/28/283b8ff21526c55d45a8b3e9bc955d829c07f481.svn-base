package com.edgedo.drawing.service;

import com.edgedo.drawing.entity.BigdataDriverStopCount;
import com.edgedo.drawing.entity.BigdataDriverStopRec;
import com.edgedo.drawing.mapper.BigdataDriverStopRecMapper;
import com.edgedo.drawing.queryvo.BigdataDriverStopRecQuery;
import com.edgedo.drawing.queryvo.BigdataDriverStopRecView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BigdataDriverStopRecService {
	
	
	@Autowired
	private BigdataDriverStopRecMapper mapper;

	
	public List<BigdataDriverStopRecView> listPage(BigdataDriverStopRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverStopRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverStopRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverStopRec voObj) {
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
	public BigdataDriverStopRec loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataDriverStopCount> selectGroupCityIdById(String driverId,int countMonth) {
		Map<String,Object> map = new HashMap<>();
		map.put("driverId",driverId);
		map.put("countMonth",countMonth);
		return mapper.selectGroupCityIdById(map);
	}
}
