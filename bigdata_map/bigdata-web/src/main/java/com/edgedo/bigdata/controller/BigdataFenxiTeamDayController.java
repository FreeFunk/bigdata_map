package com.edgedo.bigdata.controller;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.edgedo.bigdata.entity.BigdataFenxiTeamMonth;
import com.edgedo.bigdata.entity.BigdataFenxiTeamWeek;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataFenxiTeamDay;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamDayQuery;
import com.edgedo.bigdata.service.BigdataFenxiTeamDayService;
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


@Api(tags = "BigdataFenxiTeamDay")
@Controller
@RequestMapping("/admin/bigdataFenxiTeamDay")
public class BigdataFenxiTeamDayController extends BaseController{
	
	@Autowired
	private BigdataFenxiTeamDayService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataFenxiTeamDay", notes = "分页查询BigdataFenxiTeamDay")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataFenxiTeamDayQuery query){
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
	@ApiOperation(value = "新增修改BigdataFenxiTeamDay", notes = "新增修改BigdataFenxiTeamDay")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataFenxiTeamDay voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataFenxiTeamDay", notes = "根据ID批量删除BigdataFenxiTeamDay")
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
	@ApiOperation(value = "根据ID加载BigdataFenxiTeamDay", notes = "根据ID加载BigdataFenxiTeamDay")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	@RequestMapping(value = "/selectQiYeBaoJingPaiMing",method = RequestMethod.POST)
	public ModelAndView  selectQiYeBaoJingPaiMing(String carType,String xianQuId,Integer timeCount,
												  Integer yearNum,Integer countMonth,String timeType){
		ModelAndView modelAndView = new ModelAndView();
		//1.企业类型 == 车辆类型
		//2.查询  carType  xianQuId timeCount yearNum  倒序(前十名)  升序(后十名)
		//安全评分前十
		List<BigdataFenxiTeamDay> listAnQuanQianShi = service.selectByDayAnQuanQianShi(carType,xianQuId,timeCount,yearNum,countMonth);
		//安全评分到十
		List<BigdataFenxiTeamDay> listAnQuanHouShi = service.selectByDayAnQuanHouShi(carType,xianQuId,timeCount,yearNum,countMonth);
		//报警数/百公里前十  越高越差
		List<BigdataFenxiTeamDay> listBaiGongLiHouShi = service.selectByDayBaiGongLiHouShi(carType,xianQuId,timeCount,yearNum,countMonth);

		//报警数/百公里后十
		List<BigdataFenxiTeamDay> listBaiGongLiQianShi = service.selectByDayBaiGongLiQianShi(carType,xianQuId,timeCount,yearNum,countMonth);
		//3.获取  企业名list  安全评分list  报警数/百公里list  5个list
		List<String> anQuanQianShiQiYeName = new ArrayList<>();//安全评分list前十企业名
		List<BigDecimal> anQuanQianShiQiYePingFen = new ArrayList<>();//安全评分list前十评分
		List<String> anQuanHouShiQiYeName = new ArrayList<>();//安全评分list后十企业名
		List<BigDecimal> anQuanHouShiQiYePingFen = new ArrayList<>();//安全评分list后十评分

		List<String> baiGongLiQianShiQiYeName = new ArrayList<>();//报警数/百公里list前十企业名
		List<BigDecimal> baiGongLiQianShiQiYePingFen = new ArrayList<>();//报警数/百公里list前十评分
		List<String> baiGongLiHouShiQiYeName = new ArrayList<>();//报警数/百公里list后十企业名
		List<BigDecimal> baiGongLiHouShiQiYePingFen = new ArrayList<>();//报警数/百公里list后十评分

		//前十
		for(BigdataFenxiTeamDay bigdataFenxiTeamDay : listAnQuanQianShi){
			anQuanQianShiQiYeName.add(bigdataFenxiTeamDay.getTeamName());
			anQuanQianShiQiYePingFen.add(bigdataFenxiTeamDay.getSafeScore());
		}
		//后十
		for(BigdataFenxiTeamDay bigdataFenxiTeamDay : listAnQuanHouShi){
			anQuanHouShiQiYeName.add(bigdataFenxiTeamDay.getTeamName());
			anQuanHouShiQiYePingFen.add(bigdataFenxiTeamDay.getSafeScore());
		}

		//前十
		for(BigdataFenxiTeamDay bigdataFenxiTeamDay : listBaiGongLiQianShi){
			baiGongLiQianShiQiYeName.add(bigdataFenxiTeamDay.getTeamName());
			baiGongLiQianShiQiYePingFen.add(bigdataFenxiTeamDay.getAlarmRate());
		}
		//后十
		for(BigdataFenxiTeamDay bigdataFenxiTeamDay : listBaiGongLiHouShi){
			baiGongLiHouShiQiYeName.add(bigdataFenxiTeamDay.getTeamName());
			baiGongLiHouShiQiYePingFen.add(bigdataFenxiTeamDay.getAlarmRate());
		}

		Map<String,Object> map = new HashMap<>();
		map.put("anQuanQianShiQiYeName",anQuanQianShiQiYeName);
		map.put("anQuanQianShiQiYePingFen",anQuanQianShiQiYePingFen);
		map.put("anQuanHouShiQiYeName",anQuanHouShiQiYeName);
		map.put("anQuanHouShiQiYePingFen",anQuanHouShiQiYePingFen);
		map.put("baiGongLiQianShiQiYeName",baiGongLiQianShiQiYeName);
		map.put("baiGongLiQianShiQiYePingFen",baiGongLiQianShiQiYePingFen);
		map.put("baiGongLiHouShiQiYeName",baiGongLiHouShiQiYeName);
		map.put("baiGongLiHouShiQiYePingFen",baiGongLiHouShiQiYePingFen);

		return buildResponse(modelAndView,map);
	}

