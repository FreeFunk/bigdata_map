package com.edgedo.drawing.controller;


import java.text.SimpleDateFormat;
import java.util.*;

import com.edgedo.common.base.BaseController;
import com.edgedo.drawing.entity.BigdataDriverStopCount;
import com.edgedo.drawing.queryvo.BigdataDriverStopCountQuery;
import com.edgedo.drawing.queryvo.BigdataDriverStopCountView;
import com.edgedo.drawing.service.BigdataDriverStopCountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataDriverStopCount")
@Controller
@RequestMapping("/admin/bigdataDriverStopCount")
public class BigdataDriverStopCountController extends BaseController{
	
	@Autowired
	private BigdataDriverStopCountService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataDriverStopCount", notes = "分页查询BigdataDriverStopCount")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataDriverStopCountQuery query){
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
	@ApiOperation(value = "新增修改BigdataDriverStopCount", notes = "新增修改BigdataDriverStopCount")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataDriverStopCount voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataDriverStopCount", notes = "根据ID批量删除BigdataDriverStopCount")
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
	@ApiOperation(value = "根据ID加载BigdataDriverStopCount", notes = "根据ID加载BigdataDriverStopCount")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	@ApiOperation(value = "根据DRIVER_ID加载BigdataDriverStopCount", notes = "根据DRIVER_ID加载BigdataDriverStopCount")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/selectDriverStopByDriverId",method = RequestMethod.POST)
	public ModelAndView selectDriverStopByDriverId(@ModelAttribute BigdataDriverStopCountQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> resultMap = new HashMap<>();
		List<String> dateList = new ArrayList<>();
		List<Map<String,Object>> stopCityList = new ArrayList<>();

		int yearNum = query.getQueryObj().getYearNum();

		//查询一下该驾驶员一年都去过哪些城市
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("yearNum",yearNum);
		paramMap.put("countType","MONTH");
		paramMap.put("driverId",query.getQueryObj().getDriverId());
		List<String> cityList = service.selectTotalStopCity(paramMap);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat sdfTime = new SimpleDateFormat("M月");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,yearNum);
		for(int i=0;i<12;i++){
			calendar.set(Calendar.MONTH,i);
			Date date = calendar.getTime();
			String monthStr = sdf.format(date);
			int countMonth = Integer.parseInt(monthStr);
			query.getQueryObj().setCountMonth(countMonth);
			query.getQueryObj().setCountType("MONTH");

			//存放展示日期
			String dateStr = sdfTime.format(date);
			dateList.add(dateStr);

			//存放停靠城市和次数
			Map<String,Object> stopCityMap = new HashMap<>();
			for(int j=0;j<cityList.size();j++){
				query.getQueryObj().setMapCity(cityList.get(j));
				BigdataDriverStopCountView driverStop = service.selectListByDriverIdAndCity(query);
				if(driverStop != null){
					stopCityMap.put(cityList.get(j),driverStop.getStopNum());
				}else{
					stopCityMap.put(cityList.get(j),0);
				}
			}
			stopCityList.add(stopCityMap);
		}
		//将数据返回
		resultMap.put("dateList",dateList);
		resultMap.put("cityList",cityList);
		resultMap.put("stopCityList",stopCityList);
		return buildResponse(modelAndView,resultMap);
	}

	/*
	*司机停靠城市展示
	* */
	@RequestMapping(value = "/selectDriverStopByDriverIdNew",method = RequestMethod.POST)
	public ModelAndView selectDriverStopByDriverIdNew(@ModelAttribute BigdataDriverStopCountQuery query){
		ModelAndView modelAndView = new ModelAndView();
		int yearNum = query.getQueryObj().getYearNum();
		//查询一下该驾驶员一年都去过哪些城市
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("yearNum",yearNum);
		paramMap.put("countType","YEAR");
		paramMap.put("driverId",query.getQueryObj().getDriverId());
		List<BigdataDriverStopCountView> driverStopCountViewList = service.selectTotalStopCityNew(paramMap);
		return buildResponse(modelAndView,driverStopCountViewList);
	}
	
}
