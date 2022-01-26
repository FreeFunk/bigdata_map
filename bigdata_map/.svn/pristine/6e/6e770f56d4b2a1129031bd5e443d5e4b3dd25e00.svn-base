package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouTeamInfo;
import com.edgedo.bigdata.queryvo.BigdataBeidouTeamInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouTeamInfoView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataBeidouTeamInfoMapper  extends BaseMapper<BigdataBeidouTeamInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouTeamInfoView> listPage(BigdataBeidouTeamInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouTeamInfoView> listByObj(BigdataBeidouTeamInfoQuery query);
	
	

}