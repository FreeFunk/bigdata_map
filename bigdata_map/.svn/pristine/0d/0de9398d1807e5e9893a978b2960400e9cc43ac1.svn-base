package com.edgedo.bigdata.controller;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamDayQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecQuery;
import com.edgedo.bigdata.service.BigdataFenxiTeamDayService;
import com.edgedo.bigdata.service.BigdataFenxiTeamWeekService;
import com.edgedo.bigdata.service.BigdataTimeCarDayRecService;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarWeekQuery;
import com.edgedo.bigdata.service.BigdataFenxiCarWeekService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataFenxiCarWeek")
@Controller
@RequestMapping("/admin/bigdataFenxiCarWeek")
public class BigdataFenxiCarWeekController extends BaseController{

	@Autowired
	private BigdataFenxiCarWeekService service;
	@Autowired
	private BigdataFenxiTeamWeekService teamWeekService;
	@Autowired
	private BigdataTimeCarDayRecService carDayRecService;
	@Autowired
	private BigdataFenxiTeamDayService teamDayService;

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataFenxiCarWeek", notes = "分页查询BigdataFenxiCarWeek")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataFenxiCarWeekQuery query){
		ModelAndView modelAndView = new ModelAndView();
		query.getQueryObj().setOwnerTeamName(query.getQueryObj().getCarPlateNum());
		String weekCountStr = query.getQueryObj().getWeekCountStr();
		if(weekCountStr != null && !weekCountStr.equals("")){
			String[] weekCountArr = weekCountStr.split("@@");
			query.getQueryObj().setCountWeek(Integer.parseInt(weekCountArr[0]));
			query.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
		}
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}


	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改BigdataFenxiCarWeek", notes = "新增修改BigdataFenxiCarWeek")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataFenxiCarWeek voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataFenxiCarWeek", notes = "根据ID批量删除BigdataFenxiCarWeek")
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
	@ApiOperation(value = "根据ID加载BigdataFenxiCarWeek", notes = "根据ID加载BigdataFenxiCarWeek")
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
	public ModelAndView  selectAnQuanPingFen(String carType,String xianQuId,
											 Integer timeChangeAge,String timeChangeWeek,Integer countMonth,String time,String timeType){
		//2.周  -- 对应县区  对应车辆类型  统计时间类型 第几周 年份 WEEK   ->list   升序(后十名) 降序(前十名)
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> map = new HashMap<>();
		if(timeChangeWeek.indexOf("@@")==-1){//当前周  第37周 20190912-20190913
			String[] timeArr = time.split("-");
			String[] startTime = timeArr[0].split("");//开始时间2 0 1 9 0 9 1 2
			String[] endTime = timeArr[1].split("");//结束时间 2 0 1 9 0 9 1 3
			if((startTime[0]+startTime[1]+startTime[2]+startTime[3]+startTime[4]+startTime[5]).equals
					(endTime[0]+endTime[1]+endTime[2]+endTime[3]+endTime[4]+endTime[5])){//当月  不存在跨度
				List<BigdataFenxiCarWeek> listQianShi = service.selectByWeekQianShi(carType,xianQuId,timeChangeAge,new Integer(timeChangeWeek),countMonth);
				List<BigdataFenxiCarWeek> listHouShi = service.selectByWeekHouShi(carType,xianQuId,timeChangeAge,new Integer(timeChangeWeek),countMonth);
				List<String> carNumQianShiList = new ArrayList<>();
				List<BigDecimal> scoreQianShiList = new ArrayList<>();
				List<String> carNumHouShiList = new ArrayList<>();
				List<BigDecimal> scoreHouShiList = new ArrayList<>();
				for(BigdataFenxiCarWeek bigdataFenxiCarWeek : listQianShi){
					carNumQianShiList.add(bigdataFenxiCarWeek.getCarPlateNum());
					scoreQianShiList.add(bigdataFenxiCarWeek.getSafeScore());
				}
				for(BigdataFenxiCarWeek bigdataFenxiCarWeek : listHouShi){
					carNumHouShiList.add(bigdataFenxiCarWeek.getCarPlateNum());
					scoreHouShiList.add(bigdataFenxiCarWeek.getSafeScore());
				}
				map.put("carNumQianShiList",carNumQianShiList);
				map.put("scoreQianShiList",scoreQianShiList);
				map.put("carNumHouShiList",carNumHouShiList);
				map.put("scoreHouShiList",scoreHouShiList);
				return buildResponse(modelAndView, map);
			}else {//跨月
				//1.carType车辆类型  xianQuId县区 timeChangeAge统计年份2019  time"20190909-20190912" timeChangeWeek
				String startDate = startTime[0]+startTime[1]+startTime[2]+startTime[3]+startTime[4]+startTime[5];//201908
				String endDate = endTime[0]+endTime[1]+endTime[2]+endTime[3]+endTime[4]+endTime[5];//201909
				//分两张表查询
				List<BigdataFenxiCarWeek> listQianShiStartDate = service.selectByWeekQianShi(carType,xianQuId,timeChangeAge,new Integer(timeChangeWeek),new Integer(startDate));
				List<BigdataFenxiCarWeek> listHouShiStartDate = service.selectByWeekHouShi(carType,xianQuId,timeChangeAge,new Integer(timeChangeWeek),new Integer(startDate));

				List<BigdataFenxiCarWeek> listQianShiEndDate = service.selectByWeekQianShi(carType,xianQuId,timeChangeAge,new Integer(timeChangeWeek),new Integer(endDate));
				List<BigdataFenxiCarWeek> listHouShiEndDate = service.selectByWeekHouShi(carType,xianQuId,timeChangeAge,new Integer(timeChangeWeek),new Integer(endDate));

				//合并集合
				listQianShiStartDate.addAll(listQianShiEndDate);
				listHouShiStartDate.addAll(listHouShiEndDate);
				//前十
				Collections.sort(listQianShiStartDate, new Comparator<BigdataFenxiCarWeek>(){
					/*
					 * int compare(BigdataFenxiCarWeek p1, BigdataFenxiCarWeek p2) 返回一个基本类型的整型，
					 * 返回负数表示：p1 小于p2，
					 * 返回0 表示：p1和p2相等，
					 * 返回正数表示：p1大于p2
					 */
					@Override
					public int compare(BigdataFenxiCarWeek o1, BigdataFenxiCarWeek o2) {
						//按照Person的年龄进行升序排列
						if (o1.getSafeScore().compareTo(o2.getSafeScore()) == -1) {//o1小于o2
							return 1;
						}
						if (o1.getSafeScore().compareTo(o2.getSafeScore()) == 0) {//==
							return 0;
						}
						return -1;
					}
				});

				//后十取后十个
				Collections.sort(listHouShiStartDate, new Comparator<BigdataFenxiCarWeek>(){
					/*
					 * int compare(BigdataFenxiCarWeek p1, BigdataFenxiCarWeek p2) 返回一个基本类型的整型，
					 * 返回负数表示：p1 小于p2，
					 * 返回0 表示：p1和p2相等，
					 * 返回正数表示：p1大于p2
					 */
					@Override
					public int compare(BigdataFenxiCarWeek o1, BigdataFenxiCarWeek o2) {
						//按照Person的年龄进行升序排列
						if(o1.getSafeScore().compareTo(o2.getSafeScore())==-1){//o1小于o2
							return 1;
						}
						if(o1.getSafeScore().compareTo(o2.getSafeScore())==0){//==
							return 0;
						}
						return -1;
					}
				});
				//倒序
				Collections.reverse(listHouShiStartDate);

				//存入map
				List<String> carNumQianShiList = new ArrayList<>();
				List<BigDecimal> scoreQianShiList = new ArrayList<>();
				List<String> carNumHouShiList = new ArrayList<>();
				List<BigDecimal> scoreHouShiList = new ArrayList<>();
				for(int i = 0;i<9;i++){
					carNumQianShiList.add(listQianShiStartDate.get(i).getCarPlateNum());
					scoreQianShiList.add(listQianShiStartDate.get(i).getSafeScore());
				}
				for(int i = 0;i<9;i++){
					carNumHouShiList.add(listHouShiStartDate.get(i).getCarPlateNum());
					scoreHouShiList.add(listHouShiStartDate.get(i).getSafeScore());
				}

				map.put("carNumQianShiList",carNumQianShiList);
				map.put("scoreQianShiList",scoreQianShiList);
				map.put("carNumHouShiList",carNumHouShiList);
				map.put("scoreHouShiList",scoreHouShiList);
				return buildResponse(modelAndView, map);
			}

		}else {//第37周@@20190912-20190912
			String[] str = timeChangeWeek.split("@@");
			String[] str1 = str[0].split("");
			String[] timeArr = str[1].split("-");
			String[] startTime = timeArr[0].split("");//开始时间2 0 1 9 0 9 1 2
			String[] endTime = timeArr[1].split("");//结束时间 2 0 1 9 0 9 1 3
			if((startTime[0]+startTime[1]+startTime[2]+startTime[3]+startTime[4]+startTime[5]).equals
					(endTime[0]+endTime[1]+endTime[2]+endTime[3]+endTime[4]+endTime[5])){//不存在跨度
				List<BigdataFenxiCarWeek> listQianShi = service.selectByWeekQianShi(carType,xianQuId,timeChangeAge,new Integer(str1[1]+str1[2]),countMonth);
				List<BigdataFenxiCarWeek> listHouShi = service.selectByWeekHouShi(carType,xianQuId,timeChangeAge,new Integer(str1[1]+str1[2]),countMonth);
				List<String> carNumQianShiList = new ArrayList<>();
				List<BigDecimal> scoreQianShiList = new ArrayList<>();
				List<String> carNumHouShiList = new ArrayList<>();
				List<BigDecimal> scoreHouShiList = new ArrayList<>();
				for(BigdataFenxiCarWeek bigdataFenxiCarWeek : listQianShi){
					carNumQianShiList.add(bigdataFenxiCarWeek.getCarPlateNum());
					scoreQianShiList.add(bigdataFenxiCarWeek.getSafeScore());
				}
				for(BigdataFenxiCarWeek bigdataFenxiCarWeek : listHouShi){
					carNumHouShiList.add(bigdataFenxiCarWeek.getCarPlateNum());
					scoreHouShiList.add(bigdataFenxiCarWeek.getSafeScore());
				}

				map.put("carNumQianShiList",carNumQianShiList);
				map.put("scoreQianShiList",scoreQianShiList);
				map.put("carNumHouShiList",carNumHouShiList);
				map.put("scoreHouShiList",scoreHouShiList);
				return buildResponse(modelAndView, map);
			}else {//存在跨度
				//1.carType车辆类型  xianQuId县区 timeChangeAge统计年份2019  time"20190909-20190912" timeChangeWeek
				String startDate = startTime[0]+startTime[1]+startTime[2]+startTime[3]+startTime[4]+startTime[5];//201908
				String endDate = endTime[0]+endTime[1]+endTime[2]+endTime[3]+endTime[4]+endTime[5];//201909
				//分两张表查询
				List<BigdataFenxiCarWeek> listQianShiStartDate = service.selectByWeekQianShi(carType,xianQuId,timeChangeAge,new Integer(str1[1]+str1[2]),new Integer(startDate));
				List<BigdataFenxiCarWeek> listHouShiStartDate = service.selectByWeekHouShi(carType,xianQuId,timeChangeAge,new Integer(str1[1]+str1[2]),new Integer(startDate));

				List<BigdataFenxiCarWeek> listQianShiEndDate = service.selectByWeekQianShi(carType,xianQuId,timeChangeAge,new Integer(str1[1]+str1[2]),new Integer(endDate));
				List<BigdataFenxiCarWeek> listHouShiEndDate = service.selectByWeekHouShi(carType,xianQuId,timeChangeAge,new Integer(str1[1]+str1[2]),new Integer(endDate));

				//合并集合
				listQianShiStartDate.addAll(listQianShiEndDate);
				listHouShiStartDate.addAll(listHouShiEndDate);
				//前十取前十个
				Collections.sort(listQianShiStartDate, new Comparator<BigdataFenxiCarWeek>(){
					/*
					 * int compare(BigdataFenxiCarWeek p1, BigdataFenxiCarWeek p2) 返回一个基本类型的整型，
					 * 返回负数表示：p1 小于p2，
					 * 返回0 表示：p1和p2相等，
					 * 返回正数表示：p1大于p2
					 */
					@Override
					public int compare(BigdataFenxiCarWeek o1, BigdataFenxiCarWeek o2) {
						//按照Person的年龄进行升序排列
						if(o1.getSafeScore().compareTo(o2.getSafeScore())==-1){//o1小于o2
							return 1;
						}
						if(o1.getSafeScore().compareTo(o2.getSafeScore())==0){//==
							return 0;
						}
						return -1;
					}
				});

				//后十取后十个
				Collections.sort(listHouShiStartDate, new Comparator<BigdataFenxiCarWeek>(){
					/*
					 * int compare(BigdataFenxiCarWeek p1, BigdataFenxiCarWeek p2) 返回一个基本类型的整型，
					 * 返回负数表示：p1 小于p2，
					 * 返回0 表示：p1和p2相等，
					 * 返回正数表示：p1大于p2
					 */
					@Override
					public int compare(BigdataFenxiCarWeek o1, BigdataFenxiCarWeek o2) {
						//按照Person的年龄进行升序排列
						if(o1.getSafeScore().compareTo(o2.getSafeScore())==-1){//o1小于o2
							return 1;
						}
						if(o1.getSafeScore().compareTo(o2.getSafeScore())==0){//==
							return 0;
						}
						return -1;
					}
				});
				//倒序
				Collections.reverse(listHouShiStartDate);

				//存入map
				List<String> carNumQianShiList = new ArrayList<>();
				List<BigDecimal> scoreQianShiList = new ArrayList<>();
				List<String> carNumHouShiList = new ArrayList<>();
				List<BigDecimal> scoreHouShiList = new ArrayList<>();
				for(int i = 0;i<9;i++){
					carNumQianShiList.add(listQianShiStartDate.get(i).getCarPlateNum());
					scoreQianShiList.add(listQianShiStartDate.get(i).getSafeScore());
				}
				for(int i = 0;i<9;i++){
					carNumHouShiList.add(listHouShiStartDate.get(i).getCarPlateNum());
					scoreHouShiList.add(listHouShiStartDate.get(i).getSafeScore());
				}
				map.put("carNumQianShiList",carNumQianShiList);
				map.put("scoreQianShiList",scoreQianShiList);
				map.put("carNumHouShiList",carNumHouShiList);
				map.put("scoreHouShiList",scoreHouShiList);
				return buildResponse(modelAndView, map);
			}
		}

	}

	/**
	 * 根据企业查询里程前10的车辆
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/selectTopTenRunMileageByTeamId",method = RequestMethod.POST)
	public ModelAndView selectTopTenRunMileageByTeamId(@ModelAttribute BigdataFenxiCarWeekQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<BigdataFenxiCarWeek> fenxiCarWeekList = service.selectTopTenRunMileageByTeamId(query);
		return buildResponse(modelAndView,fenxiCarWeekList);
	}

	/**
	 * 根据企业查询报警数前10的车辆
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/selectTopTenAlarmNumByTeamId",method = RequestMethod.POST)
	public ModelAndView selectTopTenAlarmNumByTeamId(@ModelAttribute BigdataFenxiCarWeekQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<BigdataFenxiCarWeek> fenxiCarWeekList = service.selectTopTenAlarmNumByTeamId(query);
		return buildResponse(modelAndView,fenxiCarWeekList);
	}

	/**
	 * 根据id获取整条记录
	 * @return
	 */
	@RequestMapping(value = "/selectCarWeekAndTeamWeek",method = RequestMethod.POST)
	public ModelAndView selectCarWeekAndTeamWeek(@ModelAttribute BigdataFenxiCarWeekQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> returnMap = new HashMap<>();
		String weekCountStr = query.getQueryObj().getWeekCountStr();
		//企业周统计数据
		BigdataFenxiTeamWeekQuery teamWeekQuery = new BigdataFenxiTeamWeekQuery();
		teamWeekQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
		if(weekCountStr != null && !weekCountStr.equals("")){
			String[] weekCountArr = weekCountStr.split("@@");
			query.getQueryObj().setCountWeek(Integer.parseInt(weekCountArr[0]));
			query.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
			teamWeekQuery.getQueryObj().setCountWeek(Integer.parseInt(weekCountArr[0]));
			teamWeekQuery.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
		}
		//车辆周统计数据
		BigdataFenxiCarWeek carWeek = service.selectById(query);
		teamWeekQuery.getQueryObj().setTeamId(carWeek.getOwnerTeamId());
		BigdataFenxiTeamWeek teamWeek = teamWeekService.selectByTeamId(teamWeekQuery);
		returnMap.put("carWeek",carWeek);
		returnMap.put("teamWeek",teamWeek);
		return buildResponse(modelAndView,returnMap);
	}

	@RequestMapping(value = "/selectCarTeamDayByCarWeek",method = RequestMethod.POST)
	public ModelAndView selectCarTeamDayByCarWeek(@ModelAttribute BigdataFenxiCarWeekQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> returnMap = new HashMap<>();
		//车辆每天数据分析查询参数
		BigdataTimeCarDayRecQuery dayRecQuery = new BigdataTimeCarDayRecQuery();
		dayRecQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());
		//企业每天数据分析查询参数
		BigdataFenxiTeamDayQuery teamDayQuery = new BigdataFenxiTeamDayQuery();
		teamDayQuery.getQueryObj().setYearNum(query.getQueryObj().getYearNum());

		String weekCountStr = query.getQueryObj().getWeekCountStr();
		if(weekCountStr != null && !weekCountStr.equals("")){
			String[] weekCountArr = weekCountStr.split("@@");
			dayRecQuery.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
			teamDayQuery.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));

			Date countDateStart = query.getQueryObj().getStartCountDate();
			Date countDateEnd = query.getQueryObj().getEndCountDate();

			List<BigdataTimeCarDayRec> carDayRecList = new ArrayList<>();
			List<BigdataFenxiTeamDay> teamDayList = new ArrayList<>();

			List<Integer> countDateList = getCountDateList(countDateStart,countDateEnd);
			for(int i=0;i<countDateList.size();i++){
				//查询车辆每天的信息
				String carFrameNum = query.getQueryObj().getCarFrameNum();
				dayRecQuery.getQueryObj().setCarFrameNum(carFrameNum);
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
				teamDayQuery.getQueryObj().setTeamId(query.getQueryObj().getOwnerTeamId());
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
		}
		return buildResponse(modelAndView,returnMap);
	}

	//获取周每天的数据
	public List<Integer> getCountDateList(Date countDateStart,Date countDateEnd){
		List<Integer> countDateList = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(countDateStart);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int countEnd = Integer.parseInt(sdf.format(countDateEnd));
		int countNow = Integer.parseInt(sdf.format(new Date()));
		String countDateStr = sdf.format(countDateStart);
		int countDate = Integer.parseInt(countDateStr);
		while (countDate <= countEnd && countDate <countNow){
			countDateList.add(countDate);
			calendar.add(Calendar.DAY_OF_MONTH,1);
			countDateStart = calendar.getTime();
			countDateStr = sdf.format(countDateStart);
			countDate = Integer.parseInt(countDateStr);
		}
		return countDateList;
	}

}
