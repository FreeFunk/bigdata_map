package com.edgedo.drawing.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;

import com.edgedo.drawing.entity.BigdataDriverChangeCarRec;
import com.edgedo.drawing.mapper.BigdataDriverChangeCarRecMapper;
import com.edgedo.drawing.queryvo.BigdataDriverChangeCarRecQuery;
import com.edgedo.drawing.queryvo.BigdataDriverChangeCarRecView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataDriverChangeCarRecService {
	
	
	@Autowired
	private BigdataDriverChangeCarRecMapper mapper;

	
	public List<BigdataDriverChangeCarRecView> listPage(BigdataDriverChangeCarRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverChangeCarRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverChangeCarRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverChangeCarRec voObj) {
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
	public BigdataDriverChangeCarRec loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataDriverChangeCarRecView> selectByDriverId(String driverId) {
		return mapper.selectByDriverId(driverId);
	}
}
