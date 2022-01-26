package com.edgedo.sys.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.edgedo.common.base.BaseController;
import com.edgedo.sys.entity.SysRoleMenue;
import com.edgedo.sys.queryvo.SysRoleMenueQuery;
import com.edgedo.sys.service.SysMenueService;
import com.edgedo.sys.service.SysRoleMenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/sysRoleMenue")
public class SysRoleMenueController extends BaseController {
	
	@Autowired
	private SysRoleMenueService service;

	@Autowired
	private SysMenueService menueService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysRoleMenueQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

//	public List

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(SysRoleMenue voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getRoleId();
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


	/**
	 * 根据角色Id配置菜单Ids
	 * @param query
	 * @param listJsonStr
	 * @return
	 */
	@RequestMapping("/configUserRoleMenue")
	public ModelAndView  configUserRoleMenue(@ModelAttribute SysRoleMenueQuery query,String listJsonStr){
		List<String> menuIdList = JSON.parseArray(listJsonStr,String.class);
		ModelAndView modelAndView = new ModelAndView();
		service.configUserRoleMenue(query,menuIdList);
		return buildResponse(modelAndView,query);
	}
	
	
}
