package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionView;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.CarMonthDirectionDistribution;
import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionQuery;
import com.edgedo.bigdata.service.CarMonthDirectionDistributionService;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "CarMonthDirectionDistribution")
@Controller
@RequestMapping("/admin/carMonthDirectionDistribution")
public class CarMonthDirectionDistributionController extends BaseController{
	
	@Autowired
	private CarMonthDirectionDistributionService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询CarMonthDirectionDistribution", notes = "分页查询CarMonthDirectionDistribution")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute CarMonthDirectionDistributionQuery query){
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
	@ApiOperation(value = "新增修改CarMonthDirectionDistribution", notes = "新增修改CarMonthDirectionDistribution")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(CarMonthDirectionDistribution voObj){
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
	@ApiOperation(value = "根据ID批量删除CarMonthDirectionDistribution", notes = "根据ID批量删除CarMonthDirectionDistribution")
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
	@ApiOperation(value = "根据ID加载CarMonthDirectionDistribution", notes = "根据ID加载CarMonthDirectionDistribution")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}


	/**
	 * @Author ZhaoSiDa
	 * @Description 获取常跑省份
	 * @Date 2019/3/25 18:51
	 * @Param [query]
	 * @return org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/getOftenRunProvince",method = RequestMethod.POST)
	public ModelAndView  getOftenRunProvince(@ModelAttribute CarMonthDirectionDistributionQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<CarMonthDirectionDistributionView>  carMonthDirectionDistributionViewList = service.getOftenRunProvince(query);
		return buildResponse(modelAndView,carMonthDirectionDistributionViewList);
	}

	/**
	 * @Author ZhaoSiDa
	 * @Description 获取常跑城市
	 * @Date 2019/3/25 18:51
	 * @Param [query]
	 * @return org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/getOftenRunCity",method = RequestMethod.POST)
	public ModelAndView  getOftenRunCity(@ModelAttribute CarMonthDirectionDistributionQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<CarMonthDirectionDistributionView>  carMonthDirectionDistributionViewList = service.getOftenRunCity(query);
		return buildResponse(modelAndView,carMonthDirectionDistributionViewList);
	}

	
	
}
