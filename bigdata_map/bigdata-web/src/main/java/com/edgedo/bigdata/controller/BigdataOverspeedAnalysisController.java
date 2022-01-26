package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.bigdata.entity.OverspeedEchartsVo;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisView;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataOverspeedAnalysis;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisQuery;
import com.edgedo.bigdata.service.BigdataOverspeedAnalysisService;
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


@Api(tags = "BigdataOverspeedAnalysis")
@Controller
@RequestMapping("/admin/bigdataOverspeedAnalysis")
public class BigdataOverspeedAnalysisController extends BaseController{
	
	@Autowired
	private BigdataOverspeedAnalysisService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataOverspeedAnalysis", notes = "分页查询BigdataOverspeedAnalysis")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataOverspeedAnalysisQuery query){
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
	@ApiOperation(value = "新增修改BigdataOverspeedAnalysis", notes = "新增修改BigdataOverspeedAnalysis")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataOverspeedAnalysis voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataOverspeedAnalysis", notes = "根据ID批量删除BigdataOverspeedAnalysis")
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
	@ApiOperation(value = "根据ID加载BigdataOverspeedAnalysis", notes = "根据ID加载BigdataOverspeedAnalysis")
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
	@RequestMapping(value = "/getOverspeedAnalysisData",method = RequestMethod.POST)
	public ModelAndView  getOverspeedAnalysisData(BigdataOverspeedAnalysisQuery query){
		ModelAndView modelAndView = new ModelAndView();
		BigdataOverspeedAnalysisView bigdataOverspeedAnalysisView = service.getOverspeedAnalysisData(query);
		return buildResponse(modelAndView, bigdataOverspeedAnalysisView);
	}

	/**
	 * @Author ZhaoSiDa
	 * @Description //获取详情的柱状图的数据
	 * @Date 2019/3/26 16:47
	 * @Param [query]
	 * @return org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/getOverspeedEchartsData",method = RequestMethod.POST)
	public ModelAndView getOverspeedEchartsData(BigdataOverspeedAnalysisQuery query){
		ModelAndView modelAndView = new ModelAndView();
        OverspeedEchartsVo overspeedEchartsVo = service.getOverspeedEchartsData(query);
		return buildResponse(modelAndView, overspeedEchartsVo);
	}


}
