package com.edgedo.drawing.service;
		
import java.util.List;
import java.util.Map;

import com.edgedo.common.util.Guid;
import com.edgedo.drawing.entity.BigdataDriverStopCount;
import com.edgedo.drawing.mapper.BigdataDriverStopCountMapper;
import com.edgedo.drawing.queryvo.BigdataDriverStopCountQuery;
import com.edgedo.drawing.queryvo.BigdataDriverStopCountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public BigdataDriverStopCountView selectListByDriverIdAndCity(BigdataDriverStopCountQuery query){
		return mapper.selectListByDriverIdAndCity(query);
	}

	public List<String> selectTotalStopCity(Map<String,Object> paramMap){
		return mapper.selectTotalStopCity(paramMap);
	}

	public List<BigdataDriverStopCountView> selectTotalStopCityNew(Map<String, Object> paramMap) {
		return mapper.selectTotalStopCityNew(paramMap);
	}
}
