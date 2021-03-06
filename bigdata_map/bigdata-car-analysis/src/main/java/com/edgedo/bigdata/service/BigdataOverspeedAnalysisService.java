package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataOverspeedAnalysis;
import com.edgedo.bigdata.mapper.BigdataOverspeedAnalysisMapper;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisView;
import com.edgedo.common.util.Guid;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataOverspeedAnalysisService {
	
	
	@Autowired
	private BigdataOverspeedAnalysisMapper mapper;

	private SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");

	
	public List<BigdataOverspeedAnalysisView> listPage(BigdataOverspeedAnalysisQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataOverspeedAnalysis voObj) {
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
	public String update(BigdataOverspeedAnalysis voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataOverspeedAnalysis voObj) {
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
	public BigdataOverspeedAnalysis loadById(String id) {
		return mapper.selectById(id);
	}


	//首页获取超速分析的数据
	public BigdataOverspeedAnalysisView getOverspeedAnalysisData(BigdataOverspeedAnalysisQuery query) {
		return mapper.getOverspeedAnalysisData(query);
	}

	public BigdataOverspeedAnalysisView getVoByQuery(BigdataOverspeedAnalysis bigdataOverspeedAnalysis) {
		return mapper.getVoByQuery(bigdataOverspeedAnalysis);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void addOrUpdate(BigdataOverspeedAnalysis bigdataOverspeedAnalysis) {
		//查看当天的记录是否存在
		BigdataOverspeedAnalysisView  bigdataOverspeedAnalysisView = mapper.getVoByQuery(bigdataOverspeedAnalysis);
		//查询上一天的记录
		BigdataOverspeedAnalysis bigdataOverspeedAnalysis1 = new BigdataOverspeedAnalysis();
		Date lastDayDate= DateUtil.getLastDayDate(bigdataOverspeedAnalysis.getCountTime());
		bigdataOverspeedAnalysis1.setCountTime(lastDayDate);
		bigdataOverspeedAnalysis1.setCarType(bigdataOverspeedAnalysis.getCarType());
		BigdataOverspeedAnalysisView  bigdataOverspeedAnalysisViewLast = mapper.getVoByQuery(bigdataOverspeedAnalysis1);
		//和前一天对比得出箭头的标识
		if(bigdataOverspeedAnalysisViewLast==null){
			bigdataOverspeedAnalysis.setNationaloverspeedflAg("1");
			bigdataOverspeedAnalysis.setHighoverspeedflAg("1");
			bigdataOverspeedAnalysis.setOtheroverspeedflAg("1");
			bigdataOverspeedAnalysis.setSeriousoverspeedflAg("1");
		}else {
			if(bigdataOverspeedAnalysis.getNationalOverspeedRate()!=null){
				if(bigdataOverspeedAnalysis.getNationalOverspeedRate().compareTo(bigdataOverspeedAnalysisViewLast.getNationalOverspeedRate())>=0){
					bigdataOverspeedAnalysis.setNationaloverspeedflAg("1");
				}else {
					bigdataOverspeedAnalysis.setNationaloverspeedflAg("0");
				}
			}
			if(bigdataOverspeedAnalysis.getHighOverspeedRate()!=null){
				if(bigdataOverspeedAnalysis.getHighOverspeedRate().compareTo(bigdataOverspeedAnalysisViewLast.getHighOverspeedRate())>=0){
					bigdataOverspeedAnalysis.setHighoverspeedflAg("1");
				}else {
					bigdataOverspeedAnalysis.setHighoverspeedflAg("0");
				}
			}
			if(bigdataOverspeedAnalysis.getOtherOverspeedRate()!=null){
				if(bigdataOverspeedAnalysis.getOtherOverspeedRate().compareTo(bigdataOverspeedAnalysisViewLast.getOtherOverspeedRate())>=0){
					bigdataOverspeedAnalysis.setOtheroverspeedflAg("1");
				}else {
					bigdataOverspeedAnalysis.setOtheroverspeedflAg("0");
				}
			}
			if(bigdataOverspeedAnalysis.getSeriousOverspeedRate()!=null){
				if(bigdataOverspeedAnalysis.getSeriousOverspeedRate().compareTo(bigdataOverspeedAnalysisViewLast.getSeriousOverspeedRate())>=0){
					bigdataOverspeedAnalysis.setSeriousoverspeedflAg("1");
				}else {
					bigdataOverspeedAnalysis.setSeriousoverspeedflAg("0");
				}
			}
		}
		Date countTime = bigdataOverspeedAnalysis.getCountTime();
		String dateStr = sdfDateInt.format(countTime);
		String monthStr = dateStr.substring(0,6);
		int dateInt = new Integer(dateStr);
		int monthInt = new Integer(monthStr);
		bigdataOverspeedAnalysis.setCountDate(dateInt);
		bigdataOverspeedAnalysis.setCountMonth(monthInt);
		if(bigdataOverspeedAnalysisView == null){
			bigdataOverspeedAnalysis.setCreateTime(new Date());
			insert(bigdataOverspeedAnalysis);
		}else {
			bigdataOverspeedAnalysis.setId(bigdataOverspeedAnalysisView.getId());
			update(bigdataOverspeedAnalysis);
		}
	}

	public List<BigdataOverspeedAnalysis> selectSumGroupByCarTypeMonth(int month) {

		return mapper.selectSumGroupByCarTypeMonth(month);
	}

}
