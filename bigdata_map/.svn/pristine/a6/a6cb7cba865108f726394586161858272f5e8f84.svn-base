package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiCarWeek;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarWeekView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface BigdataFenxiCarWeekMapper  extends BaseMapper<BigdataFenxiCarWeek>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarWeekView> listPage(BigdataFenxiCarWeekQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarWeekView> listByObj(BigdataFenxiCarWeekQuery query);


    List<BigdataFenxiCarWeek> selectByWeekQianShi(@Param("carType") String carType,
												  @Param("xianQuId") String xianQuId,
												  @Param("timeChangeAge") Integer timeChangeAge,
												  @Param("timeChangeWeek") Integer timeChangeWeek,
												  @Param("countMonth") Integer countMonth);

	List<BigdataFenxiCarWeek> selectByWeekHouShi(@Param("carType") String carType,
												 @Param("xianQuId") String xianQuId,
												 @Param("timeChangeAge") Integer timeChangeAge,
												 @Param("timeChangeWeek") Integer timeChangeWeek,
												 @Param("countMonth") Integer countMonth);

	public BigdataFenxiCarWeek selectById(BigdataFenxiCarWeekQuery query);

	public List<BigdataFenxiCarWeek> selectTopTenRunMileageByTeamId(BigdataFenxiCarWeekQuery query);

	public List<BigdataFenxiCarWeek> selectTopTenAlarmNumByTeamId(BigdataFenxiCarWeekQuery query);

}