	/**
	 * 根据时间查询企业日数据
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/selectListForChart",method = RequestMethod.POST)
	public ModelAndView selectListForChart(@ModelAttribute BigdataFenxiTeamDayQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<BigdataFenxiTeamDay> teamDayList = new ArrayList<>();
		String searchType = query.getQueryObj().getSearchType();
		List<Integer> countDateList = null;
		if(searchType != null && searchType.equals("week")){
			countDateList = getCountDateList(query.getQueryObj().getCountDateStart(),query.getQueryObj().getCountDateEnd());
		}else{
			countDateList = getCountDateByCountMonth(query.getQueryObj().getCountMonth(),query.getQueryObj().getYearNum());
		}
		if(countDateList.size() > 0){
			for(int i=0;i<countDateList.size();i++){
				query.getQueryObj().setCountDate(countDateList.get(i));
				BigdataFenxiTeamDay teamDay = service.selectByIdAndCountDate(query);
				if(teamDay == null){
					teamDay = new BigdataFenxiTeamDay();
					teamDay.setCountDate(countDateList.get(i));
					teamDay.setAlarmNum(0);
					teamDay.setRunMileage(new BigDecimal(0));
					teamDay.setRunTimeLength(0);
				}
				teamDayList.add(teamDay);
			}
		}
		return buildResponse(modelAndView,teamDayList);
	}

	//获取周每天的数据
	public List<Integer> getCountDateList(Date countDateStart, Date countDateEnd){
		List<Integer> countDateList = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//判断一下是否超过了当前的日期
		int countNow = Integer.parseInt(sdf.format(new Date()));
		calendar.setTime(countDateStart);
		int countEnd = Integer.parseInt(sdf.format(countDateEnd));
		String countDateStr = sdf.format(countDateStart);
		int countDate = Integer.parseInt(countDateStr);
		while (countDate <= countEnd && countDate<countNow){
			countDateList.add(countDate);
			calendar.add(Calendar.DAY_OF_MONTH,1);
			countDateStart = calendar.getTime();
			countDateStr = sdf.format(countDateStart);
			countDate = Integer.parseInt(countDateStr);
		}
		return countDateList;
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
