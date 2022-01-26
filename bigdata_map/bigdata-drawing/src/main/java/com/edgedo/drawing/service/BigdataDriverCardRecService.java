package com.edgedo.drawing.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.drawing.entity.BigdataDriverCardRec;
import com.edgedo.drawing.mapper.BigdataDriverCardRecMapper;
import com.edgedo.drawing.queryvo.BigdataDriverCardRecQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCardRecView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataDriverCardRecService {
	
	
	@Autowired
	private BigdataDriverCardRecMapper mapper;

	
	public List<BigdataDriverCardRecView> listPage(BigdataDriverCardRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverCardRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverCardRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverCardRec voObj) {
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
	public BigdataDriverCardRec loadById(String id) {
		return mapper.selectById(id);
	}
	

}
