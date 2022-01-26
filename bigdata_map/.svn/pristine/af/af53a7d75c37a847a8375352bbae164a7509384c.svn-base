package com.edgedo.sys.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.edgedo.common.base.BaseController;
import com.edgedo.sys.entity.SysProvice;
import com.edgedo.sys.queryvo.SysProviceQuery;
import com.edgedo.sys.service.SysProviceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/sysProvice")
public class SysProviceController extends BaseController {
	
	@Autowired
	private SysProviceService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysProviceQuery query, String cityId, String xianquId){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query,cityId,xianquId);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	@RequestMapping(value = "/selectAll.jsn")
	public ModelAndView selectAll(@ModelAttribute SysProviceQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.selectAll(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(SysProvice voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		if(id==null || id.trim().equals("")){
			errMsg = service.insert(voObj);
		}else{
			errMsg = service.update(voObj);
		}
		if(errMsg!=null && !errMsg.equals("")){
			errMsg="提交失败";
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

	/**@author 王斌
	 * 根据主键加载
	 * @param provinceName
	 * @return
	 */
	@RequestMapping("/selectByName")
	public ModelAndView  selectByName(String provinceName){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.selectByName(provinceName));
	}
	
	
}
