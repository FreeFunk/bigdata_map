package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataDriverChangeTeamRec;
import com.edgedo.bigdata.queryvo.BigdataDriverChangeTeamRecQuery;
import com.edgedo.bigdata.queryvo.BigdataDriverChangeTeamRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataDriverChangeTeamRecMapper  extends BaseMapper<BigdataDriverChangeTeamRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverChangeTeamRecView> listPage(BigdataDriverChangeTeamRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverChangeTeamRecView> listByObj(BigdataDriverChangeTeamRecQuery query);
	
	

}