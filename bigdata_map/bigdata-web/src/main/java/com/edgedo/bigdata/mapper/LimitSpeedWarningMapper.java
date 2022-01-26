package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.LimitSpeedWarning;
import com.edgedo.bigdata.queryvo.LimitSpeedWarningQuery;
import com.edgedo.bigdata.queryvo.LimitSpeedWarningView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface LimitSpeedWarningMapper  extends BaseMapper<LimitSpeedWarning>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<LimitSpeedWarningView> listPage(LimitSpeedWarningQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<LimitSpeedWarningView> listByObj(LimitSpeedWarningQuery query);


	List<LimitSpeedWarningView> getLimitSpeedWarningData(LimitSpeedWarningQuery query);
}