package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.SysMonitorAlarm;
import com.edgedo.bigdata.mapper.SysMonitorAlarmMapper;
import com.edgedo.bigdata.queryvo.SysMonitorAlarmQuery;
import com.edgedo.bigdata.queryvo.SysMonitorAlarmView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMonitorAlarmService {
	
	
	@Autowired
	private SysMonitorAlarmMapper mapper;

	
	public List<SysMonitorAlarmView> listPage(SysMonitorAlarmQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysMonitorAlarm voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysMonitorAlarm voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysMonitorAlarm voObj) {
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
	public SysMonitorAlarm loadById(String id) {
		return mapper.selectById(id);
	}
	

}
