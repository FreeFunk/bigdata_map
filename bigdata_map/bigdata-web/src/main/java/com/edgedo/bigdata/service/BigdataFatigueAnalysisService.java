package com.edgedo.bigdata.service;
		
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.bigdata.entity.BigdataConfigLine;
import com.edgedo.bigdata.entity.BigdataFatigueEchartsVo;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataFatigueAnalysis;
import com.edgedo.bigdata.mapper.BigdataFatigueAnalysisMapper;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisView;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataFatigueAnalysisService {
	
	
	@Autowired
	private BigdataFatigueAnalysisMapper mapper;

	@Autowired
	private BigdataConfigLineService bigdataConfigLineService;

	
	public List<BigdataFatigueAnalysisView> listPage(BigdataFatigueAnalysisQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataFatigueAnalysis voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataFatigueAnalysis voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataFatigueAnalysis voObj) {
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
	public BigdataFatigueAnalysis loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataFatigueAnalysisView getFatigueAnalysisData(BigdataFatigueAnalysisQuery query) {
		return mapper.getFatigueAnalysisData(query);
	}

	public BigdataFatigueEchartsVo getFatigueEchartsData(BigdataFatigueAnalysisQuery query) {
		//日期的集合
		List<String> dateList = new ArrayList<>();
		//疲劳次数集合
		List<Integer> nationalFatigueNumList = new ArrayList<>();
		//严重疲劳次数集合
		List<Integer> nationalSeriousFatigueNumList = new ArrayList<>();
		//危险时段疲劳次数
		List<Integer> nationalNightFatigueNumList = new ArrayList<>();


		//获取日期的集合
		Date countTime = query.getQueryObj().getCountTime();
		dateList = DateUtil.getDateList(countTime,query.getLimit());
		//开始日期
		Date startDate = DateUtil.getLastDate(countTime,query.getLimit());
		List<BigdataFatigueAnalysisView> bigdataFatigueAnalysisViewList = new ArrayList<>();
		for(int i =0 ;i<=Math.abs(query.getLimit());i++){
			query.getQueryObj().setCountTime(startDate);
			BigdataFatigueAnalysisView bigdataFatigueAnalysisView = mapper.getFatigueAnalysisData(query);
			bigdataFatigueAnalysisViewList.add(bigdataFatigueAnalysisView);
			startDate = DateUtil.getNextDayDate(startDate);
		}
		for(BigdataFatigueAnalysisView b:bigdataFatigueAnalysisViewList){
			if(b==null){
				nationalFatigueNumList.add(0);
				nationalSeriousFatigueNumList.add(0);
				nationalNightFatigueNumList.add(0);
			}else {
				nationalFatigueNumList.add(b.getSumFatigueNum());
				nationalSeriousFatigueNumList.add(b.getSumSeriousFatigueNum());
				nationalNightFatigueNumList.add(b.getSumNightFatigueNum());
			}
		}
		BigdataFatigueEchartsVo bigdataFatigueEchartsVo = new BigdataFatigueEchartsVo();
		bigdataFatigueEchartsVo.setDateList(dateList);
		bigdataFatigueEchartsVo.setNationalFatigueNumList(nationalFatigueNumList);
		bigdataFatigueEchartsVo.setNationalSeriousFatigueNumList(nationalSeriousFatigueNumList);
		bigdataFatigueEchartsVo.setNationalNightFatigueNumList(nationalNightFatigueNumList);

		BigdataConfigLine bigdataConfigLine = bigdataConfigLineService.loadById("NATIONAL_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setNationalFatigueNumLine(bigdataConfigLine.getLineValue());

		BigdataConfigLine bigdataConfigLine1 = bigdataConfigLineService.loadById("NATIONAL_SERIOUS_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setNationalSeriousFatigueNumLine(bigdataConfigLine1.getLineValue());

		BigdataConfigLine bigdataConfigLine2 = bigdataConfigLineService.loadById("NATIONAL_NIGHT_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setNationalNightFatigueNumLine(bigdataConfigLine2.getLineValue());

		BigdataConfigLine bigdataConfigLine3 = bigdataConfigLineService.loadById("HIGH_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setHighFatigueNumLine(bigdataConfigLine3.getLineValue());

		BigdataConfigLine bigdataConfigLine4 = bigdataConfigLineService.loadById("HIGH_SERIOUS_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setHighSeriousFatigueNumNumLine(bigdataConfigLine4.getLineValue());

		BigdataConfigLine bigdataConfigLine5 = bigdataConfigLineService.loadById("HIGH_NIGHT_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setHighNightFatigueNumLine(bigdataConfigLine5.getLineValue());
		return bigdataFatigueEchartsVo;
	}
	/*public BigdataFatigueEchartsVo getFatigueEchartsData(BigdataFatigueAnalysisQuery query) {
		//日期的集合
		List<String> dateList = new ArrayList<>();
		//国道疲劳次数集合
		List<Integer> nationalFatigueNumList = new ArrayList<>();
		//国道严重疲劳次数集合
		List<Integer> nationalSeriousFatigueNumList = new ArrayList<>();
		//国道危险时段疲劳次数
		List<Integer> nationalNightFatigueNumList = new ArrayList<>();
		//高速疲劳次数集合
		List<Integer> highFatigueNumList = new ArrayList<>();
		//高速严重疲劳次数集合
		List<Integer> highSeriousFatigueNumNumList = new ArrayList<>();
		//高速危险时段疲劳次数
		List<Integer> highNightFatigueNumList =new ArrayList<>();

		//获取日期的集合
		Date countTime = query.getQueryObj().getCountTime();
		dateList = DateUtil.getDateList(countTime,query.getLimit());
		//开始日期
		Date startDate = DateUtil.getLastDate(countTime,query.getLimit());
		List<BigdataFatigueAnalysisView> bigdataFatigueAnalysisViewList = new ArrayList<>();
		for(int i =0 ;i<=Math.abs(query.getLimit());i++){
			query.getQueryObj().setCountTime(startDate);
			BigdataFatigueAnalysisView bigdataFatigueAnalysisView = mapper.getFatigueAnalysisData(query);
			bigdataFatigueAnalysisViewList.add(bigdataFatigueAnalysisView);
			startDate = DateUtil.getNextDayDate(startDate);
		}
		for(BigdataFatigueAnalysisView b:bigdataFatigueAnalysisViewList){
			if(b==null){
				nationalFatigueNumList.add(0);
				nationalSeriousFatigueNumList.add(0);
				nationalNightFatigueNumList.add(0);
				highFatigueNumList.add(0);
				highSeriousFatigueNumNumList.add(0);
				highNightFatigueNumList.add(0);
			}else {
				nationalFatigueNumList.add(b.getNationalFatigueNum());
				nationalSeriousFatigueNumList.add(b.getNationalSeriousFatigueNum());
				nationalNightFatigueNumList.add(b.getNationalNightFatigueNum());
				highFatigueNumList.add(b.getHighFatigueNum());
				highSeriousFatigueNumNumList.add(b.getHighSeriousFatigueNum());
				highNightFatigueNumList.add(b.getHighNightFatigueNum());
			}
		}
		BigdataFatigueEchartsVo bigdataFatigueEchartsVo = new BigdataFatigueEchartsVo();
		bigdataFatigueEchartsVo.setDateList(dateList);
		bigdataFatigueEchartsVo.setNationalFatigueNumList(nationalFatigueNumList);
		bigdataFatigueEchartsVo.setNationalSeriousFatigueNumList(nationalSeriousFatigueNumList);
		bigdataFatigueEchartsVo.setNationalNightFatigueNumList(nationalNightFatigueNumList);
		bigdataFatigueEchartsVo.setHighFatigueNumList(highFatigueNumList);
		bigdataFatigueEchartsVo.setHighSeriousFatigueNumNumList(highSeriousFatigueNumNumList);
		bigdataFatigueEchartsVo.setHighNightFatigueNumList(highNightFatigueNumList);

		BigdataConfigLine bigdataConfigLine = bigdataConfigLineService.loadById("NATIONAL_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setNationalFatigueNumLine(bigdataConfigLine.getLineValue());

		BigdataConfigLine bigdataConfigLine1 = bigdataConfigLineService.loadById("NATIONAL_SERIOUS_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setNationalSeriousFatigueNumLine(bigdataConfigLine1.getLineValue());

		BigdataConfigLine bigdataConfigLine2 = bigdataConfigLineService.loadById("NATIONAL_NIGHT_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setNationalNightFatigueNumLine(bigdataConfigLine2.getLineValue());

		BigdataConfigLine bigdataConfigLine3 = bigdataConfigLineService.loadById("HIGH_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setHighFatigueNumLine(bigdataConfigLine3.getLineValue());

		BigdataConfigLine bigdataConfigLine4 = bigdataConfigLineService.loadById("HIGH_SERIOUS_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setHighSeriousFatigueNumNumLine(bigdataConfigLine4.getLineValue());

		BigdataConfigLine bigdataConfigLine5 = bigdataConfigLineService.loadById("HIGH_NIGHT_FATIGUE_LINE");
		bigdataFatigueEchartsVo.setHighNightFatigueNumLine(bigdataConfigLine5.getLineValue());
		return bigdataFatigueEchartsVo;
	}*/
}
