package com.edgedo.drawing.controller;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.drawing.entity.BigdataDriverCountMonthAndYear;
import com.edgedo.drawing.entity.BigdataDriverDrawInfo;
import com.edgedo.drawing.queryvo.BigdataDriverCountMonthAndYearQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCountMonthAndYearView;
import com.edgedo.drawing.service.BigdataDriverCountMonthAndYearService;
import com.edgedo.drawing.service.BigdataDriverDrawInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataDriverCountMonthAndYear")
@Controller
@RequestMapping("/admin/bigdataDriverCountMonthAndYear")
public class BigdataDriverCountMonthAndYearController extends BaseController{
	
	@Autowired
	private BigdataDriverCountMonthAndYearService service;
	@Autowired
	private BigdataDriverDrawInfoService drawInfoService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataDriverCountMonthAndYear", notes = "分页查询BigdataDriverCountMonthAndYear")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataDriverCountMonthAndYearQuery query){
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
	@ApiOperation(value = "新增修改BigdataDriverCountMonthAndYear", notes = "新增修改BigdataDriverCountMonthAndYear")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataDriverCountMonthAndYear voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataDriverCountMonthAndYear", notes = "根据ID批量删除BigdataDriverCountMonthAndYear")
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
	@ApiOperation(value = "根据ID加载BigdataDriverCountMonthAndYear", notes = "根据ID加载BigdataDriverCountMonthAndYear")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	/**
	 * 根据驾驶员id查询行驶里程
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "根据driver_id加载BigdataDriverCountMonthAndYear", notes = "根据driver_id加载BigdataDriverCountMonthAndYear")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/selectMileageByDriverId",method = RequestMethod.POST)
	public ModelAndView selectMileageByDriverId(@ModelAttribute BigdataDriverCountMonthAndYearQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> resultMap = new HashMap<>();
		List<String> dateList = new ArrayList<>();
		List<BigDecimal> totalMileageList = new ArrayList<>();
		List<BigDecimal> dayMileageList = new ArrayList<>();
		List<BigDecimal> nightMileageList = new ArrayList<>();

		int yearNum = query.getQueryObj().getYearNum();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,yearNum);
		for(int i=0;i<12;i++){
			calendar.set(Calendar.MONTH,i);
			Date date = calendar.getTime();
			String monthStr = sdf.format(date);
			int countMonth = Integer.parseInt(monthStr);
			query.getQueryObj().setCountMonth(countMonth);

			//存放展示日期
			String dateStr = sdfTime.format(date);
			dateList.add(dateStr);
			BigdataDriverCountMonthAndYearView driverCount = service.selectByDriverId(query);
			if(driverCount != null){
				//总行驶里程
				totalMileageList.add(driverCount.getSumMileage());
				//白天行驶里程
				dayMileageList.add(driverCount.getDayRunMileage());
				//夜晚行驶里程
				nightMileageList.add(driverCount.getNightRunMileage());
			}else{
				//总行驶里程
				totalMileageList.add(new BigDecimal(0));
				//白天行驶里程
				dayMileageList.add(new BigDecimal(0));
				//夜晚行驶里程
				nightMileageList.add(new BigDecimal(0));
			}
		}
		//将数据返回
		resultMap.put("dateList",dateList);
		resultMap.put("totalMileageList",totalMileageList);
		resultMap.put("dayMileageList",dayMileageList);
		resultMap.put("nightMileageList",nightMileageList);
		return buildResponse(modelAndView,resultMap);
	}

	/**
	 * 根据驾驶员id查询行驶时长
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "根据driver_id加载BigdataDriverCountMonthAndYear", notes = "根据driver_id加载BigdataDriverCountMonthAndYear")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/selectDurationByDriverId",method = RequestMethod.POST)
	public ModelAndView selectDurationByDriverId(@ModelAttribute BigdataDriverCountMonthAndYearQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> resultMap = new HashMap<>();
		List<String> dateList = new ArrayList<>();
		List<BigDecimal> totalDurationList = new ArrayList<>();
		List<BigDecimal> dayDurationList = new ArrayList<>();
		List<BigDecimal> nightDurationList = new ArrayList<>();

		int yearNum = query.getQueryObj().getYearNum();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,yearNum);
		for(int i=0;i<12;i++){
			calendar.set(Calendar.MONTH,i);
			Date date = calendar.getTime();
			String monthStr = sdf.format(date);
			int countMonth = Integer.parseInt(monthStr);
			query.getQueryObj().setCountMonth(countMonth);

			//存放展示日期
			String dateStr = sdfTime.format(date);
			dateList.add(dateStr);
			BigdataDriverCountMonthAndYearView driverCount = service.selectByDriverId(query);
			if(driverCount != null){
				//总行驶时长
				totalDurationList.add((driverCount.getSumRunTimeLength()).divide(new BigDecimal(60.0),2, RoundingMode.HALF_UP));
				//白天行驶时长
				dayDurationList.add((driverCount.getDayRunTimeLength()).divide(new BigDecimal(60.0),2, RoundingMode.HALF_UP));
				//夜晚行驶时长
				nightDurationList.add((driverCount.getNightRunTimeLength()).divide(new BigDecimal(60.0),2, RoundingMode.HALF_UP));
			}else{
				//总行驶时长
				totalDurationList.add(new BigDecimal(0));
				//白天行驶时长
				dayDurationList.add(new BigDecimal(0));
				//夜晚行驶时长
				nightDurationList.add(new BigDecimal(0));
			}
		}
		//将数据返回
		resultMap.put("dateList",dateList);
		resultMap.put("totalDurationList",totalDurationList);
		resultMap.put("dayDurationList",dayDurationList);
		resultMap.put("nightDurationList",nightDurationList);
		return buildResponse(modelAndView,resultMap);
	}

	/**
	 * 根据驾驶员id查询行驶平均速度
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "根据driver_id加载BigdataDriverCountMonthAndYear", notes = "根据driver_id加载BigdataDriverCountMonthAndYear")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/selectSpeedByDriverId",method = RequestMethod.POST)
	public ModelAndView selectSpeedByDriverId(@ModelAttribute BigdataDriverCountMonthAndYearQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> resultMap = new HashMap<>();
		List<String> dateList = new ArrayList<>();
		List<BigDecimal> totalSpeedList = new ArrayList<>();
		List<BigDecimal> daySpeedList = new ArrayList<>();
		List<BigDecimal> nightSpeedList = new ArrayList<>();

		int yearNum = query.getQueryObj().getYearNum();
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

			//存放展示日期
			String dateStr = sdfTime.format(date);
			dateList.add(dateStr);
			BigdataDriverCountMonthAndYearView driverCount = service.selectByDriverId(query);
			if(driverCount != null){
				//总行驶时长
				totalSpeedList.add(driverCount.getAverageSpeed());
				//白天行驶时长
				daySpeedList.add(driverCount.getDayRunAverageSpeed());
				//夜晚行驶时长
				nightSpeedList.add(driverCount.getNightRunAverageSpeed());
			}else{
				//总行驶时长
				totalSpeedList.add(new BigDecimal(0));
				//白天行驶时长
				daySpeedList.add(new BigDecimal(0));
				//夜晚行驶时长
				nightSpeedList.add(new BigDecimal(0));
			}
		}
		//将数据返回
		resultMap.put("dateList",dateList);
		resultMap.put("totalSpeedList",totalSpeedList);
		resultMap.put("daySpeedList",daySpeedList);
		resultMap.put("nightSpeedList",nightSpeedList);
		return buildResponse(modelAndView,resultMap);
	}

	/**
	 * 根据驾驶员id查询报警统计情况
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "根据driver_id加载BigdataDriverCountMonthAndYear", notes = "根据driver_id加载BigdataDriverCountMonthAndYear")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/selectAlarmByDriverId",method = RequestMethod.POST)
	public ModelAndView selectAlarmByDriverId(@ModelAttribute BigdataDriverCountMonthAndYearQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> resultMap = new HashMap<>();
		List<String> dateList = new ArrayList<>();
		List<Integer> overSpeedList = new ArrayList<>();
		List<Integer> seriousOverSpeedList = new ArrayList<>();
		List<Integer> tiredList = new ArrayList<>();
		List<Integer> seriousTiredList = new ArrayList<>();
		List<Integer> safetyList = new ArrayList<>();

		int yearNum = query.getQueryObj().getYearNum();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,yearNum);
		for(int i=0;i<12;i++){
			calendar.set(Calendar.MONTH,i);
			Date date = calendar.getTime();
			String monthStr = sdf.format(date);
			int countMonth = Integer.parseInt(monthStr);
			query.getQueryObj().setCountMonth(countMonth);

			//存放展示日期
			String dateStr = sdfTime.format(date);
			dateList.add(dateStr);
			BigdataDriverCountMonthAndYearView driverCount = service.selectByDriverId(query);
			if(driverCount != null){
				//超速驾驶次数
				overSpeedList.add(driverCount.getOverspeedNum());
				//严重超速驾驶次数
				seriousOverSpeedList.add(driverCount.getSeriousOverspeedNum());
				//疲劳驾驶次数
				tiredList.add(driverCount.getTiredNum());
				//严重疲劳驾驶次数
				seriousTiredList.add(driverCount.getSeriousTiredNum());
				//主动安全次数
				safetyList.add(driverCount.getSafetyWarningNum());
			}else{
				//超速驾驶次数
				overSpeedList.add(0);
				//严重超速驾驶次数
				seriousOverSpeedList.add(0);
				//疲劳驾驶次数
				tiredList.add(0);
				//严重疲劳驾驶次数
				seriousTiredList.add(0);
				//主动安全次数
				safetyList.add(0);
			}
		}
		//将数据返回
		resultMap.put("dateList",dateList);
		resultMap.put("overSpeedList",overSpeedList);
		resultMap.put("seriousOverSpeedList",seriousOverSpeedList);
		resultMap.put("tiredList",tiredList);
		resultMap.put("seriousTiredList",seriousTiredList);
		resultMap.put("safetyList",safetyList);
		return buildResponse(modelAndView,resultMap);
	}

	/**
	 * 根据驾驶员id查询安全培训情况
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "根据driver_id加载BigdataDriverCountMonthAndYear", notes = "根据driver_id加载BigdataDriverCountMonthAndYear")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/selectSafetyTrainByDriverId",method = RequestMethod.POST)
	public ModelAndView selectSafetyTrainByDriverId(@ModelAttribute BigdataDriverCountMonthAndYearQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> resultMap = new HashMap<>();
		List<String> dateList = new ArrayList<>();
		List<Integer> safetyTrainList = new ArrayList<>();

		int yearNum = query.getQueryObj().getYearNum();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,yearNum);
		for(int i=0;i<12;i++){
			calendar.set(Calendar.MONTH,i);
			Date date = calendar.getTime();
			String monthStr = sdf.format(date);
			int countMonth = Integer.parseInt(monthStr);
			query.getQueryObj().setCountMonth(countMonth);

			//存放展示日期
			String dateStr = sdfTime.format(date);
			dateList.add(dateStr);
			BigdataDriverCountMonthAndYearView driverCount = service.selectByDriverId(query);
			if(driverCount != null){
				//安全培训次数
				safetyTrainList.add(driverCount.getSafetrainNum());
			}else{
				//安全培训次数
				safetyTrainList.add(0);
			}
		}
		//将数据返回
		resultMap.put("dateList",dateList);
		resultMap.put("safetyTrainList",safetyTrainList);
		return buildResponse(modelAndView,resultMap);
	}
	
}
