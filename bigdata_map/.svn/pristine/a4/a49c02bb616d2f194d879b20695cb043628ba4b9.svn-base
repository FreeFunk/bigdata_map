package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouComp;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataBeidouCompMapper  extends BaseMapper<BigdataBeidouComp>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCompView> listPage(BigdataBeidouCompQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCompView> listByObj(BigdataBeidouCompQuery query);
	
	

}