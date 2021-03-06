package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataBeidouComp;
import com.edgedo.bigdata.mapper.BigdataBeidouCompMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataBeidouCompService {
	
	
	@Autowired
	private BigdataBeidouCompMapper mapper;

	
	public List<BigdataBeidouCompView> listPage(BigdataBeidouCompQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataBeidouComp voObj) {
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
	public String update(BigdataBeidouComp voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataBeidouComp voObj) {
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
	public BigdataBeidouComp loadById(String id) {
		return mapper.selectById(id);
	}

	//查询所有
	public List<BigdataBeidouCompView> listAll() {
		return mapper.listAll();
	}

	//根据809ip地址查询运营商信息
    public BigdataBeidouCompView selectByIp809Addr(String ip809Addr) {
		return mapper.selectByIp809Addr(ip809Addr);
    }

}
