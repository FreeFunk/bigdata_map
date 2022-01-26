package com.edgedo.drawing.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverCountMonthAndYear;
import com.edgedo.drawing.queryvo.BigdataDriverCountMonthAndYearQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCountMonthAndYearView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataDriverCountMonthAndYearMapper extends BaseMapper<BigdataDriverCountMonthAndYear>{
	
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


    BigdataDriverCountMonthAndYear selectByVo(Map<String, Object> map);

    /**
     * @Author WangZhen
     * @Description 汇总司机某个月的情况
     * @Date 2020/2/6 15:38
     **/
    BigdataDriverCountMonthAndYearView sumDriverCountDayInfoForMonth(Map<String, Object> param);

    /**
     * @Author WangZhen
     * @Description  根据主键和分片字段统计
     * @Date 2020/2/6 17:06
     **/
	int countByIdAndFenpian(BigdataDriverCountMonthAndYearView driverMonthCount);
	/**
	 * @Author WangZhen
	 * @Description 根据主键和分片字段修改数据
	 * @Date 2020/2/6 17:15
	 **/
	int updateByIdAndFenpian(BigdataDriverCountMonthAndYearView driverMonthCount);

	/**
	 * @Author WangZhen
	 * @Description
	 * @Date 2020/2/7 8:47
	 **/
    BigdataDriverCountMonthAndYearView sumDriverCountMonthInfoForYear(Map<String, Object> param);

}