package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.CarMonthDirectionDistribution;
import com.edgedo.bigdata.mapper.CarMonthDirectionDistributionMapper;
import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionQuery;
import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionView;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarMonthDirectionDistributionService {
	
	
	@Autowired
	private CarMonthDirectionDistributionMapper mapper;

	
	public List<CarMonthDirectionDistributionView> listPage(CarMonthDirectionDistributionQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(CarMonthDirectionDistribution voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(CarMonthDirectionDistribution voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(CarMonthDirectionDistribution voObj) {
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
	public CarMonthDirectionDistribution loadById(String id) {
		return mapper.selectById(id);
	}


	public List<CarMonthDirectionDistributionView> getOftenRunProvince(CarMonthDirectionDistributionQuery query) {
		String countType = query.getQueryObj().getCountType();
		if(countType!=null && countType.equals("QUARTER")){
			int yearAndQuarter = DateUtil.getYearAndQuarter(query.getQueryObj().getCountTime());
			query.getQueryObj().setQuarterType(yearAndQuarter);
		}
		return mapper.getOftenRunProvince(query);
	}

	public List<CarMonthDirectionDistributionView> getOftenRunCity(CarMonthDirectionDistributionQuery query) {
		String countType = query.getQueryObj().getCountType();
		if(countType!=null && countType.equals("QUARTER")){
			int yearAndQuarter = DateUtil.getYearAndQuarter(query.getQueryObj().getCountTime());
			query.getQueryObj().setQuarterType(yearAndQuarter);
		}
		return mapper.getOftenRunCity(query);
	}
}
