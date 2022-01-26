package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataTimeAnalysis;
import com.edgedo.bigdata.queryvo.BigdataTimeAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeAnalysisView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataTimeAnalysisMapper  extends BaseMapper<BigdataTimeAnalysis>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataTimeAnalysisView> listPage(BigdataTimeAnalysisQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataTimeAnalysisView> listByObj(BigdataTimeAnalysisQuery query);


	BigdataTimeAnalysisView getTimeAnalysisData(BigdataTimeAnalysisQuery query);

}