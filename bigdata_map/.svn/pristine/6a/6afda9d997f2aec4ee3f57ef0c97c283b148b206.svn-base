package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataCarStopRec;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecQuery;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataCarStopRecMapper extends BaseMapper<BigdataCarStopRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarStopRecView> listPage(BigdataCarStopRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarStopRecView> listByObj(BigdataCarStopRecQuery query);


	BigdataCarStopRecView selectByCarRealId(Map<String, Object> param);

	/**
	 * 根据主键和分片字段查询
	 * @param param
	 * @return
	 */
	int countByIdAndCountMonth(Map<String, Object> param);
}