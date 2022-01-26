package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataGpsTransmitCarPermit;
import com.edgedo.bigdata.queryvo.BigdataGpsTransmitCarPermitQuery;
import com.edgedo.bigdata.queryvo.BigdataGpsTransmitCarPermitView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;


@Mapper
public interface BigdataGpsTransmitCarPermitMapper  extends BaseMapper<BigdataGpsTransmitCarPermit>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataGpsTransmitCarPermitView> listPage(BigdataGpsTransmitCarPermitQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataGpsTransmitCarPermitView> listByObj(BigdataGpsTransmitCarPermitQuery query);

	/**
	 * @Author WangZhen
	 * @Description 查询某个平台可转发的车牌号id
	 * @Date 2020/1/16 14:24
	 **/
	Set<String> selectCarPermitByPlatId(String platId);

}