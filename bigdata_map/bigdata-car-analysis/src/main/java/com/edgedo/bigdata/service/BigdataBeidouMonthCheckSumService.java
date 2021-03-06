package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataBeidouMonthCheckSum;
import com.edgedo.bigdata.mapper.BigdataBeidouMonthCheckSumMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouMonthCheckSumQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouMonthCheckSumView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
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
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
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
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataBeidouMonthCheckSum voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataBeidouMonthCheckSum voObj) {
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
	public BigdataBeidouMonthCheckSum loadById(String id) {
		return mapper.selectById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(BigdataBeidouMonthCheckSum bigdataBeidouMonthCheckSum) {

		BigdataBeidouMonthCheckSum bigdataBeidouMonthCheckSum1 = mapper.selectByVo(bigdataBeidouMonthCheckSum);
		if(bigdataBeidouMonthCheckSum1==null){
			bigdataBeidouMonthCheckSum.setCreateTime(new Date());
			bigdataBeidouMonthCheckSum.setUpdateTime(new Date());
			insert(bigdataBeidouMonthCheckSum);
		}else {
			bigdataBeidouMonthCheckSum.setUpdateTime(new Date());
			updateNew(bigdataBeidouMonthCheckSum);
		}
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateNew(BigdataBeidouMonthCheckSum bigdataBeidouMonthCheckSum) {
		mapper.updateNew(bigdataBeidouMonthCheckSum);
	}
}
