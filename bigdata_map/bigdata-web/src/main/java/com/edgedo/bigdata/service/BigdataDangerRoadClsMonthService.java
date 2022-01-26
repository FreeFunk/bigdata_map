package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataDangerRoadClsMonth;
import com.edgedo.bigdata.mapper.BigdataDangerRoadClsMonthMapper;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadClsMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadClsMonthView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataDangerRoadClsMonthService {
	
	
	@Autowired
	private BigdataDangerRoadClsMonthMapper mapper;

	
	public List<BigdataDangerRoadClsMonthView> listPage(BigdataDangerRoadClsMonthQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDangerRoadClsMonth voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDangerRoadClsMonth voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDangerRoadClsMonth voObj) {
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
	public BigdataDangerRoadClsMonth loadById(String id) {
		return mapper.selectById(id);
	}
	

}
