package com.edgedo.sys.mapper;

import java.util.List;

import com.edgedo.sys.entity.SysUserLoginLog;
import com.edgedo.sys.queryvo.SysUserLoginLogQuery;
import com.edgedo.sys.queryvo.SysUserLoginLogView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;

@Mapper
public interface SysUserLoginLogMapper  extends BaseMapper<SysUserLoginLog>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysUserLoginLogView> listPage(SysUserLoginLogQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysUserLoginLogView> listByObj(SysUserLoginLogQuery query);
	
	

}