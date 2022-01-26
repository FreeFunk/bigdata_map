package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.CarMonthOftenrunRoute;
import com.edgedo.bigdata.queryvo.CarMonthOftenrunRouteQuery;
import com.edgedo.bigdata.queryvo.CarMonthOftenrunRouteView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface CarMonthOftenrunRouteMapper extends BaseMapper<CarMonthOftenrunRoute>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<CarMonthOftenrunRouteView> listPage(CarMonthOftenrunRouteQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<CarMonthOftenrunRouteView> listByObj(CarMonthOftenrunRouteQuery query);
	
	public List<CarMonthOftenrunRouteView> searchOftenRunRoute(CarMonthOftenrunRouteQuery query);

	/**
	 * 车辆分组统计
	 * @param param
	 * @return
	 */
    List<CarMonthOftenrunRoute> selectGroupSumOfJidu(Map<String, Object> param);

	/**
	 * 根据车辆类型和月份分组统计线路数据
	 * @param param
	 * @return
	 */
    List<CarMonthOftenrunRoute> selectGroupSumOfMonth(Map<String, Object> param);

	/**
	 * 分片之后根据主键查询
	 * @param param
	 * @return
	 */
    CarMonthOftenrunRoute loadByIdAndDate(Map<String, Object> param);

}