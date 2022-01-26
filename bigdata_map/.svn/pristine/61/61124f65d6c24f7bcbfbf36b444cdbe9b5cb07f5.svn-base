package com.edgedo.drawing.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverDrawInfo;
import com.edgedo.drawing.queryvo.BigdataDriverDrawInfoQuery;
import com.edgedo.drawing.queryvo.BigdataDriverDrawInfoView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataDriverDrawInfoMapper extends BaseMapper<BigdataDriverDrawInfo>{
	
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


    BigdataDriverDrawInfo loadByDriverIdAndYear(BigdataDriverDrawInfo driverDrawInfo);
}