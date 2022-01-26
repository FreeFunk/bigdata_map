package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFatigueAnalysis;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataFatigueAnalysisMapper  extends BaseMapper<BigdataFatigueAnalysis>{
	
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


    BigdataFatigueAnalysisView getFatigueAnalysisData(BigdataFatigueAnalysisQuery query);

	List<BigdataFatigueAnalysisView> getFatigueEchartsData(BigdataFatigueAnalysisQuery query);
}