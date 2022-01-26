package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.bigdata.entity.BigdataFatigueEchartsVo;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisView;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataFatigueAnalysis;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisQuery;
import com.edgedo.bigdata.service.BigdataFatigueAnalysisService;
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


@Api(tags = "BigdataFatigueAnalysis")
@Controller
@RequestMapping("/admin/bigdataFatigueAnalysis")
public class BigdataFatigueAnalysisController extends BaseController{
	
	@Autowired
	private BigdataFatigueAnalysisService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataFatigueAnalysis", notes = "分页查询BigdataFatigueAnalysis")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataFatigueAnalysisQuery query){
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
	@ApiOperation(value = "新增修改BigdataFatigueAnalysis", notes = "新增修改BigdataFatigueAnalysis")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataFatigueAnalysis voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataFatigueAnalysis", notes = "根据ID批量删除BigdataFatigueAnalysis")
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
	@ApiOperation(value = "根据ID加载BigdataFatigueAnalysis", notes = "根据ID加载BigdataFatigueAnalysis")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}


	/**
	 * @Author ZhaoSiDa
	 * @Description //首页获取超速分析的数据
	 * @Date 2019/3/26 16:47
	 * @Param [query]
	 * @return org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/getFatigueAnalysisData",method = RequestMethod.POST)
	public ModelAndView  getFatigueAnalysisData(BigdataFatigueAnalysisQuery query){
		ModelAndView modelAndView = new ModelAndView();
		BigdataFatigueAnalysisView bigdataFatigueAnalysisView = service.getFatigueAnalysisData(query);
		return buildResponse(modelAndView, bigdataFatigueAnalysisView);
	}

	/**
	 * @Author ZhaoSiDa
	 * @Description //获取详情的柱状图的数据
	 * @Date 2019/3/26 16:47
	 * @Param [query]
	 * @return org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/getFatigueEchartsData",method = RequestMethod.POST)
	public ModelAndView getFatigueEchartsData(BigdataFatigueAnalysisQuery query){
		ModelAndView modelAndView = new ModelAndView();
		BigdataFatigueEchartsVo bigdataFatigueEchartsVo = service.getFatigueEchartsData(query);
		return buildResponse(modelAndView, bigdataFatigueEchartsVo);
	}
	
}
