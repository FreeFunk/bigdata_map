package com.edgedo.drawing.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverStopCount;
import com.edgedo.drawing.queryvo.BigdataDriverStopCountQuery;
import com.edgedo.drawing.queryvo.BigdataDriverStopCountView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataDriverStopCountMapper extends BaseMapper<BigdataDriverStopCount>{
	
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


    BigdataDriverStopCount selectByCityId(BigdataDriverStopCount s);

	void updateByfenPian(BigdataDriverStopCount bigdataDriverStopCount);

	List<BigdataDriverStopCount> selectGroupCityIdById(Map<String, Object> map);

	List<BigdataDriverStopCount> listTopThree(Map<String, Object> map);
}