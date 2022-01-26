package com.edgedo.bigdata.mapper;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataTeamAnalysisInfo;
import com.edgedo.bigdata.queryvo.BigdataTeamAnalysisInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataTeamAnalysisInfoView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataTeamAnalysisInfoMapper  extends BaseMapper<BigdataTeamAnalysisInfo>{
	
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


    List<BigdataTeamAnalysisInfoView> listPageByCountDate(BigdataTeamAnalysisInfoQuery query);

    List<BigdataTeamAnalysisInfoView> selectByTeamType(Map<String, Object> map);
}