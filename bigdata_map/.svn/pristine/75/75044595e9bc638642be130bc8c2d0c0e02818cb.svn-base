package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.MapLocaltionPoint;
import com.edgedo.bigdata.queryvo.MapLocaltionPointQuery;
import com.edgedo.bigdata.queryvo.MapLocaltionPointView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface MapLocaltionPointMapper  extends BaseMapper<MapLocaltionPoint>{
	
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


    List<MapLocaltionPointView> list(MapLocaltionPointQuery query);
}