package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouModel;
import com.edgedo.bigdata.queryvo.BigdataBeidouModelQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouModelView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataBeidouModelMapper extends BaseMapper<BigdataBeidouModel>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouModelView> listPage(BigdataBeidouModelQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouModelView> listByObj(BigdataBeidouModelQuery query);


	List<BigdataBeidouModel> getByCompId(String compId);
}