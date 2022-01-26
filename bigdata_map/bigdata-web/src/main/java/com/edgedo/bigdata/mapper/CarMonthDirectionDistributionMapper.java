package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.CarMonthDirectionDistribution;
import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionQuery;
import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface CarMonthDirectionDistributionMapper  extends BaseMapper<CarMonthDirectionDistribution>{
	
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
}