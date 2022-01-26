package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouSpeedAlarmDayCheck;
import com.edgedo.bigdata.queryvo.BigdataBeidouSpeedAlarmDayCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouSpeedAlarmDayCheckView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataBeidouSpeedAlarmDayCheckMapper  extends BaseMapper<BigdataBeidouSpeedAlarmDayCheck>{
	
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
	
	

}