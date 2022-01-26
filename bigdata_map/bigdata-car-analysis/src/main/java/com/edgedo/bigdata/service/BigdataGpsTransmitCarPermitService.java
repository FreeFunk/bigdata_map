package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataGpsTransmitCarPermit;
import com.edgedo.bigdata.mapper.BigdataGpsTransmitCarPermitMapper;
import com.edgedo.bigdata.queryvo.BigdataGpsTransmitCarPermitQuery;
import com.edgedo.bigdata.queryvo.BigdataGpsTransmitCarPermitView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataGpsTransmitCarPermitService {
	
	
	@Autowired
	private BigdataGpsTransmitCarPermitMapper mapper;

	
	public List<BigdataGpsTransmitCarPermitView> listPage(BigdataGpsTransmitCarPermitQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataGpsTransmitCarPermit voObj) {
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
	public String update(BigdataGpsTransmitCarPermit voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataGpsTransmitCarPermit voObj) {
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
	public BigdataGpsTransmitCarPermit loadById(String id) {
		return mapper.selectById(id);
	}


	public Set<String> selectCarPermitByPlatId(String platId) {
		return mapper.selectCarPermitByPlatId(platId);
	}
}
