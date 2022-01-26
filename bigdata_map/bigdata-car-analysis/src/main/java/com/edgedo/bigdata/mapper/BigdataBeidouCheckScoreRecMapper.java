package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouCheckScoreRec;
import com.edgedo.bigdata.queryvo.BigdataBeidouCheckScoreRecQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCheckScoreRecView;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


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


    BigdataBeidouCheckScoreRec selectByVo(BigdataBeidouCheckScoreRec bigdataBeidouCheckScoreRec);

	void updateNew(BigdataBeidouCheckScoreRec bigdataBeidouCheckScoreRec);

	BigDecimal countCompScore(Map<String, Object> map);
}