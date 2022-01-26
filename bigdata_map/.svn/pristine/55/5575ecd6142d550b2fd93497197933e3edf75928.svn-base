package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataCarStopRec;
import com.edgedo.bigdata.mapper.BigdataCarStopRecMapper;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecQuery;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataCarStopRecService {
	
	
	@Autowired
	private BigdataCarStopRecMapper mapper;

	
	public List<BigdataCarStopRecView> listPage(BigdataCarStopRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	public List<BigdataCarStopRecView> qtlistPage(BigdataCarStopRecQuery query){
		List list = mapper.qtlistPage(query);
		query.setList(list);
		//统计总的数量
		List<BigdataCarStopRecView> list1 = mapper.countCarStopRec(query);
		query.setTotalCount(list1.size());
		return list;
	}

	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataCarStopRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataCarStopRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataCarStopRec voObj) {
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
	public BigdataCarStopRec loadById(String id) {
		return mapper.selectById(id);
	}
	

}
