package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiCarAlarmWeek;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarAlarmWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarAlarmWeekView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataFenxiCarAlarmWeekMapper  extends BaseMapper<BigdataFenxiCarAlarmWeek>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarAlarmWeekView> listPage(BigdataFenxiCarAlarmWeekQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarAlarmWeekView> listByObj(BigdataFenxiCarAlarmWeekQuery query);


    BigdataFenxiCarAlarmWeek selectByOwnerCarDayIdAndType(BigdataFenxiCarAlarmWeek bigdataFenxiCarAlarmWeek);

	void updateByFenPian(BigdataFenxiCarAlarmWeek bigdataFenxiCarAlarmWeek);
}