package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiCarAlarmMonth;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarAlarmMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarAlarmMonthView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataFenxiCarAlarmMonthMapper  extends BaseMapper<BigdataFenxiCarAlarmMonth>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarAlarmMonthView> listPage(BigdataFenxiCarAlarmMonthQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarAlarmMonthView> listByObj(BigdataFenxiCarAlarmMonthQuery query);


    BigdataFenxiCarAlarmMonth selectByOwnerCarMonthIdAndType(BigdataFenxiCarAlarmMonth bigdataFenxiCarAlarmMonth);

	void updateByFenPian(BigdataFenxiCarAlarmMonth bigdataFenxiCarAlarmMonth);
}