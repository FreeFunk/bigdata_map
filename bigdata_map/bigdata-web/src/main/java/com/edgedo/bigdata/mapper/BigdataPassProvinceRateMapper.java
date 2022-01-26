package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataPassProvinceRate;
import com.edgedo.bigdata.queryvo.BigdataPassProvinceRateQuery;
import com.edgedo.bigdata.queryvo.BigdataPassProvinceRateView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataPassProvinceRateMapper  extends BaseMapper<BigdataPassProvinceRate>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataPassProvinceRateView> listPage(BigdataPassProvinceRateQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataPassProvinceRateView> listByObj(BigdataPassProvinceRateQuery query);


    BigdataPassProvinceRateView getPassProvinceRate(BigdataPassProvinceRateQuery query);
}