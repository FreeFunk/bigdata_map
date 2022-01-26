package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataCarDayOftenrunRoute;
import com.edgedo.bigdata.queryvo.BigdataCarDayOftenrunRouteQuery;
import com.edgedo.bigdata.queryvo.BigdataCarDayOftenrunRouteView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataCarDayOftenrunRouteMapper  extends BaseMapper<BigdataCarDayOftenrunRoute>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarDayOftenrunRouteView> listPage(BigdataCarDayOftenrunRouteQuery query);

	public List<BigdataCarDayOftenrunRouteView> qtlistPage(BigdataCarDayOftenrunRouteQuery query);
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarDayOftenrunRouteView> listByObj(BigdataCarDayOftenrunRouteQuery query);
	
	

}