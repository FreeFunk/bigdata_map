package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataBeidouTeamInfo;
import com.edgedo.bigdata.mapper.BigdataBeidouTeamInfoMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouTeamInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouTeamInfoView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataBeidouTeamInfoService {
	
	
	@Autowired
	private BigdataBeidouTeamInfoMapper mapper;

	
	public List<BigdataBeidouTeamInfoView> listPage(BigdataBeidouTeamInfoQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataBeidouTeamInfo voObj) {
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
	public String update(BigdataBeidouTeamInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataBeidouTeamInfo voObj) {
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
	public BigdataBeidouTeamInfo loadById(String id) {
		return mapper.selectById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(BigdataBeidouTeamInfo bigdataBeidouTeamInfo) {
		BigdataBeidouTeamInfo bigdataBeidouTeamInfo1 = loadById(bigdataBeidouTeamInfo.getId());
		if(bigdataBeidouTeamInfo1==null){
			bigdataBeidouTeamInfo.setCreateTime(new Date());
			bigdataBeidouTeamInfo.setUpdateTime(new Date());
			mapper.insert(bigdataBeidouTeamInfo);
		}else {
			bigdataBeidouTeamInfo.setUpdateTime(new Date());
			update(bigdataBeidouTeamInfo);
		}
	}
}
