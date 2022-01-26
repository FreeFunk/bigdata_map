package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataBeidouTeamInfo;
import com.edgedo.bigdata.mapper.BigdataBeidouTeamInfoMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouTeamInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouTeamInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
	public String update(BigdataBeidouTeamInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataBeidouTeamInfo voObj) {
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
	public BigdataBeidouTeamInfo loadById(String id) {
		return mapper.selectById(id);
	}
	

}
