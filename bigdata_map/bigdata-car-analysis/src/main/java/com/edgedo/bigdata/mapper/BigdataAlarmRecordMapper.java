package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.AlarmVo;
import com.edgedo.bigdata.entity.BigdataAlarmRecord;
import com.edgedo.bigdata.entity.BigdataDangerRoadClsMonth;
import com.edgedo.bigdata.entity.CarListVo;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataAlarmRecordMapper extends BaseMapper<BigdataAlarmRecord>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataAlarmRecordView> listPage(BigdataAlarmRecordQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataAlarmRecordView> listByObj(BigdataAlarmRecordQuery query);

	/**
	 * 根据公司id和业务id统计数量
	 * @param param
	 * @return
	 */
    int countByCompIdAndBid(Map<String, Object> param);


    int countByQuery(BigdataAlarmRecordQuery query);

	int countOtherRoadOverSpeedNum(BigdataAlarmRecordQuery query);

	Integer sumByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery);

	int sumOtherRoadOverSpeedNum(BigdataAlarmRecordQuery bigdataAlarmRecordQuery);

	List<Integer>  countByQueryNew(BigdataAlarmRecordQuery bigdataAlarmRecordQuery);

	int countSeriousByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery);

	Integer sumSeriousByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery);
	//查询几个没有位置查询的报警记录
    List<BigdataAlarmRecord> listUnLocationAlarm(Map<String,Object> param);
	//根据联合主键查询
    BigdataAlarmRecord loadByIdAndAlarmDate(Map<String, Object> param);
	//根据分片字段和主键修改
	int updateByFenPian(BigdataAlarmRecord param);
	//根据日期和月份分组统计
    List<BigdataDangerRoadClsMonth> selectGroupCountOfDangerRoad(Map<String, Object> param);

	List<Integer> countSeriousByQueryNew(BigdataAlarmRecordQuery bigdataAlarmRecordQuery);

	List<CarListVo> selectSeriousCarListByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery);

	List<String> countCarNumByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery);
	//统计某辆车的
    int countDayOverSpeedOfCar(Map<String, Object> param);
	//统计某辆车的疲劳次数
	int countDayFatigueOfCar(Map<String, Object> param);
	//统计某辆车的高速超速次数
	int countDayHighWayOverSpeedOfCar(Map<String, Object> param);
	//统计某辆车国道的超速次数
	int countDayGuodaoWayOverSpeedOfCar(Map<String, Object> param);
	//统计某辆车某天的严重超速次数
	int countDaySeriousWayOverSpeedOfCar(Map<String, Object> param);
	//统计某辆车某天的危险时段超速次数
	int countDayDangerWayOverSpeedOfCar(Map<String, Object> param);
	//统计危险时段疲劳次数
	int countDayDangerFatigueOfCar(Map<String, Object> param);
	//更具条件分组统计
    List<BigdataAlarmRecordView> selectGroupCountByCondition(Map<String, Object> param);

    int countByCompId(Map<String, Object> map);

	int countByCarPlateNum(Map<String, Object> map);

    List<AlarmVo> countByCarType(Map<String, Object> map);

	List<AlarmVo> countByCarTypeMonth(Map<String, Object> map);

    List<AlarmVo> countByTeamTransitType(Map<String, Object> map);

    int countHandleNumByCarPlateNum(Map<String, Object> map);

    int selectAlarmNumAndHandlerDay(@Param("yearNum") Integer yearNum,
									@Param("countMonth")Integer countMonth,
									@Param("countDay")Integer countDay,
									@Param("startTime")String startTime,
									@Param("endTime")String endTime);

    int selectAlarm(@Param("yearNum")Integer yearNum,
					@Param("countMonth")Integer countMonth,
					@Param("countDay")Integer countDay,
					@Param("xianQuId")String xianQuId,
					@Param("carType")String carType,
					@Param("startTime")String startTime,
					@Param("endTime")String endTime);

	int selectHandler(@Param("yearNum")Integer yearNum,
					  @Param("countMonth")Integer countMonth,
					  @Param("countDay")Integer countDay,
					  @Param("xianQuId")String xianQuId,
					  @Param("carType")String carType,
					  @Param("startTime")String startTime,
					  @Param("endTime")String endTime);

	Map<String, String> selectCountType(@Param("countMonth")Integer countMonth,
										@Param("countDay")Integer countDay,
										@Param("xianQuId")String xianQuId,
										@Param("carType")String carType);

	List<AlarmVo> countByTeamTransitTypeMonth(Map<String, Object> map);

	List<AlarmVo> countByTeamTransitTypeTopThree(Map<String, Object> map);

	List<AlarmVo> countByTeamTransitTypeTopThreeNew(Map<String, Object> map1);

	List<AlarmVo> countByTeamTransitTypeTopThreeMonth(Map<String, Object> map1);

	List<AlarmVo> countByTeamTransitTypeTopThreeMonthNew(Map<String, Object> map1);

    int selectAlarmTypeCountByQuery(BigdataAlarmRecordQuery query);

	int countById(BigdataAlarmRecord bigdataAlarmRecord);

    List<BigdataAlarmRecord> selectDataForFake(Map<String, Object> map);

    List<BigdataAlarmRecord> selectDataForFakeNew();

    int countOverSpeedNum(Map<String, Object> map);

	int countSeriousOverSpeedNum(Map<String, Object> map);

	int countFatigueNum(Map<String, Object> map);

    int countSumNumByCompId(Map<String, Object> map);

	List<BigdataAlarmRecord> selectGroupEmpId(Map<String, Object> map);

	List<String> countNotOverSpeedCarNumByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery);

	int sumNotOverSpeedByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery);

	List<String> countNotCarNumByQuery(BigdataAlarmRecordQuery bigdataAlarmRecordQuery);
}