package com.edgedo.sys.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysMenue;
import com.edgedo.sys.mapper.SysMenueMapper;
import com.edgedo.sys.queryvo.SysMenueQuery;
import com.edgedo.sys.queryvo.SysMenueView;
import com.edgedo.sys.queryvo.SysMenueViewSyn;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysMenueService {
	
	
	@Autowired
	private SysMenueMapper mapper;

	
	public List<SysMenueView> listPage(SysMenueQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysMenue voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysMenue voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysMenue voObj) {
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
	public String deleteByIds(List<String> ids) {
		for(String id:ids) {
			List list = mapper.selectByPreantID(id);
			if(list!=null && list.size()>0){
				return "删除失败,存在子树";
			}
		}
		mapper.deleteBatchIds(ids);
		return "";
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysMenue loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 根据父节点和用户获得子菜单
	 * @param pid 父节点
	 * @param userId 用户id
	 * @return
	 */
	public List<SysMenueView> getUserMenuByPidAndUserid(String pid, String userId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("pid",pid);
		param.put("userId", userId);
		return mapper.getUserMenuByPidAndUserId(param);
	}

	public List<SysMenueViewSyn> selectByPreantID(String parentId) {
	
		return mapper.selectByPreantID(parentId);
	}


    public String selectParentIdById(String menuId) {
		return mapper.selectParentIdById(menuId);
    }
}
