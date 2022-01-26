package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataDriverChangeCarRec;
import com.edgedo.bigdata.queryvo.BigdataDriverChangeCarRecQuery;
import com.edgedo.bigdata.queryvo.BigdataDriverChangeCarRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataDriverChangeCarRecMapper  extends BaseMapper<BigdataDriverChangeCarRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverChangeCarRecView> listPage(BigdataDriverChangeCarRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverChangeCarRecView> listByObj(BigdataDriverChangeCarRecQuery query);
	
	

}