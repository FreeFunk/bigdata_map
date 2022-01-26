package com.edgedo.bigdata.service;
		
import java.util.*;

import com.edgedo.bigdata.entity.YwTrainConsumRec;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataPushLearnRec;
import com.edgedo.bigdata.mapper.BigdataPushLearnRecMapper;
import com.edgedo.bigdata.queryvo.BigdataPushLearnRecQuery;
import com.edgedo.bigdata.queryvo.BigdataPushLearnRecView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


	public LinkedHashMap<String,List<BigdataPushLearnRec>> selectByEmpId(BigdataPushLearnRec voObj) {
		List<BigdataPushLearnRec> bigdataPushLearnRecList = mapper.selectByEmpId(voObj);
		LinkedHashMap<String,List<BigdataPushLearnRec>> map = new LinkedHashMap<>();
		for(BigdataPushLearnRec b:bigdataPushLearnRecList){
			String countMonth = "d"+b.getCountMonth();
			List<BigdataPushLearnRec> learnRecList = map.get(countMonth);
			if(learnRecList==null){
				learnRecList = new ArrayList<>();
				learnRecList.add(b);
			}else {
				learnRecList.add(b);
			}
			map.put(countMonth,learnRecList);
		}
		return map;
	}

	public List<YwTrainConsumRec> selectSafetyRec(String empId) {
		String stuId = mapper.loadByEmpId(empId);
		return mapper.selectSafetyRec(stuId);
	}
}
