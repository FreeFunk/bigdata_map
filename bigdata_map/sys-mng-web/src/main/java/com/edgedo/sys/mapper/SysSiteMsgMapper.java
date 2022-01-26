package com.edgedo.sys.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysSiteMsg;
import com.edgedo.sys.queryvo.SysSiteMsgQuery;
import com.edgedo.sys.queryvo.SysSiteMsgView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SysSiteMsgMapper  extends BaseMapper<SysSiteMsg> {
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysSiteMsgView> listPage(SysSiteMsgQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysSiteMsgView> listByObj(SysSiteMsgQuery query);
	
	

}