package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataGpsTransmitCarPermit;
import com.edgedo.bigdata.queryvo.BigdataGpsTransmitCarPermitQuery;
import com.edgedo.bigdata.queryvo.BigdataGpsTransmitCarPermitView;
import org.apache.ibatis.annotations.Mapper;



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
	
	

}