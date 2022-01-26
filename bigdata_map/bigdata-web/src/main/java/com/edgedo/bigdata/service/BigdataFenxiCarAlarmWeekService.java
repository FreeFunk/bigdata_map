package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataFenxiCarAlarmWeek;
import com.edgedo.bigdata.mapper.BigdataFenxiCarAlarmWeekMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarAlarmWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarAlarmWeekView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataFenxiCarAlarmWeekService {
	
	
	@Autowired
	private BigdataFenxiCarAlarmWeekMapper mapper;

	
	public List<BigdataFenxiCarAlarmWeekView> listPage(BigdataFenxiCarAlarmWeekQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	/**
	 * 非分页查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarAlarmWeekView> listByObj(BigdataFenxiCarAlarmWeekQuery query){
		List list = mapper.listByObj(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
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
	public String update(BigdataFenxiCarAlarmWeek voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataFenxiCarAlarmWeek voObj) {
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
	public BigdataFenxiCarAlarmWeek loadById(String id) {
		return mapper.selectById(id);
	}
	

}
