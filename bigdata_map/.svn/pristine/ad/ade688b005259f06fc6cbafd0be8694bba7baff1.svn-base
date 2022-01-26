package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.MapLocaltionPoint;
import com.edgedo.bigdata.queryvo.MapLocaltionPointQuery;
import com.edgedo.bigdata.queryvo.MapLocaltionPointView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface MapLocaltionPointMapper extends BaseMapper<MapLocaltionPoint>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<MapLocaltionPointView> listPage(MapLocaltionPointQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<MapLocaltionPointView> listByObj(MapLocaltionPointQuery query);


    MapLocaltionPoint selectByXianQuId(Map map);

	Integer countCarNumByCityId(Map map);

	MapLocaltionPoint selectByCityId(Map map);

	Integer countCarNumByProviceId(Map Map);

	MapLocaltionPoint selectByProviceId(Map map);
}