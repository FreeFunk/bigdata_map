package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouMonthCheckSum;
import com.edgedo.bigdata.queryvo.BigdataBeidouMonthCheckSumQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouMonthCheckSumView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataBeidouMonthCheckSumMapper extends BaseMapper<BigdataBeidouMonthCheckSum>{
	
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


    void updateNew(BigdataBeidouMonthCheckSum bigdataBeidouMonthCheckSum);

	BigdataBeidouMonthCheckSum selectByVo(BigdataBeidouMonthCheckSum bigdataBeidouMonthCheckSum);
}