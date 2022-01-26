package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataBeidouDataCount;
import com.edgedo.bigdata.mapper.BigdataBeidouDataCountMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouDataCountQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouDataCountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataBeidouDataCountService {
	
	
	@Autowired
	private BigdataBeidouDataCountMapper mapper;

	
	public List<BigdataBeidouDataCountView> listPage(BigdataBeidouDataCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataBeidouDataCount voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataBeidouDataCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataBeidouDataCount voObj) {
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
	public BigdataBeidouDataCount loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataBeidouDataCountView getbeidouInCountData(BigdataBeidouDataCountQuery query) {
		return mapper.getbeidouInCountData(query);
	}
}
