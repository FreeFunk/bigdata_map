package com.edgedo.sys.mapper;

import java.util.List;

import com.edgedo.sys.entity.SysUserRole;
import com.edgedo.sys.queryvo.SysUserRoleQuery;
import com.edgedo.sys.queryvo.SysUserRoleView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;

@Mapper
public interface SysUserRoleMapper  extends BaseMapper<SysUserRole>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysUserRoleView> listPage(SysUserRoleQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysUserRoleView> listByObj(SysUserRoleQuery query);

	/**
	 * 删除用户和角色
	 * @param userRole
	 */
	public void deleteByUserAndRole(SysUserRoleView userRole);

	/**
	 * 根据用户id和角色id获得关联关系
	 * @param view
	 */
	SysUserRoleView selectByUserIdAndRoleId(SysUserRoleView view);


	/**
	 * 根据userId删除和这个userId相关的所有值。
	 * @param userRole
	 */
	void deleteByUserId(SysUserRoleView userRole);

	/**
	 * 根据userId查询roleIdList
	 * @param userId
	 */
    List<SysUserRoleView> selectRoleListByUserId(String userId);
}