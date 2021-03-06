package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiCarMonth;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarMonthView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface BigdataFenxiCarMonthMapper  extends BaseMapper<BigdataFenxiCarMonth>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarMonthView> listPage(BigdataFenxiCarMonthQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarMonthView> listByObj(BigdataFenxiCarMonthQuery query);


    List<BigdataFenxiCarMonth> selectByMonthQianShi(@Param("carType") String carType, @Param("xianQuId")String xianQuId, @Param("timeCount")Integer timeCount, @Param("timeType")String timeType);

	List<BigdataFenxiCarMonth> selectByMonthHouShi(@Param("carType") String carType, @Param("xianQuId")String xianQuId, @Param("timeCount")Integer timeCount, @Param("timeType")String timeType);

	public BigdataFenxiCarMonth selectById(BigdataFenxiCarMonthQuery query);

	public List<BigdataFenxiCarMonth> selectTopTenRunMileageByTeamId(BigdataFenxiCarMonthQuery query);

	public List<BigdataFenxiCarMonth> selectTopTenAlarmNumByTeamId(BigdataFenxiCarMonthQuery query);

}