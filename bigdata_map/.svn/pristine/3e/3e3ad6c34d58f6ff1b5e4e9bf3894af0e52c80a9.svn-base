package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataSafetyWarning;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningQuery;
import com.edgedo.bigdata.service.BigdataSafetyWarningService;
import com.edgedo.common.base.annotation.Pass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataSafetyWarning")
@Controller
@RequestMapping("/admin/bigdataSafetyWarning")
public class BigdataSafetyWarningController extends BaseController{
	
	@Autowired
	private BigdataSafetyWarningService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataSafetyWarning", notes = "分页查询BigdataSafetyWarning")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataSafetyWarningQuery query){
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
	@ApiOperation(value = "新增修改BigdataSafetyWarning", notes = "新增修改BigdataSafetyWarning")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataSafetyWarning voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataSafetyWarning", notes = "根据ID批量删除BigdataSafetyWarning")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/deleteByIds",method = RequestMethod.POST)
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
	@ApiOperation(value = "根据ID加载BigdataSafetyWarning", notes = "根据ID加载BigdataSafetyWarning")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}


	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/qtlistpage",method = RequestMethod.POST)
	public ModelAndView qtlistpage(@ModelAttribute BigdataSafetyWarningQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.qtlistpage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	//统计数量
	@RequestMapping(value = "/safetyWarningCount",method = RequestMethod.POST)
	public ModelAndView safetyWarningCount(@ModelAttribute BigdataSafetyWarningQuery query){
		ModelAndView modelAndView = new ModelAndView();
		int safetyWarningCount = service.safetyWarningCount(query);
		buildResponse(modelAndView,safetyWarningCount);
		return modelAndView;
	}


	
}
