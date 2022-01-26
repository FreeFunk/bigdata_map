package com.edgedo.drawing.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverChangeCarRec;
import com.edgedo.drawing.queryvo.BigdataDriverChangeCarRecQuery;
import com.edgedo.drawing.queryvo.BigdataDriverChangeCarRecView;
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