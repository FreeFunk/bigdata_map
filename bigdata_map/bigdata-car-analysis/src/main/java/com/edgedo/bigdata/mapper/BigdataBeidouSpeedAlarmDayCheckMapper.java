package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouSpeedAlarmDayCheck;
import com.edgedo.bigdata.queryvo.BigdataBeidouSpeedAlarmDayCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouSpeedAlarmDayCheckView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataBeidouSpeedAlarmDayCheckMapper extends BaseMapper<BigdataBeidouSpeedAlarmDayCheck>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouSpeedAlarmDayCheckView> listPage(BigdataBeidouSpeedAlarmDayCheckQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouSpeedAlarmDayCheckView> listByObj(BigdataBeidouSpeedAlarmDayCheckQuery query);


    BigdataBeidouSpeedAlarmDayCheck selectByVo(BigdataBeidouSpeedAlarmDayCheck bigdataBeidouSpeedAlarmDayCheck);

	void updateNew(BigdataBeidouSpeedAlarmDayCheck bigdataBeidouSpeedAlarmDayCheck);

	int countSpeedAlarm(Map<String, Object> param8);
}