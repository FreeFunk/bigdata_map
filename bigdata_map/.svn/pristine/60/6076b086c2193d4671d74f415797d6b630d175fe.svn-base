package com.edgedo.sys.mapper;


import com.edgedo.sys.entity.SysSiteMsgTongyi;
import com.edgedo.sys.queryvo.SysSiteMsgTongyiQuery;
import com.edgedo.sys.queryvo.SysSiteMsgTongyiView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

@Mapper
public interface SysSiteMsgTongyiMapper  extends BaseMapper<SysSiteMsgTongyi>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysSiteMsgTongyiView> listPage(SysSiteMsgTongyiQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysSiteMsgTongyiView> listByObj(SysSiteMsgTongyiQuery query);
	
	

}