package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouCompMonthCheck;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompMonthCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompMonthCheckView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataBeidouCompMonthCheckMapper extends BaseMapper<BigdataBeidouCompMonthCheck>{
	
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


    BigdataBeidouCompMonthCheck selectByVo(BigdataBeidouCompMonthCheck bigdataBeidouCompMonthCheck);

    void updateNew(BigdataBeidouCompMonthCheck voObj);

    List<BigdataBeidouCompMonthCheckView> listBySearchDate(Map<String, Object> map);

}