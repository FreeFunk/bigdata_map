package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataTimeAnalysis;
import com.edgedo.bigdata.mapper.BigdataTimeAnalysisMapper;
import com.edgedo.bigdata.queryvo.BigdataTimeAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeAnalysisView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataTimeAnalysisService {
	
	
	@Autowired
	private BigdataTimeAnalysisMapper mapper;

	
	public List<BigdataTimeAnalysisView> listPage(BigdataTimeAnalysisQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataTimeAnalysis voObj) {
		String id = voObj.getId();
		if(id==null ||id.length()==0 ){
			voObj.setId(Guid.guid());
		}
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataTimeAnalysis voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataTimeAnalysis voObj) {
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
	public BigdataTimeAnalysis loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataTimeAnalysisView getTimeAnalysisData(BigdataTimeAnalysisQuery query) {
		return mapper.getTimeAnalysisData(query);
	}

	//更新每日的时段统计
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void updateSynTimeAnalysis(BigdataTimeAnalysisView bigdataTimeAnalysis) {
		String id  = bigdataTimeAnalysis.getId();
		BigdataTimeAnalysis analysis =  loadById(id);
		if(analysis==null){
			//新增
			bigdataTimeAnalysis.setCreateTime(new Date());
			insert(bigdataTimeAnalysis);
		}else{
			//更新
			update(bigdataTimeAnalysis);
		}
    }
}
