package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouCompDayCheck;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompDayCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompDayCheckView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataBeidouCompDayCheckMapper extends BaseMapper<BigdataBeidouCompDayCheck>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCompDayCheckView> listPage(BigdataBeidouCompDayCheckQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCompDayCheckView> listByObj(BigdataBeidouCompDayCheckQuery query);


    BigdataBeidouCompDayCheck selectByVo(BigdataBeidouCompDayCheck bigdataBeidouCompDayCheck);
}