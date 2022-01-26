package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiTeamAlarmWeek;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamAlarmWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamAlarmWeekView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataFenxiTeamAlarmWeekMapper  extends BaseMapper<BigdataFenxiTeamAlarmWeek>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiTeamAlarmWeekView> listPage(BigdataFenxiTeamAlarmWeekQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiTeamAlarmWeekView> listByObj(BigdataFenxiTeamAlarmWeekQuery query);
	
	public List<BigdataFenxiTeamAlarmWeek> selectTopSixByOwnerTeamDayId(BigdataFenxiTeamAlarmWeekQuery query);

    BigdataFenxiTeamAlarmWeek selectByOwnerCarDayIdAndType(BigdataFenxiTeamAlarmWeek bigdataFenxiTeamAlarmWeek);

	void updateByFenPian(BigdataFenxiTeamAlarmWeek bigdataFenxiTeamAlarmWeek);
}