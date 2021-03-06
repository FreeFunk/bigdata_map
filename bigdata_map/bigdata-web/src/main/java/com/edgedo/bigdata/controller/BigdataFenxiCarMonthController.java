package com.edgedo.bigdata.controller;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamDayQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecQuery;
import com.edgedo.bigdata.service.BigdataFenxiTeamDayService;
import com.edgedo.bigdata.service.BigdataFenxiTeamMonthService;
import com.edgedo.bigdata.service.BigdataTimeCarDayRecService;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarMonthQuery;
import com.edgedo.bigdata.service.BigdataFenxiCarMonthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataFenxiCarMonth")
@Controller
@RequestMapping("/admin/bigdataFenxiCarMonth")
public class BigdataFenxiCarMonthController extends BaseController{
	
	@Autowired
	private BigdataFenxiCarMonthService service;
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
	@ApiOperation(value = "分页查询BigdataFenxiCarMonth", notes = "分页查询BigdataFenxiCarMonth")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataFenxiCarMonthQuery query){
		ModelAndView modelAndView = new ModelAndView();
		query.getQueryObj().setOwnerTeamName(query.getQueryObj().getCarPlateNum());
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改BigdataFenxiCarMonth", notes = "新增修改BigdataFenxiCarMonth")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataFenxiCarMonth voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataFenxiCarMonth", notes = "根据ID批量删除BigdataFenxiCarMonth")
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
	@ApiOperation(value = "根据ID加载BigdataFenxiCarMonth", notes = "根据ID加载BigdataFenxiCarMonth")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	/**
	 * 初始化安全评分
	 * @return
	 */
	@RequestMapping(value = "/selectAnQuanPingFen",method = RequestMethod.POST)
	public ModelAndView  selectAnQuanPingFen(String carType,String xianQuId,Integer timeCount,
											 String timeChangeAge,String timeChangeWeek,String timeType){
		//1.天  -- 对应县区  对应车辆类型  统计时间类型 20190909 DAY   ->list  升序(后十名) 降序(前十名)
		//2.周  -- 对应县区  对应车辆类型  统计时间类型 第几周   WEEK   ->list   升序(后十名) 降序(前十名)
		//3.月  -- 对应县区  对应车辆类型  统计时间类型 201909   MONTH  ->list  升序(后十名) 降序(前十名)
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> map = new HashMap<>();
		//前十
		List<BigdataFenxiCarMonth> listQianShi = service.selectByMonthQianShi(carType,xianQuId,timeCount,timeType);
		//后十
		List<BigdataFenxiCarMonth> listHouShi = service.selectByMonthHouShi(carType,xianQuId,timeCount,timeType);
		List<String> carNumQianShiList = new ArrayList<>();
		List<BigDecimal> scoreQianShiList = new ArrayList<>();
		List<String> carNumHouShiList = new ArrayList<>();
		List<BigDecimal> scoreHouShiList = new ArrayList<>();
		for(BigdataFenxiCarMonth bigdataFenxiCarMonth : listQianShi){
			carNumQianShiList.add(bigdataFenxiCarMonth.getCarPlateNum());
			scoreQianShiList.add(bigdataFenxiCarMonth.getSafeScore());
		}
		for(BigdataFenxiCarMonth bigdataFenxiCarMonth : listHouShi){
			carNumHouShiList.add(bigdataFenxiCarMonth.getCarPlateNum());
			scoreHouShiList.add(bigdataFenxiCarMonth.getSafeScore());
		}

		map.put("carNumQianShiList",carNumQianShiList);
		map.put("scoreQianShiList",scoreQianShiList);
		map.put("carNumHouShiList",carNumHouShiList);
		map.put("scoreHouShiList",scoreHouShiList);

		return buildResponse(modelAndView, map);
	}

	/**
	 * 根据企业查询里程前10的车辆
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/selectTopTenRunMileageByTeamId",method = RequestMethod.POST)
	public ModelAndView selectTopTenRunMileageByTeamId(@ModelAttribute BigdataFenxiCarMonthQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<BigdataFenxiCarMonth> fenxiCarWeekList = service.selectTopTenRunMileageByTeamId(query);
		return buildResponse(modelAndView,fenxiCarWeekList);
	}

	/**
	 * 根据企业查询报警数前10的车辆
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/selectTopTenAlarmNumByTeamId",method = RequestMethod.POST)
	public ModelAndView selectTopTenAlarmNumByTeamId(@ModelAttribute BigdataFenxiCarMonthQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<BigdataFenxiCarMonth> fenxiCarWeekList = service.selectTopTenAlarmNumByTeamId(query);
		return buildResponse(modelAndView,fenxiCarWeekList);
	}

	/**
	 * 查询企业和车辆的月份统计信息
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/selectCarAndTeamMonth",method = RequestMethod.POST)
	public ModelAndView selectCarAndTeamMonth(@ModelAttribute BigdataFenxiCarMonthQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> returnMap = new HashMap<>();
		BigdataFenxiCarMonth fenxiCarMonth = service.selectById(query);
		returnMap.put("carMonth",fenxiCarMonth);
		if(fenxiCarMonth != null){
			BigdataFenxiTeamMonthQuery teamMonthQuery = new BigdataFenxiTeamMonthQuery();
			teamMonthQuery.getQueryObj().setTeamId(fenxiCarMonth.getOwnerTeamId());
			teamMonthQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
			teamMonthQuery.getQueryObj().setCountMonth(query.getQueryObj().getCountMonth());
			BigdataFenxiTeamMonth teamMonth = teamMonthService.selectByTeamId(teamMonthQuery);
			returnMap.put("teamMonth",teamMonth);
		}
		return buildResponse(modelAndView,returnMap);
	}

	@RequestMapping(value = "/selectCarTeamDayByCarMonth",method = RequestMethod.POST)
	public ModelAndView selectCarTeamDayByCarMonth(@ModelAttribute BigdataFenxiCarMonthQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> returnMap = new HashMap<>();
		//车辆每天数据分析查询参数
		BigdataTimeCarDayRecQuery dayRecQuery = new BigdataTimeCarDayRecQuery();
		dayRecQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
		dayRecQuery.getQueryObj().setCountMonth(query.getQueryObj().getCountMonth());
		String carFrameNum = query.getQueryObj().getCarFrameNum();
		dayRecQuery.getQueryObj().setCarFrameNum(carFrameNum);
		//企业每天数据分析查询参数
		BigdataFenxiTeamDayQuery teamDayQuery = new BigdataFenxiTeamDayQuery();
		teamDayQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
		teamDayQuery.getQueryObj().setCountMonth(query.getQueryObj().getCountMonth());
		String ownerTeamId = query.getQueryObj().getOwnerTeamId();
		teamDayQuery.getQueryObj().setTeamId(query.getQueryObj().getOwnerTeamId());

		List<BigdataTimeCarDayRec> carDayRecList = new ArrayList<>();
		List<BigdataFenxiTeamDay> teamDayList = new ArrayList<>();

		List<Integer> countDateList = getCountDateByCountMonth(query.getQueryObj().getCountMonth(),query.getQueryObj().getYearNum());
		for(int i=0;i<countDateList.size();i++){
			//查询车辆每天的信息
			dayRecQuery.getQueryObj().setCountDate(countDateList.get(i));
			BigdataTimeCarDayRec carDayRec = carDayRecService.selectByCarFrameNumAndCountDate(dayRecQuery);
			if(carDayRec == null){
				carDayRec = new BigdataTimeCarDayRec();
				carDayRec.setSumMileage(new BigDecimal(0));
				carDayRec.setSumDuration(new BigDecimal(0));
				carDayRec.setAlarmNum(0);
			}else{
				BigDecimal sumDuration = carDayRec.getSumDuration();
				if(sumDuration.compareTo(BigDecimal.ZERO) != 0){
					BigDecimal sumDurationNew = sumDuration.divide(new BigDecimal(60),2, RoundingMode.HALF_UP);
					carDayRec.setSumDuration(sumDurationNew);
				}
			}
			carDayRecList.add(carDayRec);
			//查询企业每天的信息
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
		returnMap.put("carDayRecList",carDayRecList);
		//返回企业每天的数据
		returnMap.put("teamDayRecList",teamDayList);
		return buildResponse(modelAndView,returnMap);
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
			for(int i=1;i<nowDate;i++){
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

}
