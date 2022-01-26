package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataOverspeedAnalysis;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisView;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;


@Mapper
public interface BigdataOverspeedAnalysisMapper extends BaseMapper<BigdataOverspeedAnalysis>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataOverspeedAnalysisView> listPage(BigdataOverspeedAnalysisQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataOverspeedAnalysisView> listByObj(BigdataOverspeedAnalysisQuery query);


	BigdataOverspeedAnalysisView getOverspeedAnalysisData(BigdataOverspeedAnalysisQuery query);

    List<BigdataOverspeedAnalysisView> getOverspeedEchartsData(BigdataOverspeedAnalysisQuery query);

	BigdataOverspeedAnalysisView getVoByQuery(BigdataOverspeedAnalysis bigdataOverspeedAnalysis);
	//分组统计月度的超速分析
	List<BigdataOverspeedAnalysis> selectSumGroupByCarTypeMonth(int month);

}