package com.edgedo.bigdata.mapper;

import java.util.List;
import java.util.Map;
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

	/**
	 * @Author WangZhen
	 * @Description 最近几分钟的某个类型未处理报警
	 * @Date 2020/4/24 15:03
	 **/
    int countByAlaramTypeOfSysRecentMinute(Map<String, Object> param);
	/**
	 * @Author WangZhen
	 * @Description 查询所有没有发送短信的报警
	 * @Date 2020/4/24 16:04
	 **/
	List<SysMonitorAlarm> selectAllNotSendMsgAlarm();

}