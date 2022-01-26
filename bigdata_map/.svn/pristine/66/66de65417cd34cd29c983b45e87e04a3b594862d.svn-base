package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataGpsTransmitPlatform;
import com.edgedo.bigdata.queryvo.BigdataGpsTransmitPlatformQuery;
import com.edgedo.bigdata.queryvo.BigdataGpsTransmitPlatformView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataGpsTransmitPlatformMapper  extends BaseMapper<BigdataGpsTransmitPlatform>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataGpsTransmitPlatformView> listPage(BigdataGpsTransmitPlatformQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataGpsTransmitPlatformView> listByObj(BigdataGpsTransmitPlatformQuery query);

	/**
	 * @Author WangZhen
	 * @Description 获得所有转发平台
	 * @Date 2020/1/16 14:09
	 **/
	List<BigdataGpsTransmitPlatformView> selectAllPlatformOfUp();

}