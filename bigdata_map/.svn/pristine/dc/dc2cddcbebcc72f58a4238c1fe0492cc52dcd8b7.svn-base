package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataTimeCarSumCount;
import com.edgedo.bigdata.queryvo.BigdataTimeCarSumCountQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeCarSumCountView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataTimeCarSumCountMapper extends BaseMapper<BigdataTimeCarSumCount>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataTimeCarSumCountView> listPage(BigdataTimeCarSumCountQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataTimeCarSumCountView> listByObj(BigdataTimeCarSumCountQuery query);

	/**
	 * 从月度那统计年度
	 * @param countYear
	 * @return
	 */
    List<BigdataTimeCarSumCount> selectSumGroupCarInfoYear(int countYear);


}