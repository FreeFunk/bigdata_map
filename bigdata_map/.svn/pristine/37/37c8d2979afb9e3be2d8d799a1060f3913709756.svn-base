package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataLinshiBatch;
import com.edgedo.bigdata.mapper.BigdataLinshiBatchMapper;
import com.edgedo.bigdata.queryvo.BigdataLinshiBatchQuery;
import com.edgedo.bigdata.queryvo.BigdataLinshiBatchView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataLinshiBatchService {
	
	
	@Autowired
	private BigdataLinshiBatchMapper mapper;

	
	public List<BigdataLinshiBatchView> listPage(BigdataLinshiBatchQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataLinshiBatch voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataLinshiBatch voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataLinshiBatch voObj) {
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
	public BigdataLinshiBatch loadById(String id) {
		return mapper.selectById(id);
	}
	

}
