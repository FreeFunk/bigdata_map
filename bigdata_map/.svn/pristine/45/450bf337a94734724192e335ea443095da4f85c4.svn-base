package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouComp;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataBeidouCompMapper extends BaseMapper<BigdataBeidouComp>{
	
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

	//查询所有
	List<BigdataBeidouCompView> listAll();

	//根据ip地址查询北斗运营商
    BigdataBeidouCompView selectByIp809Addr(String ip809Addr);

}