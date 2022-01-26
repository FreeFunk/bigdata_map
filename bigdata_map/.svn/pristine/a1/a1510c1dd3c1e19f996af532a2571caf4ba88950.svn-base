package com.edgedo.drawing.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverStopCount;
import com.edgedo.drawing.queryvo.BigdataDriverStopCountQuery;
import com.edgedo.drawing.queryvo.BigdataDriverStopCountView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataDriverStopCountMapper  extends BaseMapper<BigdataDriverStopCount>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverStopCountView> listPage(BigdataDriverStopCountQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverStopCountView> listByObj(BigdataDriverStopCountQuery query);
	
	public BigdataDriverStopCountView selectListByDriverIdAndCity(BigdataDriverStopCountQuery query);

	public List<String> selectTotalStopCity(Map<String,Object> map);

	List<BigdataDriverStopCountView> selectTotalStopCityNew(Map<String, Object> paramMap);
}