package com.edgedo.sys.mapper;

import java.util.List;

import com.edgedo.sys.entity.SysRolePower;
import com.edgedo.sys.queryvo.SysRolePowerQuery;
import com.edgedo.sys.queryvo.SysRolePowerView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;

@Mapper
public interface SysRolePowerMapper  extends BaseMapper<SysRolePower>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysRolePowerView> listPage(SysRolePowerQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysRolePowerView> listByObj(SysRolePowerQuery query);
	
	

}