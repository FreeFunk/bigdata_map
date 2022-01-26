package com.edgedo.sys.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.sequrity.CheckPermission;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.sys.entity.SysMenue;
import com.edgedo.sys.queryvo.SysMenueQuery;
import com.edgedo.sys.queryvo.SysMenueViewSyn;
import com.edgedo.sys.queryvo.SysRoleMenueQuery;
import com.edgedo.sys.queryvo.SysRoleMenueView;
import com.edgedo.sys.service.SysMenueService;
import com.edgedo.sys.service.SysRoleMenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/admin/sysMenue")
public class SysMenueController extends BaseController {
	
	@Autowired
	private SysMenueService service;

	@Autowired
	private SysRoleMenueService roleMenueService;
	
	
	/**
	 * 用户访问菜单数据
	 * @return
	 */
	@RequestMapping("/nav")
	public ModelAndView nav(final HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("tpl/blocks/nav");
		List meneu = (List)session.getAttribute("currentUserMenue");
		buildResponse(modelAndView, meneu);
		return modelAndView;
	}
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysMenueQuery query, HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		//loadTree(response);
		return modelAndView;
	}


	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(SysMenue voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		if(id==null || id.trim().equals("")){
			//设置数据状态
			voObj.setDataState("1");
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
		//return buildResponse(modelAndView);
		String errMsg = "";
		errMsg = service.deleteByIds(list);
		if(errMsg!=null && !errMsg.equals("")){
			buildErrorResponse(modelAndView, errMsg);
		}else{
			buildResponse(modelAndView);
		}
		return modelAndView;
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

	//异步加载树节点
	@RequestMapping("/loadMenue")
	public ModelAndView  loadMenue(String id){
		ModelAndView modelAndView = new ModelAndView();
		List<SysMenueViewSyn> meanueList = service.selectByPreantID(id);
		recursive(meanueList);
		return buildResponse(modelAndView,meanueList);
	}


	@RequestMapping("/loadTree")
	@Pass
	public ModelAndView loadTree(HttpServletResponse response,String roleId){
		ModelAndView modelAndView = new ModelAndView();
		List<SysMenueViewSyn> meanueList = new ArrayList();
		SysMenueViewSyn sysMenueViewSyn = new SysMenueViewSyn ();
		//要进行维护数据;
		if(roleId!=null && roleId!=""){
			String parentId = "ROOT";
			sysMenueViewSyn.setTitle("菜单树");
			sysMenueViewSyn.setValue("ROOT");
			List<SysMenueViewSyn> childXtreeDataList = service.selectByPreantID(parentId);
			diguiSelect(childXtreeDataList,roleId);
			sysMenueViewSyn.setData(childXtreeDataList);
		}else{
			sysMenueViewSyn.setId("ROOT");
			sysMenueViewSyn.setText("菜单树");
			sysMenueViewSyn.setLabel();
			sysMenueViewSyn.setName();
			List<SysMenueViewSyn> childList = service.selectByPreantID(sysMenueViewSyn.getId());
			sysMenueViewSyn.setChildren(childList);
			diguiSelect(childList,null);
		}
		meanueList.add(sysMenueViewSyn);
		buildResponse(modelAndView,meanueList);
		return modelAndView;
	}
	
	private void diguiSelect(List<SysMenueViewSyn> list,String roleId) {

		List <SysRoleMenueView> menuIdList  = roleMenueService.selectMenueIdsByRoleId(roleId);

		if(list.size()==0||list==null){
			return;
		}
		for(SysMenueViewSyn l : list){
			l.setLabel();
			l.setName();
			l.setTitle();
			for(SysRoleMenueView menuId : menuIdList){
				if(menuId.getMenueId().equals(l.getId())){
					l.setChecked(true);
				}
			}
			l.setValue();
			List<SysMenueViewSyn> childList = service.selectByPreantID(l.getId());
			l.setChildren(childList);
			l.setData(childList);
			diguiSelect(childList,roleId);
		}
		
	}

	private void recursive(List<SysMenueViewSyn> list){

		for(SysMenueViewSyn pmv : list){
			if(pmv==null){
				return;
			}
			pmv.setLabel();
			pmv.setName();
			recursive(pmv.getChildren());
		}
			
	}
	
}
