package com.edgedo.drawing.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverCountDay;
import com.edgedo.drawing.queryvo.BigdataDriverCountDayQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCountDayView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataDriverCountDayMapper  extends BaseMapper<BigdataDriverCountDay>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCountDayView> listPage(BigdataDriverCountDayQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCountDayView> listByObj(BigdataDriverCountDayQuery query);
	
	

}