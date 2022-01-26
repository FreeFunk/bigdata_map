package com.edgedo.bigdata.service;
		
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataTeamAnalysisInfo;
import com.edgedo.bigdata.mapper.BigdataTeamAnalysisInfoMapper;
import com.edgedo.bigdata.queryvo.BigdataTeamAnalysisInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataTeamAnalysisInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataTeamAnalysisInfoService {
	
	
	@Autowired
	private BigdataTeamAnalysisInfoMapper mapper;

	
	public List<BigdataTeamAnalysisInfoView> listPage(BigdataTeamAnalysisInfoQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataTeamAnalysisInfo voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataTeamAnalysisInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataTeamAnalysisInfo voObj) {
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
	public BigdataTeamAnalysisInfo loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataTeamAnalysisInfoView> listPageByCountDate(BigdataTeamAnalysisInfoQuery query) {
		List list = mapper.listPageByCountDate(query);
		query.setList(list);
		return list;
	}

	public List<BigdataTeamAnalysisInfoView> selectByTeamType(Integer countDate, String teamType,String teamName,String xianquId) {
		Map<String,Object> map =  new HashMap<>();
		map.put("countDate",countDate);
		map.put("teamType",teamType);
		map.put("teamName",teamName);
		map.put("xianquId",xianquId);
		return mapper.selectByTeamType(map);
	}
}
