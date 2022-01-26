package com.edgedo.sys.service;

import java.util.List;

import com.edgedo.sys.entity.SysRoleMenue;
import com.edgedo.sys.mapper.SysRoleMenueMapper;
import com.edgedo.sys.queryvo.SysRoleMenueQuery;
import com.edgedo.sys.queryvo.SysRoleMenueView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysRoleMenueService {
	
	
	@Autowired
	private SysRoleMenueMapper mapper;

	
	public List<SysRoleMenueView> listPage(SysRoleMenueQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysRoleMenue voObj) {
		//voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysRoleMenue voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysRoleMenue voObj) {
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
	public SysRoleMenue loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 根据角色Id查询菜单Ids;
	 * @param roleId
	 * @return
	 */
	public List<SysRoleMenueView> selectMenueIdsByRoleId(String roleId){
		List list = mapper.selectMenueIdsByRoleId(roleId);
		return list;
	}


	/**
	 * 根据对象进行删除数据;
	 * @param query
	 */
	public void deleteByAllMess(SysRoleMenueQuery query) {
		mapper.deleteByAllMess(query);
	}

	/**
	 * 根据角色Id配置菜单Ids
	 * @param query
	 * @param menuIdList
	 * @return
	 */
    public void configUserRoleMenue(SysRoleMenueQuery query, List <String>menuIdList) {
		//删除原先有的配置信息
		mapper.deleteByRoleId(query);
		//重新写入数据库选中的信息;
		for(String menueId : menuIdList){
			SysRoleMenue voObj = new SysRoleMenue();
			voObj.setMenueId(menueId);
			voObj.setRoleId(query.getQueryObj().getRoleId());
			mapper.insert(voObj);
		}
	}
}
