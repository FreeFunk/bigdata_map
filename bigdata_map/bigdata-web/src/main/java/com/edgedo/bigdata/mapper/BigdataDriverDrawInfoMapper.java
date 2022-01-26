package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataDriverDrawInfo;
import com.edgedo.bigdata.queryvo.BigdataDriverDrawInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataDriverDrawInfoView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataDriverDrawInfoMapper  extends BaseMapper<BigdataDriverDrawInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverDrawInfoView> listPage(BigdataDriverDrawInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverDrawInfoView> listByObj(BigdataDriverDrawInfoQuery query);
	
	

}