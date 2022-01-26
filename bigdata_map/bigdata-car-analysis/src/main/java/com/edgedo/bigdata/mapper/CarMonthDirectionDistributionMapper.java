package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.CarMonthDirectionDistribution;
import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionQuery;
import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface CarMonthDirectionDistributionMapper extends BaseMapper<CarMonthDirectionDistribution>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<CarMonthDirectionDistributionView> listPage(CarMonthDirectionDistributionQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<CarMonthDirectionDistributionView> listByObj(CarMonthDirectionDistributionQuery query);


    List<CarMonthDirectionDistributionView> getOftenRunProvince(CarMonthDirectionDistributionQuery query);

    List<CarMonthDirectionDistributionView> getOftenRunCity(CarMonthDirectionDistributionQuery query);

	/**
	 * 在月度汇总的基础上攫取季度汇总
	 * @param param
	 * @return
	 */
    List<CarMonthDirectionDistributionView> listQuxiangGroupSumOfJiduProvince(Map<String,Object> param);

	/**
	 * 在月度汇总的基础上攫取季度汇总
	 * @param param
	 * @return
	 */
    List<CarMonthDirectionDistributionView> listQuxiangGroupSumOfJiduCity(Map<String, Object> param);


}