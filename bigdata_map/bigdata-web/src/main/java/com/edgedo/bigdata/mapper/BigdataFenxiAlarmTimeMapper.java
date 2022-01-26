package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiAlarmTime;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmTimeQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmTimeView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataFenxiAlarmTimeMapper  extends BaseMapper<BigdataFenxiAlarmTime>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiAlarmTimeView> listPage(BigdataFenxiAlarmTimeQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiAlarmTimeView> listByObj(BigdataFenxiAlarmTimeQuery query);


	List<BigdataFenxiAlarmTime> selectByDay(String carType, String xianQuId, Integer timeCount, String timeType);
}