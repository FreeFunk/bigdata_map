package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataFenxiCarAlarmWeek;
import com.edgedo.bigdata.mapper.BigdataFenxiCarAlarmWeekMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarAlarmWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarAlarmWeekView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataFenxiCarAlarmWeekService {
	
	
	@Autowired
	private BigdataFenxiCarAlarmWeekMapper mapper;

	
	public List<BigdataFenxiCarAlarmWeekView> listPage(BigdataFenxiCarAlarmWeekQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFenxiCarAlarmWeek voObj) {
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
	public String update(BigdataFenxiCarAlarmWeek voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFenxiCarAlarmWeek voObj) {
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
	public BigdataFenxiCarAlarmWeek loadById(String id) {
		return mapper.selectById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(BigdataFenxiCarAlarmWeek bigdataFenxiCarAlarmWeek) {
		BigdataFenxiCarAlarmWeek bigdataFenxiCarAlarmWeek1 = mapper.selectByOwnerCarDayIdAndType(bigdataFenxiCarAlarmWeek);
		if(bigdataFenxiCarAlarmWeek1==null){
			bigdataFenxiCarAlarmWeek.setId(Guid.guid());
			bigdataFenxiCarAlarmWeek.setCreateTime(new Date());
			mapper.insert(bigdataFenxiCarAlarmWeek);
		}else {
			bigdataFenxiCarAlarmWeek.setId(bigdataFenxiCarAlarmWeek1.getId());
			bigdataFenxiCarAlarmWeek.setUpdateTime(new Date());
			mapper.updateByFenPian(bigdataFenxiCarAlarmWeek);
		}
	}
}
