package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataDangerRoadAnalysis;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadAnalysisView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataDangerRoadAnalysisMapper extends BaseMapper<BigdataDangerRoadAnalysis>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDangerRoadAnalysisView> listPage(BigdataDangerRoadAnalysisQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDangerRoadAnalysisView> listByObj(BigdataDangerRoadAnalysisQuery query);


    List<BigdataDangerRoadAnalysisView> getDangerRoadClsDetailData(BigdataDangerRoadAnalysisQuery query);
}