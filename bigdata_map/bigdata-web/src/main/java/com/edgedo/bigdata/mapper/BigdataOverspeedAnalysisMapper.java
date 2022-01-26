package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataOverspeedAnalysis;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataOverspeedAnalysisMapper  extends BaseMapper<BigdataOverspeedAnalysis>{
	
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
}