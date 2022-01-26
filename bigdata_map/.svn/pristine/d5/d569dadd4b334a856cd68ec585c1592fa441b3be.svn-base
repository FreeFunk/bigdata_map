package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.CityTransportCapacityAnalysis;
import com.edgedo.bigdata.mapper.CityTransportCapacityAnalysisMapper;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisQuery;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityTransportCapacityAnalysisService {
	
	
	@Autowired
	private CityTransportCapacityAnalysisMapper mapper;

	
	public List<CityTransportCapacityAnalysisView> listPage(CityTransportCapacityAnalysisQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(CityTransportCapacityAnalysis voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(CityTransportCapacityAnalysis voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(CityTransportCapacityAnalysis voObj) {
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
	public CityTransportCapacityAnalysis loadById(String id) {
		return mapper.selectById(id);
	}
	

}
