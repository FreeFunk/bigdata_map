package com.edgedo.drawing.service;

import com.edgedo.bigdata.entity.BigdataDriverCardInfo;
import com.edgedo.drawing.entity.BigdataDriverCountMonthAndYear;
import com.edgedo.drawing.mapper.BigdataDriverCountMonthAndYearMapper;
import com.edgedo.drawing.queryvo.BigdataDriverCountMonthAndYearQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCountMonthAndYearView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BigdataDriverCountMonthAndYearService {
	
	
	@Autowired
	private BigdataDriverCountMonthAndYearMapper mapper;

	
	public List<BigdataDriverCountMonthAndYearView> listPage(BigdataDriverCountMonthAndYearQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverCountMonthAndYear voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverCountMonthAndYear voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverCountMonthAndYear voObj) {
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
	public BigdataDriverCountMonthAndYear loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataDriverCountMonthAndYear selectByVo(String driverId, int yearNum) {
		Map<String,Object> map = new HashMap<>();
		map.put("id",driverId+"-"+yearNum);
		map.put("yearNum",yearNum);
		map.put("countType","year");
		return mapper.selectByVo(map);
	}

	/**
	 * @Author WangZhen
	 * @Description 汇总统计某个司机的月度数据
	 * @Date 2020/2/6 15:26
	 **/
	public void updateDriverCountSumMonth(
			BigdataDriverCardInfo driver,
		    int countMonth,int yearNum) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("driverId",driver.getId());
		param.put("countMonth",countMonth);
//		param.put("yearNum",yearNum);

		//1.从日统计里汇总统计
		BigdataDriverCountMonthAndYearView driverMonthCount =
				mapper.sumDriverCountDayInfoForMonth(param);
		if(driverMonthCount!=null){
			//2.计算各个维度的平均速度,百公里报警系数=所有报警数量/(公里/100)
			driverMonthCount.countData();
		}else{
			driverMonthCount = new BigdataDriverCountMonthAndYearView();
			driverMonthCount.initNullData();
		}
		//3.设置司机信息和分片字段等基础信息
		driverMonthCount.confDriverInfo(driver);
		//往月度表中新增或者修改
		driverMonthCount.setCountMonth(countMonth);
		driverMonthCount.setCountType("month");
		driverMonthCount.setYearNum(yearNum);
		String sumId = driver.getId()+"-" + countMonth;
		driverMonthCount.setId(sumId);
		int count = mapper.countByIdAndFenpian(driverMonthCount);
		if(count>0){
			mapper.updateByIdAndFenpian(driverMonthCount);
		}else{
			driverMonthCount.setCreateTime(new Date());
			mapper.insert(driverMonthCount);
		}


	}

	/**
	 * @Author WangZhen
	 * @Description
	 * @Date 2020/2/7 8:41
	 **/
	public void updateDriverCountSumYear(BigdataDriverCardInfo driver, int yearNum) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("driverId",driver.getId());
		param.put("yearNum",yearNum);
		param.put("countType","month");
		//1.从日统计里汇总统计
		BigdataDriverCountMonthAndYearView driverYearCount =
				mapper.sumDriverCountMonthInfoForYear(param);
		if(driverYearCount!=null){
			//2.计算各个维度的平均速度,百公里报警系数=所有报警数量/(公里/100)
			driverYearCount.countData();
		}else{
			driverYearCount = new BigdataDriverCountMonthAndYearView();
			driverYearCount.initNullData();
		}
		//3.设置司机信息和分片字段等基础信息
		driverYearCount.confDriverInfo(driver);
		//往月度表中新增或者修改
		driverYearCount.setCountType("year");
		driverYearCount.setYearNum(yearNum);
		String sumId = driver.getId()+"-" + yearNum;
		driverYearCount.setId(sumId);
		int count = mapper.countByIdAndFenpian(driverYearCount);
		if(count>0){
			mapper.updateByIdAndFenpian(driverYearCount);
		}else{
			driverYearCount.setCreateTime(new Date());
			mapper.insert(driverYearCount);
		}
	}
}
