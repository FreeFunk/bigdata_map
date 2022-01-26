package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.ContinueLearnRec;
import com.edgedo.bigdata.mapper.ContinueLearnRecMapper;
import com.edgedo.bigdata.queryvo.ContinueLearnRecQuery;
import com.edgedo.bigdata.queryvo.ContinueLearnRecView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinueLearnRecService {
	
	
	@Autowired
	private ContinueLearnRecMapper mapper;

	
	public List<ContinueLearnRecView> listPage(ContinueLearnRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(ContinueLearnRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(ContinueLearnRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(ContinueLearnRec voObj) {
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
	public ContinueLearnRec loadById(String id) {
		return mapper.selectById(id);
	}


	public List<ContinueLearnRecView> listpageLearnRec(ContinueLearnRecQuery query) {
		List list = mapper.listpageLearnRec(query);
		query.setList(list);
		return list;
	}
}
