package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataFenxiAlarmTime;
import com.edgedo.bigdata.mapper.BigdataFenxiAlarmTimeMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmTimeQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmTimeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataFenxiAlarmTimeService {
	
	
	@Autowired
	private BigdataFenxiAlarmTimeMapper mapper;

	
	public List<BigdataFenxiAlarmTimeView> listPage(BigdataFenxiAlarmTimeQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataFenxiAlarmTime voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataFenxiAlarmTime voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataFenxiAlarmTime voObj) {
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
	public BigdataFenxiAlarmTime loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataFenxiAlarmTime> selectByDay(String carType, String xianQuId, Integer timeCount, String timeType) {
		return mapper.selectByDay( carType,  xianQuId,  timeCount,  timeType);
	}
}
