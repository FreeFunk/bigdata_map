package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.edgedo.bigdata.entity.BigdataFenxiTeamDay;
import com.edgedo.bigdata.entity.BigdataFenxiTeamMonth;
import com.edgedo.bigdata.entity.BigdataFenxiTeamWeek;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamDayQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamDayView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataFenxiTeamDayMapper extends BaseMapper<BigdataFenxiTeamDay>{
	
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

    int selectCountTeam(@Param("id") String id, @Param("yearNum")Integer yearNum,
						@Param("countMonth")Integer countMonth, @Param("countDay")Integer countDay);

	BigdataFenxiTeamDay selectByTeamId(String teamId, Integer yearNum, Integer countMonth, Integer countDay);

	void updateByIdAndYearAndMonthAndDay(BigdataFenxiTeamDay bigdataFenxiTeamDay);

	BigdataFenxiTeamWeek countMileageByWeek(Map<String, Object> map);

    BigdataFenxiTeamMonth countMileageByMonth(Map<String, Object> map);


}