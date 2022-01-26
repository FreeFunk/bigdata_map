package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.edgedo.bigdata.entity.YwTrainConsumRec;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataPushLearnRec;
import com.edgedo.bigdata.queryvo.BigdataPushLearnRecQuery;
import com.edgedo.bigdata.service.BigdataPushLearnRecService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataPushLearnRec")
@Controller
@RequestMapping("/admin/bigdataPushLearnRec")
public class BigdataPushLearnRecController extends BaseController{
	
	@Autowired
	private BigdataPushLearnRecService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataPushLearnRec", notes = "分页查询BigdataPushLearnRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataPushLearnRecQuery query){
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
	@ApiOperation(value = "新增修改BigdataPushLearnRec", notes = "新增修改BigdataPushLearnRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataPushLearnRec voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataPushLearnRec", notes = "根据ID批量删除BigdataPushLearnRec")
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
	@ApiOperation(value = "根据ID加载BigdataPushLearnRec", notes = "根据ID加载BigdataPushLearnRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}


	/**
	 * 根据empId查询最近个月内的学记录
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "根据ID加载BigdataPushLearnRec", notes = "根据ID加载BigdataPushLearnRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/selectByEmpId",method = RequestMethod.POST)
	public ModelAndView  selectByEmpId(BigdataPushLearnRec voObj){
		ModelAndView modelAndView = new ModelAndView();
		LinkedHashMap<String,List<BigdataPushLearnRec>> bigdataPushLearnRecList = service.selectByEmpId(voObj);
		return buildResponse(modelAndView,bigdataPushLearnRecList);
	}

	/*
	*  根据从业资格证号查询学习记录
	* */
	@RequestMapping(value = "/selectSafetyRec",method = RequestMethod.POST)
	public ModelAndView  selectSafetyRec(String empId){
		ModelAndView modelAndView = new ModelAndView();
		List<YwTrainConsumRec> ywTrainConsumRecList = service.selectSafetyRec(empId);
		return buildResponse(modelAndView,ywTrainConsumRecList);
	}

	
}
