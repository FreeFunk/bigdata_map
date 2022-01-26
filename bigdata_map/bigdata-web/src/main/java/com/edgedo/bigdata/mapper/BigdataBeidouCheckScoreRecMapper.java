package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouCheckScoreRec;
import com.edgedo.bigdata.queryvo.BigdataBeidouCheckScoreRecQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCheckScoreRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataBeidouCheckScoreRecMapper  extends BaseMapper<BigdataBeidouCheckScoreRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCheckScoreRecView> listPage(BigdataBeidouCheckScoreRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCheckScoreRecView> listByObj(BigdataBeidouCheckScoreRecQuery query);
	
	

}