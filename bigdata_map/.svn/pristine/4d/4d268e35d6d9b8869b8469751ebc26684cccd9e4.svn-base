package com.edgedo.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.entity.SysUserRole;
import com.edgedo.sys.mapper.SysUserMapper;
import com.edgedo.sys.mapper.SysUserRoleMapper;
import com.edgedo.sys.queryvo.SysOrgLevelRoleView;
import com.edgedo.sys.queryvo.SysUserRoleQuery;
import com.edgedo.sys.queryvo.SysUserRoleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysUserRoleService {
	
	
	@Autowired
	private SysUserRoleMapper mapper;

	@Autowired
	private SysUserMapper userMapper;

	
	public List<SysUserRoleView> listPage(SysUserRoleQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysUserRole voObj) {
		//voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysUserRole voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysUserRole voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public int deleteByIds(List<String> ids) {

		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysUserRole loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 根据用户id和角色id删除用户 角色关联
	 * @param userId
	 * @param roleId
	 */
	public void deleteByUserAndRole(String userId,String roleId) {
		SysUserRoleView userRole =new SysUserRoleView();
		userRole.setUserId(userId);
		userRole.setRoleId(roleId);
		mapper.deleteByUserAndRole(userRole);
	}

	/**
	 * 根据用户id和角色id获得关联
	 * @param userId 用户id
	 * @param roleId 角色id
	 * @return
	 */
	public SysUserRoleView selectByUserIdAndRoleId(String userId, String roleId) {
		SysUserRoleView view = new SysUserRoleView();
		view.setUserId(userId);
		view.setRoleId(roleId);
		return mapper.selectByUserIdAndRoleId(view);
	}

	public void deleteByUserId(String userId) {
		SysUserRoleView userRole =new SysUserRoleView();
		userRole.setUserId(userId);
		mapper.deleteByUserId(userRole);
	}

	/**
	 * 根据userId查询角色的id；
	 * @param userId
	 * @return
	 */
    public List<SysUserRoleView> selectRoleListByUserId(String userId) {
		return mapper.selectRoleListByUserId(userId);
    }

	/**
	 *
	 * @param query
	 * @param roleIdList
	 */
	public void userRoleConfig(SysUserRoleQuery query, List<String> roleIdList) {
		//根据userId查询所对应的roleId
		mapper.deleteByUserId(query.getQueryObj());
		SysUser sysUser = userMapper.selectByPrimaryKey(query.getQueryObj().getUserId());
		String defaultId = sysUser.getDefaultRoleId();
		if(!roleIdList.contains(defaultId)){
			sysUser.setDefaultRoleId("");
			sysUser.setDefaultRoleName("");
			userMapper.updateById(sysUser);
		}
		for(String roleId : roleIdList){
			if(!roleId.equals("ROOT")){
				SysUserRole voObj = new SysUserRole();
				voObj.setRoleId(roleId);
				voObj.setUserId(query.getQueryObj().getUserId());
				mapper.insert(voObj);
			}
		}
    }
}
