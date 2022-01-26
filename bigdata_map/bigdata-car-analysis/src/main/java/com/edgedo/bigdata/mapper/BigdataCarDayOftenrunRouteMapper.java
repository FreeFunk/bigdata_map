package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataCarDayOftenrunRoute;
import com.edgedo.bigdata.queryvo.BigdataCarDayOftenrunRouteQuery;
import com.edgedo.bigdata.queryvo.BigdataCarDayOftenrunRouteView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataCarDayOftenrunRouteMapper extends BaseMapper<BigdataCarDayOftenrunRoute>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarDayOftenrunRouteView> listPage(BigdataCarDayOftenrunRouteQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarDayOftenrunRouteView> listByObj(BigdataCarDayOftenrunRouteQuery query);

	/**
	 * 分组统计某个车的某个月的线路信息
	 * @param param
	 * @return
	 */
    List<BigdataCarDayOftenrunRoute> selectGroupSumOfMonth(Map<String, Object> param);

	/**
	 * 根据统计月份和主键获得记录
	 * @param param
	 * @return
	 */
	BigdataCarDayOftenrunRoute loadByIdAndDate(Map<String, Object> param);

}