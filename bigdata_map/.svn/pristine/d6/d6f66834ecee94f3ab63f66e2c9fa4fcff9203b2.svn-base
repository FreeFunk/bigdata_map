package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataBeidouCompMonthCheck;
import com.edgedo.bigdata.mapper.BigdataBeidouCompMonthCheckMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompMonthCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompMonthCheckView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataBeidouCompMonthCheckService {
	
	
	@Autowired
	private BigdataBeidouCompMonthCheckMapper mapper;

	
	public List<BigdataBeidouCompMonthCheckView> listPage(BigdataBeidouCompMonthCheckQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataBeidouCompMonthCheck voObj) {
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
	public String update(BigdataBeidouCompMonthCheck voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataBeidouCompMonthCheck voObj) {
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
	public BigdataBeidouCompMonthCheck loadById(String id) {
		return mapper.selectById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(BigdataBeidouCompMonthCheck bigdataBeidouCompMonthCheck) {
		BigdataBeidouCompMonthCheck bigdataBeidouCompMonthCheck1 = mapper.selectByVo(bigdataBeidouCompMonthCheck);
		if(bigdataBeidouCompMonthCheck1==null){
			bigdataBeidouCompMonthCheck.setCreateTime(new Date());
			bigdataBeidouCompMonthCheck.setUpdateTime(new Date());
			insert(bigdataBeidouCompMonthCheck);
		}else {
			bigdataBeidouCompMonthCheck.setUpdateTime(new Date());
			updateNew(bigdataBeidouCompMonthCheck);
		}
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateNew(BigdataBeidouCompMonthCheck voObj) {
		mapper.updateNew(voObj);
		return "";
	}

	public List<BigdataBeidouCompMonthCheckView> listBySearchDate(Map<String, Object> map) {
		return mapper.listBySearchDate(map);
	}


}
