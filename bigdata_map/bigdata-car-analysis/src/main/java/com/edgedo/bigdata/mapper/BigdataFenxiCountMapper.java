package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiCount;
import com.edgedo.bigdata.queryvo.BigdataFenxiCountQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCountView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface BigdataFenxiCountMapper extends BaseMapper<BigdataFenxiCount>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCountView> listPage(BigdataFenxiCountQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCountView> listByObj(BigdataFenxiCountQuery query);



    BigdataFenxiCount selectByCarTypeAndXianQuIdAndTimeCount(@Param("carType") String carType,
                                                             @Param("xianQuId") String xianQuId,
                                                             @Param("dateNum") Integer dateNum,
                                                             @Param("timeType") String timeType);

    BigdataFenxiCount selectByDay(@Param("carType") String carType,
                                  @Param("xianQuId") String xianQuId,
                                  @Param("timeCount") Integer timeCount,
                                  @Param("timeType") String timeType);

	BigdataFenxiCount selectByMonth(@Param("carType") String carType,
                                    @Param("xianQuId") String xianQuId,
                                    @Param("timeCount") Integer timeCount,
                                    @Param("timeType") String timeType);

	BigdataFenxiCount selectByWeek(@Param("carType") String carType,
                                   @Param("xianQuId") String xianQuId,
                                   @Param("timeChangeAge") String timeChangeAge,
                                   @Param("timeChangeWeek") Integer timeChangeWeek,
                                   @Param("timeType") String timeType);

    List<BigdataFenxiCount> selectByTime(@Param("bettTime") Integer bettTime,
                                         @Param("currTime") Integer currTime,
                                         @Param("carType") String carType,
                                         @Param("xianQuId") String xianQuId,
                                         @Param("timeType") String timeType);

	List<BigdataFenxiCount> selectByTimeMonth(@Param("firstArr") Integer firstArr,
                                              @Param("lastArr") Integer lastArr,
                                              @Param("carType") String carType,
                                              @Param("xianQuId") String xianQuId,
                                              @Param("timeType") String timeType);

    List<BigdataFenxiCount> selectAll(@Param("yearNum") Integer yearNum,
									  @Param("countMonth") Integer countMonth,
									  @Param("countDay")Integer countDay,
									  @Param("countType")String countType);

	List<BigdataFenxiCount> selectXianQuAndTimeAll(@Param("timeType")String timeType,
												@Param("startTime")Integer startTime,
												   @Param("endTime")Integer endTime,
												@Param("countType")String countType,
												@Param("xianQu")String xianQu);

	List<BigdataFenxiCount> selectCityAndTimeAll(@Param("timeType")String timeType,
												 @Param("startTime")Integer startTime,
												 @Param("endTime")Integer endTime,
												 @Param("city")String city);

	List<BigdataFenxiCount> selectXianQuAndTime(@Param("timeType")String timeType,
												@Param("startTime")Integer startTime,
												@Param("endTime")Integer endTime,
												   @Param("countType")String countType,
												   @Param("xianQu")String xianQu);

	List<BigdataFenxiCount> selectCityAndTime(@Param("timeType")String timeType,
											  @Param("startTime")Integer startTime,
											  @Param("endTime")Integer endTime,
												 @Param("city")String city);

	List<BigdataFenxiCount> selectXianQuAndMonth(@Param("timeType")String timeType,
													@Param("yearNum")Integer yearNum,
												 @Param("countMonth")Integer countMonth,
												 @Param("countType")String countType,
												 @Param("xianQu")String xianQu);

	List<BigdataFenxiCount> selectCityAndMonth(@Param("timeType")String timeType,
											   @Param("yearNum")Integer yearNum,
											   @Param("countMonth")Integer countMonth,
											   @Param("city")String city);

	List<BigdataFenxiCount> selectXianQuAndMonthAll(@Param("timeType")String timeType,
												 @Param("yearNum")Integer yearNum,
												 @Param("countMonth")Integer countMonth,
												 @Param("countType")String countType,
												 @Param("xianQu")String xianQu);

	List<BigdataFenxiCount> selectCityAndMonthAll(@Param("timeType")String timeType,
											   @Param("yearNum")Integer yearNum,
											   @Param("countMonth")Integer countMonth,
											   @Param("city")String city);

    Integer selectByInfo(@Param("xianQuId")String xianQuId,
    		@Param("carType")String carType,
					 @Param("countDay")Integer countDay,
					 @Param("countMonth")Integer countMonth,
					 @Param("yearNum")Integer yearNum,
					 @Param("countType")String countType,
					 @Param("timeType")String timeType);

	Integer selectByInfoWeek(@Param("xianQuId")String xianQuId,
						 @Param("carType")String carType,
						 @Param("countDay")Integer countDay,
						 @Param("countMonth")Integer countMonth,
						 @Param("yearNum")Integer yearNum,
						 @Param("countType")String countType,
						 @Param("timeType")String timeType,
							 @Param("week")Integer week	 );

	void updateByInfo(BigdataFenxiCount bigdataFenxiCount);

	Integer selectByInfoDay(@Param("xianQuId")String xianQuId,
						 @Param("carType")String carType,
						 @Param("countDay")Integer countDay,
						 @Param("countMonth")Integer countMonth,
						 @Param("yearNum")Integer yearNum,
						 @Param("countType")String countType,
						 @Param("timeType")String timeType);

	void updateByInfoWeek(BigdataFenxiCount bigdataFenxiCount);

    void updateByInfoMonth(BigdataFenxiCount bigdataFenxiCount);
}