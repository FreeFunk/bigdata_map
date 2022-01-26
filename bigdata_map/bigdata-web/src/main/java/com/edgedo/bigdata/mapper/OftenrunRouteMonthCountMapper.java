package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.OftenrunRouteMonthCount;
import com.edgedo.bigdata.queryvo.OftenrunRouteMonthCountQuery;
import com.edgedo.bigdata.queryvo.OftenrunRouteMonthCountView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface OftenrunRouteMonthCountMapper  extends BaseMapper<OftenrunRouteMonthCount>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<OftenrunRouteMonthCountView> listPage(OftenrunRouteMonthCountQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<OftenrunRouteMonthCountView> listByObj(OftenrunRouteMonthCountQuery query);


    List<OftenrunRouteMonthCountView> getOftenRunRoute(OftenrunRouteMonthCountQuery query);
}