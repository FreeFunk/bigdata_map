package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BeidouDataInCount;
import com.edgedo.bigdata.mapper.BeidouDataInCountMapper;
import com.edgedo.bigdata.queryvo.BeidouDataInCountQuery;
import com.edgedo.bigdata.queryvo.BeidouDataInCountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeidouDataInCountService {
	
	
	@Autowired
	private BeidouDataInCountMapper mapper;

	
	public List<BeidouDataInCountView> listPage(BeidouDataInCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BeidouDataInCount voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BeidouDataInCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BeidouDataInCount voObj) {
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
	public BeidouDataInCount loadById(String id) {
		return mapper.selectById(id);
	}


	public BeidouDataInCountView getbeidouInCountData(BeidouDataInCountQuery query) {
		return mapper.getbeidouInCountData(query);
	}


	public List<BeidouDataInCountView> listpageForBeidouData(BeidouDataInCountQuery query){
		List list = mapper.listpageForBeidouData(query);
		query.setList(list);
		return list;
	}

}
