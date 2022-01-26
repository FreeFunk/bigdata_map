package com.edgedo.drawing.service;

import com.edgedo.drawing.entity.BigdataDriverCarPartitionCountDay;
import com.edgedo.drawing.mapper.BigdataDriverCarPartitionCountDayMapper;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigdataDriverCarPartitionCountDayService {
	
	
	@Autowired
	private BigdataDriverCarPartitionCountDayMapper mapper;

	
	public List<BigdataDriverCarPartitionCountDayView> listPage(BigdataDriverCarPartitionCountDayQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverCarPartitionCountDay voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverCarPartitionCountDay voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverCarPartitionCountDay voObj) {
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
	public BigdataDriverCarPartitionCountDay loadById(String id) {
		return mapper.selectById(id);
	}
	

}
