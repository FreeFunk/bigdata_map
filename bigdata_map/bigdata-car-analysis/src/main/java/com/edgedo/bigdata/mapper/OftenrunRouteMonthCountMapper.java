package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.OftenrunRouteMonthCount;
import com.edgedo.bigdata.queryvo.OftenrunRouteMonthCountQuery;
import com.edgedo.bigdata.queryvo.OftenrunRouteMonthCountView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface OftenrunRouteMonthCountMapper extends BaseMapper<OftenrunRouteMonthCount>{
	
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

	/**
	 * 根据季度和车辆类型做季度分组统计
	 * @param param
	 * @return
	 */
    List<OftenrunRouteMonthCount> selectGroupSumOfQuarter(Map<String, Object> param);

	/**
	 * 根据分片的年份和主键获得记录
	 * @param param
	 * @return
	 */
	OftenrunRouteMonthCount loadByIdByDate(Map<String, Object> param);

}