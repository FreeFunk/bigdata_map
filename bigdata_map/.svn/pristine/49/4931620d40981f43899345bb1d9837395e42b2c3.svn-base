package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.CredibilityCheckRec;
import com.edgedo.bigdata.mapper.CredibilityCheckRecMapper;
import com.edgedo.bigdata.queryvo.CredibilityCheckRecQuery;
import com.edgedo.bigdata.queryvo.CredibilityCheckRecView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredibilityCheckRecService {
	
	
	@Autowired
	private CredibilityCheckRecMapper mapper;

	
	public List<CredibilityCheckRecView> listPage(CredibilityCheckRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(CredibilityCheckRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(CredibilityCheckRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(CredibilityCheckRec voObj) {
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
	public CredibilityCheckRec loadById(String id) {
		return mapper.selectById(id);
	}



	public List<CredibilityCheckRecView> listpageCheckRec(CredibilityCheckRecQuery query){
		List list = mapper.listpageCheckRec(query);
		query.setList(list);
		return list;
	}
}
