package com.edgedo.bigdata.controller;


import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.BigdataFenxiCount;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataFenxiAlarm;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmQuery;
import com.edgedo.bigdata.service.BigdataFenxiAlarmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataFenxiAlarm")
@Controller
@RequestMapping("/admin/bigdataFenxiAlarm")
public class BigdataFenxiAlarmController extends BaseController{
	
	@Autowired
	private BigdataFenxiAlarmService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataFenxiAlarm", notes = "分页查询BigdataFenxiAlarm")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataFenxiAlarmQuery query){
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
	@ApiOperation(value = "新增修改BigdataFenxiAlarm", notes = "新增修改BigdataFenxiAlarm")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataFenxiAlarm voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataFenxiAlarm", notes = "根据ID批量删除BigdataFenxiAlarm")
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
	@ApiOperation(value = "根据ID加载BigdataFenxiAlarm", notes = "根据ID加载BigdataFenxiAlarm")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	/**
	 * 查询扇形信息  报警类型
	 * @return
	 */
	@RequestMapping(value = "/selectBaoJingType",method = RequestMethod.POST)
	public ModelAndView  selectBaoJingType(String carType,String xianQuId,Integer timeCount,
										   Integer timeChangeAge,String timeChangeWeek,String timeType){
		ModelAndView modelAndView = new ModelAndView();
		List<BigdataFenxiAlarm> list = new ArrayList<>();
		//进行判断 什么时间类型
		if(timeType.equals("DAY")){
			//前台的时间数据类型  20190919
			//查询改天的 所有的车辆信息
			list = service.selectByDay(carType,xianQuId,timeCount,timeType);
		}else if (timeType.equals("WEEK")){//一周好几天   一个月多条记录 一天一条记录
			if(timeChangeWeek.indexOf("@@")==-1){
				list = service.selectByWeek(carType,xianQuId,timeChangeAge,new Integer(timeChangeWeek),timeType);
			}else {
				String[] str = timeChangeWeek.split("@@");
				String[] str1 = str[0].split("");
				list = service.selectByWeek(carType,xianQuId,timeChangeAge,new Integer(str1[1]+str1[2]),timeType);
			}

		}else if (timeType.equals("MONTH")){
			list = service.selectByMonth(carType,xianQuId,timeCount,timeType);
		}
		JSONArray jsonArrayChangGui = new JSONArray();
		JSONArray jsonArrayZhuDong = new JSONArray();
		for(BigdataFenxiAlarm bigdataFenxiAlarm : list){
			JSONObject jo = new JSONObject();
			if(bigdataFenxiAlarm.getAlarmCls().equals("0")){//常规
				jo.put("value", bigdataFenxiAlarm.getAlarmNum());
				jo.put("name", bigdataFenxiAlarm.getAlarmTypeDesc());
				jsonArrayChangGui.add(jo);
			}else if(bigdataFenxiAlarm.getAlarmCls().equals("1")) {//主动
				jo.put("value", bigdataFenxiAlarm.getAlarmNum());
				jo.put("name", bigdataFenxiAlarm.getAlarmTypeDesc());
				jsonArrayZhuDong.add(jo);
			}
		}

		Map<String,Object> map = new HashMap<>();
		map.put("jsonArrayChangGui",jsonArrayChangGui);
		map.put("jsonArrayZhuDong",jsonArrayZhuDong);
		return buildResponse(modelAndView,map);
	}
	
	
}
