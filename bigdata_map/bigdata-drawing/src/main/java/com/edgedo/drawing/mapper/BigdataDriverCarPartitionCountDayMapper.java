package com.edgedo.drawing.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverCarPartitionCountDay;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataDriverCarPartitionCountDayMapper  extends BaseMapper<BigdataDriverCarPartitionCountDay>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCarPartitionCountDayView> listPage(BigdataDriverCarPartitionCountDayQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCarPartitionCountDayView> listByObj(BigdataDriverCarPartitionCountDayQuery query);
	
	

}