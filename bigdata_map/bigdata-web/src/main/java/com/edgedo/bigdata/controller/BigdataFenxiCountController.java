package com.edgedo.bigdata.controller;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataFenxiCount;
import com.edgedo.bigdata.queryvo.BigdataFenxiCountQuery;
import com.edgedo.bigdata.service.BigdataFenxiCountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataFenxiCount")
@Controller
@RequestMapping("/admin/bigdataFenxiCount")
public class BigdataFenxiCountController extends BaseController{
	
	@Autowired
	private BigdataFenxiCountService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataFenxiCount", notes = "分页查询BigdataFenxiCount")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataFenxiCountQuery query){
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
	@ApiOperation(value = "新增修改BigdataFenxiCount", notes = "新增修改BigdataFenxiCount")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataFenxiCount voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataFenxiCount", notes = "根据ID批量删除BigdataFenxiCount")
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
	@ApiOperation(value = "根据ID加载BigdataFenxiCount", notes = "根据ID加载BigdataFenxiCount")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	/**
	 * 折线图  信息  周或月
	 * @return
	 */
	@RequestMapping(value = "/selectBaoJingWeekAndMonth",method = RequestMethod.POST)
	public ModelAndView  selectBaoJingWeekAndMonth(String carType,String xianQuId,Integer timeCount,
												   Integer timeChangeAge,String timeChangeWeek,String timeWeek,String timeType){
		ModelAndView modelAndView = new ModelAndView();
		if(timeType.equals("WEEK")){
			timeType = "DAY";
			Map<String,Object> map = getMap(carType,xianQuId,timeCount,timeChangeAge,timeChangeWeek,timeWeek,timeType);
			//2.全部的数量将对应的时间段  进行相加
			return buildResponse(modelAndView,map);
		}else{
			Map<String,Object> map = new HashMap<>();
			//存放一周时间的list
			List<Integer> quanBuBaoJinList = new ArrayList<>();
			List<Integer> quanBuLChuLiist = new ArrayList<>();
			List<Integer> changGuiBaoJinList = new ArrayList<>();
			List<Integer> changGuiChuLiList = new ArrayList<>();
			List<Integer> zhuDongBaoJinList = new ArrayList<>();
			List<Integer> zhuDongChuLiList = new ArrayList<>();
			List<String> timeList = new ArrayList<>();
			//1.查询所有月的常规报警数量 和 常规处理
			//timeCount 201909 MONTH  carType xianQuId
			String[] str = timeCount.toString().split("");
			String year = str[0]+str[1]+str[2]+str[3];//前台传过来的年份
			String month = str[4]+str[5];//前台传过来的月份
			String monthSelect = getMonth(new Integer(year),new Integer(month));
			String[] arr = monthSelect.split("-");
			Integer firstArr = new Integer(arr[0]);
			Integer lastArr = new Integer(arr[1]);
			timeType = "DAY";
			List<BigdataFenxiCount> list = service.selectByTimeMonth(firstArr,lastArr,carType,xianQuId,timeType);
			for(BigdataFenxiCount bigdataFenxiCount : list){
				quanBuBaoJinList.add(bigdataFenxiCount.getCommonAlarmNum()+bigdataFenxiCount.getSafeAlarmNum());//全部报警数量
				quanBuLChuLiist.add(bigdataFenxiCount.getCommonHandleNum()+bigdataFenxiCount.getSafeHandleNum());//全部处理数量
				changGuiBaoJinList.add(bigdataFenxiCount.getCommonAlarmNum());//常规报警数量
				changGuiChuLiList.add(bigdataFenxiCount.getCommonHandleNum());//常规处理数量
				zhuDongBaoJinList.add(bigdataFenxiCount.getSafeAlarmNum());//主动报警数量
				zhuDongChuLiList.add(bigdataFenxiCount.getSafeHandleNum());//主动处理数量
				String[] arr1 = bigdataFenxiCount.getCountDate().toString().split("");
				timeList.add(arr1[4]+arr1[5]+"-"+arr1[6]+arr1[7]);//设置该时间段有值 20190912
			}
			List weekList1 = getTimeStr1(arr[0],arr[1]);
			map.put("weekList1",weekList1);
			map.put("timeList",timeList);
			map.put("quanBuBaoJinList",quanBuBaoJinList);
			map.put("quanBuLChuLiist",quanBuLChuLiist);
			map.put("changGuiBaoJinList",changGuiBaoJinList);
			map.put("changGuiChuLiList",changGuiChuLiList);
			map.put("zhuDongBaoJinList",zhuDongBaoJinList);
			map.put("zhuDongChuLiList",zhuDongChuLiList);
			//2.全部的数量将对应的时间段  进行相加
			return buildResponse(modelAndView,map);
		}
	}

	public String getMonth(Integer year, Integer month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH,0);
		Date date = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = simpleDateFormat.format(date);
		String[] str = dateStr.split("-");

