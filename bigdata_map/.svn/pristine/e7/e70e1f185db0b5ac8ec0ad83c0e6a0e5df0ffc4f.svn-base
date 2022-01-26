package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataSafetyWarningFile;
import com.edgedo.bigdata.mapper.BigdataSafetyWarningFileMapper;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningFileQuery;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningFileView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataSafetyWarningFileService {
	
	
	@Autowired
	private BigdataSafetyWarningFileMapper mapper;

	
	public List<BigdataSafetyWarningFileView> listPage(BigdataSafetyWarningFileQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataSafetyWarningFile voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataSafetyWarningFile voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataSafetyWarningFile voObj) {
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
	public BigdataSafetyWarningFile loadById(String id) {
		return mapper.selectById(id);
	}

	public List<BigdataSafetyWarningFile> selectByWarningInfoId(BigdataSafetyWarningFileQuery query){
		List list = mapper.selectByWarningInfo(query);
		query.setList(list);
		return list;
	}
}
