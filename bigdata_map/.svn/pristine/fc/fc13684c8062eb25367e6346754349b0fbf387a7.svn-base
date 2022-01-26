package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouCompMonthCheck;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompMonthCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompMonthCheckView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataBeidouCompMonthCheckMapper  extends BaseMapper<BigdataBeidouCompMonthCheck>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCompMonthCheckView> listPage(BigdataBeidouCompMonthCheckQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCompMonthCheckView> listByObj(BigdataBeidouCompMonthCheckQuery query);


    List listForBeidouCompMonthData(BigdataBeidouCompMonthCheckQuery query);
}