package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiTeamDay;
import com.edgedo.bigdata.entity.BigdataFenxiTeamMonth;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamDayQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamDayView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface BigdataFenxiTeamDayMapper  extends BaseMapper<BigdataFenxiTeamDay>{

	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiTeamDayView> listPage(BigdataFenxiTeamDayQuery query);

	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiTeamDayView> listByObj(BigdataFenxiTeamDayQuery query);


    List<BigdataFenxiTeamDay> selectByDayAnQuanQianShi(@Param("carType") String carType,
													   @Param("xianQuId") String xianQuId,
													   @Param("timeCount") Integer timeCount,
													   @Param("yearNum") Integer yearNum,
													   @Param("countMonth") Integer countMonth);

	List<BigdataFenxiTeamDay> selectByDayAnQuanHouShi(@Param("carType") String carType,
													  @Param("xianQuId") String xianQuId,
													  @Param("timeCount")  Integer timeCount,
													  @Param("yearNum") Integer yearNum,
													  @Param("countMonth") Integer countMonth);

	List<BigdataFenxiTeamDay> selectByDayBaiGongLiQianShi(@Param("carType") String carType,
														  @Param("xianQuId") String xianQuId,
														  @Param("timeCount") Integer timeCount,
														  @Param("yearNum") Integer yearNum,
														  @Param("countMonth") Integer countMonth);

	List<BigdataFenxiTeamDay> selectByDayBaiGongLiHouShi(@Param("carType") String carType,
														 @Param("xianQuId") String xianQuId,
														 @Param("timeCount") Integer timeCount,
														 @Param("yearNum") Integer yearNum,
														 @Param("countMonth") Integer countMonth);

	public BigdataFenxiTeamDay selectByIdAndCountDate(BigdataFenxiTeamDayQuery query);

}