package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataBeidouCarMonthCheck;
import com.edgedo.bigdata.mapper.BigdataBeidouCarMonthCheckMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarMonthCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarMonthCheckView;
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
public class BigdataBeidouCarMonthCheckService {
	
	
	@Autowired
	private BigdataBeidouCarMonthCheckMapper mapper;

	
	public List<BigdataBeidouCarMonthCheckView> listPage(BigdataBeidouCarMonthCheckQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataBeidouCarMonthCheck voObj) {
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
	public String update(BigdataBeidouCarMonthCheck voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataBeidouCarMonthCheck voObj) {
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
	public BigdataBeidouCarMonthCheck loadById(String id) {
		return mapper.selectById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insertOrUpdate(BigdataBeidouCarMonthCheck bigdataBeidouCarMonthCheck) {
		BigdataBeidouCarMonthCheck bigdataBeidouCarMonthCheck1 = mapper.selectByVo(bigdataBeidouCarMonthCheck);
		if(bigdataBeidouCarMonthCheck1==null){
			bigdataBeidouCarMonthCheck.setCreateTime(new Date());
			bigdataBeidouCarMonthCheck.setUpdateTime(new Date());
			insert(bigdataBeidouCarMonthCheck);
		}else {
			bigdataBeidouCarMonthCheck.setUpdateTime(new Date());
			updateNew(bigdataBeidouCarMonthCheck);
		}
    }

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateNew(BigdataBeidouCarMonthCheck bigdataBeidouCarMonthCheck1) {
		mapper.updateNew(bigdataBeidouCarMonthCheck1);
	}


	public int countOnlineByCompId(Map<String, Object> param) {
		return mapper.countOnlineByCompId(param);
	}

	public int countTraceUncompleteNumByCompId(Map<String, Object> param1) {
		return mapper.countTraceUncompleteNumByCompId(param1);
	}

	public int countTraceFlayCarNumByCompId(Map<String, Object> param2) {
		return mapper.countTraceFlayCarNumByCompId(param2);
	}

	public int countGpsUploadTimeQualifiedNumByCompId(Map<String, Object> param3) {
		return mapper.countGpsUploadTimeQualifiedNumByCompId(param3);
	}

	public int countDriverCardUpNumByCompId(Map<String, Object> param5) {
		return mapper.countDriverCardUpNumByCompId(param5);
	}
}
