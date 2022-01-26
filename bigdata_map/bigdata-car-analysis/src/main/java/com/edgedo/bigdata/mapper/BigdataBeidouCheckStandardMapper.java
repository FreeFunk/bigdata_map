package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouCheckStandard;
import com.edgedo.bigdata.queryvo.BigdataBeidouCheckStandardQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCheckStandardView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataBeidouCheckStandardMapper  extends BaseMapper<BigdataBeidouCheckStandard>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCheckStandardView> listPage(BigdataBeidouCheckStandardQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouCheckStandardView> listByObj(BigdataBeidouCheckStandardQuery query);


    List<BigdataBeidouCheckStandardView> listAll();
}