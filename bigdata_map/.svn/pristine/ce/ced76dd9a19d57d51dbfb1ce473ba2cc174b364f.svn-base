package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataBeidouCheckScoreRec;
import com.edgedo.bigdata.mapper.BigdataBeidouCheckScoreRecMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouCheckScoreRecQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCheckScoreRecView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataBeidouCheckScoreRecService {
	
	
	@Autowired
	private BigdataBeidouCheckScoreRecMapper mapper;

	
	public List<BigdataBeidouCheckScoreRecView> listPage(BigdataBeidouCheckScoreRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataBeidouCheckScoreRec voObj) {
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
	public String update(BigdataBeidouCheckScoreRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataBeidouCheckScoreRec voObj) {
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
	public BigdataBeidouCheckScoreRec loadById(String id) {
		return mapper.selectById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(BigdataBeidouCheckScoreRec bigdataBeidouCheckScoreRec) {
		BigdataBeidouCheckScoreRec bigdataBeidouCheckScoreRec1 = mapper.selectByVo(bigdataBeidouCheckScoreRec);
		if(bigdataBeidouCheckScoreRec1==null){
			bigdataBeidouCheckScoreRec.setCreateTime(new Date());
			bigdataBeidouCheckScoreRec.setUpdateTime(new Date());
			insert(bigdataBeidouCheckScoreRec);
		}else {
			bigdataBeidouCheckScoreRec.setUpdateTime(new Date());
			updateNew(bigdataBeidouCheckScoreRec);
		}
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateNew(BigdataBeidouCheckScoreRec bigdataBeidouCheckScoreRec) {
		mapper.updateNew(bigdataBeidouCheckScoreRec);
	}

	public BigDecimal countCompScore(Map<String, Object> map) {
		return mapper.countCompScore(map);
	}
}
