package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecView;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataTimeCarDayRecMapper  extends BaseMapper<BigdataTimeCarDayRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataTimeCarDayRecView> listPage(BigdataTimeCarDayRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataTimeCarDayRecView> listByObj(BigdataTimeCarDayRecQuery query);

	//根据车辆类型分组统计 某天的汇总数据
    List<BigdataTimeCarDayRec> sumGroupByCarType(Integer countDate);
	//月度第一时段的统计
	List<BigdataTimeCarDayRec>  selectSumGroupCarInfoMonthFirstCount(Map<String, Object> param);
	//月度第二时段的统计
	List<BigdataTimeCarDayRec>  selectSumGroupCarInfoMonthSecondCount(Map<String, Object> param);
	//月度第三时段的统计
	List<BigdataTimeCarDayRec>  selectSumGroupCarInfoMonthThirdCount(Map<String, Object> param);
	//根据主键和分片字段查询
    BigdataTimeCarDayRec loadByIdAndDate(Map<String, Object> param);

	List<BigdataTimeCarDayRec> sumGroupByCarTypeOfDay(Map<String,Object> param);
	//有分片的修改
    void updateByFenPian(BigdataTimeCarDayRec dayHistory);
	//从业人员的报警统计
    List<BigdataMonthEmpAlarmSum> selectGroupSumInfoForEmpAlarm(Map<String, Object> param);

	BigdataFenxiCarWeek countMileageByWeek(Map<String, Object> map);

    BigdataFenxiCarMonth countMileageByMonth(Map<String, Object> map);

	List<BigdataTimeCarDayRec> selectByTeamId(@Param("id")String id, @Param("yearNum")Integer yearNum,
											  @Param("countMonth") Integer countMonth, @Param("countDay")Integer countDay);

    List<BigdataTimeCarDayRec> selectByDate(@Param("yearNum") Integer yearNum,
											@Param("countMonth") Integer countMonth,
											@Param("countDay") Integer countDay);

    Integer selectAlarmNum(@Param("countDay")Integer countDay,
						   @Param("countMonth")Integer countMonth,
						   @Param("yearNum")Integer yearNum,
						   @Param("carType")String carType);

	Integer selectCompNum(@Param("countDay")Integer countDay,
						  @Param("countMonth")Integer countMonth,
						  @Param("yearNum")Integer yearNum,
						  @Param("carType")String carType);

	Integer selectAlarmNumXianQu(@Param("xianQuId")String xianQuId,@Param("countDay")Integer countDay,
						  @Param("countMonth")Integer countMonth,
						  @Param("yearNum")Integer yearNum,@Param("carType")String carType);

	Integer selectCompNumXianQu(@Param("xianQuId")String xianQuId,@Param("countDay")Integer countDay,
						  @Param("countMonth")Integer countMonth,
						  @Param("yearNum")Integer yearNum,
								@Param("carType")String carType);

	Integer selectAlarmNumXianQuAll(@Param("xianQuId")String xianQuId,@Param("countDay")Integer countDay,
								 @Param("countMonth")Integer countMonth,
								 @Param("yearNum")Integer yearNum);

	Integer selectCompNumXianQuAll(@Param("xianQuId")String xianQuId,@Param("countDay")Integer countDay,
								@Param("countMonth")Integer countMonth,
								@Param("yearNum")Integer yearNum);

    List<BigdataTimeCarDayRec> selectByWeekCountRunMileageTop(Map<String, Object> map);

	List<BigdataTimeCarDayRec> selectByMonthCountRunMileageTop(Map<String, Object> map);
	List<BigdataTimeCarDayRec> selectByMonthCountAlarmTop(Map<String, Object> map);

	Integer selectWeekCarNum(@Param("carNum")String carNum,
							 @Param("teamId")String teamId,
							 @Param("beginDate")Date beginDate,
							 @Param("endDate")Date endDate,
							 @Param("countMonth")Integer countMonth,
							 @Param("weekYear")Integer weekYear);

	BigDecimal selectWeekCarNumLiCheng(@Param("carNum")String carNum,
										@Param("teamId")String teamId,
									   @Param("beginDate")Date beginDate,
									   @Param("endDate")Date endDate,
									   @Param("countMonth")Integer countMonth,
									   @Param("weekYear")Integer weekYear);

	BigDecimal selecMonthCarNumLiCheng(@Param("carNum")String carNum,
									   @Param("teamId")String teamId,
									   @Param("countMonth")Integer countMonth,
									   @Param("yearNum")Integer yearNum);

	Integer selectMonthCarNum(@Param("carNum")String carNum,
							  @Param("teamId")String teamId,
							  @Param("countMonth")Integer countMonth,
							  @Param("yearNum")Integer yearNum);


	Map<String, Object> countNum(@Param("teamId") String teamId,
								  @Param("yearNum")Integer yearNum,
								  @Param("countMonth")Integer countMonth,
								  @Param("countDay")Integer countDay);

    Map<String, Object> selectCountNum(@Param("carType")String carType,
									   @Param("xianQuId")String xianQuId,
									   @Param("yearNum")Integer yearNum,
									   @Param("countMonth")Integer countMonth,
									   @Param("countDay")Integer countDay);

	int countCarNumByTeamId(Map<String, Object> map);

	List<BigdataTimeCarDayRec> selectRunMileageTopThree(Map<String, Object> map);

	List<BigdataTimeCarDayRec> selectAlarmNumTopThree(Map<String, Object> map);

	List<BigdataTimeCarDayRec> selectByWeekCountAlarmTop(Map<String, Object> map);
	//查询某天的有过行驶记录的车辆的id
    List<String> selectOperatedCarIdsOfDay(Map<String, Object> map);

}