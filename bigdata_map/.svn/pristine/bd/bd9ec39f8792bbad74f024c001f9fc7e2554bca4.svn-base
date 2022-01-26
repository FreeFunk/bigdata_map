package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiCount;
import com.edgedo.bigdata.queryvo.BigdataFenxiCountQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCountView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface BigdataFenxiCountMapper  extends BaseMapper<BigdataFenxiCount>{
	
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
								  @Param("xianQuId")  String xianQuId,
								  @Param("timeCount") Integer timeCount,
								  @Param("timeType") String timeType);

	BigdataFenxiCount selectByMonth(@Param("carType") String carType,
									@Param("xianQuId") String xianQuId,
									@Param("timeCount") Integer timeCount,
									@Param("timeType") String timeType);

	BigdataFenxiCount selectByWeek(@Param("carType") String carType,
								   @Param("xianQuId") String xianQuId,
								   @Param("timeChangeAge") Integer timeChangeAge,
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
}