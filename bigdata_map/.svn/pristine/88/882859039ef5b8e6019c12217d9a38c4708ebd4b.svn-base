package com.edgedo.sys.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.edgedo.common.base.BaseController;
import com.edgedo.sys.entity.SysUserRole;
import com.edgedo.sys.queryvo.SysUserRoleQuery;
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
@RequestMapping("/admin/sysUserRole")
public class SysUserRoleController extends BaseController {
	
	@Autowired
	private SysUserRoleService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysUserRoleQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(SysUserRole voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getUserId();
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
	 * 根据userId和roleIdList维护角色的信息;
	 * @param query
	 * @param roleIdListJsonStr
	 * @return
	 */
	@RequestMapping("/userRoleConfig")
	public ModelAndView userRoleConfig(@ModelAttribute SysUserRoleQuery query,String roleIdListJsonStr){
		List<String> roleIdList = JSON.parseArray(roleIdListJsonStr,String.class);
		ModelAndView modelAndView = new ModelAndView();
		service.userRoleConfig(query,roleIdList);
		return buildResponse(modelAndView,query);
	}

	
}
