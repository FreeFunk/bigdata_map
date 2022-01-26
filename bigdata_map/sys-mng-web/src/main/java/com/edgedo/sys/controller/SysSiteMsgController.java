package com.edgedo.sys.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edgedo.common.base.BaseController;
import com.edgedo.sys.entity.SysSiteMsg;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.queryvo.SysSiteMsgQuery;
import com.edgedo.sys.service.SysSiteMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/sysSiteMsg")
public class SysSiteMsgController extends BaseController {
	
	@Autowired
	private SysSiteMsgService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysSiteMsgQuery query){
		ModelAndView modelAndView = new ModelAndView();
		if(query.getQueryObj().getOwnerMsg()==null||"".equals(query.getQueryObj().getOwnerMsg())){
			SysUser su = null;//AdminUserLoginIntercepter.getCurrentUser();
			query.getQueryObj().setUserId(su.getId());
		}
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
	public ModelAndView saveOrUpdate(SysSiteMsg voObj){
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
	public ModelAndView  loadById(String id, HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.updataAndLoadById(id,session));
	}
	
	
}
