package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataFenxiCarAlarmMonth;
import com.edgedo.bigdata.mapper.BigdataFenxiCarAlarmMonthMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarAlarmMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarAlarmMonthView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataFenxiCarAlarmMonthService {
	
	
	@Autowired
	private BigdataFenxiCarAlarmMonthMapper mapper;

	
	public List<BigdataFenxiCarAlarmMonthView> listPage(BigdataFenxiCarAlarmMonthQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFenxiCarAlarmMonth voObj) {
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
	public String update(BigdataFenxiCarAlarmMonth voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFenxiCarAlarmMonth voObj) {
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
	public BigdataFenxiCarAlarmMonth loadById(String id) {
		return mapper.selectById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(BigdataFenxiCarAlarmMonth bigdataFenxiCarAlarmMonth) {
		BigdataFenxiCarAlarmMonth bigdataFenxiCarAlarmMonth1 = mapper.selectByOwnerCarMonthIdAndType(bigdataFenxiCarAlarmMonth);
		if(bigdataFenxiCarAlarmMonth1==null){
			bigdataFenxiCarAlarmMonth.setId(Guid.guid());
			bigdataFenxiCarAlarmMonth.setCreateTime(new Date());
			mapper.insert(bigdataFenxiCarAlarmMonth);
		}else {
			bigdataFenxiCarAlarmMonth.setId(bigdataFenxiCarAlarmMonth1.getId());
			bigdataFenxiCarAlarmMonth.setUpdateTime(new Date());
			mapper.updateByFenPian(bigdataFenxiCarAlarmMonth);
		}
	}
}
