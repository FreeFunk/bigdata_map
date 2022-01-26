package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiTeamMonth;
import com.edgedo.bigdata.entity.BigdataFenxiTeamWeek;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamWeekView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface BigdataFenxiTeamWeekMapper  extends BaseMapper<BigdataFenxiTeamWeek>{

	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiTeamWeekView> listPage(BigdataFenxiTeamWeekQuery query);

	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiTeamWeekView> listByObj(BigdataFenxiTeamWeekQuery query);


    List<BigdataFenxiTeamWeek> selectByWeekAnQuanQianShi(@Param("carType") String carType,
														 @Param("xianQuId") String xianQuId,
														 @Param("timeChangeWeek") Integer timeChangeWeek);

	List<BigdataFenxiTeamWeek> selectByWeekAnQuanHouShi(@Param("carType") String carType,
														@Param("xianQuId") String xianQuId,
														@Param("timeChangeWeek") Integer timeChangeWeek);

	List<BigdataFenxiTeamWeek> selectByWeekBaiGongLiQianShi(@Param("carType") String carType,
															@Param("xianQuId") String xianQuId,
															@Param("timeChangeWeek") Integer timeChangeWeek);

	List<BigdataFenxiTeamWeek> selectByWeekBaiGongLiHouShi(@Param("carType") String carType,
														   @Param("xianQuId") String xianQuId,
														   @Param("timeChangeWeek") Integer timeChangeWeek);

	public BigdataFenxiTeamWeek selectById(BigdataFenxiTeamWeekQuery query);

	public BigdataFenxiTeamWeek selectByTeamId(BigdataFenxiTeamWeekQuery query);
}