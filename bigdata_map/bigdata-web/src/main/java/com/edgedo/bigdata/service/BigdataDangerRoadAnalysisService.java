package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataDangerRoadAnalysis;
import com.edgedo.bigdata.mapper.BigdataDangerRoadAnalysisMapper;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadAnalysisView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataDangerRoadAnalysisService {
	
	
	@Autowired
	private BigdataDangerRoadAnalysisMapper mapper;

	
	public List<BigdataDangerRoadAnalysisView> listPage(BigdataDangerRoadAnalysisQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDangerRoadAnalysis voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDangerRoadAnalysis voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDangerRoadAnalysis voObj) {
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
	public BigdataDangerRoadAnalysis loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataDangerRoadAnalysisView> getDangerRoadClsDetailData(BigdataDangerRoadAnalysisQuery query) {
		return  mapper.getDangerRoadClsDetailData(query);
	}
}
