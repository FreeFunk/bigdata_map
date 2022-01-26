package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouMonthCheckSum;
import com.edgedo.bigdata.queryvo.BigdataBeidouMonthCheckSumQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouMonthCheckSumView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataBeidouMonthCheckSumMapper  extends BaseMapper<BigdataBeidouMonthCheckSum>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouMonthCheckSumView> listPage(BigdataBeidouMonthCheckSumQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouMonthCheckSumView> listByObj(BigdataBeidouMonthCheckSumQuery query);


    BigdataBeidouMonthCheckSum getBeidouMonthCheckSum(BigdataBeidouMonthCheckSumQuery query);
}