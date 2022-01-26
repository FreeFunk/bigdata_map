package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.queryvo.BigdataCarRealtimeGpsQuery;
import com.edgedo.bigdata.queryvo.BigdataCarRealtimeGpsView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataCarRealtimeGpsMapper  extends BaseMapper<BigdataCarRealtimeGps>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarRealtimeGpsView> listPage(BigdataCarRealtimeGpsQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarRealtimeGpsView> listByObj(BigdataCarRealtimeGpsQuery query);
	
	

}