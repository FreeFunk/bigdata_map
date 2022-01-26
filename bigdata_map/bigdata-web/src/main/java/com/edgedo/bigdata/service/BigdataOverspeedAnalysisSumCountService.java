package com.edgedo.bigdata.service;
		
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.bigdata.entity.OverSpeedSumCountEchartsVo;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataOverspeedAnalysisSumCount;
import com.edgedo.bigdata.mapper.BigdataOverspeedAnalysisSumCountMapper;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisSumCountQuery;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisSumCountView;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataOverspeedAnalysisSumCountService {
	
	
	@Autowired
	private BigdataOverspeedAnalysisSumCountMapper mapper;

	
	public List<BigdataOverspeedAnalysisSumCountView> listPage(BigdataOverspeedAnalysisSumCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataOverspeedAnalysisSumCount voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataOverspeedAnalysisSumCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataOverspeedAnalysisSumCount voObj) {
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
	public BigdataOverspeedAnalysisSumCount loadById(String id) {
		return mapper.selectById(id);
	}


	public OverSpeedSumCountEchartsVo getTimeCarCountEchartsData(BigdataOverspeedAnalysisSumCountQuery query) {
		//日期的集合
		List<String> dateList = new ArrayList<>();
		//一类
		List<Integer> overSpeedNumList = new ArrayList<>();
		//二类
		List<Integer> seriousOverSpeedNumList = new ArrayList<>();
		//三类
		List<Integer> dangerOverSpeedNumList = new ArrayList<>();
		List<BigdataOverspeedAnalysisSumCountView> bigdataOverspeedAnalysisSumCountViewList = new ArrayList<>();
		String countType = query.getQueryObj().getCountType();
		//月份查询
		if(countType.equals("MONTH")){
			//获取日期的集合
			//开始月份
			Date startMonthDate = query.getStartMonthDate();
			//结束月份
			Date endMonthDate = query.getEndMonthDate();

			dateList = DateUtil.getDateListByStartAndEndMonth(startMonthDate,endMonthDate);
			int countMonth = 0;
			for(int i = 0;i<dateList.size();i++){
				countMonth = DateUtil.getCountMonth(startMonthDate);
				query.getQueryObj().setCountMonth(countMonth);
				BigdataOverspeedAnalysisSumCountView bigdataOverspeedAnalysisSumCountView = mapper.getOverSpeedSumCountData(query);
				bigdataOverspeedAnalysisSumCountViewList.add(bigdataOverspeedAnalysisSumCountView);
				startMonthDate = DateUtil.getNextMonth(startMonthDate);
			}
		}else {
			//年度查询
			//开始月份
			Date startMonthDate = query.getStartMonthDate();
			//结束月份
			Date endMonthDate = query.getEndMonthDate();
			dateList = DateUtil.getDateListByStartAndEndYear(startMonthDate,endMonthDate);
			int countYear = 0;
			for(int i = 0;i<dateList.size();i++){
				countYear = DateUtil.getCountYear(startMonthDate);
				query.getQueryObj().setCountYear(countYear);
				BigdataOverspeedAnalysisSumCountView bigdataOverspeedAnalysisSumCountView = mapper.getOverSpeedSumCountData(query);
				bigdataOverspeedAnalysisSumCountViewList.add(bigdataOverspeedAnalysisSumCountView);
				startMonthDate = DateUtil.getNextYear(startMonthDate);
			}

		}

		for(BigdataOverspeedAnalysisSumCountView b:bigdataOverspeedAnalysisSumCountViewList){
			if(b==null){
				overSpeedNumList.add(0);
				seriousOverSpeedNumList.add(0);
				dangerOverSpeedNumList.add(0);
			}else {
				overSpeedNumList.add(b.getSumOverspeedNum());
				seriousOverSpeedNumList.add(b.getSumSeriousOverspeedNum());
				dangerOverSpeedNumList.add(b.getSumNightOverspeedNum());
			}
		}
		OverSpeedSumCountEchartsVo overSpeedSumCountEchartsVo = new OverSpeedSumCountEchartsVo();
		overSpeedSumCountEchartsVo.setDateList(dateList);
		overSpeedSumCountEchartsVo.setOverSpeedNumList(overSpeedNumList);
		overSpeedSumCountEchartsVo.setSeriousOverSpeedNumList(seriousOverSpeedNumList);
		overSpeedSumCountEchartsVo.setDangerOverSpeedNumList(dangerOverSpeedNumList);

		return overSpeedSumCountEchartsVo;
	}
}
