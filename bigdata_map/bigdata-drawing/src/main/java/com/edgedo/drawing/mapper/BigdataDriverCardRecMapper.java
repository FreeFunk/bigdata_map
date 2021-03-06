package com.edgedo.drawing.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverCardRec;
import com.edgedo.drawing.queryvo.BigdataDriverCardRecQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCardRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataDriverCardRecMapper  extends BaseMapper<BigdataDriverCardRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCardRecView> listPage(BigdataDriverCardRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCardRecView> listByObj(BigdataDriverCardRecQuery query);
	
	

}