package com.edgedo.bigdata.service;
		
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.bigdata.entity.BigdataConfigLine;
import com.edgedo.bigdata.entity.TimeEchartsVo;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataTimeAnalysis;
import com.edgedo.bigdata.mapper.BigdataTimeAnalysisMapper;
import com.edgedo.bigdata.queryvo.BigdataTimeAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeAnalysisView;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataTimeAnalysisService {
	
	
	@Autowired
	private BigdataTimeAnalysisMapper mapper;
	@Autowired
	private BigdataConfigLineService bigdataConfigLineService;

	
	public List<BigdataTimeAnalysisView> listPage(BigdataTimeAnalysisQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataTimeAnalysis voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataTimeAnalysis voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataTimeAnalysis voObj) {
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
	public BigdataTimeAnalysis loadById(String id) {
		return mapper.selectById(id);
	}
	

	public BigdataTimeAnalysisView getTimeAnalysisData(BigdataTimeAnalysisQuery query) {
		return mapper.getTimeAnalysisData(query);
	}

	public TimeEchartsVo getTimeEchartsData(BigdataTimeAnalysisQuery query) {
		//日期的集合
		List<String> dateList = new ArrayList<>();

		//一类
		List<Integer> firstCarNumList = new ArrayList<>();

		//二类
		List<Integer> secondCarNumList = new ArrayList<>();

		//三类
		List<Integer> thirdCarNumList = new ArrayList<>();

		//获取日期的集合
		Date countTime = query.getQueryObj().getCountTime();
		dateList = DateUtil.getDateList(countTime,query.getLimit());
		//开始日期
		Date startDate = DateUtil.getLastDate(countTime,query.getLimit());
		List<BigdataTimeAnalysisView> bigdataTimeAnalysisViewList = new ArrayList<>();
		for(int i =0 ;i<=Math.abs(query.getLimit());i++){
			query.getQueryObj().setCountTime(startDate);
			BigdataTimeAnalysisView bigdataTimeAnalysisView = mapper.getTimeAnalysisData(query);
			bigdataTimeAnalysisViewList.add(bigdataTimeAnalysisView);
			startDate = DateUtil.getNextDayDate(startDate);
		}
		for(BigdataTimeAnalysisView b:bigdataTimeAnalysisViewList){
			if(b==null){
				firstCarNumList.add(0);
				secondCarNumList.add(0);
				thirdCarNumList.add(0);
			}else {
				firstCarNumList.add(b.getFirstDangerTimeNum());
				secondCarNumList.add(b.getSecondDangerTimeNum());
				thirdCarNumList.add(b.getThirdDangerTimeNum());
			}
		}
		TimeEchartsVo timeEchartsVo = new TimeEchartsVo();
		timeEchartsVo.setDateList(dateList);
		timeEchartsVo.setFirstCarNumList(firstCarNumList);
		timeEchartsVo.setSecondCarNumList(secondCarNumList);
		timeEchartsVo.setThirdCarNumList(thirdCarNumList);

		BigdataConfigLine bigdataConfigLine = bigdataConfigLineService.loadById("FIRST_DANGER_CAR_NUM");
		timeEchartsVo.setFirstDangerCarNumLine(bigdataConfigLine.getLineValue());

		BigdataConfigLine bigdataConfigLine1 = bigdataConfigLineService.loadById("SECOND_DANGER_CAR_NUM");
		timeEchartsVo.setSecondDangerCarNumLine(bigdataConfigLine1.getLineValue());

		BigdataConfigLine bigdataConfigLine2 = bigdataConfigLineService.loadById("THIRD_DANGER_CAR_NUM");
		timeEchartsVo.setThirdDangerCarNumLine(bigdataConfigLine2.getLineValue());


		return timeEchartsVo;
	}
}
