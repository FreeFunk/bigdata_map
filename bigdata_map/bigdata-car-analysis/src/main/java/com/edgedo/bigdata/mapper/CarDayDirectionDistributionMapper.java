package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.CarDayDirectionDistribution;
import com.edgedo.bigdata.queryvo.CarDayDirectionDistributionQuery;
import com.edgedo.bigdata.queryvo.CarDayDirectionDistributionView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface CarDayDirectionDistributionMapper extends BaseMapper<CarDayDirectionDistribution>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<CarDayDirectionDistributionView> listPage(CarDayDirectionDistributionQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<CarDayDirectionDistributionView> listByObj(CarDayDirectionDistributionQuery query);


    List<CarDayDirectionDistributionView> getDataForCarDirection(CarDayDirectionDistributionQuery query);

	Integer countOtherCarNum(CarDayDirectionDistributionQuery query);

	/**
	 * 统计月份的汇总数据 省份级
	 * @param param
	 * @return
	 */
    List<CarDayDirectionDistributionView> listQuxiangGroupSumOfMonthProvince(Map<String, Object> param);

	/**
	 * 统计月份的汇总数据 城市级
	 * @param param
	 * @return
	 */
    List<CarDayDirectionDistributionView> listQuxiangGroupSumOfMonthCity(Map<String, Object> param);

    //根据主键和分片字段查询
    CarDayDirectionDistribution loadByIdAndDate(Map<String, Object> param);

}