package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.PeccancyRec;
import com.edgedo.bigdata.mapper.PeccancyRecMapper;
import com.edgedo.bigdata.queryvo.PeccancyRecQuery;
import com.edgedo.bigdata.queryvo.PeccancyRecView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeccancyRecService {
	
	
	@Autowired
	private PeccancyRecMapper mapper;

	
	public List<PeccancyRecView> listPage(PeccancyRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(PeccancyRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(PeccancyRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(PeccancyRec voObj) {
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
	public PeccancyRec loadById(String id) {
		return mapper.selectById(id);
	}



	public List<PeccancyRecView> listpagePeccancyRec(PeccancyRecQuery query){
		List list = mapper.listpagePeccancyRec(query);
		query.setList(list);
		return list;
	}

	public List<PeccancyRecView> listPagePRByCarInfo(PeccancyRecQuery query){
		List list = mapper.listPagePRByCarInfo(query);
		query.setList(list);
		return list;
	}
}
