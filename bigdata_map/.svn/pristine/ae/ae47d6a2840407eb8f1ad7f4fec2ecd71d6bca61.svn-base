package com.edgedo.drawing.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverCountMonthAndYear;
import com.edgedo.drawing.queryvo.BigdataDriverCountMonthAndYearQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCountMonthAndYearView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataDriverCountMonthAndYearMapper  extends BaseMapper<BigdataDriverCountMonthAndYear>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCountMonthAndYearView> listPage(BigdataDriverCountMonthAndYearQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCountMonthAndYearView> listByObj(BigdataDriverCountMonthAndYearQuery query);
	
	public BigdataDriverCountMonthAndYearView selectVoByDriverId(BigdataDriverCountMonthAndYearQuery query);

}