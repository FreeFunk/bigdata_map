package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.bigdata.entity.BigdataBeidouComp;
import com.edgedo.bigdata.entity.CarInfoForVideo;
import com.edgedo.bigdata.service.BigdataBeidouCompService;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataBeidouSafetyCarInfo;
import com.edgedo.bigdata.queryvo.BigdataBeidouSafetyCarInfoQuery;
import com.edgedo.bigdata.service.BigdataBeidouSafetyCarInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataBeidouSafetyCarInfo")
@Controller
@RequestMapping("/admin/bigdataBeidouSafetyCarInfo")
public class BigdataBeidouSafetyCarInfoController extends BaseController{
	
	@Autowired
	private BigdataBeidouSafetyCarInfoService service;
	@Autowired
	private BigdataBeidouCompService bigdataBeidouCompService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataBeidouSafetyCarInfo", notes = "分页查询BigdataBeidouSafetyCarInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataBeidouSafetyCarInfoQuery query){
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
	@ApiOperation(value = "新增修改BigdataBeidouSafetyCarInfo", notes = "新增修改BigdataBeidouSafetyCarInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataBeidouSafetyCarInfo voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataBeidouSafetyCarInfo", notes = "根据ID批量删除BigdataBeidouSafetyCarInfo")
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
	@ApiOperation(value = "根据ID加载BigdataBeidouSafetyCarInfo", notes = "根据ID加载BigdataBeidouSafetyCarInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	@ApiOperation(value = "根据ID加载BigdataBeidouSafetyCarInfo", notes = "根据ID加载BigdataBeidouSafetyCarInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadByCarPlateForVideo",method = RequestMethod.POST)
	public ModelAndView  loadByIdForVideo(String carPlateNum,String carPlateColor){
		ModelAndView modelAndView = new ModelAndView();
		CarInfoForVideo carInfoForVideo = new CarInfoForVideo();
		BigdataBeidouSafetyCarInfo bigdataBeidouSafetyCarInfo = service.selectByCarPlateNumAndColor(carPlateNum,carPlateColor);
		if(bigdataBeidouSafetyCarInfo==null){
			return buildResponse(modelAndView, "");
		}
		carInfoForVideo.setCarPlateNum(bigdataBeidouSafetyCarInfo.getCarPlateNum());
		carInfoForVideo.setCarPlateColor(bigdataBeidouSafetyCarInfo.getCarPlateColor());
		carInfoForVideo.setSim(bigdataBeidouSafetyCarInfo.getSim());
		carInfoForVideo.setDeviceType(bigdataBeidouSafetyCarInfo.getDeviceType());
		carInfoForVideo.setChannelEnable(bigdataBeidouSafetyCarInfo.getChannelEnable());

		BigdataBeidouComp bigdataBeidouComp = bigdataBeidouCompService.loadById(bigdataBeidouSafetyCarInfo.getCompId());
		carInfoForVideo.setLiveIp(bigdataBeidouComp.getLiveIp());
		carInfoForVideo.setLivePort(bigdataBeidouComp.getLivePort());
		carInfoForVideo.setLiveType(bigdataBeidouComp.getLiveType());
		return buildResponse(modelAndView, carInfoForVideo);
	}
	
}
