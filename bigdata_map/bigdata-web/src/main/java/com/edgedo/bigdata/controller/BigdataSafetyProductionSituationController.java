package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.bigdata.entity.BigdataSafetyProductionEchatsVo;
import com.edgedo.bigdata.queryvo.BigdataSafetyProductionSituationView;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataSafetyProductionSituation;
import com.edgedo.bigdata.queryvo.BigdataSafetyProductionSituationQuery;
import com.edgedo.bigdata.service.BigdataSafetyProductionSituationService;
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


@Api(tags = "BigdataSafetyProductionSituation")
@Controller
@RequestMapping("/admin/bigdataSafetyProductionSituation")
public class BigdataSafetyProductionSituationController extends BaseController{
	
	@Autowired
	private BigdataSafetyProductionSituationService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataSafetyProductionSituation", notes = "分页查询BigdataSafetyProductionSituation")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataSafetyProductionSituationQuery query){
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
	@ApiOperation(value = "新增修改BigdataSafetyProductionSituation", notes = "新增修改BigdataSafetyProductionSituation")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataSafetyProductionSituation voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataSafetyProductionSituation", notes = "根据ID批量删除BigdataSafetyProductionSituation")
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
	@ApiOperation(value = "根据ID加载BigdataSafetyProductionSituation", notes = "根据ID加载BigdataSafetyProductionSituation")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	/**
	 * @Author ZhaoSiDa
	 * @Description //获取安全形势的数据
	 * @Date 2019/3/28 15:11
	 * @Param [query]
	 * @return org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/getSafetyProductionSituationData",method = RequestMethod.POST)
	public ModelAndView getSafetyProductionSituationData(@ModelAttribute BigdataSafetyProductionSituationQuery query){
		ModelAndView modelAndView = new ModelAndView();
		BigdataSafetyProductionSituationView bigdataSafetyProductionSituationView = service.getSafetyProductionSituationData(query);
		buildResponse(modelAndView,bigdataSafetyProductionSituationView);
		return modelAndView;
	}

	/**
	 * @Author ZhaoSiDa
	 * @Description //获取安全形势的图表数据
	 * @Date 2019/3/28 15:11
	 * @Param [query]
	 * @return org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/safetyProductionEchartsData",method = RequestMethod.POST)
	public ModelAndView safetyProductionEchartsData(@ModelAttribute BigdataSafetyProductionSituationQuery query){
		ModelAndView modelAndView = new ModelAndView();
		BigdataSafetyProductionEchatsVo bigdataSafetyProductionEchatsVo = service.safetyProductionEchartsData(query);
		buildResponse(modelAndView,bigdataSafetyProductionEchatsVo);
		return modelAndView;
	}
	
	
}
