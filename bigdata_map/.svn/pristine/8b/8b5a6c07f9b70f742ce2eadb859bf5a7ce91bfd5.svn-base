package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataFenxiTeamAlarmMonth;
import com.edgedo.bigdata.mapper.BigdataFenxiTeamAlarmMonthMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamAlarmMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamAlarmMonthView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataFenxiTeamAlarmMonthService {
	
	
	@Autowired
	private BigdataFenxiTeamAlarmMonthMapper mapper;

	
	public List<BigdataFenxiTeamAlarmMonthView> listPage(BigdataFenxiTeamAlarmMonthQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFenxiTeamAlarmMonth voObj) {
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
	public String update(BigdataFenxiTeamAlarmMonth voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFenxiTeamAlarmMonth voObj) {
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
	public BigdataFenxiTeamAlarmMonth loadById(String id) {
		return mapper.selectById(id);
	}

	public List<BigdataFenxiTeamAlarmMonth> selectTopSixByOwnerTeamDayId(BigdataFenxiTeamAlarmMonthQuery query){
		return mapper.selectTopSixByOwnerTeamDayId(query);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(BigdataFenxiTeamAlarmMonth bigdataFenxiTeamAlarmMonth) {
		BigdataFenxiTeamAlarmMonth bigdataFenxiTeamAlarmMonth1 = mapper.selectByOwnerCarMonthIdAndType(bigdataFenxiTeamAlarmMonth);
		if(bigdataFenxiTeamAlarmMonth1==null){
			bigdataFenxiTeamAlarmMonth.setId(Guid.guid());
			bigdataFenxiTeamAlarmMonth.setCreateTime(new Date());
			mapper.insert(bigdataFenxiTeamAlarmMonth);
		}else {
			bigdataFenxiTeamAlarmMonth.setId(bigdataFenxiTeamAlarmMonth1.getId());
			bigdataFenxiTeamAlarmMonth.setUpdateTime(new Date());
			mapper.updateByFenPian(bigdataFenxiTeamAlarmMonth);
		}
	}
}
