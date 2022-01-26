package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataDriverChangeTeamRec;
import com.edgedo.bigdata.mapper.BigdataDriverChangeTeamRecMapper;
import com.edgedo.bigdata.queryvo.BigdataDriverChangeTeamRecQuery;
import com.edgedo.bigdata.queryvo.BigdataDriverChangeTeamRecView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataDriverChangeTeamRecService {
	
	
	@Autowired
	private BigdataDriverChangeTeamRecMapper mapper;

	
	public List<BigdataDriverChangeTeamRecView> listPage(BigdataDriverChangeTeamRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverChangeTeamRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverChangeTeamRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverChangeTeamRec voObj) {
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
	public BigdataDriverChangeTeamRec loadById(String id) {
		return mapper.selectById(id);
	}
	

}
