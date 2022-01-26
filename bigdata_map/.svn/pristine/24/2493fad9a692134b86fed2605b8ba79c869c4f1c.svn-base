package com.edgedo.bigdata.controller;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.queryvo.*;
import com.edgedo.bigdata.service.*;
import com.edgedo.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;


@Api(tags = "BigdataFenxiCarAlarmWeek")
@Controller
@RequestMapping("/admin/bigdataFenxiCarAlarmWeek")
public class BigdataFenxiCarAlarmWeekController extends BaseController{
	
	@Autowired
	private BigdataFenxiCarAlarmWeekService service;
	@Autowired
	private BigdataFenxiCarWeekService fenxiCarWeekService;
	@Autowired
	private BigdataFenxiTeamWeekService fenxiTeamWeekService;
	@Autowired
	private BigdataTimeCarDayRecService carDayRecService;
	@Autowired
	private BigdataFenxiTeamDayService teamDayService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataFenxiCarAlarmWeek", notes = "分页查询BigdataFenxiCarAlarmWeek")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataFenxiCarAlarmWeekQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}


	/*@ApiOperation(value = "分页查询BigdataFenxiCarAlarmWeek", notes = "分页查询BigdataFenxiCarAlarmWeek")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listByObj",method = RequestMethod.POST)
	public ModelAndView listByObj(@ModelAttribute BigdataFenxiCarAlarmWeekQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> returnParam = new HashMap<>();
		//查询详细信息
		String ownerCarDayId = query.getQueryObj().getOwnerCarDayId();
		//车辆周分析查询参数
		BigdataFenxiCarWeekQuery weekQuery = new BigdataFenxiCarWeekQuery();
		weekQuery.getQueryObj().setId(ownerCarDayId);
		weekQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
		//企业周分析查询参数

		//车辆每天数据分析查询参数
		BigdataTimeCarDayRecQuery dayRecQuery = new BigdataTimeCarDayRecQuery();
		dayRecQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
		//企业每天数据分析查询参数
		BigdataFenxiTeamDayQuery teamDayQuery = new BigdataFenxiTeamDayQuery();
		teamDayQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
		//根据参数分析出月份和周数
		String weekCountStr = query.getQueryObj().getWeekCountStr();
		if(weekCountStr != null && !weekCountStr.equals("")){
			String[] weekCountArr = weekCountStr.split("@@");
			query.getQueryObj().setCountWeek(Integer.parseInt(weekCountArr[0]));
			query.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
			//用于查询车辆周分析信息
			weekQuery.getQueryObj().setCountWeek(Integer.parseInt(weekCountArr[0]));
			weekQuery.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
			//用于查询企业周分析信息
			teamWeekQuery.getQueryObj().setCountWeek(Integer.parseInt(weekCountArr[0]));
			teamWeekQuery.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
			//用于车辆每天查询
			dayRecQuery.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
			//用于企业每天查询
			teamDayQuery.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
		}
		//查询出该辆车的信息
		BigdataFenxiCarWeek fenxiCarWeek = fenxiCarWeekService.selectById(weekQuery);
		//查询出企业的信息
		if(fenxiCarWeek != null){
			teamWeekQuery.getQueryObj().setId(fenxiCarWeek.getOwnerTeamId());
			BigdataFenxiTeamWeek fenxiTeamWeek = fenxiTeamWeekService.selectById(teamWeekQuery);
			returnParam.put("fenxiTeamWeek",fenxiTeamWeek);
			//车辆日查询
			Date countDateStart = fenxiCarWeek.getStartCountDate();
			Date countDateEnd = fenxiCarWeek.getEndCountDate();

			List<BigdataTimeCarDayRec> carDayRecList = new ArrayList<>();
			List<BigdataFenxiTeamDay> teamDayList = new ArrayList<>();

			List<Integer> countDateList = getCountDateList(countDateStart,countDateEnd);
			for(int i=0;i<countDateList.size();i++){
				//查询车辆每天的信息
				String carFrameNum = fenxiCarWeek.getCarFrameNum();
				dayRecQuery.getQueryObj().setCarFrameNum(carFrameNum);
				dayRecQuery.getQueryObj().setCountDate(countDateList.get(i));
				BigdataTimeCarDayRec carDayRec = carDayRecService.selectByCarFrameNumAndCountDate(dayRecQuery);
				if(carDayRec == null){
					carDayRec = new BigdataTimeCarDayRec();
					carDayRec.setSumMileage(new BigDecimal(0));
					carDayRec.setSumDuration(new BigDecimal(0));
					carDayRec.setAlarmNum(0);
				}
				carDayRecList.add(carDayRec);
				//查询企业每天的信息
				teamDayQuery.getQueryObj().setId(fenxiCarWeek.getOwnerTeamId());
				teamDayQuery.getQueryObj().setCountDate(countDateList.get(i));
				BigdataFenxiTeamDay teamDay = teamDayService.selectByIdAndCountDate(teamDayQuery);
				if(teamDay == null){
					teamDay = new BigdataFenxiTeamDay();
					teamDay.setRunMileage(new BigDecimal(0));
					teamDay.setRunTimeLength(0);
					teamDay.setAlarmNum(0);
				}
				teamDayList.add(teamDay);
			}
			//返回车辆每天的数据
			returnParam.put("carDayRecList",carDayRecList);
			//返回企业每天的数据
			returnParam.put("teamDayRecList",teamDayList);
		}

		service.listByObj(query);
		returnParam.put("fenxiCarWeek",fenxiCarWeek);
		returnParam.put("carAlarmWeekList",query.getList());
		buildResponse(modelAndView,returnParam);
		return modelAndView;
	}*/

	@RequestMapping(value = "/selectAlarmTypeByCarWeek",method = RequestMethod.POST)
	public ModelAndView selectAlarmTypeByCarWeek(@ModelAttribute BigdataFenxiCarAlarmWeekQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String countWeekStr = query.getQueryObj().getWeekCountStr();
		if(countWeekStr != null && !countWeekStr.equals("")){
			String[] weekCountArr = countWeekStr.split("@@");
			query.getQueryObj().setCountWeek(Integer.parseInt(weekCountArr[0]));
			query.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
		}
		service.listByObj(query);
		return buildResponse(modelAndView,query);
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改BigdataFenxiCarAlarmWeek", notes = "新增修改BigdataFenxiCarAlarmWeek")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataFenxiCarAlarmWeek voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataFenxiCarAlarmWeek", notes = "根据ID批量删除BigdataFenxiCarAlarmWeek")
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
	@ApiOperation(value = "根据ID加载BigdataFenxiCarAlarmWeek", notes = "根据ID加载BigdataFenxiCarAlarmWeek")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	
}
