package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiCarMonth;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarMonthView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataFenxiCarMonthMapper  extends BaseMapper<BigdataFenxiCarMonth>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarMonthView> listPage(BigdataFenxiCarMonthQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarMonthView> listByObj(BigdataFenxiCarMonthQuery query);


    List<BigdataFenxiCarMonth> selectByMonthQianShi(String carType, String xianQuId, Integer timeCount, String timeType);

	List<BigdataFenxiCarMonth> selectByMonthHouShi(String carType, String xianQuId, Integer timeCount, String timeType);

    BigdataFenxiCarMonth selectByFenqu(Map<String, Object> map);

	void updateByfenPian(BigdataFenxiCarMonth bigdataFenxiCarMonth);
}