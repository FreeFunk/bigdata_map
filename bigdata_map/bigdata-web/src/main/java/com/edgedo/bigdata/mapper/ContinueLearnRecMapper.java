package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.ContinueLearnRec;
import com.edgedo.bigdata.queryvo.ContinueLearnRecQuery;
import com.edgedo.bigdata.queryvo.ContinueLearnRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ContinueLearnRecMapper  extends BaseMapper<ContinueLearnRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ContinueLearnRecView> listPage(ContinueLearnRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ContinueLearnRecView> listByObj(ContinueLearnRecQuery query);


    List listpageLearnRec(ContinueLearnRecQuery query);
}