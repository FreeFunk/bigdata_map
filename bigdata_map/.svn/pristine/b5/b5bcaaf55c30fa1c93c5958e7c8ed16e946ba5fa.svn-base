package com.edgedo.sys.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.common.base.CheckTreeObj;
import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysOrgLevelRole;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.entity.SysUserRole;
import com.edgedo.sys.mapper.SysMenueMapper;
import com.edgedo.sys.mapper.SysOrgLevelRoleMapper;
import com.edgedo.sys.queryvo.SysMenueViewSyn;
import com.edgedo.sys.queryvo.SysOrgLevelRoleQuery;
import com.edgedo.sys.queryvo.SysOrgLevelRoleView;
import com.edgedo.sys.queryvo.SysUserRoleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysOrgLevelRoleService {
	
	
	@Autowired
	private SysOrgLevelRoleMapper mapper;
	@Autowired
	private SysMenueMapper mapper2;
	
	@Autowired
	private SysUserRoleService userRoleService;
	@Autowired
	private SysUserService sysUserService;

	
	public List<SysOrgLevelRoleView> listPage(SysOrgLevelRoleQuery query, String userId){
		List<SysOrgLevelRoleView> list = mapper.listPage(query);
		if(userId!=null&&!("".equals(userId))) {
			SysUser sysuser = sysUserService.loadById(userId);
			for(SysOrgLevelRoleView sysOrgLevelRoleView:list){
				if(sysOrgLevelRoleView.getId().equals(sysuser.getDefaultRoleId())){
					list.remove(sysOrgLevelRoleView);
					list.add(0,sysOrgLevelRoleView);
					break;
				}
			}
		}
		query.setList(list);
		return list;
	}



	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysOrgLevelRole voObj) {
		//重复检查
		SysOrgLevelRoleQuery sysOrgLevelRoleQuery = new SysOrgLevelRoleQuery();
		SysOrgLevelRoleView sysOrgLevelRoleView = new SysOrgLevelRoleView();
		sysOrgLevelRoleView.setRoleName(voObj.getRoleName());
		sysOrgLevelRoleQuery.setQueryObj(sysOrgLevelRoleView);
		if(mapper.listPage(sysOrgLevelRoleQuery).size()!=0){
			return "该角色已存在!";
		}
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysOrgLevelRole voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysOrgLevelRole voObj) {
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
	public SysOrgLevelRole loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 根据用户或用户角色选择树节点
	 * @param parentId 父几点id
	 * @param userId 用户id
	 * @return
	 */
	public List<CheckTreeObj> selectRoleForUserCheck(String parentId, String userId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("parentId",parentId);
		param.put("userId", userId);
		return mapper.selectRoleForUserCheck(param);
	}

	/**
	 * 修改用户角色关联
	 * @param userId 用户id
	 * @param roleId 角色id
	 * @param check 是否关联
	 * @return
	 */
	public String updateUserRoleCheck(String userId, String roleId, boolean check) {
		SysUserRoleView userRole = userRoleService.selectByUserIdAndRoleId(userId,roleId);
		if(check){
			if(userRole==null){
				SysUserRole userRoleInsert = new SysUserRole();
				userRoleInsert.setUserId(userId);
				userRoleInsert.setRoleId(roleId);
				userRoleService.insert(userRoleInsert);
			}
		}else{
			if(userRole!=null){
				userRoleService.deleteByUserAndRole(userRole.getUserId(),userRole.getRoleId());
			}
		}
		return "";
	}

	public List<SysMenueViewSyn> selectByPreantID(String parentId) {
		return mapper2.selectByPreantID(parentId);
	}

	/**
	 * 根据用户id获得用户的所有的角色
	 * @param userId
	 * @return
	 */
    public List<SysOrgLevelRoleView> selectAllUserRolesByUserId(String userId) {
		return mapper.selectAllUserRolesByUserId(userId);
    }

	/**
	 *获得所有的角色
	 * @param
	 * @return
	 */
	public List<SysOrgLevelRoleView> selectAllRoles(SysOrgLevelRoleQuery query) {
		return mapper.listByObj(query);
	}

	/**
	 * 根据id查询角色;
	 * @param id
	 * @return
	 */
    public List<SysOrgLevelRoleView> selectUserRoleByParentId(String id) {
    	return mapper.selectUserRoleByParentId(id);
    }
}