		return str[0]+str[1]+"01"+"-"+str[0]+str[1]+str[2];
	}


	/**
	 * 获取一个周的数据
	 * @param carType
	 * @param xianQuId
	 * @param timeCount
	 * @param timeChangeAge
	 * @param timeChangeWeek
	 * @param timeWeek
	 * @param timeType
	 * @return
	 */
	public Map<String,Object> getMap(String carType,String xianQuId,Integer timeCount,
									 Integer timeChangeAge,String timeChangeWeek,String timeWeek,String timeType){
		Map<String,Object> map = new HashMap<>();
		//存放一周时间的list
		List<Integer> quanBuBaoJinList = new ArrayList<>();
		List<Integer> quanBuLChuLiist = new ArrayList<>();
		List<Integer> changGuiBaoJinList = new ArrayList<>();
		List<Integer> changGuiChuLiList = new ArrayList<>();
		List<Integer> zhuDongBaoJinList = new ArrayList<>();
		List<Integer> zhuDongChuLiList = new ArrayList<>();
		List<String> timeList = new ArrayList<>();
		//1.查询所有周的常规报警数量 和 常规处理
		if(timeWeek!=null){//2019
			String[] arr = timeWeek.split("-");
			Integer currTime = new Integer(arr[1]);
			Integer bettTime = new Integer(arr[0]);
			List<BigdataFenxiCount> list = service.selectByTime(bettTime,currTime,carType,xianQuId,timeType);
			//7天记录  一天有3全部 常规  主动
			for(BigdataFenxiCount bigdataFenxiCount : list){

				quanBuBaoJinList.add(bigdataFenxiCount.getCommonAlarmNum()+bigdataFenxiCount.getSafeAlarmNum());//全部报警数量
				quanBuLChuLiist.add(bigdataFenxiCount.getCommonHandleNum()+bigdataFenxiCount.getSafeHandleNum());//全部处理数量
				changGuiBaoJinList.add(bigdataFenxiCount.getCommonAlarmNum());//常规报警数量
				changGuiChuLiList.add(bigdataFenxiCount.getCommonHandleNum());//常规处理数量
				zhuDongBaoJinList.add(bigdataFenxiCount.getSafeAlarmNum());//主动报警数量
				zhuDongChuLiList.add(bigdataFenxiCount.getSafeHandleNum());//主动处理数量
				String[] arr1 = bigdataFenxiCount.getCountDate().toString().split("");
				timeList.add(arr1[4]+arr1[5]+"-"+arr1[6]+arr1[7]);//设置该时间段有值 20190912
			}

			List weekList1 = getTimeStr1(arr[0],arr[1]);
			map.put("weekList1",weekList1);
			map.put("timeList",timeList);
			map.put("quanBuBaoJinList",quanBuBaoJinList);
			map.put("quanBuLChuLiist",quanBuLChuLiist);
			map.put("changGuiBaoJinList",changGuiBaoJinList);
			map.put("changGuiChuLiList",changGuiChuLiList);
			map.put("zhuDongBaoJinList",zhuDongBaoJinList);
			map.put("zhuDongChuLiList",zhuDongChuLiList);
			return map;
		}else {
			String[] arr = timeChangeWeek.split("@@");
			String[] arr1 = arr[1].split("-");
			Integer currTime = new Integer(arr1[1]);
			Integer bettTime = new Integer(arr1[0]);
			List<BigdataFenxiCount> list = service.selectByTime(bettTime,currTime,carType,xianQuId,timeType);
			//7天记录  一天有3全部 常规  主动
			for(BigdataFenxiCount bigdataFenxiCount : list){

				quanBuBaoJinList.add(bigdataFenxiCount.getCommonAlarmNum()+bigdataFenxiCount.getSafeAlarmNum());//全部报警数量
				quanBuLChuLiist.add(bigdataFenxiCount.getCommonHandleNum()+bigdataFenxiCount.getSafeHandleNum());//全部处理数量
				changGuiBaoJinList.add(bigdataFenxiCount.getCommonAlarmNum());//常规报警数量
				changGuiChuLiList.add(bigdataFenxiCount.getCommonHandleNum());//常规处理数量
				zhuDongBaoJinList.add(bigdataFenxiCount.getSafeAlarmNum());//主动报警数量
				zhuDongChuLiList.add(bigdataFenxiCount.getSafeHandleNum());//主动处理数量
				String[] arr2 = bigdataFenxiCount.getCountDate().toString().split("");
				timeList.add(arr2[4]+arr2[5]+"-"+arr2[6]+arr2[7]);//设置该时间段有值 20190912
			}
			List weekList1 = getTimeStr1(arr1[0],arr1[1]);
			map.put("weekList1",weekList1);
			map.put("timeList",timeList);
			map.put("quanBuBaoJinList",quanBuBaoJinList);
			map.put("quanBuLChuLiist",quanBuLChuLiist);
			map.put("changGuiBaoJinList",changGuiBaoJinList);
			map.put("changGuiChuLiList",changGuiChuLiList);
			map.put("zhuDongBaoJinList",zhuDongBaoJinList);
			map.put("zhuDongChuLiList",zhuDongChuLiList);
			return map;
		}
	}


	/**
	 * 设置初始值
	 * @param carType xianQuId timeCount
	 * @return
	 */
	@RequestMapping(value = "/setBaoJinInfo",method = RequestMethod.POST)
	public ModelAndView  setBaoJinInfo(String carType,String xianQuId,String timeCount){
		ModelAndView modelAndView = new ModelAndView();
		//切割字符串
		String[] timeCountArr = timeCount.split("-");
		Integer dateNum = new Integer(timeCountArr[0]+timeCountArr[1]);

		//当前时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateStr = simpleDateFormat.format(date);
		String[] dateStrArr = dateStr.split("-");
		Integer dateStrArrdateNum = new Integer(dateStrArr[0]+dateStrArr[1]+dateStrArr[2]);
		List list = getTimeStr(timeCount,dateStr);
		String timeType = "MONTH";
		BigdataFenxiCount bigdataFenxiCount = service.selectByCarTypeAndXianQuIdAndTimeCount(carType,xianQuId,dateNum,timeType);

		return buildResponse(modelAndView,bigdataFenxiCount);
	}

	public List<String> getTimeStr(String startTimeStr,String endTimeStr) {
		String[] startStr = startTimeStr.split("-");
		String[] endStr = endTimeStr.split("-");

		Calendar start = Calendar.getInstance();
		start.set(new Integer(startStr[0]),new Integer(startStr[1])-1 , new Integer(startStr[2]));
		Long startTIme = start.getTimeInMillis();

		Calendar end = Calendar.getInstance();
		end.set(new Integer(endStr[0]), new Integer(endStr[1])-1, new Integer(endStr[2]));
		Long endTime = end.getTimeInMillis();

		Long oneDay = 1000 * 60 * 60 * 24l;

		List<String> list = new ArrayList<>();
		Long time = startTIme;
		while (time <= endTime) {
			Date d = new Date(time);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			list.add(df.format(d));
			time += oneDay;
		}
		return list;
	}

	public List<String> getTimeStr1(String startTimeStr,String endTimeStr) {
		String[] startStr = startTimeStr.split("");
		String[] endStr = endTimeStr.split("");

		Calendar start = Calendar.getInstance();//20190912
		start.set(new Integer(startStr[0]+startStr[1]+startStr[2]+startStr[3]),new Integer(startStr[4]+startStr[5])-1 , new Integer(startStr[6]+startStr[7]));
		Long startTIme = start.getTimeInMillis();

		Calendar end = Calendar.getInstance();
		end.set(new Integer(endStr[0]+endStr[1]+endStr[2]+endStr[3]),new Integer(endStr[4]+endStr[5])-1 , new Integer(endStr[6]+endStr[7]));
		Long endTime = end.getTimeInMillis();

		Long oneDay = 1000 * 60 * 60 * 24l;

		List<String> list = new ArrayList<>();
		Long time = startTIme;
		while (time <= endTime) {
			Date d = new Date(time);
			DateFormat df = new SimpleDateFormat("MM-dd");
			list.add(df.format(d));
			time += oneDay;
		}
		return list;
	}

	/**
	 * 设置初始值
	 * @param carType xianQuId timeCount
	 * @return
	 */
	@RequestMapping(value = "/selectXianQu",method = RequestMethod.POST)
	public ModelAndView  selectXianQtring(String carType,String xianQuId,Integer timeCount,
										  String timeChangeAge,String timeChangeWeek,String timeType){
		ModelAndView modelAndView = new ModelAndView();
		BigdataFenxiCount bigdataFenxiCount = new BigdataFenxiCount();
		//进行判断 什么时间类型
		if(timeType.equals("DAY")){
			//前台的时间数据类型  20190919
			//查询改天的 所有的车辆信息
			bigdataFenxiCount = service.selectByDay(carType,xianQuId,timeCount,timeType);
		}else if (timeType.equals("MONTH")){
			bigdataFenxiCount = service.selectByMonth(carType,xianQuId,timeCount,timeType);
		}
		return buildResponse(modelAndView,bigdataFenxiCount);
	}


	/**
	 * 设置初始值
	 * @param carType xianQuId timeCount
	 * @return
	 */
	@RequestMapping(value = "/selectXianQuWeek",method = RequestMethod.POST)
	public ModelAndView  selectXianQuWeek(String carType,String xianQuId,
										  String timeChangeAge,String timeChangeWeek,String timeType){
		ModelAndView modelAndView = new ModelAndView();
		BigdataFenxiCount bigdataFenxiCount = new BigdataFenxiCount();
		//进行判断 什么时间类型
		if(timeChangeWeek.indexOf("@@")==-1){
			bigdataFenxiCount = service.selectByWeek(carType,xianQuId,timeChangeAge,new Integer(timeChangeWeek),timeType);
		}else {
			String[] str = timeChangeWeek.split("@@");
			String[] str1 = str[0].split("");
			bigdataFenxiCount = service.selectByWeek(carType,xianQuId,timeChangeAge,new Integer(str1[1]+str1[2]),timeType);
		}
		return buildResponse(modelAndView,bigdataFenxiCount);
	}
	
}
