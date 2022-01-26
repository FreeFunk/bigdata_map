package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataOverspeedAnalysisSumCount;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisSumCountQuery;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisSumCountView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataOverspeedAnalysisSumCountMapper  extends BaseMapper<BigdataOverspeedAnalysisSumCount>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataOverspeedAnalysisSumCountView> listPage(BigdataOverspeedAnalysisSumCountQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataOverspeedAnalysisSumCountView> listByObj(BigdataOverspeedAnalysisSumCountQuery query);


    BigdataOverspeedAnalysisSumCountView getOverSpeedSumCountData(BigdataOverspeedAnalysisSumCountQuery query);
}