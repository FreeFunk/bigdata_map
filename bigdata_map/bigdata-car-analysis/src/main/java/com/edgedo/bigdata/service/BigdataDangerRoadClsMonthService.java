package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataDangerRoadClsMonth;
import com.edgedo.bigdata.mapper.BigdataDangerRoadClsMonthMapper;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadClsMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadClsMonthView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
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
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataDangerRoadClsMonth voObj) {
		String id = voObj.getId();
		if(id==null || id.length()==0){
			voObj.setId(Guid.guid());
		}
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataDangerRoadClsMonth voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataDangerRoadClsMonth voObj) {
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
	public BigdataDangerRoadClsMonth loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 汇总月度的危险路段数出来总数
	 * @return
	 */
	public List<BigdataDangerRoadClsMonth> selectGroupByDangerRoadName() {
		return mapper.selectGroupByDangerRoadName();
	}

}
