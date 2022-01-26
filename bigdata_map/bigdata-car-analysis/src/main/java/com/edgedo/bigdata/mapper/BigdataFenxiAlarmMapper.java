package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiAlarm;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataFenxiAlarmMapper extends BaseMapper<BigdataFenxiAlarm>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiAlarmView> listPage(BigdataFenxiAlarmQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiAlarmView> listByObj(BigdataFenxiAlarmQuery query);


	List<BigdataFenxiAlarm> selectByDay(String carType, String xianQuId, Integer timeCount, String timeType);

	List<BigdataFenxiAlarm> selectByWeek(String carType, String xianQuId, Integer timeChangeAge, Integer timeChangeWeek, String timeType);

	List<BigdataFenxiAlarm> selectByMonth(String carType, String xianQuId, Integer timeCount, String timeType);

	BigdataFenxiAlarm selectVoForWeekOrMonth(BigdataFenxiAlarmQuery query);
}