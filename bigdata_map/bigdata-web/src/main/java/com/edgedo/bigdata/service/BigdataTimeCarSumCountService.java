package com.edgedo.bigdata.service;
		
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.bigdata.entity.TimeCarCountEchartsVo;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataTimeCarSumCount;
import com.edgedo.bigdata.mapper.BigdataTimeCarSumCountMapper;
import com.edgedo.bigdata.queryvo.BigdataTimeCarSumCountQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeCarSumCountView;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataTimeCarSumCountService {
	
	
	@Autowired
	private BigdataTimeCarSumCountMapper mapper;

	
	public List<BigdataTimeCarSumCountView> listPage(BigdataTimeCarSumCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataTimeCarSumCount voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataTimeCarSumCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataTimeCarSumCount voObj) {
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
	public BigdataTimeCarSumCount loadById(String id) {
		return mapper.selectById(id);
	}


	public TimeCarCountEchartsVo getTimeCarCountEchartsData(BigdataTimeCarSumCountQuery query) {
		//日期的集合
		List<String> dateList = new ArrayList<>();
		//一类
		List<Integer> firstDangerTimeCarNumList = new ArrayList<>();
		//二类
		List<Integer> secondDangerTimeCarNumList = new ArrayList<>();
		//三类
		List<Integer> thirdDangerTimeCarNumList = new ArrayList<>();
		List<BigdataTimeCarSumCountView> bigdataTimeCarSumCountViewList = new ArrayList<>();
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
				BigdataTimeCarSumCountView bigdataTimeCarSumCountView = mapper.getTimeCarSumCountData(query);
				bigdataTimeCarSumCountViewList.add(bigdataTimeCarSumCountView);
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
				BigdataTimeCarSumCountView bigdataTimeCarSumCountView = mapper.getTimeCarSumCountData(query);
				bigdataTimeCarSumCountViewList.add(bigdataTimeCarSumCountView);
				startMonthDate = DateUtil.getNextYear(startMonthDate);
			}

		}

		for(BigdataTimeCarSumCountView b:bigdataTimeCarSumCountViewList){
			if(b==null){
				firstDangerTimeCarNumList.add(0);
				secondDangerTimeCarNumList.add(0);
				thirdDangerTimeCarNumList.add(0);
			}else {
				firstDangerTimeCarNumList.add(b.getFirstDangerTimeNum());
				secondDangerTimeCarNumList.add(b.getSecondDangerTimeNum());
				thirdDangerTimeCarNumList.add(b.getFirstDangerTimeNum());
			}
		}
		TimeCarCountEchartsVo timeCarCountEchartsVo = new TimeCarCountEchartsVo();
		timeCarCountEchartsVo.setDateList(dateList);
		timeCarCountEchartsVo.setFirstDangerTimeCarNum(firstDangerTimeCarNumList);
		timeCarCountEchartsVo.setSecondDangerTimeCarNum(secondDangerTimeCarNumList);
		timeCarCountEchartsVo.setThirdDangerTimeCarNum(thirdDangerTimeCarNumList);

		return timeCarCountEchartsVo;
	}
}
