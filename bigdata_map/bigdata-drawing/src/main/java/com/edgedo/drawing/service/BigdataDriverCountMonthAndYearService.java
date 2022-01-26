package com.edgedo.drawing.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.drawing.entity.BigdataDriverCountMonthAndYear;
import com.edgedo.drawing.mapper.BigdataDriverCountMonthAndYearMapper;
import com.edgedo.drawing.queryvo.BigdataDriverCountMonthAndYearQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCountMonthAndYearView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataDriverCountMonthAndYearService {
	
	
	@Autowired
	private BigdataDriverCountMonthAndYearMapper mapper;

	
	public List<BigdataDriverCountMonthAndYearView> listPage(BigdataDriverCountMonthAndYearQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverCountMonthAndYear voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverCountMonthAndYear voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverCountMonthAndYear voObj) {
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
	public BigdataDriverCountMonthAndYear loadById(String id) {
		return mapper.selectById(id);
	}

	public BigdataDriverCountMonthAndYearView selectByDriverId(BigdataDriverCountMonthAndYearQuery query){
		return mapper.selectVoByDriverId(query);
	}

}
