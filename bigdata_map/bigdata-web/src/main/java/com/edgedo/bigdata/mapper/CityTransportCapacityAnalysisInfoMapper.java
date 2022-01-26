package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.CityTransportCapacityAnalysisInfo;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisInfoQuery;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisInfoView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface CityTransportCapacityAnalysisInfoMapper  extends BaseMapper<CityTransportCapacityAnalysisInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<CityTransportCapacityAnalysisInfoView> listPage(CityTransportCapacityAnalysisInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<CityTransportCapacityAnalysisInfoView> listByObj(CityTransportCapacityAnalysisInfoQuery query);


    List<CityTransportCapacityAnalysisInfoView> listByCountDate(CityTransportCapacityAnalysisInfo cityTransportCapacityAnalysisInfo);
}