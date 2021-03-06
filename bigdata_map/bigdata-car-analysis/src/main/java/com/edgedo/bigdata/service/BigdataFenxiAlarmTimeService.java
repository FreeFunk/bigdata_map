package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataFenxiAlarmTime;
import com.edgedo.bigdata.mapper.BigdataFenxiAlarmTimeMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmTimeQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmTimeView;
import com.edgedo.common.util.Guid;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
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
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
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
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataFenxiAlarmTime voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFenxiAlarmTime voObj) {
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
	public BigdataFenxiAlarmTime loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataFenxiAlarmTime> selectByDay(String carType, String xianQuId, Integer timeCount, String timeType) {
		return mapper.selectByDay( carType,  xianQuId,  timeCount,  timeType);
	}

	public int selectByCount(Integer yearNum ,Integer countMonth, Integer countDay,
							 String xianQuId, String carType,String dataType,String alarmType) {
		return mapper.selectByCount(yearNum, countMonth,  countDay,  xianQuId,  carType,dataType,alarmType);
	}

	public int selectByCountChangGui(Integer yearNum ,Integer countMonth, Integer countDay,
									 String xianQuId, String carType,String dataType,String alarmType) {
		return mapper.selectByCountChangGui(yearNum, countMonth,  countDay,  xianQuId,  carType,dataType,alarmType);
	}

	public int selectByCountAll(Integer yearNum ,Integer countMonth,
								Integer countDay, String xianQuId, String carType,String dataType,String alarmType) {
		return mapper.selectByCountAll(yearNum, countMonth,  countDay,  xianQuId,  carType,dataType,alarmType);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateRecord(BigdataFenxiAlarmTime bigdataFenxiAlarmTime) {
		mapper.updateRecord( bigdataFenxiAlarmTime);
	}
}
