package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataAlarmInfoVo;
import com.edgedo.bigdata.entity.BigdataTeamAnalysisInfo;
import com.edgedo.bigdata.queryvo.BigdataTeamAnalysisInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataTeamAnalysisInfoView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface BigdataTeamAnalysisInfoMapper extends BaseMapper<BigdataTeamAnalysisInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataTeamAnalysisInfoView> listPage(BigdataTeamAnalysisInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataTeamAnalysisInfoView> listByObj(BigdataTeamAnalysisInfoQuery query);


    BigdataTeamAnalysisInfo selectByVo(BigdataTeamAnalysisInfo bigdataTeamAnalysisInfo);

    void insertAlarmInfoVo(@Param("alarmInfoVoList") List<BigdataAlarmInfoVo> alarmInfoVoList);
}