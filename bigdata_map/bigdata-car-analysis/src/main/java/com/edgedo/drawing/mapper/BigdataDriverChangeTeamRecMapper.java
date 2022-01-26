package com.edgedo.drawing.mapper;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverChangeTeamRec;
import com.edgedo.drawing.queryvo.BigdataDriverChangeTeamRecQuery;
import com.edgedo.drawing.queryvo.BigdataDriverChangeTeamRecView;
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


    int countChangeTeam(Map<String, Object> map);
}