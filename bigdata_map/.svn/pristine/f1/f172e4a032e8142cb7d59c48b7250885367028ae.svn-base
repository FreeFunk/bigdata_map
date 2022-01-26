package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataBeidouDataInfo;
import com.edgedo.bigdata.mapper.BigdataBeidouDataInfoMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouDataInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouDataInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataBeidouDataInfoService {
	
	
	@Autowired
	private BigdataBeidouDataInfoMapper mapper;

	
	public List<BigdataBeidouDataInfoView> listPage(BigdataBeidouDataInfoQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataBeidouDataInfo voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataBeidouDataInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataBeidouDataInfo voObj) {
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
	public BigdataBeidouDataInfo loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataBeidouDataInfoView>  listpageForBeidouDataInfo(BigdataBeidouDataInfoQuery query) {
		List list = mapper.listpageForBeidouDataInfo(query);
		query.setList(list);
		return list;
	}
}
