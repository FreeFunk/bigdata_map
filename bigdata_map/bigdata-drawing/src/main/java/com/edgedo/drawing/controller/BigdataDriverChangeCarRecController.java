package com.edgedo.drawing.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.common.base.BaseController;

import com.edgedo.common.base.annotation.Pass;
import com.edgedo.drawing.entity.BigdataDriverChangeCarRec;
import com.edgedo.drawing.queryvo.BigdataDriverChangeCarRecQuery;
import com.edgedo.drawing.queryvo.BigdataDriverChangeCarRecView;
import com.edgedo.drawing.service.BigdataDriverChangeCarRecService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataDriverChangeCarRec")
@Controller
@RequestMapping("/admin/bigdataDriverChangeCarRec")
public class BigdataDriverChangeCarRecController extends BaseController{
	
	@Autowired
	private BigdataDriverChangeCarRecService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataDriverChangeCarRec", notes = "分页查询BigdataDriverChangeCarRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	@Pass
	public ModelAndView listpage(@ModelAttribute BigdataDriverChangeCarRecQuery query){
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
	@ApiOperation(value = "新增修改BigdataDriverChangeCarRec", notes = "新增修改BigdataDriverChangeCarRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataDriverChangeCarRec voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataDriverChangeCarRec", notes = "根据ID批量删除BigdataDriverChangeCarRec")
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
	@ApiOperation(value = "根据ID加载BigdataDriverChangeCarRec", notes = "根据ID加载BigdataDriverChangeCarRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	/**
	 * 根据主键加载
	 * @param driverId
	 * @return
	 */
	@ApiOperation(value = "根据ID加载BigdataDriverChangeCarRec", notes = "根据ID加载BigdataDriverChangeCarRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/selectByDriverId",method = RequestMethod.POST)
	public ModelAndView  selectByDriverId(String driverId){
		ModelAndView modelAndView = new ModelAndView();
		List<BigdataDriverChangeCarRecView> bigdataDriverChangeCarRecList  = service.selectByDriverId(driverId);
		return buildResponse(modelAndView,bigdataDriverChangeCarRecList);
	}


}
