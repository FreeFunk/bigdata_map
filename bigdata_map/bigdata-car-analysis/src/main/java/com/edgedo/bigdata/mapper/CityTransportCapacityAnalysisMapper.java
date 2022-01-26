package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.CityTransportCapacityAnalysis;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisQuery;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CityTransportCapacityAnalysisMapper extends BaseMapper<CityTransportCapacityAnalysis>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<CityTransportCapacityAnalysisView> listPage(CityTransportCapacityAnalysisQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<CityTransportCapacityAnalysisView> listByObj(CityTransportCapacityAnalysisQuery query);


    CityTransportCapacityAnalysisView getRealTimeData(String carType);

}