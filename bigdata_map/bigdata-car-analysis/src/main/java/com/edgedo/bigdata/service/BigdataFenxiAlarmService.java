package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataFenxiAlarm;
import com.edgedo.bigdata.mapper.BigdataFenxiAlarmMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataFenxiAlarmService {
	
	
	@Autowired
	private BigdataFenxiAlarmMapper mapper;

	
	public List<BigdataFenxiAlarmView> listPage(BigdataFenxiAlarmQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFenxiAlarm voObj) {
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
	public String update(BigdataFenxiAlarm voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFenxiAlarm voObj) {
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
	public BigdataFenxiAlarm loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataFenxiAlarm> selectByDay(String carType, String xianQuId, Integer timeCount, String timeType) {
		return mapper.selectByDay( carType,  xianQuId,  timeCount,  timeType);
	}

	public List<BigdataFenxiAlarm> selectByWeek(String carType, String xianQuId, Integer timeChangeAge, Integer timeChangeWeek, String timeType) {
		return mapper.selectByWeek( carType,  xianQuId,  timeChangeAge,  timeChangeWeek,  timeType);
	}

	public List<BigdataFenxiAlarm> selectByMonth(String carType, String xianQuId, Integer timeCount, String timeType) {
		return mapper.selectByMonth( carType,  xianQuId,  timeCount,  timeType);
	}

	public BigdataFenxiAlarm selectVoForWeekOrMonth(BigdataFenxiAlarmQuery query){
		return mapper.selectVoForWeekOrMonth(query);
	}
}
