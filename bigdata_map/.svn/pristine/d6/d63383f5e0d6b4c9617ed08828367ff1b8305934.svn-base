package com.edgedo.sys.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.CheckTreeObj;
import com.edgedo.common.shiro.User;
import com.edgedo.sys.entity.SysOrgLevelRole;
import com.edgedo.sys.entity.SysRoleMenue;
import com.edgedo.sys.queryvo.*;
import com.edgedo.sys.service.SysOrgLevelRoleService;
import com.edgedo.sys.service.SysRoleMenueService;
import com.edgedo.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/sysOrgLevelRole")
public class SysOrgLevelRoleController extends BaseController {
	
	@Autowired
	private SysOrgLevelRoleService service;

	@Autowired
	private SysRoleMenueService servie2;

	@Autowired
	private SysUserRoleService userRoleService;

	private String selectRoleId;

	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysOrgLevelRoleQuery query, String userId){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query,userId);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	/**
	 * 查出所有角色
	 * @param
	 * @return
	 */
	@RequestMapping("/listAllRole")
	public ModelAndView listAllRole(@ModelAttribute SysOrgLevelRoleQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List list=service.selectAllRoles(query);
		return buildResponse(modelAndView,list);
	}
	/**
	 * 根据用户id进行查询所对应的菜单。
	 * @param id
	 * @return
	 */
	//异步加载树节点
	@RequestMapping("/loadMenueRole")
	public ModelAndView  loadMenueRole(String id,String roleId){
		ModelAndView modelAndView = new ModelAndView();
		this.selectRoleId = roleId;
		List<SysMenueViewSyn> meanueList = service.selectByPreantID(id);
		//在这进行角色与roleId对应。
		SysRoleMenueQuery query = new SysRoleMenueQuery();
		query.getQueryObj().setRoleId(roleId);
		//查询到roleId所对应的menuId;
		List <SysRoleMenueView> list = servie2.listPage(query);
		for(SysMenueViewSyn sysMenu : meanueList){
			sysMenu.setChecked(false);
			for(SysRoleMenueView sysRoleMenu : list){
				if(sysRoleMenu.getMenueId().equals(sysMenu.getId())){
					sysMenu.setChecked(true);
				}
			}
		}
		recursive(meanueList);
		return buildResponse(modelAndView,meanueList);
	}

	/**
	 * 根据菜单的id和user的id进行菜单的修改。
	 * @param menuId
	 * @return
	 */
	@RequestMapping("/updateCheckMenu")
	public ModelAndView updateCheckMenu(String menuId){
		ModelAndView modelAndView = new ModelAndView();
		//根据菜单的id和user用户的id查询sys_role_menue表中是否有数据，如果有则删除，没有则新增。
		SysRoleMenueQuery query = new SysRoleMenueQuery();
		query.getQueryObj().setRoleId(selectRoleId);
		query.getQueryObj().setMenueId(menuId);
		//查询：
		List <SysRoleMenueView> list = servie2.listPage(query);
		if(list.size()>0){
			//删除;
			servie2.deleteByAllMess(query);
		}else{
			//新增;
			SysRoleMenue sysRoleMenue = new SysRoleMenue();
			sysRoleMenue.setMenueId(menuId);
			sysRoleMenue.setRoleId(selectRoleId);
			String str = servie2.insert(sysRoleMenue);
		}
		return buildResponse(modelAndView);
	}



	private void recursive(List<SysMenueViewSyn> list){

		for(SysMenueViewSyn pmv : list){
			if(pmv==null){
				return;
			}
			pmv.setLabel();
			recursive(pmv.getChildren());
		}

	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(SysOrgLevelRole voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		if(id==null || id.trim().equals("")){
			errMsg = service.insert(voObj);
		}else{
			errMsg = service.update(voObj);
		}
		if(errMsg!=null && !errMsg.equals("")){
			buildErrorResponse(modelAndView, errMsg);
		}else{
			buildResponse(modelAndView);
		}
		return modelAndView;
	}



	
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteByIds")
	public ModelAndView delete(String ids){
		ModelAndView modelAndView = new ModelAndView();
		String[] arr = ids.split(",");
		List<String> list = new ArrayList<String>();
		for(String str : arr){
			list.add(str);
		}
		service.deleteByIds(list);		
		return buildResponse(modelAndView);
	}
	
	
	/**
	 * 根据主键加载
	 * @param id
	 * @return
	 */
	@RequestMapping("/loadById")
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
/*	*//**
	 * 根据用户或用户角色选择树节点
	 * @param parentId 父几点id
	 * @param userId 用户id
	 * @return
	 *//*
	@RequestMapping("/loadRoleForUserCheck")
	//@SequrityPermission(value="PT_ORGROLE_TREE_LOAD")
	@ResponseBody
	public List loadRoleForUserCheck(@RequestParam String node,@RequestParam String userId){
		List<CheckTreeObj> list = service.selectRoleForUserCheck(node, userId);
		return list;
	}*/
	/**
	 * 根据用户或用户角色选择树节点
	 * @param userId 用户id
	 * @return
	 */
	@RequestMapping("/loadTree")
	public ModelAndView loadTree(@RequestParam String node,@RequestParam String userId,HttpServletResponse response){
		/*String json = "[{\"label\":\"节点\",\"children\":["
				+ "{\"label\":\"节点1\"},"
				+ "{\"label\":\"节点2\"}"
				+ "]}]";*/
		/*List<TreeVo> list = new ArrayList<TreeVo>();
		String json = JSON.toJSONString(list);*/
		ModelAndView modelAndView = new ModelAndView();
		List<CheckTreeObj> list = service.selectRoleForUserCheck(node, userId);
		//recursive(list);
		//String jsonList = JSON.toJSONString(list);
		buildResponse(modelAndView, list);
		return modelAndView;
	}
	
/*	private void recursive(List<CheckTreeObj> list){
		
		for(CheckTreeObj pmv : list){
			if(pmv==null){
				return;
			}
			pmv.setLabel();
			recursive(pmv.getChildren());
		}
			
	}*/

	/**
	 * 修改用户角色关联
	 * @param userId 用户id
	 * @param roleId 角色id
	 * @param check 是否关联
	 * @return
	 */
	@RequestMapping("/updateUserRoleCheck")
	@ResponseBody
	//@SequrityPermission(value="PT_ORGROLE_USER_CHECK")
	public ModelAndView updateUserRoleCheck(@RequestParam String userId,@RequestParam String roleId,@RequestParam boolean check){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = service.updateUserRoleCheck(userId,roleId,check);
		if(errMsg!=null && !errMsg.equals("")){
			buildErrorResponse(modelAndView, errMsg);
			return modelAndView;
		}else{
			buildResponse(modelAndView);
			return modelAndView;
		}
	}

	//loadUserRoleTree 角色树
	@RequestMapping("/loadUserRoleTree")
	public ModelAndView loadUserRoleTree(HttpServletResponse response,String userId,String defaultRoleId){
		ModelAndView modelAndView = new ModelAndView();
		List<SysOrgLevelRoleView> sysOrgLevelRoleList = new ArrayList<>();
		SysOrgLevelRoleView sysOrgLevelRoleView = new SysOrgLevelRoleView();
		sysOrgLevelRoleView.setRoleName("角色树");
		sysOrgLevelRoleView.setId("ROOT");
		if(userId!=null && userId!=""){
			sysOrgLevelRoleView.setTitle();
			sysOrgLevelRoleView.setValue();
			sysOrgLevelRoleView.setTreeType();
			String parentId = "ROOT";
			List<SysOrgLevelRoleView> childXtreeDataList = service.selectUserRoleByParentId(parentId);
			diguiSelect(childXtreeDataList,userId,defaultRoleId);
			sysOrgLevelRoleView.setData(childXtreeDataList);
		}else{
			sysOrgLevelRoleView.setName();
			sysOrgLevelRoleView.setText();
			String parentId = "ROOT";
			List<SysOrgLevelRoleView> childList = service.selectUserRoleByParentId(parentId);
			diguiSelect(childList,null,null);
			sysOrgLevelRoleView.setChildren(childList);
		}
		sysOrgLevelRoleList.add(sysOrgLevelRoleView);
		buildResponse(modelAndView,sysOrgLevelRoleList);
		return modelAndView;
	}

	private void diguiSelect(List<SysOrgLevelRoleView> list,String userId,String defaultRoleId) {

		List <SysUserRoleView> userRoleList  = userRoleService.selectRoleListByUserId(userId);

		if(list.size()==0||list==null){
			return;
		}
		for(SysOrgLevelRoleView l : list){

			l.setName();
			l.setTitle();
			l.setValue();
			l.setTreeType();
			for(SysUserRoleView sysUserRole : userRoleList){
				if(sysUserRole.getRoleId().equals(l.getId())){
					l.setChecked(true);
				}
			}
			List<SysOrgLevelRoleView> childList = service.selectUserRoleByParentId(l.getId());
			l.setChildren(childList);
			l.setData(childList);
			diguiSelect(childList,userId,defaultRoleId);
		}
	}

	public String getSelectRoleId() {
		return selectRoleId;
	}

	public void setSelectRoleId(String selectRoleId) {
		this.selectRoleId = selectRoleId;
	}
}
