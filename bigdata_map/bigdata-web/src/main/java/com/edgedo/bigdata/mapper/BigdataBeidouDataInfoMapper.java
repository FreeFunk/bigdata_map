package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouDataInfo;
import com.edgedo.bigdata.queryvo.BigdataBeidouDataInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouDataInfoView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataBeidouDataInfoMapper  extends BaseMapper<BigdataBeidouDataInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouDataInfoView> listPage(BigdataBeidouDataInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouDataInfoView> listByObj(BigdataBeidouDataInfoQuery query);


	List listpageForBeidouDataInfo(BigdataBeidouDataInfoQuery query);
}