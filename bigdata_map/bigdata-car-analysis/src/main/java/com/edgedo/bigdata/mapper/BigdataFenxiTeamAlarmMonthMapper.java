package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiTeamAlarmMonth;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamAlarmMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamAlarmMonthView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataFenxiTeamAlarmMonthMapper  extends BaseMapper<BigdataFenxiTeamAlarmMonth>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiTeamAlarmMonthView> listPage(BigdataFenxiTeamAlarmMonthQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiTeamAlarmMonthView> listByObj(BigdataFenxiTeamAlarmMonthQuery query);
	
	public List<BigdataFenxiTeamAlarmMonth> selectTopSixByOwnerTeamDayId(BigdataFenxiTeamAlarmMonthQuery query);

    BigdataFenxiTeamAlarmMonth selectByOwnerCarMonthIdAndType(BigdataFenxiTeamAlarmMonth bigdataFenxiTeamAlarmMonth);

	void updateByFenPian(BigdataFenxiTeamAlarmMonth bigdataFenxiTeamAlarmMonth);
}