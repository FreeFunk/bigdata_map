package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataDangerRoadClsCount;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadClsCountQuery;
import com.edgedo.bigdata.queryvo.BigdataDangerRoadClsCountView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataDangerRoadClsCountMapper  extends BaseMapper<BigdataDangerRoadClsCount>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDangerRoadClsCountView> listPage(BigdataDangerRoadClsCountQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDangerRoadClsCountView> listByObj(BigdataDangerRoadClsCountQuery query);


    BigdataDangerRoadClsCountView getDangerRoadClsCountData(BigdataDangerRoadClsCountQuery query);
}