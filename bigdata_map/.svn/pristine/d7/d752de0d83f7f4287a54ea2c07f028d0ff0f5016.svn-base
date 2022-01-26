package com.edgedo.sys.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.common.base.CheckTreeObj;
import com.edgedo.sys.entity.SysOrgLevelRole;
import com.edgedo.sys.queryvo.SysOrgLevelRoleQuery;
import com.edgedo.sys.queryvo.SysOrgLevelRoleView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface SysOrgLevelRoleMapper  extends BaseMapper<SysOrgLevelRole> {
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysOrgLevelRoleView> listPage(SysOrgLevelRoleQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysOrgLevelRoleView> listByObj(SysOrgLevelRoleQuery query);

	/**
	 * 获得用户的角色选择树
	 * @param param : parentId父节点,userId用户主键
	 * @return
	 */
	List<CheckTreeObj> selectRoleForUserCheck(Map<String, Object> param);

	/**
	 * 根据用户id获得所有用户的角色id
	 * @param userId
	 * @return
	 */
    List<SysOrgLevelRoleView> selectAllUserRolesByUserId(String userId);

	/**
	 * 根据id查询用户的角色
	 * @param id
	 * @return
	 */
	List<SysOrgLevelRoleView> selectUserRoleByParentId(String id);
}