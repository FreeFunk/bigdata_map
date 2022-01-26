package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.CredibilityCheckRec;
import com.edgedo.bigdata.queryvo.CredibilityCheckRecQuery;
import com.edgedo.bigdata.queryvo.CredibilityCheckRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface CredibilityCheckRecMapper  extends BaseMapper<CredibilityCheckRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<CredibilityCheckRecView> listPage(CredibilityCheckRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<CredibilityCheckRecView> listByObj(CredibilityCheckRecQuery query);


    List listpageCheckRec(CredibilityCheckRecQuery query);
}