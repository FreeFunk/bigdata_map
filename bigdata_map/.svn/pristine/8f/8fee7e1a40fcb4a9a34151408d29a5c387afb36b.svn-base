package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataBeidouCarTraceBkRec;
import com.edgedo.bigdata.mapper.BigdataBeidouCarTraceBkRecMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarTraceBkRecQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarTraceBkRecView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataBeidouCarTraceBkRecService {
	
	
	@Autowired
	private BigdataBeidouCarTraceBkRecMapper mapper;

	
	public List<BigdataBeidouCarTraceBkRecView> listPage(BigdataBeidouCarTraceBkRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataBeidouCarTraceBkRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataBeidouCarTraceBkRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataBeidouCarTraceBkRec voObj) {
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
	public BigdataBeidouCarTraceBkRec loadById(String id) {
		return mapper.selectById(id);
	}
	

}
