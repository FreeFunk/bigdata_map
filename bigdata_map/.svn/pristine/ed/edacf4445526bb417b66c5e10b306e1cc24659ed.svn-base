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
import org.springframework.data.redis.repository.support.QueryByExampleRedisExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataFenxiCarAlarmMonth")
@Controller
@RequestMapping("/admin/bigdataFenxiCarAlarmMonth")
public class BigdataFenxiCarAlarmMonthController extends BaseController{
	
	@Autowired
	private BigdataFenxiCarAlarmMonthService service;
	@Autowired
	private BigdataFenxiCarMonthService fenxiCarMonthService;
	@Autowired
	private BigdataFenxiTeamMonthService teamMonthService;
	@Autowired
	private BigdataTimeCarDayRecService carDayRecService;
	@Autowired
	private BigdataFenxiTeamDayService teamDayService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataFenxiCarAlarmMonth", notes = "分页查询BigdataFenxiCarAlarmMonth")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataFenxiCarAlarmMonthQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}


	/*@ApiOperation(value = "非分页查询BigdataFenxiCarAlarmMonth", notes = "非分页查询BigdataFenxiCarAlarmMonth")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listByObj",method = RequestMethod.POST)
	public ModelAndView listByObj(@ModelAttribute BigdataFenxiCarAlarmMonthQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> returnParam = new HashMap<>();
		String ownerCarMonthId = query.getQueryObj().getOwnerCarMonthId();
		//查询出该辆车的分析信息
		BigdataFenxiCarMonthQuery monthQuery = new BigdataFenxiCarMonthQuery();
		//企业月信息查询参数
		BigdataFenxiTeamMonthQuery teamMonthQuery = new BigdataFenxiTeamMonthQuery();
		//企业月每天数据
		BigdataFenxiTeamDayQuery teamDayQuery = new BigdataFenxiTeamDayQuery();
		//车辆月每天数据
		BigdataTimeCarDayRecQuery carDayRecQuery = new BigdataTimeCarDayRecQuery();
		monthQuery.getQueryObj().setId(ownerCarMonthId);
		monthQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
		monthQuery.getQueryObj().setCountMonth(query.getQueryObj().getCountMonth());
		//企业月数据
		teamMonthQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
		teamMonthQuery.getQueryObj().setCountMonth(query.getQueryObj().getCountMonth());
		//企业月天数据
		teamDayQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
		teamDayQuery.getQueryObj().setCountMonth(query.getQueryObj().getCountMonth());
		//车辆月天数据
		carDayRecQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
		carDayRecQuery.getQueryObj().setCountMonth(query.getQueryObj().getCountMonth());

		BigdataFenxiCarMonth fenxiCarMonth = fenxiCarMonthService.selectById(monthQuery);
		if(fenxiCarMonth != null){
			teamMonthQuery.getQueryObj().setId(fenxiCarMonth.getOwnerTeamId());
			BigdataFenxiTeamMonth teamMonth = teamMonthService.selectById(teamMonthQuery);
			returnParam.put("teamMonth",teamMonth);
			//车辆每天数据查询
			String carFrameNum = fenxiCarMonth.getCarFrameNum();
			carDayRecQuery.getQueryObj().setCarFrameNum(carFrameNum);
			//存放返回数据
			List<BigdataTimeCarDayRec> carDayRecList = new ArrayList<>();
			List<BigdataFenxiTeamDay> teamDayList = new ArrayList<>();

			List<Integer> countDateList = getCountDateByCountMonth(query.getQueryObj().getCountMonth(),query.getQueryObj().getYearNum());
			for(int i=0;i<countDateList.size();i++){
				//车辆每天记录
				carDayRecQuery.getQueryObj().setCountDate(countDateList.get(i));
				BigdataTimeCarDayRec carDayRec = carDayRecService.selectByCarFrameNumAndCountDate(carDayRecQuery);
				if(carDayRec == null){
					carDayRec = new BigdataTimeCarDayRec();
					carDayRec.setSumMileage(new BigDecimal(0));
					carDayRec.setSumDuration(new BigDecimal(0));
					carDayRec.setAlarmNum(0);
				}
				carDayRecList.add(carDayRec);
				//企业每天数据查询
				String ownerTeamId = fenxiCarMonth.getOwnerTeamId();
				teamDayQuery.getQueryObj().setId(ownerTeamId);
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
			//车辆每天记录
			returnParam.put("carDayRecList",carDayRecList);
			//企业每天记录
			returnParam.put("teamDayList",teamDayList);
		}
		returnParam.put("fenxiCarMonth",fenxiCarMonth);
		//查询出该辆车报警类型信息
		service.listByObj(query);
		returnParam.put("carAlarmMonthList",query.getList());
		buildResponse(modelAndView,returnParam);
		return modelAndView;
	}*/

	@RequestMapping(value = "/selectCarAlarmTypeByCarWeek",method = RequestMethod.POST)
	public ModelAndView selectCarAlarmTypeByCarWeek(@ModelAttribute BigdataFenxiCarAlarmMonthQuery query){
		ModelAndView modelAndView = new ModelAndView();
		//查询出该辆车报警类型信息
		service.listByObj(query);
		return buildResponse(modelAndView,query);
	}

	//获取一个月的时间
	public List<Integer> getCountDateByCountMonth(int countMonth,int yearNum){
		List<Integer> countDateList = new ArrayList<>();
		//根据日的时间设置list
		String countMonthStr = countMonth+"";
		String[] countMonthArr = countMonthStr.split(yearNum+"");
		String monthStr = countMonthArr[1];
		int month = Integer.parseInt(monthStr);
		Calendar calendar = Calendar.getInstance();
		//判断一下是否为本月份
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyyMMdd");
		String nowStr = sdf.format(new Date());
		if(nowStr.equals(countMonthStr)){
			//如果是本月
			calendar.setTime(new Date());
			int nowDate = calendar.get(Calendar.DAY_OF_MONTH);
			for(int i=1;i<=nowDate;i++){
				calendar.set(Calendar.YEAR,yearNum);
				calendar.set(Calendar.MONTH,month-1);
				calendar.set(Calendar.DAY_OF_MONTH,i);
				Date newDate = calendar.getTime();
				int countDate = Integer.parseInt(sdfDay.format(newDate));
				countDateList.add(countDate);
			}
		}else{
			//如果不是本月
			calendar.set(Calendar.YEAR,yearNum);
			calendar.set(Calendar.MONTH,month-1);
			calendar.set(Calendar.DATE,1);
			calendar.roll(Calendar.DATE,-1);
			int nowDate = calendar.get(Calendar.DATE);
			for(int i=1;i<=nowDate;i++){
				calendar.set(Calendar.DATE,i);
				Date newDate = calendar.getTime();
				int countDate = Integer.parseInt(sdfDay.format(newDate));
				countDateList.add(countDate);
			}
		}
		return countDateList;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改BigdataFenxiCarAlarmMonth", notes = "新增修改BigdataFenxiCarAlarmMonth")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataFenxiCarAlarmMonth voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataFenxiCarAlarmMonth", notes = "根据ID批量删除BigdataFenxiCarAlarmMonth")
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
	@ApiOperation(value = "根据ID加载BigdataFenxiCarAlarmMonth", notes = "根据ID加载BigdataFenxiCarAlarmMonth")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	
}
