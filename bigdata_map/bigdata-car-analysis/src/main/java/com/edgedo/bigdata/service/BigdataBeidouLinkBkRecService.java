package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataBeidouLinkBkRec;
import com.edgedo.bigdata.mapper.BigdataBeidouLinkBkRecMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouLinkBkRecQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouLinkBkRecView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataBeidouLinkBkRecService {
	
	
	@Autowired
	private BigdataBeidouLinkBkRecMapper mapper;

	
	public List<BigdataBeidouLinkBkRecView> listPage(BigdataBeidouLinkBkRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataBeidouLinkBkRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataBeidouLinkBkRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataBeidouLinkBkRec voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public BigdataBeidouLinkBkRec loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataBeidouLinkBkRec selectByTime(Map<String, Object> map) {
		return mapper.selectByTime(map);
	}

	public int sumLinkMinNum(Map<String, Object> param4) {
		return mapper.sumLinkMinNum(param4);
	}
}
