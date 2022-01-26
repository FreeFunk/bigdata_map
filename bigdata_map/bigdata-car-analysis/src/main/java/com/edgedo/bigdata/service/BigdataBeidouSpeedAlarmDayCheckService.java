package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataBeidouSpeedAlarmDayCheck;
import com.edgedo.bigdata.mapper.BigdataBeidouSpeedAlarmDayCheckMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouSpeedAlarmDayCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouSpeedAlarmDayCheckView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataBeidouSpeedAlarmDayCheckService {
	
	
	@Autowired
	private BigdataBeidouSpeedAlarmDayCheckMapper mapper;

	
	public List<BigdataBeidouSpeedAlarmDayCheckView> listPage(BigdataBeidouSpeedAlarmDayCheckQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataBeidouSpeedAlarmDayCheck voObj) {
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
	public String update(BigdataBeidouSpeedAlarmDayCheck voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataBeidouSpeedAlarmDayCheck voObj) {
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
	public BigdataBeidouSpeedAlarmDayCheck loadById(String id) {
		return mapper.selectById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(BigdataBeidouSpeedAlarmDayCheck bigdataBeidouSpeedAlarmDayCheck) {
		BigdataBeidouSpeedAlarmDayCheck bigdataBeidouSpeedAlarmDayCheck1 = mapper.selectByVo(bigdataBeidouSpeedAlarmDayCheck);
		if(bigdataBeidouSpeedAlarmDayCheck1==null){
			bigdataBeidouSpeedAlarmDayCheck.setCreateTime(new Date());
			bigdataBeidouSpeedAlarmDayCheck.setUpdateTime(new Date());
			insert(bigdataBeidouSpeedAlarmDayCheck);
		}else {
			bigdataBeidouSpeedAlarmDayCheck.setUpdateTime(new Date());
			updateNew(bigdataBeidouSpeedAlarmDayCheck);
		}
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateNew(BigdataBeidouSpeedAlarmDayCheck bigdataBeidouSpeedAlarmDayCheck) {
		mapper.updateNew(bigdataBeidouSpeedAlarmDayCheck);
	}

	public int countSpeedAlarm(Map<String, Object> param8) {
		return mapper.countSpeedAlarm(param8);
	}
}
