package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.PeccancyRec;
import com.edgedo.bigdata.queryvo.PeccancyRecQuery;
import com.edgedo.bigdata.queryvo.PeccancyRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface PeccancyRecMapper  extends BaseMapper<PeccancyRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<PeccancyRecView> listPage(PeccancyRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<PeccancyRecView> listByObj(PeccancyRecQuery query);


    List listpagePeccancyRec(PeccancyRecQuery query);

    List<PeccancyRecView> listPagePRByCarInfo(PeccancyRecQuery query);
}