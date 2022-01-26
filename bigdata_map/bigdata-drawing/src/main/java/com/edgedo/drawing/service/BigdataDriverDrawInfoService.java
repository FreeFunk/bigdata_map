package com.edgedo.drawing.service;

import com.edgedo.drawing.entity.BigdataDriverDrawInfo;
import com.edgedo.drawing.mapper.BigdataDriverDrawInfoMapper;
import com.edgedo.drawing.queryvo.BigdataDriverDrawInfoQuery;
import com.edgedo.drawing.queryvo.BigdataDriverDrawInfoView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigdataDriverDrawInfoService {
	
	
	@Autowired
	private BigdataDriverDrawInfoMapper mapper;

	
	public List<BigdataDriverDrawInfoView> listPage(BigdataDriverDrawInfoQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverDrawInfo voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverDrawInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverDrawInfo voObj) {
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
	public BigdataDriverDrawInfo loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataDriverDrawInfo loadByDriverIdAndYear(BigdataDriverDrawInfo driverDrawInfo) {
		return mapper.loadByDriverIdAndYear(driverDrawInfo);
	}
}
