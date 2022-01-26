package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.CarDayDirectionDistribution;
import com.edgedo.bigdata.queryvo.CarDayDirectionDistributionQuery;
import com.edgedo.bigdata.queryvo.CarDayDirectionDistributionView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface CarDayDirectionDistributionMapper  extends BaseMapper<CarDayDirectionDistribution>{
	
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

	Integer countSumCarNum(CarDayDirectionDistributionQuery query);
}