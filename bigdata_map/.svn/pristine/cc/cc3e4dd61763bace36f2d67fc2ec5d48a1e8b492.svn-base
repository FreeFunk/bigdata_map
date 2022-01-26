package com.edgedo.bigdata.service;
		
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.bigdata.entity.FatigueSumCountEchartsVo;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataFatigueAnalysisSumCount;
import com.edgedo.bigdata.mapper.BigdataFatigueAnalysisSumCountMapper;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisSumCountQuery;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisSumCountView;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataFatigueAnalysisSumCountService {
	
	
	@Autowired
	private BigdataFatigueAnalysisSumCountMapper mapper;

	
	public List<BigdataFatigueAnalysisSumCountView> listPage(BigdataFatigueAnalysisSumCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataFatigueAnalysisSumCount voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataFatigueAnalysisSumCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataFatigueAnalysisSumCount voObj) {
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
	public BigdataFatigueAnalysisSumCount loadById(String id) {
		return mapper.selectById(id);
	}


	public FatigueSumCountEchartsVo getTimeCarCountEchartsData(BigdataFatigueAnalysisSumCountQuery query) {
		//日期的集合
		List<String> dateList = new ArrayList<>();
		//一类
		List<Integer> fatigueNumList = new ArrayList<>();
		//二类
		List<Integer> seriousFatigueNumList = new ArrayList<>();
		//三类
		List<Integer> dangerFatigueNumList = new ArrayList<>();

		List<BigdataFatigueAnalysisSumCountView> bigdataFatigueAnalysisSumCountViewList = new ArrayList<>();
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
				BigdataFatigueAnalysisSumCountView bigdataFatigueAnalysisSumCountView = mapper.getFatigueSumCountData(query);
				bigdataFatigueAnalysisSumCountViewList.add(bigdataFatigueAnalysisSumCountView);
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
				BigdataFatigueAnalysisSumCountView bigdataFatigueAnalysisSumCountView = mapper.getFatigueSumCountData(query);
				bigdataFatigueAnalysisSumCountViewList.add(bigdataFatigueAnalysisSumCountView);
				startMonthDate = DateUtil.getNextYear(startMonthDate);
			}

		}

		for(BigdataFatigueAnalysisSumCountView b:bigdataFatigueAnalysisSumCountViewList){
			if(b==null){
				fatigueNumList.add(0);
				seriousFatigueNumList.add(0);
				dangerFatigueNumList.add(0);
			}else {
				fatigueNumList.add(b.getSumFatigueNum());
				seriousFatigueNumList.add(b.getSumSeriousFatigueNum());
				dangerFatigueNumList.add(b.getSumNightFatigueNum());
			}
		}
		FatigueSumCountEchartsVo fatigueSumCountEchartsVo = new FatigueSumCountEchartsVo();
		fatigueSumCountEchartsVo.setDateList(dateList);
		fatigueSumCountEchartsVo.setFatigueNumList(fatigueNumList);
		fatigueSumCountEchartsVo.setSeriousFatigueNumList(seriousFatigueNumList);
		fatigueSumCountEchartsVo.setDangerFatigueNumList(dangerFatigueNumList);

		return fatigueSumCountEchartsVo;
	}
}
