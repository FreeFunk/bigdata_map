package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataLinshiBatch;
import com.edgedo.bigdata.queryvo.BigdataLinshiBatchQuery;
import com.edgedo.bigdata.queryvo.BigdataLinshiBatchView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataLinshiBatchMapper  extends BaseMapper<BigdataLinshiBatch>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataLinshiBatchView> listPage(BigdataLinshiBatchQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataLinshiBatchView> listByObj(BigdataLinshiBatchQuery query);
	
	

}