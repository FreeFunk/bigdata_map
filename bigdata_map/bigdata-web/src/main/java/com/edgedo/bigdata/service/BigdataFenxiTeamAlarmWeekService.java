package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataFenxiTeamAlarmWeek;
import com.edgedo.bigdata.mapper.BigdataFenxiTeamAlarmWeekMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamAlarmWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamAlarmWeekView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataFenxiTeamAlarmWeekService {
	
	
	@Autowired
	private BigdataFenxiTeamAlarmWeekMapper mapper;

	
	public List<BigdataFenxiTeamAlarmWeekView> listPage(BigdataFenxiTeamAlarmWeekQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataFenxiTeamAlarmWeek voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataFenxiTeamAlarmWeek voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataFenxiTeamAlarmWeek voObj) {
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
	public BigdataFenxiTeamAlarmWeek loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 获取企业报警数量前6名报警类型
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiTeamAlarmWeek> selectTopSixByOwnerTeamDayId(BigdataFenxiTeamAlarmWeekQuery query){
		return mapper.selectTopSixByOwnerTeamDayId(query);
	}

}
