package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.CityTransportCapacityAnalysisInfo;
import com.edgedo.bigdata.mapper.CityTransportCapacityAnalysisInfoMapper;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisInfoQuery;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisInfoView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class CityTransportCapacityAnalysisInfoService {
	
	
	@Autowired
	private CityTransportCapacityAnalysisInfoMapper mapper;

	
	public List<CityTransportCapacityAnalysisInfoView> listPage(CityTransportCapacityAnalysisInfoQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(CityTransportCapacityAnalysisInfo voObj) {
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
	public String update(CityTransportCapacityAnalysisInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(CityTransportCapacityAnalysisInfo voObj) {
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
	public CityTransportCapacityAnalysisInfo loadById(String id) {
		return mapper.selectById(id);
	}


	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(CityTransportCapacityAnalysisInfo cityTransportCapacityAnalysisInfo) {
		CityTransportCapacityAnalysisInfo cityTransportCapacityAnalysisInfo1 = mapper.selectByVo(cityTransportCapacityAnalysisInfo);
		if(cityTransportCapacityAnalysisInfo1==null){
			cityTransportCapacityAnalysisInfo.setCreateTime(new Date());
			cityTransportCapacityAnalysisInfo.setUpdateTime(new Date());
			insert(cityTransportCapacityAnalysisInfo);
		}else {
			cityTransportCapacityAnalysisInfo.setId(cityTransportCapacityAnalysisInfo1.getId());
			cityTransportCapacityAnalysisInfo.setUpdateTime(new Date());
			update(cityTransportCapacityAnalysisInfo);
		}
	}
}
