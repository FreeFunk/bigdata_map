package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.bigdata.queryvo.BeidouDataInCountView;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BeidouDataInCount;
import com.edgedo.bigdata.queryvo.BeidouDataInCountQuery;
import com.edgedo.bigdata.service.BeidouDataInCountService;
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


@Api(tags = "BeidouDataInCount")
@Controller
@RequestMapping("/admin/beidouDataInCount")
public class BeidouDataInCountController extends BaseController{
	
	@Autowired
	private BeidouDataInCountService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BeidouDataInCount", notes = "分页查询BeidouDataInCount")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BeidouDataInCountQuery query){
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
	@ApiOperation(value = "新增修改BeidouDataInCount", notes = "新增修改BeidouDataInCount")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BeidouDataInCount voObj){
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
	@ApiOperation(value = "根据ID批量删除BeidouDataInCount", notes = "根据ID批量删除BeidouDataInCount")
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
	@ApiOperation(value = "根据ID加载BeidouDataInCount", notes = "根据ID加载BeidouDataInCount")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	/**
	 * @Author ZhaoSiDa
	 * @Description //获取北斗统计的数据
	 * @Date 2019/3/28 9:28
	 * @Param [query]
	 * @return org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/getbeidouInCountData",method = RequestMethod.POST)
	public ModelAndView getbeidouInCountData(@ModelAttribute BeidouDataInCountQuery query){
		ModelAndView modelAndView = new ModelAndView();
		BeidouDataInCountView beidouDataInCountView= service.getbeidouInCountData(query);
		buildResponse(modelAndView,beidouDataInCountView);
		return modelAndView;
	}


	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/listpageForBeidouData",method = RequestMethod.POST)
	public ModelAndView listpageForBeidouData(@ModelAttribute BeidouDataInCountQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listpageForBeidouData(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	
	
}
