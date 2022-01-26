package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataSafetyWarning;
import com.edgedo.bigdata.mapper.BigdataSafetyWarningMapper;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningQuery;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataSafetyWarningService {
	
	
	@Autowired
	private BigdataSafetyWarningMapper mapper;

	
	public List<BigdataSafetyWarningView> listPage(BigdataSafetyWarningQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	public List<BigdataSafetyWarningView> qtlistpage(BigdataSafetyWarningQuery query){
		List list = mapper.qtlistPage(query);
		query.setList(list);
		return list;
	}
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataSafetyWarning voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataSafetyWarning voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataSafetyWarning voObj) {
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
	public BigdataSafetyWarning loadById(String id) {
		return mapper.selectById(id);
	}


	public int safetyWarningCount(BigdataSafetyWarningQuery query) {
		return mapper.safetyWarningCount(query);
	}

	public List<BigdataSafetyWarningView> selectSafetyWarningByCar(BigdataAlarmRecordQuery query) {
		return mapper.selectSafetyWarningByCar(query);
	}
}
