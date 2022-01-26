package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFatigueAnalysisSumCount;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisSumCountQuery;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisSumCountView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataFatigueAnalysisSumCountMapper  extends BaseMapper<BigdataFatigueAnalysisSumCount>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFatigueAnalysisSumCountView> listPage(BigdataFatigueAnalysisSumCountQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFatigueAnalysisSumCountView> listByObj(BigdataFatigueAnalysisSumCountQuery query);


    BigdataFatigueAnalysisSumCountView getFatigueSumCountData(BigdataFatigueAnalysisSumCountQuery query);
}