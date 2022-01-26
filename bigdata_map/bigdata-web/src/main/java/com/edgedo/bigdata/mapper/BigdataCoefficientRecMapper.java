package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataCoefficientRec;
import com.edgedo.bigdata.queryvo.BigdataCoefficientRecQuery;
import com.edgedo.bigdata.queryvo.BigdataCoefficientRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataCoefficientRecMapper  extends BaseMapper<BigdataCoefficientRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCoefficientRecView> listPage(BigdataCoefficientRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCoefficientRecView> listByObj(BigdataCoefficientRecQuery query);


    BigdataCoefficientRecView getCoefficientNum(BigdataCoefficientRecQuery query);
}