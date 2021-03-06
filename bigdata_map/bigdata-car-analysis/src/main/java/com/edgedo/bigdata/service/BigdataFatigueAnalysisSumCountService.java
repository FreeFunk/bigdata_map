package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataFatigueAnalysisSumCount;
import com.edgedo.bigdata.mapper.BigdataFatigueAnalysisSumCountMapper;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisSumCountQuery;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisSumCountView;
import com.edgedo.common.util.Guid;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataFatigueAnalysisSumCountService {
	
	
	@Autowired
	private BigdataFatigueAnalysisSumCountMapper mapper;

	
	public List<BigdataFatigueAnalysisSumCountView> listPage(BigdataFatigueAnalysisSumCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFatigueAnalysisSumCount voObj) {
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
	public String update(BigdataFatigueAnalysisSumCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFatigueAnalysisSumCount voObj) {
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
	public BigdataFatigueAnalysisSumCount loadById(String id) {
		return mapper.selectById(id);
	}

	//新增或者修改汇总统计
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void addOrUpdate(BigdataFatigueAnalysisSumCount sumCount) {
		String id = sumCount.getId();
		BigdataFatigueAnalysisSumCount oraCount = loadById(id);
		if(oraCount==null){
			insert(sumCount);
		}else{
			sumCount.setCreateTime(null);
			sumCount.setCountTime(null);
			update(sumCount);
		}
    }

	/**
	 * 分组统计年度的信息
	 * @param countYear
	 * @return
	 */
	public List<BigdataFatigueAnalysisSumCount> selectGroupYearSumCount(int countYear) {
		return mapper.selectGroupYearSumCount(countYear);
	}

}
