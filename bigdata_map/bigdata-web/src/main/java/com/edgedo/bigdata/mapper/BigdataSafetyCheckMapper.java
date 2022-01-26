package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataSafetyCheck;
import com.edgedo.bigdata.queryvo.BigdataSafetyCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataSafetyCheckView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataSafetyCheckMapper  extends BaseMapper<BigdataSafetyCheck>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataSafetyCheckView> listPage(BigdataSafetyCheckQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataSafetyCheckView> listByObj(BigdataSafetyCheckQuery query);
	
	

}