package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.CarMonthOftenrunRoute;
import com.edgedo.bigdata.queryvo.CarMonthOftenrunRouteQuery;
import com.edgedo.bigdata.queryvo.CarMonthOftenrunRouteView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface CarMonthOftenrunRouteMapper  extends BaseMapper<CarMonthOftenrunRoute>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<CarMonthOftenrunRouteView> listPage(CarMonthOftenrunRouteQuery query);



	public List<CarMonthOftenrunRouteView> qtlistPage(CarMonthOftenrunRouteQuery query);
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<CarMonthOftenrunRouteView> listByObj(CarMonthOftenrunRouteQuery query);
	
	public List<CarMonthOftenrunRouteView> searchOftenRunRoute(CarMonthOftenrunRouteQuery query);

	List<CarMonthOftenrunRouteView> selectOftenRunRoute(CarMonthOftenrunRouteQuery query);
}