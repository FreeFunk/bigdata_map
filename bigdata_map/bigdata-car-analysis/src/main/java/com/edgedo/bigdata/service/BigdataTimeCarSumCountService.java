package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataTimeCarSumCount;
import com.edgedo.bigdata.mapper.BigdataTimeCarSumCountMapper;
import com.edgedo.bigdata.queryvo.BigdataTimeCarSumCountQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeCarSumCountView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataTimeCarSumCountService {
	
	
	@Autowired
	private BigdataTimeCarSumCountMapper mapper;

	
	public List<BigdataTimeCarSumCountView> listPage(BigdataTimeCarSumCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataTimeCarSumCount voObj) {
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
	public String update(BigdataTimeCarSumCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataTimeCarSumCount voObj) {
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
	public BigdataTimeCarSumCount loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 新增或者修改统计信息
	 * @param timeCarSumCount
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insertOrUpdate(BigdataTimeCarSumCount timeCarSumCount) {
		String id = timeCarSumCount.getId();
		BigdataTimeCarSumCount count = loadById(id);
		if(count==null){
			//新增
			insert(timeCarSumCount);
		}else{
			//修改
			timeCarSumCount.setCountTime(null);
			timeCarSumCount.setCreateTime(null);
			update(timeCarSumCount);
		}

    }


	/**
	 * 统计年度情况
	 * @param countYear
	 * @return
	 */
	public List<BigdataTimeCarSumCount> selectSumGroupCarInfoYear(int countYear) {
		return mapper.selectSumGroupCarInfoYear(countYear);
	}


}
