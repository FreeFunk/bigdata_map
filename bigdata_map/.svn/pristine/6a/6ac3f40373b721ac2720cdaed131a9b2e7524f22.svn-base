package com.edgedo.drawing.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.drawing.entity.BigdataDriverCountDay;
import com.edgedo.drawing.mapper.BigdataDriverCountDayMapper;
import com.edgedo.drawing.queryvo.BigdataDriverCountDayQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCountDayView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataDriverCountDayService {
	
	
	@Autowired
	private BigdataDriverCountDayMapper mapper;

	
	public List<BigdataDriverCountDayView> listPage(BigdataDriverCountDayQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverCountDay voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverCountDay voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverCountDay voObj) {
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
	public BigdataDriverCountDay loadById(String id) {
		return mapper.selectById(id);
	}
	

}
