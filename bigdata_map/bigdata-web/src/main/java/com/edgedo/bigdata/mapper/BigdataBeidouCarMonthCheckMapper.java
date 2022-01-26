package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouCarMonthCheck;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarMonthCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCarMonthCheckView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataBeidouCarMonthCheckMapper  extends BaseMapper<BigdataBeidouCarMonthCheck>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCarMonthCheckView> listPage(BigdataBeidouCarMonthCheckQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCarMonthCheckView> listByObj(BigdataBeidouCarMonthCheckQuery query);
	
	

}