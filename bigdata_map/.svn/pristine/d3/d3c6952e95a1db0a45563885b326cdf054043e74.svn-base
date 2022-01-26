package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.SysMonitorAlarm;
import com.edgedo.bigdata.queryvo.SysMonitorAlarmQuery;
import com.edgedo.bigdata.queryvo.SysMonitorAlarmView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface SysMonitorAlarmMapper  extends BaseMapper<SysMonitorAlarm>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysMonitorAlarmView> listPage(SysMonitorAlarmQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysMonitorAlarmView> listByObj(SysMonitorAlarmQuery query);
	
	

}