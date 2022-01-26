package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataBeidouMonthCheckSum;
import com.edgedo.bigdata.mapper.BigdataBeidouMonthCheckSumMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouMonthCheckSumQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouMonthCheckSumView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataBeidouMonthCheckSumService {
	
	
	@Autowired
	private BigdataBeidouMonthCheckSumMapper mapper;

	
	public List<BigdataBeidouMonthCheckSumView> listPage(BigdataBeidouMonthCheckSumQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataBeidouMonthCheckSum voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataBeidouMonthCheckSum voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataBeidouMonthCheckSum voObj) {
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
	public BigdataBeidouMonthCheckSum loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataBeidouMonthCheckSum getBeidouMonthCheckSum(BigdataBeidouMonthCheckSumQuery query) {
		return mapper.getBeidouMonthCheckSum(query);
	}
}
