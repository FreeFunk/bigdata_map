package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.bigdata.queryvo.BigdataBeidouDataCountQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouDataCountView;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataCoefficientRec;
import com.edgedo.bigdata.mapper.BigdataCoefficientRecMapper;
import com.edgedo.bigdata.queryvo.BigdataCoefficientRecQuery;
import com.edgedo.bigdata.queryvo.BigdataCoefficientRecView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataCoefficientRecService {
	
	
	@Autowired
	private BigdataCoefficientRecMapper mapper;

	
	public List<BigdataCoefficientRecView> listPage(BigdataCoefficientRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataCoefficientRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataCoefficientRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataCoefficientRec voObj) {
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
	public BigdataCoefficientRec loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataCoefficientRecView getCoefficientNum(BigdataCoefficientRecQuery query) {
		return mapper.getCoefficientNum(query);
	}

	public BigdataBeidouDataCountView getbeidouInCountData(BigdataBeidouDataCountQuery query) {
		return null;
	}
}
