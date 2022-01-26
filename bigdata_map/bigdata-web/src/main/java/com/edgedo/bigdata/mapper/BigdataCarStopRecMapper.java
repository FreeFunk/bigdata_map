package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataCarStopRec;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecQuery;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataCarStopRecMapper  extends BaseMapper<BigdataCarStopRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarStopRecView> listPage(BigdataCarStopRecQuery query);

	public List<BigdataCarStopRecView> qtlistPage(BigdataCarStopRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarStopRecView> listByObj(BigdataCarStopRecQuery query);


	public List<BigdataCarStopRecView> countCarStopRec(BigdataCarStopRecQuery query);
}