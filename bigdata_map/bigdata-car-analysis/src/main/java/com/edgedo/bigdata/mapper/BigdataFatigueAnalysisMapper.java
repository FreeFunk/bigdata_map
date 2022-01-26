package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFatigueAnalysis;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataFatigueAnalysisMapper extends BaseMapper<BigdataFatigueAnalysis>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFatigueAnalysisView> listPage(BigdataFatigueAnalysisQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFatigueAnalysisView> listByObj(BigdataFatigueAnalysisQuery query);


	BigdataFatigueAnalysisView getVoByQuery(BigdataFatigueAnalysis bigdataFatigueAnalysis);

	/**
	 * 月度的分组统计
	 * @param monthInt
	 * @return
	 */
    List<BigdataFatigueAnalysis> selectGroupSumCountMonth(int monthInt);


}