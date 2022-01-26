package com.edgedo.drawing.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverStopRec;
import com.edgedo.drawing.queryvo.BigdataDriverStopRecQuery;
import com.edgedo.drawing.queryvo.BigdataDriverStopRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataDriverStopRecMapper  extends BaseMapper<BigdataDriverStopRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverStopRecView> listPage(BigdataDriverStopRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverStopRecView> listByObj(BigdataDriverStopRecQuery query);
	
	

}