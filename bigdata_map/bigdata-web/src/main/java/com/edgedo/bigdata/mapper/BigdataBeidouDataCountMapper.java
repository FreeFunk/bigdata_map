package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouDataCount;
import com.edgedo.bigdata.queryvo.BigdataBeidouDataCountQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouDataCountView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataBeidouDataCountMapper  extends BaseMapper<BigdataBeidouDataCount>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouDataCountView> listPage(BigdataBeidouDataCountQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouDataCountView> listByObj(BigdataBeidouDataCountQuery query);


    BigdataBeidouDataCountView getbeidouInCountData(BigdataBeidouDataCountQuery query);
}