package com.edgedo.sys.mapper;

import java.util.List;

import com.edgedo.sys.entity.SysRoleMenue;
import com.edgedo.sys.queryvo.SysRoleMenueQuery;
import com.edgedo.sys.queryvo.SysRoleMenueView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;

@Mapper
public interface SysRoleMenueMapper  extends BaseMapper<SysRoleMenue>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysRoleMenueView> listPage(SysRoleMenueQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysRoleMenueView> listByObj(SysRoleMenueQuery query);


	void deleteByAllMess(SysRoleMenueQuery query);

	//根据roleId删除数据;
    void deleteByRoleId(SysRoleMenueQuery query);

    //根据roleId查询menueIds
    List<SysRoleMenueView> selectMenueIdsByRoleId(String roleId);
}