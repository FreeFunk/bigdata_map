package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiAlarmTime;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmTimeQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmTimeView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface BigdataFenxiAlarmTimeMapper extends BaseMapper<BigdataFenxiAlarmTime>{
	
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

    int selectByCount(@Param("yearNum")Integer yearNum,
    					@Param("countMonth")Integer countMonth,
					  @Param("countDay")Integer countDay,
					  @Param("xianQuId")String xianQuId,
					  @Param("carType")String carType,@Param("dataType")String dataType,@Param("alarmType")String alarmType);


	int selectByCountChangGui(@Param("yearNum")Integer yearNum,
					  @Param("countMonth")Integer countMonth,
					  @Param("countDay")Integer countDay,
					  @Param("xianQuId")String xianQuId,
					  @Param("carType")String carType,@Param("dataType")String dataType,@Param("alarmType")String alarmType);


	int selectByCountAll(@Param("yearNum")Integer yearNum,
							  @Param("countMonth")Integer countMonth,
							  @Param("countDay")Integer countDay,
							  @Param("xianQuId")String xianQuId,
							  @Param("carType")String carType,@Param("dataType")String dataType,@Param("alarmType")String alarmType);

	void updateRecord(BigdataFenxiAlarmTime bigdataFenxiAlarmTime);

}