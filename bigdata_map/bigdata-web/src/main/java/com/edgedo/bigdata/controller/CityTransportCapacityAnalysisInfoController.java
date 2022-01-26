package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.bigdata.entity.BigdataBeidouCompDayCheck;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompDayCheckView;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisInfoView;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.CityTransportCapacityAnalysisInfo;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisInfoQuery;
import com.edgedo.bigdata.service.CityTransportCapacityAnalysisInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "CityTransportCapacityAnalysisInfo")
@Controller
@RequestMapping("/admin/cityTransportCapacityAnalysisInfo")
public class CityTransportCapacityAnalysisInfoController extends BaseController{
	
	@Autowired
	private CityTransportCapacityAnalysisInfoService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询CityTransportCapacityAnalysisInfo", notes = "分页查询CityTransportCapacityAnalysisInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute CityTransportCapacityAnalysisInfoQuery query){
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
	@ApiOperation(value = "新增修改CityTransportCapacityAnalysisInfo", notes = "新增修改CityTransportCapacityAnalysisInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(CityTransportCapacityAnalysisInfo voObj){
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
	@ApiOperation(value = "根据ID批量删除CityTransportCapacityAnalysisInfo", notes = "根据ID批量删除CityTransportCapacityAnalysisInfo")
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
	@ApiOperation(value = "根据ID加载CityTransportCapacityAnalysisInfo", notes = "根据ID加载CityTransportCapacityAnalysisInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	@RequestMapping(value = "/listByCountDate",method = RequestMethod.POST)
	public ModelAndView listByCountDate(CityTransportCapacityAnalysisInfo cityTransportCapacityAnalysisInfo){
		ModelAndView modelAndView = new ModelAndView();
		List<CityTransportCapacityAnalysisInfoView> cityTransportCapacityAnalysisInfoViewList = service.listByCountDate(cityTransportCapacityAnalysisInfo);
		buildResponse(modelAndView,cityTransportCapacityAnalysisInfoViewList);
		return modelAndView;
	}
}
