package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataAlarmInfoVo;
import com.edgedo.bigdata.entity.BigdataTeamAnalysisInfo;
import com.edgedo.bigdata.mapper.BigdataTeamAnalysisInfoMapper;
import com.edgedo.bigdata.queryvo.BigdataTeamAnalysisInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataTeamAnalysisInfoView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataTeamAnalysisInfoService {
	
	
	@Autowired
	private BigdataTeamAnalysisInfoMapper mapper;

	
	public List<BigdataTeamAnalysisInfoView> listPage(BigdataTeamAnalysisInfoQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataTeamAnalysisInfo voObj) {
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
	public String update(BigdataTeamAnalysisInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataTeamAnalysisInfo voObj) {
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
	public BigdataTeamAnalysisInfo loadById(String id) {
		return mapper.selectById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insertOrUpdate(BigdataTeamAnalysisInfo bigdataTeamAnalysisInfo) {
		BigdataTeamAnalysisInfo bigdataTeamAnalysisInfo1 = mapper.selectByVo(bigdataTeamAnalysisInfo);
		if(bigdataTeamAnalysisInfo1==null){
			bigdataTeamAnalysisInfo.setCreateTime(new Date());
			bigdataTeamAnalysisInfo.setUpdateTime(new Date());
			insert(bigdataTeamAnalysisInfo);
		}else {
			bigdataTeamAnalysisInfo.setId(bigdataTeamAnalysisInfo1.getId());
			bigdataTeamAnalysisInfo.setUpdateTime(new Date());
			update(bigdataTeamAnalysisInfo);
		}
	}

	public void insertAlarmInfoVo(List<BigdataAlarmInfoVo> alarmInfoVoList) {
		mapper.insertAlarmInfoVo(alarmInfoVoList);
	}
}
