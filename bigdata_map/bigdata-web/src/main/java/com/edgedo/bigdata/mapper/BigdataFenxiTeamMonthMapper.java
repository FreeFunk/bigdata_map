package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiTeamMonth;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamMonthView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface BigdataFenxiTeamMonthMapper  extends BaseMapper<BigdataFenxiTeamMonth>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiTeamMonthView> listPage(BigdataFenxiTeamMonthQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiTeamMonthView> listByObj(BigdataFenxiTeamMonthQuery query);


	List<BigdataFenxiTeamMonth> selectByMonthAnQuanQianShi(@Param("carType") String carType, @Param("xianQuId") String xianQuId, @Param("timeCount") Integer timeCount);
	List<BigdataFenxiTeamMonth> selectByMonthAnQuanHouShi(@Param("carType") String carType, @Param("xianQuId") String xianQuId, @Param("timeCount") Integer timeCount);

	List<BigdataFenxiTeamMonth> selectByMonthBaiGongLiQianShi(@Param("carType") String carType, @Param("xianQuId") String xianQuId, @Param("timeCount") Integer timeCount);

	List<BigdataFenxiTeamMonth> selectByMonthBaiGongLiHouShi(@Param("carType") String carType, @Param("xianQuId") String xianQuId, @Param("timeCount") Integer timeCount);

	public BigdataFenxiTeamMonth selectById(BigdataFenxiTeamMonthQuery query);

	public BigdataFenxiTeamMonth selectByTeamId(BigdataFenxiTeamMonthQuery query);

}