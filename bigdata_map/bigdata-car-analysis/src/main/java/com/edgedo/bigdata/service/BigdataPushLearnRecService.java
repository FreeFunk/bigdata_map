package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataBeidouCompMonthCheck;
import com.edgedo.bigdata.entity.BigdataPushLearnRec;
import com.edgedo.bigdata.entity.YwTrainLession;
import com.edgedo.bigdata.mapper.BigdataPushLearnRecMapper;
import com.edgedo.bigdata.queryvo.BigdataPushLearnRecQuery;
import com.edgedo.bigdata.queryvo.BigdataPushLearnRecView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BigdataPushLearnRecService {
	
	
	@Autowired
	private BigdataPushLearnRecMapper mapper;

	
	public List<BigdataPushLearnRecView> listPage(BigdataPushLearnRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataPushLearnRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataPushLearnRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataPushLearnRec voObj) {
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
	public BigdataPushLearnRec loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataPushLearnRec> selectByEmpId(BigdataPushLearnRec voObj) {
		return mapper.selectByEmpId(voObj);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int countSafetyRec(String empCode,int countMonth) {
		Map<String,Object> map = new HashMap<>();
		map.put("empCode",empCode);
		map.put("countMonth",countMonth);
		return mapper.countSafetyRec(map);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public YwTrainLession getLessionByClsId(String clsId) {
		List<YwTrainLession> ywTrainLessionList = mapper.getLessionByClsId(clsId);
		Random random= new Random();// 定义随机类
		int result = random.nextInt(5);
		YwTrainLession ywTrainLession = ywTrainLessionList.get(result);
		return ywTrainLession;
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(BigdataPushLearnRec bigdataPushLearnRec) {
		BigdataPushLearnRec bigdataPushLearnRec1 = mapper.selectByVo(bigdataPushLearnRec);
		if(bigdataPushLearnRec1==null){
			bigdataPushLearnRec.setCreateTime(new Date());
			insert(bigdataPushLearnRec);
		}else {
			bigdataPushLearnRec.setId(bigdataPushLearnRec1.getId());
			bigdataPushLearnRec.setUpdateTime(new Date());
			updateNew(bigdataPushLearnRec);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateNew(BigdataPushLearnRec bigdataPushLearnRec) {
		mapper.updateNew(bigdataPushLearnRec);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<BigdataPushLearnRec> selectUnLearnRec(int yearNum) {
		return mapper.selectUnLearnRec(yearNum);
	}
}
