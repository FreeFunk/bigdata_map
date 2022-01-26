package com.edgedo.bigdata.service;
		
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.SysMonitorAlarm;
import com.edgedo.bigdata.mapper.SysMonitorAlarmMapper;
import com.edgedo.bigdata.queryvo.SysMonitorAlarmQuery;
import com.edgedo.bigdata.queryvo.SysMonitorAlarmView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMonitorAlarmService {
	
	
	@Autowired
	private SysMonitorAlarmMapper mapper;

	
	public List<SysMonitorAlarmView> listPage(SysMonitorAlarmQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysMonitorAlarm voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysMonitorAlarm voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysMonitorAlarm voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public int deleteByIds(List<String> ids) {
		
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysMonitorAlarm loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * @Author WangZhen
	 * @Description 统计几分钟内某种报警的产生
	 * @param systemName 系统名称
	 * @param systemModel 模块名
	 * @param alarmType 报警类型
	 * @param  minute 几分钟
	 * @Date 2020/4/24 14:54
	 **/
    public int countByAlaramTypeOfSysRecentMinute(
    		String systemName,String systemModel,String alarmType,int minute) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("systemName",systemName);
		param.put("systemModel",systemModel);
		param.put("alarmType",alarmType);
		param.put("minute",minute);
		return mapper.countByAlaramTypeOfSysRecentMinute(param);

    }

    /**
     * @Author WangZhen
     * @Description 查询那些没有发送的系统监控报警
     * @Date 2020/4/24 16:03
     **/
	public List<SysMonitorAlarm> selectAllNotSendMsgAlarm() {
		return mapper.selectAllNotSendMsgAlarm();
	}
}
