package com.edgedo.bigdata.service;
		
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.bigdata.entity.BigdataConfigLine;
import com.edgedo.bigdata.entity.OverspeedEchartsVo;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataOverspeedAnalysis;
import com.edgedo.bigdata.mapper.BigdataOverspeedAnalysisMapper;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisView;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataOverspeedAnalysisService {
	
	
	@Autowired
	private BigdataOverspeedAnalysisMapper mapper;

	@Autowired
	private BigdataConfigLineService bigdataConfigLineService;
	
	public List<BigdataOverspeedAnalysisView> listPage(BigdataOverspeedAnalysisQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
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
	public String update(BigdataOverspeedAnalysis voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataOverspeedAnalysis voObj) {
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
	public BigdataOverspeedAnalysis loadById(String id) {
		return mapper.selectById(id);
	}


	//首页获取超速分析的数据
	public BigdataOverspeedAnalysisView getOverspeedAnalysisData(BigdataOverspeedAnalysisQuery query) {
		return mapper.getOverspeedAnalysisData(query);
	}
	//获取数据组装柱状图对象
	public OverspeedEchartsVo getOverspeedEchartsData(BigdataOverspeedAnalysisQuery query) {
		//日期的集合
		List<String> dateList = new ArrayList<>();
		//国道超速次数集合
		List<Integer> nationalOverspeedNumList = new ArrayList<>();
		//国道严重超速次数集合
		List<Integer> nationalSeriousOverspeedNumList = new ArrayList<>();
		//国道危险时段超速次数
		List<Integer> nationalNightOverspeedNumList = new ArrayList<>();
		//高速超速次数集合
		List<Integer> highOverspeedNumList = new ArrayList<>();
		//高速严重超速次数集合
		List<Integer> highSeriousOverspeedNumList = new ArrayList<>();
		//高速危险时段超速次数
		List<Integer> highNightOverspeedNumList =new ArrayList<>();

		//获取日期的集合
		Date countTime = query.getQueryObj().getCountTime();
		dateList = DateUtil.getDateList(countTime,query.getLimit());
		//开始日期
		Date startDate = DateUtil.getLastDate(countTime,query.getLimit());
		List<BigdataOverspeedAnalysisView> bigdataOverspeedAnalysisViewList = new ArrayList<>();
		for(int i =0 ;i<=Math.abs(query.getLimit());i++){
			query.getQueryObj().setCountTime(startDate);
			BigdataOverspeedAnalysisView bigdataOverspeedAnalysisView = mapper.getOverspeedAnalysisData(query);
			bigdataOverspeedAnalysisViewList.add(bigdataOverspeedAnalysisView);
			startDate = DateUtil.getNextDayDate(startDate);
		}
		for(BigdataOverspeedAnalysisView b:bigdataOverspeedAnalysisViewList){
			if(b==null){
				nationalOverspeedNumList.add(0);
				nationalSeriousOverspeedNumList.add(0);
				nationalNightOverspeedNumList.add(0);
				highOverspeedNumList.add(0);
				highSeriousOverspeedNumList.add(0);
				highNightOverspeedNumList.add(0);
			}else {
				/*
				* 修改为非高速统计数据
				* */
				nationalOverspeedNumList.add(b.getOtherOverspeedNum());
				nationalSeriousOverspeedNumList.add(b.getOtherSeriousOverspeedNum());
				nationalNightOverspeedNumList.add(b.getOtherNightOverspeedNum());
				highOverspeedNumList.add(b.getHighOverspeedNum());
				highSeriousOverspeedNumList.add(b.getHighSeriousOverspeedNum());
				highNightOverspeedNumList.add(b.getHighNightOverspeedNum());
			}
		}
		OverspeedEchartsVo overspeedEchartsVo = new OverspeedEchartsVo();
		overspeedEchartsVo.setDateList(dateList);
		overspeedEchartsVo.setNationalOverspeedNumList(nationalOverspeedNumList);
		overspeedEchartsVo.setNationalSeriousOverspeedNumList(nationalSeriousOverspeedNumList);
		overspeedEchartsVo.setNationalNightOverspeedNumList(nationalNightOverspeedNumList);
		overspeedEchartsVo.setHighOverspeedNumList(highOverspeedNumList);
		overspeedEchartsVo.setHighSeriousOverspeedNumList(highSeriousOverspeedNumList);
		overspeedEchartsVo.setHighNightOverspeedNumList(highNightOverspeedNumList);

		BigdataConfigLine bigdataConfigLine = bigdataConfigLineService.loadById("NATIONAL_OVERSPEED_LINE");
		overspeedEchartsVo.setNationalOverspeedNumLine(bigdataConfigLine.getLineValue());

		BigdataConfigLine bigdataConfigLine1 = bigdataConfigLineService.loadById("NATIONAL_SERIOUS_OVERSPEED_LINE");
		overspeedEchartsVo.setNationalSeriousOverspeedNumLine(bigdataConfigLine1.getLineValue());

		BigdataConfigLine bigdataConfigLine2 = bigdataConfigLineService.loadById("NATIONAL_NIGHT_OVERSPEED_LINE");
		overspeedEchartsVo.setNationalNightOverspeedNumLine(bigdataConfigLine2.getLineValue());

		BigdataConfigLine bigdataConfigLine3 = bigdataConfigLineService.loadById("HIGH_OVERSPEED_LINE");
		overspeedEchartsVo.setHighOverspeedNumLine(bigdataConfigLine3.getLineValue());

		BigdataConfigLine bigdataConfigLine4 = bigdataConfigLineService.loadById("HIGH_SERIOUS_OVERSPEED_LINE");
		overspeedEchartsVo.setHighSeriousOverspeedNumLine(bigdataConfigLine4.getLineValue());

		BigdataConfigLine bigdataConfigLine5 = bigdataConfigLineService.loadById("HIGH_NIGHT_OVERSPEED_LINE");
		overspeedEchartsVo.setHighNightOverspeedNumLine(bigdataConfigLine5.getLineValue());

		return overspeedEchartsVo;
	}
}
