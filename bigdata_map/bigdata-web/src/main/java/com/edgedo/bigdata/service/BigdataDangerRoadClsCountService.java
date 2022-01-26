package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataDangerRoadClsCount;
import com.edgedo.bigdata.mapper.BigdataDangerRoadClsCountMapper;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadClsCountQuery;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadClsCountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataDangerRoadClsCountService {
	
	
	@Autowired
	private BigdataDangerRoadClsCountMapper mapper;

	
	public List<BigdataDangerRoadClsCountView> listPage(BigdataDangerRoadClsCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDangerRoadClsCount voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDangerRoadClsCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDangerRoadClsCount voObj) {
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
	public BigdataDangerRoadClsCount loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataDangerRoadClsCountView getDangerRoadClsCountData(BigdataDangerRoadClsCountQuery query) {
		return mapper.getDangerRoadClsCountData(query);
	}
}
