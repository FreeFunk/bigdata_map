package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataDangerRoadClsMonth;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadClsMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadClsMonthView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataDangerRoadClsMonthMapper extends BaseMapper<BigdataDangerRoadClsMonth>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDangerRoadClsMonthView> listPage(BigdataDangerRoadClsMonthQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDangerRoadClsMonthView> listByObj(BigdataDangerRoadClsMonthQuery query);

	/**
	 * 汇总危险路段之后的总数
	 * @return
	 */
    List<BigdataDangerRoadClsMonth> selectGroupByDangerRoadName();

}