package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.queryvo.CarMonthOftenrunRouteView;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.CarMonthOftenrunRoute;
import com.edgedo.bigdata.queryvo.CarMonthOftenrunRouteQuery;
import com.edgedo.bigdata.service.CarMonthOftenrunRouteService;
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


@Api(tags = "CarMonthOftenrunRoute")
@Controller
@RequestMapping("/admin/carMonthOftenrunRoute")
public class CarMonthOftenrunRouteController extends BaseController{
	
	@Autowired
	private CarMonthOftenrunRouteService service;
	@Autowired
	private CarInfoService carInfoService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询CarMonthOftenrunRoute", notes = "分页查询CarMonthOftenrunRoute")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute CarMonthOftenrunRouteQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}


	@RequestMapping(value = "/qtlistpage",method = RequestMethod.POST)
	public ModelAndView qtlistpage(@ModelAttribute CarMonthOftenrunRouteQuery query){
		String carType= query.getQueryObj().getCarType();
		if(carType!=null && carType.equals("总")){
			query.getQueryObj().setCarType(null);
		}
		ModelAndView modelAndView = new ModelAndView();
		service.qtlistPage(query);
		List<CarMonthOftenrunRouteView> carMonthOftenrunRouteViewList = query.getList();
		//查询车牌号是属于哪个县区的
		for(CarMonthOftenrunRouteView c:carMonthOftenrunRouteViewList){
			CarInfo carInfo = carInfoService.loadById(c.getCarRealId());
			if(carInfo!=null){
				c.setXianquName(carInfo.getXianquName());
			}
		}
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改CarMonthOftenrunRoute", notes = "新增修改CarMonthOftenrunRoute")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(CarMonthOftenrunRoute voObj){
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
	@ApiOperation(value = "根据ID批量删除CarMonthOftenrunRoute", notes = "根据ID批量删除CarMonthOftenrunRoute")
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
	@ApiOperation(value = "根据ID加载CarMonthOftenrunRoute", notes = "根据ID加载CarMonthOftenrunRoute")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	@RequestMapping(value = "/searchOftenRunRoute",method = RequestMethod.POST)
	public ModelAndView searchOftenRunRoute(@ModelAttribute CarMonthOftenrunRouteQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("carPlateNum",query.getQueryObj().getCarPlateNum());
		paramMap.put("carFrameNum",query.getQueryObj().getCarFrameNum());
		CarInfo carInfo = carInfoService.selectByPlateNumFrameNum(paramMap);
		if(carInfo != null){
			query.getQueryObj().setCarType(carInfo.getCarType());
		}
		List<CarMonthOftenrunRouteView> carOftenrunRouteList = service.searchOftenRunRoute(query);
		buildResponse(modelAndView,carOftenrunRouteList);
		return modelAndView;
	}

	@RequestMapping(value = "/selectOftenRunRoute",method = RequestMethod.POST)
	public ModelAndView selectOftenRunRoute(@ModelAttribute CarMonthOftenrunRouteQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<CarMonthOftenrunRouteView> carOftenrunRouteList = service.selectOftenRunRoute(query);
		buildResponse(modelAndView,carOftenrunRouteList);
		return modelAndView;
	}
}
